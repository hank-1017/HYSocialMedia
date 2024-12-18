package com.hung1.HYSocialMedia.service;

import com.hung1.HYSocialMedia.model.Comment;
import com.hung1.HYSocialMedia.model.CommentRepository;
import com.hung1.HYSocialMedia.model.Post;
import com.hung1.HYSocialMedia.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostService pService;

    @Transactional
    public String insert(String content, Integer postid, HttpSession httpsession) {
        User loginUser = (User) httpsession.getAttribute("loginUser");
        if (loginUser != null) {
            Post p1 = pService.findById(postid);
            Comment c1 = new Comment();
            c1.setUser(loginUser);
            c1.setContent(content);
            c1.setPost(p1);
            commentRepo.save(c1);
            return "Y";
        }
        return "N";
    }

}
