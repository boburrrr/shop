package org.example.shop.controller;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.product.Product;
import org.example.shop.service.ProductService;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {
    private final UserService userService;
    private final ProductService productService;

    @GetMapping(value ="/create-product")
    public String createProductPage(
            Model model,
            @RequestParam UUID userId
    ){
        model.addAttribute("user",userService.getById1(userId));
        return "create-product";
    }
    @PostMapping(value = "/create-product")
    public String createProduct(
            @ModelAttribute Product product,
            @RequestParam UUID userId,
            Model model
            ){
        product.setUser(userService.getById1(userId));
        productService.addProduct1(product);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("products",productService.getUserProduct1(userId));
        return "admin-welcome";
    }
    @GetMapping(value = "/update")
    public String updatePage(
            @RequestParam UUID productId,
            Model model
    ){
        model.addAttribute("product",productService.getById1(productId));
        return "update-product";
    }
    @PostMapping(value = "/update")
    public String update(
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            @ModelAttribute Product product,
            Model model
    ){
        productService.updateProduct1(productId,product);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("products",productService.getUserProduct1(userId));
        return "admin-welcome";
    }
    @PostMapping(value = "/delete")
    public String delete(
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            Model model
    ){
        productService.deleteProduct1(productId);
        model.addAttribute("user",userService.getById1(userId));
        model.addAttribute("products",productService.getUserProduct1(userId));
        return "admin-welcome";
    }

}
