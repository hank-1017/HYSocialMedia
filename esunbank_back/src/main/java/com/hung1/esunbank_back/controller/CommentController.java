package com.hung1.esunbank_back.controller;

import com.hung1.esunbank_back.model.Comment;
import com.hung1.esunbank_back.model.Post;
import com.hung1.esunbank_back.model.User;
import com.hung1.esunbank_back.service.CommentService;
import com.hung1.esunbank_back.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials = "true")
public class CommentController {

    @Autowired
    private CommentService mService;

    @Autowired
    private PostService pService;

    @PostMapping("/comment/add")
    public String addComment(@RequestParam("content") String content,
                             @RequestParam("postid") Integer postid,
                             HttpSession httpsession) {
        User loginUser = (User) httpsession.getAttribute("loginUser");
        if (loginUser != null) {
            Post p1 = pService.findById(postid);
            Comment c1 = new Comment();
            c1.setUser(loginUser);
            c1.setContent(content);
            c1.setPost(p1);
            mService.insert(c1);

            return "Y";
        }
        ;
        return "N";//尚未登入

    }


}
