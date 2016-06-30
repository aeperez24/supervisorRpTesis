package Petri;


public class Lugar {
	//static private int cantidad_lugares;
	static public  ListaLugares todosLosLugares;
	private int fichas;
	private  final String id;
	
	public Lugar(int fichas,String id)
	{
		//cantidad_lugares++;
		this.id=id;
		this.fichas=fichas;
		todosLosLugares.add(this);
	}
	
	public void addFichas()
	{
		this.fichas++;
		
	}
	
	public void addFichas(int c)
	{
		this.fichas=this.fichas+c;
		
	}
	
	public void remFichas()
	{
		this.fichas--;
	}
	
	public static void inicio(){
		{
		todosLosLugares=new ListaLugares();
		}
		
	}
	public String getId()
	{
		return this.id;
		
	}
	public int getFichas()
	{
		return this.fichas;
		
	}
	
	public void setFichas(int x)
	
	{
		this.fichas=x;
	}
	
	
}
