%controladores de la premezcla 
function [VIAg1 VIAg2  VIAg3 VIAg4 VIAg5 VIAg6 VIAg7 VIAg8    VOAg1   VOAg2 MAg BoAg]=controlAg() 
global tiempo nivelAG estadoAg tag1 tag2 tag3 tag4 tag5 tag6 tag7 tag8 tag9 tag10 tag11 tag12 tag13 tag14 tag15 tag16 tag17 tag18 tag19 tag20 tag21 tag22 tag23 tag24 tag25 tag26 tag27 tag28 tag29 tag30 tag31 tag32 tag33 tag34 tag35 tag36 tag37 tag38 tag39 tag40 tag41 tag42 tag43 tag44;%transiciones
global temporizadorAg1 temporizadorAg2 temporizadorAg3 temporizadorAg4 temporizadorAg5 temporizadorAg6 temporizadorAg7 temporizadorAg8 temporizadorAg9 temporizadorAg10 temporizadorAg11 temporizadorAg12 temporizadorAg13  limiteTemporizadorAg;%temporizadores
global SLAg0  SLAg1;%valores de los sensores de nivel en el tanque de Agitado
global parametroTemporizadorAg1 parametroTemporizadorAg2 parametroTemporizadorAg3 parametroTemporizadorAg4 parametroTemporizadorAg5 parametroTemporizadorAg6 parametroTemporizadorAg7 parametroTemporizadorAg8 parametroTemporizadorAg9 parametroTemporizadorAg10 parametroTemporizadorAg11 parametroTemporizadorAg12 parametroTemporizadorAg13;%tiempo pre-establecido de los temporizadores.

VIAg1=0;
VIAg2=0;
VIAg3=0;
VIAg4=0;
VIAg5=0;
VIAg6=0;
VIAg7=0;
VIAg8=0;
VOAg1=0;
VOAg2=0;
MAg=0;
BoAg=0;



[SLAg0  SLAg1]   =   sensores_sistema_Ag(nivelAG);
%inicio transicion entre estados%
if(~estadoAg(1)&&~estadoAg(2)&&~estadoAg(3)&&~estadoAg(4)&&~estadoAg(5)&&~estadoAg(6)&&~estadoAg(7)&&~estadoAg(8)&&~estadoAg(9)&&~estadoAg(10)&&~estadoAg(11)&&~estadoAg(12)&&~estadoAg(13)&&~estadoAg(14)&&~estadoAg(15)&&~estadoAg(16)&&~estadoAg(17)&&~estadoAg(18)&&~estadoAg(19)&&~estadoAg(20)&&~estadoAg(21)&&~estadoAg(22)&&~estadoAg(23)&&~estadoAg(24)&&~estadoAg(25)&&~estadoAg(26)&&~estadoAg(27)&&~estadoAg(28)&&~estadoAg(29)&&~estadoAg(30)&&~estadoAg(31)&&~estadoAg(32)&&~estadoAg(33)&&~estadoAg(34)&&~estadoAg(35)&&~estadoAg(36)&&~estadoAg(37)&&~estadoAg(38)&&~estadoAg(39)&&~estadoAg(40)&&~estadoAg(41)&&~estadoAg(42))
estadoAg(1)=1;
%tag1=0;
tag2=0;
tag3=0;
tag4=0;
tag5=0;
tag6=0;
tag7=0;
%tag8=0;
%tag9=0;
tag10=0;
tag11=0;
tag12=0;
tag13=0;
tag14=0;
tag15=0;
tag16=0;
%tag17=0;
tag18=0;
tag19=0;
tag20=0;
tag21=0;
tag22=0;
tag23=0;
%tag24=0;
tag25=0;
tag26=0;
tag27=0;
tag28=0;
tag29=0;
tag30=0;
tag31=0;
%tag32=0;
tag33=0;
tag34=0;
tag35=0;
%tag36=0;
tag37=0;
tag38=0;
%tag39=0;
% tag40=0;
% tag41=0;
% tag42=0;
% tag43=0;
% tag44=0;
end
%llenado y agitado blanco lote completo%
if(estadoAg(1)&&tag1)
    estadoAg(1)=0;
    estadoAg(2)=1;
    
end

if(estadoAg(2)&&tag39)
    estadoAg(2)=0;
    estadoAg(3)=1;
    
end

if(estadoAg(3)&&tag2)
    estadoAg(3)=0;
    estadoAg(4)=1;
    
end
if(estadoAg(4)&&tag3)
    estadoAg(4)=0;
    estadoAg(5)=1;
    
end
if(estadoAg(5)&&tag4)
    estadoAg(5)=0;
    estadoAg(6)=1;
    
