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
	private int t_bo_no;
	private String t_bo_title;
	private String t_bo_content;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date t_bo_date;
	private int t_bo_readcount;
	private int t_bo_status;
	private int t_bo_person;
	private String t_bo_img;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date t_bo_start_date;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date t_bo_end_date;
	private String t_bo_style;
	private String hashtag;
	//FK
	private int city_no;
	private String user_id;
	
}
