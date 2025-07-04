
import java.time.LocalDate;
public class Products {
    private String productName;
    private double price;
    private int quantity;

    private boolean expired;
    private LocalDate expirationDate;

    private boolean shippable;
    private double weight;

    public Products(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Products(String productName, double price, int quantity, boolean expired, LocalDate expirationDate) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
        this.expirationDate = expirationDate;
    }

    public Products(String productName, double price, int quantity, boolean expired, LocalDate expirationDate, boolean shippable, double weight) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
        this.expirationDate = expirationDate;
        this.shippable = shippable;
        this.weight = weight;

    }

    public Products(String productName, double price, int quantity, boolean shippable, double weight) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isShippable() {
        return shippable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
