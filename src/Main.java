//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. View Details");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            if (choice == 6) {
                System.out.println("Thank you, have a nice day!");
                break;
            }

            switch (choice) {
                case 1:
                    Account a = new Account();
                    a.createAccount();
                    accounts.add(a);
                    break;

                case 2:
                    System.out.print("Enter withdraw account number: ");
                    int withdrawAcc = Integer.parseInt(sc.nextLine());
                    boolean foundWithdraw = false;

                    for (Account acc : accounts) {
                        if (acc.getAccountNumber() == withdrawAcc) {
                            try {
                                acc.withdraw();
                            } catch (InsufficientBalanceException | InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                            foundWithdraw = true;
                            break;
                        }
                    }
                    if (!foundWithdraw) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter deposit account number: ");
                    int depositAcc = Integer.parseInt(sc.nextLine());
                    boolean foundDeposit = false;

                    for (Account acc : accounts) {
                        if (acc.getAccountNumber() == depositAcc) {
                            try {
                                acc.deposit();
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                            foundDeposit = true;
                            break;
                        }
                    }
                    if (!foundDeposit) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number to view details: ");
                    int viewAcc = Integer.parseInt(sc.nextLine());
                    boolean foundView = false;

                    for (Account acc : accounts) {
                        if (acc.getAccountNumber() == viewAcc) {
                            try {
                                acc.viewDetails();
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                            foundView = true;
                            break;
                        }
                    }
                    if (!foundView) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts to display.");
                    } else {
                        for (Account acc : accounts) {
                            try {
                                acc.viewDetails();
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("----------------------");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}