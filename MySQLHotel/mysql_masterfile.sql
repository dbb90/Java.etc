-- Drop DB if in use, create new DB, use said DB

DROP DATABASE IF EXISTS SGHotel;
CREATE DATABASE SGHotel;
USE SGHotel;

-- Creating our Type and room tables 
-- naming a table Type ran fine but messed with the Workbench parser, modified

CREATE TABLE RoomType

(Typeid INT NOT NULL,
TypeName VARCHAR(255),
PRIMARY KEY(Typeid)
);

CREATE TABLE Rooms

(RoomNum INT NOT NULL,
FloorNum INT NOT NULL,
MaxOcc INT NOT NULL,
RoomType INT NOT NULL,
PRIMARY KEY(RoomNum),
FOREIGN KEY(RoomType) REFERENCES RoomType(Typeid)
);

CREATE TABLE TypeRate(

TypeRateid INT NOT NULL,
Typeid INT NOT NULL,
Price NUMERIC(10,2),
DateStart DATE,
DateLast DATE,
PRIMARY KEY(TypeRateid),
FOREIGN KEY(Typeid)REFERENCES RoomType(Typeid));

create table Amenities(

Amenityid INT NOT NULL,
AmenityType VARCHAR(255),
Price NUMERIC(10,2),
PRIMARY KEY(Amenityid)
);

create table RoomsAmenities(

RoomsAmenitiesid INT,
Roomid INT NOT NULL,
Amenityid INT NOT NULL,
PRIMARY KEY(RoomsAmenitiesid),
FOREIGN KEY(Roomid) REFERENCES Rooms(RoomNum),
FOREIGN KEY(Amenityid) REFERENCES Amenities(Amenityid));

create table Customers(

Customerid INT NOT NULL,
phone VARCHAR(255),
email VARCHAR(255),
PRIMARY KEY(Customerid));

create table Guests(

Guestid INT NOT NULL,
name VARCHAR(255),
DateOfBirth date,
Customerid INT,
PRIMARY KEY(Guestid),
FOREIGN KEY(Customerid)REFERENCES Customers(Customerid)
);

create table Res(

Resid INT NOT NULL,
Customerid INT NOT NULL,
PRIMARY KEY(Resid),
FOREIGN KEY(Customerid) REFERENCES Guests(Guestid)
);

create table GuestRes(
guestid INT NOT NULL,
Resid INT NOT NULL,
FOREIGN KEY(Guestid) REFERENCES Guests(Guestid),
FOREIGN KEY(Resid) REFERENCES Res(Resid)
);

create table Promos(

Promoid INT NOT NULL,
PromoDesc VARCHAR(255) NOT NULL,
Discount INT NOT NULL,
IsPercent BOOLEAN,
DateStart DATE,
DateLast DATE,
PRIMARY KEY(PromoID)
);

create table AddOns(

AddOnid INT NOT NULL,
AddOnDesc VARCHAR(255),
AddonPrice NUMERIC(10,2),
PRIMARY KEY(AddOnid)
);


create table Bills(

Billid INT NOT NULL,
Resid INT NOT NULL,
Taxrate NUMERIC(10,2) NOT NULL,
Total NUMERIC(10,2) NOT NULL,
PRIMARY KEY(Billid),
FOREIGN KEY(Resid) REFERENCES Res(Resid)
);

insert into ROOMTYPE (Typeid, TypeName) values (1, 'Single');
insert into ROOMTYPE (Typeid, TypeName) values (2, 'Double');
insert into ROOMTYPE (Typeid, TypeName) values (3, 'Suite');
insert into ROOMTYPE (Typeid, TypeName) values (4, 'Suite Deluxe');
insert into ROOMTYPE (Typeid, TypeName) values (5, 'Budget');
insert into ROOMTYPE (Typeid, TypeName) values (6, 'Penthouse');
insert into ROOMTYPE (Typeid, TypeName) values (7, 'Penthouse Deluxe');
insert into ROOMTYPE (Typeid, TypeName) values (8, 'Penthouse Platinum Deluxe');


insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (1, 1, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (2, 1, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (3, 1, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (4, 1, 4, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (5, 1, 4, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (6, 1, 5, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (7, 1, 4, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (8, 1, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (9, 1, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (10, 1, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (11, 2, 2, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (12, 2, 4, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (13, 2, 2, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (14, 2, 2, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (15, 2, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (16, 2, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (17, 2, 1, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (18, 2, 1, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (19, 2, 4, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (20, 2, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (21, 3, 2, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (22, 3, 2, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (23, 3, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (24, 3, 4, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (25, 3, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (26, 3, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (27, 3, 2, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (28, 3, 2, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (29, 3, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (30, 3, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (31, 4, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (32, 4, 4, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (33, 4, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (34, 4, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (35, 4, 2, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (36, 4, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (37, 4, 2, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (38, 4, 4, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (39, 4, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (40, 4, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (41, 5, 4, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (42, 5, 2, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (43, 5, 2, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (44, 5, 2, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (45, 5, 2, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (46, 5, 4, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (47, 5, 4, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (48, 5, 6, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (49, 5, 6, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (50, 5, 6, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (51, 6, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (52, 6, 4, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (53, 6, 4, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (54, 6, 2, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (55, 6, 4, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (56, 6, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (57, 6, 2, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (58, 6, 2, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (59, 6, 2, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (60, 6, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (61, 7, 4, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (62, 7, 16, 8);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (63, 7, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (64, 7, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (65, 7, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (66, 7, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (67, 7, 2, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (68, 7, 2, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (69, 7, 4, 5);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (70, 7, 2, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (71, 8, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (72, 8, 4, 1);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (73, 8, 2, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (74, 8, 2, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (75, 8, 4, 2);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (76, 8, 4, 7);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (77, 8, 6, 4);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (78, 8, 4, 3);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (79, 8, 4, 6);
insert into ROOMS (RoomNum, FloorNum, MaxOcc, RoomType) values (80, 8, 2, 5);



INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (1, 7, 138, '2016-02-02 10:12:50', '2016-08-12 02:40:26');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (2, 4, 195, '2016-01-29 00:52:47', '2016-11-09 02:21:03');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (3, 2, 466, '2016-04-21 10:44:52', '2016-11-06 18:57:26');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (4, 2, 181, '2016-02-23 13:37:58', '2016-10-07 05:27:44');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (5, 4, 132, '2016-03-18 00:09:55', '2016-10-18 15:45:36');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (6, 5, 112, '2016-03-01 01:15:58', '2016-10-12 01:31:15');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (7, 4, 433, '2016-07-02 18:54:27', '2016-09-01 12:44:55');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (8, 3, 475, '2016-06-30 14:21:17', '2016-11-11 06:20:42');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (9, 2, 123, '2016-03-06 06:43:36', '2016-11-14 03:24:08');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (10, 3, 292, '2016-02-12 06:31:21', '2016-09-22 20:53:54');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (11, 3, 290, '2016-04-09 15:33:57', '2016-11-16 15:19:31');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (12, 4, 489, '2016-02-26 15:52:28', '2016-12-09 12:22:17');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (13, 8, 354, '2016-04-25 15:57:31', '2016-11-24 14:37:50');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (14, 5, 211, '2016-02-01 03:04:07', '2016-09-25 22:43:31');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (15, 4, 465, '2016-07-08 13:45:55', '2016-08-15 20:20:42');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (16, 6, 301, '2016-03-01 09:29:01', '2016-12-29 11:16:26');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (17, 7, 320, '2016-01-30 06:34:25', '2016-10-25 10:43:09');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (18, 2, 320, '2016-04-07 21:54:56', '2016-11-08 05:11:18');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (19, 3, 242, '2016-06-13 06:23:54', '2016-12-27 01:33:48');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (20, 3, 229, '2016-01-30 10:22:52', '2016-12-17 05:45:08');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (21, 1, 494, '2016-05-26 14:35:25', '2016-11-29 09:31:20');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (22, 5, 388, '2016-02-27 06:01:21', '2016-11-02 11:51:03');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (23, 1, 420, '2016-04-20 07:12:12', '2016-08-13 17:49:02');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (24, 6, 344, '2016-06-09 18:00:30', '2016-08-28 13:38:42');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (25, 8, 204, '2016-03-28 01:23:14', '2016-08-18 02:29:24');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (26, 7, 252, '2016-04-24 19:22:58', '2016-11-24 04:45:17');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (27, 8, 116, '2016-05-24 03:38:49', '2016-08-17 03:13:40');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (28, 4, 416, '2016-02-24 03:08:10', '2016-08-30 12:39:14');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (29, 5, 218, '2016-03-04 05:24:01', '2016-08-13 02:22:45');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (30, 2, 464, '2016-03-05 01:17:30', '2016-09-14 22:40:49');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (31, 5, 123, '2016-06-14 00:43:06', '2016-09-22 13:18:14');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (32, 5, 257, '2016-02-24 15:05:18', '2016-12-02 18:29:19');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (33, 6, 408, '2016-06-12 07:35:12', '2016-09-18 07:35:54');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (34, 3, 149, '2016-06-07 23:20:51', '2016-12-21 13:55:42');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (35, 8, 397, '2016-05-04 10:45:50', '2016-11-14 03:55:14');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (36, 3, 386, '2016-04-21 20:04:57', '2016-10-01 22:28:32');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (37, 7, 259, '2016-03-01 14:23:16', '2016-08-14 10:50:48');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (38, 5, 443, '2016-03-11 03:18:46', '2016-08-04 10:51:04');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (39, 2, 216, '2016-03-21 13:12:48', '2016-08-14 10:13:15');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (40, 3, 316, '2016-06-11 14:11:46', '2016-09-11 14:47:24');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (41, 3, 454, '2016-03-23 00:32:10', '2016-09-16 23:36:16');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (42, 2, 363, '2016-03-24 18:56:58', '2016-07-30 18:05:13');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (43, 3, 151, '2016-03-03 09:34:20', '2016-08-15 04:39:11');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (44, 4, 301, '2016-06-06 06:27:27', '2016-11-27 18:54:07');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (45, 7, 359, '2016-05-03 21:03:07', '2016-10-10 16:07:13');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (46, 5, 436, '2016-02-21 09:17:32', '2016-07-28 21:27:26');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (47, 3, 145, '2016-05-29 20:10:28', '2016-11-21 13:41:10');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (48, 5, 364, '2016-06-28 06:27:32', '2016-10-20 14:37:48');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (49, 8, 165, '2016-02-19 23:58:57', '2016-08-08 06:45:02');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (50, 8, 232, '2016-01-25 13:24:45', '2016-07-30 12:53:55');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (51, 7, 296, '2016-01-22 09:30:44', '2016-08-10 23:54:51');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (52, 7, 174, '2016-05-12 12:13:31', '2016-11-16 22:41:31');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (53, 1, 326, '2016-07-07 13:20:52', '2016-09-13 11:07:09');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (54, 8, 436, '2016-03-24 15:28:58', '2016-09-30 20:37:15');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (55, 1, 384, '2016-03-20 12:35:04', '2016-11-17 11:11:17');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (56, 5, 195, '2016-04-20 01:47:36', '2016-08-23 10:32:49');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (57, 5, 99, '2016-06-08 20:16:42', '2016-09-20 02:35:16');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (58, 4, 400, '2016-04-14 16:04:17', '2016-12-29 06:01:36');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (59, 2, 210, '2016-02-17 03:49:50', '2016-09-20 03:31:36');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (60, 4, 239, '2016-07-19 04:20:15', '2016-07-26 00:43:19');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (61, 1, 167, '2016-03-24 07:57:50', '2016-07-23 06:09:55');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (62, 1, 278, '2016-05-10 06:39:14', '2016-11-02 08:28:01');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (63, 6, 196, '2016-07-16 01:52:06', '2016-10-10 08:17:37');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (64, 5, 451, '2016-03-20 01:22:21', '2016-10-03 11:07:22');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (65, 4, 372, '2016-02-01 12:38:37', '2016-09-17 06:47:54');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (66, 5, 220, '2016-06-22 17:36:06', '2016-11-11 17:38:27');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (67, 3, 196, '2016-01-31 07:00:46', '2016-09-04 18:03:52');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (68, 6, 378, '2016-05-05 10:26:28', '2016-08-14 15:53:00');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (69, 7, 152, '2016-03-09 05:56:55', '2016-09-26 04:26:20');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (70, 7, 379, '2016-07-01 19:08:51', '2016-09-02 13:45:19');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (71, 8, 468, '2016-04-12 17:29:19', '2016-11-10 17:42:26');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (72, 5, 186, '2016-05-19 13:09:19', '2016-07-25 17:20:59');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (73, 6, 350, '2016-06-22 13:46:35', '2016-07-23 11:21:58');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (74, 2, 179, '2016-07-03 21:06:15', '2016-11-26 14:04:44');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (75, 5, 342, '2016-03-21 13:04:16', '2016-09-17 08:30:53');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (76, 1, 323, '2016-06-21 14:58:27', '2016-11-07 23:02:50');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (77, 1, 145, '2016-03-23 01:14:21', '2016-08-24 00:34:34');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (78, 8, 353, '2016-02-13 23:26:17', '2016-12-19 00:54:27');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (79, 8, 345, '2016-03-23 00:47:09', '2016-12-25 19:39:30');
INSERT INTO TYPERATE (TypeRateid, Typeid, price, DateStart, DateLast) VALUES (80, 1, 259, '2016-01-23 18:49:47', '2016-10-20 22:36:13');


INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (1, 'lacus purus aliquet at', 97.9);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (2, 'ante', 4.82);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (3, 'odio elementum eu interdum', 1.04);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (4, 'etiam vel augue vestibulum', 62.92);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (5, 'mi integer ac', 46.37);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (6, 'odio odio elementum', 47.34);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (7, 'vitae nisi nam', 6.78);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (8, 'vel sem sed', 80.69);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (9, 'posuere felis sed lacus', 62.81);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (10, 'in hac', 20.63);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (11, 'etiam pretium iaculis justo', 32.98);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (12, 'est et tempus', 95.74);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (13, 'ac tellus semper interdum', 16.28);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (14, 'hendrerit at vulputate vitae', 54.19);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (15, 'viverra pede', 93.94);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (16, 'felis sed', 80.86);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (17, 'pretium nisl ut volutpat', 71.97);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (18, 'vel', 26.75);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (19, 'posuere felis', 46.71);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (20, 'morbi a ipsum integer', 51.9);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (21, 'et magnis dis', 45.41);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (22, 'platea', 2.83);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (23, 'at', 77.87);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (24, 'varius integer', 19.6);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (25, 'id sapien', 91.13);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (26, 'in', 73.11);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (27, 'sed vel', 20.81);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (28, 'vel dapibus at diam', 45.29);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (29, 'elementum nullam varius nulla', 4.36);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (30, 'dui', 21.67);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (31, 'viverra diam vitae', 53.31);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (32, 'sit amet diam', 26.56);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (33, 'semper interdum mauris ullamcorper', 73.48);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (34, 'duis consequat', 31.96);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (35, 'elementum', 94.06);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (36, 'quisque arcu libero', 90.34);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (37, 'convallis', 6.92);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (38, 'dolor sit', 3.08);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (39, 'vivamus vestibulum', 20.0);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (40, 'convallis', 64.05);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (41, 'ante', 43.6);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (42, 'parturient montes nascetur', 35.8);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (43, 'mauris', 92.51);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (44, 'vestibulum', 39.84);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (45, 'id', 30.49);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (46, 'eu felis fusce posuere', 2.32);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (47, 'erat', 74.16);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (48, 'ornare consequat lectus in', 71.93);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (49, 'gravida sem praesent', 75.61);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (50, 'tortor risus', 35.66);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (51, 'pede morbi', 56.0);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (52, 'proin interdum mauris', 40.34);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (53, 'pede', 54.87);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (54, 'eget', 5.27);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (55, 'massa id nisl venenatis', 76.54);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (56, 'rutrum nulla nunc', 55.88);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (57, 'blandit non', 5.93);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (58, 'cras pellentesque volutpat dui', 88.64);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (59, 'at', 82.98);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (60, 'justo', 50.46);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (61, 'ac', 66.7);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (62, 'eget', 38.16);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (63, 'pretium iaculis', 63.89);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (64, 'in magna bibendum', 22.8);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (65, 'sagittis', 66.77);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (66, 'ac', 10.96);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (67, 'eros suspendisse accumsan', 22.19);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (68, 'blandit lacinia erat', 79.15);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (69, 'eget', 12.48);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (70, 'vestibulum vestibulum ante ipsum', 25.66);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (71, 'mauris', 96.15);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (72, 'ultrices', 90.26);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (73, 'tellus semper', 90.73);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (74, 'pellentesque at nulla', 5.33);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (75, 'mi', 3.54);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (76, 'id nisl', 24.88);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (77, 'luctus rutrum nulla tellus', 43.94);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (78, 'purus eu magna', 42.4);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (79, 'odio elementum eu', 28.02);
INSERT INTO AMENITIES (Amenityid, AmenityType, Price) VALUES (80, 'eu massa donec dapibus', 65.31);


INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (1, 14, 63);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (2, 9, 10);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (3, 65, 16);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (4, 66, 47);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (5, 25, 67);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (6, 15, 66);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (7, 3, 64);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (8, 41, 69);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (9, 4, 51);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (10, 47, 58);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (11, 1, 15);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (12, 46, 25);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (13, 65, 61);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (14, 53, 39);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (15, 61, 70);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (16, 67, 60);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (17, 41, 64);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (18, 36, 5);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (19, 62, 27);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (20, 42, 54);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (21, 40, 55);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (22, 55, 33);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (23, 53, 4);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (24, 27, 48);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (25, 59, 16);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (26, 57, 66);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (27, 2, 51);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (28, 49, 63);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (29, 23, 54);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (30, 1, 56);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (31, 66, 74);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (32, 46, 53);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (33, 66, 70);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (34, 71, 15);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (35, 6, 31);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (36, 20, 59);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (37, 72, 34);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (38, 5, 8);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (39, 58, 41);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (40, 78, 21);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (41, 45, 75);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (42, 53, 11);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (43, 41, 66);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (44, 4, 7);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (45, 27, 9);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (46, 73, 63);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (47, 21, 56);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (48, 75, 31);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (49, 75, 31);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (50, 39, 37);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (51, 67, 23);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (52, 56, 77);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (53, 14, 47);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (54, 7, 40);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (55, 24, 20);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (56, 31, 4);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (57, 39, 12);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (58, 7, 54);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (59, 6, 10);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (60, 32, 72);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (61, 51, 36);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (62, 5, 5);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (63, 12, 29);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (64, 77, 56);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (65, 49, 71);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (66, 29, 4);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (67, 70, 53);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (68, 36, 79);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (69, 49, 76);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (70, 75, 50);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (71, 60, 21);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (72, 67, 70);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (73, 15, 38);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (74, 80, 20);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (75, 20, 43);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (76, 19, 65);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (77, 24, 1);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (78, 32, 21);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (79, 12, 70);
INSERT INTO ROOMSAMENITIES (RoomsAmenitiesid, Roomid, Amenityid) VALUES (80, 50, 24);

INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (1, null, 'abroad0@netvibes.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (2, '547 288 8839', 'dgoudy1@hostgator.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (3, '730 648 8688', 'vdeedes2@yolasite.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (4, '229 677 2334', 'fleat3@pbs.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (5, '172 291 5361', 'emcchruiter4@phpbb.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (6, '913 509 9492', 'rfidilis5@globo.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (7, '356 157 4685', 'yparbrook6@boston.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (8, '414 428 4966', 'mmanifould7@friendfeed.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (9, '617 285 4360', 'koconnolly8@edublogs.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (10, '157 994 5458', null);
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (11, '787 494 6934', 'oguesta@dot.gov');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (12, null, 'phaneyb@unesco.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (13, '388 372 8418', 'jaristidec@prweb.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (14, '583 438 7945', 'ikingswelld@qq.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (15, '789 649 1578', 'finnmane@nasa.gov');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (16, null, 'kguerrof@gov.uk');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (17, '185 744 3725', 'wcitrineg@dell.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (18, '698 418 1061', 'odymickh@meetup.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (19, '897 833 2769', 'mmcshiriei@list-manage.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (20, '497 198 3155', 'tgadsdonj@360.cn');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (21, '790 910 9093', 'wcusickk@nba.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (22, null, 'qbehrensl@miitbeian.gov.cn');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (23, '591 555 4277', 'emarienm@army.mil');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (24, '635 442 7409', 'mdickensonn@bigcartel.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (25, '653 785 4971', 'kbelsono@tumblr.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (26, '999 630 2930', 'torrittp@virginia.edu');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (27, '919 738 8771', 'svillarq@tuttocitta.it');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (28, '422 520 4582', 'sstandonr@nhs.uk');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (29, '860 321 0213', 'fscarsbricks@sfgate.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (30, '462 663 2407', 'spratet@mozilla.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (31, '719 204 6245', 'bsichardtu@webs.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (32, '988 452 4900', 'awoodyerv@google.nl');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (33, '181 254 4878', 'lcudmorew@multiply.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (34, null, 'kloanx@csmonitor.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (35, '359 707 7095', 'bnansony@ebay.co.uk');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (36, '414 407 2676', 'tcourtesz@tmall.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (37, '911 132 1415', 'mhadland10@cornell.edu');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (38, '318 473 2425', 'nhardes11@washingtonpost.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (39, '387 457 2716', 'ibassano12@smh.com.au');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (40, '331 551 4652', 'kmcbeath13@vk.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (41, '514 614 3285', 'jsaing14@mashable.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (42, '121 956 0831', 'sdobrowlski15@hc360.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (43, '698 534 3255', 'traynton16@mashable.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (44, '624 246 3572', 'phartnell17@simplemachines.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (45, '980 778 9618', 'mstratiff18@craigslist.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (46, '444 204 6184', 'amarco19@domainmarket.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (47, null, 'ddufaire1a@tinyurl.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (48, '912 613 0914', 'efishburn1b@theguardian.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (49, '563 159 5200', 'dmckechnie1c@bravesites.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (50, '243 763 3983', 'ubendel1d@canalblog.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (51, '594 565 3478', 'jbulger1e@yellowbook.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (52, '694 503 3730', 'knancekivell1f@unicef.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (53, '728 835 9979', 'pheeran1g@yale.edu');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (54, '201 219 5593', 'sashtonhurst1h@trellian.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (55, '438 452 9983', null);
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (56, '884 864 8712', 'cleyband1j@naver.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (57, '207 910 1469', 'tshelmardine1k@businessinsider.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (58, '679 663 6837', 'mserotsky1l@nasa.gov');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (59, '633 807 2048', 'rosbourne1m@stanford.edu');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (60, '110 789 8956', 'aavann1n@clickbank.net');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (61, '483 763 6349', 'fphilliskirk1o@archive.org');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (62, '133 511 0101', 'dklimus1p@princeton.edu');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (63, '831 829 7485', null);
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (64, '244 101 6284', 'cgarshore1r@go.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (65, '233 469 3950', 'lsindle1s@i2i.jp');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (66, '961 731 6552', 'mwaine1t@independent.co.uk');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (67, '758 518 8653', 'eever1u@delicious.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (68, '807 585 1772', 'efernez1v@dailymail.co.uk');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (69, null, 'chendonson1w@last.fm');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (70, '804 110 2418', 'tboddington1x@webnode.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (71, null, 'jprendergrass1y@auda.org.au');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (72, '189 686 7843', 'bduhig1z@jalbum.net');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (73, null, 'dbondley20@time.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (74, null, 'bpindar21@paypal.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (75, '854 659 1178', 'saspin22@buzzfeed.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (76, '993 362 5127', 'fmuldoon23@google.nl');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (77, '578 900 4694', 'scarney24@fc2.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (78, '393 825 3775', 'rstuckey25@biglobe.ne.jp');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (79, '289 945 6965', 'shanshawe26@sciencedirect.com');
INSERT INTO CUSTOMERS (Customerid, Phone, email) VALUES (80, '573 498 0374', 'cbartali27@google.com.hk');


INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (1, 'Sherlocke Leward', '1953-08-05 06:47:30', 25);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (2, 'Stern Tessyman', '2009-12-21 07:46:06', 9);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (3, 'Carolus Loughton', '2002-08-29 23:24:34', 38);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (4, 'Richardo Burnitt', '1989-06-22 21:06:42', 11);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (5, 'Inna Pirson', '2005-10-29 07:37:59', 22);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (6, 'Else Balser', '1968-05-22 05:32:14', 72);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (7, 'Gearalt Brech', '1957-01-21 12:15:53', 14);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (8, 'Zachary Le Marquis', '1950-02-19 15:42:03', 65);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (9, 'Estella Ormond', '1949-02-23 02:14:11', 35);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (10, 'Leoline Luetchford', '2001-10-15 22:44:31', 4);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (11, 'Arabela Tournay', '1993-05-28 19:58:18', 51);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (12, 'Nike Grimsdike', '1989-01-09 07:13:06', 4);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (13, 'Fonzie Runacres', '2009-04-01 12:03:24', 75);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (14, 'Langston Hudless', '1995-02-01 15:30:03', 58);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (15, 'Daryn Triplow', '1948-06-29 16:48:00', 23);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (16, 'Pearle Georgievski', '1957-10-16 23:12:57', 16);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (17, 'Winnah Pagelsen', '1961-05-01 23:07:51', 45);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (18, 'Locke Alexis', '1953-10-18 19:13:57', 36);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (19, 'Delmar Feeham', '1949-06-20 13:42:56', 77);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (20, null, '1945-04-19 21:04:01', 7);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (21, 'Barny Gurney', '2001-03-12 06:14:33', 37);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (22, 'Efrem Fernehough', '1965-07-05 12:48:35', 12);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (23, 'Archibold Broscombe', '1995-08-28 19:51:22', 49);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (24, 'Kaylyn Ridewood', '1978-04-10 19:27:26', 34);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (25, 'Kean Giraudoux', '2000-01-15 20:42:00', 46);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (26, 'Cacilia Geldert', '1960-02-14 09:44:22', 32);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (27, 'Ophelie Birtchnell', '2009-04-07 04:51:41', 64);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (28, 'Davidson Derbyshire', '1985-07-11 15:55:27', 38);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (29, 'Rossy Michael', '1963-11-13 18:27:56', 15);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (30, 'Chelsey Drescher', '1967-09-11 04:51:42', 32);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (31, 'Jerrome Tippell', '1968-05-19 04:36:50', 80);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (32, 'Vassily Cassin', '1984-08-16 15:07:22', 51);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (33, 'Gianna Laxston', '1976-04-25 11:17:58', 61);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (34, 'Tibold Colls', '1956-09-02 22:18:21', 26);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (35, 'Bailie Jermyn', '1960-06-02 03:29:31', 64);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (36, 'Blake Francesch', '1966-09-07 13:03:23', 19);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (37, 'Floris Sarver', '1971-11-30 11:15:17', 34);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (38, 'Artus Ranken', '1993-04-15 04:13:12', 59);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (39, 'Rhiamon Brokenbrow', '1982-08-18 07:40:46', 52);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (40, 'Grethel Beincken', '1961-05-23 00:14:12', 52);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (41, 'Lonnard Fawdrey', '1994-12-08 21:21:39', 21);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (42, 'Alonso Raeside', '1992-01-13 16:23:36', 45);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (43, 'Kelcy Thickin', '1988-07-05 18:11:58', 20);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (44, 'Meggie Birdwhistell', '1994-02-22 07:47:09', 35);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (45, 'Olivette Brumbie', '1996-03-19 00:13:00', 9);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (46, 'Zia Le Grand', '1965-05-14 21:42:07', 62);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (47, 'Cloe Goodyear', '1976-09-13 18:45:47', 37);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (48, 'Tera Haslock(e)', '1963-10-12 00:02:19', 79);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (49, 'Cornelius Keays', null, null);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (50, 'Salomone Partkya', '2006-11-04 10:08:37', 8);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (51, 'Lilian Norfolk', '1998-07-11 08:10:18', 23);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (52, 'Melisent Thwaites', '2004-03-14 00:35:54', 12);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (53, 'Lindsay Paulino', '2007-03-02 04:58:28', 44);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (54, 'Stewart Duggary', '1954-08-08 05:23:44', 57);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (55, 'Susi Lesor', '1954-01-29 23:51:55', 29);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (56, 'Ennis Feighney', '2006-08-13 02:57:24', 62);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (57, 'Cammie Caldaro', '1977-02-23 12:25:49', 67);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (58, 'Kara Curro', '1981-02-17 01:58:56', 30);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (59, 'Mona Fretson', '1949-09-04 04:35:36', 5);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (60, 'Orson Dolton', '1954-06-05 13:29:06', 4);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (61, 'Marrissa Marginson', '1959-06-15 22:26:14', 19);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (62, 'Andromache Mueller', '1990-05-09 08:43:37', 29);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (63, 'Hynda Enderson', '1982-02-16 13:17:14', 5);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (64, 'Reba Micheu', '2007-11-07 07:10:56', 41);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (65, 'Lucille Keslake', '1953-03-10 04:51:06', 11);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (66, 'Irene Ludlom', '1978-10-13 09:43:36', 77);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (67, 'Garfield Brunt', '1956-06-28 19:18:57', 73);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (68, 'Andee Surcomb', '1998-08-22 21:29:23', 75);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (69, 'Gavra Mallebone', '1994-10-08 12:04:01', 10);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (70, 'Tove De Bruijn', '1992-07-04 00:04:43', 38);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (71, 'Rollo Bigland', null, null);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (72, null, '1969-02-03 22:16:04', 40);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (73, 'Ezri Challener', '2006-10-07 11:34:38', 32);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (74, 'Joanna Hamly', '1989-10-27 06:28:47', 20);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (75, 'Griz Benitez', '1954-04-06 00:59:42', 44);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (76, 'Sayre Spinige', '1961-08-10 19:15:02', 64);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (77, 'Alastair Ismay', '1960-09-27 02:15:34', 24);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (78, 'Buddy Sidsaff', '1947-11-06 04:21:59', 10);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (79, 'Reinaldos Bea', '1993-11-03 10:07:25', 3);
INSERT INTO GUESTS (Guestid, Name, DateOfBirth, Customerid) VALUES (80, 'Cozmo Nyssen', '2008-10-15 14:54:31', 66);

insert into RES (Resid, Customerid) values (1, 17);
insert into RES (Resid, Customerid) values (2, 54);
insert into RES (Resid, Customerid) values (3, 52);
insert into RES (Resid, Customerid) values (4, 25);
insert into RES (Resid, Customerid) values (5, 15);
insert into RES (Resid, Customerid) values (6, 21);
insert into RES (Resid, Customerid) values (7, 37);
insert into RES (Resid, Customerid) values (8, 71);
insert into RES (Resid, Customerid) values (9, 18);
insert into RES (Resid, Customerid) values (10, 28);
insert into RES (Resid, Customerid) values (11, 62);
insert into RES (Resid, Customerid) values (12, 42);
insert into RES (Resid, Customerid) values (13, 51);
insert into RES (Resid, Customerid) values (14, 27);
insert into RES (Resid, Customerid) values (15, 75);
insert into RES (Resid, Customerid) values (16, 73);
insert into RES (Resid, Customerid) values (17, 16);
insert into RES (Resid, Customerid) values (18, 3);
insert into RES (Resid, Customerid) values (19, 47);
insert into RES (Resid, Customerid) values (20, 55);
insert into RES (Resid, Customerid) values (21, 16);
insert into RES (Resid, Customerid) values (22, 38);
insert into RES (Resid, Customerid) values (23, 21);
insert into RES (Resid, Customerid) values (24, 37);
insert into RES (Resid, Customerid) values (25, 61);
insert into RES (Resid, Customerid) values (26, 75);
insert into RES (Resid, Customerid) values (27, 56);
insert into RES (Resid, Customerid) values (28, 36);
insert into RES (Resid, Customerid) values (29, 64);
insert into RES (Resid, Customerid) values (30, 73);
insert into RES (Resid, Customerid) values (31, 68);
insert into RES (Resid, Customerid) values (32, 76);
insert into RES (Resid, Customerid) values (33, 51);
insert into RES (Resid, Customerid) values (34, 38);
insert into RES (Resid, Customerid) values (35, 74);
insert into RES (Resid, Customerid) values (36, 3);
insert into RES (Resid, Customerid) values (37, 50);
insert into RES (Resid, Customerid) values (38, 65);
insert into RES (Resid, Customerid) values (39, 71);
insert into RES (Resid, Customerid) values (40, 45);
insert into RES (Resid, Customerid) values (41, 72);
insert into RES (Resid, Customerid) values (42, 12);
insert into RES (Resid, Customerid) values (43, 47);
insert into RES (Resid, Customerid) values (44, 5);
insert into RES (Resid, Customerid) values (45, 15);
insert into RES (Resid, Customerid) values (46, 59);
insert into RES (Resid, Customerid) values (47, 46);
insert into RES (Resid, Customerid) values (48, 47);
insert into RES (Resid, Customerid) values (49, 2);
insert into RES (Resid, Customerid) values (50, 52);
insert into RES (Resid, Customerid) values (51, 13);
insert into RES (Resid, Customerid) values (52, 23);
insert into RES (Resid, Customerid) values (53, 10);
insert into RES (Resid, Customerid) values (54, 68);
insert into RES (Resid, Customerid) values (55, 2);
insert into RES (Resid, Customerid) values (56, 64);
insert into RES (Resid, Customerid) values (57, 75);
insert into RES (Resid, Customerid) values (58, 14);
insert into RES (Resid, Customerid) values (59, 77);
insert into RES (Resid, Customerid) values (60, 60);
insert into RES (Resid, Customerid) values (61, 3);
insert into RES (Resid, Customerid) values (62, 30);
insert into RES (Resid, Customerid) values (63, 64);
insert into RES (Resid, Customerid) values (64, 56);
insert into RES (Resid, Customerid) values (65, 59);
insert into RES (Resid, Customerid) values (66, 77);
insert into RES (Resid, Customerid) values (67, 38);
insert into RES (Resid, Customerid) values (68, 50);
insert into RES (Resid, Customerid) values (69, 37);
insert into RES (Resid, Customerid) values (70, 1);
insert into RES (Resid, Customerid) values (71, 75);
insert into RES (Resid, Customerid) values (72, 78);
insert into RES (Resid, Customerid) values (73, 11);
insert into RES (Resid, Customerid) values (74, 60);
insert into RES (Resid, Customerid) values (75, 58);
insert into RES (Resid, Customerid) values (76, 31);
insert into RES (Resid, Customerid) values (77, 32);
insert into RES (Resid, Customerid) values (78, 48);
insert into RES (Resid, Customerid) values (79, 30);
insert into RES (Resid, Customerid) values (80, 65);




INSERT INTO GUESTRES (Guestid, Resid) VALUES (60, 73);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (37, 1);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (50, 70);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (5, 29);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (2, 17);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (4, 73);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (71, 34);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (73, 77);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (45, 65);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (6, 44);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (17, 78);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (47, 48);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (16, 9);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (71, 51);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (78, 6);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (72, 58);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (32, 57);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (66, 17);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (19, 38);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (52, 69);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (64, 13);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (12, 22);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (53, 70);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (70, 12);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (67, 2);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (27, 18);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (80, 66);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (24, 26);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (1, 19);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (30, 15);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (22, 33);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (31, 1);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (79, 58);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (75, 22);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (15, 22);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (27, 51);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (3, 60);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (27, 35);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (75, 49);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (44, 43);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (16, 46);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (3, 56);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (65, 68);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (27, 31);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (12, 42);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (51, 41);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (1, 58);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (24, 23);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (66, 78);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (77, 55);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (55, 27);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (25, 30);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (64, 64);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (73, 67);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (5, 39);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (37, 45);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (29, 67);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (12, 41);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (21, 67);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (64, 64);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (15, 34);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (14, 22);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (47, 19);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (10, 41);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (6, 31);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (44, 44);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (50, 21);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (37, 62);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (36, 44);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (48, 60);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (51, 66);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (8, 14);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (43, 27);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (64, 69);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (37, 49);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (49, 77);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (49, 73);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (24, 23);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (35, 66);
INSERT INTO GUESTRES (Guestid, Resid) VALUES (8, 49);


insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (1, 'eros', 21, true, '2016-07-26 04:19:43', '2017-08-09 07:28:14');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (2, 'metus vitae', 43, true, '2016-09-13 18:00:53', '2016-09-04 05:49:27');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (3, 'dui', 29, false, '2016-08-29 11:17:49', '2016-12-06 09:43:35');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (4, 'mus vivamus', 12, true, '2016-04-23 16:52:17', '2017-09-09 22:58:00');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (5, 'non mi integer ac', 45, false, '2017-03-05 15:53:22', '2016-07-28 05:41:56');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (6, 'platea dictumst morbi', 46, false, '2017-04-21 00:42:03', '2017-10-20 02:48:12');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (7, 'eleifend quam a', 15, true, '2016-12-16 23:08:02', '2017-11-08 19:39:19');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (8, 'curabitur', 27, false, '2016-09-12 22:32:26', '2017-02-25 12:34:37');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (9, 'praesent id', 21, false, '2016-11-23 20:45:22', '2017-07-14 13:32:18');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (10, 'curabitur in', 46, true, '2017-01-17 06:43:27', '2016-09-17 09:26:17');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (11, 'volutpat in congue etiam', 38, false, '2016-07-15 18:00:27', '2017-05-07 08:43:10');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (12, 'dictumst maecenas ut massa', 7, false, '2016-03-16 00:59:06', '2017-01-18 18:48:29');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (13, 'vitae', 24, false, '2016-06-01 23:52:15', '2017-11-15 08:44:19');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (14, 'vitae quam suspendisse potenti', 28, true, '2016-08-26 10:36:04', '2017-09-02 02:06:43');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (15, 'mauris laoreet', 8, true, '2017-01-08 10:50:39', '2017-07-27 20:55:31');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (16, 'lectus suspendisse potenti', 18, false, '2016-01-30 09:26:08', '2017-08-19 03:48:29');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (17, 'dapibus nulla suscipit', 15, true, '2016-01-15 10:48:19', '2016-08-28 17:45:09');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (18, 'eget rutrum at lorem', 1, false, '2017-03-06 09:56:57', '2017-09-05 11:29:44');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (19, 'pellentesque', 23, true, '2017-03-19 14:48:17', '2017-04-11 19:54:35');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (20, 'pede justo lacinia eget', 9, false, '2017-02-26 20:22:36', '2017-06-19 23:42:01');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (21, 'id', 18, true, '2017-03-07 01:39:42', '2017-07-06 01:02:32');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (22, 'in', 17, false, '2016-04-07 10:33:42', '2016-12-04 06:22:51');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (23, 'mauris ullamcorper purus sit', 20, true, '2016-02-29 15:57:02', '2016-07-27 05:00:39');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (24, 'urna', 7, true, '2017-01-28 12:40:35', '2017-09-14 17:34:27');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (25, 'quam nec dui luctus', 17, false, '2016-05-15 05:41:26', '2016-09-24 06:26:19');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (26, 'curabitur', 12, false, '2017-03-18 09:31:23', '2017-07-22 15:51:43');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (27, 'ante ipsum primis', 48, true, '2017-03-22 14:49:43', '2016-08-22 02:01:31');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (28, 'eros viverra eget', 4, false, '2017-03-18 21:19:14', '2017-10-07 19:14:54');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (29, 'sapien', 8, true, '2016-02-09 10:31:50', '2016-08-22 15:02:15');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (30, 'amet erat', 34, true, '2016-10-29 21:44:15', '2017-02-21 20:37:14');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (31, 'sit amet', 44, false, '2017-06-19 01:13:14', '2017-08-11 02:49:31');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (32, 'vel nisl duis ac', 7, false, '2016-07-13 23:20:20', '2017-02-03 01:51:21');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (33, 'sapien dignissim', 35, false, '2016-01-11 02:51:56', '2017-09-24 16:43:51');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (34, 'pretium', 33, true, '2016-04-12 09:43:59', '2017-09-02 12:48:24');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (35, 'in', 27, true, '2016-09-24 14:37:41', '2017-07-06 01:46:43');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (36, 'vel ipsum', 37, true, '2016-12-29 17:45:52', '2016-10-23 04:50:18');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (37, 'luctus rutrum nulla tellus', 20, false, '2017-02-06 03:09:41', '2016-07-27 16:45:03');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (38, 'orci luctus', 27, true, '2016-04-04 17:36:28', '2017-02-24 06:21:40');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (39, 'erat', 27, true, '2016-11-19 09:05:41', '2017-10-28 04:40:20');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (40, 'cursus urna', 29, false, '2017-05-07 05:47:57', '2017-08-03 23:47:17');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (41, 'eu', 17, false, '2016-12-05 05:02:25', '2017-11-07 06:59:36');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (42, 'amet eros suspendisse accumsan', 10, true, '2016-08-11 03:06:09', '2016-09-21 20:25:46');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (43, 'enim in', 13, false, '2016-12-08 08:36:56', '2016-09-14 01:43:51');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (44, 'orci eget', 17, true, '2017-02-23 15:14:03', '2016-10-27 13:53:24');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (45, 'risus praesent', 19, true, '2016-02-17 02:52:39', '2017-09-07 18:05:59');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (46, 'phasellus id', 36, true, '2017-01-02 02:56:59', '2016-10-25 15:57:19');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (47, 'tincidunt nulla', 2, true, '2016-03-02 13:44:00', '2017-01-29 13:09:13');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (48, 'euismod scelerisque quam turpis', 33, true, '2016-06-13 00:41:39', '2017-02-10 16:59:42');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (49, 'sapien urna pretium', 15, true, '2016-12-11 05:43:01', '2017-04-11 17:56:38');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (50, 'amet nunc viverra', 3, true, '2017-01-04 05:46:36', '2017-07-30 10:20:55');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (51, 'in magna', 33, true, '2017-01-10 01:09:26', '2016-10-03 17:16:40');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (52, 'vel sem sed', 18, false, '2016-08-30 00:24:45', '2016-07-09 19:17:12');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (53, 'integer ac leo', 41, false, '2016-11-26 09:24:55', '2016-12-10 00:49:39');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (54, 'nullam', 37, false, '2016-11-16 05:54:35', '2017-04-18 09:50:07');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (55, 'consequat varius integer ac', 26, true, '2016-01-03 08:39:29', '2017-01-17 14:51:42');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (56, 'nascetur ridiculus mus etiam', 45, false, '2016-10-25 11:06:21', '2017-01-28 14:32:12');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (57, 'consequat nulla nisl nunc', 37, true, '2016-10-27 23:31:42', '2017-01-06 23:17:32');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (58, 'amet turpis elementum', 35, false, '2016-12-23 06:35:34', '2017-04-17 23:49:35');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (59, 'augue', 47, true, '2017-06-01 04:01:50', '2017-08-29 13:13:04');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (60, 'et eros vestibulum ac', 22, true, '2017-04-10 14:05:03', '2017-05-08 10:31:25');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (61, 'aliquam', 27, true, '2016-04-30 16:37:20', '2016-10-23 00:24:12');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (62, 'lobortis vel dapibus at', 49, false, '2017-02-05 00:16:49', '2017-06-17 18:50:55');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (63, 'elit ac nulla sed', 7, false, '2016-12-28 23:20:53', '2017-11-07 17:05:49');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (64, 'eu felis fusce posuere', 17, false, '2016-07-11 11:59:23', '2017-05-16 17:31:31');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (65, 'nunc nisl duis bibendum', 47, false, '2017-05-26 12:02:05', '2017-09-18 09:33:41');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (66, 'eleifend', 19, false, '2016-01-23 05:23:00', '2016-10-30 08:32:20');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (67, 'erat fermentum justo', 37, true, '2016-08-14 09:06:22', '2017-05-17 19:18:52');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (68, 'egestas metus aenean fermentum', 27, true, '2016-08-10 17:10:19', '2016-12-05 00:09:32');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (69, 'nulla integer pede', 25, true, '2017-01-19 02:58:24', '2017-12-07 15:50:33');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (70, 'dictumst morbi vestibulum velit', 9, true, '2017-06-20 07:55:24', '2017-12-02 23:37:15');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (71, 'convallis nunc proin', 43, false, '2017-02-14 17:59:19', '2016-12-08 14:41:23');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (72, 'duis mattis egestas', 26, false, '2017-01-04 13:24:57', '2016-12-02 13:44:24');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (73, 'vulputate elementum nullam', 21, true, '2017-01-17 08:30:32', '2016-08-07 22:23:30');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (74, 'in felis eu', 37, true, '2016-06-23 03:48:59', '2016-12-12 19:21:47');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (75, 'tincidunt eu', 33, true, '2016-05-27 23:27:08', '2016-10-08 21:34:23');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (76, 'quis orci nullam molestie', 2, true, '2017-03-04 19:23:59', '2016-10-08 09:26:25');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (77, 'porttitor', 36, false, '2016-12-09 12:44:02', '2017-09-03 21:10:39');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (78, 'tempus', 48, false, '2017-05-07 21:31:21', '2017-01-07 05:36:00');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (79, 'dui maecenas', 7, false, '2016-11-14 00:51:57', '2016-09-29 19:29:00');
insert into PROMOS (Promoid, PromoDesc, Discount, IsPercent, DateStart, DateLast) values (80, 'vitae consectetuer eget rutrum', 11, true, '2016-02-14 08:04:11', '2017-08-09 14:38:30');




INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (1, 'id lobortis convallis tortor', 38186.86);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (2, 'porta', 16777.73);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (3, 'ut tellus nulla', 14675.21);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (4, 'id consequat in consequat', 6709.53);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (5, 'mollis molestie', 27610.49);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (6, 'consequat varius integer ac', 35143.72);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (7, 'morbi porttitor lorem id', 19201.07);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (8, 'integer tincidunt', 47710.95);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (9, 'nulla facilisi', 2558.9);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (10, 'sagittis', 40429.61);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (11, 'nulla nunc purus', 36460.1);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (12, 'nulla', 26527.19);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (13, 'id lobortis convallis', 42616.55);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (14, 'vestibulum', 3448.49);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (15, 'convallis', 2030.02);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (16, 'sapien quis', 30471.74);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (17, 'accumsan tortor quis turpis', 3475.95);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (18, 'vel accumsan tellus nisi', 689.99);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (19, 'parturient montes nascetur', 24515.1);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (20, 'lorem', 39152.34);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (21, 'volutpat sapien', 19040.59);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (22, 'lobortis convallis tortor risus', 1287.45);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (23, 'blandit nam nulla', 36542.98);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (24, 'ipsum dolor sit amet', 31530.87);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (25, 'vitae', 40751.66);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (26, 'eu', 37145.21);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (27, 'donec semper', 20195.9);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (28, 'in faucibus orci luctus', 10191.16);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (29, 'eleifend luctus ultricies', 32363.23);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (30, 'gravida sem praesent', null);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (31, 'pede ac diam', 18851.55);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (32, 'ultrices posuere', 8645.23);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (33, 'potenti in', 16443.56);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (34, 'integer aliquet massa id', 11332.44);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (35, 'elit', 1439.09);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (36, 'sagittis dui vel', 27852.05);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (37, 'venenatis', 4233.37);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (38, 'semper', 14350.78);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (39, 'magna ac consequat metus', 36155.94);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (40, 'dui maecenas', 14349.71);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (41, 'pellentesque at nulla', 47343.2);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (42, 'at', 28989.58);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (43, 'odio', 11677.54);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (44, 'potenti', 10067.86);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (45, 'in', 19562.9);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (46, 'diam', 6124.24);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (47, 'justo', 48964.52);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (48, 'morbi', 17709.75);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (49, 'duis', 40995.66);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (50, 'lacinia aenean sit', null);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (51, 'nulla ultrices aliquet maecenas', 26067.77);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (52, 'nec nisi', 44210.32);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (53, 'lobortis vel', 35703.27);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (54, 'consequat metus', 25897.99);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (55, 'elementum pellentesque quisque porta', 3549.97);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (56, 'lobortis', 26401.83);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (57, 'sollicitudin vitae consectetuer eget', 19039.31);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (58, 'urna ut tellus', 48335.11);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (59, 'turpis', 44508.14);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (60, 'vel est donec odio', 25004.92);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (61, 'velit', 18935.92);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (62, 'lectus', 24644.47);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (63, 'eget elit', 2695.96);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (64, 'orci', 40470.93);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (65, 'convallis morbi odio', 13646.9);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (66, 'dictumst maecenas ut massa', 41920.51);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (67, 'est et', 26250.37);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (68, 'eleifend luctus ultricies', null);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (69, 'consequat', 22518.63);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (70, 'turpis eget elit sodales', 31183.43);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (71, 'lacinia', 31857.28);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (72, 'lorem', null);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (73, 'vivamus in', 17452.49);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (74, 'ultrices libero non mattis', null);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (75, 'dictumst morbi', 44450.07);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (76, 'lobortis', 29553.23);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (77, 'mollis', 26734.16);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (78, 'aenean', 41016.33);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (79, 'habitasse platea', 16089.32);
INSERT INTO ADDONS (AddOnid, AddOnDesc, AddOnPrice) VALUES (80, 'ullamcorper augue a suscipit', 18076.66);


INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (1, 10, 11.99, 2108.19);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (2, 59, 8.23, 1551.9);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (3, 58, 19.94, 1768.07);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (4, 66, 13.84, 767.63);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (5, 17, 22.32, 978.21);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (6, 68, 14.33, 2709.29);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (7, 45, 22.28, 2871.34);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (8, 22, 13.96, 700.88);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (9, 63, 14.04, 1824.02);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (10, 38, 7.16, 460.61);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (11, 49, 17.42, 846.57);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (12, 75, 19.64, 236.43);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (13, 5, 16.94, 2248.17);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (14, 68, 0.79, 1789.11);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (15, 50, 8.29, 2735.49);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (16, 41, 11.47, 1161.33);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (17, 51, 10.15, 1029.41);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (18, 1, 14.38, 2144.32);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (19, 34, 13.87, 1223.9);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (20, 52, 4.76, 1141.11);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (21, 38, 10.87, 849.28);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (22, 48, 2.23, 467.62);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (23, 31, 4.16, 1275.32);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (24, 12, 20.82, 225.66);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (25, 74, 8.92, 665.72);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (26, 12, 2.91, 521.51);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (27, 66, 3.33, 1416.62);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (28, 57, 17.46, 2574.12);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (29, 18, 11.69, 356.8);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (30, 55, 10.13, 718.53);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (31, 53, 12.59, 1411.49);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (32, 27, 7.19, 2995.04);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (33, 75, 6.92, 876.32);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (34, 11, 0.66, 576.91);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (35, 71, 20.07, 1366.66);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (36, 22, 7.73, 1171.9);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (37, 3, 10.46, 858.58);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (38, 45, 19.1, 412.56);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (39, 5, 5.81, 912.62);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (40, 76, 15.85, 375.48);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (41, 29, 18.55, 2472.48);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (42, 51, 9.26, 955.19);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (43, 69, 6.75, 845.55);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (44, 76, 3.49, 261.3);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (45, 29, 0.56, 2166.81);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (46, 72, 21.78, 2816.56);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (47, 2, 15.24, 854.24);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (48, 20, 14.02, 2592.48);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (49, 3, 18.92, 1747.33);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (50, 37, 14.65, 1900.79);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (51, 59, 6.81, 2099.83);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (52, 36, 15.33, 482.9);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (53, 72, 18.83, 278.12);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (54, 72, 21.95, 1583.78);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (55, 16, 4.65, 493.02);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (56, 39, 0.45, 2845.35);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (57, 20, 3.7, 2695.82);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (58, 54, 15.03, 1133.8);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (59, 31, 17.91, 257.97);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (60, 4, 17.24, 2477.58);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (61, 9, 6.79, 2630.23);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (62, 48, 19.29, 811.44);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (63, 13, 5.96, 768.7);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (64, 7, 21.16, 1807.81);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (65, 39, 11.63, 1984.54);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (66, 25, 15.01, 2106.03);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (67, 17, 17.2, 298.54);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (68, 69, 16.68, 1538.28);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (69, 28, 1.12, 2547.55);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (70, 25, 2.31, 452.7);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (71, 29, 9.53, 1108.67);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (72, 27, 10.29, 2506.12);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (73, 2, 12.52, 1569.31);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (74, 63, 13.51, 1240.22);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (75, 4, 0.06, 2542.93);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (76, 65, 1.12, 2421.73);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (77, 70, 20.33, 1000.12);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (78, 12, 13.52, 2402.8);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (79, 38, 0.37, 1149.82);
INSERT INTO BILLS (Billid, Resid, Taxrate, Total) VALUES (80, 36, 11.94, 633.59);
