-- create tables
create table questions
(
    number serial       primary key,
    text   varchar(255) not null unique
);

create table answer_options
(
    text        varchar(255) not null unique,
    is_right    boolean      default false not null,
    number      serial       primary key,
    question_id integer      not null references questions on delete cascade
);
