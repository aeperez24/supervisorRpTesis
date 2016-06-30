package Petri;


import java.sql.SQLException;
import java.util.LinkedList;

import conexion.Conexion;
import utilidades.Utilidades;
import modbus.ModbusSimple;
import Ordenes.*;
import GPIO.*;

public class EjecutorAcciones {
	private static int i=0;
	
	private static int auxiliarSimulacion=1;
	public static OrdenPintura proximaOPintura=null;
	public static OrdenPremezcla proximaOPm=null;
	public static OrdenPremezcla premezclaenProduccion=null;
	public static OrdenAgitado proximaOAg=null;
	public static OrdenAgitado agitadoenProduccion=null;
	public static OrdenTransporte proximaOTr=null;
	public static OrdenTransporte transporteenProduccion=null;
	public static Conexion db=new Conexion("localhost","ordenes","completadas","root","123");
	
	/*public static final int	trSinMolienda	=	17;
	public static final int	trConMolienda	=	18;
	public static final int	trLimpieza		=	19;
	public static final int	trSensorFlujo	=	22;
	
	*/
	public static final int	trSinMolienda	=	23;
	public static final int	trConMolienda	=	24;
	public static final int	trLimpieza		=	25;
	public static final int	trSensorFlujo	=	18;
	
	public static final long temp_tr_limpieza=10000;
	
	
	public static final long temp_a_limpieza=30000;
	
	public static final long temp_a_VI=45000;
	public static final long temp_a_VI2=50000;
	public static final long temp_a_vaciado=temp_a_VI+10000;
	//public static final long temp_a_vaciado=temp_a_VI;
	public static final long temp_a_vaciado2=temp_a_VI2+10000;
	//public static final long temp_a_vaciado2=temp_a_VI2;
	
	
	
	public static void inicializacion()
	{
		SimpleGPIO.apagar(trConMolienda);
		SimpleGPIO.apagar(trLimpieza);
		SimpleGPIO.apagar(trSinMolienda);
		
		
	}
	
	static void ejecutar(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda )
	
	{
		LinkedList<String> activos=Lu.LugaresActivos();
		
		
	
		
		
	}
	
	
	
