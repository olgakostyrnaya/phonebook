create sequence seq_phone_code start with 100 increment by 1;
create table phone_code (id int not null, code varchar(10 char), name varchar(100 CHAR), primary key (id));
alter table phone_code add constraint UK_CODE unique (code);
alter table phone_code add constraint UK_NAME unique (name);
