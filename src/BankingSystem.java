import java.util.*;

public class BankingSystem {
    // Task 1 & 2: LinkedList for account storage
    static LinkedList<BankAccount> accounts = new LinkedList<>();

    // Task 3: Stack for Transaction History (LIFO)
    static Stack<String> transactionHistory = new Stack<>();

    // Task 4: Queue for Bill Payments (FIFO)
    static Queue<String> billQueue = new LinkedList<>();

    // Task 5: Queue for Account Opening Requests
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Task 6: Physical Data Structure (Array)
        BankAccount[] initialAccounts = new BankAccount[3];
        initialAccounts[0] = new BankAccount("101", "Ali", 150000);
        initialAccounts[1] = new BankAccount("102", "Sara", 220000);
        initialAccounts[2] = new BankAccount("103", "John", 50000);
        Collections.addAll(accounts, initialAccounts);

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1 – Enter Bank\n2 – Enter ATM\n3 – Admin Area\n4 – Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // --- PART 3: INTEGRATED MENUS ---

    static void bankMenu() {
        System.out.println("\n1. Submit Account Request\n2. Deposit\n3. Withdraw\n4. Back");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Initial Deposit: ");
            double amt = sc.nextDouble();
            String accNum = "ACC" + (accounts.size() + accountRequests.size() + 1);
            accountRequests.add(new BankAccount(accNum, name, amt));
            System.out.println("Request submitted to Admin queue.");
        } else if (choice == 2 || choice == 3) {
            handleTransaction(choice == 2 ? "Deposit" : "Withdraw");
        }
    }

    static void atmMenu() {
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        BankAccount acc = findAccount(name);

        if (acc != null) {
            System.out.println("1. Balance Enquiry\n2. Withdraw");
            int choice = sc.nextInt();
            if (choice == 1) System.out.println("Balance: " + acc.balance);
            else if (choice == 2) {
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                if (acc.balance >= amt) {
                    acc.balance -= amt;
                    transactionHistory.push("Withdraw " + amt + " from " + name);
                    System.out.println("New balance: " + acc.balance);
                } else System.out.println("Insufficient funds.");
            }
        } else System.out.println("Account not found.");
    }

    static void adminMenu() {
        System.out.println("\n1. Process Account Request\n2. View/Process Bills\n3. Undo Transaction\n4. Back");
        int choice = sc.nextInt();

        if (choice == 1) {
            if (!accountRequests.isEmpty()) {
                BankAccount newAcc = accountRequests.poll();
                accounts.add(newAcc);
                System.out.println("Processed: " + newAcc.username + " is now a member.");
            } else System.out.println("No pending requests.");
        } else if (choice == 2) {
            System.out.println("Bills in queue: " + billQueue);
            if (!billQueue.isEmpty()) System.out.println("Processing: " + billQueue.poll());
        } else if (choice == 3) {
            if (!transactionHistory.isEmpty()) {
                System.out.println("Undo -> " + transactionHistory.pop() + " removed.");
            } else System.out.println("No history.");
        }
    }

    // Helper method for Task 1 & 2 logic
    static BankAccount findAccount(String name) {
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) return acc;
        }
        return null;
    }

    static void handleTransaction(String type) {
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        BankAccount acc = findAccount(name);
        if (acc != null) {
            System.out.print(type + " amount: ");
            double amt = sc.nextDouble();
            if (type.equals("Deposit")) acc.balance += amt;
            else acc.balance -= amt;
            transactionHistory.push(type + " " + amt + " for " + name);
            System.out.println("Done. New balance: " + acc.balance);
        }
    }
}
