package producer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductController {
    @RequestMapping(
            value = "/product/insert",
            method = RequestMethod.POST)
    public void insert(@RequestBody Map<String,Object> jsonPayload){
        System.out.println(jsonPayload);
    }

}
