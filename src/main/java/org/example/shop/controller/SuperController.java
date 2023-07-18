package org.example.shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Hisob;
import org.example.shop.model.user.Blocked;
import org.example.shop.model.user.Role;
import org.example.shop.model.user.User;
import org.example.shop.service.HisobService;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/super")
public class SuperController {

    private final UserService userService;
    private final HisobService hisobService;
    private User user;

    @RequestMapping(value = "user-controller")
    public String userControllerPage(
            Model model
    ){
        model.addAttribute("users",userService.showUser1());
        return "user-controller";
    }
    @PostMapping(value = "user-controller")
    public String userController(
            Model model,
            @RequestParam UUID userId
            ){
        User byId1 = userService.getById1(userId);
        Hisob hisob = new Hisob();
        hisob.setUser(byId1);
        hisob.setBalance(0.0);
        hisobService.addHisob(hisob);
        userService.createUserHisob(userId,hisob);
        userService.updateUser1(byId1.getId(),Role.ADMIN);
        model.addAttribute("users",userService.showUser1());
        return "user-controller";
    }
    @RequestMapping(value = "/admin-controller")
    public String adminControllerPage(
            Model model
    ){
        model.addAttribute("users",userService.showAdmin1());
        return "admin-controller";
    }
    @PostMapping(value = "/admin-controller")
    public String adminController(
            Model model,
            @RequestParam UUID userId
    ){

        User byId1 = userService.getById1(userId);
        User superU = userService.getById1(UUID.fromString("741e3031-3c2c-4cc0-b0d6-422935b0b4a7"));
        hisobService.updateHisobBalance(superU.getId(),superU.getHisob().getBalance()+byId1.getHisob().getBalance());
        userService.deleteUserHisob(userId);
        UUID uuid = byId1.getHisob().getId();
        hisobService.deleteById(uuid);
        userService.updateUser1(byId1.getId(),Role.USER);
        model.addAttribute("users",userService.showAdmin1());
        return "admin-controller";
    }
    @GetMapping(value = "/back")
    public String back(
            @RequestParam String path
    ){
        return path;
    }
    @PostMapping(value = "/user-blocked")
    public String blockUser(
            @RequestParam UUID userId,
            Model model
    ){
        user = userService.getById1(userId);
        Blocked blocked;
        if (user.getBlocked().equals(Blocked.BLOCK)){
            blocked = Blocked.ON_BLOCK;
        }else{
            blocked = Blocked.BLOCK;
        }
        userService.updateUser2(userId,blocked);
        model.addAttribute("users",userService.showUser1());
        return "user-controller";
    }

    @PostMapping(value = "/admin-blocked")
    public String blockAdmin(
            @RequestParam UUID userId,
            Model model
    ){
        user = userService.getById1(userId);
        Blocked blocked;
        if (user.getBlocked().equals(Blocked.BLOCK)){
            blocked = Blocked.ON_BLOCK;
        }else{
            blocked = Blocked.BLOCK;
        }
        userService.updateUser2(userId,blocked);
        model.addAttribute("users",userService.showAdmin1());
        return "admin-controller";
    }
}
