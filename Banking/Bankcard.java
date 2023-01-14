package Banking;
/*
 * Write a description of class Bankcard here.
 *
 * @author (SajinRajAmatya_AI1)
 * @version (a version number or a date)
 */
public class Bankcard   // Main class name Bankcard is created
{
    private int balance$amount;     //private variable  balance_amount is declared 
    private int card$id;            // private variable card_id is declared
    private String issuer$bank;     // private variable issuer_bank is declared
    private String client$name;     // private variable client_name is declared
    private String bank$account;    // private variable bank_account is declared

    public Bankcard(int balance$amount,int card$id, String issuer$bank,String bank$account){    //parameterized constructor with 4 parameter 
        this.balance$amount = balance$amount;  // this keyword is used for invoking the current constructor Bankcard of a class
        this.card$id = card$id; 
        this.client$name = "";
        this.issuer$bank = issuer$bank;
        this.bank$account = bank$account;
    }

    public  int getBalance$amount(){ //accessor method for balanceamount

        return this.balance$amount;
    }

    public int  getCard$id(){ //accessor method for card$id

        return this.card$id;

    }

    public  String getIssuer$bank(){ // accessor method for 

        return this.issuer$bank;
    }

    public  String getClient$name(){

        return this.client$name;
    } 

    public  String getBank$account(){

        return this.bank$account; 

    }

    public void setBalance$amount(int balance$amount){  //setter or mutator  method accessor for balance amount 
        this.balance$amount = balance$amount;

    }

    public void setClient$name(String client$name){     //setter or mutator  method accessor for client name
        this.client$name=client$name;
    }

    public void display(){      // Display the enter detail value of a customer
        System.out.println("CardID = "+ this.card$id);
        if(this.client$name == ""){
            System.out.println("Please enter the client name");
        }
        else{
            System.out.println("ClientName = " + this.client$name);
        }
        System.out.println("IssuerBank = "+ this.issuer$bank);
        System.out.println("BankAccount = "+ this.bank$account);
        System.out.println("BalanceAmount = "+ this.balance$amount);

    }
}

