package Controller;

import Model.Client;
import Model.Queue;
import Model.Scheduler;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Controller extends Thread{
    private View mainView;
    private Scheduler scheduler;
    private ArrayList<Client> clients;
    private int timeLimit;
    private int start;
    private String prt;
    private float serviceAverage;
    private float waitingAverage;


    public Controller(View mainView)
    {   this.prt=" ";
        this.start=0;
    this.mainView=mainView;
    this.clients=new ArrayList<Client>();

    this.mainView.validareListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                int numberQueues= Integer.parseInt(mainView.getQueues());
                int nrClients=Integer.parseInt(mainView.getClients());
                int interval=Integer.parseInt(mainView.getInterval());
                int minSosire=Integer.parseInt((mainView.getMinTimpSosire()));
                int maxSosire=Integer.parseInt(mainView.getMaxTimpSosire());
                int minService=Integer.parseInt(mainView.getMinServire());
                int maxService=Integer.parseInt(mainView.getMaxServire());

                timeLimit=interval;

                JOptionPane.showMessageDialog(mainView,"Validare a avut loc cu succes");
                mainView.getStartButton().setEnabled(true);

            }

            catch (NumberFormatException exc)
            {
                JOptionPane.showMessageDialog(mainView,"Va rugam introduceti un set de date corecte!");
            }


        }
    });

    this.mainView.startListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numberQueues= Integer.parseInt(mainView.getQueues());
            int nrClients=Integer.parseInt(mainView.getClients());
            int interval=Integer.parseInt(mainView.getInterval());
            int minSosire=Integer.parseInt((mainView.getMinTimpSosire()));
            int maxSosire=Integer.parseInt(mainView.getMaxTimpSosire());
            int minService=Integer.parseInt(mainView.getMinServire());
            int maxService=Integer.parseInt(mainView.getMaxServire());

            scheduler=new Scheduler(numberQueues);
            for (int i=0; i<numberQueues;i++)
            {
                Queue q=new Queue(i);
                q.start();
                scheduler.addQueue(q);

            }
            generateClients(nrClients,minSosire,maxSosire,minService,maxService);
             start=1;

     //  mainView.getTextArea().setText(clients.toString());



        }
    });
    }
    public void generateClients (int nrClients,int minSosire,int maxSosire,int minService,int maxService)
    {

        for(int i=0;i<nrClients;i++)
        {   Random rand =new Random();
            Client client=new Client(i,rand.nextInt(minSosire,maxSosire),rand.nextInt(minService,maxService));
            clients.add(client);
            this.serviceAverage+=client.getServiceTime();



        }
        Collections.sort(clients);
        this.serviceAverage/=nrClients;


    }
public String afisare(int time)
{String str="";
    str+="Waiting clients: \n";
    for(Client c:this.clients)
    {   if(c.getArrivalTime()>time)
        str+=c.toString2();

    }
    str+="\n";
    for(int i=0;i<this.scheduler.getQueues().size();i++)
    {   int j =this.scheduler.getQueues().get(i).getQueueNumber();
        str+="Queue "+ j+"\n";
        if(this.scheduler.getQueues().get(i).getClients().isEmpty())
        {
            str+="closed";
        }
        else {
            str += this.scheduler.getQueues().get(i).toString();
        }
        str+="\n";
    }
return str;
}
    @Override
    public void run() {
        int curentTime = 0;

        while (curentTime < timeLimit) {
            this.mainView.getTimeLabel().setText("Timp  " + curentTime);
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getArrivalTime() == curentTime) {
                    int waitingPerClient = scheduler.dispatchClient(clients.get(i));
                  //  System.out.println("Clientul cu numarul " + clients.get(i).getID() + " a fost adaugat la coada cu numarul " + nr);
                   // clients.remove(i);
                    this.waitingAverage+=waitingPerClient;


                }

            }

            System.out.println(this.clients.size());
            prt += "Time" + curentTime + "\n";
            prt += this.afisare(curentTime);
            prt += "\n\n";
            this.mainView.getTextArea().setText(prt);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            curentTime++;
        }
        this.waitingAverage/=clients.size();
    prt+="Average waiting time: " + waitingAverage +"\n" + "Average service time: " + serviceAverage;
    this.mainView.getTextArea().setText(prt);
    }


    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }


        public static void main(String[] args) throws InterruptedException {
            View ads=new View();

            Controller c=new Controller(ads);

            while(c.start==0)
            {
            System.out.println(c.start);
            }
            System.out.println("A pornit");
            c.start();
            //System.out.println(c.getStart());

        }
}
