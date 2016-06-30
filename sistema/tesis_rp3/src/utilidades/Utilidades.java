package utilidades;
import java.util.LinkedList;

import Ordenes.*;
public class Utilidades {

	public final static OrdenPintura getOrdenFromLista(int numero,LinkedList<OrdenPintura> ordenes)
	{	OrdenPintura orden=null;
		for (int i = 0; i < ordenes.size(); i++) {
		if(ordenes.get(i).getNOrden()==numero){orden=ordenes.get(i);}
		}
	
		return orden;
		
		
	}
}
