FROM	node
ARG	UID
RUN	npm install -g create-react-app
RUN	chmod 777 /usr/src/
COPY	createapp /usr/bin/
USER	$UID

# Uncomment this line if you want the container to hold a template.
# Holding a template causes the container to have +300Mb but to create
# the application faster, because it will just be copied from the template.
#
# RUN	createapp /usr/src/

WORKDIR	/app
COPY	entrypoint /usr/bin/
CMD	/usr/bin/entrypoint
EXPOSE	3000
