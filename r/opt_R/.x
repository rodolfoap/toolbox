execute(){
	./btceur.R
}
case "$1" in
e)	vi ./btceur.R .x
	;;
"")	execute
	;;
esac
