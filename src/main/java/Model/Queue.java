package Model;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

        public class Queue extends Thread implements Comparable<Queue> {
            private BlockingQueue<Client> clients;
            private int waitingTime;
            private int queueNumber;

            public Queue(int queueNumber) {
                this.clients = new LinkedBlockingQueue<Client>();
                this.waitingTime = 0;
                this.queueNumber = queueNumber;


            }

            public void addClient(Client c) {
                this.clients.add(c);
                this.waitingTime += c.getServiceTime();

            }

            public void run() {
                while (true) {
                    if (this.clients.isEmpty() != true) {
                        Client c = this.clients.peek();
                        int wait = c.getServiceTime();
                        try {
                            Thread.sleep(wait * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        this.clients.poll();
                        this.waitingTime -= wait;
                        System.out.println("Clientul cu id -ul " + c.getID() + " a fost servit de casa cu numarul " + this.queueNumber);
                    }
                }
            }

            public String toString() {
                String str = " ";
                Iterator<Client> list = clients.iterator();

                // print result

                while (list.hasNext())
                    str+=(list.next().toString2());


return str;
        }

        public int getTotalTime()
        {   int sum=0;
            for(Client c:this.clients)
            {
                sum+=c.getServiceTime();
            }
            return sum;
        }

            public BlockingQueue<Client> getClients() {
                return clients;
            }

            @Override
            public int compareTo(Queue o) {
                return this.waitingTime-o.waitingTime;
            }

            public int getQueueNumber() {
                return queueNumber;
            }

            public int getWaitingTime() {
                return waitingTime;
            }
        }

