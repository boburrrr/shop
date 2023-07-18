package org.example.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.shop.model.card.Card;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CardRepository {
    @PersistenceContext
    EntityManager entityManager;
    private String USER_CARD = "select c from cards c where c.user.id = :user_id";
    private String CARD_UPDATE_BALANCE = "update cards c set c.balance = :balance1 where c.id = :id1";
    private String GET_BY_USERNAME = "select c from cards c where c.card_number = :card_number";
    private String CARD_UPDATE_PASSWORD = "update cards c set c.password = :password where c.id = :id";
    @Transactional
    public Card addcard(Card card){
        entityManager.persist(card);
        return card;
    }
    public Card getById(UUID id){
        return entityManager.find(Card.class,id);
    }
    public List<Card> getUserCard(UUID user_id){
        return entityManager.createQuery(USER_CARD, Card.class)
                .setParameter("user_id",user_id)
                .getResultList();
    }
    @Transactional
    public int cardUpdateBalance(UUID id, Double balance, boolean tree){
        if(getById(id).getBalance()>balance || tree == true) {
            entityManager.createQuery(CARD_UPDATE_BALANCE)
                    .setParameter("balance1", balance)
                    .setParameter("id1", id)
                    .executeUpdate();
            return 1;
        }else{
            return -1;
        }
    }
    public Card getByCardNumber(String card_number){
        return entityManager.createQuery(GET_BY_USERNAME, Card.class)
                .setParameter("card_number",card_number)
                .getSingleResult();
    }
    @Transactional
    public void deleteById(UUID id){
        entityManager.remove(getById(id));
    }
    @Transactional
    public void cardUpdatePassword(UUID id, String password){
            entityManager.createQuery(CARD_UPDATE_PASSWORD)
                    .setParameter("id", id)
                    .setParameter("password",password)
                    .executeUpdate();
    }
}
