#!/usr/bin/tclsh
# Source: http://www.tcl.tk/man/tcl8.5/tutorial/tcltutorial.html
set x 1

# This is a normal way to write a Tcl while loop.

while {$x < 5} {
    puts "x is $x"
    set x [expr $x + 1]
}

puts "exited first loop with X equal to $x\n"

# The next example shows the difference between ".." and {...}
# How many times does the following loop run?  Why does it not
# print on each pass?

set x 0
while "$x < 3" {
    set x [expr {$x + 1}]
    if "$x > 7" break
    if "$x > 3" { puts "WHILE OVERPASSES because the condition WAS 0<3; x is $x" }
}

puts "exited second loop with X equal to $x"
