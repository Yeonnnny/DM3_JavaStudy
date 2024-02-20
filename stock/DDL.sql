drop table stock;
drop SEQUENCE stock_seq;

create table stock(
    pid number constraint stock_id_pk primary key
    ,pname  varchar2(100) constraint stock_name_nn not null
    ,unit_price number constraint stock_price_nn not null
    ,pnum number default 1
    ,category varchar2(10) -- enum 타입
);

create sequence stock_seq;

select * from stock;