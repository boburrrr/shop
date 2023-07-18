package org.example.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.shop.model.product.Order;
import org.example.shop.model.product.Status;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {
    @PersistenceContext
    EntityManager entityManager;
    private String USER_ORDER = "select o from orders o where o.user.id = :userId and o.status = 'CREATED'";
    private String USER_HISTORY = "select o from orders o where o.user.id = :userId and o.status = 'BUY'";
    private String UPDATE_ORDER_STATUS = "update orders o set o.status = :status where o.id = :id";
    private String UPDATE_ORDER_BY_TYPE = "update orders o set o.buy_type = :buyType where o.id = :id";
    @Transactional
    public Order addOrder(Order order){
        entityManager.persist(order);
        return order;
    }
    public Order getById(UUID id){
        return entityManager.find(Order.class,id);
    }
    public List<Order> userOrder(UUID user_id){
        return entityManager.createQuery(USER_ORDER, Order.class)
                .setParameter("userId",user_id)
                .getResultList();
    }
    public List<Order> userHistory(UUID user_id){
        return entityManager.createQuery(USER_HISTORY, Order.class)
                .setParameter("userId",user_id)
                .getResultList();
    }
    @Transactional
    public void updateOrderStatus(UUID id){
        entityManager.createQuery(UPDATE_ORDER_STATUS)
                .setParameter("id",id)
                .setParameter("status", Status.valueOf("BUY"))
                .executeUpdate();
    }

    @Transactional
    public void updateOrderByType(UUID id,String buyType){
        entityManager.createQuery(UPDATE_ORDER_BY_TYPE)
                .setParameter("id",id)
                .setParameter("buyType",buyType)
                .executeUpdate();
    }
}
