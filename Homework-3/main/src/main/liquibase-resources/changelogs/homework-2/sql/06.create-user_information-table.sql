CREATE TABLE user_information (
    user_id integer,
    telephone_number varchar(20),
    address varchar(30),
    foreign key (user_id) REFERENCES users (id)
)