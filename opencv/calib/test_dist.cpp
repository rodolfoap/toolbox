#include <iostream>
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/calib3d/calib3d.hpp"
#include "opencv2/viz/vizcore.hpp"
#include "opencv2/video/tracking.hpp"
#define LOG std::cerr<<">>> "<<__FILE__<<"["<<__LINE__<<"]:"<<__func__<<"();"<<std::endl;

using namespace std;
using namespace cv;

string images_path="pic/";

int main(int argc, char* argv[]) {
	Mat intrinsic_matrix;
	Mat distortion_coeffs;
	Mat input=imread(argv[1], CV_LOAD_IMAGE_GRAYSCALE);
	FileStorage file("camera_matrix.yaml", cv::FileStorage::READ);
	file["intrinsic_matrix" ]>>intrinsic_matrix;
	file["distortion_coeffs"]>>distortion_coeffs;
	file.release();
	Mat image_undistorted;
	undistort(input,image_undistorted,intrinsic_matrix,distortion_coeffs);
	imshow("distortion_test",image_undistorted);
	moveWindow("distortion_test",1,1);
	waitKey();
	cvDestroyAllWindows();
	return 0;
}
