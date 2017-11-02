DROP USER SMARTSHOP CASCADE;
CREATE USER SMARTSHOP IDENTIFIED BY 1234;
GRANT dba TO SMARTSHOP WITH ADMIN OPTION;
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
  TOKEN VARCHAR2(100),
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
  NAME NVARCHAR2(100) NOT NULL,
  PRICE NUMBER NOT NULL,
  IMAGE VARCHAR2(200),
  DESCRIPTION NVARCHAR2(1000),
  DISCOUNT VARCHAR2(10),
  QUANTITY NUMBER,
  VIEWS NUMBER,
  STATUS VARCHAR(15) DEFAULT 'NEW',
  CATEGORY_ID NUMBER NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_PRODUCT_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
);

--PRODUCT_STATUS: HOT, NEW, NORMAL, OUT OF STOCK

CREATE SEQUENCE IDPRODUCT START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER5
BEFORE INSERT ON SMARTSHOP.PRODUCT
FOR EACH ROW
BEGIN
  SELECT IDPRODUCT.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

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

CREATE OR REPLACE TRIGGER TRIGGER6
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
  NOTE NVARCHAR2(500) DEFAULT 'NO',
  STATUS VARCHAR(10) DEFAULT 'WAITING',
  PRIMARY KEY (ID),
  CONSTRAINT FK_BILL_ODERS_ID FOREIGN KEY (ORDERS_ID) REFERENCES ORDERS (ID),
  CONSTRAINT FK_BILL_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);

--BILL_STATUS: DONE, WAITING, CANCEL

CREATE SEQUENCE IDBILL START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER7
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
  TITLE NVARCHAR2(100) NOT NULL,
  BRIEF NVARCHAR2(500) NOT NULL,
  CONTENT NVARCHAR2(1000) NOT NULL,
  CATEGORY_ID NUMBER NOT NULL,
  USERS_ID NUMBER NOT NULL,
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  CONSTRAINT FK_NEW_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID),
  CONSTRAINT FK_NEW_USERS_ID FOREIGN KEY (USERS_ID) REFERENCES USERS (ID)
);

CREATE SEQUENCE IDNEW START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER8
BEFORE INSERT ON SMARTSHOP.NEW
FOR EACH ROW
BEGIN
  SELECT IDNEW.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE FEEDBACK 
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(100) NOT NULL,
  EMAIL VARCHAR2(100) NOT NULL,
  PHONE VARCHAR2(15) NOT NULL,
  NOTE NVARCHAR2(1000) NOT NULL,
  CREATED_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
);

CREATE SEQUENCE IDFEEDBACK START WITH 1;

CREATE OR REPLACE TRIGGER TRIGGER9
BEFORE INSERT ON SMARTSHOP.FEEDBACK
FOR EACH ROW
BEGIN
  SELECT IDFEEDBACK.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;

CREATE TABLE CONTACT 
(
  ID NUMBER NOT NULL,
  NAME NVARCHAR2(100) NOT NULL,
  EMAIL VARCHAR2(100) NOT NULL,
  PHONE VARCHAR2(15) NOT NULL,
  FAX VARCHAR2(25) NOT NULL,
  ADDRESS NVARCHAR2(100) NOT NULL,
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

--TABLE 'ROLE'
INSERT INTO "SMARTSHOP"."ROLE" (NAME) VALUES ('PUBLIC');
INSERT INTO "SMARTSHOP"."ROLE" (NAME) VALUES ('CUSTOMER');
INSERT INTO "SMARTSHOP"."ROLE" (NAME) VALUES ('SALES');
INSERT INTO "SMARTSHOP"."ROLE" (NAME) VALUES ('MARKETING');
INSERT INTO "SMARTSHOP"."ROLE" (NAME) VALUES ('MANAGER');

--TABLE 'USERS'
INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PASSWORD, PHONE, ADDRESS) VALUES ('tuan@gmail.com', 'tuan', 'Nguyễn Thế Tuân', '1234', '0963349511', 'Hà Nội');
INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PASSWORD, PHONE, ADDRESS) VALUES ('duong@gmail.com', 'duong', 'Mặt Dương', '1234', '0963349512', 'Hà Nội');
INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PASSWORD, PHONE, ADDRESS) VALUES ('duc@gmail.com', 'duc', 'BD Đức', '1234', '0963349513', 'Hà Nội');
INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PASSWORD, PHONE, ADDRESS) VALUES ('linh@gmail.com', 'linh', 'Nguyễn Linh', '1234', '0963349514', 'Hà Nội');
INSERT INTO "SMARTSHOP"."USERS" (EMAIL, USERNAME, FULLNAME, PASSWORD, PHONE, ADDRESS) VALUES ('thinh@gmail.com', 'thinh', 'Nguyễn Thịnh', '1234', '0963349515', 'Hà Nội');

