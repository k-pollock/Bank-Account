/**
 * Jennefer Maldonado & Kayla Pollock
 * 
 * 16 February 2017
 */
import java.util.Scanner;
public class Bank implements BankInterface
{
   private String nameOfBank;
   private Account[] account;
   private int numOfAccounts;
    public Bank(String s)
    {
        nameOfBank = s;
        account = new Account[10];
        numOfAccounts = 0;
    }
    
    public void addAccount(Account a)
    {
        account[numOfAccounts] = a;  
        numOfAccounts++;
    }
    
    public Account search (long s)
    {
        int bin = binarySearch(account, 0, numOfAccounts-1, s);
        if( bin == -1)
        {
        }
        else
        {
          return account[bin];  
        }
       return null;
    }
    
     public static int binarySearch(Account [] anArray, int first, int last, long value) {
        // Searches the array items anArray[first] through
        // anArray[last] for value by using a binary search.
        // Precondition: 0 <= first, last <= SIZE-1, where
        // SIZE is the maximum size of the array, and
        // anArray[first] <= anArray[first+1] <= ... <= anArray[last].
        // Postcondition: If value is in the array, the method
        // returns the index of the array item that equals value;
        // otherwise the method returns -1.
          int index;
          if (first > last) {
            index = -1;      // value not in original array
          } 
          else {
                // Invariant: If value is in anArray, 
                // anArray[first] <= value <= anArray[last]        
                int mid = (first + last)/2;
            if (value == anArray[mid].getId()) {
              index = mid;  // value found at anArray[mid]
            } 
            else if ((value < (anArray[mid].getId()))) {
              index = binarySearch(anArray, first, mid-1, value);   // point X
            } 
            else {
              index = binarySearch(anArray, mid+1, last, value);    // point Y
           }  // end if
        }  // end if
    
       return index;
    }  // end binarySearch
    
    public void deposit(long s, Money m)
    {
      Account acc =(this.search(s));
      if( acc != null)
      {
        acc.deposit(m);
      }
    }
    
    //boolean
    public void withdraw(long s, Money m)
    {
        Account acc = (this.search(s));
        if(acc != null)
        {
        acc.withdraw(m);
       }
    }
    
    public String toString()
    {
        String value = "";
        for (int i = 0; i <= numOfAccounts-1; i++)
        {
            value += " " + account[i].toString();
        }
        return value;
    }
    
    public void sortAccounts()
    {
      SortsClass s = new SortsClass();
      SortsClass.selectionSort(account, numOfAccounts); 
    }
    
    public void removeAccount(long s){
    }
    
    public boolean insertNoDuplicates(Account a){
        return true;
    }
    
    public int size(){
        return numOfAccounts;
    }
}

