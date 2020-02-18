#include <iostream>
#include <exception>

class Wrong{
public:
	Wrong(){
		char *pMemory=new char[999999999999];
		delete [] pMemory;
	}
};

int main(){
	try{
		Wrong wrong;
	} catch(std::bad_alloc &e){
		std::cerr << "[ERROR] " << e.what() << std::endl;
	}
	std::cerr << "[OK] Still running." << std::endl;
	return 0;
}
