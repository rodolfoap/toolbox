#include <iostream>
#include <exception>

class CanGoWrong{
public:
	CanGoWrong(){
		char *pMemory=new char[999999999999];
		delete [] pMemory;
	}
};

int main(){
	try{
		CanGoWrong wrong;
	} catch(std::bad_alloc &e){
		std::cerr << "[ERROR] " << e.what() << std::endl;
	}
	std::cerr << "[OK] Still running." << std::endl;
	return 0;
}
