package interfaces;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

    private ArrayList<Order> orders = new ArrayList<Order>();  // ArrayList of all Orders
    private Customer dummyCustomer = new Customer("Evans", "Brian", "123 W Brdige St", "13126");
    private Account dummyAccount = new NonCommercialAccount("123-45-678", dummyCustomer);
    private Order currentOrder; // Reference to the current Order being processed
    private OrderItem currentOrderItem; // Reference to the current OrderItem being processed
    private Product currentProduct;  // Reference to the current Product


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element:" + qName);

            // Handle the order element
            // Instantiate the currentOrder with dummeyAccount

            // Handle orderItem element
            // Get quantity attribute
            // Instantiate the currentOrderItem

            // Handle product element
            // Get product attributes
            // Instantiate the current Product based on taxable attribute
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element:" + qName);

            // Handle order element
            // Add currentOrder to list of orders

            // Handle orderItem element
            // Associate currentOrderItem with currentOrder

            // Handle product element
            // Associate currentProduct with currentOrderItem
    }

    // Return a reference to array list
    public ArrayList<Order> getOrders() {
        return orders;
    }
}