--TABLE 'USER_ROLE'
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('1', '1');
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('1', '5');
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('2', '1');
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('3', '1');
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('4', '1');
INSERT INTO "SMARTSHOP"."USER_ROLE" (USER_ID, ROLE_ID) VALUES ('5', '1');

--TABLE 'LOGIN_LOG'
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('1', 'cedL7QgFHUxyFqcordBl');
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('2', 'B2EWubuFc327WDIe933z');
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('3', 'Is2PzORKprEEoAYkN9fi');
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('4', 'yuXCcoyDrEdQVuAZxBS1');
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('5', '2aIjtV13nwZwoyo11qPl');
INSERT INTO "SMARTSHOP"."LOGIN_LOG" (USER_ID, TOKEN) VALUES ('1', 'bRhQfbo50eVHYW2LoAq1');

--TABLE 'CATEGORY'
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Thời trang nam', '1');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Thời trang nữ', '1');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Giày nam', '2');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Trang phục nam', '2');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Ba lô nam', '2');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Phụ kiện nam', '2');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Ví nam', '2');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Túi xách tay nữ', '3');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Giày nữ', '3');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Trang phục nữ', '3');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Phụ kiện nữ', '3');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Ba lô nữ', '3');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Sao style', '4');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Xu hướng', '4');
INSERT INTO "SMARTSHOP"."CATEGORY" (NAME, NOTE) VALUES ('Tư vấn', '4');

--TABLE 'PRODUCT'
INSERT INTO "SMARTSHOP"."PRODUCT" (NAME, PRICE, IMAGE, DESCRIPTION, DISCOUNT, QUANTITY, VIEWS, STATUS, CATEGORY_ID) VALUES ('ÁO KHOÁC KAKI BOMBER OCEAN NAM (ĐEN)  ', '230000', '/assets/users/images/cart/ao-khoac-kaki-bomber-ocean-nam-den.jpg', 'Thiết kế tinh tế với cổ bẻ, tay dài phối bo tay sành điệu, cá tính, form dáng khỏe khoắn cho bạn phong cách trẻ trung, chỉnh chu và không kém phần lịch lãm', '20', '10', '100', 'NORMAL', '4');
INSERT INTO "SMARTSHOP"."PRODUCT" (NAME, PRICE, IMAGE, DESCRIPTION, DISCOUNT, QUANTITY, VIEWS, STATUS, CATEGORY_ID) VALUES ('Giày tây Zapas công sở kiểu xỏ - GT016 (Màu Đen)', '460000', '/assets/users/images/cart/giay-tay-zapas-cong-so-kieu-xo-gt016.jpg', 'Giày tây da nam của thương hiệu Zapas có thiết kế đơn giản, sang trọng nhưng không kém phần nam tính và lịch lãm dành cho các quý ông. Thiết kế thanh lịch với những điểm nhấn mới lạ kết hợp cùng chất liệu da PU cao cấp tạo cảm giác mềm mại, êm ái và thoải mái khi di chuyển trong khoảng thời gian dài. Sản phẩm giày tây Zapas luôn là sự lựa chọn hàng đầu trong việc thể hiện phong cách thời trang nổi bật của các quý ông sang trọng, đẳng cấp', '20', '10', '100', 'NORMAL', '3');
INSERT INTO "SMARTSHOP"."PRODUCT" (NAME, PRICE, IMAGE, DESCRIPTION, DISCOUNT, QUANTITY, VIEWS, STATUS, CATEGORY_ID) VALUES ('Thắt lưng da nam cao cấp TLG HK203880-24', '125000', '/assets/users/images/cart/that-lung-da-nam-cao-cap-tlg-hk203880.jpg', 'Chất liệu da bền đẹp An toàn cho người dùng Kiểu dáng thời trang Dễ dàng phối trang phục', '20', '10', '100', 'NORMAL', '6');

--TABLE 'ORDERS'
INSERT INTO "SMARTSHOP"."ORDERS" (NAME, PHONE, EMAIL, ADDRESS, NOTE, AMOUNT) VALUES ('Lê Minh Dương', '04857895749', 'duongml@gmail.com', 'Hà Nội', 'Chuyển nhanh em nhé', '1288000');
INSERT INTO "SMARTSHOP"."ORDERS" (NAME, PHONE, EMAIL, ADDRESS, NOTE, AMOUNT) VALUES ('Trần Trung Đức', '03485789453543', 'ductr@gmail.com', 'HÀ Nội', 'Chuyển thứ 3 tuần này nhé', '1304000');
INSERT INTO "SMARTSHOP"."ORDERS" (NAME, PHONE, EMAIL, ADDRESS, NOTE, AMOUNT) VALUES ('Nguyễn Linh', '05736979', 'linhhg@gmail.com', 'Hà Nội', 'Chuyển nhanh đê', '936000');

