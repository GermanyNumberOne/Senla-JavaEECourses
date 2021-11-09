CREATE TABLE operations (
    id integer primary key,
    report_id integer,
    cost integer,
    foreign key (report_id) REFERENCES reports (id)
)