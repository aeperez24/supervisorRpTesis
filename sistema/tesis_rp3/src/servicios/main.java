/*main de la primera prueba de redthenelsev2 tomando ids de los lugares como strings*/
package servicios;
import Petri.*;
import Ordenes.*;
import modbus.*;

import java.util.LinkedList;

import Ordenes.OrdenAgitado;
import Ordenes.OrdenPintura;
import Ordenes.OrdenPremezcla;
import Ordenes.OrdenTransporte;
public class main implements Runnable {
	
	static LinkedList<OrdenPintura> Agenda=new LinkedList<>();

	public main(){}
	public void run()
	{
		
		
		
		
		
		
		/* inicializacion de las listas de lugares y tranisciones*/
		Lugar.todosLosLugares=new ListaLugares();
		Transicion.ListadeTransiciones=new ListaTransiciones();
		/*finalizacion de la inicializacion */
		
		
		
		
		ListaLugares todosLosLugares=Lugar.todosLosLugares;
		/*inicializacion de los lugares del coordinador general*/
		Lugar m1_1=new Lugar(0,"m1_1");
		Lugar m1_2=new Lugar(0,"m1_2");
		Lugar m1_3=new Lugar(0,"m1_3");
		Lugar m1_4=new Lugar(0,"m1_4");
		Lugar m1_5=new Lugar(0,"m1_5");
		Lugar m1_6=new Lugar(0,"m1_6");
		Lugar m1_7=new Lugar(0,"m1_7");
		Lugar m1_8=new Lugar(0,"m1_8");
		Lugar m1_9=new Lugar(0,"m1_9");
		Lugar m1_10=new Lugar(0,"m1_10");
		Lugar m1_11=new Lugar(0,"m1_11");
		Lugar m1_12=new Lugar(0,"m1_12");
		Lugar m1_13=new Lugar(0,"m1_13");
		Lugar m1_14=new Lugar(0,"m1_14");
		Lugar m1_15=new Lugar(0,"m1_15");
		Lugar m1_16=new Lugar(0,"m1_16");
		Lugar m1_17=new Lugar(0,"m1_17");
		Lugar m1_18=new Lugar(0,"m1_18");
		Lugar m1_19=new Lugar(0,"m1_19");
		Lugar m1_20=new Lugar(0,"m1_20");
		Lugar m1_21=new Lugar(0,"m1_21");
		Lugar m1_22=new Lugar(0,"m1_22");
		Lugar m1_23=new Lugar(0,"m1_23");
		Lugar m1_24=new Lugar(0,"m1_24");
		Lugar m1_25=new Lugar(0,"m1_25");
		
		/*lugares conectores*/
		Lugar mc1_1=new Lugar(0,"mc1_1");
		Lugar mc1_2=new Lugar(0,"mc1_2");
		Lugar mc1_3=new Lugar(0,"mc1_3");
		Lugar mc1_4=new Lugar(0,"mc1_4");
		Lugar mc1_5=new Lugar(0,"mc1_5");
		Lugar mc1_6=new Lugar(0,"mc1_6");
		Lugar mc1_7=new Lugar(0,"mc1_7");
		Lugar mc1_8=new Lugar(0,"mc1_8");
		Lugar mc1_9=new Lugar(0,"mc1_9");
		Lugar mc1_10=new Lugar(0,"mc1_10");
		Lugar mc1_11=new Lugar(0,"mc1_11");
		Lugar mc1_12=new Lugar(0,"mc1_12");
		Lugar mc1_13=new Lugar(0,"mc1_13");
		Lugar mc1_14=new Lugar(0,"mc1_14");
		Lugar mc1_15=new Lugar(0,"mc1_15");
		Lugar mc1_16=new Lugar(0,"mc1_16");
		Lugar mc1_17=new Lugar(0,"mc1_17");
		Lugar mc1_18=new Lugar(0,"mc1_18");
		
		
		
		
		/*fin lugares conectores*/
		/*fin de la inicializacion de los lugares del coordinador genereal*/
		
		
		/*transiciones coordinador general*/
		Transicion T1_1=new Transicion("m1_1,m1_2","m1_3");
		Transicion T1_2=new Transicion("m1_3","m1_4,m1_11,m1_18");
		Transicion T1_3=new Transicion("m1_4,m1_8","m1_5,m1_9");
		Transicion T1_4=new Transicion("m1_5","m1_6");
		Transicion T1_5=new Transicion("m1_6,","m1_7");
		Transicion T1_6=new Transicion("m1_6,m1_9","m1_8,m1_2,m1_10");
		Transicion T1_7=new Transicion("m1_11,m1_15","m1_12,m1_16");
		Transicion T1_8=new Transicion("m1_12","m1_13");
		Transicion T1_9=new Transicion("m1_13","m1_14");
		Transicion T1_10=new Transicion("m1_16,m1_13","m1_17,m1_15");
		Transicion T1_11=new Transicion("m1_18,m1_22","m1_19,m1_23");
		Transicion T1_12=new Transicion("m1_19","m1_20");
		Transicion T1_13=new Transicion("m1_20","m1_21");
		Transicion T1_14=new Transicion("m1_20,m1_23","m1_22,m1_24");

		//transicion sin salida
		Transicion T1_15=new Transicion(0);
		T1_15.addId_L_Entrante("m1_10,m1_17,m1_24");
		//fin transicion sin salida

		Transicion T1_16=new Transicion("m1_14,m1_7,m1_21","m1_25");
		Transicion T1_17=new Transicion("m1_25","m1_6,m1_20,m1_13");

		/*fin transicion coordinador general*/
		
		/*transicion a lugares conectores*/
		
		
		T1_3.addId_L_Saliente("mc1_1");
		T1_4.addId_L_Entrante("mc1_2");
		T1_5.addId_L_Entrante("mc1_3");
		T1_6.addId_L_Entrante("mc1_10");
		T1_7.addId_L_Saliente("mc1_11");
		T1_8.addId_L_Entrante("mc1_12");
		T1_9.addId_L_Entrante("mc1_13");
		T1_10.addId_L_Entrante("mc1_14");
		
		T1_11.addId_L_Saliente("mc1_15");
		T1_12.addId_L_Entrante("mc1_16");
		T1_13.addId_L_Entrante("mc1_17");
		T1_14.addId_L_Entrante("mc1_18");
		T1_16.addId_L_Saliente("mc1_4,mc1_5,mc1_6");
		T1_17.addId_L_Entrante("mc1_7");
		T1_17.addId_L_Saliente("mc1_8,mc1_9");
		
		/*fin transicion lugares conectores*/
	/*inicio de lugares con fichas*/

		
		
	m1_2.addFichas();
	m1_8.addFichas();
	m1_15.addFichas();
	m1_22.addFichas();
		
	/*fin de lugares con fichas*/
	
	
	
	
	/*agregando ids a las transiciones*/
	T1_1.setId("T1_1");
	T1_2.setId("T1_2");
	T1_3.setId("T1_3");
	T1_4.setId("T1_4");
	T1_5.setId("T1_5");
	T1_6.setId("T1_6");
	T1_7.setId("T1_7");
	T1_8.setId("T1_8");
	T1_9.setId("T1_9");
	T1_10.setId("T1_10");
	T1_11.setId("T1_11");
	T1_12.setId("T1_12");
	T1_13.setId("T1_13");
	T1_14.setId("T1_14");
	T1_15.setId("T1_15");
	T1_16.setId("T1_16");
	T1_17.setId("T1_17");
	
	

	/*funciones que deben iniciar desctivadas*/
	T1_1.desactivar();
	T1_2.desactivar();
	T1_7.desactivar();
	T1_11.desactivar();
	T1_12.desactivar();
	
	
	/*fin red de petri coordinador general*/
	
	
	
	

	
/*inicio de la red de petri coordinado de la premzcla*/	
	
	
	
		
	
	Lugar m2_1=new Lugar(0,"m2_1");
	Lugar m2_2=new Lugar(0,"m2_2");
	Lugar m2_3=new Lugar(0,"m2_3");
	Lugar m2_4=new Lugar(0,"m2_4");
	Lugar m2_5=new Lugar(0,"m2_5");
	Lugar m2_6=new Lugar(0,"m2_6");
	Lugar m2_7=new Lugar(0,"m2_7");
	Lugar m2_8=new Lugar(0,"m2_8");
	Lugar m2_9=new Lugar(0,"m2_9");
	Lugar m2_10=new Lugar(0,"m2_10");
	Lugar m2_11=new Lugar(0,"m2_11");
	Lugar m2_12=new Lugar(0,"m2_12");
	Lugar m2_13=new Lugar(0,"m2_13");
	Lugar m2_14=new Lugar(0,"m2_14");
	Lugar m2_15=new Lugar(0,"m2_15");
	Lugar m2_16=new Lugar(0,"m2_16");
	Lugar m2_17=new Lugar(0,"m2_17");
	Lugar m2_18=new Lugar(0,"m2_18");
	Lugar m2_19=new Lugar(0,"m2_19");
	Lugar m2_20=new Lugar(0,"m2_20");
	Lugar m2_21=new Lugar(0,"m2_21");
	Lugar m2_22=new Lugar(0,"m2_22");
	Lugar m2_23=new Lugar(0,"m2_23");
	
	
	
	/*transiciones de coordinacion de premezcla*/
	Transicion T2_1=new Transicion("mc1_1,m2_1,m2_18","m2_2,m2_17");
	Transicion T2_2=new Transicion("m2_2", "m2_3,mc1_2");
	Transicion T2_3=new Transicion("m2_3,m2_14","m2_4,m2_11");
				T2_3.addId_LI_Entrante("m2_22,m2_21");
	Transicion T2_4=new Transicion("m2_20,m2_4","m2_5");
	Transicion T2_5=new Transicion("m2_4,m2_19","m2_6");
	Transicion T2_6=new Transicion("m2_20,m2_3", "m2_5");
				T2_6.addId_LI_Entrante("m2_14");
	Transicion T2_7=new Transicion("m2_5", "m2_6");
	Transicion T2_8=new Transicion("m2_19,m2_3,", "m2_6");
				T2_8.addId_LI_Entrante("m2_14");
	Transicion T2_9=new Transicion("m2_23,m2_6", "m2_6");
	Transicion T2_10=new Transicion("m2_17,m2_6", "m2_10,m2_16");
				T2_10.addId_LI_Entrante("m2_23");
	Transicion T2_11=new Transicion("m2_3,m2_12", "m2_7,m2_11");
				T2_11.addId_LI_Entrante("m2_19,m2_20");
	Transicion T2_12=new Transicion("m2_3,m2_22", "m2_8");
				T2_12.addId_LI_Entrante("m2_12");
	Transicion T2_13=new Transicion("m2_3,m2_21", "m2_9");
				T2_13.addId_LI_Entrante("m2_12");
	Transicion T2_14=new Transicion("m2_7,m2_22", "m2_8");
	Transicion T2_15=new Transicion("m2_7,m2_21", "m2_9");
	Transicion T2_16=new Transicion("m2_8", "m2_9");
	Transicion T2_17=new Transicion("m2_9,m2_23", "m2_9");
	Transicion T2_18=new Transicion("m2_17,m2_9", "m2_13,m2_16");
				T2_18.addId_LI_Entrante("m2_23");
	Transicion T2_19=new Transicion("m2_10,m2_11", "m2_12,m2_15");
	Transicion T2_20=new Transicion("m2_11,m2_13", "m2_14,m2_15");
	Transicion T2_21=new Transicion("m2_10,m2_12", "m2_12,m2_15");
	Transicion T2_22=new Transicion("m2_14,m2_13", "m2_14,m2_15");
	Transicion T2_23=new Transicion("m2_16,m2_15", "m2_18,mc1_10");
	
	/*fin de transiciones de coordinacion de premezcla*/

	/*inicializacion de lugares con fichas*/
	m2_18.addFichas();
	m2_11.addFichas();
	
	/*fin de inicializacion lugares con fichas*/
	
	
	
/*fin de red de petri de coordinacion de premzcla*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
 /*inicio de la red de petri del supervisor de premezcla*/
	
	//inicio lugares del supervisor de premezcla
	Lugar m3_1 =new Lugar(0, "m3_1");
	Lugar m3_2 =new Lugar(0, "m3_2");
	Lugar m3_3 =new Lugar(0, "m3_3");
	Lugar m3_4 =new Lugar(0, "m3_4");
	Lugar m3_5 =new Lugar(0, "m3_5");
	Lugar m3_6 =new Lugar(0, "m3_6");
	Lugar m3_7 =new Lugar(0, "m3_7");
	Lugar m3_8 =new Lugar(0, "m3_8");
	Lugar m3_9 =new Lugar(0, "m3_9");
	Lugar m3_10 =new Lugar(0, "m3_10");
	Lugar m3_11 =new Lugar(0, "m3_11");
	Lugar m3_12 =new Lugar(0, "m3_12");
	Lugar m3_13 =new Lugar(0, "m3_13");
	Lugar m3_14 =new Lugar(0, "m3_14");
	Lugar m3_15 =new Lugar(0, "m3_15");
	Lugar m3_16 =new Lugar(0, "m3_16");
	Lugar m3_17 =new Lugar(0, "m3_17");
	Lugar m3_18 =new Lugar(0, "m3_18");
	Lugar m3_19 =new Lugar(0, "m3_19");
	Lugar m3_20 =new Lugar(0, "m3_20");
	Lugar m3_21 =new Lugar(0, "m3_21");
	Lugar m3_22 =new Lugar(0, "m3_22");
	Lugar m3_23 =new Lugar(0, "m3_23");
	Lugar m3_24 =new Lugar(0, "m3_24");
	Lugar m3_25 =new Lugar(0, "m3_25");
	Lugar m3_26 =new Lugar(0, "m3_26");
	Lugar m3_27 =new Lugar(0, "m3_27");
	
	//fin de lugares del supervisor de premezcla
	
	// inicio de fichas supervisor de premezla
	
	m3_1.addFichas();
	//fin de inicio de fichas supervisor de premezcla
	
	
	
	
	
	//inicio transiciones del supervisor
	Transicion T3_1=new Transicion("m3_1,m3_18","m3_2,m3_5,m3_17");
	Transicion T3_2=new Transicion("m3_2","m3_3");
	Transicion T3_3=new Transicion("m3_3","m3_4");
	Transicion T3_4=new Transicion("m3_4,m3_5","m3_6,m3_15");
	Transicion T3_5=new Transicion("m3_1,m3_19","m3_2,m3_7,m3_17");
	Transicion T3_6=new Transicion("m3_4,m3_7","m3_8,m3_15");
	Transicion T3_7=new Transicion("m3_1,m3_20","m3_2,m3_9,m3_17");
	Transicion T3_8=new Transicion("m3_4,m3_9","m3_10,m3_15");
	Transicion T3_9=new Transicion("m3_1,m3_21","m3_2,m3_11,m3_17");
	Transicion T3_10=new Transicion("m3_4,m3_11","m3_12,m3_15");
	Transicion T3_11=new Transicion("m3_1,m3_22","m3_2,m3_13,m3_17");
	Transicion T3_12=new Transicion("m3_13,m3_4,m3_17","m3_1,m3_27");
	Transicion T3_13=new Transicion("m3_16,mc1_4","m3_2,m3_14");
	Transicion T3_14=new Transicion("m3_6,m3_4,m3_17,m3_14","m3_23,m3_1,mc1_7");
	Transicion T3_15=new Transicion("m3_8,m3_4,m3_17,m3_14","m3_24,m3_1,mc1_7");
	Transicion T3_16=new Transicion("m3_10,m3_4,m3_17,m3_14","m3_25,m3_1,mc1_7");
	Transicion T3_17=new Transicion("m3_12,m3_4,m3_17,m3_14","m3_26,m3_1,mc1_7");
	Transicion T3_18=new Transicion("m3_15","m3_16,mc1_3");
	
	//conexion con el PLC
	
	Lugar m_PLC=new Lugar(0,"m_PLC");
	T3_3.addId_L_Entrante("m_PLC");
	//fin transiciones del supervisor
	
/*fin de la red de petri del supervisor de premezcla*/
	
	
	/*conexion entre el supervisor y el coordinador de premezcla*/
	
	T2_8.addId_L_Saliente("m3_18");
	T2_5.addId_L_Saliente("m3_18");
	T2_7.addId_L_Saliente("m3_18");
	T2_9.addId_L_Saliente("m3_18");
	T2_4.addId_L_Saliente("m3_19");
	T2_6.addId_L_Saliente("m3_19");
	T2_16.addId_L_Saliente("m3_20");
	T2_13.addId_L_Saliente("m3_20");
	T2_17.addId_L_Saliente("m3_20");
	T2_15.addId_L_Saliente("m3_20");
	T2_12.addId_L_Saliente("m3_21");
	T2_14.addId_L_Saliente("m3_21");
	T2_3.addId_L_Saliente("m3_22");
	T2_11.addId_L_Saliente("m3_22");
	T2_9.addId_L_Entrante("m3_23");
	T2_10.addId_L_Entrante("m3_23");
	T2_7.addId_L_Entrante("m3_24");
	
	
	
	T2_17.addId_L_Entrante("m3_25");
	T2_18.addId_L_Entrante("m3_25");
	T2_16.addId_L_Entrante("m3_26");
	T2_4.addId_L_Entrante("m3_27");
	T2_5.addId_L_Entrante("m3_27");
	T2_14.addId_L_Entrante("m3_27");
	T2_15.addId_L_Entrante("m3_27");
	
	/* fin de la conexion entre el supervisor y el coordinador de premezcla*/
	
	/* transicion comun con el cooridnador general*/
	 T1_2.addId_L_Saliente(m2_1);
	 
	 /* agregandos ids a las transiciones*/
	T2_1.setId("T2_1");
	T2_2.setId("T2_2");
	T2_3.setId("T2_3");
	T2_4.setId("T2_4");
	T2_5.setId("T2_5");
	T2_6.setId("T2_6");
	T2_7.setId("T2_7");
	T2_8.setId("T2_8");
	T2_9.setId("T2_9");
	T2_10.setId("T2_10");
	T2_11.setId("T2_11");
	T2_12.setId("T2_12");
	T2_13.setId("T2_13");
	T2_14.setId("T2_14");
	T2_15.setId("T2_15");
	T2_16.setId("T2_16");
	T2_17.setId("T2_17");
	T2_18.setId("T2_18");
	T2_19.setId("T2_19");
	T2_20.setId("T2_20");
	T2_21.setId("T2_21");
	T2_22.setId("T2_22");
	T2_23.setId("T2_23");
	
	T3_1.setId("T3_1");
	T3_2.setId("T3_2");
	T3_3.setId("T3_3");
	T3_4.setId("T3_4");
	T3_5.setId("T3_5");
	T3_6.setId("T3_6");
	T3_7.setId("T3_7");
	T3_8.setId("T3_8");
	T3_9.setId("T3_9");
	T3_10.setId("T3_10");
	T3_11.setId("T3_11");
	T3_12.setId("T3_12");
	T3_13.setId("T3_13");
	T3_14.setId("T3_14");
	T3_15.setId("T3_15");
	T3_16.setId("T3_16");
	T3_17.setId("T3_17");
	T3_18.setId("T3_18");
	
	
	
	
	
	
	
	/*inicio de la red de petri coordinador de la transporte*/	
	
	/* inicio inicializacion de lugares*/
	Lugar m4_1=new Lugar(0,"m4_1");
	Lugar m4_2=new Lugar(0,"m4_2");
	Lugar m4_3=new Lugar(0,"m4_3");
	Lugar m4_4=new Lugar(0,"m4_4");
	Lugar m4_5=new Lugar(0,"m4_5");
	Lugar m4_6=new Lugar(0,"m4_6");
	Lugar m4_7=new Lugar(0,"m4_7");
	Lugar m4_8=new Lugar(0,"m4_8");
	Lugar m4_9=new Lugar(0,"m4_9");
	Lugar m4_10=new Lugar(0,"m4_10");
	Lugar m4_11=new Lugar(0,"m4_11");
	Lugar m4_12=new Lugar(0,"m4_12");
	Lugar m4_13=new Lugar(0,"m4_13");
	Lugar m4_14=new Lugar(0,"m4_14");
	Lugar m4_15=new Lugar(0,"m4_15");
	Lugar m4_16=new Lugar(0,"m4_16");
	Lugar m4_17=new Lugar(0,"m4_17");
	Lugar m4_18=new Lugar(0,"m4_18");
	Lugar m4_19=new Lugar(0,"m4_19");
	Lugar m4_20=new Lugar(0,"m4_20");
	
	
	
	/*fin inicializacion de lugares */
	
	
	
	/*transiciones de coordinacion de transporte*/
	Transicion T4_1=new Transicion("mc1_11,m4_2,m4_1","m4_20,m4_3");
	Transicion T4_2=new Transicion("m4_3","mc1_12,m4_4");
	Transicion T4_3=new Transicion("m4_17,m4_4","m4_6");
				T4_3.addId_LI_Entrante("m4_12");
	Transicion T4_4=new Transicion("m4_6","m4_7,m4_15");
				T4_4.addId_LI_Entrante("m4_19");
	Transicion T4_5=new Transicion("m4_7,m4_8","m4_8,m4_14,m4_16");
	Transicion T4_6=new Transicion("m4_4,m4_17,m4_12","m4_5,m4_13");
				T4_6.addId_LI_Entrante("m4_8");
	Transicion T4_7=new Transicion("m4_5","m4_6");
	Transicion T4_8=new Transicion("m4_6,m4_19","m4_6");
	Transicion T4_9=new Transicion("m4_7,m4_13","m4_14,m4_16,m4_8");
	Transicion T4_10=new Transicion("m4_4,m4_8,m4_18","m4_9,m4_13");
				T4_10.addId_LI_Entrante("m4_12");
	Transicion T4_11=new Transicion("m4_9","m4_10");
	Transicion T4_12=new Transicion("m4_19,m4_10","m4_10");
	Transicion T4_13=new Transicion("m4_13,m4_11","m4_14,m4_12,m4_16");
	Transicion T4_14=new Transicion("m4_4,m4_18","m4_10");
				T4_14.addId_LI_Entrante("m4_8");
	Transicion T4_15=new Transicion("m4_10","m4_11,m4_15");
				T4_15.addId_LI_Entrante("m4_19");
	Transicion T4_16=new Transicion("m4_11,m4_12","m4_12,m4_14,m4_16");
	Transicion T4_17=new Transicion("m4_14,m4_15,m4_16,m4_20","mc1_14,m4_1");
	
	
	
	
	/*fin de transiciones de coordinacion de transporte*/

	
	
	
	/*inicializacion de lugares con fichas*/
	
	m4_1.addFichas();
	m4_13.addFichas();
	/*fin de inicializacion lugares con fichas*/
	
	/* transicion comun con el coordinador*/
	T1_2.addId_L_Saliente("m4_2");




		
/*fin de red de petri de coordinacion de la tranpsorte*/


	

	
	
	
	
	
/*inicio de la red de petri supervision de la transporte*/	
	
	/* inicio inicializacion de lugares*/
	Lugar m5_1=new Lugar(0,"m5_1");
	Lugar m5_2=new Lugar(0,"m5_2");
	Lugar m5_3=new Lugar(0,"m5_3");
	Lugar m5_4=new Lugar(0,"m5_4");
	Lugar m5_5=new Lugar(0,"m5_5");
	Lugar m5_6=new Lugar(0,"m5_6");
	Lugar m5_7=new Lugar(0,"m5_7");
	Lugar m5_8=new Lugar(0,"m5_8");
	Lugar m5_9=new Lugar(0,"m5_9");
	Lugar m5_10=new Lugar(0,"m5_10");
	Lugar m5_11=new Lugar(0,"m5_11");
	Lugar m5_12=new Lugar(0,"m5_12");
	Lugar m5_13=new Lugar(0,"m5_13");
	Lugar m5_14=new Lugar(0,"m5_14");
	Lugar m5_15=new Lugar(0,"m5_15");
	Lugar m5_16=new Lugar(0,"m5_16");
	Lugar m5_17=new Lugar(0,"m5_17");
	Lugar m5_18=new Lugar(0,"m5_18");
	Lugar m5_19=new Lugar(0,"m5_19");
	
	
	
	/*fin inicializacion de lugares */
	
	
	
	/*transiciones de supervisor de transporte*/
	Transicion T5_1=new Transicion("m5_1,m5_14,mc1_5","m5_17,m5_2");
	Transicion T5_2=new Transicion("m5_18,mc1_8","m5_3");
	Transicion T5_3=new Transicion("m5_3,m5_17","m5_1,m5_8");
	Transicion T5_4=new Transicion("mc1_5,m5_1,m5_15","m5_17,m5_4");
	Transicion T5_5=new Transicion("m5_19,mc1_8","m5_5");
	Transicion T5_6=new Transicion("m5_5,m5_17","m5_1,m5_9");
	Transicion T5_7=new Transicion("m5_13,m5_1","m5_17,m5_6");
	Transicion T5_8=new Transicion("m5_6","m5_7");
	Transicion T5_9=new Transicion("m5_7,m5_17","m5_1,m5_10");
	Transicion T5_10=new Transicion("m5_11","mc1_13,m5_14");
	Transicion T5_11=new Transicion("m5_12","mc1_13,m5_15");
	
	/*transicion agregada despues*/
	Transicion T5_12=new Transicion("m5_2","m5_18");
	Transicion T5_13=new Transicion("m5_4","m5_19");
	
	/*fin de transiciones de coordinacion de transporte*/

	
	
	
	/*inicializacion de lugares con fichas*/
	
	m5_1.addFichas();
	/*fin de inicializacion lugares con fichas*/
	
		
	/*fin de red de petri de supervision de transporte*/

	
	/*inicio conexion supervisor-coordinador transporte*/	
	T4_3.addId_L_Saliente("m5_11");
	T4_7.addId_L_Saliente("m5_11");
	T4_8.addId_L_Saliente("m5_11");
	T4_11.addId_L_Saliente("m5_12");
	T4_12.addId_L_Saliente("m5_12");
	T4_6.addId_L_Saliente("m5_13");
	T4_10.addId_L_Saliente("m5_13");
	T4_14.addId_L_Saliente("m5_12");


	T4_4.addId_L_Entrante("m5_8");
	T4_8.addId_L_Entrante("m5_8");
	T4_12.addId_L_Entrante("m5_9");
	T4_15.addId_L_Entrante("m5_9");
	T4_7.addId_L_Entrante("m5_10");
	T4_11.addId_L_Entrante("m5_10");
	
	
	
	
	/*colocacion de ids a las transiciones */
	
	T4_1.setId("T4_1");
	T4_2.setId("T4_2");
	T4_3.setId("T4_3");
	T4_4.setId("T4_4");
	T4_5.setId("T4_5");
	T4_6.setId("T4_6");
	T4_7.setId("T4_7");
	T4_8.setId("T4_8");
	T4_9.setId("T4_9");
	T4_10.setId("T4_10");
	T4_11.setId("T4_11");
	T4_12.setId("T4_12");
	T4_13.setId("T4_13");
	T4_14.setId("T4_14");
	T4_15.setId("T4_15");
	T4_16.setId("T4_16");
	T4_17.setId("T4_17");
	
	T5_1.setId("T5_1");
	T5_2.setId("T5_2");
	T5_3.setId("T5_3");
	T5_4.setId("T5_4");
	T5_5.setId("T5_5");
	T5_6.setId("T5_6");
	T5_7.setId("T5_7");
	T5_8.setId("T5_8");
	T5_9.setId("T5_9");
	T5_10.setId("T5_10");
	T5_11.setId("T5_11");
	T5_12.setId("T5_12");
	T5_13.setId("T5_13");
	
	/*fin de conexion supervisor  coordnador transporte*/	

	
	
/*inicio de red de petri coordinacion de agitado */
		
	
	//inicio transiciones comunes
		
	//fin transiciones comunes con corrdinacion 
	
	
	
		
	/*lugares de coordinador de agitado*/
		Lugar m7_1=new Lugar(0,"m7_1");
		Lugar m7_2=new Lugar(0,"m7_2");
		Lugar m7_3=new Lugar(0,"m7_3");
		Lugar m7_4=new Lugar(0,"m7_4");
		Lugar m7_5=new Lugar(0,"m7_5");
		Lugar m7_6=new Lugar(0,"m7_6");
		Lugar m7_7=new Lugar(0,"m7_7");
		Lugar m7_8=new Lugar(0,"m7_8");
		Lugar m7_9=new Lugar(0,"m7_9");
		Lugar m7_10=new Lugar(0,"m7_10");
		Lugar m7_11=new Lugar(0,"m7_11");
		Lugar m7_12=new Lugar(0,"m7_12");
		Lugar m7_13=new Lugar(0,"m7_13");
		Lugar m7_14=new Lugar(0,"m7_14");
		Lugar m7_15=new Lugar(0,"m7_15");
		Lugar m7_16=new Lugar(0,"m7_16");
		Lugar m7_17=new Lugar(0,"m7_17");
		Lugar m7_18=new Lugar(0,"m7_18");
		Lugar m7_19=new Lugar(0,"m7_19");
		Lugar m7_20=new Lugar(0,"m7_20");
		Lugar m7_21=new Lugar(0,"m7_21");
		Lugar m7_22=new Lugar(0,"m7_22");
		Lugar m7_23=new Lugar(0,"m7_23");
		
	
	
	
	
	
	
	/*transiciones de coordinacion de agitado*/
	Transicion T7_1=new Transicion("m7_19,m7_1","m7_2,m7_18");
	Transicion T7_2=new Transicion("m7_2","m7_3");
	Transicion T7_3=new Transicion("m7_3,m7_12","m7_4,m7_14");
					T7_3.addId_LI_Entrante("m7_22,m7_23");
	Transicion T7_4=new Transicion("m7_21,m7_4","m7_5");
	Transicion T7_5=new Transicion("m7_4,m7_20","m7_6");
	Transicion T7_6=new Transicion("m7_21,m7_3","m7_5");
				T7_6.addId_LI_Entrante("m7_12");
	Transicion T7_7=new Transicion("m7_5","m7_6");
	Transicion T7_8=new Transicion("m7_6,m7_17","m7_6");
	Transicion T7_9=new Transicion("m7_3,m7_20","m7_6");
				T7_9.addId_LI_Entrante("m7_12");
	Transicion T7_10=new Transicion("m7_3,m7_23","m7_8");
				T7_10.addId_LI_Entrante("m7_11");
	Transicion T7_11=new Transicion("m7_8","m7_9");
	Transicion T7_12=new Transicion("m7_9,m7_17","m7_9");
	Transicion T7_13=new Transicion("m7_11,m7_3","m7_7,m7_14");
					T7_13.addId_LI_Entrante("m7_20,m7_21");
	Transicion T7_14=new Transicion("m7_3,m7_22","m7_9");
					T7_14.addId_LI_Entrante("m7_11");
	Transicion T7_15=new Transicion("m7_23,m7_7","m7_8");
	Transicion T7_16=new Transicion("m7_7,m7_22","m7_9");
	Transicion T7_17=new Transicion("m7_6,m7_18","m7_10,m7_15");
					T7_17.addId_LI_Entrante("m7_17");
	Transicion T7_18=new Transicion("m7_10,m7_14","m7_16,m7_11");
	Transicion T7_19=new Transicion("m7_10","m7_16");
					T7_19.addId_LI_Entrante("m7_14");
	Transicion T7_20=new Transicion("m7_9,m7_18","m7_13,m7_15");
					T7_20.addId_LI_Entrante("m7_17");
	Transicion T7_21=new Transicion("m7_13,m7_14","m7_12,m7_16");
	Transicion T7_22=new Transicion("m7_13","m7_16");
					T7_22.addId_LI_Entrante("m7_14");
	Transicion T7_23=new Transicion("m7_16,m7_15","m7_19");
	
	
		/*transiciones coonectadas con el supervisor*/
			
	T7_5.addId_L_Saliente("m6_20");
	T7_7.addId_L_Saliente("m6_20");
	T7_8.addId_L_Saliente("m6_20");
	T7_9.addId_L_Saliente("m6_20");
	
	T7_4.addId_L_Saliente("m6_21");
	T7_6.addId_L_Saliente("m6_21");
	
	T7_11.addId_L_Saliente("m6_22");
	T7_12.addId_L_Saliente("m6_22");
	T7_14.addId_L_Saliente("m6_22");
	T7_16.addId_L_Saliente("m6_22");
	
	T7_10.addId_L_Saliente("m6_23");
	T7_15.addId_L_Saliente("m6_23");
	
	T7_13.addId_L_Saliente("m6_24");
	T7_3.addId_L_Saliente("m6_24");
	
	T7_17.addId_L_Entrante("m6_25");
	T7_8.addId_L_Entrante("m6_25");
	
	T7_7.addId_L_Entrante("m6_26");
	
	T7_20.addId_L_Entrante("m6_27");
	T7_12.addId_L_Entrante("m6_27");
	
	T7_11.addId_L_Entrante("m6_28");
	
	T7_4.addId_L_Entrante("m6_29");
	T7_5.addId_L_Entrante("m6_29");
	T7_15.addId_L_Entrante("m6_29");
	T7_16.addId_L_Entrante("m6_29");
	
	
	
	/*fin de transiciones de coordinacion de agitado*/
	
	
	/*id transiciones*/
	T7_1.setId("1");
	T7_2.setId("2");
	T7_3.setId("3");
	T7_4.setId("4");
	T7_5.setId("5");
	T7_6.setId("6");
	T7_7.setId("7");
	T7_8.setId("8");
	T7_9.setId("9");
	T7_10.setId("10");
	T7_11.setId("11");
	T7_12.setId("12");
	T7_13.setId("13");
	T7_14.setId("14");
	T7_15.setId("15");
	T7_16.setId("16");
	T7_17.setId("17");
	T7_18.setId("18");
	T7_19.setId("19");
	T7_20.setId("20");
	T7_21.setId("21");
	T7_22.setId("22");
	T7_23.setId("23");
	
	
	
	
	/* transicion comun con el coordinador*/
	
	T1_2.addId_L_Saliente("m7_1");
	
	/*fin transicion comun con el coordinador*/
	
	/*inicializacion de lugares con fichas*/

	m7_19.addFichas();
	m7_14.addFichas();
	
	/*fin de inicializacion lugares con fichas*/
	
	
/*fin de red de petri de coordinacion de premzcla*/
	
	
/*inicio de red de petri supervison de agitado */
		
	
	
	/*lugares supervision agitado*/
	
	
		
	
		Lugar m6_1=new Lugar(0,"m6_1");
		Lugar m6_2=new Lugar(0,"m6_2");
		Lugar m6_3=new Lugar(0,"m6_3");
		Lugar m6_4=new Lugar(0,"m6_4");
		Lugar m6_5=new Lugar(0,"m6_5");
		Lugar m6_6=new Lugar(0,"m6_6");
		Lugar m6_7=new Lugar(0,"m6_7");
		Lugar m6_8=new Lugar(0,"m6_8");
		Lugar m6_9=new Lugar(0,"m6_9");
		Lugar m6_10=new Lugar(0,"m6_10");
		Lugar m6_11=new Lugar(0,"m6_11");
		Lugar m6_12=new Lugar(0,"m6_12");
		Lugar m6_13=new Lugar(0,"m6_13");
		Lugar m6_14=new Lugar(0,"m6_14");
		Lugar m6_15=new Lugar(0,"m6_15");
		Lugar m6_16=new Lugar(0,"m6_16");
		Lugar m6_17=new Lugar(0,"m6_17");
		Lugar m6_18=new Lugar(0,"m6_18");
		Lugar m6_19=new Lugar(0,"m6_19");
		Lugar m6_20=new Lugar(0,"m6_20");
		Lugar m6_21=new Lugar(0,"m6_21");
		Lugar m6_22=new Lugar(0,"m6_22");
		Lugar m6_23=new Lugar(0,"m6_23");
		Lugar m6_24=new Lugar(0,"m6_24");
		Lugar m6_25=new Lugar(0,"m6_25");
		Lugar m6_26=new Lugar(0,"m6_26");
		Lugar m6_27=new Lugar(0,"m6_27");
		Lugar m6_28=new Lugar(0,"m6_28");
		Lugar m6_29=new Lugar(0,"m6_29");
		Lugar m6_30=new Lugar(0,"m6_30");
		
	
	
	/*transiciones de coordinacion de agitado*/
	Transicion T6_1=new Transicion("m6_1","m6_2,m6_8,m6_19");
	Transicion T6_2=new Transicion("m6_2","m6_3");
	Transicion T6_3=new Transicion("m6_3","m6_4");
	Transicion T6_4=new Transicion("m6_4","m6_5");
	Transicion T6_5=new Transicion("m6_5","m6_6");
	Transicion T6_6=new Transicion("m6_6","m6_7");
	Transicion T6_7=new Transicion("m6_8,m6_7","m6_9,m6_18");
	Transicion T6_8=new Transicion("m6_1","m6_2,m6_10,m6_19");
	Transicion T6_9=new Transicion("m6_10,m6_7","m6_11,m6_18");
	Transicion T6_10=new Transicion("m6_1,","m6_2,m6_12,m6_19");
	Transicion T6_11=new Transicion("m6_12,m6_7","m6_13,m6_18");
	Transicion T6_12=new Transicion("m6_1,","m6_2,m6_14,m6_19");
	Transicion T6_13=new Transicion("m6_14,m6_7","m6_15,m6_18");
	Transicion T6_14=new Transicion("m6_1","m6_16,m6_30,m6_19");
	Transicion T6_15=new Transicion("m6_16,m6_7,m6_19","m6_1");
	Transicion T6_16=new Transicion("m6_18","m6_17,m6_30");
	Transicion T6_17=new Transicion("m6_7,m6_9,m6_17,m6_19","m6_1");
	Transicion T6_18=new Transicion("m6_7,m6_11,m6_17,m6_19","m6_1");
	Transicion T6_19=new Transicion("m6_7,m6_13,m6_17,m6_19","m6_1");
	Transicion T6_20=new Transicion("m6_7,m6_15,m6_17,m6_19","m6_1");
	Transicion T6_21=new Transicion("m6_30","m6_6");
		T6_1.addId_L_Entrante("m6_20");
		T6_8.addId_L_Entrante("m6_21");
		T6_10.addId_L_Entrante("m6_22");
		T6_12.addId_L_Entrante("m6_23");
		T6_14.addId_L_Entrante("m6_24");
		
		T6_15.addId_L_Saliente("m6_29");
		T6_17.addId_L_Saliente("m6_25");
		T6_18.addId_L_Saliente("m6_26");
		T6_19.addId_L_Saliente("m6_27");
		T6_20.addId_L_Saliente("m6_28");
		
		
	/*id de transiciones*/
	T6_1.setId("T6_1");
	T6_2.setId("T6_2");
	T6_3.setId("T6_3");
	T6_4.setId("T6_4");
	T6_5.setId("T6_5");
	T6_6.setId("T6_6");
	T6_7.setId("T6_7");
	T6_8.setId("T6_8");
	T6_9.setId("T6_9");
	T6_10.setId("T6_10");
	T6_11.setId("T6_11");
	T6_12.setId("T6_12");
	T6_13.setId("T6_13");
	T6_14.setId("T6_14");
	T6_15.setId("T6_15");
	T6_16.setId("T6_16");
	T6_17.setId("T6_17");
	T6_18.setId("T6_18");
	T6_19.setId("T6_19");
	T6_20.setId("T6_20");
	T6_21.setId("T6_21");
	/*fin de transiciones supervision de agitado*/
		
	/*inicializacion de lugares con fichas*/
		m6_1.addFichas();
	
	/*fin de inicializacion lugares con fichas*/
	

		
	/*fin de petri de supervision de agitado*/
			
			
	
		
		
	/*conexion lugares con coordinacion general*/
		
	T7_1.addId_L_Entrante("mc1_15");
	T7_2.addId_L_Saliente("mc1_16");
	T7_23.addId_L_Saliente("mc1_18");
	
	T6_1.addId_L_Saliente("mc1_17");
	T6_8.addId_L_Saliente("mc1_17");
	T6_10.addId_L_Saliente("mc1_17");
	T6_12.addId_L_Saliente("mc1_17");
	
	T6_2.addId_L_Entrante("mc1_6");
	T6_4.addId_L_Entrante("mc1_9");
	
	/*fin conexcion*/
		
		
		
	
	
	
	/*manejador de falla (bomba de transporte)*/
	
	/*falla lugares comunes*/
	Lugar mcf_1	=	new Lugar(0,"mcf_1");
	Lugar mcf_2	=	new Lugar(0,"mcf_2");
	Lugar mcf_3	=	new Lugar(0,"mcf_3");
	Lugar mcf_4	=	new Lugar(0,"mcf_4");
	Lugar mcf_5	=	new Lugar(0,"mcf_5");
	Lugar mcf_6	=	new Lugar(0,"mcf_6");
	Lugar mcf_7=	new Lugar(0,"mcf_7");
	
	/*fin falla lugares comunes*/
	
	/*lugares falla transporte*/
	Lugar m4_f1	=	new Lugar(0,"m4_f1");
	Lugar m4_f2	=	new Lugar(0,"m4_f2");
	Lugar m4_f3	=	new Lugar(0,"m4_f3");
	Lugar m4_f4	=	new Lugar(0,"m4_f4");
	Lugar m4_f5	=	new Lugar(0,"m4_f5");
	Lugar m4_f6	=	new Lugar(0,"m4_f6");
	Lugar m4_f7	=	new Lugar(0,"m4_f7");
	Lugar m4_f8	=	new Lugar(0,"m4_f8");
	
	/*fin lugares falla transprte */
	
	
	
	/*transiciones falla transporte*/
	
	Transicion T4_f1 =new Transicion("m4_f1,m5_18","mcf_1,mcf_7,m4_f2,m4_f3,m4_f8");
	Transicion T4_f2 =new Transicion("m4_f1,m5_19","mcf_1,mcf_7,m4_f2,m4_f4,m4_f8");
	Transicion T4_f3 =new Transicion("m4_f2","m4_f5");
	
	Transicion T4_f4 =new Transicion("m4_f5,mcf_2,m4_f8","m4_f6,mcf_5");
	
	Transicion T4_f5 =new Transicion("m4_f6","mcf_3,m4_f7");
	Transicion T4_f6 =new Transicion("m4_f3,m4_f7,mcf_4","m5_2");
	Transicion T4_f7 =new Transicion("m4_f4,m4_f7,mcf_4","m5_4");
	
	/*fin trasnsiciones falla trasnporte*/
	/*id transiciones*/
	T4_f1.setId("T4_f1");
	T4_f2.setId("T4_f2");
	T4_f3.setId("T4_f3");
	T4_f4.setId("T4_f4");
	T4_f5.setId("T4_f5");
	T4_f6.setId("T4_f6");
	T4_f7.setId("T4_f7");
	
	
	
	
	
	
	/*lugares falla premezcla*/
	Lugar m2_f1	=	new Lugar(0,"m2_f1");
	Lugar m2_f2	=	new Lugar(0,"m2_f2");
	Lugar m2_f3	=	new Lugar(0,"m2_f3");
	Lugar m2_f4	=	new Lugar(0,"m2_f4");
	Lugar m2_f5	=	new Lugar(0,"m2_f5");
	Lugar m2_f6	=	new Lugar(0,"m2_f6");
	Lugar m2_f7	=	new Lugar(0,"m2_f7");
	Lugar m_PLC2= new Lugar(0, "m_PLC2");
	
	/*fin lugares falla premezcla */
	
	
	/*transiciones falla premezcla*/
	Transicion T2_f1=new Transicion("m2_f1","m2_f2");
	Transicion T2_f2=new Transicion("m2_f2,m_PLC2,mcf_5","m2_f3");
	Transicion T2_f3=new Transicion("m2_f3","m2_f4");
	Transicion T2_f4=new Transicion("m2_f4,m_PLC2","m2_f5");
	Transicion T2_f5=new Transicion("m2_f5,m2_f6,mcf_3,","mcf_6,mcf_4,m3_2");
	//Transicion T2_f6=new Transicion("mcf_1","m2_f6,m2_f1");
	
	Transicion T2_f6=new Transicion("mcf_1,m3_3","m2_f6,m2_f1");
	
	
	
	/*fin trasnsiciones falla premezcla*/
	/*id transiciones*/
	T2_f1.setId("T2_f1");
	T2_f2.setId("T2_f2");
	T2_f3.setId("T2_f3");
	T2_f4.setId("T2_f4");
	T2_f5.setId("T2_f5");
	T2_f6.setId("T2_f6");
	
	
	
	
	/*lugares falla agitado*/
	
	Lugar m7_f1=new Lugar(0,"m7_f1");
	Lugar m7_f2=new Lugar(0,"m7_f2");
	/*fin lugares falla agitado */
	/*transiciones falla agitado*/
	Transicion T7_f1=new Transicion("mcf_7,m6_4","m7_f1");
	Transicion T7_f2=new Transicion("m7_f1","m7_f2");
	Transicion T7_f3=new Transicion("mcf_6,m7_f2","m6_3");
	
	/*fin trasnsiciones falla agitado*/
	T7_f1.setId("T7_f1");
	T7_f2.setId("T7_f2");
	T7_f3.setId("T7_f3");
	/*id transiciones*/

	
	
	
	
	
	//introduccion de falla
	//m4_f1.addFichas();
	//m_PLC2.addFichas(2);
	//m_PLC.addFichas();
	
	//mcf_2.addFichas();
	//inicio
	
	
	
	EjecutorAcciones.inicializacion();
	
		
	while(true)
	{	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EjecutorAcciones.ejecutorCo(todosLosLugares, Transicion.ListadeTransiciones, Agenda);
		EjecutorAcciones.ejecutorPm(todosLosLugares, Transicion.ListadeTransiciones, Agenda);
		EjecutorAcciones.ejecucionTr(todosLosLugares, Transicion.ListadeTransiciones, Agenda);
		EjecutorAcciones.ejecutorAg(todosLosLugares, Transicion.ListadeTransiciones, Agenda);
		EjecutorAcciones.ejecutorFa(todosLosLugares, Transicion.ListadeTransiciones, Agenda);
		Transicion.ListadeTransiciones.desactivarTodasLasTransiciones();
		Transicion.ListadeTransiciones.activarHabilitadas(todosLosLugares);
		Transicion.ListadeTransiciones.correr(todosLosLugares);
		//todosLosLugares.infoActivos();
		//System.out.println(Agenda.get(0).getOrdenAgitado().getporcentaje());
		//System.out.println(Agenda.get(0).getOrdenTransporte().getporcentaje());
		
		//System.out.println(Agenda.get(2).getOrdenPremezcla().getporcentaje());
		//System.out.println(Agenda.get(3).getOrdenPremezcla().getporcentaje());
	//	System.out.println(Lugar.todosLosLugares.getById("m2_f4").getFichas()+" "+Lugar.todosLosLugares.getById("m_PLC2").getFichas()+" "+Lugar.todosLosLugares.getById("m2_f5").getFichas());
	}
	}

	
	
	
	
}

