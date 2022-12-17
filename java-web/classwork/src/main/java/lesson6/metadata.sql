create table if not exists calc_history
(
    id serial
    primary key,
    a  integer,
    b  integer,
    c  integer,
    dt timestamp default now()
    );