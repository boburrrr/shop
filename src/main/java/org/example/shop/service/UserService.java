package org.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Hisob;
import org.example.shop.model.user.Blocked;
import org.example.shop.model.user.Role;
import org.example.shop.model.user.User;
import org.example.shop.repository.UserRepository;
import org.springframework.cglib.core.Block;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public int addUser1(User user){
        try{
            userRepository.addUser(user);
        }catch (DataIntegrityViolationException e){
            return 400;
        }
        return 200;
    }
    public User logIn(String tel_number, String password){
        User user = userRepository.logIn(tel_number, password);
        return user;
    }

    public List<User> showUser1() {
        return userRepository.showUser();
    }
    public List<User> showAdmin1() {
        return userRepository.showAdmin();
    }

    public User getById1(UUID id){
        return userRepository.getById(id);
    }
    public void updateUser1(UUID id, Role role){
        userRepository.updateUser(id,role);
    }
    public void updateUser2(UUID id, Blocked blocked){
        userRepository.updateUserBlock(id,blocked);
    }
    public void createUserHisob(UUID id, Hisob hisob){
        userRepository.createUserHisob(id,hisob);
    }
    public void deleteUserHisob(UUID id){
        userRepository.deleteUserHisob(id);
    }
}
