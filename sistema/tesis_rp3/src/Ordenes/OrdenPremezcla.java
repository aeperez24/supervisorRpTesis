package Ordenes;

public class OrdenPremezcla {
	private int idOrdenPintura;
	private int tipoPremezcla;
	private int cantidadPremezcla;
	private double porcentaje;
	private boolean check,medioloteproducido;
	
	public OrdenPremezcla(int idOrdenPintura,int tipoPremezcla,int cantidadPremezcla)
	{
		this.idOrdenPintura=idOrdenPintura;
		this.tipoPremezcla=tipoPremezcla;
		this.cantidadPremezcla=cantidadPremezcla;
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
		if(this.tipoPremezcla==1||this.tipoPremezcla==3)
		{
		/*para lotes copletos*/
		porcentaje=(cantidadPremezcla+1-lotesFaltantes)*100/(cantidadPremezcla+1);
		}
		else/*para medio lote*/
		{	if(!this.medioloteproducido)
				{this.medioloteproducido=true;
				porcentaje=(0.5)*100/(cantidadPremezcla+1.5);
				
				}
			else
			
				{porcentaje=(cantidadPremezcla-lotesFaltantes+1.5)*100/(cantidadPremezcla+1.5);}
		}
		
		
		if (porcentaje==100)
			this.check=true;
				
		
	}

	
	/*
	 * funcion que regresa el id de la orden de pintura correspondiente a esta orden
	 * */
	public int getidOrdenPintura()
	{
		return this.idOrdenPintura;
	}
	
	/*
	 * funcion que regresa el tipo de premezcla de esta orden
	 * */
	public int gettipoPremezcla()
	{
		return this.tipoPremezcla;
	}

	/*
	 * funcion queregresa la cantidad de premezclas a realizar
	 * */
	
	public int getcantidadPremezcla()
	{
		return this.cantidadPremezcla;
		
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
		
		System.out.println("\nordenPremezcla:");
		System.out.println("\ntipo:"+this.gettipoPremezcla()+"\ncantidad:"+this.getcantidadPremezcla()+"\nid:"+this.getidOrdenPintura()+"\n");
	
	}
}
