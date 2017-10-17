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
Price NUMERIC,
DateStart DATE,
DateLast DATE,
PRIMARY KEY(TypeRateid),
FOREIGN KEY(Typeid)REFERENCES RoomType(Typeid));

create table Amenities(

Amenityid INT NOT NULL,
AmType VARCHAR(255),
Price NUMERIC,
PRIMARY KEY(Amenityid)
);

create table RoomsAmenities(

RoomsAmenitiesid INT,
Roomid INT NOT NULL,
Amenityid INT NOT NULL,
PRIMARY KEY(RoomsAmenitiesid),
FOREIGN KEY(Roomid) REFERENCES Rooms(RoomNum),
FOREIGN KEY(Amenityid) REFERENCES Amenities(Amenityid));

create table Customer(

Customerid INT NOT NULL,
phone VARCHAR(11),
email VARCHAR(255),
PRIMARY KEY(Customerid));

create table Guests(

Guestid INT NOT NULL,
name VARCHAR(255),
DateOfBirth date,
Customerid INT,
PRIMARY KEY(Guestid),
FOREIGN KEY(Customerid)REFERENCES Customer(Customerid)
);

create table Res

(Resid INT NOT NULL,
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

PromoID INT NOT NULL,
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
AddonPrice NUMERIC,
PRIMARY KEY(AddOnid)
);


create table Bill(

Billid INT NOT NULL,
Resid INT NOT NULL,
Taxrate NUMERIC NOT NULL,
Total NUMERIC NOT NULL,
PRIMARY KEY(Billid),
FOREIGN KEY(Resid) REFERENCES Res(Resid)
);

