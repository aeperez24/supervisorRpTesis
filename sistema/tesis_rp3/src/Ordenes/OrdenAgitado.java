package Ordenes;

public class OrdenAgitado {

	private int idOrdenPintura;//identfica el la orden de pintura a la que pertenece
	private int tipoAgitado;//indica el tipo de agitado a producir
	private int cantidadAgitado;//cantidad de lotes a hacer
	private double porcentaje;//porcentaje de la evolucion de la orden
	private boolean check,medioloteproducido;
	

	
	public OrdenAgitado(int idOrdenPintura,int tipoAgitado,int cantidadAgitado)
	{
		this.idOrdenPintura=idOrdenPintura;
		this.tipoAgitado=tipoAgitado;
		this.cantidadAgitado=cantidadAgitado;
		this.porcentaje=0;
		this.check=false;
		medioloteproducido=false;
	}
	
	/*
	 * funcion para la actualizar el progreso de la orden
	 * 
	 * */
	public void actualizaPorcentaje(int lotesFaltantes)
	{	
	if(tipoAgitado==1||tipoAgitado==3)/*para lote completo*/
	
		{
		porcentaje=(cantidadAgitado+1-lotesFaltantes)*100/(cantidadAgitado+1);}
	else/*para medio lote*/
		{
		if(!this.medioloteproducido)
			{this.medioloteproducido	=	true;
			porcentaje	=	(0.5)*100/(cantidadAgitado+1.5);}
		
			else
			{porcentaje	=	(cantidadAgitado-lotesFaltantes+1.5)*100/(cantidadAgitado+1.5);}
		
		}
		if (porcentaje	==	100)
			this.check	=	true;
				
	}

	
	/*
	 * funcion que regresa el id de la orden de pintura correspondiente a esta orden
	 * */
	public int getidOrdenPintura()
	{
		return this.idOrdenPintura;
	}
	
	
	/*
	 * funcion que regresa el tipo de Agitado de esta orden
	 * */
	
	public int gettipoAgitado()
	{
		return this.tipoAgitado;
	}
	
	
	
	/*
	 * funcion queregresa la cantidad de Agitado a realizar
	 * */
	
	public int getcantidadAgitado()
	{
		return this.cantidadAgitado;
		
	}
	

	
	
	/*
	 * funcion que regresa el porcentaje de la orden producida
	 * */
	public double getporcentaje()
	{
		return this.porcentaje;
		
		
	}
	
	public boolean getcheck()
	{
		return this.check;
	}
	
	
	public void info()
	{
		System.out.println("\nordenAgitado:");
		System.out.println("\ntipo:"+this.gettipoAgitado()+"\ncantidad:"+this.getcantidadAgitado()+"\nid:"+this.getidOrdenPintura()+"\n");
	
		
	}
}
