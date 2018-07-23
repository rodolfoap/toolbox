all: text_reverse basic_sample string_sample advanced_sample text_reverse-glade pi-taylor

text_reverse: text_reverse.vala
	valac -o text_reverse text_reverse.vala

basic_sample: basic_sample.vala
	valac -o basic_sample basic_sample.vala

string_sample: string_sample.vala
	valac -o string_sample string_sample.vala

advanced_sample: advanced_sample.vala
	valac -o advanced_sample advanced_sample.vala

text_reverse-glade: text_reverse-glade.vala
	valac --pkg gtk+-2.0 --pkg gmodule-2.0 text_reverse-glade.vala -o text_reverse-glade

pi-taylor: pi-taylor.vala
	rm -f pi-taylor
	valac pi-taylor.vala -o pi-taylor

clean:
	-find . -maxdepth 1 -mindepth 1 -type f -executable -print -exec rm {} \;
