#include <iostream>
#include <exception>

void mightGoWrong(){
	bool error=true;
	if(error) throw std::logic_error("Throwing a std::logic_error()");
	if(error) throw std::string("Throwing a std::string()");
	if(error) throw "Throwing a char const *.";
	if(error) throw 8;
}

int main(){
	try{
		mightGoWrong();
	} catch(int e){
		std::cout << "[ERROR] " << e << std::endl;
	} catch(char const *e){
		std::cout << "[ERROR] " << e << std::endl;
	} catch(std::string &e){
		std::cout << "[ERROR] " << e << std::endl;
	} catch(std::exception &e){
		std::cout << "[ERROR] " << e.what() << std::endl;
	}

	std::cout << "Still running" << std::endl;

	return 0;
}
