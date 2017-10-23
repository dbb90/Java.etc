-- Drop DB if in use, create new DB, use said DB

DROP DATABASE IF EXISTS Superhero;
CREATE DATABASE Superhero;
USE Superhero;

-- Creating our Type and room tables 
-- naming a table Type ran fine but messed with the Workbench parser, modified



CREATE TABLE Powers

(Powerid INT NOT NULL,
PowerName VARCHAR(50),
PowerDesc VARCHAR(255),
PRIMARY KEY(Powerid)
);

CREATE TABLE Heroes(

Heroid INT NOT NULL,
HeroName VARCHAR(50),
HeroDesc VARCHAR(255),
Villain BOOLEAN NOT NULL,
PRIMARY KEY(Heroid));

CREATE TABLE HeroesPowers(

HeroesPowersid INT NOT NULL,
Heroid INT NOT NULL,
Powerid INT NOT NULL,
PRIMARY KEY(HeroesPowersid),
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Powerid) REFERENCES Powers(Powerid));

CREATE TABLE Orgs(

Orgid INT NOT NULL,
OrgName VARCHAR(50),
OrgDesc VARCHAR(255),
PRIMARY KEY(Orgid)
);

CREATE TABLE Locs(

Locid INT NOT NULL,
LocName VARCHAR(50) NOT NULL,
LocDesc VARCHAR(255),
LocAddress VARCHAR(255),
LocLatLong VARCHAR(50),
PRIMARY KEY(Locid)
);

CREATE TABLE Sightings(

Sightingid INT NOT NULL,
Locid INT NOT NULL,
DateSighted DATE NOT NULL,
PRIMARY KEY(Sightingid),
FOREIGN KEY(Locid) REFERENCES Locs(Locid)
);

CREATE TABLE HeroesSightings(
Heroid INT NOT NULL,
Sightingid INT NOT NULL,
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Sightingid) REFERENCES Sightings(Sightingid)
);

CREATE TABLE HeroesOrgs(
Heroid INT NOT NULL,
Orgid INT NOT NULL,
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Orgid) REFERENCES Orgs(Orgid)
);



CREATE TABLE OrgContact(

Contactid INT NOT NULL,
Orgid INT NOT NULL,
Locid INT,
Phone VARCHAR(20),
Email VARCHAR(50),
PRIMARY KEY(Contactid),
FOREIGN KEY(Orgid) REFERENCES Orgs(Orgid),
FOREIGN KEY(Locid) REFERENCES Locs(Locid)
);

