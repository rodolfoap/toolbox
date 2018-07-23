obj-m := module.o

all:
	make -C /usr/src/kernels/$(shell uname -r) M=$(PWD) modules
	gcc uspace.c -o uspace

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean
	rm -f uspace
	rm -fv /dev/ppio
	rmmod module.ko
	dmesg -c

test:
	insmod module.ko
	dmesg -c
	modinfo module.ko
	rm -fv /dev/ppio
	mknod -m 0666 /dev/ppio c 22 0
	ls -l /dev/ppio
	dmesg -c

utest:
	./uspace
	dmesg -c
