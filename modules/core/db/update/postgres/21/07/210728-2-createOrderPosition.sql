alter table PIZZA_ORDER_POSITION add constraint FK_PIZZA_ORDER_POSITION_ON_ORDER foreign key (ORDER_ID) references PIZZA_ORDER(ID);
alter table PIZZA_ORDER_POSITION add constraint FK_PIZZA_ORDER_POSITION_ON_PIZZA foreign key (PIZZA_ID) references PIZZA_PIZZA(ID);
create index IDX_PIZZA_ORDER_POSITION_ON_ORDER on PIZZA_ORDER_POSITION (ORDER_ID);
create index IDX_PIZZA_ORDER_POSITION_ON_PIZZA on PIZZA_ORDER_POSITION (PIZZA_ID);
