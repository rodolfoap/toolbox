FC=gfortran

default: all

all: app

edit:
	vim -O app.f90 ../ex04/app.f90
	$(FC) -o app app.f90
	./app

app: app.f90
	$(FC) -o app app.f90
	./app

clean:
	rm -rf app
