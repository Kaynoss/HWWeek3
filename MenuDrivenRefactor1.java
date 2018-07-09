package Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class MenuDrivenRefactor1 {

	static Scanner sc = new Scanner(System.in); 
	static boolean exit;
	static String[] last5Transactions = new String[6];
	static double balance = 1500.00;
	
	public static void main(String[] args) {
	
		last5Transactions[0] = "Mcdonalds 10.00";
		last5Transactions[1] = "TacoBell 5.00";		
		last5Transactions[2] = "Wendys 8.00";
		last5Transactions[3] = "Arbys 12.00";
		last5Transactions[4] = "JackInTheBox 6.00";
		last5Transactions[5] = "";
		
		
		menuStart();
		int choice = sc.nextInt(); 
		doChoice(choice);
		
		
	}
	public static void menuStart() {

		System.out.println("Welcome to the ATM!");
		System.out.println("\n1) Check Balance");
		System.out.println("2) Withdrawl");
		System.out.println("3) Deposit");
		System.out.println("4) Last 5 transactions");
		System.out.println("5) Exit"); 
			
		}
	public static void doChoice(int choice) {
		switch(choice) {
		case 1:
			System.out.println("Your balance is : " + balance);	
			break;
		case 2: 
			doWithdrawl();
			break;
		case 3: 
			System.out.println("How much would you like to deposit?");
			double depositAmount = sc.nextDouble();
			depositMoney(depositAmount); 
		case 4:
			arrayOptions();
			break;
		case 5:
			exit = true;
			System.out.println("Thanks for your transaction!");
			break;
		default: 
			System.out.println("Please make a proper selection!");
			break;
	}
	}
	public static void doWithdrawl() { 
		System.out.println("How much would you like to withdrawl?");
		System.out.println("1) 20.00");
		System.out.println("2) 40.00");
		System.out.println("Enter your Selection."); 
		int selection = sc.nextInt();
		withdrawlStuff(selection);
	}	
	public static void withdrawlStuff(int selection) {
		switch(selection) {
		case 1:
			System.out.println("You received 20.00");
			System.out.println("Your new balance is : " + (balance - 20));
			break;
		case 2:
			System.out.println("You received 40.00");
			System.out.println("Your new balance is : " + (balance - 40));
			break;
		default:
			System.out.println("Please make a proper selection.");
			break;
		}
	}
	public static void depositMoney(double depositAmount) {
		double newBalance = depositAmount + balance;
		System.out.println("\nYour new balance is " + newBalance); 
	}
	public static void arrayOptions() {
	
		System.out.println("Here are your last 5 transactions...");
		for (int i = 0; i < last5Transactions.length; i++) {
			System.out.println(i+1 + ") "+ last5Transactions[i]); }
			
		
		System.out.println("\nWhat would you like to do next?"); 
		System.out.println("\n1) Add a transaction.");
		System.out.println("2) Look at a transaction alone.");
		System.out.println("3) Delete a recent transaction.");
		System.out.println("4) Delete all recent transactions.");
		System.out.println("\nENTER YOUR SELECTION.");
		
		int decision = sc.nextInt();
		changeArray(decision);
		
	}
	public static void changeArray(int decision) {
		switch(decision) {
		case 1: 
			System.out.println("What transaction would you like to add? Type it out.");
			String userTransaction = sc.next();
			last5Transactions[6] = userTransaction;
			for (int i = 0; i < last5Transactions.length; i++) {
			System.out.println(i+1 + ") "+ last5Transactions[i]); }
			break;
		case 2:
			System.out.println("What transaction would you like to view?");
			int pick = sc.nextInt();
			System.out.println(last5Transactions[pick - 1]);
			break;
		case 3:
			System.out.println("Which transaction would you like to delete?");
			int delete = sc.nextInt();
			last5Transactions[delete - 1] = "";
			for (int i = 0; i < last5Transactions.length; i++) {
			System.out.println(i+1 + ") "+ last5Transactions[i]); }
			break;
		case 4:
			Arrays.fill(last5Transactions, "");
			for (int i = 0; i < last5Transactions.length; i++) {
			System.out.println(i+1 + ") "+ last5Transactions[i]); }
			System.out.println("You dirty rat!  You deleted them all!");
			break;
		default:
			System.out.println("Please make a proper selection."); 
			break;
		}
	}
}

		