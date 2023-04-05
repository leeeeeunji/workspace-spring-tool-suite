
package com.itwill.my_real_korea.dao.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardListPageMakerDto;

public interface FreeBoardDao {
    int insertBoard(FreeBoard freeBoard) throws Exception;

    FreeBoard selectByNo(int no) throws Exception;


    //최신순 조회
    List<FreeBoard> selectAllOrderByFBoNoDesc(int pageStart, int pageEnd) throws Exception;

    //오래된순 조회
    List<FreeBoard> selectAllOrderByFBoNoAsc(int pageStart, int pageEnd) throws Exception;
    
    //조회수 높은순 조회
    List<FreeBoard> selectAllOrderByReadCountDesc (int pageStart, int pageEnd) ;


    int updateBoard(FreeBoard freeBoard) throws Exception;


    int deleteBoard(int no) throws Exception;

    //조회수 증가
    int increaseReadCount(int no) throws Exception;

    //게시글 갯수 조회
    int selectFreeBoardCount() throws Exception;

    //검색된 게시글 총 개수 조회
    int selectSearchCount(String keyword) throws Exception;

    //자유게시판 title 키워드로 검색
    List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception;
}
