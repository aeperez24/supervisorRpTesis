clc
clear all
close all


ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file
[Error ljHandle] = ljud_OpenLabJack(LJ_dtU3,LJ_ctUSB,'1',1); % Returns ljHandle for open LabJack
Error_Message(Error) % Check for and display any Errros

%Start by using the pin_configuration_reset IOType so that all
%pin assignments are in the factory default condition.
[Error] = ljud_ePut(ljHandle, LJ_ioPIN_CONFIGURATION_RESET, 0, 0, 0);
Error_Message(Error)




global A R u;
A=0.22
R=10
u=0

x0=0
tsim=100000
acum=0;
T=0.5%muestreo
tt=[]
xx=[]
tt2=[]
xx2=[]
minimo=25;
maximo=40;
S_minimo=0;
S_maximo=0;

    while(acum<tsim)
    tspan=[acum acum+T ];
    [t,x] = ode23('edif',tspan,x0);
    acum=acum+T;
    tt=[tt;t(length(t))];
    xx=[xx;x(length(x))];
    x0=xx(length((xx)));
    
    if x0<minimo
        S_minimo=0;
        else
            S_minimo=1;
    end;
    if x0>=maximo
        S_maximo=1;
        else
            S_maximo=0;
    end;
    
    %escribir salida S_minimo
    if S_minimo==1 
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 3.3, 0 );
        Error_Message(Error)
    else
        [DAC0] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 0, 0, 0 );
        Error_Message(Error)
    end
    
    %escribir salida de S_maximo
     if S_maximo==1 
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 1, 3.3, 0 );
        Error_Message(Error)
    else
        [DAC1] = ljud_ePut ( ljHandle, LJ_ioPUT_DAC, 1, 0, 0 );
        Error_Message(Error)
    end
    
    
    
        
    
    
    
    
    
    %leer entrada
    [Error entrada] = ljud_eGet(ljHandle,LJ_ioGET_AIN,2,0,0);
    Error_Message(Error)
    
    
    
    if entrada>=1.5
        u=1;
        
       else
        u=0;
    end
    
    pause(T);
   
    plot(tt,xx,'r')
    drawnow
  
    end
  
    

