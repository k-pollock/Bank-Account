/**
 * Savings is a subclass of the Account class
 * 
 * Jennefer Maldonado
 * Kayla Pollock
 * 4 April 2017
 */
public class Savings extends Account
{
    private double interestRate;
    public Savings(String n, long i, double b, double interest)
    {
       super(n, i, b);
       interestRate = interest;
    }
    
    public void addInterest()
    {
        Money m = this.balance();
        int balanceD = m.getDollars();
        int balanceC = m.getCents();
        
        double interestD = interestRate * balanceD;
        double interestC = interestRate * balanceC;
        if (interestD < 1)
        {
          int tempD = (int)(interestD * 100);
          int tempC = (int)(interestC * 100);
          int finalCents = tempD + tempC;
          Money toAdd = new Money(0, finalCents);  
          this.deposit(toAdd);
        }
        else if(interestD >= 1)
        {
          int tempD = (int)interestD;
          int tempC = (int)((interestD - tempD)* 100);
          Money toAdd = new Money(tempD, tempC);
          this.deposit(toAdd);
        }
        else
        {
          // do nothing
        }
    }
}