--TABLE 'BILL'
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('1', '1', '3', '552000');
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('1', '2', '2', '736000');
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('2', '2', '3', '1104000');
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('2', '3', '2', '200000');
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('3', '1', '4', '736000');
INSERT INTO "SMARTSHOP"."BILL" (ORDERS_ID, PRODUCT_ID, QUANTITY, AMOUNT) VALUES ('3', '3', '2', '200000');

--TABLE 'NEW'
INSERT INTO "SMARTSHOP"."NEW" (TITLE, BRIEF, CONTENT, CATEGORY_ID, USERS_ID) VALUES ('Sao Việt làm ''sống dậy'' xu hướng mũ nồi', 'Phụ kiện thịnh hành ở những năm 80 - 90 được nhiều người đẹp ''hâm nóng'' trở lại.', 'Ngày 29 và 30/10 - trước khi Vietnam International Fashion Week Thu đông 2017 chính thức diễn ra, nhiều bạn trẻ Hà Nội đã tập trung ở khu vực gần hồ Hoàn Kiếm để tham gia sự kiện street style. Hầu hết tín đồ thời trang đều tìm cách giúp mình nổi bật bằng những trang phục kiểu dáng khác lạ, màu sắc rực rỡ.  cần quan tâm tổng thể set đồ có rối mắt hay không, họ cố gắng khoác lên mình thật nhiều phụ kiện. Họa tiết dày đặc, phủ kín từ trên xuống dưới được nhiều người lựa chọn. Không ít bạn nam diện đồ unisex, trang điểm và mang giày cao gót như phụ nữ. Quán quân Next Top 2016 Ngọc Châu chọn phong cách khá đơn giản so với nhiều tín đồ thời trang khác.', '14', '1');
INSERT INTO "SMARTSHOP"."NEW" (TITLE, BRIEF, CONTENT, CATEGORY_ID, USERS_ID) VALUES ('Street style ''quái'' của giới trẻ Hà Nội trước thềm Tuần thời trang quốc tế Việt Nam', 'Nhiều tín đồ thời trang và cả các mẫu nhí chọn phong cách khác biệt để ghi dấu ấn trên đường phố.', 'Sau một thời gian dài bị nhấn chìm bởi các xu hướng mũ fedora, mũ snapback, mũ nồi xinh xắn đánh dấu sự trở lại của mình ở mùa mốt thu đông 2017. Góp phần khiến mẫu phụ kiện cổ điển trở nên thu hút hơn là sự lăng xê nhiệt tình của nhiều người đẹp Việt.', '15', '2');
INSERT INTO "SMARTSHOP"."NEW" (TITLE, BRIEF, CONTENT, CATEGORY_ID, USERS_ID) VALUES ('Muôn kiểu áp dụng phong cách quân đội hấp dẫn', 'Không chỉ khắc họa hình ảnh cá tính, bụi bặm, những chiếc áo khoác form cứng cáp màu xanh quân đội còn có thể tạo nên style gợi cảm.', 'Sau một thời gian dài bị nhấn chìm bởi các xu hướng mũ fedora, mũ snapback, mũ nồi xinh xắn đánh dấu sự trở lại của mình ở mùa mốt thu đông 2017. Góp phần khiến mẫu phụ kiện cổ điển trở nên thu hút hơn là sự lăng xê nhiệt tình của nhiều người đẹp Việt.', '16', '3');

--TABLE 'CONTACT'
INSERT INTO "SMARTSHOP"."CONTACT" (NAME, EMAIL, PHONE, FAX, ADDRESS) VALUES ('Công ty Cổ phần giải pháp và nguồn lực công nghệ ITSOL', 'itsol@gmail.com', '09563856385', '09563856385', 'Tòa nhà 3A, 82 Duy Tân, Cầu Giấy, Hà Nội');
INSERT INTO "SMARTSHOP"."CONTACT" (NAME, EMAIL, PHONE, FAX, ADDRESS) VALUES ('Tập đoàn NextTech', 'itsol@gmail.com', '09563856385', '09563856385', '18 Tam Trinh');

--TABLE 'FEEDBACK'
INSERT INTO "SMARTSHOP"."FEEDBACK" (NAME, EMAIL, PHONE, NOTE) VALUES ('Nguyễn Thế Tuân', 'tuan87@gmail.com', '09563856385', 'Đưa hàng nhanh, chất lượng ok, cảm thấy tốt.');
INSERT INTO "SMARTSHOP"."FEEDBACK" (NAME, EMAIL, PHONE, NOTE) VALUES ('Dương', 'duongml@gmail.com', '09563856385', 'Đưa hàng nhanh, chất lượng ok, cảm thấy tốt.');
