obj-m := simple_module_init.o
obj-m += simple_module_exit.o

all:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) clean
	@echo; ls -l

edit:
	vi -O simple_module_init.c simple_module_exit.c

load-init:
	@sudo dmesg -C
	sudo insmod simple_module_init.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

unload-init:
	@sudo dmesg -C
	sudo rmmod simple_module_init.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

load-exit:
	@sudo dmesg -C
	sudo insmod simple_module_exit.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

unload-exit:
	@sudo dmesg -C
	sudo rmmod simple_module_exit.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"
