package Petri;
import java.util.Timer;

/*
 * clase para temporizar una transicion
 * */
public class Temporizador extends Thread {
	Transicion T;
	long t;
	public Temporizador(long t,Transicion T)
{
	this.t=t;
	this.T=T;
	T.setTemporizada(true);
	T.desactivar();
	}

	
	public void run()
	{	
	try {
		Thread.sleep(t);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	T.activar();
	}
	
	
}
