package consumer.interfaces;

import consumer.product.Product;

public interface ProductDao{
    public String updateProduct(Product product, int product_id);
}