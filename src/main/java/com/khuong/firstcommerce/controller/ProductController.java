package com.khuong.firstcommerce.controller;


import com.khuong.firstcommerce.entities.Product;
import com.khuong.firstcommerce.entities.User;
import com.khuong.firstcommerce.service.MyUserDetailsService;
import com.khuong.firstcommerce.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class ProductController {

    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private ProductService productService;

    /*@Autowired
    public ProductController(@Qualifier("ProductServiceIMPL")ProductService productService){
        this.productService = productService;
    }*/

    //http://localhost:8080/AllProducts
    @GetMapping("/AllProducts")
    public List<Product> findAll() {
        return productService.listProduct();
    }

    //http://localhost:8080/myCart
    @GetMapping("/myCart")
    public List<Product> findUserProduct(Principal principal){
        User user = userService.loadUser(principal.getName());
        return user.getProductList();
    }

    //http://localhost:8080/addToCart/{productId}
    @PostMapping("addToCart/{productId}")
    public List<Product> addToCart(@PathVariable("productId")String productId, Principal principal){
        User user = userService.loadUser(principal.getName());
        long productLongId = Long.parseLong(productId);
        //Product product = productService.getProductById(productLongId);
        Product product = productService.getProductById(productLongId).get();

        //List<Product> productList = new ArrayList<Product>();
        List<Product> productList = user.getProductList();
        productList.add(product);
        user.setProductList(productList);
        userService.update(user);
        return user.getProductList();
    }

}
