#include <iostream>

#pragma pack(push, 1)
struct Data {
	std::string name;
};
#pragma pack(pop)

int main(){
	Data data;
	data.name="Test";
	std::cerr<<sizeof(data)<<std::endl;
	return 0;
}
