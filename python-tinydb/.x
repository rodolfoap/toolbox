execute(){
	rm -f db.json
	./db.py;
}
case "$1" in
	 e) 	vi -p \
			db.py \
			.x;
		# execute
	    	;;
	"")	execute;
		;;
esac
