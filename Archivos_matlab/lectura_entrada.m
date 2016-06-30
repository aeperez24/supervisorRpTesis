function [FIO0 FIO1 FIO2 FIO3 FIO4 FIO5]=lectura_entrada()
global ljHandle;
addpath('librerias');
ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file


[Error AIN0] = ljud_eGet(ljHandle,LJ_ioGET_AIN,0,0,0);
if(AIN0>=3)
    FIO0=1;
else
    FIO0=0;
end


[Error AIN1] = ljud_eGet(ljHandle,LJ_ioGET_AIN,1,0,0);
if(AIN1>=3)
    FIO1=1;
else
    FIO1=0;
end


[Error AIN2] = ljud_eGet(ljHandle,LJ_ioGET_AIN,2,0,0);
if(AIN2>=3)
    FIO2=1;
else
    FIO2=0;
end


[Error AIN3] = ljud_eGet(ljHandle,LJ_ioGET_AIN,3,0,0);
if(AIN3>=3)
    FIO3=1;
else
    FIO3=0;
end


[Error FIO4] = ljud_eGet(ljHandle,LJ_ioGET_DIGITAL_BIT,4,0,0);
Error_Message(Error)


[Error FIO5] = ljud_eGet(ljHandle,LJ_ioGET_DIGITAL_BIT,5,0,0);
Error_Message(Error)

[Error FIO6] = ljud_eGet(ljHandle,LJ_ioGET_DIGITAL_BIT,6,0,0);
Error_Message(Error)

[Error FIO7] = ljud_eGet(ljHandle,LJ_ioGET_DIGITAL_BIT,7,0,0);
Error_Message(Error)
