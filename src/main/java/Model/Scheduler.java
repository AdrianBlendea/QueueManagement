package Model;

import java.util.*;

public class Scheduler   {
    private ArrayList<Queue> queues;
    private int numberofQueues;


    public Scheduler(int numberofQueues) {
    this.queues=new ArrayList<Queue>();
    this.numberofQueues=numberofQueues;

    }
    public void addQueue(Queue q)
    {
        this.queues.add(q);
        Collections.sort(this.queues);
    }

    public int dispatchClient(Client c)
    {   int waitingTime=0;
        //System.out.println(this.queues.get(0).getWaitingTime());
        this.queues.get(0).addClient(c);
        waitingTime= this.queues.get(0).getWaitingTime();

        Collections.sort(this.queues);
        return waitingTime;
    }

    public ArrayList<Queue> getQueues() {
        return queues;
    }
}
