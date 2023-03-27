package com.itwill.ej_final_project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TripBoard {
	private int tbNo;
	private String tbTitle;
	private String tbContent;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tbDate;
	private int tbReadcount;
	private int tbStatus;
	private int tbPerson;
	private String tbImg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tbStartDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tbEndDate;
	private String tbStyle;
	private String tbHashtag;
	//FK
	private int cityNo;
	private String userId;
	
}
