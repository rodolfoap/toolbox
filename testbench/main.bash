#!/bin/bash

exitFn(){ clear; exit; }
while :; do

dialog --clear --title "Test Bench" --menu "Choose operation:" 20 50 13 \
	"etc" "Edit Test Case" \
	"rtc" "Run Test Case" \
	"ecp" "Edit Campaign" \
	"rcp" "Run Campaign" \
2> .dialog || exitFn

case $(cat .dialog) in
'etc')
	dialog --clear --title "Test Bench/Edit Test" --menu "Choose:" 20 50 13 \
		$(ls cases|sed -r 's/(.*)/\1 \1/') 2> .dialog || exitFn
		./edit_test_case.py cases/$(cat .dialog)
	;;
'rtc')
	dialog --clear --title "Test Bench/Edit Test" --menu "Choose:" 20 50 13 \
		$(ls cases|sed -r 's/(.*)/\1 \1/') 2> .dialog || exitFn
		clear && ./run_test.bash cases/$(cat .dialog)
		echo && read -p "Press [ENTER] to get the menu back." NOP
	;;
'ecp')
	dialog --clear --title "Test Bench/Edit Campaign" --menu "Choose:" 20 50 13 \
		$(ls campaigns|sed -r 's/(.*)/\1 \1/') 2> .dialog || exitFn
		./edit_test_campaign.py campaigns/$(cat .dialog)
	;;
'rcp')
	dialog --clear --title "Test Bench/Run Campaign" --menu "Choose:" 20 50 13 \
		$(ls cases|sed -r 's/(.*)/\1 \1/') 2> .dialog || exitFn
		clear && ./run_campaign.bash campaigns/$(cat .dialog)
		exitFn
	;;
esac

done
