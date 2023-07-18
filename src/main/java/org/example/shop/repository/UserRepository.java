package org.example.shop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.shop.model.card.Hisob;
import org.example.shop.model.user.Blocked;
import org.example.shop.model.user.Role;
import org.example.shop.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String LOG_IN = "select u from users u where tel_number = :tel_number and password = :password";
    String SHOW_USER = "select u from users u where role = 'USER'";
    String SHOW_ADMIN = "select u from users u where role = 'ADMIN'";
    String UPDATE_USER1 = "update users set role = :role where id = :id";
    String UPDATE_USER2 = "update users set blocked = :block where id = :id";
    String CREATE_USER_HISOB = "update users u set u.hisob = :hisob where u.id = :id";
    String DELETE_USER_HISOB = "update users u set u.hisob = null where u.id = :id";
    String CHECK_TEL_NUMBER = "select cound() ";
    @Transactional
    public User addUser(User user){

        entityManager.persist(user);
        return user;
    }
    public User getById(UUID id){
        return entityManager.find(User.class,id);
    }
    public User logIn(String tel_number, String password){
         return entityManager.createQuery(LOG_IN, User.class)
                .setParameter("tel_number",tel_number)
                .setParameter("password",password)
                .getSingleResult();
    }

    public List<User> showUser() {
        return entityManager.createQuery(SHOW_USER, User.class)
                .getResultList();
    }

    public List<User> showAdmin() {
        return entityManager.createQuery(SHOW_ADMIN, User.class)
                .getResultList();
    }
    @Transactional
    public void updateUser(UUID id, Role role){
        entityManager.createQuery(UPDATE_USER1)
                .setParameter("role",role)
                .setParameter("id",id)
                .executeUpdate();
    }
    @Transactional
    public void updateUserBlock(UUID id, Blocked blocked){
        entityManager.createQuery(UPDATE_USER2)
                .setParameter("id",id)
                .setParameter("block",blocked)
                .executeUpdate();
    }
    @Transactional
    public void createUserHisob(UUID id, Hisob hisob){
        entityManager.createQuery(CREATE_USER_HISOB)
                .setParameter("id",id)
                .setParameter("hisob",hisob)
                .executeUpdate();
    }
    @Transactional
    public void deleteUserHisob(UUID id){
        entityManager.createQuery(DELETE_USER_HISOB)
                .setParameter("id",id)
                .executeUpdate();
    }
}
