package com.fpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users implements Serializable {
	private static final long serialVersionUID = -8005275174150207433L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	@Size(max = 20, message = "Username must be less than 20 chars")
	private String username;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "hashPassword") //hashPassword là mã khóa  MD5:BRCrytPassword
	private String hashPassword;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "createdDate")
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "imgUrl")
	private String imgUrl;
	
	@Column(name = "isDeleted")
	private Boolean isDeleted;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Roles role;
}
