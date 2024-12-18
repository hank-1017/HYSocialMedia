package com.hung1.HYSocialMedia.controller;

import com.hung1.HYSocialMedia.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
