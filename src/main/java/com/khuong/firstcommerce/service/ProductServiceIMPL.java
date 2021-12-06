package com.khuong.firstcommerce.service;

import com.khuong.firstcommerce.entities.Product;
import com.khuong.firstcommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long productId) {
        return productRepository.findById(productId);
    }
    /*public Product getProductById(long productId) {
        return productRepository.getById(productId);
    }*/

    @Override
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }
}