end

if(estadoAg(6)&&tag5)
    estadoAg(6)=0;
    estadoAg(7)=1;
    
end

if(estadoAg(7)&&tag6)
    estadoAg(7)=0;
    estadoAg(8)=1;
    
end

if(estadoAg(8)&&tag7)
    estadoAg(8)=0;
    estadoAg(9)=1;
    
end


if(estadoAg(9)&&tag8)
    estadoAg(9)=0;
    estadoAg(1)=1;
    
end

%llenado  y agitado color lote completo%
if(estadoAg(1)&&tag9)
    estadoAg(1)=0;
    estadoAg(10)=1;
    
end
if(estadoAg(10)&&tag39)
    estadoAg(10)=0;
    estadoAg(11)=1;
    
end

if(estadoAg(11)&&tag10)
    estadoAg(11)=0;
    estadoAg(12)=1;
    
end


if(estadoAg(12)&&tag11)
    estadoAg(12)=0;
    estadoAg(13)=1;
    
end

if(estadoAg(13)&&tag12)
    estadoAg(13)=0;
    estadoAg(14)=1;
    
end

if(estadoAg(14)&&tag13)
    estadoAg(14)=0;
    estadoAg(15)=1;
    
end

if(estadoAg(15)&&tag14)
    estadoAg(15)=0;
    estadoAg(16)=1;
    
end

if(estadoAg(16)&&tag15)
    estadoAg(16)=0;
    estadoAg(17)=1;
    
end

if(estadoAg(17)&&tag16)
    estadoAg(17)=0;
    estadoAg(18)=1;
    
end


if(estadoAg(18)&&tag40)
    estadoAg(18)=0;
    estadoAg(1)=1;
    
end
%llenado y agitado blanco medio lote

if(estadoAg(1)&&tag17)
    estadoAg(1)=0;
    estadoAg(19)=1;
end

if(estadoAg(19)&&tag39)
    estadoAg(19)=0;
    estadoAg(20)=1;
end
if(estadoAg(20)&&tag18)
    estadoAg(20)=0;
    estadoAg(21)=1;
end
if(estadoAg(21)&&tag19)
    estadoAg(21)=0;
    estadoAg(22)=1;
end

if(estadoAg(22)&&tag20)
    estadoAg(22)=0;
    estadoAg(23)=1;
end
if(estadoAg(23)&&tag21)
    estadoAg(23)=0;
    estadoAg(24)=1;
end
if(estadoAg(24)&&tag22)
    estadoAg(24)=0;
    estadoAg(25)=1;
end
if(estadoAg(25)&&tag23)
    estadoAg(25)=0;
    estadoAg(26)=1;
end

if(estadoAg(26)&&tag41)
    estadoAg(26)=0;
    estadoAg(1)=1;
end


%llenado y agitado medio lote pintura color%
if(estadoAg(1)&&tag24)
    estadoAg(1)=0;
    estadoAg(27)=1;
end

if(estadoAg(27)&&tag39)
    estadoAg(27)=0;
    estadoAg(28)=1;
end

if(estadoAg(28)&&tag25)
    estadoAg(28)=0;
    estadoAg(29)=1;
end

if(estadoAg(29)&&tag26)
    estadoAg(29)=0;
    estadoAg(30)=1;
end

if(estadoAg(30)&&tag27)
    estadoAg(30)=0;
    estadoAg(31)=1;
end

if(estadoAg(31)&&tag28)
    estadoAg(31)=0;
    estadoAg(32)=1;
end

if(estadoAg(32)&&tag29)
    estadoAg(32)=0;
    estadoAg(33)=1;
end

if(estadoAg(33)&&tag30)
    estadoAg(33)=0;
    estadoAg(34)=1;
end

if(estadoAg(34)&&tag31)
    estadoAg(34)=0;
    estadoAg(35)=1;
end



if(estadoAg(35)&&tag42)
    estadoAg(35)=0;
    estadoAg(1)=1;
end






%vaciado del agitador %


if(estadoAg(1)&&tag32)
    estadoAg(1)=0;
    estadoAg(36)=1;
end


if(estadoAg(36)&&tag33)
    estadoAg(36)=0;
    estadoAg(37)=1;
end


if(estadoAg(37)&&tag34)
    estadoAg(37)=0;
    estadoAg(38)=1;
end


if(estadoAg(38)&&tag35)
    estadoAg(38)=0;
    estadoAg(39)=1;
end



if(estadoAg(39)&&tag43)
    estadoAg(39)=0;
    estadoAg(1)=1;
end

%limpieza en el agitador%


if(estadoAg(1)&&tag36)
    estadoAg(1)=0;
    estadoAg(40)=1;
