import java.util.*;

public class SharedQueue {
    private final PriorityQueue<Customer> q = new PriorityQueue<Customer>(new ComparatorQueue());
    private final ArrayList<Customer> allCustomers = new ArrayList<>();
    int maxsize;

    public SharedQueue(int N, ArrayList<Integer> pris) {
        this.maxsize = N;
        for (int i = 0; i < pris.size(); i++) {
            this.allCustomers.add(new Customer(i, pris.get(i)));
        }
    }

    public synchronized void addToQueue() {
        while (continueWork()) {
            while (q.size() == maxsize) {
                try {
                    wait();
                    System.out.println("Q is full in add to Queue");
                } catch (InterruptedException e) {
                    System.err.println("Error in addToQueue");
                    throw new RuntimeException(e);
                }
            }
            if (!allCustomers.isEmpty()) {
                Customer c = allCustomers.get(0);
                allCustomers.remove(0);
                this.q.add(c);
                notify();
            } else break;

        }
        System.out.println("Finished all customers");
    }

    public synchronized Customer takeFromQueue() {
            while (q.isEmpty()) {
                try {
                    System.out.println("Q is empty in take from Queue");
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Error in takeFromQueue");
                    throw new RuntimeException(e);
                }
            }
            Customer c = q.poll();
            notify();
            return c;
    }

    public synchronized boolean continueWork(){
        return q.size() != 0 || allCustomers.size() != 0;
    }

    public synchronized boolean queueIsEmpty() {
        return q.isEmpty();
    }
}
