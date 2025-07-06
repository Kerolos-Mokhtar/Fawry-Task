public class Customer {
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deductBalance(double amount){
        if (amount > this.balance) {
            System.out.println("Insufficient balance to deduct " + amount);
            return;
        }else{
        this.balance -= amount;}
    }
}
