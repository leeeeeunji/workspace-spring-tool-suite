package com.itwill.ajax.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News {
	private int no;
	@JsonProperty(value = "newsTitle")
	private String title;
	private String company;
	private String date;
	
	
}
