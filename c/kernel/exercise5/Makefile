obj-m := simple_module.o
COUNT?=2

all:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(PWD) clean

edit:
	vi simple_module.c
	@echo; ls -l

# Use: 
# make load COUNT=5
load:
	@sudo dmesg -C
	sudo insmod simple_module.ko count=$(COUNT)
	@echo;sleep 0.2;dmesg;echo -n /sys/module/simple_module/parameters/count=;cat /sys/module/simple_module/parameters/count
	@echo;lsmod|egrep "^Module|simple"

unload:
	@sudo dmesg -C
	@echo -n /sys/module/simple_module/parameters/count=;cat /sys/module/simple_module/parameters/count
	sudo rmmod simple_module.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

changevar:
	@echo -n /sys/module/simple_module/parameters/count=;cat /sys/module/simple_module/parameters/count
	sudo sh -c "echo 7 > /sys/module/simple_module/parameters/count"
	@echo -n /sys/module/simple_module/parameters/count=;cat /sys/module/simple_module/parameters/count
