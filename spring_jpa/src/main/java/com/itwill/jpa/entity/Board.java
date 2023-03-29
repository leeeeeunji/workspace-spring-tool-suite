package com.itwill.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@ToString
public class Board {

	@Id
	@SequenceGenerator(name = "board_boardno_seq", initialValue = 1, allocationSize = 1,sequenceName = "board_boardno_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_boardno_seq")
	private Long boardno;
	
	@NonNull
	@Column(length = 100,nullable = false)
	private String title;
	
	@NonNull
	@Column(length = 20,nullable = false)
	private String writer;
	
	@NonNull
	@Column(length = 2000,nullable = false)
	private String content;
	
	@ColumnDefault("sysdate")
	private LocalDateTime regdate;
	
	@ColumnDefault("0")
	private Long readcount;
	
	@ColumnDefault("0")
	private Long groupno;

	@ColumnDefault("1")
	private Long step;
	
	@ColumnDefault("0")
	private Long depth;
}
