package Lab;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumator implements Runnable {
	Queue<Integer> coada;
	Semaphore semProducator;
	Semaphore semConsumator;
	Semaphore semCoada;
	
	Consumator(Semaphore s1, Semaphore s2,Semaphore s3, Queue<Integer> c){
		this.coada=c;
		this.semProducator=s1;
		this.semConsumator=s2;
		this.semCoada=s3;
		new Thread(this).start();
	}
	
	
	
	@Override
    public void run() {
		synchronized(coada) {
		if(coada.isEmpty())
			System.out.println("Stoc epuizat!");
		else
		{
			try {
				System.out.println(Thread.currentThread().getName()+" a consumat un produs si coada are  lungimea: "+(coada.size()-1));
				semConsumator.acquire();
				semCoada.acquire();
				
				coada.remove();
				
				semCoada.release();
				semConsumator.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
			   
			
		
		}
	}
	
	


