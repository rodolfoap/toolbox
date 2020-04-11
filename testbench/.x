#APPLICATION=test_case_editor.py APPLICATION=main_menu.bash
APPLICATION=menu_editor.py
OTHERFILES=menu_form.py
case "$1" in
	e)
		vi -p ./${APPLICATION} ${OTHERFILES}
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac
