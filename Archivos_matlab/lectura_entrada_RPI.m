function [BPmMoAgT VPmAgT VPmMoT BMoAgT VMoAgT VIT1 VOT1 Mmo]=lectura_entrada_RPI()
global ljHandle2;
addpath('librerias');
ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file

BPmMoAgT=0;
VPmAgT=0;
VPmMoT=0;
BMoAgT=0;
VMoAgT=0;
VIT1=0;
VOT1=0;
Mmo=0;

[Error FIO4] = ljud_eGet(ljHandle2,LJ_ioGET_DIGITAL_BIT,4,0,0);
Error_Message(Error)


[Error FIO5] = ljud_eGet(ljHandle2,LJ_ioGET_DIGITAL_BIT,5,0,0);
Error_Message(Error)

[Error FIO6] = ljud_eGet(ljHandle2,LJ_ioGET_DIGITAL_BIT,6,0,0);
Error_Message(Error)

if(FIO4)
    BPmMoAgT =1;
    VPmAgT=1;
    

end
if(FIO5)
    BPmMoAgT =1;
    VPmMoT=1;
    Mmo=1;
    VMoAgT=1;
    BMoAgT=1;
    
end


if(FIO6)
    
    
    BPmMoAgT =1;
    VPmMoT=1;
    VMoAgT=1;
    BMoAgT=1;
    VIT1=1;
    VOT1=1;
    
    
end