#include <iostream>
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/calib3d/calib3d.hpp"
#include "opencv2/viz/vizcore.hpp"
#include "opencv2/video/tracking.hpp"
#define LOG std::cerr<<">>> "<<__FILE__<<"["<<__LINE__<<"]:"<<__func__<<"();"<<std::endl;

using namespace std;
using namespace cv;

string images_path="pic/";

int main(int argc, char *argv[]) {
	Mat intrinsic_matrix, distortion_coeffs;
	vector<cv::Mat> tvecs, rvecs;
	Mat input=imread(argv[1], CV_LOAD_IMAGE_GRAYSCALE);
	FileStorage file("camera_matrix.yaml", cv::FileStorage::READ);
	file["intrinsic_matrix" ]>>intrinsic_matrix;
	file["distortion_coeffs"]>>distortion_coeffs;
	file["tvecs"]>>tvecs;
	file["rvecs"]>>rvecs;
	file.release();

	Mat test;
	input.copyTo(test);
	cvtColor(test,test,CV_GRAY2BGR);
	vector<Point3f> cube_points;
	cube_points.resize(4);
	cube_points[0]=Point3f(0,0,0);
	cube_points[1]=Point3f(120,0,0);
	cube_points[2]=Point3f(0,120,0);
	cube_points[3]=Point3f(0,0,-120);
	vector<Point2f> cube_image_points;
	projectPoints(cube_points,rvecs, tvecs,intrinsic_matrix,distortion_coeffs,cube_image_points);
	line(test,Point(cube_image_points[0].x,cube_image_points[0].y),Point(cube_image_points[1].x,cube_image_points[1].y),Scalar(0,0,255),9);
	line(test,Point(cube_image_points[0].x,cube_image_points[0].y),Point(cube_image_points[2].x,cube_image_points[2].y),Scalar(0,255,0),9);
	line(test,Point(cube_image_points[0].x,cube_image_points[0].y),Point(cube_image_points[3].x,cube_image_points[3].y),Scalar(255,0,0),9);
	imshow("calibration_test",test);
	moveWindow("calibration_test",1,1);
	waitKey();
	cvDestroyAllWindows();
	return 0;
}