end



if(estadoAg(40)&&tag37)
    estadoAg(40)=0;
    estadoAg(41)=1;
end

if(estadoAg(41)&&tag38)
    estadoAg(41)=0;
    estadoAg(42)=1;
end


if(estadoAg(42)&&tag44)
    estadoAg(42)=0;
    estadoAg(1)=1;
end




%acciones%

% llenado y agitado blanco lote completo %
if(estadoAg(1))
    tag8=0;tag39=0;tag40=0;tag41=0;tag42=0;tag43=0;tag44=0;
 
    temporizadorAg1=0;temporizadorAg2=0;temporizadorAg3=0;
    temporizadorAg4=0;temporizadorAg5=0;temporizadorAg6=0;
    temporizadorAg7=0;temporizadorAg8=0;temporizadorAg9=0;
    temporizadorAg10=0;temporizadorAg11=0;temporizadorAg12=0;
    temporizadorAg13=0;limiteTemporizadorAg=0;

end


if(estadoAg(2))

VIAg6=1;
tag1=0;
end
if(estadoAg(3))
    if(~temporizadorAg1)
        temporizadorAg1=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg1;
    
    end
    VIAg1=1;
end
if(estadoAg(4))
    if(~temporizadorAg2)
        temporizadorAg2=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg2;
    end
     VIAg2=1;
    
end

if(estadoAg(5))
    if(~temporizadorAg3)
        temporizadorAg3=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg3;
    end
     VIAg3=1;
    
end


if(estadoAg(6))
    if(~temporizadorAg4)
        temporizadorAg4=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg4;
    end
     VIAg4=1;
    
end

if(estadoAg(7))
    if(~temporizadorAg5)
        temporizadorAg5=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg5;
    end
     VIAg5=1;
    
end



if(estadoAg(8))
    if(~temporizadorAg6)
        temporizadorAg6=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg6;
    end
     MAg=1;
    
end

if(estadoAg(9))
    
end
%fin de llenado y agitado blanco lote completo%
%llenado y agitado color lote completo%

if(estadoAg(10))

VIAg6=1;
tag9=0;
end

if(estadoAg(11))
    if(~temporizadorAg7)
        temporizadorAg7=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg7;
    
    end
    VIAg1=1;
end

if(estadoAg(12))
    if(~temporizadorAg8)
        temporizadorAg8=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg8;
    end
    VIAg2=1;
end


if(estadoAg(13))
    if(~temporizadorAg9)
        temporizadorAg9=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg9;
    end
    VIAg3=1;
end


if(estadoAg(14))
    if(~temporizadorAg10)
        temporizadorAg10=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg10;
    end
    VIAg4=1;
end


if(estadoAg(15))
    if(~temporizadorAg11)
        temporizadorAg11=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg11;
    end
    VIAg5=1;
end


if(estadoAg(16))
    if(~temporizadorAg12)
        temporizadorAg12=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg12;
    end
    VIAg8=1;
end

if(estadoAg(17))

    if(~temporizadorAg13)
        temporizadorAg13=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg13;
    end
    MAg=1;
end
if(estadoAg(18))

end


%fin pintura a color lote completo%

%pintura blanca medio lote%

if(estadoAg(19))

VIAg6=1;
tag17=0;
end

if(estadoAg(20))
    if(~temporizadorAg1)
        temporizadorAg1=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg1/2;
    
    end
    VIAg1=1;
end



if(estadoAg(21))
    if(~temporizadorAg2)
        temporizadorAg2=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg2/2;
    end
     VIAg2=1;
    
end

if(estadoAg(22))
    if(~temporizadorAg3)
        temporizadorAg3=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg3/2;
    end
     VIAg3=1;
    
end


if(estadoAg(23))
    if(~temporizadorAg4)
        temporizadorAg4=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg4/2;
    end
     VIAg4=1;
    
end

if(estadoAg(24))
    if(~temporizadorAg5)
        temporizadorAg5=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg5/2;
    end
     VIAg5=1;
    
end



if(estadoAg(25))
    if(~temporizadorAg6)
        temporizadorAg6=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg6/2;
    end
     MAg=1;
    
end

if(estadoAg(26))

end
%fin pintura blanca medio lote%

%pintura color medio lote%

if(estadoAg(27))
VIAg6=1;
tag24=0;
end
if(estadoAg(28))
    if(~temporizadorAg7)
        temporizadorAg7=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg7/2;
    
    end
    VIAg1=1;
end

if(estadoAg(29))
    if(~temporizadorAg8)
        temporizadorAg8=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg8/2;
    end
    VIAg2=1;
end


