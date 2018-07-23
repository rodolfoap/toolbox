// connect sine oscillator to D/A convertor (sound card)
SinOsc s => dac;

// loop in time
while( true ) {
	// allow 2 seconds to pass
	2::second => now;
}
