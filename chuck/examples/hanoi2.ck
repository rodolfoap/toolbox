// towers of annoy

// number of disks
3 => int disks;
// duration for each move
200::ms => dur wait;

// gain to pan to dac
Gain g => Pan2 pan => JCRev r => dac;
// set gain
.5 => g.gain;
// set mix
.15 => r.mix;

// the pegs (0 not used - for easy indexing)
SndBuf pegs[4];

// load files
"data/hihat-open.wav" => pegs[1].read;
"data/hihat.wav" => pegs[2].read;
"data/snare-chili.wav" => pegs[3].read;

// connect to gain
for( 1 => int i; i < pegs.cap(); i++ )
    pegs[i] => g;

// the hanoi
fun void hanoi( int num, int src, int dest, int other )
{
    // move all except the biggest
    if( num > 1 ) hanoi( num - 1, src, other, dest );

    // move the biggest
    <<< src, " -> ", dest >>>;
    // sonify
    0 => pegs[dest].pos;
    // pan
    dest - 2 => pan.pan;
    // advance time
    wait => now;

    // move onto the biggest
    if( num > 1 ) hanoi( num - 1, other, dest, src );
}

hanoi( disks, 1, 3, 2 );
