package Lab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;






public class Producator_Consumator {

	public static void main(String[] args) {
	     Queue<Integer> coada=new LinkedList<Integer>();
	   
		Semaphore semProducator=new Semaphore(10);
		Semaphore semConsumator=new Semaphore(1);
		
		Semaphore semCoada = new Semaphore(1);
		for(int i=0;i<10;i++) {
			
			new Producator(semProducator,semConsumator,semCoada,coada);
			  
		    new Consumator(semProducator,semConsumator,semCoada,coada);
		      semCoada.release();
		
		}

	}

}
