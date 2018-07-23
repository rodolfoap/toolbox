#include <fcntl.h>
#include <linux/kd.h>
int main() {
	int ttyhnd;
	unsigned char last_leds;
	ttyhnd=open("/dev/tty1", O_RDWR);
	ioctl(ttyhnd, KDGETLED, &last_leds);
	ioctl(ttyhnd, KDSETLED, 1 & ~last_leds); // 1=ScrollLock; 2=NumLock; 4=CapsLock
	close(ttyhnd);
        return 1;
}
