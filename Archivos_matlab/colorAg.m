function fin = colorAg()
global Pmcolor Agcolor VOPm2  VIAg6 BPmMoAgT VPmAgT VPmMoT BMoAgT VMoAgT VIAg1 VIAg2 VIAg3 VIAg4 VIAg5 VIAg7 VIAg8 
fin=0;
if((VPmAgT&&VOPm2&&VIAg6)||(VOPm2&&BPmMoAgT&&VPmMoT&&BMoAgT&&VMoAgT&&VIAg6))
Agcolor=Pmcolor;
end
if(VIAg8)
Agcolor=6;
end

if(VIAg5)
    if(Agcolor==2)
        Agcolor=5;
    end
    if(Agcolor==3)
        Agcolor=7;
    end
    
      
end
if(VIAg7)
Agcolor=4;
end 

end

