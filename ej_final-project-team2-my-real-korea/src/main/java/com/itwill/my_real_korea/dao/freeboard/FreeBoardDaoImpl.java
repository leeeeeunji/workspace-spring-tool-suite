
package com.itwill.my_real_korea.dao.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.mapper.FreeBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FreeBoardDaoImpl implements FreeBoardDao {


    private final FreeBoardMapper freeBoardMapper;

    @Autowired
    public FreeBoardDaoImpl(FreeBoardMapper freeBoardMapper) {
        this.freeBoardMapper = freeBoardMapper;
    }

    @Override
    public int insertBoard(FreeBoard freeBoard) {
        return freeBoardMapper.insertBoard(freeBoard);
    }

    @Override
    public FreeBoard selectByNo(int fBoNo) {
        return freeBoardMapper.selectByNo(fBoNo);
    }

    //최신순 정렬
    @Override
    public List<FreeBoard> selectAllOrderByFBoNoDesc(int pageStart, int pageEnd) throws Exception {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageStart", pageStart);
        pageMap.put("pageEnd", pageEnd);
        return freeBoardMapper.selectAllOrderByFBoNoDesc(pageMap);
    }
    //자유게시판 오래된순 정렬
    @Override
    public List<FreeBoard> selectAllOrderByFBoNoAsc(int pageStart, int pageEnd) throws Exception {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageStart", pageStart);
        pageMap.put("pageEnd", pageEnd);
        return freeBoardMapper.selectAllOrderByFBoNoAsc(pageMap);
    }
    //조회수 높은순 조회
    @Override
    public List<FreeBoard> selectAllOrderByReadCountDesc(int pageStart, int pageEnd) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageStart", pageStart);
        pageMap.put("pageEnd", pageEnd);
        return freeBoardMapper.selectAllOrderByReadCountDesc(pageMap);
    }


    @Override
    public int updateBoard(FreeBoard freeBoard) {
        return freeBoardMapper.updateBoard(freeBoard);
    }

    @Override
    public int deleteBoard(int no) {
        return freeBoardMapper.deleteBoard(no);
    }
    //조회수 증가
    @Override
    public int increaseReadCount(int no) throws Exception {
        return freeBoardMapper.increaseReadCount(no);
    }

    //자유게시판 게시글 갯수 조회
    @Override
    public int selectFreeBoardCount() throws Exception {
        return freeBoardMapper.selectFreeBoardCount();
    }
    //키워드 검색시 게시글 갯수 조회
    @Override
    public int selectSearchCount(String keyword) throws Exception {
        return freeBoardMapper.selectSearchCount(keyword);
    }

    //키워드검색 리스트 페이징 나누기
    @Override
    public List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageStart", pageStart);
        pageMap.put("pageEnd", pageEnd);
        pageMap.put("keyword", keyword);
        return freeBoardMapper.selectSearchFreeBoardList(pageMap);
    }
}
