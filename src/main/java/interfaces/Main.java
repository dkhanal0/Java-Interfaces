/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package interfaces;

public class Main {

    public static void main(String[] args) {

        XmlReader myXmlReader = new XmlReader("orders-2.xml");

        for (Order o: myXmlReader.getOrders()) {
           System.out.println("Order number: " + o.getOrderNumber() + ", total: " + o.getTotal()); // When ready, use this for testing

        }

    }
}
