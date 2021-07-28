-- begin PIZZA_PIZZA
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
)^
-- end PIZZA_PIZZA
-- begin PIZZA_PAYMENT
create table PIZZA_PAYMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID uuid not null,
    TOTAL decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end PIZZA_PAYMENT
-- begin PIZZA_INGREDIENT
create table PIZZA_INGREDIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PIZZA_ID uuid not null,
    TOPPING_ID uuid not null,
    WEIGHT integer not null,
    --
    primary key (ID)
)^
-- end PIZZA_INGREDIENT
-- begin PIZZA_ORDER_POSITION
create table PIZZA_ORDER_POSITION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID uuid not null,
    PIZZA_ID uuid not null,
    COUNT_ integer not null,
    --
    primary key (ID)
)^
-- end PIZZA_ORDER_POSITION
-- begin PIZZA_TOPPING
create table PIZZA_TOPPING (
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
    IS_HOT boolean not null,
    --
    primary key (ID)
)^
-- end PIZZA_TOPPING
-- begin PIZZA_ORDER
create table PIZZA_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ integer not null,
    DATE_ date not null,
    STATUS varchar(255),
    COST decimal(19, 2) not null,
    INFORMATION_ID uuid,
    POSITIONS_ID uuid,
    --
    primary key (ID)
)^
-- end PIZZA_ORDER
-- begin PIZZA_ORDER_INFORMATION
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
)^
-- end PIZZA_ORDER_INFORMATION
