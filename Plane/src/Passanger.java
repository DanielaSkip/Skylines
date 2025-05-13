public class Passanger extends Person{
    private int ticketNum;
    private double luggageWeight;
    public Passanger(String name, int age, int ticketNum, double luggageWeight){
        super(name, age);
        this.ticketNum=ticketNum;
        this.luggageWeight=luggageWeight;
    }
    public double calculateLuggageCost() { //если багаж >7kg , то доплата 40 евро, после 10 кг доплата 5 евро за каждый кг
        double cost = 0;

        if (luggageWeight > 10) {
            cost += (luggageWeight - 10) * 5;
        }

        if (luggageWeight > 7) {
            cost += 40;
        }

        return cost;
    }





    public String info(){
        String toString=super.info();
        return toString+"\nTicket number: "+ticketNum+"\nLuggage weight: "+luggageWeight+" kg"+  "\nLuggage cost: " + calculateLuggageCost() + " EUR";
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }
}
