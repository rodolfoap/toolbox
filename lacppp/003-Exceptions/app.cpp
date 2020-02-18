#include <iostream>
#include <exception>

void wrong1(){ throw 8; }
void wrong2(){ throw "Throwing a char const *."; }
void wrong3(){ throw std::string("Throwing a std::string()"); }
void wrong4(){ throw std::logic_error("Throwing a std::logic_error()"); }

int main(){
	try{ wrong1(); } catch(int e) { std::cout << "[ERROR] " << e << std::endl; }
	std::cout << "Still running" << std::endl;

	try{ wrong2(); } catch(char const *e) { std::cout << "[ERROR] " << e << std::endl; }
	std::cout << "Still running" << std::endl;

	try{ wrong3(); } catch(std::string &e){ std::cout << "[ERROR] " << e << std::endl; }
	std::cout << "Still running" << std::endl;

	try{ wrong4(); } catch(std::exception &e){ std::cout << "[ERROR] " << e.what() << std::endl; }
	std::cout << "Still running" << std::endl;

	return 0;
}
