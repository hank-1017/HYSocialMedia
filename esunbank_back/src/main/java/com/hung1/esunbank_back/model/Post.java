package com.hung1.esunbank_back.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Post ID")
	private Integer postID;

	@ManyToOne
	@JoinColumn(name = "User ID")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Comment> comment;

	@Column(name = "Content")
	private String content;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created At")
	private Date createdTime;

	@PrePersist
	public void onCreate() {
		if(createdTime == null) {
			createdTime = new Date();
		}
	}

}
