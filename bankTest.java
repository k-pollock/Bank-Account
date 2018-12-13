import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class bankTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class bankTest
{
    /**
     * Default constructor for test class bankTest
     */
    public bankTest()
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
    public void testAddAccount()
    {
      Bank bank = new Bank("ADT");
      Money money = new Money(4,0);
      Account acc = new Account ("Jenn", 20, 400);
      bank.addAccount(acc);
      
      Account acc1 = new Account("Kayla", 32, 400);
      bank.addAccount(acc1);
      
      Account acc2 = new Account("Leo", 50, 400);
      bank.addAccount(acc2);
      
      assertTrue("Error in testAddAccount",acc.equals(bank.search(20)));
      assertTrue("Error in testAddAccount",acc1.equals(bank.search(32)));
      assertTrue("Error in testAddAccount", acc2.equals(bank.search(50)));
    }
    
    @Test
    public void testSearch()
    {
      //class object
      Bank bank = new Bank("ADT");
      //money objects for accounts
      Money money = new Money(4,0);
      Money money2 = new Money(5,0);
      Money money3 = new Money(9,0);
      //account objects for search
      Account acc = new Account("Jenn", 17, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 66, 900);
      bank.addAccount(acc);
      bank.addAccount(acc1);
      bank.addAccount(acc2);
      // true tests to make sure searching properly
      //assertTrue("Error in testSearch", (bank.search("17").equals(acc2)));
      //true test to make sure searching properly
      assertTrue("Error in testSearch", (bank.search(17).equals(acc)));
      assertTrue("Error in testSearch", (bank.search(66).equals(acc2)));
      assertFalse("Error in testSearch",(bank.search(17).equals(acc1)));
    }
    
    @Test
    public void testDeposit()
    {
      Bank bank = new Bank("ADT");
      //money objects for accounts
      Money money = new Money(4,0);
      Money money2 = new Money(5,0);
      Money money3 = new Money(9,0);
      //account objects for search
      Account acc = new Account("Jenn", 32, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 67, 900);
      bank.addAccount(acc);
      bank.addAccount(acc1);
      bank.addAccount(acc2);
      
      Money toAdd = new Money(4,0);
      bank.deposit(53, toAdd);
      //Money expected = new Money(9,0);
      String expected = " Jenn 32 $4.00 Kayla 53 $9.00 Tom 67 $9.00";
      String actual = bank.toString();
      
      bank.deposit(23, toAdd);
      String actual1 = bank.toString();
      
      assertTrue("Error in testDeposit", expected.equals(actual));
      assertTrue("Error in testDeposit", expected.equals(actual1)); 
    }
    
    @Test
    public void testWithdraw()
    {
     Bank bank = new Bank("ADT");
      //money objects for accounts
      Money money = new Money(4,0);
      Money money2 = new Money(5,0);
      Money money3 = new Money(9,0);
      //account objects for search
      Account acc = new Account("Jenn", 42, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 77, 900);
      bank.addAccount(acc);
      bank.addAccount(acc1);
      bank.addAccount(acc2);
      
      Money toSub = new Money(4,0);
      bank.withdraw(53, toSub);
      //Money expected = new Money(9,0);
      String expected = " Jenn 42 $4.00 Kayla 53 $1.00 Tom 77 $9.00";
      String actual = bank.toString();
      
      bank.withdraw(23, toSub);
      String actual1 = bank.toString();
      
      assertTrue("Error in testWithdraw", expected.equals(actual));
      assertTrue("Error in testWithdraw", expected.equals(actual1));
    }
    
    @Test
    public void testToString()
    {
      Bank bank = new Bank("ADT");
      //money objects for accounts
      Money money = new Money(4,0);
      Money money2 = new Money(5,0);
      Money money3 = new Money(9,0);
      //account objects for search
      Account acc = new Account("Jenn", 42, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 77, 900);
      bank.addAccount(acc);
      bank.addAccount(acc1);
      bank.addAccount(acc2);
      
      //System.out.println(bank.toString());
      String expected = " Jenn 42 $4.00 Kayla 53 $5.00 Tom 77 $9.00";
      
      //assertTrue(acc1.equals(bank.search("53")));
      //System.out.println(bank.toString());
      assertTrue("Error in testToString", expected.equals(bank.toString()));
    }
    
    @Test
    public void testSortAccounts()
    {
      Bank b = new Bank("ADT");
      //money objects for accounts
      Money money = new Money(4,0);
      Money money2 = new Money(5,0);
      Money money3 = new Money(9,0);
      //account objects for search
      Account acc = new Account("Jenn", 72, 400);
      Account acc1 = new Account("Kayla", 53, 500);
      Account acc2 = new Account("Tom", 77, 900);
      b.addAccount(acc);
      b.addAccount(acc1);
      b.addAccount(acc2);
      
      
      b.sortAccounts();
      String expected = " Kayla 53 $5.00 Jenn 72 $4.00 Tom 77 $9.00";
      System.out.println(b);
      System.out.println(expected);
      assertTrue("Error in testSortAcc", expected.equals(b.toString()));
    }
}
