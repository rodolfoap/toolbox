FROM nikolaik/python-nodejs
WORKDIR /data
RUN apt-get -y update && apt -y install clang-format
RUN pip3 install black
RUN yarn add --dev --exact prettier
