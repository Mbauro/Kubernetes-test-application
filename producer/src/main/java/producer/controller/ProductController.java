package producer.controller;

import org.springframework.web.bind.annotation.*;
import producer.Producer;
import producer.Product.Product;

import java.util.Map;

@RestController
public class ProductController {
    @RequestMapping(
            value = "/product/insert",
            method = RequestMethod.POST)
    public void insert(@RequestBody Product product){
        product.InsertProduct(product.getName(), product.getQuantity());
    }

}
