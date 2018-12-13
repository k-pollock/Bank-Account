/**
 * Kayla Pollock
 * Jennefer Maldonado
 * 13 May 2017
 */
public class Account implements Comparable
{
   private String name;
   private long id;
   private Money balance;
   
   public Account(String n, long i, double b)
   {
       name = n;
       id = i;
       Money m = new Money(b);
       balance = m;
   }
    
    public Money balance()
   {
       return balance;
    }
   
   public long getId()
   {
       return id;
    }
    
   public String getName()
   {
       return name;
    }
    
   public void deposit(Money m)
   {
     balance = balance.add(m);
   }
   
   public void withdraw(Money m)
   {
       balance = balance.subtract(m);
    }
   
   public void transferTo(Account bank, Money m)
   {
     this.withdraw(m);
     bank.deposit(m);
   }

   public boolean equals (Account a)
   {
       return (this.name.equals(a.name) && this.id == (a.id) &&  this.balance.equals(a.balance));
    }
     
   public String toString()
   {
     return name + " " + id + " " + balance;
       
   }
   
   @Override
   public int compareTo(Object o)
   {
    //      if(o instanceof Account)
    //         {
    //             Account s = (Account) o;
    //             return this.id.compareTo(s.id);
    //         }
    if(o instanceof Account)
    {
      Account s = (Account) o;
      if(this.getId() == s.getId()){
          return 0;
        }else if(this.getId() < s.getId()){
            return -1;
        } else{
            return 1;
        }
    }
    //if something goes wrong
    return 2;
  }
}
