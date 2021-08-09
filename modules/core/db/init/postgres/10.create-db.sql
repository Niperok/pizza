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
    IMAGE_ID uuid,
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
    DELIVERY_CLIENT_NAME varchar(255) not null,
    DELIVERY_ADRESS text not null,
    DELIVERY_PHONE_NUMBER varchar(255) not null,
    DELIVERY_EMAIL varchar(255),
    DELIVERY_COURIER_ID uuid,
    DELIVERY_COMMENT_ text,
    --
    NUMBER_ bigint,
    DATE_ timestamp not null,
    STATUS integer not null,
    COST decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end PIZZA_ORDER
