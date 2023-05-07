
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

// BankingGUI class implements the ActionListener 
public class BankingGUI implements ActionListener{
    JFrame frameMain,frameDebitCard,frameWithdraw,frameCreditCard,frameCancelCreditCard,frameCreditlimit;
    JPanel panelDebitCard,panelWithdraw,panelCreditCard,panelCancelCreditCard,panelCreditlimit;
    
    
    
    Color panelcolor,textfieldcolor,lightBlue,Montecarlo, darkgreen,lightgreen,lightRed,DarkBlue;
    
    JButton buttonDebitCard,buttonClearDebitCard,buttonDisplayDebitCard,buttonWithdraw,buttonBackDebitCard,buttonBackWithdraw,buttonAddDebitCard,
    buttonWithdrawalAmount,buttonClearWithdraw, buttonAddCreditCard,buttonCreditCard,buttonClearCreditCard,buttonDisplayCreditCard,buttonBackCreditlimit,
    buttonBackCreditCard,buttonBackCancelCreditCard,buttonCancelCreditCard,buttonCancelCredit,buttonSetCreditLimit,buttonCreditLimit;  
    
    JTextField textfieldIssuerBank,textfieldClientName,textfieldBankAccount,textfieldBalanceAmount,textfieldCardId,textfieldWithdrawCardId,
    textfieldWithdrawalAmount,textfieldIssuerBankCreditCard,textfieldClientNameCreditCard,textfieldBankAccountCreditCard,textfieldSetCreditlimit,textfieldGracePeriod,
    textfieldCardIdCreditCard,textfieldBalanceAmountCreditCard,textfieldCVCNumber,textfieldInterestRate,textfieldCancelCreditCardId,textfieldCreditlimitCardId,textfieldCreditlimit;
    
    JPasswordField textfieldPIN,textfieldWithdrawPIN;
    JComboBox withdrawYear,withdrawMonth,withdrawDay, expirationYear,expirationMonth,expirationDaP ;
    ArrayList<Bankcard> BankcardArraylist;
   
    int balanceAmount,cardID,PINNumber,balanceAmountCreditCard,cardIDCreditCard,CVCNumber,cardIdWithdraw,PINNumberWithdraw,withdrawAmount,
    PINNumberCreditCard,cardIdCancelCreditCard, cardIdSetCreditlimit,gracePeriod;
    double InterestRate,creditlimit;
   
    
     
    
    public BankingGUI(){
        BankcardArraylist = new ArrayList<Bankcard>(); 
        frameMain = new JFrame("sajin bank");
        frameMain.getContentPane().setBackground(Color.gray);
        JLabel labelheading1 = new JLabel("Welcome!!!");
        labelheading1.setBounds(360,65,400,50);
        labelheading1.setFont(new Font("Century Gothic",Font.BOLD,60));
        labelheading1.setForeground(Color.BLACK);
        frameMain.add(labelheading1);
        
        JLabel labelheading = new JLabel("Our Services");
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
            debitCardGUI();
            frameMain.setVisible(false);
            frameDebitCard.setVisible(true);
            frameWithdraw.setVisible(false);
        }
        else if (e.getSource() == buttonBackDebitCard ||  e.getSource() == buttonBackCreditCard){
            frameMain.setVisible(true);
            frameDebitCard.setVisible(false);
            frameCreditCard.setVisible(false);
        }
        else if (e.getSource() == buttonBackCancelCreditCard || e.getSource() == buttonBackCreditlimit  ){
            frameCreditCard.setVisible(true);
            frameCancelCreditCard.setVisible(false);
            frameCreditlimit.setVisible(false);
            
           
        }
        
        else if ( e.getSource() == buttonWithdraw){
            withdrawGUI();
            frameMain.setVisible(false);
            frameDebitCard.setVisible(false);
            frameWithdraw.setVisible(true);
        }
        else if (e.getSource() == buttonClearDebitCard  ){
            clearDebitCard();
        }
        else if (e.getSource() == buttonClearCreditCard ){
            clearCreditCard();
        }
        
        else if(e.getSource() == buttonSetCreditLimit ){
            setCreditLimitGUI();
             frameCreditlimit.setVisible(true);
            frameMain.setVisible(false);
           frameCreditCard.setVisible(false);
          
        }
        
