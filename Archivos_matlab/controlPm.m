%controladores de la premezcla 
function [VIPm1 VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=controlPm()
global tiempo nivelPM estadoPm T1 T2 T3 T4 T5 T6 T7 T8 T9 T10 T11 T12 T13 T14 T15 T16 T17 T18 T19 T20 T21 T22 T23;%transiciones
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
if(~estadoPm(1)&&~estadoPm(2)&&~estadoPm(3)&&~estadoPm(4)&&~estadoPm(5)&&~estadoPm(6)&&~estadoPm(7)&&~estadoPm(8)&&~estadoPm(9)&&~estadoPm(10)&&~estadoPm(11)&&~estadoPm(12)&&~estadoPm(13)&&~estadoPm(14)&&~estadoPm(15)&&~estadoPm(16)&&~estadoPm(17)&&~estadoPm(18))
estadoPm(1)=1;
%T1=0;%transicion externa inicio base blanca lote completo
T2=0;
T3=0;
%T4=0;%transicion externa fin base blanca lote completo
%T5=0;%transicion externa inicio base color lote completo
T6=0;
T7=0;
%T8=0;%transicion externa fin base color lote completo
%T9=0;%transicion externa inicio vaciado
T10=0;
%T11=0;%transicion externa fin de vaciado
%T12=0;%transicion externa inicio limpieza
T13=0;
T14=0;
%T15=0;%transicion externa fin de limpieza
%T16=0;%transicion externa inicio de base banca medio lote 
T17=0;
T18=0;
%T19=0;%transicion externa fin de base blanca medio lote 
%T20=0;%transicion externa inicio base color medio lote 
T21=0;
T22=0;
%T23=0%transicion externa fin base color medio lote 

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


%inicio de limpieza premezcla:

if(estadoPm(1)&&T12)
estadoPm(1)=0;
estadoPm(10)=1;
end

if(estadoPm(10)&&T13)
    estadoPm(10)=0;
    estadoPm(11)=1;
end

if(estadoPm(11)&&T14)
    estadoPm(11)=0;
    estadoPm(12)=1;
end

if(estadoPm(12)&&T15)
estadoPm(12)=0;
estadoPm(1)=0;

end
%fin limpieza premezcla

%inicio medio lote pintura blanca
if(estadoPm(1)&&T16)
    estadoPm(1)=0;
    estadoPm(13)=1;
end

if(estadoPm(13)&&T17)
    estadoPm(13)=0;
    estadoPm(14)=1;
end

if(estadoPm(14)&&T18)
    estadoPm(14)=0;
    estadoPm(15)=1;
end

if(estadoPm(15)&&T19)
    estadoPm(15)=0;
    estadoPm(1)=1;
end


%fin medio lote pintura blanca



%inicio medio lote pintura color%

if(estadoPm(1)&&T20)
    estadoPm(1)=0;
    estadoPm(16)=1;
    

end

if(estadoPm(16)&&T21)
    estadoPm(16)=0;
    estadoPm(17)=1;

end

if(estadoPm(17)&&T22)
    estadoPm(17)=0;
    estadoPm(18)=1;
end

if(estadoPm(18)&&T23)
    estadoPm(18)=0;
    estadoPm(1)=1;
end




%fin medio lote pintura color%




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

if(estadoPm(10))
    T12=0;
    VIPm6=1;
end
if(estadoPm(11))
VOPm1=1;
end
if(estadoPm(12))

end


if(estadoPm(13))

    if(~temporizadorPm1)
    temporizadorPm1=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm1/2;
    T16=0;
    end
    VIPm1=1;
end




if(estadoPm(14)) 
    if(~temporizadorPm2)
    temporizadorPm2=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm2/2;
  

    end
      VIPm4a=1;

end

if(estadoPm(15))
end



if(estadoPm(16))
    if(~temporizadorPm3)
    temporizadorPm3=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm3/2;
    T20=0;
    end
    

    VIPm1=1;
    
end


if(estadoPm(17))
    if(~temporizadorPm4)

    temporizadorPm4=1;
    limiteTemporizadorPm=tiempo+parametroTemporizadorPm4/2;

    end
    
VIPm4b=1;
end



if(estadoPm(18))

end
%validacion  de transiciones  
T2=0; T3=0; T6=0; T7=0 ; T10=0;T13=0;T14=0;T17=0;T18=0;T21=0;T22=0;

if(temporizadorPm1==1 && tiempo>=limiteTemporizadorPm)
    T2=1;
    T17=1;
    temporizadorPm1=0; 
    
end

if(temporizadorPm2&&tiempo>=limiteTemporizadorPm)
    T3=1;
    T18=1;
   temporizadorPm2=0; 
    
end


if(temporizadorPm3&&tiempo>=limiteTemporizadorPm)
    T6=1;
    T21=1;
    temporizadorPm3=0; 
    
end





if(temporizadorPm4&&tiempo>=limiteTemporizadorPm)
    T7=1;
    T22=1;
   temporizadorPm4=0; 
    
end


if(~SLPM0&&~SLPM1)
   T10=1;
end



if(SLPM0&&SLPM1)
   T13=1;
end


if(~SLPM0&&~SLPM1)
   T14=1;
end





%fin validacion de transiciones

