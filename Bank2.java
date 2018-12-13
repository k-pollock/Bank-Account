/**
 * Bank2
 * 
 * Jennefer Maldonado 
 * Kayla Pollock
 * 
 * 27 April 2017
 */
public class Bank2 implements BankInterface
{
   private String nameOfBank;
   private ListReferenceBased account;
   private int numOfAccounts;
    public Bank2(String s)
    {
        nameOfBank = s;
        account = new ListReferenceBased();
        numOfAccounts = 0;
    }
    
    public void addAccount(Account a)
    {
        account.insertNoDuplicates(a); 
        numOfAccounts++;
    }
    
    public void removeAccount(long id){
       for (int i = 1; i <= this.account.size(); i++)
        {
           Account acc = (Account)account.get(i);
           if(acc.getId()==(id))
           {
               account.remove(i);
            }
        }  
    }
    
    public Account search(long s)
    { 
      for (int i = 1; i <= this.account.size(); i++)
        {
           Account acc = (Account)account.get(i);
           if(acc.getId()==(s))
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
    
    //boolean
    public void withdraw(long s, Money m)
    {
        Account acc = (this.search(s));
        if(acc != null)
        {
        acc.withdraw(m);
       }
    }
    
    public void sortAccounts(){
    }
    
    public boolean insertNoDuplicates(Account a){
        return true;
    }
    
    public int size(){
        return numOfAccounts;
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
  
    public static void main (String[]args){
      BankInterface bank = new Bank2("H");
      Account acc = new Account("Jenn", 17, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 66, 900);
      bank.addAccount(acc);
      bank.addAccount(acc1);
      bank.addAccount(acc2);
      System.out.println(bank);
    }
}
