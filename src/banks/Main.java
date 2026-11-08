
package banks;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int accountNumber;
    private final String accountHolder;
    private final String phoneNumber;
    private final String address;
    private final String password;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder,
            String phoneNumber, String address,
            double balance, String password) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPassword(String p) {
        return password.equals(p);
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0
                || !Double.isFinite(balance + amount)) {
            System.out.println("Invalid Amount!");
            return false;
        }

        balance += amount;
        System.out.println("Amount Deposited Successfully!");
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid Amount!");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return false;
        }

        balance -= amount;
        System.out.println("Amount Withdrawn Successfully!");
        return true;
    }

    public void displayDetails() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static final String DATA_FILE = "bank_accounts.dat";

    // SAVE DATA
    public static boolean saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {

            out.writeObject(accounts);
            return true;

        } catch (IOException e) {
            System.out.println("Save Error: " + e.getMessage());
            return false;
        }
    }

    // LOAD DATA
    @SuppressWarnings("unchecked")
    public static boolean loadAccounts() {

        File file = new File(DATA_FILE);

        if (!file.exists()) {
            return false;
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))) {

            Object data = in.readObject();

            if (!(data instanceof ArrayList<?>)) {
                return false;
            }

            ArrayList<?> list = (ArrayList<?>) data;
            ArrayList<BankAccount> loaded = new ArrayList<>();

            for (Object obj : list) {
                if (!(obj instanceof BankAccount)) {
                    return false;
                }
                loaded.add((BankAccount) obj);
            }

            accounts.clear();
            accounts.addAll(loaded);
            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load Error: " + e.getMessage());
            return false;
        }
    }

    // SAMPLE ACCOUNTS
    public static void addSampleAccounts() {

        accounts.clear();

        accounts.add(new BankAccount(1001, "Munwar",
                "03000000001", "Badin, Sindh", 25000, "Munwar123"));

        accounts.add(new BankAccount(1002, "Saqib",
                "03000000002", "Badin, Sindh", 30000, "Saqib456"));

        accounts.add(new BankAccount(1003, "Bhanwarlal",
                "03000000003", "Badin, Sindh", 45000, "Bhanwar789"));

        accounts.add(new BankAccount(1004, "Ali",
                "03000000004", "Badin, Sindh", 20000, "Ali101"));

        accounts.add(new BankAccount(1005, "Mussa",
                "03000000005", "Badin, Sindh", 35000, "Mussa202"));

        accounts.add(new BankAccount(1006, "Awais",
                "03000000006", "Badin, Sindh", 50000, "Awais303"));

        accounts.add(new BankAccount(1007, "Mudasir",
                "03000000007", "Badin, Sindh", 15000, "Mudasir404"));

        accounts.add(new BankAccount(1008, "Ahmed",
                "03000000008", "Badin, Sindh", 40000, "Ahmed505"));

        accounts.add(new BankAccount(1009, "Usman",
                "03000000009", "Badin, Sindh", 55000, "Usman606"));

        accounts.add(new BankAccount(1010, "Bilal",
                "03000000010", "Badin, Sindh", 10000, "Bilal707"));

        saveAccounts();
    }

    // INTEGER INPUT
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter Valid Number!");
            }
        }
    }

    // AMOUNT INPUT
    public static double readAmount(String message) {
        while (true) {
            System.out.print(message);
            try {
                double amount = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(amount)) {
                    return amount;
                }

            } catch (NumberFormatException e) {
                // Invalid input handled below.
            }

            System.out.println("Enter Valid Amount!");
        }
    }

    // FIND ACCOUNT
    public static BankAccount findAccount(int number) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == number) {
                return account;
            }
        }
        return null;
    }

    // CREATE ACCOUNT
    public static void addNewAccount() {

        System.out.println("\n===== CREATE NEW ACCOUNT =====");

        int number = readInt("Enter Account Number: ");

        if (number <= 0 || findAccount(number) != null) {
            System.out.println("Invalid or Existing Account Number!");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine().trim();

        System.out.print("Enter Address: ");
        String address = sc.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            System.out.println("Please Fill All Details!");
            return;
        }

        double amount = readAmount("Enter Opening Amount: ");

        if (amount < 0) {
            System.out.println("Negative Amount Not Allowed!");
            return;
        }

        System.out.print("Create Password: ");
        String password = sc.nextLine();

        if (password.trim().isEmpty()) {
            System.out.println("Password Cannot Be Empty!");
            return;
        }

        BankAccount account = new BankAccount(
                number, name, phone, address, amount, password);

        accounts.add(account);

        if (saveAccounts()) {
            System.out.println("Account Created Successfully!");
            account.displayDetails();
        } else {
            accounts.remove(account);
            System.out.println("Account Saving Failed!");
        }
    }

    // SEARCH ACCOUNT
    public static void showAccountDetails() {

        int number = readInt("Enter Account Number: ");
        BankAccount account = findAccount(number);

        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account Not Found!");
        }
    }

    // DISPLAY ALL
    public static void displayAllAccounts() {

        System.out.println("\n===== ALL BANK ACCOUNTS =====");

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available!");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayDetails();
        }

        System.out.println("\nTotal Accounts: " + accounts.size());
    }

    // CUSTOMER MENU
    public static void accountMenu(BankAccount account) {

        while (true) {

            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Logout");

            int choice = readInt("Enter Choice: ");

            switch (choice) {

                case 1: {
                    double amount = readAmount("Deposit Amount: ");

                    if (account.deposit(amount)) {
                        if (!saveAccounts()) {
                            System.out.println("Warning: Save Failed!");
                        }
                    }
                    break;
                }

                case 2: {
                    double amount = readAmount("Withdraw Amount: ");

                    if (account.withdraw(amount)) {
                        if (!saveAccounts()) {
                            System.out.println("Warning: Save Failed!");
                        }
                    }
                    break;
                }

                case 3:
                    System.out.println("Balance: Rs. "
                            + account.getBalance());
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Logout Successful!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // LOGIN
    public static void login() {

        System.out.println("\n===== CUSTOMER LOGIN =====");

        int number = readInt("Enter Account Number: ");

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        BankAccount account = findAccount(number);

        if (account != null && account.checkPassword(password)) {

            System.out.println("Login Successful!");
            System.out.println("Welcome "
                    + account.getAccountHolder());

            accountMenu(account);

        } else {
            System.out.println("Invalid Account Number or Password!");
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("Loading Banking System...");

        if (!loadAccounts()) {
            addSampleAccounts();
            System.out.println("10 Sample Accounts Created!");
        } else {
            System.out.println("Saved Accounts Loaded Successfully!");
        }

        while (true) {

            System.out.println("\n================================");
            System.out.println("    BANKING MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Customer Login");
            System.out.println("2. Create New Account");
            System.out.println("3. Search Account Details");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");

            int choice = readInt("Enter Your Choice: ");

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    addNewAccount();
                    break;

                case 3:
                    showAccountDetails();
                    break;

                case 4:
                    displayAllAccounts();
                    break;

                case 5:
                    saveAccounts();
                    System.out.println("Thank You For Using Our Bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
