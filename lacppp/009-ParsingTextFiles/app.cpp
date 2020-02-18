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

	std::fstream file2_temp;
	file2_temp.open("file.temp", std::ios::in);
	if(!file2_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }

	std::string line;
	getline(file2_temp, line);
	while(!file2_temp.eof()){ // or just: while(file2_temp){
		std::cerr<< line <<std::endl;
		size_t pos1=line.find(":");
		size_t pos2=line.find(":", pos1+1);
		std::cerr<<"Positn:"<<pos1<<":"<<pos2<<std::endl;

		std::string token1=line.substr(0, pos1);
		std::string token2=line.substr(pos1+1, pos2-(pos1+1));
		std::string token3=line.substr(pos2+1, sizeof(line)-(pos2+1));
		std::cerr<<"Token1:"<<token1<<std::endl;
		std::cerr<<"Token2:"<<token2<<std::endl;
		std::cerr<<"Token3:"<<token3<<std::endl<<std::endl;

		getline(file2_temp, line);
	}
	std::cerr<< "EOF" <<std::endl;

	file2_temp.close();
	return 0;
}
