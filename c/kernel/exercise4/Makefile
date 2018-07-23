obj-m := simple_module_import_symbol.o 
obj-m += simple_module_export_symbol.o

all:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build/ M=$(PWD) clean
	@echo; ls -l

edit:
	vi -O simple_module_import_symbol.c simple_module_export_symbol.c

load-import:
	@sudo dmesg -C
	sudo insmod simple_module_import_symbol.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

unload-import:
	@sudo dmesg -C
	sudo rmmod simple_module_import_symbol.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

load-export:
	@sudo dmesg -C
	sudo insmod simple_module_export_symbol.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"

unload-export:
	@sudo dmesg -C
	sudo rmmod simple_module_export_symbol.ko
	@echo;sleep 0.2;dmesg
	@echo;lsmod|egrep "^Module|simple"
