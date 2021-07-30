alter table PIZZA_ORDER rename column positions_id to positions_id__u64011 ;
alter table PIZZA_ORDER drop constraint FK_PIZZA_ORDER_ON_POSITIONS ;
drop index IDX_PIZZA_ORDER_ON_POSITIONS ;
