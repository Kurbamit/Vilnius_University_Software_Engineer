%include 'yasmmac.inc'
;------------------------------------------------------------------------
org 100h  

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
section .text                   ; Code starts here
      jmp     Settings                           ;First launch
    Old_I88:
      dw      0, 0

    procWrite:         
      jmp .next

    .next:
      call procFOpenForReading
      jc .klaidaAtidarantSkaityma
      mov [skaitymoDeskriptorius], bx
      mov dx, cx
      call procFCreateOrTruncate
      jc .klaidaAtidarantRasyma
      mov [rasymoDeskriptorius], bx
      jmp .loop

    .loop:
      xor ax, ax
      mov bx, [skaitymoDeskriptorius]
      call procFGetChar
      jc .klaidaSkaitant
      cmp ax, 0                       ; Ar ne failo pabaiga
      je .pabaiga
      mov [skaitymoDeskriptorius], bx
      mov bx, [rasymoDeskriptorius]
      mov al, cl
      call procFPutChar
      jc .klaidaRasant
      mov [rasymoDeskriptorius], bx
      jmp .loop
      
      
    .pabaiga:
      mov bx, [skaitymoDeskriptorius]
      call procFClose
      mov bx, [rasymoDeskriptorius]
      call procFClose
      exit
 
    .klaidaAtidarantSkaityma:
      macPutString 'Klaida atidarant skaitymo faila', '$'
      exit

    .klaidaRasant:
      macPutString 'Klaida rasant faila.', '$'
      exit

    .klaidaAtidarantRasyma:
      macPutString 'Klaida atidarant rasymo faila.', '$'
      exit

    .klaidaSkaitant:
      macPutString 'Klaida skaitant faila.', '$'
      exit



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
New_I88:                                           
    
      macPushAll                                       ; Saving registers
      call  procWrite                                  ; 
      mov ax, 0xb800
      mov es, ax
      mov ax, 0x6F41
      mov di, 0000 
      mov cx, 0xa0
      rep stosw
      macPopAll                                       ; 
    

      iret                                         ; Return from interrupt

    ;

;
;
; 
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
;  Settings (after first launch) block. Does not remain in the memory
;

 
Settings:
        ; Getting old 88h vector
        push    cs
        pop     ds
        mov     ax, 3588h                 ; Getting old interrupt vector
        int     21h
        
        ; Saving old vector 
        mov     [cs:Old_I88], bx             
        mov     [cs:Old_I88 + 2], es         
        
        ; Setting new 1Ch vector
        ;lea     dx, [New_I88]
        mov     dx,  New_I88
        mov     ax, 2588h                 ; Setting interrupt vector
        int     21h
        
        macPutString "OK ...", crlf, '$'
        
        ;lea     dx, [Settings  + 1]       ; dx - how many bytes
        mov dx, Settings + 1
        int     27h                      
%include 'yasmlib.asm'  


section .data

  skaitymoDeskriptorius:
    dw 0000
  
  rasymoDeskriptorius:
    dw 0000

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
section .bss                  
