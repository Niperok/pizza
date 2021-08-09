alter table PIZZA_PIZZA add constraint FK_PIZZA_PIZZA_ON_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID);
create index IDX_PIZZA_PIZZA_ON_IMAGE on PIZZA_PIZZA (IMAGE_ID);
