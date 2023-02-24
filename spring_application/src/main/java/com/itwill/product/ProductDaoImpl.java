package com.itwill.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ProductDaoImpl implements ProductDao {
	private DataSource dataSource;
	
	public ProductDaoImpl() {
		dataSource = new DataSource();
		System.out.println("1.#### PeroductDaoImpl() 생성자:"+this);
	}
	
	@Override
	public List<Product> productList(){
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1,"새우깡"));
		productList.add(new Product(2,"감자깡"));
		productList.add(new Product(3,"양파링"));
		productList.add(new Product(4,"옥수수깡"));
		return productList;
	}
	
	@Override
	public Product productDetail(int p_no) {
		return new Product(p_no, "허니버터칩");
	}
}