	/*
	 * acciones que seejecutan en la red de petri del premezcla
	 * */
	public static void ejecutorPm(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda)
	{	
		/*acciones coordnador pm*/
		
		
		if(T.getById("T2_1").getHabilitada())
		{
		
			premezclaenProduccion=proximaOPm;
			
			
			
		}
		
		
		//if(T.getById("T2_2").getHabilitada())
		if(existeId("m2_2", Lu.LugaresActivos()))
				
		{	
				configurarPremezlca(premezclaenProduccion, Lu);
			
		}
		
		
		if(existeId("mc1_7",Lu.LugaresActivos()))
		
			{
			
			/*actualiza el progreso de la orden de acuerdo a las fichas en m2_23*/
			premezclaenProduccion.actualizaPorcentaje(Lu.getById("m2_23").getFichas());
			}
		/*fin acciones coordinador pm*/
		/*acciones supervisor pm*/
		
		if(existeId("m3_2",Lu.LugaresActivos()))
				
			{
			
			//quitar
			//TemporizarTransicion(5000,Transicion.ListadeTransiciones.getById("T3_3"));
			
				if(existeId("m3_5", Lu.LugaresActivos()))
					{
					/* escritura en modbus inicio de premezclla blanca LC*/
					System.out.println("inicio pintura blanca Lote completo");
					modbus.ModbusSimple.EscribirC(1, 51, true);
					//51
					}
				else
					if(existeId("m3_7", Lu.LugaresActivos()))
					{
						/* escritura en modbus inicio de premezclla blanca ml*/
						System.out.println("inicio pintura blanca Lote medio");
						modbus.ModbusSimple.EscribirC(1, 66, true);
						//66	
						
					}
					else
						if(existeId("m3_9", Lu.LugaresActivos()))
						{
							/* escritura en modbus inicio de premezclla marron LC*/
							System.out.println("inicio pintura marron LC");
							modbus.ModbusSimple.EscribirC(1, 55, true);	
							//55
						}
						else
							if(existeId("m3_11", Lu.LugaresActivos()))
							{
								/* escritura en modbus inicio de premezclla marron ml*/
								System.out.println("inicio pintura marron Lote medio");
								
								modbus.ModbusSimple.EscribirC(1, 70, true);
								//70
							}
							else
								if(existeId("m3_13", Lu.LugaresActivos()))
								{
									/* escritura en modbus inicio de limpieza*/
									System.out.println("inicio limpieza premezcla");
									modbus.ModbusSimple.EscribirC(1, 62, true);
									//62
									
								}
								else
									if(existeId("m3_14", Lu.LugaresActivos()))
									{
										/* escritura en modbus inicio de transferencia o vaciado*/
										System.out.println("inicio tramsferencia");
										modbus.ModbusSimple.EscribirC(1, 59, true);
										//59
									}
			}
		
		if(existeId("m3_4",Lu.LugaresActivos()))
		{
			
			if(existeId("m3_5", Lu.LugaresActivos()))
			{
			/* escritura en modbus fin de premezclla blanca LC*/
			System.out.println("fin pintura blanca Lote completo");
			//54
			modbus.ModbusSimple.EscribirC(1, 54, true);
			}
		else
			if(existeId("m3_7", Lu.LugaresActivos()))
			{
				/* escritura en modbus fin de premezclla blanca ml*/
				System.out.println("fin pintura blanca Lote medio");
				modbus.ModbusSimple.EscribirC(1, 69, true);
				//69	
				
			}
			else
				if(existeId("m3_9", Lu.LugaresActivos()))
				{
					/* escritura en modbus fin de premezclla marron LC*/
					System.out.println("fin pintura marron LC");
					modbus.ModbusSimple.EscribirC(1, 58, true);
					//58	
					
				}
				else
					if(existeId("m3_11", Lu.LugaresActivos()))
					{
						/* escritura en modbus fin de premezclla marron ml*/
						System.out.println("fin pintura marron Lote medio");
						modbus.ModbusSimple.EscribirC(1, 73, true);
						//73
						
					}
					else
						if(existeId("m3_13", Lu.LugaresActivos()))
						{
							/* escritura en modbus fin de limpieza*/
							System.out.println("fin limpieza premezcla");
							//65
							modbus.ModbusSimple.EscribirC(1, 65, true);
							
						}
						else
							if(existeId("m3_14", Lu.LugaresActivos()))
							{
								/* escritura en modbus fin de transferencia*/
								System.out.println("fin tramsferencia");
								modbus.ModbusSimple.EscribirC(1, 61, true);
								//61
								
							}
			
		}
		
		
		
		
		
		
		if(existeId("m3_3", Lu.LugaresActivos()))
		{
			if(modbus.ModbusSimple.LeerHC(1,4)||modbus.ModbusSimple.LeerHC(1,7)||modbus.ModbusSimple.LeerHC(1,9)||modbus.ModbusSimple.LeerHC(1,12)||modbus.ModbusSimple.LeerHC(1,15)||modbus.ModbusSimple.LeerHC(1,18))
			{
			Lu.getById("m_PLC").setFichas(1);
			}
			
			
		}
		/*fin acciones supervisor pm*/
		
	}
	
	
	
	
	
	
	/*acciones que se ejecutan en la red de petir del transporte*/
	public static void ejecucionTr(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda)
	{
		
		
		/*
		 * acciones del coordnador local de transporte
		 * */
		
		if(existeId("m4_2",Lu.LugaresActivos())&&existeId("m4_1",Lu.LugaresActivos()))
		{
		transporteenProduccion=proximaOPintura.getOrdenTransporte();
		
		}
	
		
		if(existeId("m4_3",Lu.LugaresActivos()))
			{
			
			configurarTransporte(transporteenProduccion, Lu);
			}
		
		
		if(existeId("mc1_8", Lu.LugaresActivos()))
			{
			transporteenProduccion.actualizaPorcentaje(Lu.getById("m4_19").getFichas());
			
			}
		
		/*
		 * acciones del supervisor de transporte 
		 * */
		
		if(existeId("m5_2",Lu.LugaresActivos()))
			{
			
			/*encender los gpio para transporte sin molienda*/
			System.out.println("transporte sin molienda on");
			SimpleGPIO.encender(trSinMolienda);
			
			TemporizarTransicion(2000, Transicion.ListadeTransiciones.getById("T5_12"));
			
			}
		
		
		
		
		
		
		if(existeId("m5_4",Lu.LugaresActivos()))
		{
			/*encender los gpio para transporte con molienda*/
			System.out.println("transporte con molienda on");
			SimpleGPIO.encender(trConMolienda);
			TemporizarTransicion(2000, Transicion.ListadeTransiciones.getById("T5_13"));
			
		}
	
		
		

		if(existeId("m5_18",Lu.LugaresActivos())||existeId("m5_19",Lu.LugaresActivos()))
			{
			
			/*deteccion de falla*/
			if(!SimpleGPIO.leer(trSensorFlujo)){Lugar.todosLosLugares.getById("m4_f1").setFichas(1);}
			else								{
												Lugar.todosLosLugares.getById("m4_f1").setFichas(0);
												}
			
			
			}
		
		
		if(existeId("m5_6",Lu.LugaresActivos()))
		{
			/*encender los gpio para limpieza*/
			System.out.println("transporte en limpieza on");
		
			SimpleGPIO.encender(trLimpieza);
			TemporizarTransicion(temp_tr_limpieza,Transicion.ListadeTransiciones.getById("T5_8"));
			
			
		}
		
		
		
		if(existeId("m5_3",Lu.LugaresActivos()))
		{

			/*apagar los gpio para transporte sin molienda*/
			System.out.println("transporte sin molienda off");
			SimpleGPIO.apagar(trSinMolienda);
			
		}
		
		if(existeId("m5_5",Lu.LugaresActivos()))
		{
			
			/*apagar los gpio para transporte con molienda*/
			System.out.println("transporte con molienda off");
			SimpleGPIO.apagar(trConMolienda);
			
		}
		if(existeId("m5_7",Lu.LugaresActivos()))
		{
			
			/*apagar los gpio para limpieza*/
			System.out.println("transporte en limpieza off");
			SimpleGPIO.apagar(trLimpieza);
		}
	
	
	}
	
	
	
	
	
