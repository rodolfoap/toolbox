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
