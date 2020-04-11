ls -1 test_types|sort|cat -n|awk '{a=$1-1; print a, $2}'|while read CODE TESTYPE; do
	#echo $CODE = $TESTYPE;
	echo -n >test_types/$TESTYPE
	for TEST in cases/*.yaml; do
		yq r $TEST TestType|grep -q $CODE && {
			echo TEST $TEST is a $TESTYPE
			echo $TEST >> test_types/$TESTYPE
		}
	done
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
