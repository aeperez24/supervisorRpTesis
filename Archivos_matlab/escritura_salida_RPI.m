function error=escritura_salida_RPI(FIO7)
global ljHandle2
ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file

Error = ljud_ePut(ljHandle2,LJ_ioPUT_DIGITAL_BIT,7,FIO7,0);
Error_Message(Error)

end
