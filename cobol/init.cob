      *====#############################################################
      * Column 7 is comments
      * Column  8 - 11 is A Margin 
      * Column 12 - 72 is B Margin 

       IDENTIFICATION DIVISION.
        PROGRAM-ID. FIRSTONE.
        AUTHOR. RODOLFO ALCAZAR.
        DATE-WRITTEN. NOVEMBER-2008.

       ENVIRONMENT DIVISION.
        CONFIGURATION SECTION.
          SOURCE-COMPUTER. X86-64.
          OBJECT-COMPUTER. X86-64.
          SPECIAL-NAMES.
              DECIMAL-POINT IS COMMA.

        INPUT-OUTPUT SECTION.
          FILE-CONTROL.
              SELECT FICHERO ASSIGN TO DISK
                             ORGANIZATION LINE SEQUENTIAL
                             ACCESS MODE SEQUENTIAL.

       DATA DIVISION.

        FILE SECTION.

         FD FICHERO LABEL RECORD STANDARD
                    VALUE OF FILE-ID 'CLIENTE.DAT'.

         01 REGISTRO                PIC X(48).

        WORKING-STORAGE SECTION.

        01 CLIENTE.
           05 FILLER                PIC X      VALUE "#".
           05 CARNET                PIC 9(7).
           05 FILLER                PIC X      VALUE SPACES.
           05 INICIAL               PIC X. 
           05 FILLER                PIC X      VALUE '.'.
           05 NOMBRE                PIC X(16)  VALUE ALL '_'.
           05 FILLER                PIC X(5)   VALUE SPACES.
           05 APELLIDO              PIC X(16)  VALUE ALL '_'.
       01 FINAL-FICHERO             PIC 9      VALUE 0.

       PROCEDURE DIVISION.

       INICIO-PROGRAMA.
              PERFORM PIDE-DATOS.
              PERFORM MUESTRA-DATOS.
              OPEN OUTPUT FICHERO.
              PERFORM GRABA-DATOS.
              CLOSE FICHERO.
              MOVE 0 TO CARNET
              PERFORM MUESTRA-DATOS.
              OPEN INPUT FICHERO.
              PERFORM LEE-DATOS UNTIL FINAL-FICHERO = 1.
              CLOSE FICHERO.
              PERFORM MUESTRA-DATOS.
              PERFORM FIN-PROGRAMA.

       PIDE-DATOS.
              DISPLAY 'PRIMER NOMBRE: '.
              ACCEPT NOMBRE. 
              MOVE NOMBRE TO INICIAL.
              DISPLAY 'PRIMER APELLIDO: '.
              ACCEPT APELLIDO. 
              DISPLAY 'NUMERO DE CI: '.
              ACCEPT CARNET.
              IF CARNET IS EQUAL 3379263
                     PERFORM ARREGLA-CI
              ELSE
                     DISPLAY 'CARNET DESCONOCIDO'.

       ARREGLA-CI.
              ADD 1 9 TO CARNET.
              SUBTRACT 10 FROM CARNET.
              MULTIPLY 2 BY CARNET.
              DIVIDE 2 INTO CARNET.
              COMPUTE CARNET = ( CARNET * 2 + 1 - 1 ) / 2.
              
       MUESTRA-DATOS.
              DISPLAY CLIENTE.

       GRABA-DATOS.
              WRITE REGISTRO FROM CLIENTE.

       LEE-DATOS.
              READ FICHERO INTO CLIENTE
              AT END MOVE 1 TO FINAL-FICHERO.

       FIN-PROGRAMA.
              STOP RUN.
