package Lab;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumator implements Runnable {
	Queue<Integer> coada;
	Semaphore semProducator;
	Semaphore semConsumator;
	
	Consumator(Semaphore s1, Semaphore s2, Queue<Integer> c){
		this.coada=c;
		this.semProducator=s1;
		this.semConsumator=s2;
		new Thread(this).start();
	}
	
	
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
		   try {
			semConsumator.acquire();
			System.out.println("Consumatorul a consumat elementul: "+coada.peek());
			coada.remove(i);
			semProducator.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		}
	}
	
	

}
