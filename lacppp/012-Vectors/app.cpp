#include <iostream>
#include <vector>

int main(){
	std::vector<std::string> data(2);	// 0 to 1
	data[1]="ABCD";				// 1 is changed
	data.push_back("000");			// 2 added
	data.push_back("001");			// 3 added
	data.push_back("002");			// 4 added; which doubles the size of the vector!
	for(int i=0; i<sizeof(data); i++){
		std::cerr<<i<<":"<<data[i]<<std::endl;
	}
	std::cerr<<"END:"<<data.end()<<std::endl;
	return 0;
}