	/*acciones que se ejecutan en la red de petri del coordinador*/
	
	
	public static void ejecutorCo(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda)
	{	
		/*la cantidad de fichas en m1_1, es la cantidad de ordenes sin producier en la agenda*/
		Lu.getById("m1_1").setFichas(ordenesPorProducir(Agenda));
		
		
		
		LinkedList<String> activos		=	Lu.LugaresActivos();
		
		/*accion antes de T1_1*/		
	
		
		if(!T.getById("T1_1").getActivada()&&T.getById("T1_1").estaHabilitada(Lu))
	
		
		{ 	proximaOPintura	=	ProximaOrdenAgenda(Agenda);
			proximaOPintura.setprocesada();
			
		}
	
		if(existeId("m1_3",Lu.LugaresActivos())&&!T.getById("T1_2").getActivada())
		{
			
		
			
			proximaOPm=proximaOPintura.getOrdenPremezcla();
			proximaOTr=proximaOPintura.getOrdenTransporte();
			proximaOAg=proximaOPintura.getOrdenAgitado();
		
			
			
		}
		
		
		
		//actualizando ordenes producidas (envio a la base de datos)
		
				//if(existeId("m1_24",Lu.LugaresActivos())&&!T.getById("T1_2").getActivada())
				if(existeId("m1_24",Lu.LugaresActivos()))
							
				{
					
					db.pruebaconector();
					
					db.conectar();
					
					int numero=agitadoenProduccion.getidOrdenPintura();
					
					
					
				
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								db.enviar_orden_db(numero, Agenda);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							Utilidades.getOrdenFromLista(numero,Agenda).setCompletado();
							
						}
					}).start();
					
					
						}
			
		
		
		
		
	}
	
	
	public static void ejecutorAg(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda)
	{
		if(existeId("m7_1", Lu.LugaresActivos())&&existeId("m7_19", Lu.LugaresActivos()))
		{
			agitadoenProduccion=proximaOAg;
			
		}
		
		
		if(existeId("m7_2", Lu.LugaresActivos()))
		{
			configurarAgitado(agitadoenProduccion, Lu);
			
		}
		
		if(existeId("m6_2", Lu.LugaresActivos()))
		{
			System.out.println("agitado esperando materia");
			
		}
		
		if(existeId("m6_3", Lu.LugaresActivos()))
		{
			
			if(existeId("m6_8", Lu.LugaresActivos()))
			{ 
				
				System.out.println("iniciando agitado pintura blanca lote completo");
			
			}
			else
				if(existeId("m6_10", Lu.LugaresActivos()))
				{
					System.out.println("iniciando agitado pintura blanca medio lote");
				}
				else
					if(existeId("m6_12", Lu.LugaresActivos()))
					{
						System.out.println("iniciando agitado pintura marron lote completo");
					}
					else
						if(existeId("m6_14", Lu.LugaresActivos()))
						{
							System.out.println("iniciando agitado pintura marron medio lote");
						}
			
			}
		
			
		
		
		
		if(existeId("m6_5", Lu.LugaresActivos()))
		{
			
			if(existeId("m6_8", Lu.LugaresActivos()))
			{ 
				
				System.out.println("agitando pintura blanca lote completo");
				TemporizarTransicion(temp_a_VI,Transicion.ListadeTransiciones.getById("T6_6"));
			
			}
			else
				if(existeId("m6_10", Lu.LugaresActivos()))
				{
					System.out.println("agitando pintura blanca medio lote");
					TemporizarTransicion(temp_a_VI/2,Transicion.ListadeTransiciones.getById("T6_6"));
				}
				else
					if(existeId("m6_12", Lu.LugaresActivos()))
					{
						System.out.println("agitando pintura marron lote completo");
						TemporizarTransicion(temp_a_VI2,Transicion.ListadeTransiciones.getById("T6_6"));
					}
					else
						if(existeId("m6_14", Lu.LugaresActivos()))
						{
							System.out.println("agitando pintura marron medio lote");
							TemporizarTransicion(temp_a_VI2/2,Transicion.ListadeTransiciones.getById("T6_6"));
						}
			
			}
		
		
		
			if(existeId("m6_30", Lu.LugaresActivos()))
			{
				
				if(existeId("m6_16", Lu.LugaresActivos())){
					System.out.println("iniciando limpieza  agitado \n");
					TemporizarTransicion(temp_a_limpieza,Transicion.ListadeTransiciones.getById("T6_6"));
				
				}
				if(existeId("m6_17", Lu.LugaresActivos()))
				{	System.out.println("iniciando envio a almacen \n");
				
				if(existeId("m6_9", Lu.LugaresActivos()))
					{
					System.out.println(" envio a almacen LC\n");
					TemporizarTransicion(temp_a_vaciado,Transicion.ListadeTransiciones.getById("T6_6"));
					
					
					}
				if(existeId("m6_13", Lu.LugaresActivos()))
				{
				System.out.println(" envio a almacen LC\n");
				TemporizarTransicion(temp_a_vaciado2,Transicion.ListadeTransiciones.getById("T6_6"));
				
				
				}
			
				if(existeId("m6_11", Lu.LugaresActivos()))
					{
					
					System.out.println(" envio a almacen ML  \n");
					TemporizarTransicion(temp_a_vaciado/2,Transicion.ListadeTransiciones.getById("T6_6"));
						
					}
				if(existeId("m6_15", Lu.LugaresActivos()))
				{
				System.out.println(" envio a almacen LC\n");
				TemporizarTransicion(temp_a_vaciado2/2,Transicion.ListadeTransiciones.getById("T6_6"));
				
				
				}
			
			
			
			}
				
			
			
			}
			
			if(existeId("m6_6",Lu.LugaresActivos()))
			{
				
				if(existeId("m6_8",Lu.LugaresActivos())){System.out.println("agitando pintura blanca lote completo");}
				if(existeId("m6_10",Lu.LugaresActivos())){System.out.println("agitando pintura blanca medio lote");}
				if(existeId("m6_12",Lu.LugaresActivos())){System.out.println("agitando pintura marron lote completo");}
				if(existeId("m6_14",Lu.LugaresActivos())){System.out.println("agitando pintura marron medio lote");}
				if(existeId("m6_16",Lu.LugaresActivos())){System.out.println("realizando limpieza");}
				if(existeId("m6_17",Lu.LugaresActivos())){System.out.println("envio a almacen");}
				
				
				
				
				
			}
			
			if(existeId("m6_7",Lu.LugaresActivos()))
			{
				
				if(existeId("m6_8",Lu.LugaresActivos())){System.out.println("finalizando agitado pintura blanca lote completo");}
				if(existeId("m6_10",Lu.LugaresActivos())){System.out.println("finalizando agitado pintura blanca medio lote");}
				if(existeId("m6_12",Lu.LugaresActivos())){System.out.println("finalizando agitado pintura marron lote completo");}
				if(existeId("m6_14",Lu.LugaresActivos())){System.out.println("finalizando agitado pintura marron medio lote");}
				if(existeId("m6_16",Lu.LugaresActivos())){System.out.println("finalizando limpieza");}
				if(existeId("m6_17",Lu.LugaresActivos())){System.out.println("finalizando envio a almacen");}
				
				
			}
			
			if(existeId("m6_25",Lu.LugaresActivos())||existeId("m6_26",Lu.LugaresActivos())||existeId("m6_27",Lu.LugaresActivos())||existeId("m6_28",Lu.LugaresActivos()))
				
			{
				agitadoenProduccion.actualizaPorcentaje(Lu.getById("m7_17").getFichas());
				
			}
			
	
		
		
		
		
	} 
	
	
	static public void ejecutorFa(ListaLugares Lu,ListaTransiciones T,LinkedList<OrdenPintura> Agenda)
	{
		
		/*premezcla*/
		if(existeId("m2_f1",Lu.LugaresActivos()))
		{
			System.out.println("inicio de drenaje en pm falla");
			modbus.ModbusSimple.EscribirC(1, 74, true);
			
			//modbus 74 true
		}
		
		if(existeId("m2_f2", Lu.LugaresActivos()))
		{		//quitar las banderas de limpieza =)
			if(modbus.ModbusSimple.LeerHC(1,12))
			{
			Lu.getById("m_PLC2").setFichas(1);
			
			}
			
			
		}
		
		if(existeId("m2_f3",Lu.LugaresActivos()))
		{
			System.out.println("inicio de premezcla falla:");
			
			//modbus 65 true
			modbus.ModbusSimple.EscribirC(1, 65, true);
			
			
			
			if(existeId("m3_6",Lu.LugaresActivos()))
			{	System.out.println(" inicio pintura blanca LC");
				modbus.ModbusSimple.EscribirC(1, 51, true);
				//51
				
				
			}
			if(existeId("m3_8",Lu.LugaresActivos()))
			{	System.out.println(" fin pintura blanca LC");
			
				modbus.ModbusSimple.EscribirC(1, 66, true);
				//66
				
			}
			if(existeId("m3_10",Lu.LugaresActivos()))
			{
				System.out.println("inicio pintura marron LC");
				modbus.ModbusSimple.EscribirC(1, 55, true);	
				//55
			}
			if(existeId("m3_12",Lu.LugaresActivos()))
			{
				System.out.println("inicio pintura marron ml");
				modbus.ModbusSimple.EscribirC(1, 70, true);	
				//70
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		/*aqui va queen espera anade ficha a m_PLC2 cuando esta en aglun estado finalziadoo*/
		
		
		
		
		if(existeId("m2_f4", Lu.LugaresActivos()))
		{		
			if(modbus.ModbusSimple.LeerHC(1,4)||modbus.ModbusSimple.LeerHC(1,7)||modbus.ModbusSimple.LeerHC(1,15)||modbus.ModbusSimple.LeerHC(1,18))
			{
			Lu.getById("m_PLC2").setFichas(1);
			}
			
			
		}
		
		
		/**/
		
		
		
		
		
		
		
		if(existeId("m2_f5",Lu.LugaresActivos()))
		{
			System.out.println("fin de premezcla falla:");
			
			/*cada codigo modbus como en caso anterior*/
		
			
			if(existeId("m3_6",Lu.LugaresActivos()))
			{	System.out.println("fin premezcla blnca lote completo");
				modbus.ModbusSimple.EscribirC(1, 54, true);
				//54
				
				
			}
			if(existeId("m3_8",Lu.LugaresActivos()))
			{	System.out.println("fin pintura blanca ml");
			
				modbus.ModbusSimple.EscribirC(1, 69, true);
				//69
				
			}
			if(existeId("m3_10",Lu.LugaresActivos()))
			{
				System.out.println("fin pintura marron LC");
				modbus.ModbusSimple.EscribirC(1, 58, true);	
				//58
			}
			if(existeId("m3_12",Lu.LugaresActivos()))
			{
				System.out.println("fin pintura marron ml");
				modbus.ModbusSimple.EscribirC(1, 73, true);	
				//73
			}
			
			
			
			
			
		
		}
		
		
		
		
		/*transporte*/
		
		if(existeId("m4_f2",Lu.LugaresActivos()))
		{
			System.out.println("cierre de valvulas transporte falla");
			SimpleGPIO.apagar(trConMolienda);
			SimpleGPIO.apagar(trLimpieza);
			SimpleGPIO.apagar(trSinMolienda);
		}
		if(existeId("m4_f6",Lu.LugaresActivos()))
		{
			System.out.println("valvulas transporte falla limpieza  on");
			//TemporizarTransicion(temp_tr_limpieza, Transicion.ListadeTransiciones.getById("T4_5"));
			TemporizarTransicion(temp_tr_limpieza, Transicion.ListadeTransiciones.getById("T4_f5"));
			SimpleGPIO.encender(trLimpieza);
		}
		
		if(existeId("m4_f7",Lu.LugaresActivos()))
		{
			System.out.println("valvulas transporte falla limpieza off");
			SimpleGPIO.apagar(trLimpieza);
		}
		/*Agitado*/
		if(existeId("m7_f1",Lu.LugaresActivos()))
		{
			System.out.println("valvulas Agitado off");
		}
		
	
		
		
		
	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * funcion que se encarga de realizar la configuracion del coordinador de transporte
	 * A partir de una orden de trabajo
	 * */
	
	static void configurarTransporte(OrdenTransporte Ot,ListaLugares Lu)
	{
		int tipo	=	Ot.gettipoTransporte();
		int cantidad	=	Ot.getcantidadTransporte();
		
		Lu.getById("m4_19").setFichas(cantidad);
		
		switch (tipo) {
		case 1:
			System.out.println("configurando transporte sin molienda");
			Lu.getById("m4_17").addFichas();
			break;
		case 2:
			System.out.println("configurando transporte con molienda");
			Lu.getById("m4_18").addFichas();
			break;
		
		default:
			break;
		}
		
		
		
	}
	
	
	
	/*
	 * funcion que se encarga de configurar el coordinador de premezcla a partir de una orden de trabajo
	 * */
	
	static void configurarPremezlca(OrdenPremezcla OPm,ListaLugares Lu)
	{
		int tipo	=	OPm.gettipoPremezcla();
		int cantidad	=	OPm.getcantidadPremezcla();
		
		Lu.getById("m2_23").setFichas(cantidad);
		
		switch (tipo) {
		case 1:
			
			Lu.getById("m2_19").addFichas();
			System.out.println("configurando premezcla blanca lotes completo");
			break;
		
		case 2:
			System.out.println("configurando premezcla blanca con medio lote");
			Lu.getById("m2_20").addFichas();
			
			break;
		
		case 3:
			Lu.getById("m2_21").addFichas();
			System.out.println("configurando premezcla marron lotes completo");
			break;
		
		case 4:
			
			Lu.getById("m2_22").addFichas();
			System.out.println("configurando premezcla marron con medio lotes");
			break;
		
		default:
			break;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	static void configurarAgitado(OrdenAgitado OAg,ListaLugares Lu)
		{
		
		
		int tipo	=	OAg.gettipoAgitado();
		int cantidad	=	OAg.getcantidadAgitado();
		Lu.getById("m7_17").setFichas(cantidad);
		
		switch (tipo) {
		case 1:
			Lu.getById("m7_20").addFichas();
			System.out.println("configurado agitado de pintura blanca lote completa");
			break;
		case 2:
			Lu.getById("m7_21").addFichas();
			System.out.println("configurado agitado de pintura blanca medio lote");
			break;
		case 3:
			Lu.getById("m7_22").addFichas();
			System.out.println("configurado agitado de pintura marron lote completo");
			break;
		case 4:
			Lu.getById("m7_23").addFichas();
			System.out.println("configurado agitado de pintura marron medio lote");
			break;
			
		default:
			break;
		}
		
		}
	
	

	
	/*fucnion que busca un id en una lista de strings*/
	static boolean existeId(String id,LinkedList<String> x)
	{ 
		LinkedList<String> aux	=	(LinkedList<String>) x.clone();
		while(!aux.isEmpty())
		
		{	//if(aux.poll()	==	id)
			if(aux.poll().equals(id))	
				return true;

		}
		return false;
	}
	
	
	
	/*funcion que retorna la proxima orden por procesar de la agenda*/
	static OrdenPintura ProximaOrdenAgenda(LinkedList<OrdenPintura> Agenda)
	{	
		for (int i = 0; i < Agenda.size(); i++) {
			if(!Agenda.get(i).procesada())
			{
				return Agenda.get(i);
			}
			
		}
		
		return null;
	}
	
	
	
	
	
	
	
	/*funcion que retorna la cantidad de ordenes en agenda que aun no han sido procesadas*/
	static int ordenesPorProducir(LinkedList<OrdenPintura> Agenda)
	{int cont	=	0;
	
		for (int i = 0; i < Agenda.size(); i++) {
			
			if(!Agenda.get(i).procesada())
			{
				cont++;
			}
		}
		
		return cont;
	}




	/*static Thread TemporizarTransicion(long t,Transicion T)
	{
	Temporizador temp=new Temporizador(t, T);	
	temp.start();
	return temp;
	}*/
	


	static void TemporizarTransicion(long t,Transicion T)
	{
		if(!T.getTemporizada())
		{	Temporizador temp=new Temporizador(t, T);	
			temp.start();}
	
	}




}
