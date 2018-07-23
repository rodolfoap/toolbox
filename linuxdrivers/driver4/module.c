#include <linux/module.h>
#include <linux/kd.h>
#include <linux/console_struct.h>
#include <linux/vt_kern.h>
#include <linux/vt.h>

struct timer_list my_timer;
struct tty_driver *my_driver;
char kbledstatus = 0;

#define BLINK_DELAY HZ/5
#define RESTORE_LEDS 0xFF

static void my_timer_foo(unsigned long ptr)
{
    int *pstatus = (int *)ptr;
    switch (*pstatus) {
	case 0x01: *pstatus = 0x00;
		    break;
	default:   *pstatus = 0x01;
		    break;
    }

    (my_driver->ops->ioctl)(vc_cons[fg_console].d->vc_tty, NULL, KDSETLED, *pstatus);
//    my_timer.expires = jiffies + BLINK_DELAY;
//    add_timer(&my_timer);
}


static int __init kb_leds_init(void)
{
    printk(KERN_INFO "fg_console is %x\n", fg_console);
    my_driver = vc_cons[fg_console].d->vc_tty->driver;
	my_timer_foo((unsigned long)&kbledstatus);
    
//    init_timer(&my_timer);
//    my_timer.function = my_timer_foo;
//    my_timer.data = (unsigned long)&kbledstatus;
//    my_timer.expires = jiffies + BLINK_DELAY;
//    add_timer(&my_timer);
    return 0;
}

static void __exit kb_leds_exit(void)
{
//    del_timer(&my_timer);
    (my_driver->ops->ioctl)(vc_cons[fg_console].d->vc_tty, NULL, KDSETLED, RESTORE_LEDS);
}

module_init(kb_leds_init);
module_exit(kb_leds_exit);

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple memory device driver");
MODULE_AUTHOR("Rodolfo Alcazar <rodolfoap@gmail.com>");
