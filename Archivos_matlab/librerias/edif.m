function xdot = edif(t,x);
global A R u;
%Ecuaciones Diferenciales:


xdot =-sqrt(x)/(A*R)+u/A;
xdot = xdot';