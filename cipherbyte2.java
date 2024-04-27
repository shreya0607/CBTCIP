import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankY {
    private Map<String, Account> accounts;

    public BankY() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account already exists!");
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        Account from = accounts.get(fromAccount);
        Account to = accounts.get(toAccount);
        if (from != null && to != null) {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transfer successful!");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("One or both accounts not found!");
        }
    }

    public static void main(String[] args) {
        BankY bank = new BankY();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter account number: ");
                        String accNum = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double initBalance = scanner.nextDouble();
                        bank.createAccount(accNum, initBalance);
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        String accNumDeposit = scanner.next();
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(accNumDeposit, depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter account number: ");
                        String accNumWithdraw = scanner.next();
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        bank.withdraw(accNumWithdraw, withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter from account number: ");
                        String fromAccNum = scanner.next();
                        System.out.print("Enter to account number: ");
                        String toAccNum = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        bank.transfer(fromAccNum, toAccNum, transferAmount);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
    }
}

class Account {
    @SuppressWarnings("unused")
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}