VIDFILE=../vid/003-ExceptionsBasics.mp4
execute(){
	./app
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

playvid(){
	{	sleep 3; echo acting...;
		/usr/bin/wmctrl -a MPlayer -e 0,1280,0,1280,800;
		/usr/bin/wmctrl -a MPlayer -b toggle,above;
	} &
	mplayer $VIDFILE
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
esac
