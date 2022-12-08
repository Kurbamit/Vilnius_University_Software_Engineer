; Rezidentinė programa
; 
; 
; Nustatome 88 pertraukimą
; 
%include 'yasmmac.inc'          ; Pagalbiniai makrosai
;------------------------------------------------------------------------
org 100h                        ; visos COM programos prasideda nuo 100h
                                ; Be to, DS=CS=ES=SS !

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
section .text                   ; kodas prasideda cia 
    
    startas:
      mov cx, outputFile
      mov dx, inputFile
      int 0x88

      mov ah, 0x4c
      int 0x21


section .data

outputFile:
  db 'output.txt', 00

inputFile:
  db 'input.txt', 00

section .bss
