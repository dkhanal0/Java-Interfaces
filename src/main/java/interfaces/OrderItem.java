package interfaces;

// Class now implements TaxableNy interface
public class OrderItem implements TaxableNy {

    // start with code from previous "associations" assignment
    Product p1;
    int quantity;

    //A constructor that initializes the product and quantity
    public OrderItem(Product p1, int quantity) {
        this.p1 = p1;
        this.quantity = quantity;
    }

    // Introduce a new constructor that accepts only quantity parameter
    public OrderItem(int quantity) {
        this.quantity = quantity;
    }

    //getProduct()- Returns a reference to the Product object purchased
    public Product getProduct() {
        return p1;
    }

    //getQuantity()- Returns an integer indicating how many products were purchased.
    public int getQuantity() {
        return quantity;
    }


    //getPrice()- Returns the price of this item, based on the unit price of the product and the quantity
    // getPrice() - Revise this method so that it returns the price based on the unit price of the product, quantity,
    // and any applicable sales tax
    public double getPrice() {
        double price = (p1.getUnitPrice() * quantity);
        if (p1 instanceof TaxableProduct){
            price=price+(quantity* getSalesTaxNy(taxNy));
            System.out.println("price" + price);
        }
        return price;

    }

    // Introduce a method to set Product
    public void setProduct(Product p1) {
        this.p1 = p1;
    }

    // Implement method(s) required by the interface
    @Override
    public double getSalesTaxNy(double taxRate) {
        return p1.getUnitPrice() * taxNy;
    }
}
