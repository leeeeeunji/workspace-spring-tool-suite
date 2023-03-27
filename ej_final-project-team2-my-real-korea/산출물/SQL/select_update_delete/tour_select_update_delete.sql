/*********** select ***************/
	--1. 투어상품 리스트 전체 출력
	select * from tour;
	--2. 투어상품 상품번호로 상세보기
	select * from tour where to_no=1;
	--3. 키워드로 투어상품 검색
	select * from tour where to_name like '%여행%';
	--4. 지역으로 투어상품 검색
	select t.*,c.* from tour t join city c on t.city_no=c.city_no where t.city_no=2;
	--5. 여행타입으로 투어상품 검색
	select * from tour where to_type=1;
	--6. 투어번호로 투어이미지 전체출력
	select ti.* from tour_img ti join tour t on ti.to_no=t.to_no where ti.to_no=1;
	--7. 유저의 투어예약리스트 전체 보여주기
	select * from tour_reserve where user_id='admin';
	--8. 투어예약번호로 예약 상세보기
	select * from tour_reserve where to_rs_no=2;
	