LYFILE:=e7

all:	$(LYFILE)

e:	$(LYFILE)e $(LYFILE)

e7e:
	vi -p e7.c e7.lex e7.h e7.data;

e7: 	e7.lex e7.data
	lex -o e7.yy.c e7.lex
	gcc -o e7.bin e7.yy.c e7.c -ll
	@echo "----------"
	cat e7.data > e7.output

	@echo "----------"

	cat e7.output
	@echo "----------"
	cat e7.output|./e7.bin || true
	@echo "----------"

	sed -i "s/#/:/" e7.output
	cat e7.output
	@echo "----------"
	cat e7.output|./e7.bin || true
	@echo "----------"

	sed -i "s/a1099/1099/" e7.output
	cat e7.output
	@echo "----------"
	cat e7.output|./e7.bin || true
	@echo "----------"
	@cat e7.h
	@echo "----------"

e1: 	e1.lex e1.data
	vi e1.lex
	lex -o e1.yy.c e1.lex
	gcc -o e1.bin e1.yy.c -ll
	./e1.bin < e1.data

e2: 	e2.lex e2.data
	vi e2.lex
	lex -o e2.yy.c e2.lex
	gcc -o e2.bin e2.yy.c -ll
	./e2.bin < e2.data

e3: 	e3.lex e3.data
	vi e3.lex
	lex -o e3.yy.c e3.lex
	gcc -o e3.bin e3.yy.c -ll
	./e3.bin < e3.data

e4: 	e4.lex e4.data
	vi e4.lex
	lex -o e4.yy.c e4.lex
	gcc -o e4.bin e4.yy.c -ll
	./e4.bin < e4.data

e5: 	e5.lex e5.data
	vi e5.lex
	lex -o e5.yy.c e5.lex
	gcc -o e5.bin e5.yy.c -ll
	@echo "----------"
	@cat e5.data
	@echo "----------"
	@./e5.bin < e5.data > e5.output
	@cat e5.output
	@echo "----------"
	@bash e5.output
	@echo "----------"

e6: 	e6.lex e6.data
	vi e6.lex
	lex -o e6.yy.c e6.lex
	gcc -o e6.bin e6.yy.c -ll
	@echo "----------"
	@cat e6.data
	@echo "----------"
	@./e6.bin < e6.data > e6.output
	@cat e6.output
	@echo "----------"
	@bash e6.output
	@echo "----------"

pointerse:
	vi pointers.c

pointers: pointers.c
	gcc pointers.c -o pointers.bin
	./pointers.bin

clean:
	rm -f *.yy.c *.bin *.output

m:	
	vi Makefile
