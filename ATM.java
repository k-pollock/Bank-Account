import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import javax.swing.JOptionPane;
// Driver class for Bank project
public class ATM{
    BankInterface bank;
    public static void main (String[] args){
        BankInterface myBank = new Bank3("a");;
        try {
            // Read data from a file into a Bank.
            // Each line of the file has info for one account. 
            myBank = readFromFile("in_accounts.txt");
            // Print all the data stored in the bank.
            System.out.println("\nData Stored in Bank:");
            myBank.sortAccounts();
            System.out.println (myBank);
        } // end try  
        catch (IOException ioe) {
            System.out.println("IOException in main: " + ioe.getMessage()); 
            ioe.printStackTrace();
        } // end catch
        catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
            e.printStackTrace();
        } // end catch
        long id;
        String transaction;
        int cents;
        int dollars;
        ATM a = new ATM(myBank);
        try{
            String idS = JOptionPane.showInputDialog(null,"Welcome! Please enter your ID number to login:");
            id = Long.parseLong(idS);
            //validate id, will continue loop until valid id entered or cancel
            while(!a.validateId(id)){
                JOptionPane.showMessageDialog(null,"Sorry that ID was invalid.");
                String idS1 = (JOptionPane.showInputDialog(null, "Enter a valid ID"));
                id = Long.parseLong(idS1);
            }

            if(a.validateId(id))
            {
                String[] choices = { "balance", "deposit", "withdraw"};
                String input = (String) JOptionPane.showInputDialog(null, "Choose a transaction...",
                        "Make a Transaction", JOptionPane.QUESTION_MESSAGE, null,
                        choices, // Array of choices
                        choices[1]); // Initial choice
                transaction = input;
                while(!a.validateTrans(transaction)){
                    JOptionPane.showMessageDialog(null,"Sorry that transaction was invalid.");
                    transaction = (JOptionPane.showInputDialog(null, "Enter a valid transaction"));
                }

                //if transaction is a valid transaction completes the proper transaction
                if(a.validateTrans(transaction)){
                    JOptionPane.showMessageDialog(null,"Thank you, the transaction will be executed");
                    String s = a.executeTrans(transaction,id);
                    //deposit
                    if(s.equals("d")){
                        JOptionPane.showMessageDialog(null,"You will be asked to enter amount to deposit.");
                        String dollarS = (JOptionPane.showInputDialog(null, "Dollars:", JOptionPane.QUESTION_MESSAGE));
                        String  centS = (JOptionPane. showInputDialog(null, "Cents:"));
                        dollars = Integer.parseInt(dollarS);
                        cents = Integer.parseInt(centS);
                        a.deposit(id, dollars, cents);
                    }
                    //withdraw
                    else if(s.equals("w")){
                        JOptionPane.showMessageDialog(null,"You will be asked to enter amount to withdraw.");
                        String dollarS = (JOptionPane.showInputDialog(null, "Dollars:"));
                        String  centS = (JOptionPane. showInputDialog(null, "Cents:"));
                        dollars = Integer.parseInt(dollarS);
                        cents = Integer.parseInt(centS);
                        a.withdraw(id, dollars, cents);  
                    }
                    //get balance
                    else if(s.equals("b")){
                        JOptionPane.showMessageDialog(null, "Current balance: " + a.balance(id)); 
                    }
                    //something went wrong
                    else{
                        System.out.println(s);
                    }//end if
                }//end if
            }//end if
        }//end try
        catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null, "Something went wrong, no changes have been made to any account.");
        }
        catch(InsufficientFundsException ife){
            JOptionPane.showMessageDialog(null, "Amount attempted to withdraw was too large.");   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong, no changes have been made to any account."); 
        }//end catch
        //end card thanks the user
        JOptionPane.showMessageDialog(null,"Thank you for banking with us today!");

        try{
            //write bank with changes made to a new file
            a.readToFile();
        }//end try
        catch (IOException ioe) {
            System.out.println("IOException in main: " + ioe.getMessage()); 
            ioe.printStackTrace();
        } // end catch
        catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
            e.printStackTrace();
        } // end catch
    } // end main

    // ** Methods begin here**
    /**
     * Constuctor for the ATM class
     */
    public ATM (BankInterface b){
        bank = b;
    }//end ATM

    /**
     * ReadToFile takes a bank object of accounts and writes 
     * them to a file in the format
     * "Name" "ID" "$dollars.cents"
     * 
     * Precondition: a ATM object has been created & the 
     * method is called on it.
     * Postcondition: the method creates a text file called
     * out_accounts and writes the sorted accounts in the bank.
     */
    public void readToFile()throws IOException {
        FileWriter writer = new FileWriter("out_accounts.txt");
        bank.sortAccounts();
        writer.write(bank.toString());
        writer.close();
    }//end readToFile

    /**
     * Helper method withdraw takes money away from an account
     *  **If a checking account, method throws InsufficientFundsException**
     *  
     *  Precondition: called on an ATM object and recieves parameters
     *  long, int, cents 
     *  Postcondition: withdraws money from the correct account and
     *  calls the withdraw method of the bank class
     */
    public void withdraw(long id, int dollars, int cents){
        Money m = new Money(dollars, cents);
        bank.withdraw(id,m);
    }//end withdraw

    /**
     * Helper method withdraw takes money away from an account
     * 
     *  Precondition: called on an ATM object and recieves parameters
     *  long, int, cents 
     *  Postcondition: calls the deposit method of the bank class and
     *  deposits money into the correct account.
     */ 
    public void deposit(long id, int dollars, int cents){
        Money m = new Money(dollars, cents);
        bank.deposit(id, m);
    }//end deposit

    /**
     * Helper method balance returns the balance of an account
     * 
     * Precondition: recieves a parameter of the id of the desired account
     * Postcondition: calls the search method in bank to retrieve the 
     * account and then gets the balance of the account and returns it. 
     */ 
    public String balance(long id){
        Account acc = bank.search(id);
        Money m = acc.balance();
        return m.toString();
    }//end balance

    /**
     * Checks user input to make sure that a valid ID was inputted
     * 
     * Precondition: an ID of type long is sent in and the method is
     * called on a ATM object
     * Postcondition:retursn either true or false if the id is a valid
     * id in the arraylist of accounts
     */
    public boolean validateId(long id){
        if(bank.search(id) != null){  
            return true;
        }
        else{
            return false;
        }
    }//end validateId

    /**
     * Helper method validate transaction makes sure the user 
     * inputs a valid transaction
     * 
     * Precondition: a transaction of type String is passed as
     * a parameter and the method is called on an ATM object
     * Postcondition: returns true if the transaction is valid or
     * false if it is not
     */
    public boolean validateTrans(String s){
        if(s.equalsIgnoreCase("balance")){
            return true;
        }
        else if(s.equalsIgnoreCase("deposit")){
            return true;
        }
        else if(s.equalsIgnoreCase("withdraw")){
            return true;
        }
        else{
            //if transaction is NOT valid
            return false;
        }
    }//end validateTrans

    /**
     * Helper method execute transaction finds out which transaction 
     * the user wants to complete.
     * 
     * Precondition: validateTrans method has already validated that
     * the user has entered a valid transaction and method is called
     * on ATM object
     * Postcondition: returns the letter of the transaction the user 
     * wants to complete which is then handled in the main method.
     */
    public String executeTrans(String s, long id){
        if(s.equalsIgnoreCase("balance")){
            return "b";
        }
        else if(s.equalsIgnoreCase("deposit")){
            return "d";
        }
        else if(s.equalsIgnoreCase("withdraw")){
            return "w";
        } 
        else{
            //if something goes wrong
            return "";
        }
    }//end executeTrans

    /**
     * readFromFile: reads account data from a .txt file
     * Precondition: A proper text file is sent in as a parameter
     * Postcondition: returns the toString of the new bank created by the accounts 
     * read in from the text file provided.
     */
    public static BankInterface readFromFile (String fileName) throws IOException
    {
        // Create a bank.
        BankInterface myBank = new Bank3("ADT");
        // Open a file for reading.
        Scanner inputSource = new Scanner (new File(fileName));  
        // while there are more tokens to read from the input source...
        while(inputSource.hasNext()){
            // Read one line of input from the file into an Account object
            Account acct = (Account)InputManager.readOneAccountFrom(inputSource);
            // Store the account info in the bank.
            myBank.addAccount(acct);
        } // end while
        return myBank;
    } // end readFromFile
} // end ATM