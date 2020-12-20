package producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.Product.Product;
import producer.Product.ProductDAO;

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
    public ResponseEntity<String> update(@RequestBody Product product, @PathVariable("id") int id){
        if(product.getQuantity() < 0){
            return new ResponseEntity<>("This quantity is not accepted", HttpStatus.BAD_REQUEST);
        }
        ProductDAO productDAO = new ProductDAO();
        String response = productDAO.updateProduct(product,id);
        if(response.equals("Product id not found")){
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
