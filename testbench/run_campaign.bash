for a in test_cases/*; do
	TEST=$(yq r $a TestLauncherFilename)
	$TEST
done
