#include <iostream>

class MyException :public std::exception{
public:
	virtual const char* what() const throw(){
		return "MY_ERROR";
	}
};
class Test{
public:
	void genError(){
		throw MyException();
	}
};

int main(){
	Test t;
	try{
		t.genError();
	} catch(MyException &e){
		std::cerr<<"[ERROR] "<< e.what() <<std::endl;
	}
	return 0;
}
