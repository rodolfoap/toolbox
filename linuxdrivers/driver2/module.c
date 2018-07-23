#include <linux/module.h>
#include <config/i2o/config.h>
#include <linux/init.h>
#include <linux/fs.h>

MODULE_LICENSE("GPL");

static void kernmsg(char *message) {
	printk("<1>Test: %s\n", message);
}

static int pp_open(struct inode *inode, struct file *filep) {
	kernmsg("Called: pp_open.");
	return 0;
}
static ssize_t pp_write(struct file *filep, const char *buf, size_t count, loff_t *f_pos) {
	kernmsg("Called: pp_write.");
	return 0;
}
static ssize_t pp_read(struct file *filep, char *buf, size_t count, loff_t *f_pos) {
	kernmsg("Called: pp_read.");
	return 0;
}
static int pp_release(struct inode *inode, struct file *filep) {
	kernmsg("Called: pp_release.");
	return 0;
}
struct file_operations pp_fops = {
	owner:		THIS_MODULE,
	open:		pp_open,
	release:	pp_release,
	read:		pp_read,
	write:		pp_write,
};

static int rapmod_init(void) {
	int result;
	kernmsg("Called: rapmod_init.");
	if ((result = register_chrdev(22, "ppio", &pp_fops)) < 0) goto fail;
	kernmsg("rapmod_init: module registered.");
	return 0;
fail:
	kernmsg("rapmod_init: ERROR registering module.");
	return -1;
}
static void rapmod_exit(void) {
	kernmsg("Called: rapmod_exit.");
	unregister_chrdev(22, "ppio");
	kernmsg("rapmod_init: module unregistered.");
}
module_init(rapmod_init);
module_exit(rapmod_exit);
