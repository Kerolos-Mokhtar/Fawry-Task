public class ShippingService {
    public void shipItems(List<ShippableItem> items){
        System.out.println("Shipping items:");
        for (ShippableItem item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
}