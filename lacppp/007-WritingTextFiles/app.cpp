#include <iostream>
#include <fstream>

int main(){
	std::fstream file_temp;
	file_temp.open("file.temp", std::ios::out);
	if(!file_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }

	file_temp<<"Canada:82926953172:0.927"<<std::endl;
	file_temp<<"Brazil:92639402640:8.583"<<std::endl;
	file_temp<<"Turkey:64392820183:3.416"<<std::endl;
	file_temp.close();

	return 0;
}
