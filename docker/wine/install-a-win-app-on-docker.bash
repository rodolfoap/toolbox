#!/bin/bash
set -x

dockerwine(){
	docker run -it --rm \
	--env="DISPLAY" \
	--env="PULSE_SERVER=/tmp/pulse-socket" \
	--env="WINEARCH=win32" \
	--volume="${XAUTHORITY:-${HOME}/.Xauthority}:/root/.Xauthority:ro" \
	--volume="/tmp/.X11-unix:/tmp/.X11-unix" \
	--volume="/tmp/pulse-socket:/tmp/pulse-socket" \
	--volume="/etc/localtime:/etc/localtime:ro" \
	--volume="$HOMEDIR/.wine:/home/wineuser" \
	--hostname="$(hostname)" \
	--name="wine" \
	scottyhardy/docker-wine:latest "$@"
}

# The app WINDOWSAPP is located here
SCRIPTDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"
HOMEDIR=~

cat > setup.bat << EOF
ECHO PLEASE CHOOSE WIN XP IN WINECFG.
winecfg
C:
cd C:\temp\WINDOWSAPP
setup.exe
EOF

sudo rm -r $HOMEDIR/.wine
sudo mkdir -p $HOMEDIR/.wine
sudo chown -R 1010:1010 $HOMEDIR/.wine
dockerwine winetricks msxml3 dotnet40 win7

sudo mkdir -p $HOMEDIR/.wine/.wine/drive_c/temp/;
sudo cp -rv $SCRIPTDIR/ $HOMEDIR/.wine/.wine/drive_c/temp/
dockerwine wine cmd /c c:/temp/WINDOWSAPP/setup.bat
sudo cp -rv $SCRIPTDIR/crack/windowsapp.exe $HOMEDIR/.wine/.wine/drive_c/Program\ Files/Windows\ App/WindowsApp.exe

sudo chown -R 1010:1010 $HOMEDIR/.wine

grep -B99 '^}$' $SCRIPTDIR/install-on-docker.bash > $HOMEDIR/bin/windowsapp
echo "dockerwine wine C:/Program\ Files/Windows\ App/WindowsApp.exe" >> $HOMEDIR/bin/windowsapp
chmod 755 $HOMEDIR/bin/windowsapp
rm setup.bat
