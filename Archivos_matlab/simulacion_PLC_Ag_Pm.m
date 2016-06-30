clear all
close all
addpath('RealTime_Pacer');
addpath('librerias');

global tiempo PMnivelBajo PMnivelMedio PMnivelAlto nivelPM estadoPm T1 T4 T5 T8 T9 T11 parametroTemporizadorPm1 parametroTemporizadorPm2 parametroTemporizadorPm3 parametroTemporizadorPm4;%globales del controlador de premezcla
global ljHandle;
global ljHandle2;
global estadoAg;
global SLAg0  SLAg1;%valores de los sensores de nivel en el tanque de Agitado
global parametroTemporizadorAg1 parametroTemporizadorAg2 parametroTemporizadorAg3 parametroTemporizadorAg4 parametroTemporizadorAg5 parametroTemporizadorAg6 parametroTemporizadorAg7 parametroTemporizadorAg8 parametroTemporizadorAg9 parametroTemporizadorAg10 parametroTemporizadorAg11 parametroTemporizadorAg12 parametroTemporizadorAg13;%tiempo pre-establecido de los temporizadores.
global tag1 tag8 tag9 tag17 tag24 tag32 tag36 tag39 tag40 tag41 tag42 tag43
%tag1   inicio agitado de pintura blanca lote completo
%tag8   fin agitado de pintura bllanca lote completo
%tag9   inicio agitado de pintura marron lote completo
%tag17  inicio agitado de pintura blanca medio lote
%tag24  inicio agitado de pintura marron medio lote
%tag32  inicio de vaciado en el agitador
%tag36  inicio de limpieza en el agiitador
%tag39  continuacion en el agitado luegoo de haber recibido materia de
        %premezcla
%tag40  fin de agitado pintura marron lote completo
%tag41  fin de agitado pintura blanca medio lote
%tag42  fin de agitado pintura marron medio lote 
%tag43  fin de vaciado
%tag44  fin de limpieza

global AgnivelBajo  AgnivelMedio AgnivelAlto nivelAG;    
global Pmcolor Agcolor;
global VPmMoT BPmMoAgT VPmAgT  BMoAgT VMoAgT;
global  VIPm1  VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2 VIAg1 VIAg2  VIAg3 VIAg4 VIAg5 VIAg6 VIAg7 VIAg8    VOAg1   VOAg2;

ljud_LoadDriver; % Loads LabJack UD Function Library
ljud_Constants; % Loads LabJack UD constant file

% [Error ljHandle] = ljud_OpenLabJack(LJ_dtU3,LJ_ctUSB,'1',0); % Returns ljHandle for open LabJack
% ljHandle
% Error_Message(Error)
% 

[Error ljHandle2] = ljud_OpenLabJack(LJ_dtU3,LJ_ctUSB,'2',0); % Returns ljHandle for open LabJack
ljHandle2
Error_Message(Error)


%inicializacion
%tiempos


tiempo      =   0;
tsimulacion     =   80;

%localizacion de los sensores

 PMnivelBajo     =   0.4;
 PMnivelMedio    =   2;
 PMnivelAlto     =   4;
 
 AgnivelBajo    =   0.4;
 AgnivelMedio   =   4;
 AgnivelAlto    =   8;
%fin localizacion de los sensores
%variables de transporte y molienda

BPmMoAgT=0;
VIT1=0;
VOT1=0;
VPmAgT=0;
VPmMoT=0;
BMoAgT=0;
VMoAgT=0;
Mmo=0;

%transiciones Pm%
T1=0;
T4=0;
T5=0;
T8=0;
T9=0;
T11=0;

%transiciones Ag
tag1=0;
tag8=0;
tag9=0;
tag17=0;
tag24=0;
tag32=0;
tag36=0;
tag39=0;
tag40=0;
tag41=0;
tag42=0;
tag43=0;
%parametros de temporizadores premezcla
parametroTemporizadorPm1=10;
parametroTemporizadorPm2=10;
parametroTemporizadorPm3=10;
parametroTemporizadorPm4=10;

%parametros de temporizadores agitado
parametroTemporizadorAg1=5;parametroTemporizadorAg2=5;parametroTemporizadorAg3=5;
parametroTemporizadorAg4=5;parametroTemporizadorAg5=5;parametroTemporizadorAg6=5;
parametroTemporizadorAg7=5;parametroTemporizadorAg8=5;parametroTemporizadorAg9=5;
parametroTemporizadorAg10=5;parametroTemporizadorAg11=5;parametroTemporizadorAg12=5;
parametroTemporizadorAg13=5;

%estado inicial pm%
estadoPm=[0 0 0 0 0 0 0 0 0 0 0 0 0 0];
estadoAg=[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0];
Agcolor=1;
Pmcolor=1;


%inicializacion del sistema
set_param('proceso_simulacion_1', 'SimulationCommand', 'start');
set_param('proceso_simulacion_1', 'SimulationCommand', 'pause');
[tiempo nivelPM nivelAG]=  lectura_sistema()

%inicializacion controladores%
controlAg();

