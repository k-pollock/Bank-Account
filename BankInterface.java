/** 
 * Jennefer Maldonado, Kayla Pollock
 * 30 March 2017
 */
public interface BankInterface
{   
    public void sortAccounts();
    
    public int size();
    
    public boolean insertNoDuplicates(Account a);
    
    public void removeAccount(long s);
    
    /**
     * Adds an account to the array account
     * Precondition: a is an account object
     * Postcondition: the account is added to array 
     * at position numOfAccounts and that is incremented
     */
    public void addAccount(Account a);

    
    /**
     * Calls helper method to search through accounts
     * Precondition: s is a valid string
     * Postcondition: if binary search results in a -1 
     * the method does nothing but if it finds the 
     * id it returns the account
     */
    public Account search(long s);
    
    
    /**
     * Deposits Money m into account with id s
     * Precondition: m is the money amount to be deposited
     * into the id (String s)
     * Postcondition: if the id is found, then the money
     * is deposited into the account
     */
    public void deposit(long s, Money m);
    
    
    /**
     * Withdraws Money m from account with id s
     * Precondition: m is the money amount to be withdrawn
     * from the accout with id s
     * Postcondition: if the id of string s is found, then the
     * money is withdrawn from account
     */
    public void withdraw(long s, Money m);
    
    
    /**
     * Prints the accounts in order as a String
     * Precondition: none
     * Postcondition: returns all attributes formatted into a string
     */
    public String toString();
}
