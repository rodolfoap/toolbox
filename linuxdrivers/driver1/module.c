#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>

#include <linux/sys/ioctl.h>
#include <stdio.h>
#include <linux/fcntl.h>
#include <linux/kd.h>

MODULE_LICENSE("Dual BSD/GPL");

static void kernmsg(char *message) {
	printk("<1>Test: %s\n", message);
}

static int hello_init(void) {
//	led_switch();
	kernmsg("Hello world!");
	return 0;
}

static void hello_exit(void) {
	kernmsg("Goodbye, cruel world!");
}

static int led_switch(void) {
	int ttyhnd;
	unsigned char last_leds;
	ttyhnd=open("/dev/tty1", O_RDWR);
	ioctl(ttyhnd, KDGETLED, &last_leds);
	ioctl(ttyhnd, KDSETLED, 1 & ~last_leds); // 1=ScrollLock; 2=NumLock; 4=CapsLock
	close(ttyhnd);
        return 1;
}

module_init(hello_init);
module_exit(hello_exit);
