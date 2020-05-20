#include <opencv2/opencv.hpp>
#include <iostream>
#include <vector>

// See https://stackoverflow.com/questions/35942095/opencv-strange-rotation-and-translation-matrices-from-decomposehomographymat
int main() {
	// set up a virtual camera
	float f=100, w=640, h=480;
	cv::Mat1f K=(cv::Mat1f(3, 3) <<
				   f, 0, w/2,
				   0, f, h/2,
				   0, 0,   1);

	// set transformation from 1st to 2nd camera (assume K is unchanged)
	cv::Mat1f rvecDeg = (cv::Mat1f(3, 1) << 45, 12, 66);
	cv::Mat1f t = (cv::Mat1f(3, 1) << 100, 200, 300);
	std::cout << "-------------------------------------------\n";
	std::cout << "Ground truth:\n";
	std::cout << "K = \n" << K << std::endl << std::endl;
	std::cout << "rvec = \n" << rvecDeg << std::endl << std::endl;
	std::cout << "t = \n" << t << std::endl << std::endl;

	// set up points on a plane
	std::vector<cv::Point3f> p3d{{0, 0, 10},
		{100, 0, 10},
		{0, 100, 10},
		{100, 100, 10}};

	// project on both cameras
	std::vector<cv::Point2f> Q, P, S;
	cv::projectPoints(p3d,
					  cv::Mat1d::zeros(3, 1),
					  cv::Mat1d::zeros(3, 1),
					  K,
					  cv::Mat(),
					  Q);
	cv::projectPoints(p3d,
					  rvecDeg*CV_PI/180,
					  t,
					  K,
					  cv::Mat(),
					  P);

	// find homography
	cv::Mat H = cv::findHomography(Q, P); // *********************
	std::cout << "-------------------------------------------\n";
	std::cout << "Estimated H = \n" << H << std::endl << std::endl;
	// check by reprojection
	std::vector<cv::Point2f> P_(P.size());
	cv::perspectiveTransform(Q, P_, H); // *********************
	float sumError = 0;
	for (size_t i = 0; i < P.size(); i++) {
		sumError += cv::norm(P[i] - P_[i]);
	}
	std::cout << "-------------------------------------------\n";
	std::cout << "Average reprojection error = " << sumError/P.size() << std::endl << std::endl;

	// decompose using identity as internal parameters matrix
	std::vector<cv::Mat> Rs, Ts;
	cv::decomposeHomographyMat(H,
							   K,
							   Rs, Ts,
							   cv::noArray());
	std::cout << "-------------------------------------------\n";
	std::cout << "Estimated decomposition:\n\n";
	std::cout << "rvec = " << std::endl;
	for (auto R_ : Rs) {
		cv::Mat1d rvec;
		cv::Rodrigues(R_, rvec);
		std::cout << rvec*180/CV_PI << std::endl << std::endl;
	}
	std::cout << std::endl;
	std::cout << "t = " << std::endl;
	for (auto t_ : Ts) {
		std::cout << t_ << std::endl << std::endl;
	}
	return 0;
}
