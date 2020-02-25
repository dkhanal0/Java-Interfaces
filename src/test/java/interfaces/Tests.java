/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderData{
    String orderNumber;
    double total;

    public OrderData(String orderNumber, double total) {
        this.orderNumber = orderNumber;
        this.total = total;
    }
}

class Tests {

    @Test void testOrders1(){
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/interfaces/orders-1.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Order[] orders = null;
        try {
            orders = xr.getOrders();
        } catch (Exception e) {
            System.out.println("Orders array exception");
        }

        assertNotNull(orders, "Could not get Order array");

        OrderData od1 = new OrderData("abc-123", 3.08);
        OrderData[] expected = {od1};
        this.compareOrders(expected, orders);

    }

    @Test void testOrders2(){
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/interfaces/orders-2.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Order[] orders = null;
        try {
            orders = xr.getOrders();
        } catch (Exception e) {
            System.out.println("Orders array exception");
        }

        assertNotNull(orders, "Could not get Order array");

        OrderData od1 = new OrderData("abc-123", 3.08);
        OrderData od2 = new OrderData("abc-234", 21.6);

        OrderData[] expected = {od1, od2};
        this.compareOrders(expected, orders);

    }

    @Test void testOrders2b(){
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/interfaces/orders-2b.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Order[] orders = null;
        try {
            orders = xr.getOrders();
        } catch (Exception e) {
            System.out.println("Orders array exception");
        }

        assertNotNull(orders, "Could not get Order array");

        OrderData od1 = new OrderData("abc-123", 3.08);
        OrderData od2 = new OrderData("abc-234", 20.0);

        OrderData[] expected = {od1, od2};
        this.compareOrders(expected, orders);

    }

    @Test void testOrders4(){
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/interfaces/orders-4.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Order[] orders = null;
        try {
            orders = xr.getOrders();
        } catch (Exception e) {
            System.out.println("Orders array exception");
        }

        assertNotNull(orders, "Could not get Order array");

        OrderData od1 = new OrderData("abc-123", 3.08);
        OrderData od2 = new OrderData("abc-234", 20);
        OrderData od3 = new OrderData("abc-345", 23.76);
        OrderData od4 = new OrderData("abc-456", 2080);

        OrderData[] expected = {od1, od2, od3, od4};
        this.compareOrders(expected, orders);

    }

    private void compareOrders(OrderData[] expected, Order[] actual) {
        // Ensure same length
        //System.out.println("LENGTHS-" + expected.length + ":" + actual.length);
        if (expected.length != actual.length) {
            // Abort -- different lengths
            fail("Result does not contain the expected number of orders");
        }

        // Compare elements
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].orderNumber, actual[i].getOrderNumber());
            assertEquals(expected[i].total, actual[i].getTotal());
        }
    }
}