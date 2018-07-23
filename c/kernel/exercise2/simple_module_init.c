#include <linux/init.h>
#include <linux/module.h>

int simple_module_init(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}

module_init(simple_module_init);
