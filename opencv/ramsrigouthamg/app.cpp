#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/calib3d/calib3d.hpp"
#include <iostream>
#include <limits>
#include <numeric>
using namespace cv;
using namespace std;

// We need 4 corresponding 2D points(x, y)to calculate homography.
vector<Point2f> left_image;	// Stores 4 points(x, y)of the logo image. Here the four points are 4 corners of image.
vector<Point2f> right_image;	// stores 4 points that the user clicks(mouse left click)in the main image.

// Image containers for main and logo image
Mat imageMain;
Mat imageLogo;

// Function to add main image and transformed logo image and show final output.
// Icon image replaces the pixels of main image in this implementation.
void showFinal(Mat src1, Mat src2) {
	Mat gray, gray_inv, src1final, src2final;
	cvtColor(src2, gray, COLOR_BGR2GRAY);
	threshold(gray, gray, 0, 255, THRESH_BINARY);
	//adaptiveThreshold(gray, gray, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 5, 4);
	bitwise_not(gray, gray_inv);
	src1.copyTo(src1final, gray_inv);
	src2.copyTo(src2final, gray);
	Mat finalImage=src1final+src2final;
	namedWindow("output", WINDOW_AUTOSIZE);
	imshow("output", finalImage);
	waitKey(0);
}

// Here we get four points from the user with left mouse clicks.
// On 5th click we output the overlayed image.
void on_mouse(int e, int x, int y, int d, void *ptr) {
	if(e==EVENT_LBUTTONDOWN) {
		right_image.push_back(Point2f(float(x), float(y)));
		cout << x << " "<< y <<endl;
		if(right_image.size()==4) {
			cout << "Calculating homography... " <<endl;
			// Deactivate callback
			cv::setMouseCallback("Display window", NULL, NULL);
			// once we get 4 corresponding points in both images calculate homography matrix
			Mat H=findHomography(left_image, right_image, 0);
			Mat logoWarped;
			// Warp the logo image to change its perspective
			warpPerspective(imageLogo, logoWarped, H, imageMain.size());
			showFinal(imageMain, logoWarped);
		}
	}
}


int main(int argc, char** argv) {
	if(argc !=3) { cerr<<" Usage: "<<argv[0]<<"[background.jpg logo.jpg]"<<endl; return -1; }
	imageMain=imread(argv[1], IMREAD_COLOR);
	imageLogo=imread(argv[2], IMREAD_COLOR);
	// Push the 4 corners of the logo image as the 4 points for correspondence to calculate homography.
	left_image.push_back(Point2f(float(0), float(0)));
	left_image.push_back(Point2f(float(0), float(imageLogo.rows)));
	left_image.push_back(Point2f(float(imageLogo.cols), float(imageLogo.rows)));
	left_image.push_back(Point2f(float(imageLogo.cols), float(0)));
	namedWindow("Display window", WINDOW_AUTOSIZE);// Create a window for display.
	imshow("Display window", imageMain);
	setMouseCallback("Display window", on_mouse, NULL);
	cout << "Please select 4 points..." <<endl;
	// ESC to exit
	while(1) {
		int key=waitKey(10);
		if(key==27)break;
	}
	return 0;
}