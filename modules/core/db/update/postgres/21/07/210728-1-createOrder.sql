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
    INFORMATION_ID uuid not null,
    POSITIONS_ID uuid,
    --
    primary key (ID)
);