package Ordenes;

public class OrdenPintura {
private int color;//color de la pintura en la orden
private int numeroLotes;//numero de lotes a producir
private int numeroOrden;//numero de la orden de produccion
private boolean medioLote;// indica si se producira un medio lote extra
private OrdenPremezcla ordenParaPremezcla;//sub orden derviada que se envia a premezcla
private OrdenTransporte ordenParaTransporte;//sub orden derivada que se envia a transporte
private OrdenAgitado ordenParaAgitado;//sub orden derivada que se envia a agitado
private boolean check=false;//orden ya completada
private boolean procesed=false;//orden ya pasada a procesar
public OrdenPintura(int numeroOrden,int color,int numeroLotes,boolean medioLote)
{
	this.numeroOrden=numeroOrden;
	this.color=color;
	this.numeroLotes=numeroLotes;
	this.medioLote=medioLote;
	descomponerEnPremezcla();
	descomponerEnTransporte();
	descomponerEnAgitado();
}

/*
 * funcion que deriva la orden de  pintura en una orden para enviar a premezlca
 * 
 * */

private void descomponerEnPremezcla()

{
	int tipoPremezcla=-1;
	if(this.color==1&&!this.medioLote)
	{
		tipoPremezcla=1;
	}
	else
		if(this.color==1&&this.medioLote)
		
		{
			tipoPremezcla=2;
		}
		else
			if(this.color==2&&!this.medioLote)
			{
				tipoPremezcla=3;
			}
			else
				if(this.color==2&&this.medioLote)
				{
					tipoPremezcla=4;
				}
	
		this.ordenParaPremezcla=new OrdenPremezcla(this.numeroOrden, tipoPremezcla, this.numeroLotes);

		}



/*
 * funcion que deriva de la orden de pintura en una orden para enviar a transporte
 * */


private void descomponerEnTransporte()
	{
	int tipoTransporte=this.color;
	int cantidadTransporte=this.numeroLotes;
	
	/*
	 * en caso de que se tenga un medio lote extra, se realiza un lote extra de transporte
	 * */
	if(this.medioLote)
		cantidadTransporte++;
	
	this.ordenParaTransporte=new OrdenTransporte(this.numeroOrden, tipoTransporte, cantidadTransporte);
	
	
	}

/*
 * funcion que deriva la orden de pintura en una orden para enviar a agitado
 * */
private void descomponerEnAgitado()
	{
	
	int tipoAgitado=-1;
	if(this.color==1&&!this.medioLote)
	{
		tipoAgitado=1;
	}
	else
		if(this.color==1&&this.medioLote)
		
		{
			tipoAgitado=2;
		}
		else
			if(this.color==2&&!this.medioLote)
			{
				tipoAgitado=3;
			}
			else
				if(this.color==2&&this.medioLote)
				{
					tipoAgitado=4;
				}
	
		this.ordenParaAgitado=new OrdenAgitado(this.numeroOrden, tipoAgitado, this.numeroLotes);



	}

/*
 * funciones que retornan cada una de las variables prviadas
 * */



/*
*funcion que retorna color de la orden de pintura 
 */
public int getColor()

{
	return this.color;
}


/*
*funcion que retorna numero de lotes de la orden de pintura 
 */
public int getNlotes()
{
	return this.numeroLotes;
}


/*
*funcion que retorna el numero de la orden de pintura 
 */
public int getNOrden()
{
	return this.numeroOrden;	
}


/*
*funcion que retorna si la orden contiene un medio lote a prodicir
 */
public boolean getMedioLote()
{
	return this.medioLote;
}

/*
*funcion que retorna sub orden derivada hacia premezcla
 */

public OrdenPremezcla getOrdenPremezcla()
{
	return this.ordenParaPremezcla;	
}



/*
*funcion que retorna sub orden derivada hacia transporte 
 */
public OrdenTransporte getOrdenTransporte()
{
	return this.ordenParaTransporte;	
}


/*
*funcion que retorna sub orden derivada hacia agitado
 */
public OrdenAgitado getOrdenAgitado()
{
	return this.ordenParaAgitado;
}



public void setCompletado()
{
this.check=true;	
}


public boolean completado()
{
return this.check;	
}


public void setprocesada()
{
this.procesed=true;	
}


public boolean procesada()
{
return this.procesed;	
}



}