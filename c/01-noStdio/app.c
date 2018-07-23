// Is it possible to write to console without #includes?
// yes, but only because write() is a system call,
// it is contained in unistd.h

int main(int argc, char *argv[])
{
	// The length of the string is 14
	char str[] = "Hello, world!\n";

	write(1, str, 14);
	return 0;
}
