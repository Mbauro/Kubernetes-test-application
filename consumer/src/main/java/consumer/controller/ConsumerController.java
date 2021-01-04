package consumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import consumer.product.Product;
import consumer.product.ProductDao;

@RestController
public class ConsumerController {
    @RequestMapping(
            value = "/product/consume/{id}",
            method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody Product product,@PathVariable("id") int id){
        ProductDaoImpl productDao = new ProductDaoImpl();
        String response = productDao.updateProduct(product,id);
        if (response.equals("Product id not found") || response.equals("The quantity you inserted is not available")){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }

}
