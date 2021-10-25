CREATE TABLE bank_accounts (
    id integer primary key,
    card_number varchar(15),
    payment_id integer,
    foreign key (card_number) REFERENCES cards (card_number),
    foreign key (payment_id) REFERENCES operations (id)
)