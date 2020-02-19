#include <iostream>
#include <fstream>

#pragma pack(push, 1)
struct Data {
	// sizeof() rounds to 48 without #pragma
	// sizeof() rounds to 44 with    #pragma
	char name[32]; 	// 32
	double weight; 	//  8
	int age; 	//  4
	// std::string name; Of course, not. Such is a pointer to the heap, not a space on the stack.
};
#pragma pack(pop)

int main(){
	Data data = { "ABCDabcd", 77.44, 255 };
	std::cerr<<"sizeof(struct): "<<sizeof(Data)<<std::endl;

	/* Writing */
	std::fstream file;
	file.open("data.temp", std::ios::binary|std::ios::out);
	if(file.is_open()){

	// This will not work: write() expects a pointer to char[]
	//	file.write(&data, sizeof(data));

	// Fixed:
	//	file.write((char *)&data, sizeof(data));

	// Yet better:
		file.write(reinterpret_cast<char *>(&data), sizeof(Data));
		file.close();
	}

	/* Reading */
	Data datx;
	std::fstream filx;
	filx.open("data.temp", std::ios::binary|std::ios::in);
	if(filx.is_open()){
		filx.read(reinterpret_cast<char *>(&datx), sizeof(Data));
		std::cerr
			<<"["<<datx.name
			<<":"<<datx.weight
			<<":"<<datx.age
			<<"]"<<std::endl;
		filx.close();
	}
	return 0;
}
