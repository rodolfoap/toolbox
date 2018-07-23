obj-m := simple_char_driver.o

all:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean
	@echo; ls -l

edit:
	vi -O simple_char_driver.c

load:
	@sudo dmesg -C
	sudo insmod simple_char_driver.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"
	@echo;cat /proc/devices|egrep ":|simple"
	@echo
	sudo mknod -m 666 /dev/simple_char_driver c 240 0
	# Will generate (c)har device, mode (rw-rw-rw-) major=(240) minor=(0) filename=(/dev/simple_char_driver)
	# crw-rw-rw- 1 root root 240, 0 Dec 22 16:26 /dev/simple_char_driver
	ls -l /dev/simple_char_driver

unload:
	@sudo dmesg -C
	sudo rm -f /dev/simple_char_driver
	sudo rmmod simple_char_driver.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

test:
	@sudo dmesg -C
	echo test > /dev/simple_char_driver
	@echo;sleep 0.2;dmesg
