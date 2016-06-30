function [pm ag] = aplicacionColor(Pmcolor,Agcolor)
global nivelPM nivelAG
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
pm=[0 0 0 0];
ag=[0 0 0 0 0 0 0];
pm(Pmcolor)=nivelPM;
ag(Agcolor)=nivelAG;


end

