package Petri;


import java.util.LinkedList;

public class ListaLugares extends LinkedList<Lugar> {

	
	public Lugar getById(String id)
	{
		return this.get(getIndexId(id));
		
		
	}
	
	
	
	public int getIndexId(String id)
	{ListaLugares aux	=	(ListaLugares) this.clone();
	int i	=	0;
	while(!aux.isEmpty())
	{//if(id	==	aux.peek().getId())
		if(id.equals(aux.peek().getId()))
			
		return i;
	else
		aux.poll();
		
	i++;}	
	return -1;	
	}
	
	
	
	public LinkedList<String> getIds()
	{
		LinkedList<String> aux=new LinkedList<>();
		LinkedList<Lugar> aux2=(LinkedList<Lugar>) this.clone();
		while (!aux2.isEmpty())
		{aux.add(aux2.poll().getId());
			
		}
		return aux;
		
	}
	
	
	
	public int remId(String id)
	{int indice = this.getIndexId(id);
		if(indice>=0)
		{this.remove(indice);
			return 1;
		}
		else
			return -1;
		
		
	}
	public LinkedList<String> LugaresActivos()
	{ListaLugares aux	=	(ListaLugares) this.clone();
	LinkedList<String> resultado	=	new LinkedList<>();
	while(!aux.isEmpty())
	{if(aux.peek().getFichas()>0)
		resultado.add(aux.peek().getId());
	aux.poll();
	}
		
		return resultado;
	}
	
	
	
	public ListaLugares() {
	super();	// TODO Auto-generated constructor stub
	}

/*para mostrar todos los lugares*/
	public void info()
	{
		LinkedList<Lugar> aux= (LinkedList<Lugar>) this.clone();
		Lugar aux2;
		while (!aux.isEmpty())
		{
			aux2=aux.poll();
			System.out.println(aux2.getId()+":"+aux2.getFichas());
			
		}
		
	}


	public void infoActivos()
	{LinkedList<String> aux=LugaresActivos();
		
	while (!aux.isEmpty())
	{
		System.out.println(aux.poll());
		
	}
		
	}
	


}
