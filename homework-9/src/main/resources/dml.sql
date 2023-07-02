-- insert questions
insert into questions(text)
values ('Какое стихийное бедствие измеряется по шкале Рихтера?');

insert into questions(text)
values ('Какая планета находится ближе всего к Солнцу?');

insert into questions(text)
values ('Кто была первой женщиной, получившей Нобелевскую премию в 1903 году?');

-- insert answers
insert into answer_options(question_id, text, is_right)
values
    (1,'Торнадо', false),
    (1,'Землетрясения', true),
    (1,'Наводнения', false),
    (1,'Ураган', false);

insert into answer_options(question_id, text, is_right)
values
    (2,'Земля', false),
    (2,'Марс', false),
    (2,'Меркурий', true),
    (2,'Венера', false),
    (2,'Сатурн', false);

insert into answer_options(question_id, text, is_right)
values
    (3,'Мария Кюри', true),
    (3,'Джейн Аддамс', false);

-- join
select q.text, a.text
from questions as q join answer_options as a
                         on q.number = a.question_id;

-- before
select count(number)
from answer_options where question_id = 3
group by question_id;

-- cascade delete
delete from questions
where number = 3;

-- after
select * from answer_options
where question_id = 3;