%fin de la inicializacion
%tag36=1;
%tag1=1;
%eliminar desde aqui
VIPm1=0; 
VIPm4a=0; 
VIPm4b=0; 
VIPm6=0; 
VOPm1=0;
VOPm2=0;
%hasta aqui
while(tiempo<tsimulacion)
    
    
    
    
    set_param('proceso_simulacion_1', 'SimulationCommand', 'continue');
    pause(0.1);
    set_param('proceso_simulacion_1', 'SimulationCommand', 'pause');
    [tiempo nivelPM nivelAG]=  lectura_sistema();%obtiene todos los valores del sistema
 

    %escritura_salida();%escribe el  valor de los sensores sobre la labjack
    [SLPM0  SLPM1]   =   sensores_sistema(nivelPM);%expresion del nivel de premezcla en dos bits
    
    %descomentar
    %escritura_salida(SLPM0,SLPM1);%escritura del sensor sobre la labjack
    
    
    
    
    %[VIPm1  VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=controlPm();%lectura señal del plc sobre el labjack
    
    %descomentar
    %[VIPm1  VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=lectura_entrada();%lectura señal del plc sobre el labjack
    
    
    [BPmMoAgT VPmAgT VPmMoT BMoAgT VMoAgT VIT1 VOT1 Mmo]=lectura_entrada_RPI();%lectura de la raspberry pi sobre el labjack
    
    
    
    %para falla
    %BPmMoAgT=0;
    
    
    [VIAg1 VIAg2  VIAg3 VIAg4 VIAg5 VIAg6 VIAg7 VIAg8    VOAg1   VOAg2 MAg BOAg]=controlAg();
    escritura_sistema(VIPm1,VIPm4a ,VIPm4b  ,VIPm6  , VOPm1,   VOPm2,BPmMoAgT,VPmAgT,VPmMoT,BMoAgT,VMoAgT,VIT1,VOT1,Mmo,VIAg1,VIAg2,VIAg3,VIAg4,VIAg5,VIAg6,VIAg7,VIAg8,VOAg1,VOAg2,MAg,BOAg);%ejecucion de la accion del plc sobre el sistema
   
    
    %coordinacion%
    
    if(tiempo>6&&tiempo<6.30) 
    %transferenica de flujo
     tag1=1;
     BPmMoAgT=1;
     VPmAgT=1;
%     
    
    end
    
    
   if(tiempo>10&&~SLPM0&&~SLPM0)
       %fin de transferencia de flujo
%        BPmMoAgT=0;
%        VPmAgT=0;
%        tag39=1;
   end
   
   
   
   
   if(tiempo>20&&tiempo<20.30)
       %inicio de llenado en el agitador
%        BPmMoAgT=0;
%        VPmAgT=0;
%        tag8=1;
   end
   
   if(tiempo>21&&tiempo<21.30)
       %inicio de llenado en el agitador
%        tag32=1;
       
   end
   
   
   
   
    %fin conrdinacion
    
    

% %     %inicio envio a lookout%

%     inicio cambio
        colorPm();
        colorAg();
        [nivelesPm nivelesAg]=aplicacionColor(Pmcolor,Agcolor);
% fin cambio




% %     %inicio envio a lookout%
    
    

    enviaralookout('mimico','Pm1',nivelesPm(1));%agua
    enviaralookout('mimico','Pm2',nivelesPm(2));%base blaca(gris)
    enviaralookout('mimico','Pm3',nivelesPm(3));%base color
    enviaralookout('mimico','Pm4',nivelesPm(4));%limpiador
    enviaralookout('mimico','Ag1',nivelesAg(1));%agua
    enviaralookout('mimico','Ag2',nivelesAg(2));%base blanca
    enviaralookout('mimico','Ag3',nivelesAg(3));%base color
    enviaralookout('mimico','Ag4',nivelesAg(4));%limpiadoor
    enviaralookout('mimico','Ag5',nivelesAg(5));%pintura blanca
    enviaralookout('mimico','Ag6',nivelesAg(6));%pintura color
    enviaralookout('mimico','Ag7',nivelesAg(7));%pintura color
    


    
    %enviaralookout('mimico','Pm',nivelPM);
    enviaralookout('mimico','VIPm1',VIPm1);
    enviaralookout('mimico','VIPm4a',VIPm4a);
    enviaralookout('mimico','VIPm4b',VIPm4b);
    enviaralookout('mimico','VIPm6',VIPm6);
    
    enviaralookout('mimico','VOPm1',VOPm1);
    enviaralookout('mimico','VOPm2',VOPm2);

    enviaralookout('mimico','BPmMoAgT',BPmMoAgT);
    enviaralookout('mimico','VPmMoT',VPmMoT);
    enviaralookout('mimico','VPmAgT',VPmAgT);
    enviaralookout('mimico','BMoAgT',BMoAgT);
    enviaralookout('mimico','VMoAgT',VMoAgT);
    enviaralookout('mimico','VIT1',VIT1);
    enviaralookout('mimico','VOT1',VOT1);
    enviaralookout('mimico','Mmo',Mmo);
    
    %enviaralookout('mimico','Ag',nivelAG);
    enviaralookout('mimico','VIAg1',VIAg1);
    enviaralookout('mimico','VIAg2',VIAg2);
    enviaralookout('mimico','VIAg3',VIAg3);
    enviaralookout('mimico','VIAg4',VIAg4);
    enviaralookout('mimico','VIAg5',VIAg5);
    enviaralookout('mimico','VIAg6',VIAg6);
    enviaralookout('mimico','VIAg7',VIAg7);
    enviaralookout('mimico','VIAg8',VIAg8);
    enviaralookout('mimico','VOAg1',VOAg1);
    enviaralookout('mimico','VOAg2',VOAg2);
    enviaralookout('mimico','MAg',MAg);
    enviaralookout('mimico','BOAg',BOAg);




%     %fin envio a lookout%



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
    
