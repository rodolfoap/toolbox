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

         01 REGISTRO                PIC X(53).

        WORKING-STORAGE SECTION.

        01 CLIENTE.
           05 FILLER                PIC X      VALUE "#".
           05 CARNET                PIC 9(8).
           05 FILLER                PIC X      VALUE SPACES.
           05 INICIAL               PIC X. 
           05 FILLER                PIC X      VALUE '.'.
           05 NOMBRE                PIC X(20)  VALUE ALL '_'.
           05 FILLER                PIC X      VALUE SPACES.
           05 APELLIDO              PIC X(20)  VALUE ALL '_'.

       PROCEDURE DIVISION.

       INICIO-PROGRAMA.
              DISPLAY 'PRIMER NOMBRE: '.
              ACCEPT NOMBRE. 
              MOVE NOMBRE TO INICIAL.
              DISPLAY 'PRIMER APELLIDO: '.
              ACCEPT APELLIDO. 
              DISPLAY 'NUMERO DE CI: '.
              ACCEPT CARNET. 
              DISPLAY CLIENTE.

       FIN-PROGRAMA.
              STOP RUN.
