#!/bin/bash
[ -z "$1" ] && exit 1
mkdir -p results
TEST=$1
TESTNAME=$(echo ${TEST%.yaml}|sed 's:.*/::')
LOGFILE=results/$TESTNAME.log
RESULT=results/$TESTNAME.status

LAUNCHER=$(yq r $TEST TestLauncherFilename)
BASEDIR=$(dirname $LAUNCHER)
BASENAM=$(basename $LAUNCHER)
if [[ "$BASENAM" == manual* ]]; then TYPE=1; else TYPE=0; fi

echo [RUNTEST] $TEST started.
echo [RUNTEST] Launcher: $LAUNCHER
echo [RUNTEST] STARTED: $TEST
case $TYPE in
0) 	{ # Automatic test
	pushd $BASEDIR &>/dev/null
	echo
	$LAUNCHER; [ $? == 0 ] && TEST_STATUS=PASS || TEST_STATUS=FAIL;
	echo
	popd &>/dev/null
	echo TEST_STATUS=$TEST_STATUS > $RESULT
	} |& tee $LOGFILE
	grep "^[^ ]*=.*$" $LOGFILE >> $RESULT
	echo $RESULT:
	sed 's/^/\t/' $RESULT
	echo
;;
1) 	# Manual test
	$LAUNCHER;
;;
esac
echo [RUNTEST] FINISHED: $TEST
