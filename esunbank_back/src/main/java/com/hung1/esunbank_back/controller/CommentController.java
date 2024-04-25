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


    @PostMapping("/comment/add")
    public String addComment(@RequestParam("content") String content,
                             @RequestParam("postid") Integer postid,
                             HttpSession httpsession) {
        return mService.insert(content, postid, httpsession);
    }

    ;


}
