package com.hung1.esunbank_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Comment ID")
	private Integer commentID;

	@ManyToOne
	@JoinColumn(name = "User ID")
	private User user;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "Post ID")
	private Post post;

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
