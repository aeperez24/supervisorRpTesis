function [VIPm1 VIPm4a  VIPm4b  VIPm6   VOPm1   VOPm2]=control()
global tiempo

VIPm1=0;
VIPm4a=0;
VIPm4b=0;
VIPm6=0;
VOPm1=0;
VOPm2=0;
if tiempo<=1
    VIPm1=1;
end
    
if tiempo<=2&&tiempo>1
    VIPm4a=1;
end

if tiempo<=3&&tiempo>2
    VIPm4b=1;
end
if tiempo<=4&&tiempo>3
    VIPm6=1;
end
if tiempo<=5&&tiempo>4
    VOPm1=1;
end
    
    


