create table tb_event (
    id binary(16) not null primary key,
    delivery_id binary(16) not null,
    description text not null,
    date_record datetime not null
);
alter table tb_event add constraint fk_event_delivery2
foreign key (delivery_id) references tb_delivery (id)