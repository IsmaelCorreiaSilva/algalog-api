create table tb_delivery (
    id binary(16) not null primary key,
    customer_id binary(16) not null,
    status varchar(20) not null,
    tax decimal(10,2) not null,
    date_ordered datetime not null,
    date_finalization datetime,

    name_addressee varchar(100) not null,
    street_addressee varchar(100) not null,
    number_addressee varchar(10) not null,
    complement_addressee varchar(100),
    district_addressee varchar(50) not null
);
alter table tb_delivery add constraint fk_delivery_customer
foreign key (customer_id) references tb_customer (id)