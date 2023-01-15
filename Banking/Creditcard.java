package Banking;

/**
 * Write a description of class Creditcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Creditcard extends Bankcard
{
    private int cvc$number;
    private double credit$limit;
    private double interest$rate;
    private String expiration$date;
    private int grace$period;
    private boolean is$granted;

    Creditcard(int card$id, String client$name, String issuer$bank, String bank$account,
    int balance$amount, int cvc$number, double interest$rate, String expiration$date){
        super(balance$amount,card$id,issuer$bank,bank$account);
        this.cvc$number = cvc$number;
        this.interest$rate = interest$rate;
        this.expiration$date = expiration$date;
        this.is$granted = false;
        setBalance$amount( balance$amount);
        setClient$name(client$name);
    }

    public int getCvc$number(){
        return this.cvc$number;

    }

    public double getCredit$limit(){
        return this.credit$limit;
    }

    public double getInterest$rate(){
        return this.interest$rate;
    }

    public String getExpiration$date(){
        return this.expiration$date;
    }

    public int getGrace$period(){
        return this.grace$period;
    }

    public boolean getIs$granted(){
        return this.is$granted;
    }

    public void setCredit$limit(double new$credit$limit, int new$grace$limit)
    {
        if(this.credit$limit <= 2 * getBalance$amount()){
            is$granted = true;
            this.credit$limit = new$credit$limit;
        }
        else{
            System.out.println("the credit amount can't be issued, !Please try again later");
        }
    }

    public void cancel$Credit$Card(){
        this.credit$limit = 0;
        this.cvc$number = 0;
        this.grace$period = 0;
        this.is$granted = false;
    }
    
    public void display(){
        if(is$granted == true){
            super.display();
            
        }
    }
}
