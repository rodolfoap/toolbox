[ -d tf/models ] || { echo "Models directory does not exist, please run ./models-clone.bash"; exit; }
sudo docker run --rm -it -p 8888:8888 -v $(pwd)/tf/:/tf/ --name dockertf dockertf
