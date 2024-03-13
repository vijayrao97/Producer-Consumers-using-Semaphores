package ProducerConsumers;

import java.util.concurrent.Semaphore;


public class Consumers implements Runnable{
    private Store s;
    private Semaphore semaProd;
    private Semaphore semaCons;

    public Consumers(Store s, Semaphore semaProd, Semaphore semaCons){
        this.s = s;
        this.semaProd = semaProd;
        this.semaCons = semaCons;
    }

    @Override
    public void run() {
        while(true) {
            try {
                semaCons.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            s.removeItems();
            System.out.println("Inventory size "+s.itemsSize());
            semaProd.release();
        }
    }

}
