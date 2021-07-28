create table PIZZA_ORDER_INFORMATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_NAME varchar(255) not null,
    ADRESS varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    EMAIL varchar(255),
    COURIER_ID uuid,
    COMMENT_ text,
    --
    primary key (ID)
);