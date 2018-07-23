obj-m := module.o

all:
	make -C /usr/src/kernels/$(shell uname -r) M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean
	rmmod module.ko
	dmesg -c

test:
	insmod module.ko
	modinfo module.ko
	dmesg -c
