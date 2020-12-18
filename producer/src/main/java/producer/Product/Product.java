package producer.Product;

import producer.database.ProductDAO;

public class Product {
    private String name;
    private int quantity;

    public Product() {
    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void InsertProduct(String name, int quantity){
        Product product = new Product(name,quantity);
        ProductDAO productDAO = new ProductDAO();
        productDAO.insertProduct(product);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
