#include<iostream>
#include "main.h"

void sayHello(const std::string &name){
	std::cerr << "Hello, " << name << "!" << std::endl;
}

int main(int argc, char *argv[]){
	sayHello("World");
	return 0;
}
