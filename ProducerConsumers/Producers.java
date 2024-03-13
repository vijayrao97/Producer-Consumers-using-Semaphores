package ProducerConsumers;

import java.util.concurrent.Semaphore;

public class Producers implements Runnable {
    private Store s;
    private Semaphore semaProd;
    private Semaphore semaCons;

    public Producers(Store s, Semaphore semaProd, Semaphore semaCons){
        this.s = s;
        this.semaProd = semaProd;
        this.semaCons = semaCons;
    }

    @Override
    public void run() {
        while(true){
            try{
                semaProd.acquire();
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            s.addItems();
            System.out.println("Inventory size "+s.itemsSize());
            semaCons.release();
        }
    }
}
