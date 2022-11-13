org 100h

%include 'yasmmac.inc'

section .text

    startas:
        macPutString 'Iveskite rasymo failo varda:', crlf, '$'
        
            ; Issaugome rasymo failo varda
        mov al, 128         
        mov dx, rasymoFailas
        call procGetStr     
        macNewLine
        
        ; Atidaryti skaitymo faila
        mov dx, skaitymoFailas
        call procFOpenForReading
        jnc .rasymoFailasAtidarytas
        macPutString 'Klaida atidarant skaitymo faila', '$'
        exit
        
        ; Atidarome rasymo faila
        .rasymoFailasAtidarytas:
            mov [skaitymoDeskriptorius], bx
            mov dx, rasymoFailas
            call procFCreateOrTruncate
            jnc .rasymoFailoAtidarymas
            macPutString 'Klaida atidarant rasymo faila', '$'
            jmp .rasymoKlaida
        
        ; Issaugome rasymo deskriptoriu
        .rasymoFailoAtidarymas:
            mov [rasymoDeskriptorius], bx
            
            
        ; Nuskaito pirma eilute
        call procSkaitytiEilute
        call rasykHeader
        
        ; Main ciklas
        .kolNeFailoPabaiga:
            call procSkaitytiEilute
            
            ; Tikrina pirmus du stulpelius
            ;mov al, ';'

		mov di, eilute
            
            ; Tikrina pirma stulpeli
            .pirmasStulpelis:
                mov al, [di]
                inc di
                
                cmp al, byte 'B'
                je .praleistiEilute
                cmp al, byte 'b'
                je .praleistiEilute
                cmp al, byte 'C'
                je .praleistiEilute
                cmp al, byte 'c'
                je .praleistiEilute
                
                cmp al, byte ';'
                jne .pirmasStulpelis
                jmp .antrasStulpelis
                
            ; Tikrina antra stulpeli
            .antrasStulpelis:
                mov al, [di]
                inc di
                
                cmp al, byte 'B'
                je .praleistiEilute
                cmp al, byte 'b'
                je .praleistiEilute
                cmp al, byte 'C'
                je .praleistiEilute
                cmp al, byte 'c'
                je .praleistiEilute
                
                cmp al, byte ';'
                jne .antrasStulpelis
                jmp .pridekSkaiciu      ; Pridedame vieneta, nes eilute atitinka reikalavimus
                
            .pridekSkaiciu:
                call procPridekSkaiciu
                jmp .praleistiEilute
                
            
            ; Jeigu ne failo pabaiga, kartojame cikla
            .praleistiEilute:
            cmp [nuskaitytaPaskutineEilute], byte 0
            je .kolNeFailoPabaiga
            
            ; Hexadecimal konvertavimas i decimal
		   mov dx, eilutesSkaicius
           mov ax, [eilutesSkaicius]
           call procUInt16ToStr
           mov si, dx


           .rasymas:
           lodsb
           cmp al, 0
           jne .rasymas
           sub si, dx
           lea cx, [si-1]
           mov bx, [rasymoDeskriptorius]
           mov ah, 40h
           int 21h

        
        
        ; Closing Files
        .end:
            mov bx, [rasymoDeskriptorius]
            call procFClose
        
        .rasymoKlaida:
            mov bx, [skaitymoDeskriptorius]
            call procFClose
        
        exit
        
%include 'yasmlib.asm'

; void procSkaitytiEilute()
; Read line to buffer ‘eilute’
procSkaitytiEilute:
    push ax
    push bx
    push cx
    push si
    
    mov bx, [skaitymoDeskriptorius]
    mov si, 0


    .ciklas:
        call procFGetChar
    
        ; End if the end of file or error
        cmp ax, 0
        je .baigesiFailas
        jc .baigesiFailas
        
        ; Putting symbol to buffer
        mov [eilute+si], cl
        inc si
    
        ; Check if there is \n?
        cmp cl, 0x0A
        je .baigesiEilute
    
        jmp .ciklas
        
        
    .baigesiFailas:
        mov [nuskaitytaPaskutineEilute], byte 1
    .baigesiEilute:
    
    mov [eilute+si], byte '$'
    mov [eilutesIlgis], si
    
    pop si
    pop cx
    pop bx
    pop ax
    ret

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
procPridekSkaiciu:
    push si
    push ax
    push bx
    push cx
    push dx
    
    ;eilutesSkaicius++
    xor ah, ah
	macPutString 'Pridedu skaiciu', crlf, '$'
    mov al, byte [eilutesSkaicius]
    inc al
    mov [eilutesSkaicius], al
    call procPutUInt16
    
    pop dx
    pop cx
    pop bx
    pop ax
    pop si
    ret

rasykHeader:

    mov bx, [rasymoDeskriptorius]
	mov cx, [eilutesIlgis]
	mov dx, eilute
   	mov ah, 40h
	int 21h

    ret

section .data

    skaitymoFailas:
        db 'input.dat', 00
        
    skaitymoDeskriptorius:
        dw 0000
        
    rasymoFailas:
        times 128 db 00
        
    rasymoDeskriptorius:
        dw 0000
        
    nuskaitytaPaskutineEilute:
        db 00
        
    eilute:
        db 64
        times 66 db '$'
        
    eilutesIlgis:
        dw 0000
    
    eilutesSkaicius:
        db 00, 00, 00, 00, 00
