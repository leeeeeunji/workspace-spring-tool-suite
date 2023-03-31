package com.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "provider")
public class Provider extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	
	
	/*************************************
	@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)
	List<Product> productList = new ArrayList<>();
	**************************************/
	
	/****************** case1 CascadeType.PERSIST *******************/
	@OneToMany(mappedBy = "provider", 
				cascade = CascadeType.PERSIST, 
				fetch = FetchType.EAGER)
	List<Product> productList = new ArrayList<>();
	 /***************************************************************/
	
	
}
