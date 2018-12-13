import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class accountTest
{
    
    /**
     * Default constructor for test class accountTest
     */
    public accountTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Money money3 = new Money(4,0);
        Account acc = new Account("Jenn", 32, 400);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        Account acc = null;
    }
    
    /**
     * Tests deposit method
     */
    @Test
    public void testDeposit()
    {
       Money money = new Money(2,0);
       Account acc = new Account("Kayla", 320, 200);
       Money expected = new Money (4,00);
       acc.deposit(money);
      assertTrue("Error in testDeposit", acc.balance().equals(expected));
    }
    
    /**
     * Tests withdraw method
     */
    @Test 
    public void testWithdraw()
    {
        Money money = new Money(4,0);
        Money toSub = new Money(2,0);
        Account acc = new Account("Kayla", 320, 400);
        
        Money expected = new Money(2,0);
        acc.withdraw(toSub);
        assertTrue("Error in testWithdraw",acc.balance().equals(expected));
    }
   
    /**
     * Tests transfer method
     */
    @Test
    public void testTransferTo()
    {
        //new account w/ 400
        Money m = new Money(4,0);
        Account acc2 = new Account("Jenn", 3, 400);
        //new account w/ 200
        Money m1 = new Money(2,0);
        Account acc = new Account("Kayla", 4, 200);
        
        //should subtract 2 from acc2 and add 2 to acc
        Money toSub = new Money(2,0);
        acc2.transferTo(acc, toSub);
        
        Money expectedacc2 = new Money(2,0);
        Money expectedacc = new Money(4,0);
        assertTrue("Error in testTransferTo", acc2.balance().equals(expectedacc2));
        assertTrue("Error in testTransferTo", acc.balance().equals(expectedacc));
    }
     
     /**
      * Tests equals method
      */
     @Test
     public void testEquals()
     {
      Money money = new Money(4,0);
      Money money1 = new Money(4,0);
      Account acc1 = new Account("Jenn", 23, 400);
      Account acc2 = new Account("Jenn", 23, 400);
      
      Money money3 = new Money(5,0);
      Money money4 = new Money(6,0);
      Account acc3 = new Account("Jenn", 34, 500);
      Account acc4 = new Account("Kayla", 45, 600);
      
      assertFalse("Error in testEquality", acc3.equals(acc4));
      assertTrue("Error in testEquality", acc1.equals(acc2));  
     }
 }
