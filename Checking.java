/**
 * Jennefer Maldonado
 * Kayla Pollock
 */
public class Checking extends Account
{
 private Money overdraftMaximum;
 private String name;
 private long id;
 private double balance;
 
 public Checking (String name, long id, double balance, Money max)
 {
    super(name, id, balance);
    overdraftMaximum = max;
 }
  
 @Override
 public void withdraw(Money m){
  if( (m.compareTo(this.balance().add(overdraftMaximum)) == 0))
   {
     super.withdraw(m);
   }
   else if ((m.compareTo(this.balance().add(overdraftMaximum)) == 1))
   {
     //does not perform withdrawal because greater than.
     throw new InsufficientFundsException("Error in withdraw," 
         + "overdraft amount too large.");
   }
       
  else 
  {
   super.withdraw(m);
   }
     }
    }
