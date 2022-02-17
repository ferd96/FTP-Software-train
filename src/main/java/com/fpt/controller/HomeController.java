package com.fpt.controller;

import com.fpt.entity.Products;
import com.fpt.entity.Users;
import com.fpt.service.ProductsService;
import com.fpt.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("index")
    public String doGetIndex(Model model) {
        List<Products> products = productsService.findAll();
        model.addAttribute("products", products);

        // java 8 hứng dữ liệu
        //  products.forEach(p -> System.out.println(p.getName()));
        return "user/index";

    }

    @GetMapping("login")
    public String doGetlogin(Model model) {
        model.addAttribute("userRequest", new Users());
        return "user/login";

    }

    @GetMapping("logout")
    public String doGetLogut(HttpSession session, Model model) {
        session.removeAttribute("currentUser");
        return "redirect:/index";

    }

    @PostMapping("login")
    public String doPostLogin(@ModelAttribute("userRequest") Users userRequest, Model model, HttpSession session) {
        Users userRespone = usersService.doLogin(userRequest.getUsername(), userRequest.getHashPassword());
        if (ObjectUtils.isEmpty(userRespone)) {
            String message = "Login failed, pleas try again";
            model.addAttribute("message", message);
            return "user/login";
        } else {
            session.setAttribute("currentUser", userRespone);
            return "redirect:/index";
            //redirect là chuyển trang
        }
    }
}

//HTTP Method GET/PUT/POST/DELETE