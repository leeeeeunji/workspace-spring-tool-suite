/************* 동행게시판 *************/
desc trip_board;


-- 게시글 수정
update trip_board set t_bo_title='제목수정',t_bo_content='내용수정',t_bo_person=3,
                        t_bo_img='img11.png',t_bo_start_date='2023-05-11',t_bo_end_date='2023-05-20',t_bo_style='느긋한',hashtag='즉흥적',city_no=3 where t_bo_no=1;

-- 게시글 삭제
delete trip_board where t_bo_no=2;

--  게시글 1개 보기
select t.* from trip_board t join city c on t.city_no = c.city_no where t.t_bo_no = 1;
    
--  게시글 모집상태별로 보기 - 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no where t.t_bo_status = 0 order by t.t_bo_no asc) s
	)
	where idx >= 1 and idx <= 10;
        
--  게시글 지역별로 보기 - 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no where c.city_no = 3 order by t.t_bo_no asc) s
	)
	where idx >= 1 and idx <= 10;

--  게시글 해시태그별로 보기 - 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no where t.hashtag = '인싸만' order by t.t_bo_no asc) s
	)
where idx >= 1 and idx <= 10;

-- 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순) - 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no order by t.t_bo_date desc) s
	)
where idx >= 1 and idx <= 10;

-- 게시판 리스트 정렬(조회수 기준 내림차순) - 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no order by t.t_bo_readcount desc) s
	)
where idx >= 1 and idx <= 10;

-- 게시판 리스트(게시글 시작번호~끝번호)- 페이징 처리
select * from
	(select rownum idx, s.* from
		(select * from trip_board t join city c on t.city_no = c.city_no order by t.t_bo_no asc) s
	)
where idx >= 1 and idx <= 10;

-- 게시글 총 개수
select count(*) from trip_board;

-- 모집상태별 게시글 개수
select count(*) from trip_board where t_bo_status=0;

-- 지역별 게시글 개수
select count(*) from trip_board where city_no=1;

-- 해시태그별 게시글 개수
select count(*) from trip_board where hashtag='아무나다좋아';

-- 게시글 조회수 1 증가
update trip_board set t_bo_readcount=t_bo_readcount+1 where t_bo_no=6;

-- 키워드로 검색된 게시판 리스트 - 페이징 처리
select * from
    (select rownum idx, s.* from
        (select * from trip_board t
        join city c on t.city_no = c.city_no
        where t.t_bo_title like '%추추%' or t.t_bo_content like '%추추%'
        order by t.t_bo_no desc) s
    )
where idx >= 1 and idx <= 10;

-- 검색된 게시글 총 개수
select count(*) cnt from trip_board where t_bo_title like '%추추%' or t_bo_content like '%추추%';

