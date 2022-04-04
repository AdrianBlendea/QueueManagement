package Model;

public class Client implements Comparable<Client>{
private int ID;
private int arrivalTime;
private int serviceTime;

public Client (int id, int arrivalTime, int serviceTime)
{
    this.ID=id;
    this.arrivalTime=arrivalTime;
    this.serviceTime=serviceTime;


}

    public int getServiceTime() {
        return serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getID() {
        return ID;
    }

    public void print() {
        System.out.println("ID: " + this.ID + "Timp sosire: "+this.arrivalTime + " Timp servire :" +this.serviceTime );
    }

    @Override
    public String toString() {
        return "Clientul cu id " +this.ID + " si cu timpul de servire"+this.serviceTime;
    }

    public String toString2() {
        return "("+this.ID +","+this.arrivalTime+","+this.serviceTime+") ";
    }


    @Override
    public int compareTo(Client o) {
   return  this.arrivalTime-o.arrivalTime;

    }
}
