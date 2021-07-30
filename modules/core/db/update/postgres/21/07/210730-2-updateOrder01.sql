alter table PIZZA_ORDER rename column information_id to information_id__u63784 ;
drop index IDX_PIZZA_ORDER_ON_INFORMATION ;
alter table PIZZA_ORDER rename column status to status__u15747 ;
alter table PIZZA_ORDER rename column date_ to date___u73130 ;
alter table PIZZA_ORDER alter column date___u73130 drop not null ;
alter table PIZZA_ORDER add column DELIVERY_COURIER_ID uuid ;
alter table PIZZA_ORDER add column DELIVERY_ADRESS text ^
update PIZZA_ORDER set DELIVERY_ADRESS = '' where DELIVERY_ADRESS is null ;
alter table PIZZA_ORDER alter column DELIVERY_ADRESS set not null ;
alter table PIZZA_ORDER add column DELIVERY_PHONE_NUMBER varchar(255) ^
update PIZZA_ORDER set DELIVERY_PHONE_NUMBER = '' where DELIVERY_PHONE_NUMBER is null ;
alter table PIZZA_ORDER alter column DELIVERY_PHONE_NUMBER set not null ;
alter table PIZZA_ORDER add column DELIVERY_COMMENT_ text ;
alter table PIZZA_ORDER add column DELIVERY_EMAIL varchar(255) ;
alter table PIZZA_ORDER add column DELIVERY_CLIENT_NAME varchar(255) ^
update PIZZA_ORDER set DELIVERY_CLIENT_NAME = '' where DELIVERY_CLIENT_NAME is null ;
alter table PIZZA_ORDER alter column DELIVERY_CLIENT_NAME set not null ;
alter table PIZZA_ORDER add column DATE_ timestamp ^
update PIZZA_ORDER set DATE_ = current_timestamp where DATE_ is null ;
alter table PIZZA_ORDER alter column DATE_ set not null ;
alter table PIZZA_ORDER add column STATUS integer ^
update PIZZA_ORDER set STATUS = 10 where STATUS is null ;
alter table PIZZA_ORDER alter column STATUS set not null ;
