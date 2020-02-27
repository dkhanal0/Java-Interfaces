package interfaces;

import javax.crypto.spec.PSource;
import java.util.ArrayList;

public class Order {

    // Bring in code from previous "associations" assignment
    //private String AccountNum;
    private String customerName;
    private String[] orderItem;
    private double price;
    private Account a;
    // Add instance variable for order number (String)
    private String orderNumber;

    public ArrayList<OrderItem> items;

    //  A constructor that initializes the account number and an empty collection of items
    public Order(String  orderNumber, Account a1) {
        //this.AccountNum = AccountNum;
        this.orderNumber= orderNumber;
        this.a = a1;

        this.items = new ArrayList<OrderItem>();
    }

    // getAccount() - Returns a reference to the Account object associated with this order
    public Account getAccount() {
        return a;
    }

    // addItem(OrderItem item) - Adds an order item (above) to this order
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // getItems() - Returns an array of OrderItem object references listing all purchases
    public OrderItem[] getItems() {
        OrderItem[] itemArray = new OrderItem[items.size()];
        itemArray = items.toArray(itemArray);

        return itemArray;
    }


    // getTotal() - Returns the price of all items purchased
    public double getTotal() {
        double sum = 0;
        for (OrderItem i : items) {
            sum += i.getPrice();
        }
        return sum;

    }


    // Add method to get orderNumber
    public String getOrderNumber(){
            return orderNumber;
    }

}