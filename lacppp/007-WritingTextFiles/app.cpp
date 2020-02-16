#include <iostream>
#include <fstream>

int main(){
	/* Method 1 */
	//std::ofstream file_temp;
	//file_temp.open("file.temp");

	/* Method 2 */
	std::fstream file_temp;
	file_temp.open("file.temp", std::ios::out);

	if(!file_temp.is_open()) { std::cerr<<"[ERR]"<<std::endl; return 1; }

	file_temp<<"some data"<<std::endl;
	file_temp.close();
	return 0;
}
