obj-m := simple_module.o

all:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean

edit:
	vi simple_module.c
	@echo; ls -l

load:
	@sudo dmesg -C
	sudo insmod simple_module.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

unload:
	@sudo dmesg -C
	sudo rmmod simple_module.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"
