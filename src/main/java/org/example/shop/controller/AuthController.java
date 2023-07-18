package org.example.shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.user.Blocked;
import org.example.shop.model.user.Role;
import org.example.shop.model.user.User;
import org.example.shop.service.ProductService;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final ProductService productService;

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/log-in",method = RequestMethod.GET)
    public String logInPage(){ return "log-in"; }

    @RequestMapping(value = "/log-in",method = RequestMethod.POST)
    public String logIn(
            @RequestParam String tel_number,
            @RequestParam String password,
            Model model
    ){
        User user = userService.logIn(tel_number, password);
        if(user == null){
            model.addAttribute("message","wrong password or username!");
            return "log-in";
        } else {
            model.addAttribute("user", user);
            if (user.getRole().equals(Role.USER)) {
                if(user.getBlocked().equals(Blocked.BLOCK)) {
                    model.addAttribute("products", productService.getProduct1());
                    return "user-welcome";
                }else{
                    model.addAttribute("message","User Blocked");
                    return "index";
                }
            } else if (user.getRole().equals(Role.ADMIN)) {
                if(user.getBlocked().equals(Blocked.BLOCK)) {
                    model.addAttribute("products", productService.getUserProduct1(user.getId()));
                    return "admin-welcome";
                }else{
                    model.addAttribute("message","Admin Blocked");
                    return "index";
                }
            }else {
                return "super-welcome";
            }
        }
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signUpPage() {
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute User user,
            Model model
    ) {
        if(userService.addUser1(user) == 400) {
            model.addAttribute("message", "bad tel number or password");
            return "index";
        }
        return "log-in";
    }
}
