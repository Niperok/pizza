create table PIZZA_PIZZA (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    SIZE_ integer not null,
    PRICE decimal(19, 2) not null,
    CALORIFIC integer,
    INFORMATION text,
    --
    primary key (ID)
);