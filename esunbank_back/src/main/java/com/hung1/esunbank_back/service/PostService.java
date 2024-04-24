package com.hung1.esunbank_back.service;

import java.util.List;
import java.util.Optional;

import com.hung1.esunbank_back.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung1.esunbank_back.model.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public void insert(Post post) {
		postRepo.save(post);
	}
	
	public Post findById(Integer id) {
		Optional<Post> optioanl = postRepo.findById(id);
		
		if(optioanl.isPresent()) {
			return optioanl.get();
		}
		
		return null;
	}

	@Transactional
	public String update(Post post) {
		Optional<Post> existingPost = Optional.ofNullable(postRepo.findByPostID(post.getPostID()));
		if (existingPost.isPresent()) {
			existingPost.get().setContent(post.getContent());
			existingPost.get().setUser(post.getUser());
			postRepo.save(existingPost.get());
			return "Y";
		} else {
			return "N";
		}
	}
	
	public void deleteById(Integer id) {
		postRepo.deleteById(id);
	}


	public List<Post> findAll(){
		return postRepo.findAll();
	}
	
	public Post findLastest() {
		return postRepo.findFirstByOrderByCreatedTimeDesc();
	}
	
	

}
