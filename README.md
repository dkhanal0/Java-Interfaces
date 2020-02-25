# CSC 241 Interfaces

In this assignment, we will modify our  XML file reader so that it can build a collection of
Order, OrderItem, and Product objects. We will again use the Java Simple API 
for XML, or Java SAX, to read and process our XML input file. This will also 
give you additional opportunities to work with event driven 
programing. The Java SAX documentation can be found here:

http://www.saxproject.org/

Follow the specification below and make the necessary changes and additions.

## Specification

### Order
Begin with the code from the "Associations" assignment, then make the following
changes:

- Add a new private String instance variable called `orderNumber` 
- Modify the constructor to accept the `orderNumber` as the first parameter
- Add a new `getOrderNumber()` method that returns the order number

### OrderItem
This class must now implement a new interface called `TaxableNy` (see below). In addition,
it requires the following modifications

- Introduce a new constructor that accepts only the `quantity` parameter
- `getPrice()` - Revise this method so that it returns the price based on the unit price of the 
 product, quantity, and any applicable sales tax  
- Introduce a method to set the Product reference
- Implement method(s) required by the interface

### TaxableNy (Interface)
Create this new interface with the following properties:
- A constant for NY State tax rate of 8%
- A required `getSalesTaxNy(double)` method signature

### XmlHandler
This class must be modified to work with the new input file:
- startElement - This method should identify the different types of elements
and instantiate object references as needed.
- endElement - This method should associate object references (See comments in handler)
- getOrders - This method should return the ArrayList of all Orders generated from
the input file.

### XmlReader
This class has been modified slightly from the previous assignment, but 
no further modifications should be necessary.

### Unchanged Classes
The following classes are unchanged from the previous assignments:
- Account
- CommericalAccount
- Customer
- NonCommercialAccount
- NonTaxableProduct
- Product
- TaxableProduct

## Testing
The `Main` class contains a `main()` method that you can use to test your program.
When you push your code back to your repository, GitHub will initiate a series of
tests to verify the correct operation of each of the required methods.
