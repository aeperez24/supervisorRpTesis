package Ordenes;

public class OrdenTransporte {

	private int idOrdenPintura;
	private int tipoTransporte;
	private int cantidadTransporte;
	private float porcentaje;
	private boolean check;
	
	public OrdenTransporte(int idOrdenPintura,int tipoTransporte,int cantidadTransporte)
	{
		this.idOrdenPintura=idOrdenPintura;
		this.tipoTransporte=tipoTransporte;
		this.cantidadTransporte=cantidadTransporte;
		this.porcentaje=0;
		this.check=false;
	}
	
	/*
	 * actualizar el progreso de la orden de tranpsorte
	 * */
	public void actualizaPorcentaje(int lotesFaltantes)
	{
		porcentaje=(cantidadTransporte+1-lotesFaltantes)*100/(cantidadTransporte+1);
		if (porcentaje==100)
			this.check=true;
				
	}
	
	/**
	 * retorna la id  de la orden de pintura a la que corresponde esta orden
	 */
	public int getidOrdenPintura()
	{
		return this.idOrdenPintura;
	}
	
	
	/*
	 * retorna el tipo de transporte
	 * */
	public int gettipoTransporte()
	{
		return this.tipoTransporte;
	}
	
	
	/*
	 * retorna cantidad de transporte a realizar
	 * */
	public int getcantidadTransporte()
	{
		return this.cantidadTransporte;
		
	}
	
	/*
	 * retorna el porcentaje de prgreso de la orden 
	 * */
	public float getporcentaje()
	{
		return this.porcentaje;
		
		
	}
	/*
	 * retorna variable check(orden completada)
	 * */
	public boolean getcheck()
	{
		return this.check;
	}

	public void info()
	
	{
		
		System.out.println("\nordenTransporte:");
		System.out.println("\ntipo:"+this.gettipoTransporte()+"\ncantidad:"+this.getcantidadTransporte()+"\nid:"+this.getidOrdenPintura()+"\n");
		
	}
	
}
