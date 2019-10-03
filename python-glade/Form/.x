case "$1" in
e)
	glade Form.ui &> /dev/null & vi ./Form.py
;;
"")
	./Form.py
;;
esac
