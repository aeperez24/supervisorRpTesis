package GPIO;
import java.time.chrono.HijrahEra;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class SimpleGPIO {
	
	public  static int encender(int opc) {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput pin;
		switch (opc) {
		
		case 4:
			 pin= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
			/*p4 corresponde a gpio7*/
			break;
			
		case 17:
			/*p17 corresponde a gpio0*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
			break;	
		case 18:
			/*corresponde a gpio1*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
			
			break;
		case 22:
			/*corresponde a gpio 3*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
			
			break;
		case 23:
			/*corresponde a gpio 4*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
			
			break;
			
		case 24:
			
			/*corresponde a gpio 5*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
			
			break;
		case 25:
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
			
			/*corresponde a gpio 6*/
			break;
			
		case 27:
			/*p27 corresponde a gpio2*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
			
			break;
			
		default: return 0;
			
		
		}
		
		pin.high();
		gpio.unprovisionPin(pin);
		gpio.shutdown();
		return 1;	
	}
	
	
	
	public  static int apagar(int opc) {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput pin;
		switch (opc) {
		
		case 4:
			 pin= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
			/*p4 corresponde a gpio7*/
			break;
			
		case 17:
			/*p17 corresponde a gpio0*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
			break;	
		case 18:
			/*corresponde a gpio1*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
			
			break;
		case 22:
			/*corresponde a gpio 3*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
			
			break;
		case 23:
			/*corresponde a gpio 4*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
			
			break;
			
		case 24:
			
			/*corresponde a gpio 5*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
			
			break;
		case 25:
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
			
			/*corresponde a gpio 6*/
			break;
			
		case 27:
			/*p27 corresponde a gpio2*/
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
			
			break;
			
		default: return 0;
			
		
		}
		
		pin.low();
		gpio.unprovisionPin(pin);
		gpio.shutdown();
		return 1;	
	}
	

	
	public  static boolean leer(int opc) {
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalInput pin;
		boolean rt=false;
		switch (opc) {
		
		case 4:
			 pin= gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,PinPullResistance.PULL_DOWN);
			/*p4 corresponde a gpio7*/
			break;
			
		case 17:
			/*p17 corresponde a gpio0*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00,PinPullResistance.PULL_DOWN);
			break;	
		case 18:
			/*corresponde a gpio1*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01,PinPullResistance.PULL_DOWN);
			
			break;
		case 22:
			/*corresponde a gpio 3*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03,PinPullResistance.PULL_DOWN);
			
			break;
		case 23:
			/*corresponde a gpio 4*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04,PinPullResistance.PULL_DOWN);
			
			break;
			
		case 24:
			
			/*corresponde a gpio 5*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05,PinPullResistance.PULL_DOWN);
			
			break;
		case 25:
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06,PinPullResistance.PULL_DOWN);
			
			/*corresponde a gpio 6*/
			break;
			
		case 27:
			/*p27 corresponde a gpio2*/
			pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,PinPullResistance.PULL_DOWN);
			
			break;
			
		default: return false;
			
		
		}
		
		rt= pin.isHigh();
		gpio.unprovisionPin(pin);
		gpio.shutdown();
		return rt;	
	}
	
	
	
	
	
}
