package Lab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producator_Consumator {

	public static void main(String[] args) {
		Queue<Integer> coada=new LinkedList<Integer>();
		Semaphore semConsumator=new Semaphore(0);
		Semaphore semProducator=new Semaphore(1);
		new Consumator(semProducator,semConsumator,coada);
		new Producator(semProducator,semConsumator,coada);

	}

}
