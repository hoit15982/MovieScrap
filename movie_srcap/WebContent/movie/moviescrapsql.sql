create table MovieScrap(
	ms_no number,
	mb_id varchar2(15),
	ms_title varchar2(50),
	ms_director varchar2(30),
	ms_poster varchar2(500),
	ms_regdate date,
	ms_rating varchar(50),
	ms_seq varchar2(15),
	ms_id varchar2(15),	
	primary key (ms_no)
);

drop table MovieScrap purge;
delete from MovieScrap;
select * from MovieScrap;
select * from MovieScrap where mb_id='namhy' and ms_seq='35443' and ms_id='F';
select * from (select rownum rnum, ms_no, mb_id, ms_title, ms_director,ms_poster, ms_regdate, ms_rating, ms_seq, ms_id from (select * from Moviescrap)) where rnum>=1 and rnum<=5 and mb_id='namhy';

select * from MEMBER;

select * from MovieReview;
select count(*) from MovieReview where mb_id='namhy' and ms_seq=35443 and ms_id='F';
drop table MovieReview purge;
delete from MovieReview;
delete from MovieReview where mb_id='namhy';

create table MovieReview(
	ms_no number,
	mb_id varchar2(15),
	ms_myRating number,
	ms_review varchar2(1000),
	ms_seq varchar2(15),
	ms_id varchar2(15),
	ms_regdate date,
	primary key (ms_no)
);

drop table MovieReview purge
