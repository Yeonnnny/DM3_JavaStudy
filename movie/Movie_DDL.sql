
-- 회원(mem) table
drop table mem;

create table mem (
    mem_id varchar2(20) primary key,
    mem_pwd varchar2(20) not null
);

select * from mem;



-- 영화정보 table
drop table film;
drop sequence film_seq;

create table film (
    film_num number primary key,
    title varchar2(30) not null,
    director varchar2(20) not null,
    film_desc varchar2(4000),
    runtime number(3),    -- minute 기준
    ratings varchar2(10), -- G, PG, PG-13, R, NC-17
    avg_grade number(3,1),
    release_date date not null
);

create sequence film_seq;

select * from film;

-- 영화배우 table
drop table actor;
drop sequence actor_seq;

create table actor(
    actor_num number primary key,
    actor_name VARCHAR2(20)
);
create sequence actor_seq;

select * from actor;


-- 출연 table
drop table casts;

create table casts(
    film_num number references film(film_num) on delete cascade,
    actor_num number references actor(actor_num) on delete cascade,
    CONSTRAINT casts_pk PRIMARY KEY(film_num, actor_num)
);

select * from casts;

--장르 table
drop table genre;
create table genre(
    genre_attr varchar2(30) primary key
);

select * from genre;


-- 영화_장르 table
drop table film_genre;

create table film_genre(
    film_num number references film(film_num) on delete cascade,
    genre_attr varchar2(30) references genre(genre_attr) on delete cascade,
    CONSTRAINT film_genre_pk PRIMARY KEY(film_num, genre_attr)
);

select * from film_genre;



-- 관람평 table
drop table review;
drop sequence review_seq;

create table review (
    review_num number primary key,
    film_num number references film(film_num) on delete cascade,
    mem_id varchar2(20) references mem(mem_id) on delete cascade,
    review_text varchar2(2000) not null,
    grade number(3,1) not null,
    write_date date default sysdate
);

create sequence review_seq;

select * from review;