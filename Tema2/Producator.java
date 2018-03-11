package Lab;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producator implements Runnable {
	
	Queue<Integer> coada;
	Semaphore semProducator;
	Semaphore semConsumator;
	Semaphore semCoada;
	
	Producator(Semaphore s1, Semaphore s2, Semaphore s3, Queue<Integer> c){
		this.semProducator=s1;
		this.semConsumator=s2;
		this.semCoada=s3;
		this.coada=c;
		new Thread(this).start();
	}
	

	@Override
    public void run() {
		
			synchronized(coada) {
				try {
					semProducator.acquire();
					semCoada.acquire();
					coada.add(1);
			        semCoada.release();
			        semProducator.release();
			        System.out.println(Thread.currentThread().getName()+ " a produs un element si coada are  lungimea: "+ coada.size() );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
		        
		    
		}
	}


