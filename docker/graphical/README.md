# Launch X apps from a container

Taken from https://medium.com/@SaravSun/running-gui-applications-inside-docker-containers-83d65c0db110

...
* share XServer:
```
--volume="$HOME/.Xauthority:/root/.Xauthority:rw"
```
* share DISPLAY:
```
--env="DISPLAY"
```
* run container with host network driver:
```
--net=host
```
