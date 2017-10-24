INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PHONE, ADDRESS, PASSWORD) VALUES ('tuannt39@gmail.com', 'tuannt39', 'nguyen the tuan', '096538563', 'Ha Noi', '1234');

CREATE TABLE ROLE 
(
  ID NUMBER NOT NULL,
  NAME VARCHAR2(20) DEFAULT 'PUBLIC',
  PRIMARY KEY (ID)
);

--ROLE_NAME: PUBLIC, CUSTOMER, SALES, MARKETING, MANAGER

CREATE SEQUENCE IDROLE START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER1
BEFORE INSERT ON SMARTSHOP.ROLE 
FOR EACH ROW
BEGIN
  SELECT IDROLE.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE USERS 
(
  ID NUMBER NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  USERNAME VARCHAR2(50) NOT NULL,
  FULLNAME NVARCHAR2(50) NOT NULL,
  PASSWORD VARCHAR2(20) NOT NULL,
  PHONE VARCHAR2(15) NOT NULL,
  ADDRESS VARCHAR2(50) NOT NULL,
  AVARTAR VARCHAR2(500) DEFAULT '/assets/layouts/layout/img/avartar.png',
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  STATUS VARCHAR(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (ID)
);

--USER_STATUS: ACTIVE, INACTIVE, DELETED, LOCKED

CREATE SEQUENCE IDUSERS START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER2
BEFORE INSERT ON SMARTSHOP.USERS
FOR EACH ROW
BEGIN
  SELECT IDUSERS.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE USER_ROLE 
(
  USER_ID NUMBER NOT NULL,
  ROLE_ID NUMBER NOT NULL,
  PRIMARY KEY (USER_ID, ROLE_ID),
  CONSTRAINT FK_USER_ROLE_USER_ID FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
  CONSTRAINT FK_USER_ROLE_ROLE_ID FOREIGN KEY (ROLE_ID) REFERENCES ROLE (ID)
);

CREATE TABLE LOGIN_LOG 
(
  ID NUMBER NOT NULL,
  USER_ID NUMBER NOT NULL,
  TOKEN VARCHAR2(50),
  LAST_ACCESS TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  CONSTRAINT FK_LOGIN_LOG_USER_ID FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

CREATE SEQUENCE IDLOGINLOG START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER3
BEFORE INSERT ON SMARTSHOP.LOGIN_LOG
FOR EACH ROW
BEGIN
  SELECT IDLOGINLOG.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE CATEGORY 
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(50) NOT NULL,
  NOTE NVARCHAR2(50),
  PRIMARY KEY (ID)
);

CREATE SEQUENCE IDCATEGORY START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER4
BEFORE INSERT ON SMARTSHOP.CATEGORY
FOR EACH ROW
BEGIN
  SELECT IDCATEGORY.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE PRODUCT
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(50) NOT NULL,
  PRICE NUMBER NOT NULL,
  IMAGE VARCHAR2(200),
  DESCRIPTION NVARCHAR2(1000),
  DISCOUNT VARCHAR2(10),
  QUANTITY NUMBER,
  VIEWS NUMBER,
  STATUS VARCHAR(10) DEFAULT 'NEW',
  CATEGORY_ID NUMBER NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_PRODUCT_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
);

--PRODUCT_STATUS: HOT, NEW, NORMAL

CREATE SEQUENCE IDPRODUCT START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER5
BEFORE INSERT ON SMARTSHOP.PRODUCT
FOR EACH ROW
BEGIN
  SELECT IDPRODUCT.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

/*CREATE TABLE PRODUCT_DETAIL
(
  ID NUMBER NOT NULL,
  MODEL NVARCHAR2(50) NOT NULL,
  COLOR NVARCHAR2(50),
  CAMERA_AFTER NVARCHAR2(50),
  CAMERA_BRFORE NVARCHAR2(50),
  RAM NVARCHAR2(50),
  SCREEN NVARCHAR2(50),
  PIN NVARCHAR2(50),
  SIM NVARCHAR2(50),
  CPU NVARCHAR2(50),
  OS NVARCHAR2(50),
  STORAGE NVARCHAR2(50),
  PRODUCT_ID NUMBER,
  PRIMARY KEY (ID),
  CONSTRAINT FK_PRODUCT_DETAIL_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);

CREATE SEQUENCE IDPRODUCTDETAIL START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER6
BEFORE INSERT ON SMARTSHOP.PRODUCT_DETAIL
FOR EACH ROW
BEGIN
  SELECT IDPRODUCTDETAIL.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;*/

CREATE TABLE ORDERS 
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  ADDRESS VARCHAR2(50) NOT NULL,
  NOTE NVARCHAR2(500),
  AMOUNT NUMBER NOT NULL,
  PAYMENT VARCHAR2(50),
  PAYMENT_INFO VARCHAR2(50),
  SECURITY VARCHAR2(10),
  USER_ID NUMBER,
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  STATUS VARCHAR(10) DEFAULT 'WAITING',
  PRIMARY KEY (ID)
);

--ORDERS_STATUS: CANCEL, WAITING, DONE

CREATE SEQUENCE IDORDERS START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER7
BEFORE INSERT ON SMARTSHOP.ORDERS
FOR EACH ROW
BEGIN
  SELECT IDORDERS.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE BILL 
(
  ID NUMBER NOT NULL,
  ORDERS_ID NUMBER NOT NULL,
  PRODUCT_ID NUMBER NOT NULL,
  QUANTITY NUMBER NOT NULL,
  AMOUNT NUMBER,
  NOTE NVARCHAR2(500),
  STATUS VARCHAR(10) DEFAULT 'WAITING',
  PRIMARY KEY (ID),
  CONSTRAINT FK_BILL_ODERS_ID FOREIGN KEY (ORDERS_ID) REFERENCES ORDERS (ID),
  CONSTRAINT FK_BILL_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);

--BILL_STATUS: DONE, WAITING, CANCEL

CREATE SEQUENCE IDBILL START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER8
BEFORE INSERT ON SMARTSHOP.BILL
FOR EACH ROW
BEGIN
  SELECT IDBILL.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE NEW
(
  ID NUMBER NOT NULL,
  TITLE NVARCHAR2(100),
  BRIEF NVARCHAR2(100),
  CONTENT NVARCHAR2(1000),
  CATEGORY_ID NUMBER NOT NULL,
  USERS_ID NUMBER NOT NULL,
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  CONSTRAINT FK_NEW_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID),
  CONSTRAINT FK_NEW_USERS_ID FOREIGN KEY (USERS_ID) REFERENCES USERS (ID)
);

CREATE SEQUENCE IDNEW START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER9
BEFORE INSERT ON SMARTSHOP.NEW
FOR EACH ROW
BEGIN
  SELECT IDNEW.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE CONTACT 
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(50) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) NOT NULL,
  NOTE NVARCHAR2(1000) NOT NULL,
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
);

CREATE SEQUENCE IDCONTACT START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER10
BEFORE INSERT ON SMARTSHOP.CONTACT
FOR EACH ROW
BEGIN
  SELECT IDCONTACT.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

