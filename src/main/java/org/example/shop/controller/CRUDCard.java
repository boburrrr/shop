package org.example.shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Card;
import org.example.shop.service.CardService;
import org.example.shop.service.ProductService;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/card")
public class CRUDCard {
    private final UserService userService;
    private final CardService cardService;
    private final ProductService productService;

    @GetMapping(value = "/create")
    public String createPage(
            @RequestParam UUID userId,
            Model model
            ){
        model.addAttribute("user",userService.getById1(userId));
        return "create-card";
    }
    @PostMapping(value = "/create")
    public String create(
            @RequestParam UUID userId,
            @ModelAttribute Card card,
            Model model
    ){
        card.setUser(userService.getById1(userId));
        cardService.addCard1(card);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "crud-card";
    }
    @RequestMapping(value = "/back")
    private String back(
            @RequestParam UUID userId,
            @RequestParam String path,
            Model model
    ){
        model.addAttribute("products",productService.getProduct1());
        model.addAttribute(userService.getById1(userId));
        return path;
    }
    @GetMapping(value = "/delete")
    public String delete(
            @RequestParam UUID userId,
            @RequestParam UUID cardId,
            Model model
    ){
        cardService.deleteById(cardId);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "crud-card";
    }
    @GetMapping(value = "/update")
    public String updatePage(
            @RequestParam UUID userId,
            @RequestParam UUID cardId,
            Model model
    ){
        model.addAttribute("userId",userId);
        model.addAttribute("cardId",cardId);
        return "update-card";
    }
    @PostMapping(value = "/update")
    public String update(
            @RequestParam UUID userId,
            @RequestParam UUID cardId,
            @RequestParam String password,
            Model model
    ){
        cardService.cardUpdatePassword(cardId,password);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "crud-card";
    }
    @GetMapping(value = "/add-balance")
    public String addBalancePage(
            @RequestParam UUID userId,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "add-balance-card";
    }
    @PostMapping(value = "/add-balance")
    public String addBalance(
            @RequestParam UUID userId,
            @RequestParam UUID cardId,
            @RequestParam Double balance,
            Model model
    ){
        Card card = cardService.getById1(cardId);
        cardService.cardUpdateBalance1(cardId,card.getBalance()+balance,true);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "crud-card";
    }
}
