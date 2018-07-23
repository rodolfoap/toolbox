#!/usr/bin/tclsh 
# Source: http://www.tcl.tk/man/tcl8.5/tutorial/tcltutorial.html
set x "ONE"
set y 1
set z ONE

switch $x {
    "$z" {
        set y1 [expr {$y+1}]
        puts "a MATCH \$z. $y + $z is $y1"
	puts "THIS OPTION IS NOT SELECTED because on brace SWITCH version no patterns are evaluated"
    }
    ONE {
        set y1 [expr {$y+1}]
        puts "b MATCH ONE. $y + one is $y1"
    }
    TWO {
        set y1 [expr {$y+2}]
        puts "c MATCH TWO. $y + two is $y1"
    }
    default {
        puts "e $x is NOT A MATCH"
    }
}

switch $x "$z" {
    set y1 [expr {$y+1}]
    puts "f MATCH \$z. $y + $z is $y1"
} ONE {
    set y1 [expr {$y+1}]
    puts "g MATCH ONE. $y + one is $y1"
} TWO {
    set y1 [expr {$y+2}]
    puts "h MATCH TWO. $y + two is $y1"
} default {
    puts "j $x does not match any of these choices"
}

switch $x "ONE" "puts ONE=1" "TWO" "puts TWO=2" "default" "puts NO_MATCH"

switch $x \
"ONE"     "puts ONE=1"  \
"TWO"     "puts TWO=2" \
"default"     "puts NO_MATCH";
    
