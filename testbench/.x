APPLICATION=test_case_editor.py
case "$1" in
	e)
		vi -p ./${APPLICATION} entry_form.py
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac
