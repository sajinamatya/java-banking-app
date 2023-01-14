package Banking;

/*
 * Write a description of class Debitcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debitcard extends Bankcard  //subclass Debitcard is created which inherit the property of Bankcard
{
    private int pin$number;    
    private String date$of$withdrawal;
    private int withdrawal$amount;
    private boolean has$withdrawn;

    public Debitcard(int balance$amount, int card$id, String bank$account,String issuer$bank, String client$name,int pin$number){  //constructor 
        super(balance$amount,card$id,issuer$bank,bank$account);
        super.setClient$name(client$name);
        this.pin$number = pin$number;
        this.has$withdrawn=false;

    }

    public int getPin$number(){             //accessor method for pin$number
        return this.pin$number;
    }

    public int getWithdrawal$amount(){      //accessor method for  withdrawal$amount
        return this.withdrawal$amount;

    }

    public String getDate$of$withdrawal(){ //accessor method for date$of$withdrawal
        return this.date$of$withdrawal;
    }

    public boolean getHas$withdrawn(){ // accessor method for has$withdrawn
        return this.has$withdrawn;
    }

    public void setWithdrawal$amount(int withdrawal$amount){  //mutator method for withdrawal amount
        this.withdrawal$amount = withdrawal$amount;
    }

    public void Withdraw(int withdrawal$amount,String date$of$withdrawal,int pin$number){  // withdraw method 

        if(this.pin$number == pin$number){      // checking if the pin number is correct or not 
            if( withdrawal$amount<= getBalance$amount()){  // if correct pin number is entered then withdrawal amount is checked 
                setBalance$amount(getBalance$amount()-withdrawal$amount);   //for the current balance after the withdrawal 
                this.has$withdrawn = true;
            }
            else{                       // insufficient balance then return the message 
                System.out.println("Not enough balance in your account");
            }
        }
        else{                   // if the pin is incorrect then return the message 
            System.out.println("Incorrect Pin number, Please try again");        

        }
    }

    public void display(){   // display method 
        super.display();    //calling the display method of Bankcard class 

        if(has$withdrawn == true){        // if the money withdrawal then shows the detail of the transaction 
            super.display();    
            System.out.println("Pin number =" + pin$number);
            System.out.println("Withdrawal Amount = " + withdrawal$amount);
            System.out.println("Date of withdrawal = "+ date$of$withdrawal);
        }
        else{          // shows the balance amount only 
            System.out.println("Balance amount ="+ getBalance$amount());

        }
    }

}
