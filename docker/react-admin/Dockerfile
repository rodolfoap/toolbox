FROM	node

RUN	npm install -g create-react-app
RUN	chmod 777 /usr/src/

ARG	UID
ARG	GID
RUN	usermod -u $UID node
RUN	groupmod -g $GID node
RUN	find /home -uid 1000 -exec chown -h node {} \;
RUN	find /home -gid 1000 -exec chgrp -h node {} \;
COPY	createapp /usr/bin/
COPY	entrypoint  /usr/bin/

USER	node
# Uncomment this line if you want the container to hold a template.
# Holding a template causes the container to have +300Mb but to create
# the application faster, because it will just be copied from the template.
#
# RUN	createapp /usr/src/ && rm -rf /usr/src/node_modules/

WORKDIR	/app
CMD	/usr/bin/entrypoint
EXPOSE	3000
