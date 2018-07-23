#include <linux/init.h>
#include <linux/module.h>

MODULE_LICENSE("GPL");

__initdata int count=5;

__init int simple_module_function1(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}

int simple_module_function2(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}

__init int simple_module_init(void) {
	int index=0;
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	for(index=0; index<count; index++) {
		printk(KERN_ALERT "index=%d\n", index);
	}
	simple_module_function1();
	simple_module_function2();
	return 0;
}

void simple_module_exit(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	simple_module_function2();
}

module_init(simple_module_init);
module_exit(simple_module_exit);
