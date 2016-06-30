function [SLPM0  SLPM1]=sensores_sistema(nivelPM)
global  PMnivelBajo PMnivelMedio PMnivelAlto;
%sensor de nivel en PM
if nivelPM<PMnivelBajo
    SLPM0=0;
    SLPM1=0;

else
    if  nivelPM<PMnivelMedio
         SLPM0=1;
         SLPM1=0;
    else
        if nivelPM<PMnivelAlto
             SLPM0=0;
             SLPM1=1;
        else
             SLPM0=1;
             SLPM1=1;
        end
    end
end

    