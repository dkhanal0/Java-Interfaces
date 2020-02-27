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
            if (qName.equals("order")) {

                // Instantiate the currentOrder with dummyAccount
                currentOrder = new Order(attributes.getValue("orderNumber"), dummyAccount);

            }
            // Handle orderItem element
            if (qName.equals("orderItem")) {

                // Get quantity attribute
                int quantity = Integer.parseInt(attributes.getValue("quantity"));

                // Instantiate the currentOrderItem
                currentOrderItem = new OrderItem(currentProduct, quantity);
            }
            // Handle product element
            if (qName.equals("product")) {
                // Get product attributes
                String name = attributes.getValue("name");
                String isbn = attributes.getValue("isbn");
                String price = attributes.getValue("unitPrice");
                String type = attributes.getValue("taxable");


            // Instantiate the current Product based on taxable attribute
            if (attributes.getValue("taxable") != null && type.contentEquals("true")) {
                currentProduct = new TaxableProduct(name, isbn, Double.parseDouble(price));

            } else {
                currentProduct = new NonTaxableProduct(name, isbn, Double.parseDouble(price));
            }
        }
    }
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element:" + qName);

                // Handle order element
            if (qName.equals("order")) {

                // Add currentOrder to list of orders
                orders.add(currentOrder);
            }
                // Handle orderItem element
            else if (qName.equals("orderItem")) {

                // Associate currentOrderItem with currentOrder
                currentOrder.addItem(currentOrderItem);
            }
            // Handle product element
            if (qName.equals("product")){

                //Associate currentProduct with currentOrderItem
                currentOrderItem.setProduct(currentProduct);
            }
        }
        // Return a reference to array list
        public ArrayList<Order> getOrders() {
            return orders;
        }
    }


