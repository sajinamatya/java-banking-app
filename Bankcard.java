
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

    public Bankcard(int balance$amount,int card_id, String issuer$bank,String bank$account){    //parameterized constructor with 4 parameter 
        this.balance$amount = balance$amount;  // this keyword is used for invoking the current constructor Bankcard of a class
        this.card$id = card_id; 
        this.client$name = "";
        this.issuer$bank = issuer$bank;
        this.bank$account = bank$account;
    }

    public  int getbalance$amount(){ //accessor method for balanceamount

        return this.balance$amount;
    }

    public int  getcard$id(){ //accessor method for card$id

        return this.card$id;

    }

    public  String getissuer$bank(){ // accessor method for 

        return this.issuer$bank;
    }

    public  String getclient$name(){

        return this.client$name;
    } 

    public  String getbank$account(){

        return this.bank$account; 

    }
                                                    //setter method accessor
    public void setbank$amount(int bank$amount){
        this.balance$amount = balance$amount;

    }

    public void setcard$id(int card$id){
        this.card$id = card$id;

    }

    public void setclient$name(String client$name){
        this.clien$name=client$name;
    }

    public void setbank$account(String bank$account){
        this.bank$account=bank$account}
    
    }
    
    
    
    
public void display(){
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
