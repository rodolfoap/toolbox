#!/usr/bin/tclsh
# Source: http://www.tcl.tk/man/tcl8.5/tutorial/tcltutorial.html
puts "SYNTAX: if START TEST NEXT BODY"
for {set i 0} {$i < 10} {incr i} { puts "I inside first loop: $i" }

for {set i 3} {$i < 2} {incr i} { puts "I inside second loop: $i" }

puts "Start"
set i 0
while {$i < 5} {
    puts "before: \$i$i"
    incr i
    puts "after:  \$i=$i"
}

set i 0
incr i
puts "test1:  \$i=$i"
# This is equivalent to:
set i [expr {$i + 1}]
puts "test2:  \$i=$i"
