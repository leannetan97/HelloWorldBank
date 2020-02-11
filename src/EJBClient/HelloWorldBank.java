/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBClient;

/**
 *
 * @author Leanne
 */
import AccountStatefulBean.Account;
import java.io.IOException;
import java.util.Scanner;
import javax.ejb.EJB;

public class HelloWorldBank {

    /**
     * @param args the command line arguments
     */
    @EJB
    private static Account account;

    public static void main(String[] args) {
        System.out.println("Welcome to Hello World Bank:");
        while (true) {
            double amount = 0;
            System.out.println("1. Deposit\n2. Withdraw\n3. View Balance\n4. Exit");
            System.out.println("Choose Option (1 - 4):");
            try {
                Scanner in = new Scanner(System.in);
                int option = in.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Please enter deposit amount:");
                        while ((amount = in.nextDouble()) == 0) {
                            System.out.println("Deposit amount cannot be 0. Please enter the deposit amount.");
                        }
                        System.out.println(account.deposit(amount));
                        break;
                    case 2:
                        System.out.println("Please enter withdrawal amount:\n(Note: 1% of addition service charge will be charged if the withdrawal amount more than or equal to RM1000)");
                        while ((amount = in.nextDouble()) == 0) {
                            System.out.println("Withdrawal amount cannot be 0. Please enter the withdrawal amount.");
                        }
                        System.out.println(account.withdraw(amount));
                        break;
                    case 3:
                        System.out.println("Account Balance: " + account.getBalance() + "\n");
                        break;
                    case 4:
                        System.out.println("Thank you for choosing Hello World Bank. Have a nice day! Thank you. :)");
                        break;
                    default:
                        System.out.println("Sorry, Invalid option. Please choose again.");
                        break;
                }
                if (option == 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Opps, Invalid input, Please choose again.");
            }
        }
    }
}
