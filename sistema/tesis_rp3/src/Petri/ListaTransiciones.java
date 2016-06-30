package Petri;


import java.util.LinkedList;

public class  ListaTransiciones {
	private LinkedList<Transicion> todasLasTransiciones=new LinkedList<>();
	
	
	//agrega una transicion a la lista
	public void incluir(Transicion x)
	{
		this.todasLasTransiciones.add(x);
		
	}
	
	//ejecuta todas las transiciones habilitadas y activadas.
	
	public void correr(ListaLugares todosLosLugares)
	{
		for (int i = 0; i < todasLasTransiciones.size(); i++) {
			todasLasTransiciones.get(i).validaFlanqueo(todosLosLugares);
		}
		
		
	}
	
	/*activa la transicion por indice*/
	public void activarTransicion(int indice)
	{
		todasLasTransiciones.get(indice).activar();
	}
	
	
	/*desactiva la transicion por indice*/
	public void desactivarTransicion(int indice)
	{
		todasLasTransiciones.get(indice).desactivar();
	}
	
	
	
	/*retornar la transicion por id*/
	public Transicion getById(String id)
	{
		for (int i = 0; i < todasLasTransiciones.size(); i++) 
		{
		if(todasLasTransiciones.get(i).getId().equals(id))
			return todasLasTransiciones.get(i); 
		}
		return null;
		
	}
	
	
	
	/*funcion para desactivar todas las transiciones*/
	public void desactivarTodasLasTransiciones()
	{
		for (int i = 0;  i < todasLasTransiciones.size(); i++)
		{
			if(!todasLasTransiciones.get(i).getTemporizada())
				
				todasLasTransiciones.get(i).desactivar();
		}
		
		
	}
	
	/*funcion para activar todas aquellas funciones habilitadas que no son temporizadas*/
	public void activarHabilitadas(ListaLugares Lu)
	{
		for (int i = 0;  i < todasLasTransiciones.size(); i++)
		
		{	
			todasLasTransiciones.get(i).habilitacion(Lu);
			
		}
		
		
		for (int i = 0;  i < todasLasTransiciones.size(); i++)
		{
			if((todasLasTransiciones.get(i).getHabilitada()&&!todasLasTransiciones.get(i).getTemporizada()))
				
				{todasLasTransiciones.get(i).activar();}
		}
		
		
	}
	
	
	public ListaTransiciones(){}

	
}
