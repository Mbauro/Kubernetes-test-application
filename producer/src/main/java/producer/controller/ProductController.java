package producer.controller;

import org.springframework.web.bind.annotation.*;
import producer.Product.Product;
import producer.database.ProductDAO;

@RestController
public class ProductController {
    @RequestMapping(
            value = "/product/insert",
            method = RequestMethod.POST)
    public void insert(@RequestBody Product product){
        ProductDAO productDAO = new ProductDAO();
        productDAO.insertProduct(product);
    }

    @RequestMapping(
            value = "/product/update/{id}",
            method = RequestMethod.POST)
    public void update(@RequestBody Product product,@PathVariable("id") int id){
        ProductDAO productDAO = new ProductDAO();
        productDAO.updateProduct(product,id);
    }

}
