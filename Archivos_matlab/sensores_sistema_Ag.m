function [SLAg0  SLAg1]=sensores_sistema_Ag(nivelAg)

global  AgnivelBajo AgnivelMedio AgnivelAlto;
%sensor de nivel en Ag
if nivelAg<AgnivelBajo
    SLAg0=0;
    SLAg1=0;

else
    if  nivelAg<AgnivelMedio
         SLAg0=1;
         SLAg1=0;
    else
        if nivelAg<AgnivelAlto
             SLAg0=0;
             SLAg1=1;
        else
             SLAg0=1;
             SLAg1=1;
            end
           
        end
    end
end

    