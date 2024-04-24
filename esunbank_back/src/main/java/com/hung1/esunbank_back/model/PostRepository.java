package com.hung1.esunbank_back.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findFirstByOrderByCreatedTimeDesc();

	public  Post findByPostID(Integer id);
}
