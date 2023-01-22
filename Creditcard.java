
/**
 * Write a description of class Creditcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Creditcard extends Bankcard  // child class credit card which inherit the properties of Bankcard class 
{
    private int cvc_Number;                // instance variable with a private access modifier is declared 
    private double credit_Limit;
    private double interest_Rate;
    private String expiration_Date;
    private int grace_Period;
    private boolean is_Granted;

    public Creditcard(int card_Id, String client_Name, String issuer_Bank, String bank_Account,    // parameterised constructor of Creditcard  
    int balance_Amount, int cvc_Number, double interest_Rate, String expiration_Date){
        super(balance_Amount,card_Id,issuer_Bank,bank_Account);             // calling the constructor of superclass Bankcard 
        this.cvc_Number = cvc_Number;
        this.interest_Rate = interest_Rate;
        this.expiration_Date = expiration_Date;
        this.is_Granted = false;
        setBalance_Amount(balance_Amount);              // calling the mutator method  of superclass Bankcard 
        setClient_Name(client_Name);
    }
    // getter/accesssor method of each attribute of Creditcard class
    public int getCvc_Number(){                     
        return this.cvc_Number;

    }

    public double getCredit_Limit(){
        return this.credit_Limit;
    }

    public double getInterest_Rate(){
        return this.interest_Rate;
    }

    public String getExpiration_Date(){
        return this.expiration_Date;
    }

    public int getGrace_Period(){
        return this.grace_Period;
    }

    public boolean getIs_Granted(){
        return this.is_Granted;
    }
    // method for setting the credit limit 
    public void setCredit_Limit(double new_Creditlimit, int new_Gracelimit)
    {
        if(this.credit_Limit <= 2 * getBalance_Amount()){                   // if-else condition statment 
            is_Granted = true;
            this.credit_Limit = new_Creditlimit;
        }
        else{
            System.out.println("the credit amount can't be issued,please try again later");

        }
    }

    public void cancel_Credit_Card(){               // method for canceling the creditcard
        this.credit_Limit = 0;
        this.cvc_Number = 0;
        this.grace_Period = 0;
        this.is_Granted = false;
    }

    public void Display(){       // method for displaying the detail of Credit card 

        super.Display();      
        System.out.println("CVC Number = " + cvc_Number);
        System.out.println("Interest Rate = "+ interest_Rate);
        System.out.println("Expiration Date = " + expiration_Date);
        if(is_Granted == true){             // if-else statment 
            System.out.println("Credit Limit =" + credit_Limit);
            System.out.println("Grace Period =" + grace_Period);
        }
        else{
              System.out.println("Could not display Credit Limit and Grace Period as it is not permitted");
        }
    }
}
