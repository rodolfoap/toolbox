#include <linux/init.h>
#include <linux/module.h>
#include <linux/fs.h>

MODULE_LICENSE("GPL");

int 	char_driver_open (struct inode *pinode, struct file *pfile){
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}
ssize_t char_driver_read (struct file *pfile, char __user *buffer, size_t length, loff_t *offset){
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}
ssize_t char_driver_write (struct file *pfile, const char __user *buffer, size_t length, loff_t *offset){
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return length;
}
int 	char_driver_release (struct inode *pinode, struct file *pfile){
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	return 0;
}

/* From /usr/src/linux-headers-3.16.0-4-common/include/linux/fs.h:
 *
 *	int (*open) (struct inode *, struct file *);
 *	ssize_t (*read) (struct file *, char __user *, size_t, loff_t *);
 *	ssize_t (*write) (struct file *, const char __user *, size_t, loff_t *);
 *	int (*release) (struct inode *, struct file *);
 */
struct file_operations simple_file_operations = {
	.owner=THIS_MODULE,
	.open=char_driver_open,
	.read=char_driver_read,
	.write=char_driver_write,
	.release=char_driver_release
};

__init int simple_char_driver_init(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	// 240 is the Major driver number
	register_chrdev(240, "simple_char_driver", &simple_file_operations);
	return 0;
}
void simple_char_driver_exit(void) {
	printk(KERN_ALERT "Function: %s\n", __FUNCTION__);
	unregister_chrdev(240, "simple_char_driver");
}

module_init(simple_char_driver_init);
module_exit(simple_char_driver_exit);
