
DROP DATABASE IF EXISTS Superhero_test;
CREATE DATABASE Superhero_test;
USE Superhero_test;

-- Creating our Type and room tables 
-- naming a table Type ran fine but messed with the Workbench parser, modified



CREATE TABLE Powers

(Powerid INT(11) NOT NULL AUTO_INCREMENT,
PowerName VARCHAR(50),
PowerDesc VARCHAR(255),
PRIMARY KEY(Powerid)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


insert into POWERS (PowerName, PowerDesc) values ("Super Speed", "Super Speed is simple to use, cheap, fast, and safe, but is very much restricted by terrain since it offers no way to gain altitude.");
insert into POWERS (PowerName, PowerDesc) values ("Flying", "Fly is simple to use, safe, and highly maneuverable, but expensive in Endurance and relatively slow.");
insert into POWERS (PowerName, PowerDesc) values ("Super Jump", "Super Jump is simple to use, fast, fairly maneuverable, fairly safe, and cheap. Its biggest drawback is the danger of accidentally jumping into a crowd of enemies.");
insert into POWERS (PowerName, PowerDesc) values ("Teleportation", "Teleport is complex to use, very expensive, and dangerous. On the other hand, it is potentially the fastest of all Travel Powers, it is the least affected by debuffs and Status Effects, and it doesn't suffer Suppression.");
insert into POWERS (PowerName, PowerDesc) values ("Ice Sword", "Melee, Moderate DMG(Cold/Lethal), Foe -Recharge, -SPD");
insert into POWERS (PowerName, PowerDesc) values ("Chillblain", "Ranged, Moderate Damage over Time(Cold), Foe Immobilize, -Speed, -Recharge");


CREATE TABLE Heroes(

Heroid INT(11) NOT NULL AUTO_INCREMENT,
HeroName VARCHAR(50),
HeroDesc VARCHAR(255),
Villain BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY(Heroid))
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO Heroes (HeroName) VALUES
("Superman"), ("Batman"), ("The Flash"), 
("The Joker"), ("Powdered Toast Man"), ("Quail Boy");

CREATE TABLE HeroesPowers(

HeroesPowersid INT NOT NULL,
Heroid INT NOT NULL,
Powerid INT NOT NULL,
PRIMARY KEY(HeroesPowersid),
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Powerid) REFERENCES Powers(Powerid));

insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (1, 1, 1);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (2, 1, 2);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (3, 1, 3);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (4, 2, 1);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (5, 2, 2);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (6, 2, 3);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (7, 3, 2);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (8, 3, 4);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (9, 4, 4);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (10, 4, 2);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (11, 5, 1);
 insert into HEROESPOWERS (HeroesPowersid, Heroid, Powerid) values (12, 5, 3);

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

