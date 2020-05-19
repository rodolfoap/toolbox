#include <iostream>
#include "opencv2/highgui/highgui.hpp"
#include "opencv2/calib3d/calib3d.hpp"
#include "opencv2/viz/vizcore.hpp"
#include "opencv2/video/tracking.hpp"
#define LOG std::cerr<<">>> "<<__FILE__<<"["<<__LINE__<<"]:"<<__func__<<"();"<<std::endl;

using namespace std;
using namespace cv;

string images_path="pic/";

cv::Mat takePicture() {
	VideoCapture cam(0);
	cv::Mat pic, gray;
	while (!cam.isOpened()) {
		std::cout << "Failed to make connection to cam" << std::endl;
		cam.open(0);
	}
	cam>>pic;
        cvtColor(pic, gray, CV_RGB2GRAY);
	return gray;
	//cv::waitKey(1000);
}
int main() {
	// Load images
	vector<cv::Mat> input;
	int iter=1;
	Mat image=imread(images_path+std::to_string(iter)+".jpg", CV_LOAD_IMAGE_GRAYSCALE);
	while(iter<10) {
		input.push_back(image);
		cerr<<"Loaded: "<<images_path+std::to_string(iter)+".jpg\n";
		iter++;
		image=imread(images_path+std::to_string(iter)+".jpg", CV_LOAD_IMAGE_GRAYSCALE);
	}
	int N=input.size();
	cerr<<"Size: "<<N<<"\n";
	// Chessboard Corners Detection
	Mat out;
	vector<Point2f> corners;
	vector<vector<Point2f> > image_points;
	Scalar color[5]= {Scalar(255,0,255),Scalar(255,180,0),Scalar(0,255,0),Scalar(0,255,255),Scalar(0,0,255)};
	for(int i=0; i<N; i++) {
		bool pattern_found=findChessboardCorners(input[i],Size(8,5),corners,CALIB_CB_ADAPTIVE_THRESH|CALIB_CB_NORMALIZE_IMAGE);
		if(pattern_found) {
			cvtColor(input[i],out,CV_GRAY2RGB);
			for(int j=0; j<5; j++)
				for(int i=0; i<8; i++) {
					circle(out,Point(corners[i+j*8].x,corners[i+j*8].y),6,color[j],3);
					if(i<7) line(out,Point(corners[i+j*8].x,corners[i+j*8].y),Point(corners[i+1+j*8].x,corners[i+1+j*8].y),color[j],3);
				}
		}
		image_points.push_back(corners);
		imshow("output",out);
		moveWindow("output",1,1);
		char key=waitKey();
		if(key==27)break;
	}
	N=image_points.size();
	// Camera Calibration
	Mat intrinsic_matrix;
	Mat distortion_coeffs;
	vector<vector<Point3f> > object_points;
	object_points.resize(N);
	for(int i=0; i<N; i++) {
		object_points[i].resize(40);
	}
	for(int k=0; k<N; k++) //N images
		for(int j=0; j<5; j++) //5 rows
			for(int i=0; i<8; i++) { //7 cols
				object_points[k][i+8*j].x=30*i;
				object_points[k][i+8*j].y=30*j;
				object_points[k][i+8*j].z=0;
			}
	vector<cv::Mat> rvecs;
	vector<cv::Mat> tvecs;
	double calibration_error=calibrateCamera(
			object_points, image_points,
			input[0].size(),intrinsic_matrix,
			distortion_coeffs, rvecs, tvecs);
	cout<<"calibration_error: "<<calibration_error<<endl;
	cout<<" intrinsic_matrix: "<<endl<<intrinsic_matrix<<endl;
	cout<<"distortion_coeffs: "<<endl<<distortion_coeffs<<endl;
	// Matrix storage
	FileStorage file("camera_matrix.yaml",cv::FileStorage::WRITE);
	file<<"intrinsic_matrix"<<intrinsic_matrix;
	file<<"distortion_coeffs"<<distortion_coeffs;
	file<<"tvecs"<<tvecs;
	file<<"rvecs"<<rvecs;
	file.release();
	cvDestroyAllWindows();
	return 0;
}
