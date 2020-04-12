#!/bin/bash
[ -z "$1" ] && exit 1
mkdir -p results
TEST=$1
TESTNAME=$(echo ${TEST%.yaml}|sed 's:.*/::')
LOGFILE=results/$TESTNAME.log
RESULT=results/$TESTNAME.status

echo [RUNTEST] $TEST started.
LAUNCHER=$(yq r $TEST TestLauncherFilename)
BASEDIR=$(dirname $LAUNCHER)
echo [RUNTEST] Launcher: $LAUNCHER
echo [RUNTEST] STARTED: $TEST
{
	pushd $BASEDIR &>/dev/null
	echo
	$LAUNCHER; [ $? == 0 ] && TEST_STATUS=PASS || TEST_STATUS=FAIL;
	echo
	popd &>/dev/null
	echo TEST_STATUS=$TEST_STATUS > $RESULT
} |& tee $LOGFILE
echo [RUNTEST] FINISHED: $TEST
grep "^[^ ]*=.*$" $LOGFILE >> $RESULT
echo $RESULT:
sed 's/^/\t/' $RESULT
