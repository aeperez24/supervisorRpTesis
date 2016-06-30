function [salida1 salida2 salida3]=lectura_sistema()

PM =get_param('proceso_simulacion_1/PM','RuntimeObject');
Ag =get_param('proceso_simulacion_1/Ag','RuntimeObject');
time =get_param('proceso_simulacion_1/Clock','RuntimeObject');
salida1=[time.OutputPort(1).Data];
salida2=[PM.OutputPort(1).Data];
salida3=[Ag.OutputPort(1).Data];
%(PM,time)
end
