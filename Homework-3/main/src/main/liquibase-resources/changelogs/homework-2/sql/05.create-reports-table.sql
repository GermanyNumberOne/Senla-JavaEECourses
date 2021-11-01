CREATE TABLE reports (
    id integer primary key,
    operation_category_id integer,
    is_success boolean,
    foreign key (operation_category_id) REFERENCES operation_categories (id)
)