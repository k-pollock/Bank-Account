/**
 * bank1 implements bankinterface & collection of accounts
 * is stored in ListArrayBased
 * 
 * Jennefer Maldonado
 * Kayla Pollock
 * 26 April 2017
 */
public class Bank1 implements BankInterface
{
   private String nameOfBank;
   private ListArrayBased account;
   private int numOfAccounts;
    public Bank1(String s)
    {
        nameOfBank = s;
        account = new ListArrayBased();
        numOfAccounts = 0;
    }
    
    public void addAccount(Account a)
    {
        numOfAccounts++;
        account.add(numOfAccounts, a);  
    }
    
    public Account search(long s)
    { 
      for (int i = 1; i <= this.account.size(); i++)
        {
           Account acc = (Account)account.get(i);
           if(acc.getId() == (s))
           {
               return (Account)account.get(i);
            }
        }
        return null;
    }
    
    public void deposit(long s, Money m)
    {
      Account acc =(this.search(s));
      if( acc != null)
      {
        acc.deposit(m);
      }
    }
    
    public void removeAccount(long s){
    }
    
    public boolean insertNoDuplicates(Account a){
        return true;
    }
    
    public int size(){
        return numOfAccounts;
    }
    
    public void sortAccounts(){
    }
    
    //boolean
    public void withdraw(long s, Money m)
    {
        Account acc = (this.search(s));
        if(acc != null)
        {
        acc.withdraw(m);
       }
    }
    
    @Override
    public String toString()
    {
        String value = "";
        for (int i = 1; i <= account.size(); i++)
        {
            value += " " + account.get(i);
        }
        return value;
    }
}
