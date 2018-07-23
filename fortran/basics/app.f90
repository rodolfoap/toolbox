! This is a comment
program first

        ! Force variables to be declared
        implicit none

        ! Variables declarations
        character :: message*13 = 'Hello, World!'
        real :: addition, x=9.0, y=4.0
        real :: pi=4.0*atan(1.0)
        integer :: i, j

        ! Hello world
        call helloWorld(message)

        ! Function
        print *, addition (x, y)

        ! Subroutines
        call exampleLoop(13)
        call inputOutput(pi)

end program first

!----------------------------------------------------------
! Example LOOPs
subroutine exampleLoop(a)

        integer :: count, a

        do count = a, 0, -1
                print *, 'Countdown:', count
        end do

end subroutine

!----------------------------------------------------------
! Example read/print
subroutine inputOutput(var)

        real :: var
        integer :: x, y

        print *, 'Received:', var

        print *, 'Enter two integer values:'
        read *, x, y
        ! Concatenate with commas
        print *, 'X=', x, '; Y=', y
        print *, 'X+Y=', x+y

        ! IF statements
        if (x<y) then
                print *, 'X<Y'
        else if (x==y) then
                print *, 'X==Y'
        else
                print *, 'X>Y'
        end if

end subroutine

!----------------------------------------------------------
! Example function
function addition(x, y)

        real :: x, y
        addition=x+y

end function

!----------------------------------------------------------
! Hello world
subroutine helloWorld(message)

        character :: message*13

        print *, message

end subroutine

