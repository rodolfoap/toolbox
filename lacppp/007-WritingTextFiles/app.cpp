#include <iostream>
#include <fstream>

int main(){
	std::ofstream file_temp;
	file_temp.open("file.temp");
	if(!file_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }
	file_temp<<"some data"<<std::endl;
	file_temp.close();
	return 0;
}
