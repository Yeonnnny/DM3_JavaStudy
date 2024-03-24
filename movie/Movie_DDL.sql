-- 영화정보 table
drop table movie;
drop sequence movie_seq;

create table movie (
    movie_num number primary key,
    movie_title varchar2(30) not null,
    movie_director varchar2(20) not null,
    movie_genre varchar2(20) not null,
    average_grade number(3,1),
    release_date date not null
);

create sequence movie_seq;

select * from movie;


-- 회원 table
drop table mem;
drop sequence mem_seq;

create table mem (
    mem_num number primary key,
    mem_id varchar2(20) not null unique,
    mem_pwd varchar2(20) not null
);
create sequence mem_seq;

select * from mem;


-- 관람평 table
drop table review;
drop sequence review_seq;

create table review (
    review_num number primary key,
    movie_num number references movie(movie_num) on delete cascade,
    mem_num number references mem(mem_num) on delete cascade,
    review_text varchar2(1000) not null,
    grade number(3,1) not null,
    write_date date default sysdate
);

create sequence review_seq;

select * from review;

