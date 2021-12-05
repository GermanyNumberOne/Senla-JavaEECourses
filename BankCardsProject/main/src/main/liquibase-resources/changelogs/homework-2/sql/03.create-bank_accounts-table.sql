CREATE TABLE bank_accounts (
    id integer primary key,
    user_id integer,
    payment_id integer,
    foreign key (user_id) REFERENCES users (id),
    foreign key (payment_id) REFERENCES operations (id)
);