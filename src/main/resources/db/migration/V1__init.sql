create table post (
    id bigint not null,
    content varchar(255),
    title varchar(255),
    user_id bigint,
    primary key (id)
);

create table user (
    id bigint not null,
    age integer,
    name varchar(255),
    primary key (id)
);