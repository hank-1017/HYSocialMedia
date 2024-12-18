package com.hung1.HYSocialMedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "[User]")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User ID")
	private Integer userID;

	@Column(name = "User Name")
	private String userName;

	@Column(name = "Email", unique = true)
	private String email;

	@Column(name = "Password")
	private String pwd;

	@Column(name = "Biography")
	private String biography;

}
