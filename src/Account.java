import java.util.Scanner;

class Account {
    public static int nextAccountNumber = 1;

    public int accountNumber;
    public String name;
    public String email;
    public String mobile;
    public int amount;

    private Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your email: ");
        email = sc.nextLine();
        System.out.print("Enter your mobile number: ");
        mobile = sc.nextLine();
        if (!mobile.matches("[6-9]\\d{9}")) {
            System.out.println("Invalid mobile number");
            return;
        }

        System.out.print("Enter initial deposit amount: ");
        amount = sc.nextInt();
        accountNumber = nextAccountNumber++;

        System.out.println("Account created successfully");
        System.out.println("Your account number is: " + accountNumber);
    }

    public void deposit() throws InvalidAmountException {
        System.out.print("Enter deposit amount: ");
        try {
            int dep = Integer.parseInt(sc.next());
            if (dep <= 0) {
                throw new InvalidAmountException("Invalid Amount Exception");
            }
            amount = amount + dep;
            System.out.println("Amount deposited successfully");
        }catch(NumberFormatException e)
        {
            throw new InvalidAmountException("Enter valid Amount");
        }

    }

    public void withdraw() throws InsufficientBalanceException, InvalidAmountException {
        System.out.print("Enter withdraw amount: ");
        try {
            int withdrawAmount = Integer.parseInt(sc.next());
            if (withdrawAmount > amount) {
                throw new InsufficientBalanceException("Insufficient balance");
            } else if (withdrawAmount <= 0) {
                throw new InvalidAmountException("InvalidAmountException");
            } else {
                amount = amount - withdrawAmount;
                System.out.println("Withdrawal successful");
            }
        }catch(NumberFormatException e)
        {
            throw new InvalidAmountException("Enter valid Amount");
        }
    }

    public void viewDetails() throws InvalidAmountException {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Balance: " + amount);
    }

    public int getAccountNumber()
    {

        return accountNumber;
    }
}


