
/*
 * Write a description of class Bankcard here.
 *
 * @author (SajinRajAmatya_AI1)
 * @version (a version number or a date)
 */
public class Bankcard   // Parent  class name Bankcard is created
{
    private int balance_Amount ;        // instance variable with a private access modifier is declared 
    private int card_Id;            
    private String issuer_Bank;     
    private String client_Name;     
    private String bank_Account;    

    public Bankcard(int balance_Amount, int card_Id, String issuer_Bank, String bank_Account){    //parameterized constructor with 4 parameter 
        this.balance_Amount = balance_Amount;  // this keyword is used for invoking the current constructor Bankcard of a class
        this.card_Id = card_Id; 
        this.client_Name = "";
        this.issuer_Bank = issuer_Bank;
        this.bank_Account = bank_Account;
    }

    public  int getBalance_Amount(){ //accessor method for balanceamount attribute 

        return this.balance_Amount;
    }

    public int  getCard_Id(){ //accessor method for card_Id attribute 

        return this.card_Id;

    }

    public  String getIssuer_Bank(){ // accessor method for issuer_Bank attribute 

        return this.issuer_Bank;
    }

    public  String getClient_Name(){    // accessor method for client_Name attribute 

        return this.client_Name;
    } 

    public  String getBank_Account(){     // accessor method for bank_Account attribute 

        return this.bank_Account; 

    }

    public void setBalance_Amount(int balance_Amount){  //setter or mutator  method accessor for balance_Amount attribute
        this.balance_Amount = balance_Amount;

    }

    public void setClient_Name(String client_Name){     //setter or mutator  method accessor for client_Name attribute 
        this.client_Name=client_Name;
    }

    public void Display(){      // Display the enter detail value of a customer
        System.out.println("CardID = "+ this.card_Id);
        if(this.client_Name == ""){
            System.out.println("Please enter the client name");
        }
        else{
            System.out.println("ClientName = " + this.client_Name);
        }
        System.out.println("IssuerBank = "+ this.issuer_Bank);
        System.out.println("BankAccount = "+ this.bank_Account);
        System.out.println("BalanceAmount = "+ this.balance_Amount);

    }
}

