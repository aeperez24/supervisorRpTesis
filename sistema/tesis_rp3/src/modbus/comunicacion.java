package modbus;
import java.net.*;

import net.wimpi.modbus.*;
import net.wimpi.modbus.io.ModbusSerialTransaction;
import net.wimpi.modbus.msg.ReadCoilsRequest;
import net.wimpi.modbus.msg.ReadCoilsResponse;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.msg.ReadInputRegistersRequest;
import net.wimpi.modbus.msg.ReadInputRegistersResponse;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.msg.WriteCoilRequest;
import net.wimpi.modbus.msg.WriteCoilResponse;
import net.wimpi.modbus.msg.WriteMultipleRegistersRequest;
import net.wimpi.modbus.msg.WriteSingleRegisterRequest;
import net.wimpi.modbus.msg.WriteSingleRegisterResponse;
import net.wimpi.modbus.net.SerialConnection;
import net.wimpi.modbus.procimg.Register;
import net.wimpi.modbus.util.SerialParameters;
public class comunicacion {
	//static String puerto="COM1";
	//static String puerto="/dev/ttyS1";//si fuese en windows se utilizaria com en  lugar de tty 
	
	/*para rasbperry pi siguiente*/
	static String puerto="/dev/ttyUSB0";
	
	
	//instances
	SerialConnection con;
	ModbusSerialTransaction trans=null;
	
	ReadCoilsRequest req1=null;
	ReadCoilsResponse res1=null;
	
	ReadInputDiscretesRequest req2=null;
	ReadInputDiscretesResponse res2=null;
	
	
	ReadMultipleRegistersRequest req3=null;
	ReadMultipleRegistersResponse res3=null;
	
	ReadInputRegistersRequest req4 = null; //the request
	ReadInputRegistersResponse res4 = null;
	
	WriteCoilRequest req5=null;
	WriteCoilResponse res5=null;
	
	
	WriteSingleRegisterRequest req6=null;
	WriteSingleRegisterResponse res6=null;
	
	
	 
	 
	 int id;// identificacion del equipo con el que se comunicara
	 int ref;//primer registro/coil a leer/escribir
	 int cantidad;//cantidad de registros/coils a leer
	 SerialParameters params=new SerialParameters();
	
	
	 
	 //inicio sobrecarga funcion set_parametros
	
	void set_parametros(int id,int ref,int cantidad)
	{
		this.id=id;
		this.ref=ref;
		this.cantidad=cantidad;
		
	}
	void set_parametros(int id,int ref)
	
	{
		this.id=id;
		this.ref=ref;
	
		
	}
	//fin sobrecarga funcion set_parametros
	
	
	
	void configuracion_serial(String puerto,int rate,int databits,int stopbits,String enc)//configuracion de la comunicacion serial
	
	
	
	{
		ModbusCoupler.getReference().setUnitID(1);      
    	
		params.setBaudRate(rate);//configuracion del baudrate
		params.setDatabits(databits);// confiiguracion de la cantidad de bits datos
		params.setPortName(puerto);//configuracion del puerto a usar
		params.setParity("none");//configuracion de paridad (ninguna)
		params.setStopbits(stopbits);//configuracion de cantidad de bits para detenr
		params.setEncoding(enc);//configuracion de la codificacion
		
	}
	
	
	
	void abrir_conexion()
	{	boolean fallo=false;
		con=new SerialConnection(params);
	try {
		con.open();
		//System.out.println("conexion realizada");
	} catch (Exception e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error al establecer comunicacion");
		
		fallo=true;
	}
		if(fallo)
		{
			try {System.out.println("intentando de nuevo");
			
				con.close();
				con.open();
				//System.out.println("conexion realizada");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
	}
	
	
	
	
	void set_operacion(int opcion)//configuracion de operacion a realizar (lecutra)
	{
		switch(opcion){
		case 1:
		req1=new ReadCoilsRequest(ref, cantidad);
		req1.setUnitID(id);
		req1.setHeadless();
		
		break;
		
		case 2:
			req2=new ReadInputDiscretesRequest(ref,cantidad);
			req2.setUnitID(id);
			req2.setHeadless();
			
		break;
		case 3:
			req3=new ReadMultipleRegistersRequest(ref, cantidad);
			req3.setUnitID(id);
			req3.setHeadless();
			
		break;
		
		case 4://lectura registro de entrada
			req4=new ReadInputRegistersRequest(ref,cantidad);
			req4.setUnitID(id);
			req4.setHeadless();
		break;
		
		}
		
	}
	
	
	
	
	
	void set_operacion(int opcion,boolean b)//configuracion de operacion a realizar (escritura de coil)
	
	{
		if(opcion==5)
			{req5=new WriteCoilRequest(ref, b);
			req5.setUnitID(id);
			req5.setHeadless();
			}
	
	
	}
	

	
	
	
	void set_operacion(int opcion,Register reg) //configuracion de operacion a realizar (escritura de coil)
	{	if(opcion==6)
			{req6=new WriteSingleRegisterRequest(ref,reg);
			req6.setUnitID(id);
			req6.setHeadless();	
			}
	}
	
	
	
	
	
	
	void prepare_transaction(int opcion)
	{
		switch(opcion){
		
		case 1:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req1);
			break;
		
		
		case 2:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req2);
			break;
		case 3:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req3);
			break;
		
		
		
		case 4:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req4);
			break;
		
