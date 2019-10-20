#include <iostream>
#include <exception>

void mightGoWrong(){
	bool error=true;
	if(error) throw std::logic_error("This is ridiculous!");
	if(error) throw 8;
}

int main(){
	try{
		mightGoWrong();
	} catch(int e){
		std::cout << "[ERROR] " << e << std::endl;
	} catch(std::exception &e){
		std::cout << "[ERROR] " << e.what() << std::endl;
	}
	std::cout << "Still running" << std::endl;

	return 0;
}
