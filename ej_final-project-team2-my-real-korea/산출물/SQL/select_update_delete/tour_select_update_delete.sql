/*********** select ***************/
	--1. �����ǰ ����Ʈ ��ü ���
	select * from tour;
	--2. �����ǰ ��ǰ��ȣ�� �󼼺���
	select * from tour where to_no=1;
	--3. Ű����� �����ǰ �˻�
	select * from tour where to_name like '%����%';
	--4. �������� �����ǰ �˻�
	select t.*,c.* from tour t join city c on t.city_no=c.city_no where t.city_no=2;
	--5. ����Ÿ������ �����ǰ �˻�
	select * from tour where to_type=1;
	--6. �����ȣ�� �����̹��� ��ü���
	select ti.* from tour_img ti join tour t on ti.to_no=t.to_no where ti.to_no=1;
	--7. ������ ����ฮ��Ʈ ��ü �����ֱ�
	select * from tour_reserve where user_id='admin';
	--8. ������ȣ�� ���� �󼼺���
	select * from tour_reserve where to_rs_no=2;
	