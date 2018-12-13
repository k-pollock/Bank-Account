/** 
 * A blueprint for Money objects...
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money
{
    // attributes = state variables
    private double totalCents;

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given dollars and cents.
     *
     * @param theDollars the number of dollars
     * @param theCents   the number of cents
     */
    public Money(int theDollars, int theCents)
    {
        this.totalCents = theDollars * 100L + theCents;
    }

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given total cents.
     *
     * @param theCents  the total number of cents
     */
    public Money(double theCents)
    {
        this.totalCents = theCents;
    }
    
    /**
     * getDollars:
     *
     * @return the number of dollars
     */
    public int getDollars()
    {
        return (int) this.totalCents / 100;
    }
    
    /**
     * getCents:
     *
     * @return the number of cents (between 0 and 99, inclusive)
     */
    public int getCents()
    { 
        return (int) this.totalCents % 100;
    }
 
    /**
     * add: adds two money values
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is added to the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     * 
     * @param a Money, the Money amount to add to the calling object (this)
     * @return Money, the sum
     */
    public Money add (Money theMoney)
    {
        return new Money (this.totalCents + theMoney.totalCents);
    }
      
    //     /**
    //      * multiply: multiplies money and a int/double types
    //      */
    //     public Money multiply (double i)
    //     {
    //         double totaldcents = (double)this.totalCents;
    //         Money m = new Money((long)(totaldcents * (i/100)));
    //         return m;
    //     }
    
    /**
     * toString: return String representation of this Money object
     * Precondition: this Money object is valid
     *
     * @return a String representation of this object
     */
    public String toString()
    {
        String result = "$" + this.getDollars() + "."; 
        
        if (this.getCents() < 10) {
            result += "0";
        }
        
        result += this.getCents();
        return result;
    }
    
    /**
     * equals: compare the status of two money objects.
     * 
     * @param other  a Money object
     * @return true if calling object (this) is in the same state as the Money object received as a parameter, and false otherwise.
     */
    public boolean equals (Money other)
    {
        return (this.totalCents == other.totalCents);    
    }
    
     /**
     * subtract: subtracts two money values
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is added to the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     * 
     * @param theMoney, the Money amount to subtract fro, the calling object (this)
     * @return Money, the difference
     */
    public Money subtract (Money theMoney)
    {
        return new Money (this.totalCents - theMoney.totalCents);
    }

    
    /**
     * Option 1:
     * Create blank money object (0.00) and somehow do .equals
     * and then greater than or less than??
     * 
     * Option 2:
     * See if we can make the .subtract answer into an int using 
     * toInteger or toString and come > < 0
     */
    public int compareTo(Money other)
    {
        int answer = 0;
        if (this.totalCents == other.totalCents)
        {
            answer = 0;
        }
        if (this.totalCents > other.totalCents)
        {
            answer = 1;
        }
        if (this.totalCents < other.totalCents)
        {
            answer = -1;
        }
        
        return answer;
    }
}
