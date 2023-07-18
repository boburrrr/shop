package org.example.shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Card;
import org.example.shop.model.card.Hisob;
import org.example.shop.model.product.Order;
import org.example.shop.model.product.Product;
import org.example.shop.model.user.User;
import org.example.shop.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final ProductService productService;
    private final CardService cardService;
    private final OrderService orderService;
    private final HisobService hisobService;
    @GetMapping(value = "/buy")
    public String buyPage(
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            Model model
            ){
        model.addAttribute("cards",cardService.getUserCard1(userId));
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("product",productService.getById1(productId));
        return "product-buy";
    }
    @PostMapping(value = "/buy")
    public String buy(
            @ModelAttribute Order order,
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            Model model
            ){
        order.setUser(userService.getById1(userId));
        order.setProduct(productService.getById1(productId));
        order.setFull_price(order.getFull_price()*order.getNumber());
        orderService.addOrder1(order);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("products",productService.getProduct1());
        return "user-welcome";
    }
    @GetMapping(value = "/card")
    public String cardPage(
            @RequestParam UUID userId,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        return "crud-card";
    }
    @GetMapping(value = "/order")
    public String orderPage(
            @RequestParam UUID userId,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("orders",orderService.userOrder1(userId));
        return "my-order";
    }
    @GetMapping(value = "/my-order-back")
    public String back1(
            @RequestParam UUID userId,
            @RequestParam String path,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("products",productService.getProduct1());
        return path;
    }
    @PostMapping(value = "/end-order")
    public String andOrder(
            @RequestParam UUID userId,
            @RequestParam UUID orderId,
            Model model
    ){
        orderService.updateOrderStatus(orderId);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("orders",orderService.userOrder1(userId));
        return "my-order";
    }
    @GetMapping(value = "/end-order")
    public String  andOrderPage(
            @RequestParam UUID userId,
            @RequestParam UUID orderId,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("cards",cardService.getUserCard1(userId));
        model.addAttribute("order",orderService.getById(orderId));
        return "end-order";
    }
    @GetMapping(value = "/my-order-history")
    public String history(
            @RequestParam UUID userId,
            Model model
    ){
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("orders",orderService.userOrder2(userId));
        return "history";
    }
    @GetMapping(value = "/end-product-buy")
    public String endProductBuy(
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            @RequestParam UUID orderId,
            @RequestParam String buy_type,
            Model model
    ){
        Order order = orderService.getById(orderId);
        User user = userService.getById1(userId);
        User superU = userService.getById1(UUID.fromString("741e3031-3c2c-4cc0-b0d6-422935b0b4a7"));
        Product product = productService.getById1(productId);
        Card card = cardService.getByCardNumber1(buy_type);

        Double fullPrice = order.getFull_price();
        Double comissiya = fullPrice*0.1;
        if(cardService.cardUpdateBalance1(card.getId(),card.getBalance()-fullPrice+comissiya,false) != -1) {
            hisobService.updateHisobBalance(product.getUser().getHisob().getId(), fullPrice + comissiya);
            Hisob hisob = superU.getHisob();
            hisobService.updateHisobBalance(hisob.getId(), hisob.getBalance() + comissiya);
            orderService.updateOrderByType(orderId, buy_type);
            orderService.updateOrderStatus(orderId);
        }else{
            model.addAttribute("message","You don't have enough funds");
        }
        model.addAttribute("user",user);
        model.addAttribute("orders",orderService.userOrder1(userId));
        return "my-order";
    }
}
