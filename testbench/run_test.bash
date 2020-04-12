#!/bin/bash
[ -z "$1" ] && exit 1
mkdir -p results
TEST=$1
TESTNAME=$(echo ${TEST%.yaml}|sed 's:.*/::')
LOGFILE=results/$TESTNAME.log
RESULT=results/$TESTNAME.status

echo [RUNTEST] $TEST started.
LAUNCHER=$(yq r $TEST TestLauncherFilename)
{
	echo [RUNTEST] $TEST: $LAUNCHER
	$LAUNCHER
	[ $? == 0 ] && TEST_STATUS=PASS || TEST_STATUS=FAIL;
	echo TEST_STATUS=$TEST_STATUS > $RESULT
} |& tee $LOGFILE
grep "^[^ ]*=[^ ]*$" $LOGFILE >> $RESULT
echo; echo $RESULT:; echo
sed 's/^/\t/' $RESULT
