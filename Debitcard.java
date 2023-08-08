

/*
 * Write a description of class Debitcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debitcard extends Bankcard  //subclass Debitcard is created which inherit the property of Bankcard
{
    private int pin_Number;             // instance variable with a private access modifier is declared 
    private String date_Of_Withdrawal;
    private int withdrawal_Amount;
    private boolean has_Withdrawn;
                                                                                                   
    public Debitcard(int balance_Amount, int card_Id, String bank_Account,String issuer_Bank, String client_Name,int pin_Number){  
        super(balance_Amount, card_Id, issuer_Bank, bank_Account);      // calling the constructor of superclass Bankcard 
        super.setClient_Name(client_Name);                      // calling the mutator method  of superclass Bankcard 
        this.pin_Number = pin_Number;
        this.has_Withdrawn=false;

    }

    public int getPin_Number(){             //accessor method for pin_Number
        return this.pin_Number;
    }

    public int getWithdrawal_Amount(){      //accessor method for  withdrawal_Amount
        return this.withdrawal_Amount;

    }

    public String getDate_Of_Withdrawal(){ //accessor method for date_Of_Withdrawal
        return this.date_Of_Withdrawal;
    }

    public boolean getHas_Withdrawn(){ // accessor method for has_Withdrawn
        return this.has_Withdrawn;
    }

    public void setWithdrawal_Amount(int withdrawal_Amount){  //mutator method for withdrawal amount
        this.withdrawal_Amount = withdrawal_Amount;
    }

    public void Withdraw(int withdrawal_Amount,String date_Of_Withdrawal,int pin_Number){  // withdraw method 

        if(this.pin_Number == pin_Number){      // checking if the pin number is correct or not 
            if( withdrawal_Amount<= getBalance_Amount()){  // if correct pin number is entered then withdrawal amount is checked 
                setBalance_Amount(getBalance_Amount()-withdrawal_Amount);   //for the current balance after the withdrawal 
                this.has_Withdrawn = true;
            }
            else{                       // insufficient batlance then return the message 
                System.out.println("Not enough balance in your account");
            }
        }
        else{                   // if the pin is incorrect then return the message 
            System.out.println("Incorrect Pin number, Please try again");        

        }
    }

    public void Display(){   // display method 
           
        if(has_Withdrawn == true){        // if the money withdrawal then shows the detail of the transaction 
            super.Display();                //calling the display method of Bankcard class  
            System.out.println("Pin number =" + pin_Number);
            System.out.println("Withdrawal Amount = " + withdrawal_Amount);
            System.out.println("Date of withdrawal = "+ date_Of_Withdrawal);
        }
        else{    
            System.out.println("Withdrawal transaction has not been carried out yet!");
            System.out.println("Balance amount ="+ getBalance_Amount());     // shows the balance amount only 

        }
    }

}
