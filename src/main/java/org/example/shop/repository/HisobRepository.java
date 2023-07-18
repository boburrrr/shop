package org.example.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.shop.model.card.Hisob;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class HisobRepository {
    @PersistenceContext
    EntityManager entityManager;

    String UPDATE_HISOB_BALANCE = "update hisobs h set h.balance = :balance where h.id = :id";
    @Transactional
    public Hisob addHisob(Hisob hisob){
        entityManager.persist(hisob);
        return hisob;
    }
    public Hisob getById(UUID id){
        return entityManager.find(Hisob.class,id);
    }
    @Transactional
    public void deleteById(UUID id){
        entityManager.remove(getById(id));
    }
    @Transactional
    public void updateHisobBalance(UUID id, Double balance){
        entityManager.createQuery(UPDATE_HISOB_BALANCE)
                .setParameter("id",id)
                .setParameter("balance",balance)
                .executeUpdate();
    }
}
