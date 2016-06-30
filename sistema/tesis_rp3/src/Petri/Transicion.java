package Petri;


import java.util.LinkedList;
/*clase que define el objeto de transicion para una red de petri*/

public class Transicion {
	//lista de enteros que definen las ids de los lugares entrantes a la transicion
	private LinkedList<String> id_L_Entrante=new LinkedList<>();
	
	//lista de enteros que definen las ids de los lugares que inhiben a la transicion
	private LinkedList<String> id_LI_Entrante=new LinkedList<>();
	
	//lista de enteros que definen las ids de los lugares salientes de la transicion
	private LinkedList<String> id_L_Saliente=new LinkedList<>();
	
	//variable booleana que define si la transicion se encuentr habilitada
	private boolean habilitada=false;
	
	//variable booleana que indica si la transicion se encuentra activada.
	private boolean activada;
	
	private boolean temporizada=false;
	
	//id que identifica a la transicion
	private String id;
	
	
	
	public static ListaTransiciones ListadeTransiciones;
	
	// constructor del objeto transicion
	public Transicion(int e)
	{
		this.activada	=	false;
	
		ListadeTransiciones.incluir(this);
	}
	
	// constructor del objeto transicion
	public Transicion()
	{
		this.activada	=	true;
		ListadeTransiciones.incluir(this);
	}
	
	// constructor del objeto transicion
	 public Transicion(String entrantes,String salientes)
	 {
		 String[] x	=	entrantes.split(",");
		 String[] y	=	salientes.split(",");
		 
		 for (int i = 0; i <x.length; i++) {
		this.id_L_Entrante.add(x[i]);
	}
		
	 for (int i = 0; i <y.length; i++) {
			this.id_L_Saliente.add(y[i]);
		}
	 
	 this.activada	=	true;
	 
	 ListadeTransiciones.incluir(this);
	 }
	 
	
	// constructor del objeto transicion
	 public Transicion(String entrantes,String salientes,int f)
	 {
		 String[] x	=	entrantes.split(",");
		 String[] y	=	salientes.split(",");
		 
		 for (int i = 0; i <x.length; i++) {
		this.id_L_Entrante.add(x[i]);
	}
		
	 for (int i = 0; i <y.length; i++) {
			this.id_L_Saliente.add(y[i]);
		}
	 
	 this.activada	=	false;
	 
	 ListadeTransiciones.incluir(this);
	 }
	
	 
	 //funcion para anadir un id entrante con formato entero
	 
	 
	 //funcion para anadir  ids entrantes con formato de String separados por comas.
	 public void addId_L_Entrante(String entrantes){
		 String[] x=entrantes.split(",");
		 for (int i = 0; i <x.length; i++) {
		this.id_L_Entrante.add(x[i]);
	}
		
	 }
	 
	 //funcion para anadir un id entrante a partir de su respectivo lugar.
	 public void addId_L_Entrante(Lugar x)
	 {if(!existeId(x.getId(),id_L_Entrante))
		 this.id_L_Entrante.add(x.getId());
	 }
	 
	 
	 
	 //funcion para anadir ids salientes, con un formato de String separados por comas
	 public void addId_L_Saliente(String salientes){
		 String[] x	=	salientes.split(",");
		 
		 for (int i = 0; i <x.length; i++)
		 {this.id_L_Saliente.add(x[i]);}
		
	 }
	 

	 //funcion para anadir un id saliente a partir de su respectivo lugar.
	 public void addId_L_Saliente(Lugar x)
	 {if(!existeId(x.getId(),id_L_Saliente))
		 this.id_L_Saliente.add(x.getId());
	 }
	 
	 
	//funcion par anadir un id de un lugar inhibidor con un formato de entero
	 
	 
	//funcion para anadir ids inhibidores, con un formato de String separados por comas
	 public void addId_LI_Entrante(String inhibidores){
		 String[] x=inhibidores.split(",");
		 
		 for (int i = 0; i <x.length; i++) 
		 
		 {this.id_LI_Entrante.add(x[i]);}
		 
	 }
	//funcion para anadir un id inhibidor a partir de su respectivo lugar.
	 public void addId_LI_Entrante(Lugar x)
	 {
		 if(!existeId(x.getId(),id_LI_Entrante))
		 
			 this.id_LI_Entrante.add(x.getId());
	 }

	
	 
	 //funcion para activar la transicion
	public void activar()
	{
		
		this.activada	=	true;
	}
	
	
	
	//funcion para desactivar la transicion
	public void desactivar()
	{
		this.activada	=	false;
		
	}
	
	
	
