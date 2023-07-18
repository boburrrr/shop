package org.example.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.shop.model.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    @PersistenceContext
    EntityManager entityManager;
    private String GET_USER_PRODUCT = "select p from products p where p.user.id = :user_id";
    private String GET_PRODUCT_LIST = "select p from products p";
    @Transactional
    public Product addProduct(Product product){
        entityManager.persist(product);
        return product;
    }
    public Product getById(UUID id){
        return entityManager.find(Product.class,id);
    }

    public List<Product> getUserProduct(UUID user_id){
        return entityManager.createQuery(GET_USER_PRODUCT, Product.class)
                .setParameter("user_id",user_id)
                .getResultList();
    }
    @Transactional
    public void updateProduct(Product update){
        entityManager.merge(update);
    }
    @Transactional
    public void deleteProduct(UUID productId){
        entityManager.remove(getById(productId));
    }
    public List<Product> getProduct(){
        return entityManager.createQuery(GET_PRODUCT_LIST, Product.class)
                .getResultList();
    }

}
