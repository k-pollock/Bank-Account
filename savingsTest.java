import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class savingsTest.
 *
 * Jennefer Maldonado
 * Kayla Pollock
 * 4 April 2017
 */
public class savingsTest
{
    /**
     * Default constructor for test class savingsTest
     */
    public savingsTest()
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
    public void testAddInterest()
    {
      Money m = new Money (9,0);
      Savings s = new Savings("Jenn", 32, 900, 0.02);
      s.addInterest();
      Money expectedm = new Money(9,18);
      Account expected = new Account("Jenn", 32, 918);
      
      Money m1 = new Money(54,06);
      Savings s1 = new Savings("Kayla", 45, 5406, 0.02);
      s1.addInterest();
      Money expectedm1 = new Money(55, 14);
      Account expected1 = new Account("Kayla", 45,5514);
      assertTrue("Error in testAddInterest", s.equals(expected));
      assertTrue("Error in testAddInterest", s1.equals(expected1));
    }
}
