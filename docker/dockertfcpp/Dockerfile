FROM floopcz/tensorflow_cc:ubuntu
WORKDIR /tf/models/research
ENV PYTHONPATH=/tf/models/research:/tf/models/research/slim
RUN apt-get -y update && apt -y install git curl unzip build-essential cmake python-pip vim
RUN pip install cython matplotlib pillow
RUN cd /root && \
	curl -OL https://github.com/google/protobuf/releases/download/v3.2.0/protoc-3.2.0-linux-x86_64.zip && \
	unzip protoc-3.2.0-linux-x86_64.zip -d protoc3 && \
	mv protoc3/bin/* /usr/local/bin/  && \
	mv protoc3/include/* /usr/local/include/
