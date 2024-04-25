package com.hung1.esunbank_back.controller;

import com.hung1.esunbank_back.model.User;
import com.hung1.esunbank_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public String postRegister(@RequestParam("username") String username,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("biography") String biography,
                               HttpSession httpsession) {
        boolean isExist = userService.checkIfUsernameExist(username);
        if (isExist) {
            System.out.println("此帳號已存在");
            return "N";
        } else {
            userService.addUser(username, password, email, biography);
            System.out.println("註冊成功");
            User result = userService.checkLogin(username, password);
            httpsession.setAttribute("loginUser", result);
            return "Y";
        }
    }


    @PostMapping("/user/login")
    public String checkUserLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession httpsession) {
        User result = userService.checkLogin(username, password);
        if (result != null) {
            System.out.println("登入成功");
            httpsession.setAttribute("loginUser", result);
            return "Y";
        } else {
            System.out.println("登入fail");
            return "N";
        }
    }

    @GetMapping("/user/getLoginUser")
    public ResponseEntity<User> getLoginUser(HttpSession httpsession) {
        User loginUser = (User) httpsession.getAttribute("loginUser");
        return ResponseEntity.ok(loginUser);
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession httpsession) {
        httpsession.removeAttribute("loginUser");
        return "Y";
    }

}
