package org.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.product.Product;
import org.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public int addProduct1(Product product){
        productRepository.addProduct(product);
        return 200;
    }
    public Product getById1(UUID id){
        return productRepository.getById(id);
    }
    public List<Product> getUserProduct1(UUID user_id){
        return productRepository.getUserProduct(user_id);
    }

    public Product updateProduct1(UUID productId, Product update) {
        Product product = productRepository.getById(productId);
        if(update.getName() != null && !update.getName().isBlank()){
            product.setName(update.getName());
        }
        if(update.getPrice() != null){
            product.setPrice(update.getPrice());
        }
        if(update.getRecurrence_period() != null){
            product.setRecurrence_period(update.getRecurrence_period());
        }
        productRepository.updateProduct(product);
        return product;
    }
    public void deleteProduct1(UUID id){
        productRepository.deleteProduct(id);
    }
    public List<Product> getProduct1(){
        return productRepository.getProduct();
    }
}
