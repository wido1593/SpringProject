
/* 권한을 가진 system에서 실행해야하는 명령어 */
/* jb060이라는 유저를 cometrue라는 비밀번호를 부여하여 생성한다.*/
create user jb060 identified by "cometrue";
create user csb060 identified by "cometrue";
/* connect, resource 권한을 jb060에 부여*/
grant connect, resource to csb060;
/* 테이블확인 */

select * from jb060_product;
/* 테이블 만들기 */
create table jb060_product (
	pno	number(7) not null primary key,
	name	varchar2(30) not null,
	price	number(10) not null,
	cno	varchar2(10) not null,
	color	varchar2(20),
	psize	varchar2(20),
	regdate	date,
	image	varchar2(50)
);

create table product_csb (
	pno	number(7) not null primary key,
	name	varchar2(30) not null,
	price	number(10) not null,
	cno	varchar2(10) not null,
	color	varchar2(20),
	psize	varchar2(20),
	regdate	date,
	image	varchar2(50)
);

/* 
 sequence는 유일값을 생성해준다, 이렇게되면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성가능하다. 
 primary key값을 생성하기 위해 사용한다, 테이블과는 독립적으로 저장되고 생성된다. 
- START WITH : 시퀀스의 시작 값을 지정한다. n을 1로 지정하면 1부터 순차적으로 시퀀스번호가 증가 한다.
- INCREMENT BY : 시퀀스의 증가 값을 지정한다. n을 2로 하면 2씩 증가한다. START WITH를 1로, INCREMENT BY를 2로 설정하면 1, 3, 5, 7,.. 이렇게 시퀀스 번호가 증가한다.
- MAXVALUE : 시퀀스 최대값
- MINVALUE : 시퀀스 최소값
- CYCLE|NOCYCLE : 최대값 도달시 순환 여부
- CACHE | NOCACHE : CACHE 여부, 원하는 숫자만큼 미리 만들어 Shared Pool의 Library Cache에 상주시킨다.
*/
create sequence p_seq INCREMENT BY 1 START WITH 1060060; // auto_increment

/*  jb060_product테이블  pno, name, price, cno에  values값을 차례대로 넣는다 .nextval은 다음 값을 넣어준다*/
insert into jb060_product(pno, name, price, cno) values(p_seq.nextval, 'itme01', 50600,'kids');
insert into jb060_product(pno, name, price, cno) values(p_seq.nextval, 'itme02', 59060,'men');
insert into jb060_product(pno, name, price, cno) values(p_seq.nextval, 'itme03', 50600,'woman');

//시퀀스 초기화
drop sequence p_seq;

drop table jb060_product;
delete from jb060_product where name='Tree1';

select * from jb060_product;
select * from jb060_product where pno=1060001;

/*rownum이 1~3인것만*/
select * from (select rownum rnum, pno, name, cno, image from jb060_product)a where a.rnum between 1 and 3;




create table jb060_member (
	email	varchar2(30) not null primary key,
	pw		varchar2(20) not null,
	name 	varchar2(20),
	phone	varchar2(20)
);

create table member_csb (
	email	varchar2(30) not null primary key,
	pw		varchar2(20) not null,
	name 	varchar2(20),
	phone	varchar2(20),
	image	varchar2(50),
	birthday	date	
);
select * from member_csb;

drop table member_csb;

insert into jb060_member(email, pw, name) values('egyou@induk.ac.kr', 'cometrue25', 'egyou');
insert into jb060_member(email, pw, name) values('hsh@induk.ac.kr', 'cometrue24', '한교수님');
insert into jb060_member(email, pw, name) values('sjko@induk.ac.kr', 'cometrue26', '고교수님');
insert into jb060_member(email, pw, name) values('wido1593@naver.com', 'cometrue', '박재훈');

select * from jb060_member;

update jb060_member set name='egyou', phone='7625' where email='egyou@induk.ac.kr';
update jb060_member set name='박재훈', phone='9041' where email='wido1593@naver.com';

delete from jb060_member where email='';