		case 5:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req5);
			break;
		
		
		case 6:
			trans=new ModbusSerialTransaction(con);
			trans.setRequest(req6);
			break;
		
		
		}
	
	}
	
	
	void relizar_operacion(int opcion)
	{switch(opcion)
		{case 1:
			try {
				trans.execute();
				res1 = (ReadCoilsResponse) trans.getResponse();
				 /*for (int n = 0; n < res1.getBitCount(); n++) {
			    	    System.out.println("coil " + n + "=" + res1.getCoilStatus(n));// muestra cada una de las respuestas recibidas para una lectura de coil
			    	  }
				*/
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			break;
		case 2:
			try {
				trans.execute();
				res2 = (ReadInputDiscretesResponse) trans.getResponse();
				 /*for (int n = 0; n < res2.getDiscretes().size(); n++) {
			    	    System.out.println("coil " + n + "=" + res2.getDiscreteStatus(n));// muestra cada una de las respuestas recibidas para bobinas de entrada
			    	  }
				*/
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			break;
		case 3:
			try {
				trans.execute();
				res3 = (ReadMultipleRegistersResponse) trans.getResponse();
				 for (int n = 0; n < res3.getWordCount(); n++) {
			    	    System.out.println("Word " + n + "=" + res3.getRegisterValue(n));// muestra cada una de las respuestas recibidas para un registro de  escritura 
			    	  }
				
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			break;
		case 4:
			
			try {
				trans.execute();
				res4 = (ReadInputRegistersResponse) trans.getResponse();
				 for (int n = 0; n < res4.getWordCount(); n++) {
			    	    System.out.println("Word " + n + "=" + res4.getRegisterValue(n));// muestra cada una de las respuestas recibidas de un registro de entrada
			    	  }
				
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			
			
			
			
			break;
		case 5:
			try {
				trans.execute();
				res5 = (WriteCoilResponse) trans.getResponse();
				
			    	    System.out.println("coil escrito "+  "=" + res5.getCoil());// muestra la respuesta de la escritura de un coil
			    	  
				
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			
			break;
		case 6:
			
			try {
				trans.execute();
				res6 = (WriteSingleRegisterResponse) trans.getResponse();
				System.out.println("Word valor escrito" + res6.getRegisterValue());// muestra  la respuesta de la la escritura de un registro
			    	  
				
				
				
				
				
			} catch (ModbusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error al ejecutar la operacion");
			}
			
			
			
		
			
			
			break;
			
			
	
	
	
	
	
	
	
		}
		
		
		
	}
	
	
	
	void cerrar_comunicacion()
	{	
		con.close();
		
	}
	
	//inicio sobrecarga de constructores
	
	//constructor para lectura coil o registro
	public comunicacion(int opc,int direccion,int bar,int nub,int stb,int referencia,int cantidad) {
		set_parametros( direccion,referencia,cantidad);
		configuracion_serial(puerto,bar, nub, stb, "rtu");//entre linux y windows la diferencia es lo que esta en puerto
		abrir_conexion();
		set_operacion(opc);
		prepare_transaction(opc);
		relizar_operacion(opc);
		cerrar_comunicacion();
		
		//System.out.print("conexion cerrada");
		// TODO Auto-generated method stub

	}
	
	
	//constructor para escritura de coil
	public comunicacion(int opc,int direccion,int bar,int nub,int stb,int referencia,boolean bit) {
		set_parametros( direccion,referencia);
		configuracion_serial(puerto,bar, nub, stb, "rtu");
		
		abrir_conexion();
		set_operacion(opc,bit);
		prepare_transaction(opc);
		relizar_operacion(opc);
		cerrar_comunicacion();
		//System.out.print("conexion cerrada");
		// TODO Auto-generated method stub

	}
	//constructor para escritura de registro
	public comunicacion(int opc,int direccion,int bar,int nub,int stb,int referencia,Register valor) {
		set_parametros( direccion,referencia);
		configuracion_serial(puerto,bar, nub, stb, "rtu");
		
		abrir_conexion();
		set_operacion(opc,valor);
		prepare_transaction(opc);
		relizar_operacion(opc);
		cerrar_comunicacion();
		//System.out.print("conexion cerrada");
		// TODO Auto-generated method stub

	}




}
