-- create tables
create table tTestDoc
(
    number serial       primary key,
    text   varchar(255) not null unique
);
