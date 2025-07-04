public class Customers {
    private double balance;

    public Customers(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance to deduct " + amount);
            return;
        }
        this.balance -= amount;
    } 
}
