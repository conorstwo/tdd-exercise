/**
 * Class to hold the main method for conveniently running the application
 */
public class Application {

    public static void main(String[] args) {
        final ShoppingCart shoppingCart = new ShoppingCart();
        //Add any items you want here e.g. shoppingCart.addItem(Item.APPLE);
        shoppingCart.addItem(Item.APPLE);
        shoppingCart.addItem(Item.APPLE);
        shoppingCart.addItem(Item.ORANGE);
        shoppingCart.addItem(Item.APPLE);

        System.out.println("The items in your basket are: " +shoppingCart.getItems());
        System.out.println("The total cost of your items is: " + shoppingCart.calculateTotalCost() + "p");
    }
}
