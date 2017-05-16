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
