package ProducerConsumers;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private Deque<Object> items;

    public Store(){
        this.items = new ConcurrentLinkedDeque<>();
    }

    public void addItems(){
        items.add(new Object());
    }

    public void removeItems(){
        items.remove();
    }

    public int itemsSize(){
        return items.size();
    }

}
