#include <linux/module.h>
#include <linux/miscdevice.h>
#include <asm/uaccess.h>
#include <config/i2o/config.h>
#include <linux/init.h>
#include <linux/fs.h>
#include <linux/proc_fs.h>

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple memory device driver");
MODULE_AUTHOR("Rodolfo Alcazar <rodolfoap@gmail.com>");

static void kernmsg(char *message) {
	printk("<1>Test: %s\n", message);
}

static int hello_read_proc(char *buffer, char **start, off_t offset, int size, int *eof, void *data) {
	char *hello_str = "Hello, world!\n";
	int len = strlen(hello_str); /* Don't include the null byte. */
	if (size < len)  return -EINVAL;
	if (offset != 0) return 0;
	strcpy(buffer, hello_str);
	*eof = 1;

	return len;

}
static ssize_t hello_read(struct file * file, char * buf, size_t count, loff_t *ppos) {
        char *hello_str = "Hello, world!\n";
        int len = strlen(hello_str); /* Don't include the null byte. */
        if (count < len) return -EINVAL;
        if (*ppos != 0)  return 0;
        if (copy_to_user(buf, hello_str, len)) return -EINVAL;
        *ppos = len;
        return len;
}
static const struct file_operations hello_fops = {
        .owner          = THIS_MODULE,
        .read           = hello_read,
};

static struct miscdevice hello_dev = { MISC_DYNAMIC_MINOR, "hello", &hello_fops };

static int rapmod_init(void) {
int ret;
	kernmsg("Called: rapmod_init.");
	if (create_proc_read_entry("hello_world", 0, NULL, hello_read_proc, NULL) == 0) {
		printk(KERN_ERR "Unable to register \"Hello, world!\" proc file\n");
		return -ENOMEM;
	}

        ret = misc_register(&hello_dev);
        if (ret)
                printk(KERN_ERR "Unable to register \"Hello, world!\" misc device\n");

	return 0;
}
static void rapmod_exit(void) {
	kernmsg("Called: rapmod_exit.");
	remove_proc_entry("hello_world", NULL);
	misc_deregister(&hello_dev);
}
module_init(rapmod_init);
module_exit(rapmod_exit);
