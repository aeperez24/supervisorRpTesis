function error=escritura_salida(SLPM0,SLPM1)
global ljHandle
ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file
error=1;
if ~SLPM0&&~SLPM1
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 0, 0 );
        %Error_Message(Error);
        
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC,1, 0, 0 );
        %Error_Message(Error);
        
        error=0;
elseif SLPM0&&~SLPM1
        
    
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 5, 0 );
        %Error_Message(Error);
        
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC,1, 0, 0 );
        %Error_Message(Error);
        error=0;
    elseif ~SLPM0&&SLPM1
        
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 0, 0 );
        %Error_Message(Error);
        
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC,1, 5, 0 );
        %Error_Message(Error);
        error=0
        elseif SLPM0&&SLPM1
                        
            
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 5, 0 );
        %Error_Message(Error);
        
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC,1, 5, 0 );
        %Error_Message(Error);
        error=0
    
                            end


end