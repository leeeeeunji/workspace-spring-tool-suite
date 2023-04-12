package com.itwill.my_real_korea.dto.tripboard;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.itwill.my_real_korea.dto.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TripBoard {
	private int tBoNo;
	private String tBoTitle;
	private String tBoContent;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoDate;
	private int tBoReadcount;
	private int tBoStatus;
	private int tBoPerson;
	private String tBoImg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoStartDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoEndDate;
	private String tBoStyle;
	private String hashtag;
	//FK
	private City city;
	private String userId;
	
private int commentCount;
	
	public TripBoard(int tBoNo, String tBoTitle, String tBoContent, Date tBoDate, int tBoReadcount, int tBoStatus,
			int tBoPerson, String tBoImg, Date tBoStartDate, Date tBoEndDate, String tBoStyle, String hashtag,
			City city, String userId) {
		super();
		this.tBoNo = tBoNo;
		this.tBoTitle = tBoTitle;
		this.tBoContent = tBoContent;
		this.tBoDate = tBoDate;
		this.tBoReadcount = tBoReadcount;
		this.tBoStatus = tBoStatus;
		this.tBoPerson = tBoPerson;
		this.tBoImg = tBoImg;
		this.tBoStartDate = tBoStartDate;
		this.tBoEndDate = tBoEndDate;
		this.tBoStyle = tBoStyle;
		this.hashtag = hashtag;
		this.city = city;
		this.userId = userId;
	}
	
}
