import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class checkingTest.
 *
 * Jennefer Maldonado
 * Kayla Pollock
 */
public class checkingTest
{
    /**
     * Default constructor for test class checkingTest
     */
    public checkingTest()
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
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testWithdraw()
    {
      Money m = new Money(100,0);
      Money m1 = new Money(150,0);
      Money max = new Money(50,0);
      Checking acc = new Checking("Jen", 32, 10000, max);
     
      Money w = new Money(100,0);
      Money w1 = new Money(200,0);
      
      Money expected = new Money(-50,0);
      Money expected1 = new Money(100,0);
      Checking acc1 = new Checking("Jen", 32, 10000, max);
      acc1.withdraw(w1);
      acc.withdraw(m1);
      assertTrue("Error in testWithdraw", acc.balance().equals(expected));
      assertTrue("Error in testWithdraw", acc.balance().equals(expected1));
    }
    
    @Test
		public void testOverwithdraw() {
			// Create a checking account.
			Money m = new Money(100,0);
			Money max = new Money(50,0);
            Checking acc = new Checking("Jen", 32, 10000, max);

			try {
				// Withdraw an amount that should cause an exception of type InsufficientFundsException...
				acc.withdraw( new Money(200, 0) );

				// If we reach this point in the code, that means the exception was not thrown as expected, so this test case fails.
				fail(); 
			}
			catch (InsufficientFundsException ife) {
				System.out.println("InsufficientFunds Exception on testOverwithdraw");
				ife.printStackTrace();
			}
			
		}
}
