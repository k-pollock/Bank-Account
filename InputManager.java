import java.util.Scanner;
/**
 * Manage input to be read from either keyboard or file.
 * 
 * Jennefer Maldonado
 * Kayla Pollock
 * 8 May 2017
 */

public class InputManager
{
    // Method: readOneAccountFrom
    // Precondition: inputSource is a Scanner object, already set up
    // to read from a text file or standard input source (keyboard).
    // Postcondition: returns an Account with the data read for its attributes.
    // Assumption: Account data will be in the format of: name,id,balance
    public static Account readOneAccountFrom (Scanner inputSource)
    {
        // Read one line of account data into oneLine
        System.out.println ("Reading: name,id,balance");
       while(inputSource.hasNext()){
        String oneLine = inputSource.nextLine();
        Scanner lineTokenizer = new Scanner (oneLine);
        lineTokenizer.useDelimiter (",");
        
         String name = lineTokenizer.next ();
        long accountNum = lineTokenizer.nextLong ();
        double balance = lineTokenizer.nextDouble ();
        String accountType = lineTokenizer.next ();
        double max = lineTokenizer.nextDouble ();
        // Create and return an Account object with the data read for one account.
        if(accountType.equalsIgnoreCase("c")){
            Money m = new Money(max);
            Checking oneAccount = new Checking(name, accountNum, balance, m);
            System.out.println ("Account read: " + oneAccount);
            return oneAccount;
        }
        else if(accountType.equalsIgnoreCase("s")){
            Money m = new Money(max);
            Savings oneAccount = new Savings(name, accountNum, balance, max);
            System.out.println ("Account read: " + oneAccount);
            return oneAccount;
        }
        else{
            Account oneAccount = new Account(name, accountNum, balance);
            System.out.println("Account read: " + oneAccount);
            return oneAccount;
        }
       }
        return null; 
    } // end readOneAccountFrom
} // end InputManager
