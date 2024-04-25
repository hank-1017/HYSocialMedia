package com.hung1.esunbank_back.service;

import com.hung1.esunbank_back.model.Comment;
import com.hung1.esunbank_back.model.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Transactional
    public void insert(Comment c1) {
        commentRepo.save(c1);
    }

}
