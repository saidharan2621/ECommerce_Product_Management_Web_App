package com.telusko.SpringEcom.controller;


import com.telusko.SpringEcom.model.Product;
import com.telusko.SpringEcom.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    productService productservice;

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return  new ResponseEntity<>(productservice.getProducts(), HttpStatus.ACCEPTED);
    }

    @RequestMapping("/product/{productid}")
    public ResponseEntity<Product> getProductsById(@PathVariable("productid") int productid){
        return  new ResponseEntity<>(productservice.getProductsById(productid), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{productid}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("productid") int productid){
        Product product = productservice.getProductsById(productid);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedProduct = null;
        try {
            savedProduct = productservice.addProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product updatedProduct = null;
        try {
            updatedProduct = productservice.updatedProduct(product,imageFile);
            return new ResponseEntity<>("updated",HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        Product deletedProduct = null;
        productservice.deletebyid(id);
        return  new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products = productservice.searchProduct(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }




}
