VIDFILE=../vid/003-ExceptionsBasics.mp4
execute(){
echo
	./app
echo
}
build(){
	[ -d build/ ] && {
		pushd build &> /dev/null;
	} || {
		mkdir build;
		pushd build &> /dev/null;
		cmake .. -Wdev;
	}
	make -j8; STATUS=$?
	popd &> /dev/null;
	[ $STATUS == 0 ] && echo [100%] $(ls -l app) || echo [ERROR] Compilation error.
}
playvid(){
	{	sleep 3; echo acting...;
		# gravity,x,y,w,h, where w/h=1.6, 1920x1080
		/usr/bin/wmctrl -a MPlayer -e 0,1600,0,960,600;
		/usr/bin/wmctrl -a MPlayer -b toggle,above;
	} &
	mplayer $1
}
case "$1" in
	"")
		[ -f app ] || build;
		execute
	;;
	e)
		vi -O app.cpp
		build;
		execute;
	;;
	p)
		playvid $VIDFILE
	;;
esac
