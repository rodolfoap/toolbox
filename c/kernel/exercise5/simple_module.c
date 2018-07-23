#include <linux/init.h>
#include <linux/module.h>
#include <linux/moduleparam.h>

MODULE_LICENSE("GPL");

int count=0;
module_param(count, int, 0644);

__init int simple_module_init(void) {
	int index=0;
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	for(index=0; index<count; index++) {
		printk(KERN_ALERT "index=%d\n", index);
	}
	return 0;
}

void simple_module_exit(void) {
	int index=0;
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	for(index=0; index<count; index++) {
		printk(KERN_ALERT "index=%d\n", index);
	}
}

module_init(simple_module_init);
module_exit(simple_module_exit);
