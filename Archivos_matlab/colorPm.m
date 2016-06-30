function fin =colorPm()
global Pmcolor VIPm1  VIPm4a  VIPm4b VIPm6;
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
if(VIPm1)
    Pmcolor=1;
end
if(VIPm4a)
    Pmcolor=2;
end
if(VIPm4b)
    Pmcolor=3;
end
if(VIPm6)
    Pmcolor=4;
end
fin=0;
end

