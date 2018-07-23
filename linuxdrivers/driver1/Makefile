obj-m := module.o
# obj-m += led.o

all:
	# gcc -c led.c -o led.o
	make -C /usr/src/kernels/$(shell uname -r) M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean

test:
	insmod module.ko
	modinfo module.ko
	rmmod module.ko
	dmesg -c
