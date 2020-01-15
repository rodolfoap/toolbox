case "$1" in
	e)  # Edit
		vi Dockerfile
	;;
	b)  # Build
		./build
	;;
	"") # Run
		./launch
	;;
esac
