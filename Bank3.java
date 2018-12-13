import java.util.*;
/**
 * Bank3
 * 
 * Jennefer Maldonado, Kayla Pollock
 * 26 April 2017
 */
public class Bank3 implements BankInterface
{
   private String nameOfBank;
   private ArrayList <Account> account;
   private int numOfAccounts;
    public Bank3(String s)
    {
        nameOfBank = s;
        account = new ArrayList();
        numOfAccounts = 0;
    }
    
    public void sortAccounts()
    {
      Collections.sort(account);
    }
    
    public int size(){
        return numOfAccounts;
    }
    
    public void addAccount(Account a)
    {
       if(insertNoDuplicates(a)){
       account.add(a);
       numOfAccounts++;
      }
    }
    
    public boolean insertNoDuplicates(Account a){
        long id = a.getId();
        for(Account acc: account){
          if(id == acc.getId()){
            return false;
          }
        }
        return true;
    }
    
    public void removeAccount(long s){
       ArrayList<Account> toRemove = new ArrayList();
       for(Account acc: account){
          if(s == acc.getId()){
            toRemove.add(acc);
          }
        } 
        account.removeAll(toRemove);
    }
    
    public Account search(long s)
    { 
      for (Account acc: account){
           if(acc.getId() == (s))
           {
               return acc;
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
       ListIterator it = account.listIterator();
       while(it.hasNext()){
            value += it.next() + "\r\n";
       }
       return value;
    }
}
