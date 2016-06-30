package servicios;

import Ordenes.OrdenPintura;
import Petri.Lugar;


public class Servicio {
	
	private boolean corriendo=false;
	private main principal;
	public int inicio()
	{
		corriendo=true;
		main principal=new main();
	
		Thread hilo_Principal= new Thread(principal);
		hilo_Principal.start();
		return 0;
	}
	/*funcion para incluir una orden en la agenda*/
	public void incluir_orden(String orden)
	{
		int color;//color de la pintura en la orden
		int numeroLotes;//numero de lotes a producir
		int numeroOrden;//numero de la orden de produccion
		boolean medioLote;
		String[] aux;
		aux=orden.split(":");
		numeroOrden=Integer.parseInt(aux[0]);
		numeroLotes=Integer.parseInt(aux[1]);
		
		if(aux[2].equals("true"))
			medioLote=true;
		
		else
			medioLote=false;
		
		color=Integer.parseInt(aux[3]);
		principal.Agenda.add(new OrdenPintura(numeroOrden, color, numeroLotes-1, medioLote));
		
		
	}
	/*funcion para obtener la informacion de una agenda en forma de string con una id x */
	public String obtener_orden(int x)
	{	OrdenPintura aux=null;
		String respuesta;
			for (int i = 0; i < principal.Agenda.size(); i++) 
			{
				if(x==principal.Agenda.get(i).getNOrden())
					{aux=principal.Agenda.get(i);
					break;}
			
			}
		respuesta=Double.toString(aux.getOrdenPremezcla().getporcentaje())+":"+Double.toString(aux.getOrdenTransporte().getporcentaje())+":"+Double.toString(aux.getOrdenAgitado().getporcentaje())+":"+aux.completado()+":"+Integer.toString(aux.getNOrden());
		return respuesta;
	}
	
	
	/*funcion que le indica al sistema que la falla fue reparada*/
	public void falla_sol()
	{
		Lugar.todosLosLugares.getById("mcf_2").setFichas(1);
	}
	
	/*funcion que regresa el estado del proceso*/
	public int get_status_proceso()
	
	{
		if(Lugar.todosLosLugares.getById("m4_f8").getFichas()==0)
			return 1;
		else
			return 0;
		
		
	}
	
	
	
	
	

}
