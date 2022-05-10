package com.xworkz.vaccine.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Table(name="vaccine")
@Entity
@NamedQueries({
@NamedQuery(name="getOTPFromTable",query="Select o.OTP from UserEntity as o where OTP=:OTP"),
@NamedQuery(name="getEmailFromTable",query="Select check.email from UserEntity as check where email=:Email")
})
public class UserEntity {
	@Column(name="userId")
	@Id
	@GenericGenerator(name="abc", strategy="increment")
	@GeneratedValue(generator="abc")
	private int UserId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="OTP")
	private int OTP;

	public UserEntity() {
		
	}

	
	
	
	

}
