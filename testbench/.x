ls -1 test_types|sort|cat -n|awk '{a=$1-1; print a, $2}'|while read CODE TESTYPE; do
	:>test_types/$TESTYPE
	for TEST in cases/*.yaml; do
		yq r $TEST TestType|grep -q $CODE && { echo $TEST|sed 's:.*/::' >> test_types/$TESTYPE; }
	done
done

rm results/*
cat test_types/*|sort|uniq|while read TEST; do
	LAUNCHER=$(yq r cases/$TEST TestLauncherFilename)
	{
		echo [RUNNING] $TEST:$LAUNCHER
		$LAUNCHER
		[ $? == 0 ] && STATUS=PASS || STATUS=FAIL;
		echo TEST_STATUS=$STATUS > results/${TEST%.yaml}.result
	} |& tee results/${TEST%.yaml}.log
	grep "^..*=..*$" results/${TEST%.yaml}.log > results/${TEST%.yaml}.result
done

return
APPLICATION=edit_test_campaign.py
OTHERFILES=
PARAMETERS=campaigns/camp001.yaml
case "$1" in
	e)
		vi -p ${APPLICATION} ${OTHERFILES}
		./${APPLICATION} ${PARAMETERS}
	;;
	""|*)
		./${APPLICATION} ${PARAMETERS}
	;;
esac
