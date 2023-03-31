package com.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter //(Data에 getter, setter포함이라 Data사용 시 안써도 됨, Data안 쓰면 getter,setter 직접 기재)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="category")
@Builder
@RequiredArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull 
	@Column(unique = true, nullable = false)
	private String code;
	
	@NonNull
	private String name;
	
	/*************** case1[@ManyToOne] ****************
	@ToString.Exclude
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();
	****************************************************/
	
	
	/*************** case2[@OneToMany] ****************/
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Product> products = new ArrayList<Product>();
	
	
}
