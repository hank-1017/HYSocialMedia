package com.hung1.HYSocialMedia.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}
