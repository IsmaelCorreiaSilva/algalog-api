create table tb_customer (
    id binary(16) not null primary key,
    name varchar(100) not null,
    email varchar(100) not null,
    phone_number varchar(15) not null
);