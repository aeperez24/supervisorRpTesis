%controladores de la premezcla 
function [VIPm1 VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=controlPm()
global tiempo nivelPM estadoPm T1 T2 T3 T4 T5 T6 T7 T8 T9 T10 T11;%transiciones
%T1 T6 T11 T12 T13 T16 transiciones externas 
global temporizadorPm1 temporizadorPm2 temporizadorPm3 temporizadorPm4 limiteTemporizadorPm;%temporizadores
global SLPM0  SLPM1;%valores de los sensores de nivel en el tanque de premezcla 
global parametroTemporizadorPm1 parametroTemporizadorPm2 parametroTemporizadorPm3 parametroTemporizadorPm4;%tiempo pre-establecido de los temporizadores.

VIPm1=0;
VIPm4a=0;
VIPm4b=0;
VIPm6=0;
VOPm1=0;
VOPm2=0;


%inicio  transicion de estados
if(~estadoPm(1)&&~estadoPm(2)&&~estadoPm(3)&&~estadoPm(4)&&~estadoPm(5)&&~estadoPm(6)&&~estadoPm(7)&&~estadoPm(8)&&~estadoPm(9))
estadoPm(1)=1;
%T1=0;
T2=0;
T3=0;
%T4=0;
%T5=0;
T6=0;
T7=0;
%T8=0;
%T9=0;
T10=0;
%T11=0;
temporizadorPm1=0;temporizadorPm2=0;temporizadorPm3=0;temporizadorPm4=0;
limiteTemporizadorPm=0;
end
    %inicio premezcla color blanco
if(estadoPm(1)&&T1)

estadoPm(2)=1;
estadoPm(1)=0;
end
if(estadoPm(2)&&T2)
estadoPm(3)=1;
estadoPm(2)=0;
end
if(estadoPm(3)&&T3)
estadoPm(4)=1;
estadoPm(3)=0;
end
if(estadoPm(4)&&T4)
estadoPm(1)=1;
estadoPm(4)=0;
end
    %fin de premezcla  blanco
    %inicio premezcla color
    


if(estadoPm(1)&&T5)

estadoPm(5)=1;

estadoPm(1)=0;

end



if(estadoPm(5)&&T6)

estadoPm(6)=1;

estadoPm(5)=0;

end



if(estadoPm(6)&&T7)

estadoPm(7)=1;

estadoPm(6)=0;
end


if(estadoPm(7)&&T8)

estadoPm(1)=1;

estadoPm(7)=0;
end



%fin premezcla color

%inicio de vaciado
if(estadoPm(1)&&T9)
estadoPm(8)=1;
estadoPm(1)=0;

end
if(estadoPm(8)&&T10)
estadoPm(8)=0;
estadoPm(9)=1;


end

if(estadoPm(9)&&T11)
estadoPm(9)=0;
estadoPm(1)=1;


end



%fin de vaciado


%fin transiciones de estados

%Acciones 
[SLPM0  SLPM1]   =   sensores_sistema(nivelPM);

if(estadoPm(1))
temporizadorPm1=0;temporizadorPm2=0;temporizadorPm3=0;temporizadorPm4=0;T4=0;T8=0;T11=0;

end

if(estadoPm(2))
    if(~temporizadorPm1)
    temporizadorPm1=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm1;
    T1=0;
    end
    VIPm1=1;
end

if(estadoPm(3))
    if(~temporizadorPm2)
    temporizadorPm2=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm2;
  

    end
      VIPm4a=1;
end

if(estadoPm(4))

end
if(estadoPm(5))
    if(~temporizadorPm3)
    temporizadorPm3=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm3;
    T5=0;
    end
    

    VIPm1=1;
    
end
if(estadoPm(6))
    if(~temporizadorPm4)

    temporizadorPm4=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm4;

    end
    
VIPm4b=1;
end
if(estadoPm(7))
end


if(estadoPm(8))
VOPm2=1;
T9=0;
end
if(estadoPm(9))

end


%validacion  de transiciones  
T2=0; T3=0; T6=0; T7=0 ; T10=0;

if(temporizadorPm1==1 && tiempo>=limiteTemporizadorPm)
    T2=1;
   temporizadorPm1=0; 
    
end

if(temporizadorPm2&&tiempo>=limiteTemporizadorPm)
    T3=1;
   temporizadorPm2=0; 
    
end


if(temporizadorPm3&&tiempo>=limiteTemporizadorPm)
    T6=1;
   temporizadorPm3=0; 
    
end





if(temporizadorPm4&&tiempo>=limiteTemporizadorPm)
    T7=1;
   temporizadorPm4=0; 
    
end


if(~SLPM0&&~SLPM1)
   T10=1;
end


%fin validacion de transiciones

