#include <iostream>
#include <fstream>
#include <string.h>
int main(int n, char**v) {
	int col=0, row=0;
	char b[128][256];
	std::ifstream f(v[1]);
	while(f>>b[row++]);
	for(n=0; n<row; ++n) { std::cerr<<b[n];	std::cerr<<std::endl; }
	std::cerr<<strlen(b[0])<<std::endl;
}
