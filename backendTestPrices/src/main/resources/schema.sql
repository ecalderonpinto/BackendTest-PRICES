CREATE TABLE PRICES (
	BRAND_ID int NOT NULL,
	START_DATE date NOT NULL,
	END_DATE date NOT NULL,
	PRICE_LIST int NOT NULL,
	PRODUCT_ID int NOT NULL,
	PRIORITY int NOT NULL,
	PRICE double NOT NULL,
	CURR varchar(10) NOT NULL
);
