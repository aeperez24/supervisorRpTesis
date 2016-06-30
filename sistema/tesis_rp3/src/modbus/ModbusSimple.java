package modbus;

import net.wimpi.modbus.msg.ReadCoilsResponse;
import net.wimpi.modbus.msg.WriteCoilResponse;
import net.wimpi.modbus.util.SerialParameters;

public class ModbusSimple {

	
	public static final int ibaudrate = 2400;
	public static final int nbits = 8;
	
	public static final int istopbit = 1;
	public final SerialParameters params=new SerialParameters();
	
	public  static  WriteCoilResponse EscribirC(int idireccion,int coilEscribir,boolean valorEscribir)
	{	
		comunicacion com=new comunicacion(5,idireccion,ibaudrate,nbits,istopbit,coilEscribir,valorEscribir);
		return com.res5;
	}
	
	public static ReadCoilsResponse LeerHC(int idireccion,int coilInicial,int cantidadcoilsLeer)
	{
		comunicacion com=new comunicacion(1,idireccion,ibaudrate,nbits,istopbit,coilInicial,cantidadcoilsLeer);
		return com.res1;
		
		
	}
	
	public static ReadCoilsResponse LeerIC(int idireccion,int coilInicial,int cantidadcoilsLeer)
	{
		comunicacion com=new comunicacion(2,idireccion,ibaudrate,nbits,istopbit,coilInicial,cantidadcoilsLeer);
		return com.res1;
		
		
	}
	
	
	public static boolean LeerHC(int idireccion,int coilInicial)
	{
		comunicacion com=new comunicacion(1,idireccion,ibaudrate,nbits,istopbit,coilInicial,1);
		return com.res1.getCoilStatus(0);
		
		
	}
	
	public static boolean LeerIC(int idireccion,int coilInicial)
	{
		comunicacion com=new comunicacion(2,idireccion,ibaudrate,nbits,istopbit,coilInicial,1);
		return com.res2.getDiscreteStatus(0);
		
	}
	
	
	
}