        else if (e.getSource() == buttonClearWithdraw ){
        textfieldWithdrawCardId.setText("");
        textfieldWithdrawalAmount.setText("");
        textfieldWithdrawPIN.setText("");
        }
        else if (e.getSource() == buttonCreditCard){
            creditcardGUI();
            frameMain.setVisible(false);
            frameCreditCard.setVisible(true);
        }
        else if(e.getSource() == buttonAddDebitCard){
            userInputDebitCard();
            
        }
        else if(e.getSource() == buttonCancelCredit){
           cancelcreditcardGUI();
           frameMain.setVisible(false);
           frameCreditCard.setVisible(false);
           frameCancelCreditCard.setVisible(true);
           
        }
        else if(e.getSource() == buttonDisplayDebitCard){
             displayDebitCard();
        }
        else if (e.getSource() == buttonAddCreditCard){
                userInputCreditCard();    
                
        }
        else if(e.getSource() == buttonDisplayCreditCard){
            displayCreditCard();
        }
        else if (e.getSource() == buttonWithdrawalAmount){
            userInputWithdrawAmount();
        }
        else if (e.getSource() == buttonCancelCreditCard){
            userInputCancelCreditCard();
        }
        else if (e.getSource() == buttonCreditLimit){
            userInputSetCreditLimit();
            
        }
        
   
    
       
    }

    
    //Debit Card GUI 
    public void debitCardGUI(){
            frameDebitCard = new JFrame("coursework 2 ");
            frameDebitCard.getContentPane().setBackground(Color.gray);
            panelDebitCard = new JPanel();
            panelDebitCard.setBounds(100,150,800,550);
            panelcolor = new Color(172,158,157);
            panelDebitCard.setBackground(panelcolor);
            panelDebitCard.setLayout(null);
            
            
            JLabel labelheading = new JLabel("Sajin Bank");
            labelheading.setBounds(400,10,300,50);
            labelheading.setFont(new Font("Century Gothic",Font.BOLD,40));
            labelheading.setForeground(Color.BLACK);
            frameDebitCard.add(labelheading);
            
            JLabel labelheading2 = new JLabel("Debit Card");
            labelheading2.setBounds(430,100,300,50);
            labelheading2.setFont(new Font("Century Gothic",Font.BOLD,30));
            labelheading2.setForeground(Color.BLACK);
            frameDebitCard.add(labelheading2);
            
            JLabel labelClientName = new JLabel("Client Name");
            labelClientName.setBounds(15,30,120,20);
            labelClientName.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelClientName.setForeground(Color.BLACK);
            panelDebitCard.add(labelClientName);
            
            JLabel labelBankAccount = new JLabel("Bank Account");
            labelBankAccount.setBounds(15,130,120,20);
            labelBankAccount.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelBankAccount.setForeground(Color.BLACK);
            panelDebitCard.add(labelBankAccount);
            
            JLabel labelBalanceAmount = new JLabel("Balance Amount");
            labelBalanceAmount.setBounds(15,240,140,20);
            labelBalanceAmount.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelBalanceAmount.setForeground(Color.BLACK);
            panelDebitCard.add(labelBalanceAmount);
            
            JLabel labelIssuerBank = new JLabel("Issuer Bank");
            labelIssuerBank.setBounds(480,30,140,20);
            labelIssuerBank.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelIssuerBank.setForeground(Color.BLACK);
            panelDebitCard.add(labelIssuerBank);
            
            
            JLabel labelCardId = new JLabel("Card ID");
            labelCardId.setBounds(480,130,68,20);
            labelCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
            labelCardId.setForeground(Color.BLACK);
            panelDebitCard.add(labelCardId);
            
            
            JLabel labelPIN =  new JLabel("PIN Number");
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
            
            textfieldPIN = new JPasswordField();
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
    public void clearCreditCard(){
        textfieldClientNameCreditCard.setText("");
        textfieldIssuerBankCreditCard.setText("");
        textfieldBankAccountCreditCard.setText("");
        textfieldCVCNumber.setText("");
        textfieldCardIdCreditCard.setText("");
        textfieldInterestRate.setText("");
        textfieldBalanceAmountCreditCard.setText("");
     
    }

    public void clearDebitCard(){
        textfieldClientName.setText("");
        textfieldIssuerBank.setText("");
        textfieldBankAccount.setText("");
        textfieldBalanceAmount.setText("");
        textfieldCardId.setText("");
        textfieldPIN.setText("");
        
    }
    
    
    public  void userInputDebitCard(){
        String issuerBank = textfieldIssuerBank.getText(); 
        String clientName = textfieldClientName.getText();
        String bankAccount = textfieldBankAccount.getText();
        
        if(textfieldBalanceAmount.getText().isEmpty()|| textfieldPIN.getText().isEmpty() ||textfieldCardId.getText().isEmpty()|| issuerBank.isEmpty()||clientName.isEmpty()||bankAccount.isEmpty() ){
            JOptionPane.showMessageDialog(frameDebitCard,"please enter all the information");
        }
        else{
        try{
        balanceAmount = Integer.parseInt(textfieldBalanceAmount.getText());
        PINNumber = Integer.parseInt(textfieldPIN.getText());
        cardID = Integer.parseInt(textfieldCardId.getText());
        }catch(NumberFormatException e ){
             JOptionPane.showMessageDialog(frameDebitCard,"Incorrect Format");
        }
        
           
         for (Bankcard card : BankcardArraylist){   
                 if(card instanceof Debitcard ){
                     if(cardID == card.getCard_Id()){
                         
                         
                        JOptionPane.showMessageDialog(frameDebitCard,"ERROR,Card ID already exist","Debit Card",JOptionPane.WARNING_MESSAGE);
                        return;
                }
            }
           
            }
             BankcardArraylist.add(new Debitcard(balanceAmount,cardID,bankAccount,issuerBank,clientName,PINNumber));
            JOptionPane.showMessageDialog(frameDebitCard,"Debitcard added sucessfully");
        }
        }
    
    public void displayDebitCard(){
    for (Bankcard card : BankcardArraylist){
        
        if(card instanceof Debitcard){
            Debitcard debit = (Debitcard) card; 
               String DebitCardDetail = "Clientname:   "+debit.getClient_Name()+"\n"+"Bank Account:  "
                                        +debit.getBank_Account()+"\n"+"Issuer Bank:  " + debit.getIssuer_Bank()+"\n"+
                                        "Card ID:   "+Integer.toString(debit.getCard_Id())+"\n"+"Balance Amount:   " + Integer.toString(debit.getBalance_Amount())+"\n" 
                                        + "PIN number:    "+Integer.toString(debit.getPin_Number());
                
                
                JOptionPane.showMessageDialog(frameDebitCard,DebitCardDetail,"Debit Card",JOptionPane.INFORMATION_MESSAGE);
                debit.display();
                
        }
       
        
    }
        
    
    }
    
    
    
    
    
    //WIthdraw GUI
    public void withdrawGUI(){
        frameWithdraw = new JFrame("Withdraw Amount");
        frameWithdraw.getContentPane().setBackground(Color.gray);
        panelWithdraw = new JPanel();
        panelWithdraw.setBounds(80,150,800,380);
        panelWithdraw.setBackground(panelcolor);
        panelWithdraw.setLayout(null);
            
        
        //label for withdraw GUI 
        JLabel labelheading = new JLabel("Withdraw Amount");
        labelheading.setBounds(290,35,400,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading.setForeground(Color.BLACK);
        frameWithdraw.add(labelheading);
        
        JLabel labelWithdrawCardId = new JLabel("Card ID");
        labelWithdrawCardId.setBounds(20,30,68,20);
        labelWithdrawCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawCardId.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawCardId);
       
            
        JLabel labelWithdrawPIN =  new JLabel("PIN Number");
        labelWithdrawPIN.setBounds(20,120,100,20);
        labelWithdrawPIN.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawPIN.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawPIN);
        
        JLabel labelWithdrawalAmount =  new JLabel("Withdrawal Amount");
        labelWithdrawalAmount.setBounds(430,30,240,20);
        labelWithdrawalAmount.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelWithdrawalAmount.setForeground(Color.BLACK);
        panelWithdraw.add(labelWithdrawalAmount);
        
        JLabel labelDateOfWithdrawal = new JLabel("Date Of Withdrawal");
        labelDateOfWithdrawal.setBounds(430,120,300,20);
        labelDateOfWithdrawal.setFont(new Font("Century Gothic",Font.BOLD,17)); 
        labelDateOfWithdrawal.setForeground(Color.BLACK);
        panelWithdraw.add(labelDateOfWithdrawal);
        
        String withdrawyear[]= {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};
        String withdrawmonth[] = {"Janauary","Feburary","March","April","May","June","July","August","September","October","November","December"};
        String[] withdrawday = new String[31] ;
        for (int i = 0; i < 31; i++) {
            withdrawday[i] = Integer.toString(i + 1);
        }
        
        withdrawYear = new JComboBox(withdrawyear);
        withdrawMonth = new JComboBox(withdrawmonth);
        withdrawDay = new JComboBox(withdrawday);
        withdrawYear.setBounds(430,140,70,30);
        withdrawMonth.setBounds(520,140,90,30);
        withdrawDay.setBounds(630,140,70,30);
        panelWithdraw.add(withdrawYear);
        panelWithdraw.add(withdrawMonth);
        panelWithdraw.add(withdrawDay);
        
        
        
        
        
        
        //Textfield for Withdraw GUI 
        textfieldWithdrawCardId = new JTextField();
        textfieldWithdrawCardId.setBounds(20,60,270,32);
        textfieldWithdrawCardId.setBackground(textfieldcolor);
        textfieldWithdrawCardId.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelWithdraw.add(textfieldWithdrawCardId);
            
        textfieldWithdrawPIN = new JPasswordField();
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
        buttonWithdrawalAmount.addActionListener(this);
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
    public void userInputWithdrawAmount(){
        String date =withdrawYear.getSelectedItem()+"/"+withdrawMonth.getSelectedItem()+"/"+withdrawDay.getSelectedItem();
        
        if(textfieldWithdrawCardId.getText().isEmpty()||textfieldWithdrawPIN.getText().isEmpty()||textfieldWithdrawalAmount.getText().isEmpty()){
             JOptionPane.showMessageDialog(frameWithdraw,"Please enter all information","Withdraw",JOptionPane.WARNING_MESSAGE);  
        }
        else{
        try{
         cardIdWithdraw = Integer.parseInt(textfieldWithdrawCardId.getText());
         PINNumberWithdraw = Integer.parseInt(textfieldWithdrawPIN.getText());
         withdrawAmount = Integer.parseInt(textfieldWithdrawalAmount.getText());
        }catch(NumberFormatException e ){
            JOptionPane.showMessageDialog(frameWithdraw,"Incorrect format","Withdraw",JOptionPane.WARNING_MESSAGE);            
        }
        
         for (Bankcard card : BankcardArraylist){   
                     if(card instanceof Debitcard ){
                         Debitcard debit = (Debitcard) card; 
                         if(cardIdWithdraw == card.getCard_Id() && PINNumberWithdraw == debit.getPin_Number()){
                             debit.withdraw(withdrawAmount,date,PINNumberWithdraw);
                             if(debit.getHas_Withdrawn()==true){
                                JOptionPane.showMessageDialog(frameWithdraw,"Sucessfully Withdrawn","Withdraw",JOptionPane.INFORMATION_MESSAGE);   
                                 String withdraw = "Clientname:   "+debit.getClient_Name()+"\n"+"Bank Account:  "
                                        +debit.getBank_Account()+"\n"+"Issuer Bank:  " + debit.getIssuer_Bank()+"\n"+
                                        "Card ID:   "+Integer.toString(debit.getCard_Id())+"\n"+"Balance Amount:   " + Integer.toString(debit.getBalance_Amount())+"\n" 
                                         +"Withdrawal Amount:  "+ Integer.toString(withdrawAmount)+"\nDate of Withdrawl " + debit.getDate_Of_Withdrawal() ;
                             
                                 JOptionPane.showMessageDialog(frameWithdraw,withdraw,"Withdraw",JOptionPane.INFORMATION_MESSAGE);   
                            
                            return;
                        }
                        if(debit.getHas_Withdrawn() == false){
                            JOptionPane.showMessageDialog(frameWithdraw,"Insufficent Balance","Withdraw",JOptionPane.INFORMATION_MESSAGE);   
                        }
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(frameWithdraw,"please enter correct PIN and Card ID","Withdraw",JOptionPane.WARNING_MESSAGE);
                    }
            }    
        
        
    }
}
    
}    
//Credit Card GUI 
    public void creditcardGUI(){
        frameCreditCard = new JFrame("coursework 2 ");
        frameCreditCard.getContentPane().setBackground(Color.gray);
        panelCreditCard = new JPanel();
        panelcolor = new Color(172,158,157);
        panelCreditCard.setBounds(100,130,800,600);
        panelCreditCard.setBackground(panelcolor);
        panelCreditCard.setLayout(null);
        
      
        //label for Credit Card GUI 
        JLabel labelheading = new JLabel("Sajin Bank");
        labelheading.setBounds(400,10,300,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,40));
        labelheading.setForeground(Color.BLACK);
        frameCreditCard.add(labelheading);
            
        JLabel labelheading2 = new JLabel("Credit Card");
        labelheading2.setBounds(430,80,300,50);
        labelheading2.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading2.setForeground(Color.BLACK);
        frameCreditCard.add(labelheading2);
            
        JLabel labelClientNameCreditCard = new JLabel("Client Name");
        labelClientNameCreditCard.setBounds(15,30,120,20);
        labelClientNameCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelClientNameCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelClientNameCreditCard);
            
        JLabel labelBankAccountCreditCard = new JLabel("Bank Account");
        labelBankAccountCreditCard.setBounds(15,130,120,20);
        labelBankAccountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelBankAccountCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelBankAccountCreditCard);
            
        JLabel labelBalanceAmountCreditCard = new JLabel("Balance Amount");
        labelBalanceAmountCreditCard.setBounds(15,240,140,20);
        labelBalanceAmountCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelBalanceAmountCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelBalanceAmountCreditCard);
            
        JLabel labelIssuerBankCreditCard = new JLabel("Issuer Bank");
        labelIssuerBankCreditCard.setBounds(480,30,140,20);
        labelIssuerBankCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelIssuerBankCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelIssuerBankCreditCard);
            
            
        JLabel labelCardIdCreditCard = new JLabel("Card ID");
        labelCardIdCreditCard.setBounds(480,130,68,20);
        labelCardIdCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCardIdCreditCard.setForeground(Color.BLACK);
        panelCreditCard.add(labelCardIdCreditCard);
        
        JLabel labelCVCNumber = new JLabel("CVC Number");
        labelCVCNumber.setBounds(480,240,130,20);
        labelCVCNumber.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCVCNumber.setForeground(Color.BLACK);
        panelCreditCard.add(labelCVCNumber);
        
        JLabel labelInterestRate = new JLabel("Interest Rate");
        labelInterestRate.setBounds(15,330,130,20);
        labelInterestRate.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelInterestRate.setForeground(Color.BLACK);
        panelCreditCard.add(labelInterestRate);
        
            
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
                
        textfieldCVCNumber = new JTextField();
        textfieldCVCNumber.setBounds(480,270,270,32);
        textfieldCVCNumber.setBackground(textfieldcolor);
        textfieldCVCNumber.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldCVCNumber);
        
        textfieldInterestRate = new JTextField();
        textfieldInterestRate.setBounds(15,360,270,32);
        textfieldInterestRate.setBackground(textfieldcolor);
        textfieldInterestRate.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditCard.add(textfieldInterestRate);
        
            

        // Buttons for CreditCard GUI 
        lightBlue = new Color(70, 129, 244);
        buttonAddCreditCard = new JButton("Add Credit Card");
        buttonAddCreditCard.setBounds(550,440,200,60);
        buttonAddCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonAddCreditCard.setForeground(Color.BLACK);
        buttonAddCreditCard.setBackground(lightBlue);
        buttonAddCreditCard.setFocusable(false);
        buttonAddCreditCard.addActionListener(this);
        panelCreditCard.add(buttonAddCreditCard);
            
        Color darkgreen = new Color(135, 95, 30);
        buttonClearCreditCard  = new JButton("Clear ");
        buttonClearCreditCard.setBounds(570,540,170,40);
        buttonClearCreditCard .setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonClearCreditCard .setForeground(Color.BLACK);
        buttonClearCreditCard .setBackground(darkgreen);
        buttonClearCreditCard .setFocusable(false);
        //registering listener where current instance is passed.
        buttonClearCreditCard .addActionListener(this);
        panelCreditCard .add(buttonClearCreditCard);
            
        lightgreen = new Color(39, 178, 125);
        buttonDisplayCreditCard  = new JButton("Display");
        buttonDisplayCreditCard.setBounds(300,540,170,40);
        buttonDisplayCreditCard.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonDisplayCreditCard.setForeground(Color.BLACK);
        buttonDisplayCreditCard.setBackground(lightgreen);
        buttonDisplayCreditCard.setFocusable(false);
        buttonDisplayCreditCard.addActionListener(this);
        panelCreditCard.add(buttonDisplayCreditCard );
        
        Color maron = new Color(255,75,75);   
        buttonCancelCredit = new JButton("Cancel Credit Card");
        buttonCancelCredit.setBounds(20,440,240,60);
        buttonCancelCredit.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonCancelCredit.setForeground(Color.BLACK);
        buttonCancelCredit.setBackground(maron);
        buttonCancelCredit.setFocusable(false);
        buttonCancelCredit.addActionListener(this);
        panelCreditCard.add(buttonCancelCredit);
        
        Montecarlo = new Color(118,201,170);  
        buttonSetCreditLimit = new JButton("Set Credit Limit");
        buttonSetCreditLimit.setBounds(280,440,240,60);
        buttonSetCreditLimit.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonSetCreditLimit.setForeground(Color.BLACK);
        buttonSetCreditLimit.setBackground(Montecarlo);
        buttonSetCreditLimit.setFocusable(false);
        buttonSetCreditLimit.addActionListener(this);
        panelCreditCard.add(buttonSetCreditLimit);
            


        lightRed = new Color(189,73,73);   
        buttonBackCreditCard = new JButton("Back");
        buttonBackCreditCard.setBounds(40,540,170,40);
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
      public  void userInputCreditCard(){
        String issuerBankCreditCard = textfieldIssuerBankCreditCard.getText(); 
        String clientNameCreditCard = textfieldClientNameCreditCard.getText();
        String bankAccountCreditCard = textfieldBankAccountCreditCard.getText();
        String expirationdate="e1";
        
        if(textfieldBalanceAmountCreditCard.getText().isEmpty()|| textfieldCVCNumber.getText().isEmpty() ||textfieldCardIdCreditCard.getText().isEmpty()|| issuerBankCreditCard.isEmpty()||
            clientNameCreditCard.isEmpty()||bankAccountCreditCard.isEmpty()|| textfieldInterestRate.getText().isEmpty() ){
            JOptionPane.showMessageDialog(frameCreditCard,"please enter all the information");
        }
        else{
        try{
        balanceAmountCreditCard = Integer.parseInt(textfieldBalanceAmountCreditCard.getText());
        CVCNumber = Integer.parseInt(textfieldCVCNumber.getText());
        InterestRate =Double.parseDouble(textfieldInterestRate.getText()); 
        cardIDCreditCard = Integer.parseInt(textfieldCardIdCreditCard.getText());
        }catch(NumberFormatException e ){
             JOptionPane.showMessageDialog(frameCreditCard,"Incorrect Format");
        }
             
  
         for (Bankcard card : BankcardArraylist){   
                 if(card instanceof Creditcard ){
                     
                     if(cardIDCreditCard == card.getCard_Id()){
                         
                     
                    JOptionPane.showMessageDialog(frameDebitCard,"ERROR,Card ID already exist","Debit Card",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
            }
           
            }
           BankcardArraylist.add(new Creditcard(cardIDCreditCard,clientNameCreditCard,issuerBankCreditCard,bankAccountCreditCard,balanceAmountCreditCard,CVCNumber,InterestRate,expirationdate));
            JOptionPane.showMessageDialog(frameCreditCard,"Credit Card added sucessfully");
        }
       
    }
    public void displayCreditCard(){
        int i = 0;
        for (Bankcard card1 : BankcardArraylist){
        
            if(card1 instanceof Creditcard){
                Creditcard credit = (Creditcard) card1;
                
                   String DebitCardDetail = "Clientname:   "+credit.getClient_Name()+"\n"+"Bank Account:  "
                                            +credit.getBank_Account()+"\n"+"Issuer Bank:  " + credit.getIssuer_Bank()+"\n"+
                                            "Card ID:   "+Integer.toString(credit.getCard_Id())+"\n"+"Balance Amount:   " + Integer.toString(credit.getBalance_Amount())+"\n" 
                                            + "CvcNumber:    "+Integer.toString(credit. getCvc_Number())+"\n"+"InterestRate:    "+ Double.toString(credit.getInterest_Rate());
                    
                  
                    
                    JOptionPane.showMessageDialog(frameCreditCard,DebitCardDetail,"Debit Card",JOptionPane.INFORMATION_MESSAGE);
                    credit.display();
                    
        }
    }
       
        
    }
    
    public void cancelcreditcardGUI(){
        frameCancelCreditCard = new JFrame("Cancel Credit Card");
        frameCancelCreditCard.getContentPane().setBackground(Color.gray);
        panelCancelCreditCard = new JPanel();
        panelCancelCreditCard.setBounds(140,150,700,280);
        panelCancelCreditCard.setBackground(panelcolor);
        panelCancelCreditCard.setLayout(null);
            
        
        JLabel labelheading = new JLabel("Cancel Your Credit Card");
        labelheading.setBounds(290,35,400,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading.setForeground(Color.BLACK);
        frameCancelCreditCard.add(labelheading);
        
        JLabel labelCancelCreditCardId = new JLabel("Card ID");
        labelCancelCreditCardId.setBounds(220,20,68,20);
        labelCancelCreditCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCancelCreditCardId.setForeground(Color.BLACK);
        panelCancelCreditCard.add(labelCancelCreditCardId);
       
            
         
        textfieldCancelCreditCardId = new JTextField();
        textfieldCancelCreditCardId.setBounds(220,50,270,32);
        textfieldCancelCreditCardId.setBackground(textfieldcolor);
        textfieldCancelCreditCardId.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCancelCreditCard.add(textfieldCancelCreditCardId);
        
        
        buttonBackCancelCreditCard= new JButton("Back");
        buttonBackCancelCreditCard.setBounds(20,230,170,40);
        buttonBackCancelCreditCard.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonBackCancelCreditCard.setForeground(Color.BLACK);
        buttonBackCancelCreditCard.setBackground(lightRed);
        buttonBackCancelCreditCard.setFocusable(false);
        buttonBackCancelCreditCard.addActionListener(this);
        panelCancelCreditCard.add(buttonBackCancelCreditCard);
            
    
        Color maron = new Color(255,75,75);
        buttonCancelCreditCard = new JButton("Cancel");
        buttonCancelCreditCard.setBounds(220,140,300,60);
        buttonCancelCreditCard.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonCancelCreditCard.setForeground(Color.BLACK);
        buttonCancelCreditCard.setBackground(maron);
        buttonCancelCreditCard.setFocusable(false);
        buttonCancelCreditCard.addActionListener(this);
        panelCancelCreditCard.add(buttonCancelCreditCard);
    
        frameCancelCreditCard.add(panelCancelCreditCard);
        frameCancelCreditCard.setBounds(200,0,1000,800); //setting position and size of frame
        frameCancelCreditCard.setLayout(null);
        frameCancelCreditCard.setVisible(false);
        frameCancelCreditCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        

    }
    public void userInputCancelCreditCard(){
        try{
        cardIdCancelCreditCard = Integer.parseInt(textfieldCancelCreditCardId.getText());
        
        }catch(NumberFormatException e ){
            JOptionPane.showMessageDialog(frameCancelCreditCard,"Please enter valid format of Card ID","CancelCreditCard",JOptionPane.WARNING_MESSAGE);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(frameCancelCreditCard,"Please enter your Card ID","CancelCreditCard",JOptionPane.WARNING_MESSAGE);
            
        }
                for(Bankcard card2 : BankcardArraylist){
                    if(card2 instanceof Creditcard){
                        Creditcard credit = (Creditcard) card2; 
                        if(cardIdCancelCreditCard == card2.getCard_Id()){
                            credit.cancel_Credit_Card();
                            JOptionPane.showMessageDialog(frameCancelCreditCard,"Your credit card has been cancelled","CancelCreditCard",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        else{
                            JOptionPane.showMessageDialog(frameCancelCreditCard,"Please enter correct CardID","Cancel Credit Card",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    
                }
    }
    
    
    public void setCreditLimitGUI(){
        frameCreditlimit = new JFrame("Set credit limit");
        frameCreditlimit.getContentPane().setBackground(Color.gray);
        panelCreditlimit = new JPanel();
        panelCreditlimit.setBounds(140,120,700,450);
        panelCreditlimit.setBackground(panelcolor);
        panelCreditlimit.setLayout(null);
            
        
        JLabel labelheading = new JLabel("Set Credit limit");
        labelheading.setBounds(350,35,400,50);
        labelheading.setFont(new Font("Century Gothic",Font.BOLD,30));
        labelheading.setForeground(Color.BLACK);
        frameCreditlimit.add(labelheading);
        
        JLabel labelCreditlimitCardId = new JLabel("Card ID");
        labelCreditlimitCardId.setBounds(20,20,68,20);
        labelCreditlimitCardId.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCreditlimitCardId.setForeground(Color.BLACK);
        panelCreditlimit.add(labelCreditlimitCardId);
           
        JLabel labelCreditlimit = new JLabel("Credit limit");
        labelCreditlimit.setBounds(400,20,88,20);
        labelCreditlimit.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelCreditlimit.setForeground(Color.BLACK);
        panelCreditlimit.add(labelCreditlimit);
        
        JLabel labelGracePeriod = new JLabel("Grace Period");
        labelGracePeriod.setBounds(20,130,150,20);
        labelGracePeriod.setFont(new Font("Century Gothic",Font.BOLD,17));
        labelGracePeriod.setForeground(Color.BLACK);
        panelCreditlimit.add(labelGracePeriod);
        
       
       
        textfieldCreditlimitCardId = new JTextField();
        textfieldCreditlimitCardId .setBounds(20,50,270,32);
        textfieldCreditlimitCardId .setBackground(textfieldcolor);
        textfieldCreditlimitCardId .setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditlimit.add(textfieldCreditlimitCardId);
        
        textfieldCreditlimit = new JTextField();
        textfieldCreditlimit.setBounds(400,50,270,32);
        textfieldCreditlimit.setBackground(textfieldcolor);
        textfieldCreditlimit.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditlimit.add(textfieldCreditlimit);
        
        
        
        textfieldGracePeriod = new JTextField();
        textfieldGracePeriod.setBounds(20,160,270,32);
        textfieldGracePeriod.setBackground(textfieldcolor);
        textfieldGracePeriod.setFont(new Font("Century Gothic",Font.BOLD,14));
        panelCreditlimit.add(textfieldGracePeriod);
        
        
        
        
        buttonBackCreditlimit = new JButton("Back");
        buttonBackCreditlimit.setBounds(20,400,170,40);
        buttonBackCreditlimit.setFont(new Font("Century Gothic",Font.BOLD,15));
        buttonBackCreditlimit.setForeground(Color.BLACK);
        buttonBackCreditlimit.setBackground(lightRed);
        buttonBackCreditlimit.setFocusable(false);
        buttonBackCreditlimit.addActionListener(this);
        panelCreditlimit.add(buttonBackCreditlimit);
            
    
        lightBlue = new Color(70, 129, 244);
        buttonCreditLimit = new JButton("Set Credit Limit");
        buttonCreditLimit.setBounds(250,300,250,60);
        buttonCreditLimit.setFont(new Font("Century Gothic",Font.BOLD,17));
        buttonCreditLimit.setForeground(Color.BLACK);
        buttonCreditLimit.setBackground(lightBlue);
        buttonCreditLimit.setFocusable(false);
        buttonCreditLimit.addActionListener(this);
        panelCreditlimit.add(buttonCreditLimit);
    
        frameCreditlimit.add(panelCreditlimit);
        frameCreditlimit.setBounds(200,0,1000,800); //setting position and size of frame
        frameCreditlimit.setLayout(null);
        frameCreditlimit.setVisible(true);
        //frameCreditlimit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
        
        
        
        
    }
    public void userInputSetCreditLimit(){
        try{
            cardIdSetCreditlimit = Integer.parseInt(textfieldCreditlimitCardId.getText());
            gracePeriod = Integer.parseInt(textfieldGracePeriod.getText());
            creditlimit = Double.parseDouble(textfieldCreditlimit.getText());
        }catch(NumberFormatException e ){
              JOptionPane.showMessageDialog(frameCreditlimit,"Please enter valid data","Set Credit Limit",JOptionPane.WARNING_MESSAGE);
            
            
        }
        
        for(Bankcard card : BankcardArraylist){
            if(card instanceof Creditcard){
                Creditcard credit = (Creditcard) card; 
                if(cardIdSetCreditlimit == card.getCard_Id()){
                    
                    credit.setCredit_Limit(creditlimit,gracePeriod);
                    String creditlimitdetail = "Card ID :  " + credit.getCard_Id()+ "\n" +"Credit Limit :   "+ credit.getCredit_Limit()+ "\n" + "Grace Period :   "+ credit.getGrace_Period() ;
                   JOptionPane.showMessageDialog(frameCreditlimit,creditlimitdetail,"Set Credit Limit",JOptionPane.WARNING_MESSAGE);
                   return; 
                }
                else{
                    JOptionPane.showMessageDialog(frameCreditlimit,"Incorrect Card ID","Set Credit Limit",JOptionPane.WARNING_MESSAGE);
                }
                
                
            }
            
        }
        
        
        
        
    }
    
    
    
    //main method of the class
    public static void main(String[] args){
        //Creating object of class BankingGUI
        BankingGUI first = new BankingGUI();
        
    }
   
}