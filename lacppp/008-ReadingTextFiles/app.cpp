#include <iostream>
#include <fstream>

int main(){
	std::fstream file_temp;
	file_temp.open("file.temp", std::ios::out);
	if(!file_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }

	file_temp<<"This is the  first line."<<std::endl;
	file_temp<<"This is the second line."<<std::endl;
	file_temp<<"This is the  third line."<<std::endl;
	file_temp.close();

	std::fstream file2_temp;
	file2_temp.open("file.temp", std::ios::in);
	if(!file2_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }

	std::string line;
	getline(file2_temp, line);
	while(!file2_temp.eof()){ // or just: while(file2_temp){
		std::cerr<< line <<std::endl;
		getline(file2_temp, line);
	}
	std::cerr<< "EOF" <<std::endl;

	file2_temp.close();
	return 0;
}
