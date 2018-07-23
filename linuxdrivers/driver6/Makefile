obj-m := usbhid.o

all:
	make -C /usr/src/kernels/$(shell uname -r) M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean
	rmmod usbhid.ko
	dmesg -c

test:
	insmod usbhid.ko
	modinfo usbhid.ko
	dmesg -c
