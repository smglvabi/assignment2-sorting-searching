public class BankAccount {
    String accountNumber;
    String username;
    double balance;

    // Task 1: Constructor to initialize account data
    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    // Task 1: Overriding toString to display the account in the required format
    @Override
    public String toString() {
        return username + " – Balance: " + (int)balance;
    }
}