APPLICATION=checks/check001.py
OTHERFILES=lib/status.py
PARAMETERS=results/test001.status
case "$1" in
	e)
		vi -p ${APPLICATION} ${OTHERFILES}
		./${APPLICATION} ${PARAMETERS}
	;;
	""|*)
		./${APPLICATION} ${PARAMETERS}
	;;
esac
