delete from OFFER;
insert into OFFER(TITLE, DESCRIPTION, EXPIRE_DATE, MERCHANT_NAME, PRICE, CURRENCY, PRODUCT_ID) values('title 1','description 1',TO_DATE('2021/01/01', 'yyyy/mm/dd'), 'merchant 1',11, 'EUR', 1);
insert into OFFER(TITLE, DESCRIPTION, EXPIRE_DATE, MERCHANT_NAME, PRICE, CURRENCY, PRODUCT_ID) values('title 2','description 2',TO_DATE('2021/02/01', 'yyyy/mm/dd'), 'merchant 2',21, 'EUR', 2);
insert into OFFER(TITLE, DESCRIPTION, EXPIRE_DATE, MERCHANT_NAME, PRICE, CURRENCY, PRODUCT_ID) values('title 3','description 3',TO_DATE('2021/03/01', 'yyyy/mm/dd'), 'merchant 3',31, 'EUR', 3);