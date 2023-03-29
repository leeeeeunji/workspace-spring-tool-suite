package com.itwill.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.jpa.SpringJpaApplicationTests;
import com.itwill.jpa.entity.Board;

class BoardRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	BoardRepository boardRepository;
	@Test
	void board_crud(){
		/*
		Board board1=new Board(0L,"게시판201", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		Board board2=new Board(0L,"게시판202", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		*/
		Board board1=new Board("게시판201", "김경호1", "내용1");
		Board board2=new Board("게시판202", "김경호1", "내용1");
		Board saveBoard1= boardRepository.save(board1);
		Board saveBoard2= boardRepository.save(board2);
		System.out.println(">>> saveBoard1:"+saveBoard1);
		System.out.println(">>> saveBoard2:"+saveBoard2);
		//System.out.println(boardRepository.findById(1L).get());
	}
	@Test
	void board_select() {
		/*
		Board board1=new Board(0L,"게시판201", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		Board board2=new Board(0L,"게시판202", "김경호1", "내용1",LocalDateTime.now(),0L,0L,0L,0L);
		*/
		Board board1=new Board("게시판201", "김경호1", "내용1");
		Board board2=new Board("게시판202", "김경호1", "내용1");
		Board saveBoard1= boardRepository.save(board1);
		Board saveBoard2= boardRepository.save(board2);
		System.out.println(">>> saveBoard1:"+saveBoard1);
		System.out.println(">>> saveBoard2:"+saveBoard2);
		System.out.println(">>> findById:"+boardRepository.findById(1L).get());
	}
	@Test
	void board_select_pagable() {
		List<Board> boardList =  boardRepository.findAll();
		System.out.println(">>> boardList:"+boardList.size());
		
		int PAGE_SCALE = 10;		//페이지당 게시물 수
		int BLOCK_SCALE = 10;	//화면당 페이지 수
		int curPage = 1;			//요청페이지
	    System.out.println("페이지   블록사이즈:"+BLOCK_SCALE);
	    System.out.println("페이지당 게시물 수:"+PAGE_SCALE);
	    System.out.println("요청페이지:"+curPage);
	    
		Pageable pageable= PageRequest.of(curPage-1, PAGE_SCALE,Sort.by("groupno").descending().and(Sort.by("step").ascending()));
		/*
		PageRequest.of(page, size)
			- page zero-based page index.(요청페이지)
			- size the size of the page to be returned.(페이지당 게시물 수)
		 */
		System.out.println(pageable.hasPrevious());
		System.out.println(pageable.getOffset());
		
		Page<Board> pageBoardList =boardRepository.findAll(pageable);
		System.out.println((pageBoardList.getPageable().getPageNumber()+1)+"/"+pageBoardList.getTotalPages()+" pages");
		for(Board board:pageBoardList.getContent()) {
			System.out.println(board);
		}
		System.out.println("*******************결과***********************");
		System.out.println("페이지당 게시물 수:"+pageBoardList.getSize());
		System.out.println("요청페이지	 :"+pageBoardList.getNumber());
		System.out.println("총게시물수      :"+pageBoardList.getTotalElements());
		System.out.println("총페이지		 :"+pageBoardList.getTotalPages());
		
		//페이지블록번호
		int curBlock = (int) Math.ceil((pageBoardList.getNumber()) / BLOCK_SCALE) + 1;
	    System.out.println("페이지블록번호 :"+curBlock);
	    //페이지 블록의 시작번호
	 	int blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
	 	//페이지 블록의 끝 번호
	 	int	blockEnd = blockBegin + BLOCK_SCALE - 1;
	 	System.out.println("페이지블록시작번호 :"+blockBegin);
	 	System.out.println("페이지블록  끝번호 :"+blockEnd);
	 	
		boolean hasPrev = pageBoardList.hasPrevious();
        boolean hasNext = pageBoardList.hasNext();
        System.out.println("이전페이지존재여부 :"+hasPrev);
	 	System.out.println("다음페이지존재여부 :"+hasNext);
		/* 화면에는 원래 페이지 인덱스+1 로 출력됨을 주의 */		
        int prevIndex = pageBoardList.previousOrFirstPageable().getPageNumber()+1;
        int nextIndex = pageBoardList.nextOrLastPageable().getPageNumber()+1;
        System.out.println("이전페이지번호 :"+prevIndex);
	 	System.out.println("다음페이지번호 :"+nextIndex);
	 	// 이전다음 화면그룹의 시작페이지와 끝페이지
	 	int prevGroupStartPage = blockBegin - BLOCK_SCALE;
	 	int nextGroupStartPage = blockBegin + BLOCK_SCALE;
	 	System.out.println("이전그룹시작페이지번호 :"+prevGroupStartPage);
	 	System.out.println("다음그룹시작페이지번호 :"+nextGroupStartPage);
	}
	

}
