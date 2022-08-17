create table user(
    id int primary key auto_increment,
    email varchar(255),
    password varchar(65),
    first_name varchar(255),
    last_name varchar(255),
    city varchar(100)
)