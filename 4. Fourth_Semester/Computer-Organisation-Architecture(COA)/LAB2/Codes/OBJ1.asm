; SOMNATH SHAW
; 2241019426
; LAB 2 -> OBJECTIVE I

MOV AX, 0000H
MOV DX, AX
MOV SI, 2000H
MOV CL, [SI]
MOV CH, 50H
MOV BX, CX

L2: INC SI
    INC SI
    ADD AX, [SI]
    JNC L1
    INC CH
    
L1: DEC CL
    INC SI
    INC SI
    MOV [SI], AX
    INC SI
    INC SI
    MOV [SI], CH
    MOV DL, CH
    DIV BX
    INC SI
    INC SI  
    INC SI
    MOV [SI], DX
    HLT