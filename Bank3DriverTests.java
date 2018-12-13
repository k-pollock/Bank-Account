/**
 * Jennefer Maldonado
 * Kayla Pollock
 * 
 * This class is just used to make sure everything in Bank3
 * is working properly using println instead of junit
 * testing.
 */
public class Bank3DriverTests{
    public static void main (String[]args){
        Bank3 bank = new Bank3("Bank");
        Account acc = new Account ("Jenn", 20, 400);
        bank.addAccount(acc);
        Account acc1 = new Account("Kayla", 32, 400);
        bank.addAccount(acc1);
        Account acc2 = new Account("Leo", 50, 400);
        bank.addAccount(acc2);
        Account acc3 = new Account ("Joe", 20, 400);
        bank.addAccount(acc3);
        Account acc4 = new Account ("Paul", 75, 400);
        bank.addAccount(acc4);
        Account acc5 = new Account("Matt", 24, 500);
        bank.addAccount(acc5);
        
        System.out.println("Before Removing:");
        System.out.println(bank.toString());
        
        bank.removeAccount(32);
        System.out.println("After removing:");
        System.out.println(bank.toString());
        
        System.out.println("Sorting Accounts:");
        bank.sortAccounts();
        System.out.println(bank.toString());
        
        System.out.println("Search:");
        System.out.println(bank.search(50) + "\n");
        
        System.out.println("Deposit:");
        Money m = new Money(20, 05);
        bank.deposit(75, m);
        System.out.println(bank.search(75) + "\n");
        
        System.out.println("Withdraw:");
        Money m1 = new Money(2,0);
        bank.withdraw(24, m1);
        System.out.println(bank.search(24) + "\n");
        }
}