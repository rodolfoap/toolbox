all: basicsample advancedsample list stringsample prop_sample prop_construction

basicsample: basicsample.vala
	valac -o basicsample basicsample.vala

advancedsample: advancedsample.vala
	valac -o advancedsample advancedsample.vala

list: list.vala
	valac -o list list.vala

stringsample: stringsample.vala
	valac -o stringsample stringsample.vala

prop_sample: prop_sample.vala
	valac -o prop_sample prop_sample.vala

prop_construction: prop_construction.vala
	valac -o prop_construction prop_construction.vala

clean:
	-find . -type f -executable -exec rm {} \;

