#include <iostream>
#include <fstream>

#pragma pack(push, 1)
struct Data {
	std::string name;
};
#pragma pack(pop)

int main(){
	Data data;
	data.name="Test";
	std::cerr<<sizeof(data)<<std::endl;

	std::fstream file;
	file.open("data.temp", std::ios::binary|std::ios::out);
	if(file.is_open()){
		file.write((char *)&data, sizeof(data));
		file.close();
	}
	return 0;
}
