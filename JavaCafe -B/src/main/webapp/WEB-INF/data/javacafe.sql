CREATE TABLE CafeMaster (
	masterNumber	VARCHAR(20)		PRIMARY KEY,
	passwd			VARCHAR(20)		NOT NULL,
	phoneNumber		VARCHAR(13)		NOT NULL
);

INSERT INTO CafeMaster (masterNumber, passwd, phoneNumber) VALUES ('3416341352', '1111', '0');

select * from cafemaster;

CREATE TABLE Customer (
   cid				BIGINT        NOT NULL	PRIMARY KEY AUTO_INCREMENT,
   customerNumber	VARCHAR(13)   NOT NULL,
   mileage			BIGINT        NOT NULL	DEFAULT 0
);

INSERT INTO CUSTOMER (customerNumber, mileage) VALUES ('0', 0);

CREATE TABLE MenuItem (
	itemNumber		BIGINT			PRIMARY KEY,
	itemName		VARCHAR(20)		NOT NULL,
	itemCategory	VARCHAR(15)		NOT NULL,
	itemPrice		DOUBLE			NOT NULL,
	itemImage		VARCHAR(100)	NOT NULL	DEFAULT 'none',
	salesSeason		VARCHAR(10)		NOT NULL	DEFAULT 'always'
);

CREATE TABLE Stock (
	sid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	itemNumber		BIGINT			NOT NULL,
	itemStock		BIGINT			NOT NULL,
	
	CONSTRAINT Stock_itemId_FK FOREIGN KEY(itemNumber) REFERENCES MenuItem(itemNumber)
);

CREATE TABLE OrderList (
	oid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	receiptNumber	BIGINT			NOT NULL,
	orderNumber		BIGINT			NOT NULL,
	itemName		VARCHAR(20)		NOT NULL,
	itemPrice		DOUBLE			NOT NULL,
	orderQuantity	BIGINT			NOT NULL,
	customerNumber	VARCHAR(13)		NOT NULL,
	orderDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	paymentMethod	VARCHAR(4)		NOT NULL,
	status			VARCHAR(10)		NOT NULL	DEFAULT '�����Ϸ�'
);



SELECT * FROM cafeMaster;
SELECT * FROM customer;
SELECT * FROM menu;
SELECT * FROM orderList;