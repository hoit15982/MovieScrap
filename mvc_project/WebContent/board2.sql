create table board(
	bo_num number(5) primary key,
	bo_pass varchar2(30),
	bo_name varchar2(30),
	bo_email varchar2(30),
	bo_title varchar2(50),
	bo_content varchar2(1000),
	bo_count number(5) default 0,
	bo_regdate date default sysdate
)

create sequence board2_seq
increment by 1
start with 18
maxvalue 99999
nocache

select * from board2;
select * from seq;
select * from tab;

select * from board_notice order by bo_ref desc, bo_level asc, bo_step asc;


select * from board_qna;

drop sequence board_seq;
drop table board purge;
create table board2 as select * from board;

create sequence board2_seq as board_seq;

insert into board values(board_seq.nextval, '1234', '전원지', 'rrccon@nate.com', '갯골마을', '돼지삼겹살이 최고..', 0, sysdate);

