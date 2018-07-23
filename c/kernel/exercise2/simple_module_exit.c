#include <linux/init.h>
#include <linux/module.h>

void simple_module_exit(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
}

module_exit(simple_module_exit);
