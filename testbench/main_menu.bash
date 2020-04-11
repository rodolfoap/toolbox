#!/bin/bash

getAction(){
	OPTION=$(whiptail --title "Testbench" \
		--menu "Select Action" 15 60 4 \
		"1" "Test case definition" \
		"2" "Test campaign definition" \
	3>&1 1>&2 2>&3) && echo $OPTION || echo ""
}

case $(getAction) in
	1)	./test_case_editor.py;
		;;
	2)	echo Test Campaign Definition
		;;
	"")	echo Cancelled
		;;
esac
