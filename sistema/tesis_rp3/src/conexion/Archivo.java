package conexion;
import java.io.*;

import Petri.ListaLugares;

public class Archivo {
	String ruta;
	 FileWriter fichero ;
     PrintWriter pw ;
	
	public Archivo(String ruta)
	{
		this.ruta=ruta;
		
		
		
	}
	
	
	public void AbrirFichero()
	{
		
        try {
			fichero = new FileWriter(ruta,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        pw = new PrintWriter(fichero);
        
       
	}
	
	public void escribirLugar(String id,int fichas)
	{
        
		pw.println(id+":"+fichas);
        
	}
	public void cerrar()
	{
		pw.println("********************************fin*******************************");
		pw.close();
	}
	
	public  static void guardarArchivo(Archivo a1,ListaLugares aux)
	{
		
		
		
		a1.AbrirFichero();
		
		for (int i = 0; i < aux.size(); i++) {
		
			a1.escribirLugar(aux.get(i).getId(),aux.get(i).getFichas());
	
		}
		
	a1.cerrar();	
	
		
		
	}
}
