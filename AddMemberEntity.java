package com.xworkz.vaccine.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;
@Data
@Table(name="AddMember")
@Entity
@NamedQuery(name="getAllAddMemberDetails",query="select entity from AddMemberEntity as entity")

public class AddMemberEntity {
	
	@Column(name="ID")
	@Id
	@GenericGenerator(name="abc",strategy="increment")
	@GeneratedValue(generator="abc")
	private int id;

	@Column(name="NAME")
	private String name;

	@Column(name="GENDER")
	private String gender;

	@Column(name="DOB")
	private int dob;

	@Column(name="PHOTO_ID_PROOF")
	private String photoId;

	@Column(name="ID_NUMBER")
	private String idNumber;

	@Column(name="VACCINE_TYPE")
	private String vaccineType;

	@Column(name="DOSE")
	private int dose;

	



}
