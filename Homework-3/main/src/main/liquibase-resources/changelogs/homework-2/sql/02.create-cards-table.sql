CREATE TABLE cards (
    card_number varchar(16) primary key,
    password integer,
    money integer,
    user_id integer,
    foreign key (user_id) REFERENCES users (id)
)