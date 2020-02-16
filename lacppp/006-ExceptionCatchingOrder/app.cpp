#include <iostream>

void wrong(){
	throw std::bad_alloc();
}

int main(){
	try  { wrong(); }
	// This is a mistake, since an exception will raised, not a bad_alloc()
	// because exception is a superclass, so it is allowed. The solution is
	// simply to put the subclasses before.
	catch(std::exception &e){ std::cerr << e.what() << std::endl; }
	catch(std::bad_alloc &e){ std::cerr << e.what() << std::endl; }
	return 0;
}
