package com.telusko.SpringEcom.service;

import com.telusko.SpringEcom.model.Product;
import com.telusko.SpringEcom.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class productService {
    @Autowired
    productRepo productrepo;

    public List<Product> getProducts(){
        return productrepo.findAll();
    }

    public Product getProductsById(int productid) {
        return productrepo.findById(productid).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productrepo.save(product);
    }

    public Product updatedProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productrepo.save(product);

    }

    public void deletebyid(int id) {
        productrepo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {
        return productrepo.searchProducts(keyword);
    }
}
