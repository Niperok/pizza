-- begin PIZZA_PIZZA
alter table PIZZA_PIZZA add constraint FK_PIZZA_PIZZA_ON_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID)^
create unique index IDX_PIZZA_PIZZA_UK_NAME on PIZZA_PIZZA (NAME) where DELETE_TS is null ^
create index IDX_PIZZA_PIZZA_ON_IMAGE on PIZZA_PIZZA (IMAGE_ID)^
-- end PIZZA_PIZZA
-- begin PIZZA_PAYMENT
alter table PIZZA_PAYMENT add constraint FK_PIZZA_PAYMENT_ON_ORDER foreign key (ORDER_ID) references PIZZA_ORDER(ID)^
create index IDX_PIZZA_PAYMENT_ON_ORDER on PIZZA_PAYMENT (ORDER_ID)^
-- end PIZZA_PAYMENT
-- begin PIZZA_INGREDIENT
alter table PIZZA_INGREDIENT add constraint FK_PIZZA_INGREDIENT_ON_PIZZA foreign key (PIZZA_ID) references PIZZA_PIZZA(ID)^
alter table PIZZA_INGREDIENT add constraint FK_PIZZA_INGREDIENT_ON_TOPPING foreign key (TOPPING_ID) references PIZZA_TOPPING(ID)^
create index IDX_PIZZA_INGREDIENT_ON_PIZZA on PIZZA_INGREDIENT (PIZZA_ID)^
create index IDX_PIZZA_INGREDIENT_ON_TOPPING on PIZZA_INGREDIENT (TOPPING_ID)^
-- end PIZZA_INGREDIENT
-- begin PIZZA_ORDER_POSITION
alter table PIZZA_ORDER_POSITION add constraint FK_PIZZA_ORDER_POSITION_ON_ORDER foreign key (ORDER_ID) references PIZZA_ORDER(ID)^
alter table PIZZA_ORDER_POSITION add constraint FK_PIZZA_ORDER_POSITION_ON_PIZZA foreign key (PIZZA_ID) references PIZZA_PIZZA(ID)^
create index IDX_PIZZA_ORDER_POSITION_ON_ORDER on PIZZA_ORDER_POSITION (ORDER_ID)^
create index IDX_PIZZA_ORDER_POSITION_ON_PIZZA on PIZZA_ORDER_POSITION (PIZZA_ID)^
-- end PIZZA_ORDER_POSITION
-- begin PIZZA_TOPPING
create unique index IDX_PIZZA_TOPPING_UK_NAME on PIZZA_TOPPING (NAME) where DELETE_TS is null ^
-- end PIZZA_TOPPING
-- begin PIZZA_ORDER
alter table PIZZA_ORDER add constraint FK_PIZZA_ORDER_ON_DELIVERY_COURIER foreign key (DELIVERY_COURIER_ID) references SEC_USER(ID)^
create unique index IDX_PIZZA_ORDER_UK_NUMBER_ on PIZZA_ORDER (NUMBER_) where DELETE_TS is null ^
create index IDX_PIZZA_ORDER_ON_DELIVERY_COURIER on PIZZA_ORDER (DELIVERY_COURIER_ID)^
-- end PIZZA_ORDER
