package ProducerConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        Store s = new Store();
        ExecutorService es = Executors.newCachedThreadPool();
        Semaphore semaProd = new Semaphore(5);
        Semaphore semaCons = new Semaphore(0);

        for(int i=0; i<8; i++){
            Producers p = new Producers(s,semaProd,semaCons);
            es.submit(p);
        }

        for(int i=0; i<20; i++){
            Consumers c = new Consumers(s,semaProd,semaCons);
            es.submit(c);
        }

    }
}
