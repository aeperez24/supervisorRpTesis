function salida=escritura_sistema(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,o1,o2,o3,o4,p,q,r,s,t,u,v);
%escritura_sistema(VIPm,VIPm4a,VIPm4b,VIPm6,VOPm1,VOPm2,
%BPmMoAgT,VPmAgT,VPmMoT,BMoAgT,VMoAgT,VIT1,VOT1,MMo,VIAg1,VIAg6,VIAg7,VIAg8,VOAg1,VOAg2,BOAg,MAg)
set_param('proceso_simulacion_1/VIPm1','Value',int2str(a));
set_param('proceso_simulacion_1/VIPm4a','Value',int2str(b));
set_param('proceso_simulacion_1/VIPm4b','Value',int2str(c));
set_param('proceso_simulacion_1/VIPm6','Value',int2str(d));
set_param('proceso_simulacion_1/VOPm1','Value',int2str(e));
set_param('proceso_simulacion_1/VOPm2','Value',int2str(f));

set_param('proceso_simulacion_1/BPmMoAgT','Value',int2str(g));
set_param('proceso_simulacion_1/VPmAgT','Value',int2str(h));
set_param('proceso_simulacion_1/VPmMoT','Value',int2str(i));
set_param('proceso_simulacion_1/BMoAgT','Value',int2str(j));
set_param('proceso_simulacion_1/VMoAgT','Value',int2str(k));
set_param('proceso_simulacion_1/VIT1','Value',int2str(l));
set_param('proceso_simulacion_1/VOT1','Value',int2str(m));
set_param('proceso_simulacion_1/MMo','Value',int2str(n));
set_param('proceso_simulacion_1/VIAg1','Value',int2str(o));
set_param('proceso_simulacion_1/VIAg2','Value',int2str(o1));
set_param('proceso_simulacion_1/VIAg3','Value',int2str(o2));
set_param('proceso_simulacion_1/VIAg4','Value',int2str(o3));
set_param('proceso_simulacion_1/VIAg5','Value',int2str(o4));
set_param('proceso_simulacion_1/VIAg6','Value',int2str(p));
set_param('proceso_simulacion_1/VIAg7','Value',int2str(q));
set_param('proceso_simulacion_1/VIAg8','Value',int2str(r));
set_param('proceso_simulacion_1/VOAg1','Value',int2str(s));
set_param('proceso_simulacion_1/VOAg2','Value',int2str(t));
set_param('proceso_simulacion_1/MAg','Value',int2str(u));
set_param('proceso_simulacion_1/BOAg','Value',int2str(v));

salida=1;
end