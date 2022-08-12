/* Banking application*/

import java.util.Scanner;
public class BankingApplication{
   public static void main (String[] args){
      BankAccount obj1 = new BankAccount("XYZ", "BA0001");
      obj1.showMenu();
   }
}

class BankAccount{
   double balance, previousTransaction;
   String customerName, customerId;
   
   BankAccount(String cName, String cId){
      customerName = cName;
      customerId = cId;
   }
   
   void deposit (double amount){
      if (amount > 0){
         balance += amount;
         previousTransaction = amount;
      }
   }
   
   void withdraw (double amount){
      if (amount < this.balance) {
	this.balance -= amount;
	this.previousTransaction = -amount;
      }
      else {
         System.out.println("Funds insufficient, please try another amount.");
	 this.balance += 0;
      }
   }
   
   void getPreviousTransaction (){
      if (previousTransaction > 0){
         System.out.println("Deposited amount: $" + previousTransaction);
      }
      else if (previousTransaction < 0){
         System.out.println("Amount withdrawn: $" + Math.abs(previousTransaction));
      }
      else{
         System.out.println("No transaction occured.");
      }
   }
   
   void showMenu(){
      char option = '\0';
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Welcome " + customerName);
      System.out.println("Your ID is " + customerId);
      System.out.println("\n");
      System.out.println("A. Check Balance");
      System.out.println("B. Deposit");
      System.out.println("C. Wtihdraw");
      System.out.println("D. Previous Transaction");
      System.out.println("E. Exit");
      
      do{
         System.out.println("=============================================================================================================");
         System.out.println("Enter an option");
         System.out.println("=============================================================================================================");
         option = scan.next().toUpperCase().charAt(0);
         System.out.println("\n");
         
         switch(option){
            
            case 'A':
               System.out.println("------------------------------------------");
               System.out.println("Balance = $" + balance);
               System.out.println("------------------------------------------");
               System.out.println("\n");
               break;
            
            case 'B':
               System.out.println("------------------------------------------");
               System.out.println("Enter an amount to deposit: ");
               System.out.println("------------------------------------------");
               double amount = scan.nextInt();
               deposit(amount);
               System.out.println("Balance = $" + balance);
               System.out.println("\n");
               break;
            
            case 'C':
               System.out.println("------------------------------------------");
               System.out.println("Enter an amount to withdraw: ");
               System.out.println("------------------------------------------");
               double amount2 = scan.nextInt();
               withdraw(amount2);
               System.out.println("Balance = $" + balance);
               System.out.println("\n");
               break;
            
            case 'D':
               System.out.println("------------------------------------------");
               getPreviousTransaction();
               System.out.println("Balance = $" + balance);
               System.out.println("------------------------------------------");
               System.out.println("\n");
               break;
            case 'E':
               System.out.println("*******************************************");
               break;
           
            default:
               System.out.println("Invalid option please enter again!!");
               break;
            }
         }
         while (option != 'E');
         System.out.println("Thank you for using our services.");  
   }
}
