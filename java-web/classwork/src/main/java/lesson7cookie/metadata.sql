create table if not exists calc_history2
(
    id serial
    primary key,
    a  integer,
    b  integer,
    c  integer,
    usr text, -- uuid
    dt timestamp default now()
    );