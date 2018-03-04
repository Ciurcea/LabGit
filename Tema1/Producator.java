package Lab;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producator implements Runnable {
	Queue<Integer> coada;
	Semaphore semProducator;
	Semaphore semConsumator;
	
	Producator(Semaphore s1, Semaphore s2, Queue<Integer> c){
		this.semProducator=s1;
		this.semConsumator=s2;
		this.coada=c;
		new Thread(this).start();
	}
	

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			try {
				semProducator.acquire();
				System.out.println("Producatorul a produs elementul cu numarul: "+i);
		        coada.add(i);
		        semConsumator.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        
		    
		}
	}

}
