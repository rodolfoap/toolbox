execute(){
	cat input.txt|./app
}
build(){
	lex tokens.l
	yacc -d parser.y
	cc lex.yy.c y.tab.c -o app
}
case "$1" in
e)
	vi -p tokens.l parser.y
	build
	execute
;;
x|execute)
	execute
;;
""|*)
	build
	execute
;;
esac

