all: w3t

w3t: w3t.vala
	rm -rf w3t
	vi w3t.vala
	valac --pkg gtk+-2.0 --pkg webkit-1.0 --thread -o w3t w3t.vala

clean:
	-find . -type f -executable -exec rm {} \;

