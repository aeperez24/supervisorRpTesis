clear all
close all
global tiempo PMnivelBajo PMnivelMedio PMnivelAlto nivelPM estadoPm T1 T6 T11 T12 T13 T15 parametroTemporizadorPm1 parametroTemporizadorPm2 parametroTemporizadorPm3 parametroTemporizadorPm4;%globales del controlador de premezcla
global ljHandle
%inicializacion
%tiempos

ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file
[Error ljHandle] = ljud_OpenLabJack(LJ_dtU3,LJ_ctUSB,'1',1); % Returns ljHandle for open LabJack
Error_Message(Error)

tiempo      =   0;
tsimulacion     =   50;

%localizacion de los sensores
% PMnivelBajo     =   2;
% PMnivelMedio    =   10;
% PMnivelAlto     =   16;
 PMnivelBajo     =   1;
 PMnivelMedio    =   8;
 PMnivelAlto     =   16;
%fin localizacion de los sensores

VPmAgT=0;
BPmMoAgT=0;
VIAg6=0;





addpath('RealTime_Pacer');


set_param('proceso_simulacion_1', 'SimulationCommand', 'start');
set_param('proceso_simulacion_1', 'SimulationCommand', 'pause');
%fin de la inicializacion

while(tiempo<tsimulacion)

    set_param('proceso_simulacion_1', 'SimulationCommand', 'continue');
    pause(0.1);
    set_param('proceso_simulacion_1', 'SimulationCommand', 'pause');
    [tiempo nivelPM nivelAG]=  lectura_sistema();%obtiene todos los valores del sistema
 

    %escritura_salida();%escribe el  valor de los sensores sobre la labjack
    [SLPM0  SLPM1]   =   sensores_sistema(nivelPM);%expresion del nivel de premezcla en dos bits
    escritura_salida(SLPM0,SLPM1);%escritura del sensor sobre la labjack
    [VIPm1  VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=lectura_entrada();%lectura se�al del plc sobre el labjack
    escritura_sistema(VIPm1,VIPm4a ,VIPm4b  ,VIPm6  , VOPm1,   VOPm2,BPmMoAgT,VPmAgT,0,0,0,0,0,0,0,VIAg6,0,0,0,0,0,0);%ejecucion de la accion del plc sobre el sistema
   
%    if(tiempo>=14)
%        T15=1;
%        
%     VPmAgT=1;
%     BPmMoAgT=1;
%     VIAg6=1;
%    end



%     %inicio envio a lookout%
%     enviaralookout('mimico','Pm',nivelPM);
%     enviaralookout('mimico','VIPm1',VIPm1);
%     enviaralookout('mimico','VIPm4a',VIPm4a);
%     enviaralookout('mimico','VIPm4b',VIPm4b);
%     enviaralookout('mimico','VIAg1',VIAg1);
%     enviaralookout('mimico','VIAg2',VIAg2);
%     enviaralookout('mimico','VIAg3',VIAg3);
%     enviaralookout('mimico','VIAg4',VIAg4);
%     enviaralookout('mimico','VIAg5',VIAg5);
%     enviaralookout('mimico','VIAg6',VIAg6);
%     enviaralookout('mimico','VIAg7',VIAg7);
%     enviaralookout('mimico','VIAg8',VIAg8);
%     enviaralookout('mimico','VOAg1',VOAg1);
%     enviaralookout('mimico','VOAg2',VOAg2);
%     enviaralookout('mimico','MAg',MAg);
%     enviaralookout('mimico','BOAg',BOAg);
%     
    figure(1)
    hold on
    plot(tiempo,nivelPM);
    drawnow;
    figure(2)
    hold on
    plot(tiempo,nivelAG);
    drawnow;
    
    
end




 set_param('proceso_simulacion_1', 'SimulationCommand', 'stop');
    