if(estadoAg(30))
    if(~temporizadorAg9)
        temporizadorAg9=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg9/2;
    end
    VIAg3=1;
end


if(estadoAg(31))
    if(~temporizadorAg10)
        temporizadorAg10=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg10/2;
    end
    VIAg4=1;
end


if(estadoAg(32))
    if(~temporizadorAg11)
        temporizadorAg11=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg11/2;
    end
    VIAg5=1;
end


if(estadoAg(33))
    if(~temporizadorAg12)
        temporizadorAg12=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg12/2;
    end
    VIAg8=1;
end

if(estadoAg(34))

    if(~temporizadorAg13)
        temporizadorAg13=1;
        limiteTemporizadorAg=tiempo+parametroTemporizadorAg13/2;
    end
    MAg=1;
    
end

if(estadoAg(35))
end
%fin pintura a color medio lote%
%vaciado %
if(estadoAg(36))
tag32=0;
VOAg2=1;
end

if(estadoAg(37))

VOAg2=1;
BoAg=1;
end

if(estadoAg(38))

VOAg2=0;
end

if(estadoAg(39))

end


%fin de vaciado%
%limpieza%
if(estadoAg(40))
    VIAg7=1;
    tag36=0;
end
if(estadoAg(41))
    VIAg7=0;
    VOAg1=1;
end


if(estadoAg(42))
    
end
%fin de limpieza

%validacion de trasnsiciones transiciones% 

tag2=0;tag3=0;
tag4=0;tag5=0;
tag6=0;tag7=0;
tag10=0;tag11=0;
tag12=0;tag13=0;
tag14=0;tag15=0;
tag16=0;tag18=0;
tag19=0;tag20=0;
tag21=0;tag22=0;
tag23=0;tag25=0;
tag26=0;tag27=0;
tag28=0;tag29=0;
tag30=0;tag31=0;
tag33=0;tag34=0;
tag35=0;tag37=0;
tag38=0;

% transiciones llenado y agitado pintura blanca.

if(temporizadorAg1==1 && tiempo>=limiteTemporizadorAg)
    tag2=1;
    tag18=1;
   temporizadorAg1=0; 
    
end
if(temporizadorAg2==1 && tiempo>=limiteTemporizadorAg)
    tag3=1;
    tag19=1;
   temporizadorAg2=0; 
    
end


if(temporizadorAg3==1 && tiempo>=limiteTemporizadorAg)
    tag4=1;
    tag20=1;
   temporizadorAg3=0; 
    
end


if(temporizadorAg4==1 && tiempo>=limiteTemporizadorAg)
    tag5=1;
    tag21=1;
   temporizadorAg4=0; 
    
end


if(temporizadorAg5==1 && tiempo>=limiteTemporizadorAg)
    tag6=1;
    tag22=1;
   temporizadorAg5=0; 
    
end


if(temporizadorAg6==1 && tiempo>=limiteTemporizadorAg)
    tag7=1;
    tag23=1;
   temporizadorAg6=0; 
    
end

%fin llenado pintura blanca%
%pintura color%
if(temporizadorAg7==1 && tiempo>=limiteTemporizadorAg)
    tag10=1;
    tag25=1;
   temporizadorAg7=0; 
    
end

if(temporizadorAg8==1 && tiempo>=limiteTemporizadorAg)
    tag11=1;
     tag26=1;
   temporizadorAg8=0; 
    
end
if(temporizadorAg9==1 && tiempo>=limiteTemporizadorAg)
    tag12=1;
     tag27=1;
   temporizadorAg9=0; 
    
end
if(temporizadorAg10==1 && tiempo>=limiteTemporizadorAg)
    tag13=1;
     tag28=1;
   temporizadorAg10=0; 
    
end
if(temporizadorAg11==1 && tiempo>=limiteTemporizadorAg)
    tag14=1;
     tag29=1;
   temporizadorAg11=0; 
    
end
if(temporizadorAg12==1 && tiempo>=limiteTemporizadorAg)
    tag15=1;
     tag30=1;
   temporizadorAg12=0; 
    
end
if(temporizadorAg13==1 && tiempo>=limiteTemporizadorAg)
    tag16=1;
    tag31=1;

   temporizadorAg13=0; 
    
end

%fin pintura color

%vaciado%

if(VOAg2)
    tag33=1;

end
if(~SLAg0&&~SLAg1)
tag34=1;
end
if(~VOAg2)
tag35=1;
end
%fin de vaciado%
%limpieza


if(SLAg0&&SLAg1)
tag37=1;
end


if(~SLAg0&&~SLAg1)
tag38=1;
end
%fin limpieza
%fin validacion de transiciones
%fin controlador
end