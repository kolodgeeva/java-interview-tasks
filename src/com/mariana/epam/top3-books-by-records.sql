/*
 Топ три книги по количеству записей у читателей до 10 лет
*/

create table Users
(
    id        bigint primary key,
    full_name varchar,
    age       int
);

create table Books
(
    id    bigint primary key,
    title varchar,
    pages bigint
);

create table Records
(
    id      bigint primary key,
    book_id bigint,
    user_id bigint
);


select count(b.id), b.title
from Books b
inner join Records r on b.id = r.book_id
inner join Users u on r.user_id = u.id
where u.age <= 10
group by count(b.id) desc limit 3