	// funcion que retorna verdadero si dado un id este existe en la lista de enteros x
	public boolean existeId(String id,LinkedList<String> x)
	{ 
		LinkedList<String> aux	=	(LinkedList<String>) x.clone();
		while(!aux.isEmpty())
		
		{	//if(aux.poll()	==	id)
			if(aux.poll().equals(id))	
				return true;

		}
		return false;
	}
	
	
	
	//funcion que retorna verdadero si la transicion esta habilitada
	public boolean estaHabilitada(ListaLugares x)
	{LinkedList<String> aux	=	x.LugaresActivos();
	
	LinkedList<String> aux2	=	(LinkedList<String>) this.id_L_Entrante.clone();
	
	while(!aux2.isEmpty())
	{
		if(!existeId(aux2.poll(),aux))
			return false;
	}
		
	return true;
	}
	
	//funcion que retorna verdadero si la transicion se encuentra inhibida
	public boolean estaInhibida(ListaLugares x)
	{LinkedList<String> aux	=	x.LugaresActivos();
	LinkedList<String> aux2	=	 (LinkedList<String>) this.id_LI_Entrante.clone();
	if(aux2.isEmpty()){return false;}
	else{
	while(!aux2.isEmpty())
	{
		if(existeId(aux2.poll(),aux))
			return true;
	}
		
	return false;
	}
	
	}
	
	// funcion que retorna verdadero si la transicion se encuentra habilitada y no se encutra inhibida
	public void habilitacion(ListaLugares todosLosLugares)
	{
		if(!this.estaInhibida(todosLosLugares)&&this.estaHabilitada(todosLosLugares))
		{
			this.habilitada	=	true;
		}
		else
			this.habilitada	=	false;
		
	}
	
	//retorna el valor de habilitada
	public boolean getHabilitada()
	{
		return this.habilitada;
	}
	
	//funcion que resta una ficha de todos los lugares entrantes y suma una ficha a los lugares salientes
	private void flanquear(ListaLugares todosLosLugares)
	{
		LinkedList<String> auxEntrante=(LinkedList<String>) this.id_L_Entrante.clone();
		LinkedList<String> auxSaliente=(LinkedList<String>) this.id_L_Saliente.clone();
		int indice;
		
		while(!auxEntrante.isEmpty())
		
			{indice	=	todosLosLugares.getIndexId(auxEntrante.poll());	
			todosLosLugares.get(indice).remFichas();
			}
		
		while(!auxSaliente.isEmpty())
		{indice	=	todosLosLugares.getIndexId(auxSaliente.poll());	
		todosLosLugares.get(indice).addFichas();
		}
		
	}
	
	
	//funcion que verifica la habilitacion e inhibicion de la transicion flanqueandola de ser posible
	public void validaFlanqueo(ListaLugares todosLosLugares)
		
	{
		this.habilitacion(todosLosLugares);
	
		if(this.habilitada&&this.activada)
			{
			this.flanquear(todosLosLugares);
			
			if(this.getTemporizada())
				{
				this.desactivar();
				this.setTemporizada(false);
				}
			
			}
		
		
		
	}
	
	/*coloca un id para la transicion*/
	public void setId(String id)
	{
		
		this.id	=	id;
	}
	
	/*obtiene el id de la transicion*/
	public String getId()
	{
		return this.id;
		
	}
	
	/*retorna el valor de activada*/
	public boolean getActivada()
	{
		
		return this.activada;
	}
	
	
	/*cambia a verdader el valor de temporizda*/
	public void setTemporizada(boolean tem)
	{
	this.temporizada=tem;
		
	}
	
	/*retorna el valor de temporizada*/
	public boolean getTemporizada()
	{
		
		return this.temporizada;
	}
	
	//muestra informacion de la transicion.
	public void info(ListaLugares todosLosLugares)
	{
		LinkedList<String> aux;
		System.out.println("lugares entrantes:");
		
		aux=(LinkedList<String>) this.id_L_Entrante.clone();
		while(!aux.isEmpty())
			System.out.println(aux.poll());
		System.out.println("lugares salientes:");
		
		aux=(LinkedList<String>) this.id_L_Saliente.clone();
		while(!aux.isEmpty())
			System.out.println(aux.poll());
		
		System.out.println("lugares inhibidores:");
		aux=(LinkedList<String>) this.id_LI_Entrante.clone();
		while(!aux.isEmpty())
			System.out.println(aux.poll());
		
		
		System.out.print("activada:");
		System.out.println(this.activada);
		
		System.out.print("habilitada:");
		System.out.println(!this.estaInhibida(todosLosLugares)&&this.estaHabilitada(todosLosLugares));
		
	}
	
	
	
}

