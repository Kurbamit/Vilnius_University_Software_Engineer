a790
db 50 00

a100
mov ah, 09
mov dx, 700
int 21
mov bx, 0
mov cx, 200
mov ah, 3f
mov dx, 790
int 21

a150
mov bx, 790
mov si, 0
jmp 250

a250
mov al, [bx+si]
mov byte [750], al
cmp al, 20
jl 490
and al, 4d
jp 300
jmp 320

a300
mov byte [bx+si], 34
inc si
jmp 250

a320
xor dl, dl
mov dl, [750]
mov byte [bx+si], dl
inc si
jmp 250

a490
mov byte [bx+si+1], 24
mov cx, si
inc cx
mov cx, si
jmp 500

a500
mov ah, 02
mov dl, [bx+cx]
int 21
dec cx
loop 500
mov ah, 4c
int 21

a700
db "Iveskite teksta " 0A 0D "$"

n lab1.com
r cx
1000
w
q
