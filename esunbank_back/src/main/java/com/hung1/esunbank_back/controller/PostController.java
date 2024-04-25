package com.hung1.esunbank_back.controller;

import com.hung1.esunbank_back.model.Post;
import com.hung1.esunbank_back.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hung1.esunbank_back.service.PostService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials = "true")
public class PostController {

    @Autowired
    private PostService mService;

    @GetMapping("/post/lastest")
    public Post getLastestPost() {
        return mService.findLastest();
    }

    @PostMapping("/post/new")
    public String newPost(@RequestParam("content") String content, HttpSession httpsession) {
        User loginUser = (User) httpsession.getAttribute("loginUser");
        if (loginUser != null) {
            Post p1 = new Post();
            p1.setUser(loginUser);
            p1.setContent(content);
            mService.insert(p1);

            return "Y";
        }
        ;
        return "N";//尚未登入

    }

    @GetMapping("/post/show")
    public List<Post> showMessages() {
        return mService.findAll();
    }

    @DeleteMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        mService.deleteById(id);
        return "Y";
    }

    @GetMapping("/post/edit")
    public Post editPage(@RequestParam("id") Integer id) {
        return mService.findById(id);
    }


    @PutMapping("/post/edit")
    public String updatePost(@RequestBody Post post) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("更新內容"+post.getContent());
        return mService.update(post);
    }


}
