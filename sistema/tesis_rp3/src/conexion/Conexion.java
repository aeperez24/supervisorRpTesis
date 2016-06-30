package conexion;
import Ordenes.*;
import utilidades.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Petri.ListaLugares;
import Petri.Lugar;


public class Conexion {
	private String direccion;
	private String usuario;
	private String clave;
	private Connection conexion;
	private String nombre_base_datos;
	private String tabla;
		
	
	public  Conexion(String sdireccion,String snombre_base_datos,String stabla,String susuario,String sclave)
	{
		direccion=sdireccion;
		usuario=susuario;
		clave=sclave;
		nombre_base_datos=snombre_base_datos;
		tabla =stabla;
	}
	public   void conectar()
	{
		

		try {
			conexion=	 DriverManager.getConnection("jdbc:mysql://"+direccion+"/"+nombre_base_datos,usuario,clave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	public  void insertar_lugar_bd(String id,int fichas) throws SQLException
	{
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery ("replace into "+tabla+" (id,fichas) value('"+id+"','"+fichas+"');");
		

		
		
	}
	
	
	
	
	public int fichas_db(String Lugar) throws SQLException
	{
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery ("select  fichas from "+tabla+" where id='"+Lugar+"';");
		rs.next();
		return(rs.getInt(1));
		
	}
	
	
	
	public static void pruebaconector()
	{
		
		try
		{
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("conector  bien");
		} catch (Exception e)
		{
		   e.printStackTrace();
		} 
		
	}

	
	//funcion para enviar una orden a la base de datos (completada ) 
	
	public void enviar_orden_db(int numero,LinkedList<OrdenPintura> ordenes) throws SQLException
	{		
			
			
		OrdenPintura orden=Utilidades.getOrdenFromLista(numero, ordenes);
		int color=orden.getColor();
			
			
		int lotes=orden.getNlotes()+1;
			
		int id=orden.getNOrden();
			
		String color_db;
			
		boolean medioExtra=orden.getMedioLote();
			
		int galones=lotes*60;
			
		if(medioExtra)
				galones+=30;
			
		if(color==1){color_db="blanco";}
					else{color_db="marron";}
			
		System.out.println("a base de datos: orden"+id+" color: "+color_db +" galones" + galones);	
	
		Statement s = conexion.createStatement();
		//ResultSet rs = s.executeQuery ("replace into "+tabla+" (numero_orden,color,galones) value('"+1+"','"+color_db+","+galones+"');");
		ResultSet rs = s.executeQuery ("replace into "+tabla+" (numero_orden,color,galones) value('"+id+"','"+color_db+"','"+galones+"');");
		
		
		
	}
	
	

	public static void guardar(Conexion conexion_db1,ListaLugares aux) throws SQLException
	{ 
	for (int i = 0; i < aux.size(); i++)
	
		{
		conexion_db1.insertar_lugar_bd(aux.get(i).getId(),aux.get(i).getFichas());
		}
		
		
	}
	
	
	
	
	
}
