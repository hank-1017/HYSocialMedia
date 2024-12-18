package com.hung1.HYSocialMedia.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findFirstByOrderByCreatedTimeDesc();

	public  Post findByPostID(Integer id);
}
