
/**
 * Write a description of class BankingGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BankingGUI implements ActionListener{
    JFrame frameMain,frameDebitCard,frameWithdraw,frameCreditCard;
    JPanel panelDebitCard,panelWithdraw,panelCreditCard;
    
    JLabel labelheading,labelheading1,labelheading2, labelClientName,labelBankAccount,labelBalanceAmount,labelIssuerBank,labelCardId,labelPIN,
    labelWithdrawCardId,labelWithdrawPIN,labelWithdrawalAmount,labelDateOfWithdrawal,labelClientNameCreditCard,labelBankAccountCreditCard,
    labelBalanceAmountCreditCard,labelIssuerBankCreditCard,labelCardIdCreditCard;
    
    Color panelcolor,textfieldcolor,lightBlue,Montecarlo, darkgreen,lightgreen,lightRed,DarkBlue;
    
    JButton buttonDebitCard,buttonClearDebitCard,buttonDisplayDebitCard,buttonWithdraw,buttonBackDebitCard,buttonBackWithdraw,buttonAddDebitCard,
    buttonWithdrawalAmount,buttonClearWithdraw, buttonAddCreditCard,buttonCreditCard,buttonClearCreditCard,buttonDisplayCreditCard,buttonBackCreditCard;  
    
    JTextField textfieldIssuerBank,textfieldClientName,textfieldBankAccount,textfieldBalanceAmount,textfieldCardId,textfieldPIN,textfieldWithdrawCardId,
    textfieldWithdrawPIN,textfieldWithdrawalAmount,textfieldIssuerBankCreditCard,textfieldClientNameCreditCard,textfieldBankAccountCreditCard,
    textfieldCardIdCreditCard,textfieldBalanceAmountCreditCard;
    ArrayList<Object> DebitcardArraylist;
    Debitcard objdebit;
    int balanceAmount,cardID,PINNumber;
    String issuerBank,clientName,bankAccount;
    
    public BankingGUI(){
        
        frameMain = new JFrame("sajin bank");
        frameMain.getContentPane().setBackground(Color.gray);
        
        labelheading1 = new JLabel("Welcome!!!");
        labelheading1.setBounds(360,65,400,50);
        labelheading1.setFont(new Font("Century Gothic",Font.BOLD,60));
        labelheading1.setForeground(Color.BLACK);
        frameMain.add(labelheading1);
        
        labelheading = new JLabel("Our Services");
        labelheading.setBounds(390,165,400,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading.setForeground(Color.BLACK);
        frameMain.add(labelheading);
        
        DarkBlue = new Color(56, 155, 242);
    
        buttonDebitCard = new JButton("Debit Card");
        buttonDebitCard.setBounds(360,265,300,70);
        buttonDebitCard.setFont(new Font("Century Gothic",Font.BOLD,19));
        buttonDebitCard.setForeground(Color.BLACK);
        buttonDebitCard.setBackground(DarkBlue);
        buttonDebitCard.addActionListener(this);
        buttonDebitCard.setFocusable(false);
        frameMain.add(buttonDebitCard);
        
        buttonCreditCard = new JButton("Credit Card");
        buttonCreditCard.setBounds(360,365,300,70);
        buttonCreditCard.setFont(new Font("Century Gothic",Font.BOLD,19));
        buttonCreditCard.setForeground(Color.BLACK);
        buttonCreditCard.setBackground(DarkBlue);
        buttonCreditCard.setFocusable(false);
        //registering listener where current instance is passed.
        buttonCreditCard.addActionListener(this);  
        frameMain.add(buttonCreditCard);
       
            
        frameMain.setBounds(200,0,1000,800); //setting position and size of frame
        frameMain.setLayout(null);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            }
        
    
    
    //Event Handling 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonDebitCard || e.getSource() == buttonBackWithdraw ) {
            DebitCardGUI();
            frameMain.setVisible(false);
            frameDebitCard.setVisible(true);
            frameWithdraw.setVisible(false);
        }
        else if (e.getSource() == buttonBackDebitCard ||  e.getSource() == buttonBackCreditCard){
            frameMain.setVisible(true);
            frameDebitCard.setVisible(false);
            frameCreditCard.setVisible(false);
        }
        else if ( e.getSource() == buttonWithdraw){
            WithdrawGUI();
            frameMain.setVisible(false);
            frameDebitCard.setVisible(false);
            frameWithdraw.setVisible(true);
        }
        else if (e.getSource() == buttonClearDebitCard || e.getSource() == buttonClearCreditCard ){
            ClearDebitCard();
                
        }
        else if (e.getSource() == buttonClearWithdraw ){
        textfieldWithdrawCardId.setText("");
        textfieldWithdrawalAmount.setText("");
        textfieldWithdrawPIN.setText("");
    }
        else if (e.getSource() == buttonCreditCard){
            CreditCardGUI();
            frameMain.setVisible(false);
            frameCreditCard.setVisible(true);
        }
        else if(e.getSource() == buttonAddDebitCard){
            getUserInputDebitCard();
            JOptionPane.showMessageDialog(frameDebitCard,"thankyou");
        }
        else if(e.getSource() == buttonDisplayDebitCard){
            
            String message = "";
            for (Object data : DebitcardArraylist) {
                message += data.toString() + "\n";
            }
            
            
            JOptionPane.showMessageDialog(frameDebitCard,message,"Debit Card",JOptionPane.INFORMATION_MESSAGE);
        }
   
    
       
    }



    
    //Debit Card GUI 
    public void DebitCardGUI(){
            frameDebitCard = new JFrame("coursework 2 ");
            frameDebitCard.getContentPane().setBackground(Color.gray);
            panelDebitCard = new JPanel();
            panelDebitCard.setBounds(80,150,800,550);
            panelcolor = new Color(172,158,157);
            panelDebitCard.setBackground(panelcolor);
            panelDebitCard.setLayout(null);
            
            
            labelheading = new JLabel("Sajin Bank");
            labelheading.setBounds(400,10,300,50);
            labelheading.setFont(new Font("Century Gothic",Font.BOLD,40));
            labelheading.setForeground(Color.BLACK);
            frameDebitCard.add(labelheading);
            
            labelheading2 = new JLabel("Debit Card");
            labelheading2.setBounds(430,100,300,50);
            labelheading2.setFont(new Font("Century Gothic",Font.BOLD,30));
            labelheading2.setForeground(Color.BLACK);
            frameDebitCard.add(labelheading2);
            
            labelClientName = new JLabel("Client Name");
            labelClientName.setBounds(15,30,120,20);
            labelClientName.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelClientName.setForeground(Color.BLACK);
            panelDebitCard.add(labelClientName);
            
            labelBankAccount = new JLabel("Bank Account");
            labelBankAccount.setBounds(15,130,120,20);
            labelBankAccount.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelBankAccount.setForeground(Color.BLACK);
            panelDebitCard.add(labelBankAccount);
            
            labelBalanceAmount = new JLabel("Balance Amount");
            labelBalanceAmount.setBounds(15,240,140,20);
            labelBalanceAmount.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelBalanceAmount.setForeground(Color.BLACK);
            panelDebitCard.add(labelBalanceAmount);
            
            labelIssuerBank = new JLabel("Issuer Bank");
            labelIssuerBank.setBounds(480,30,140,20);
            labelIssuerBank.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelIssuerBank.setForeground(Color.BLACK);
            panelDebitCard.add(labelIssuerBank);
            
            
            labelCardId = new JLabel("Card ID");
            labelCardId.setBounds(480,130,68,20);
            labelCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelCardId.setForeground(Color.BLACK);
            panelDebitCard.add(labelCardId);
            
            
            labelPIN =  new JLabel("PIN Number");
            labelPIN.setBounds(480,240,100,20);
            labelPIN.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelPIN.setForeground(Color.BLACK);
            panelDebitCard.add(labelPIN);
            
            //textfield for debitcard gui
            textfieldcolor = new Color(255,244,243);
            textfieldClientName = new JTextField();
            textfieldClientName.setBounds(15,60,270,32);
            textfieldClientName.setBackground(textfieldcolor);
            textfieldClientName.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldClientName);
            
            textfieldIssuerBank = new JTextField();
            textfieldIssuerBank.setBounds(480,60,270,32);
            textfieldIssuerBank.setBackground(textfieldcolor);
            textfieldIssuerBank.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldIssuerBank);
            
            textfieldBankAccount = new JTextField();
            textfieldBankAccount.setBounds(15,160,270,32);
            textfieldBankAccount.setBackground(textfieldcolor);
            textfieldBankAccount.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldBankAccount);
            
            textfieldBalanceAmount = new JTextField();
            textfieldBalanceAmount.setBounds(15,270,270,32);
            textfieldBalanceAmount.setBackground(textfieldcolor);
            textfieldBalanceAmount.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldBalanceAmount);
            
            textfieldCardId = new JTextField();
            textfieldCardId.setBounds(480,160,270,32);
            textfieldCardId.setBackground(textfieldcolor);
            textfieldCardId.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldCardId);
            
            textfieldPIN = new JTextField();
            textfieldPIN.setBounds(480,270,270,32);
            textfieldPIN.setBackground(textfieldcolor);
            textfieldPIN.setFont(new Font("Century Gothic",Font.BOLD,14));
            panelDebitCard.add(textfieldPIN);
            

            lightBlue = new Color(70, 129, 244);
            // buttons for debitcard gui
            buttonAddDebitCard = new JButton("Add Debitcard");
            buttonAddDebitCard.setBounds(550,360,200,60);
            buttonAddDebitCard.setFont(new Font("Century Gothic",Font.BOLD,17));
            buttonAddDebitCard.setForeground(Color.BLACK);
            buttonAddDebitCard.setBackground(lightBlue);
            buttonAddDebitCard.addActionListener(this);
            buttonAddDebitCard.setFocusable(false);
            panelDebitCard.add(buttonAddDebitCard);
            
            darkgreen = new Color(135, 95, 30);
            buttonClearDebitCard = new JButton("Clear ");
            buttonClearDebitCard.setBounds(570,490,170,40);
            buttonClearDebitCard.setFont(new Font("Century Gothic",Font.BOLD,15));
            buttonClearDebitCard.setForeground(Color.BLACK);
            buttonClearDebitCard.setBackground(darkgreen);
            buttonClearDebitCard.setFocusable(false);
            //registering listener where current instance is passed.
            buttonClearDebitCard.addActionListener(this);
            panelDebitCard.add(buttonClearDebitCard);
            
            lightgreen = new Color(39, 178, 125);
            buttonDisplayDebitCard = new JButton("Display");
            buttonDisplayDebitCard.setBounds(300,490,170,40);
            buttonDisplayDebitCard.setFont(new Font("Century Gothic",Font.BOLD,15));
            buttonDisplayDebitCard.setForeground(Color.BLACK);
            buttonDisplayDebitCard.setBackground(lightgreen);
            buttonDisplayDebitCard.addActionListener(this);
            buttonDisplayDebitCard.setFocusable(false);
            panelDebitCard.add(buttonDisplayDebitCard);
            
            Montecarlo = new Color(118,201,170);
            buttonWithdraw = new JButton("Withdraw Amount ");
            buttonWithdraw.setBounds(20,360,200,60);
            buttonWithdraw.setFont(new Font("Century Gothic",Font.BOLD,17));
            buttonWithdraw.setForeground(Color.BLACK);
            buttonWithdraw.addActionListener(this);
            buttonWithdraw.setBackground(Montecarlo);
            buttonWithdraw.setFocusable(false);
            panelDebitCard.add(buttonWithdraw);
            
            lightRed = new Color(189,73,73);
            buttonBackDebitCard = new JButton("Back");
            buttonBackDebitCard.setBounds(40,490,170,40);
            buttonBackDebitCard.setFont(new Font("Century Gothic",Font.BOLD,15));
            buttonBackDebitCard.setForeground(Color.BLACK);
            buttonBackDebitCard.setBackground(lightRed);
            buttonBackDebitCard.setFocusable(false);
            //registering listener where current instance is passed.
            buttonBackDebitCard.addActionListener(this);
            panelDebitCard.add(buttonBackDebitCard);
            
            
            frameDebitCard.add(panelDebitCard);
            frameDebitCard.setBounds(200,0,1000,800); //setting position and size of frame
            frameDebitCard.setLayout(null);
            frameDebitCard.setVisible(false);
            frameDebitCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    
    
    
    }

    public void ClearDebitCard(){
        textfieldClientName.setText("");
        textfieldIssuerBank.setText("");
        textfieldBankAccount.setText("");
        textfieldBalanceAmount.setText("");
        textfieldCardId.setText("");
        textfieldPIN.setText("");
        
    }
    
    
    public  void getUserInputDebitCard(){
      
        
        try{
            int balanceAmount = Integer.parseInt(textfieldBalanceAmount.getText());
            int PINNumber = Integer.parseInt(textfieldPIN.getText());
            int cardID = Integer.parseInt(textfieldCardId.getText());
            String issuerBank = textfieldIssuerBank.getText(); 
            String clientName = textfieldClientName.getText();
            String bankAccount = textfieldBankAccount.getText();
      

        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(frameDebitCard,"please enter valid numb ");
        }
        if(textfieldBalanceAmount.getText().isEmpty()|| textfieldPIN.getText().isEmpty() ||textfieldCardId.getText().isEmpty()|| issuerBank.isEmpty()||clientName.isEmpty()||bankAccount.isEmpty() ){
            JOptionPane.showMessageDialog(frameDebitCard,"please enter all the information");
        }
        
        
              
        
        
        
        
                     
        objdebit = new Debitcard(balanceAmount,cardID,bankAccount,issuerBank,clientName,PINNumber);
        //arraylist 
        DebitcardArraylist = new ArrayList<Object>();
        DebitcardArraylist.add(objdebit);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //WIthdraw GUI
    public void WithdrawGUI(){
        frameWithdraw = new JFrame("Withdraw Amount");
        frameWithdraw.getContentPane().setBackground(Color.gray);
        panelWithdraw = new JPanel();
        panelWithdraw.setBounds(80,150,800,380);
        panelWithdraw.setBackground(panelcolor);
        panelWithdraw.setLayout(null);
            
        
        //label for withdraw GUI 
        
        labelWithdrawCardId = new JLabel("Card ID");
        labelWithdrawCardId.setBounds(20,30,68,20);
        labelWithdrawCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawCardId.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawCardId);
       
            
        labelWithdrawPIN =  new JLabel("PIN Number");
        labelWithdrawPIN.setBounds(20,120,100,20);
        labelWithdrawPIN.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawPIN.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawPIN);
        
        labelWithdrawalAmount =  new JLabel("Withdrawal Amount");
        labelWithdrawalAmount.setBounds(430,30,240,20);
        labelWithdrawalAmount.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawalAmount.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawalAmount);
        
        labelDateOfWithdrawal = new JLabel("Date Of Withdrawal");
        labelDateOfWithdrawal.setBounds(430,120,300,20);
        labelDateOfWithdrawal.setFont(new Font("Century Gothic",Font.BOLD,17)); 
        labelDateOfWithdrawal.setForeground(Color.BLACK);
        panelWithdraw.add(labelDateOfWithdrawal);
        
        //Textfield for Withdraw GUI 
        textfieldWithdrawCardId = new JTextField();
        textfieldWithdrawCardId.setBounds(20,60,270,32);
        textfieldWithdrawCardId.setBackground(textfieldcolor);
        textfieldWithdrawCardId.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelWithdraw.add(textfieldWithdrawCardId);
            
        textfieldWithdrawPIN = new JTextField();
        textfieldWithdrawPIN.setBounds(20,150,270,32);
        textfieldWithdrawPIN.setBackground(textfieldcolor);
        textfieldWithdrawPIN.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelWithdraw.add(textfieldWithdrawPIN);
        
        textfieldWithdrawalAmount = new JTextField();
        textfieldWithdrawalAmount.setBounds(430,60,270,32);
        textfieldWithdrawalAmount.setBackground(textfieldcolor);
        textfieldWithdrawalAmount.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelWithdraw.add(textfieldWithdrawalAmount);
        
        
        //button for Withdraw GUI 
        buttonBackWithdraw= new JButton("Back");
        buttonBackWithdraw.setBounds(20,330,170,40);
        buttonBackWithdraw.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonBackWithdraw.setForeground(Color.BLACK);
        buttonBackWithdraw.setBackground(lightRed);
        buttonBackWithdraw.setFocusable(false);
        buttonBackWithdraw.addActionListener(this);
        panelWithdraw.add(buttonBackWithdraw);
            
    
        
        buttonWithdrawalAmount = new JButton("Withdraw");
        buttonWithdrawalAmount.setBounds(320,240,200,60);
        buttonWithdrawalAmount.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonWithdrawalAmount.setForeground(Color.BLACK);
        buttonWithdrawalAmount.setBackground(lightBlue);
        buttonWithdrawalAmount.setFocusable(false);
        panelWithdraw.add(buttonWithdrawalAmount);
        
        buttonClearWithdraw = new JButton("Clear ");
        buttonClearWithdraw.setBounds(600,330,170,40);
        buttonClearWithdraw.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonClearWithdraw.setForeground(Color.BLACK);
        buttonClearWithdraw.setBackground(darkgreen);
        buttonClearWithdraw.setFocusable(false);
        //registering listener where current instance is passed.
        buttonClearWithdraw.addActionListener(this);
        panelWithdraw.add(buttonClearWithdraw);
        
        
        frameWithdraw.add(panelWithdraw);
        frameWithdraw.setBounds(200,0,1000,800); //setting position and size of frame
        frameWithdraw.setLayout(null);
        frameWithdraw.setVisible(false);
        frameWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    //Credit Card GUI 
    public void CreditCardGUI(){
        frameCreditCard = new JFrame("coursework 2 ");
        frameCreditCard.getContentPane().setBackground(Color.gray);
        panelCreditCard = new JPanel();
        panelcolor = new Color(172,158,157);
        panelCreditCard.setBounds(80,150,800,550);
        panelCreditCard.setBackground(panelcolor);
        panelCreditCard.setLayout(null);
        
      
        //label for Credit Card GUI 
        labelheading = new JLabel("Sajin Bank");
        labelheading.setBounds(400,10,300,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,40));
        labelheading.setForeground(Color.BLACK);
        frameCreditCard.add(labelheading);
            
        labelheading2 = new JLabel("Credit Card");
        labelheading2.setBounds(430,100,300,50);
        labelheading2.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading2.setForeground(Color.BLACK);
        frameCreditCard.add(labelheading2);
            
        labelClientNameCreditCard = new JLabel("Client Name");
        labelClientNameCreditCard.setBounds(15,30,120,20);
        labelClientNameCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelClientNameCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelClientNameCreditCard);
            
        labelBankAccountCreditCard = new JLabel("Bank Account");
        labelBankAccountCreditCard.setBounds(15,130,120,20);
        labelBankAccountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelBankAccountCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelBankAccountCreditCard);
            
        labelBalanceAmountCreditCard = new JLabel("Balance Amount");
        labelBalanceAmountCreditCard.setBounds(15,240,140,20);
        labelBalanceAmountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelBalanceAmountCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelBalanceAmountCreditCard);
            
        labelIssuerBankCreditCard = new JLabel("Issuer Bank");
        labelIssuerBankCreditCard.setBounds(480,30,140,20);
        labelIssuerBankCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelIssuerBankCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelIssuerBankCreditCard);
            
            
        labelCardIdCreditCard = new JLabel("Card ID");
        labelCardIdCreditCard.setBounds(480,130,68,20);
        labelCardIdCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCardIdCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelCardIdCreditCard);
            
        // textfield for Credit Card GUI     
        textfieldcolor = new Color(255,244,243);    
        textfieldClientNameCreditCard = new JTextField();
        textfieldClientNameCreditCard.setBounds(15,60,270,32);
        textfieldClientNameCreditCard.setBackground(textfieldcolor);
        textfieldClientNameCreditCard.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldClientNameCreditCard);
            
        textfieldIssuerBankCreditCard = new JTextField();
        textfieldIssuerBankCreditCard.setBounds(480,60,270,32);
        textfieldIssuerBankCreditCard.setBackground(textfieldcolor);
        textfieldIssuerBankCreditCard.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldIssuerBankCreditCard);
            
        textfieldBankAccountCreditCard = new JTextField();
        textfieldBankAccountCreditCard.setBounds(15,160,270,32);
        textfieldBankAccountCreditCard.setBackground(textfieldcolor);
        textfieldBankAccountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldBankAccountCreditCard);
            
        textfieldBalanceAmountCreditCard = new JTextField();
        textfieldBalanceAmountCreditCard.setBounds(15,270,270,32);
        textfieldBalanceAmountCreditCard.setBackground(textfieldcolor);
        textfieldBalanceAmountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldBalanceAmountCreditCard);
            
        textfieldCardIdCreditCard = new JTextField();
        textfieldCardIdCreditCard.setBounds(480,160,270,32);
        textfieldCardIdCreditCard.setBackground(textfieldcolor);
        textfieldCardIdCreditCard.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldCardIdCreditCard);
            
        
            

        // Buttons for CreditCard GUI 
        lightBlue = new Color(70, 129, 244);
        buttonAddCreditCard = new JButton("Add Credit Card");
        buttonAddCreditCard.setBounds(550,360,200,60);
        buttonAddCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonAddCreditCard.setForeground(Color.BLACK);
        buttonAddCreditCard.setBackground(lightBlue);
        buttonAddCreditCard.setFocusable(false);
        panelCreditCard.add(buttonAddCreditCard);
            
        Color darkgreen = new Color(135, 95, 30);
        buttonClearCreditCard  = new JButton("Clear ");
        buttonClearCreditCard .setBounds(570,490,170,40);
        buttonClearCreditCard .setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonClearCreditCard .setForeground(Color.BLACK);
        buttonClearCreditCard .setBackground(darkgreen);
        buttonClearCreditCard .setFocusable(false);
        //registering listener where current instance is passed.
        buttonClearCreditCard .addActionListener(this);
        panelCreditCard .add(buttonClearCreditCard);
            
        lightgreen = new Color(39, 178, 125);
        buttonDisplayCreditCard  = new JButton("Display");
        buttonDisplayCreditCard.setBounds(300,490,170,40);
        buttonDisplayCreditCard.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonDisplayCreditCard.setForeground(Color.BLACK);
        buttonDisplayCreditCard.setBackground(lightgreen);
        buttonDisplayCreditCard.setFocusable(false);
        panelCreditCard.add(buttonDisplayCreditCard );
            
            
       
        lightRed = new Color(189,73,73);   
        buttonBackCreditCard = new JButton("Back");
        buttonBackCreditCard.setBounds(40,490,170,40);
        buttonBackCreditCard.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonBackCreditCard.setForeground(Color.BLACK);
        buttonBackCreditCard.setBackground(lightRed);
        buttonBackCreditCard.setFocusable(false);
        //registering listener where current instance is passed.
        buttonBackCreditCard.addActionListener(this);
        panelCreditCard .add(buttonBackCreditCard );
            
            
        frameCreditCard.add(panelCreditCard);
        frameCreditCard.setBounds(200,0,1000,800); //setting position and size of frame
        frameCreditCard.setLayout(null);
        frameCreditCard.setVisible(false);
        frameCreditCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
    //main method of the class
    public static void main(String[] args){
        //Creating object of class BankingGUI
        BankingGUI first = new BankingGUI();
        
    }
   
}