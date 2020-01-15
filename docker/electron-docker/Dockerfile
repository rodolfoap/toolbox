FROM		node

RUN 		apt-get update && apt-get install -y libx11-xcb-dev libxtst6 libnss3-dev libgtk-3-0 libxss1 libasound2

ARG		UID
ARG		GID
RUN		usermod -u $UID node
RUN		groupmod -g $GID node
RUN		find /home -uid 1000 -exec chown -h node {} \;
RUN		find /home -gid 1000 -exec chgrp -h node {} \;
COPY		entrypoint /usr/bin/

USER		node
WORKDIR		/app
CMD		/usr/bin/entrypoint
EXPOSE		3000
