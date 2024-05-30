-- cashbook_member
drop table cashbook_member;

create table cashbook_member(
    member_id varchar2(20) primary key,
    member_pw varchar2(100) not null,
    member_name varchar2(20) not null,
    enabled number(1) default 1 check(enabled in (0,1)),
    rolename varchar2(20) default "ROLE_USER"
);

select * from cashbook_member;

-- cashbook_info
drop table cashbook_info;
drop sequence cashbook_seq;

create table cashbook_info(
    info_num number primary key,
    member_id varchar2(20) not null references cashbook_member(member_id) on delete cascade, 
    type varchar2(20) not null check(type in ('income','expense')),
    memo varchar2(1000) not null,
    amout number default 0,
    input_date timestamp default current_timestamp 
);
create sequence cashbook_seq;

select * from cashbook_info;