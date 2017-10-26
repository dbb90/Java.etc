
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

-- Team Venture
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (1, "Dr. Thaddeus Venture", "Dubious super-scientist and unworthy successor of the late Jonas Venture.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Hank Venture", "One of the Venture twins, son of Thaddeus. Is more interested in sports and adventure than science.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (3, "Dean Venture", "the other Venture twin, son of Thaddeus. The more science-minded son, as well as the most awkward.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (4, "Sergeant Hatred", "Massive bodyguard of Dr. Venture. A former supervillain, and apparently reformed(behavior modified) pedophile.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (5, "H.E.L.P.eR.", "Helpful Electronic Lab Partner Robot", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (6, "Master Billy Quizboy", "Hydrocephalic; eye-patch; self-proclaimed boy genius; bionic arm; speech impediment", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (7, "Pete White", "An albino computer technologist, and co-founder of 'Conjectural Technologies' along with Billy Quizboy. ", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (8, "Dr. Orpheus", "A melodramatic necromancer", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (9, "Jonas Venture Jr.", "Son of the late Jonas Venture Sr., younger twin brother of Dr. Thaddeus 'Rusty' Venture and uncle of Hank Venture, Dean Venture and Dermott Fictel.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (10, "Brock Samson", "OSI agent and bodyguard of Dr. Thaddeus 'Rusty' Venture.", false);

-- Crusaders Action League
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (11, "Stars and Garters", "Wears a costume based on the American flag, and carries a star-shaped shield.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (12, "Warriana", "Apparently an Amazon, she has black hair and is uncommonly tall and strong.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (13, "Fallen Archer", "His costume is purple, and his primary weapon is a longbow that uses to shoot arrows in the shape of human feet.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (14, "Night Dick", "He wears a fedora and trench coat, and rides a motorcycle that can drive up the sides of buildings.", false);

-- Order of the Triad
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (15, "Dr. Byron Orpheus", "A necromancer and longtime friend of Dr. Venture.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (16, "Jefferson Twilight", "The power to kill blackulas may seem hopelessly niche... until you find yourself under siege by blackulas.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (17, "The Alchemist", "Knows alchemy, snarkery, and good food when he sees it.  Proudly gay, and absolutely despises the internet.", false);

-- The Fluttering Horde
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (18, "The Monarch", "The Monarch's primary traits are his butterfly/royalty theme (based on both Monarch terms for butterfly and royalty), his shrill voice, and his obsessive hatred of Thaddeus Venture.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (19, "Dr. Mrs. The Monarch", "Professional sexy partner and wife of super-villain The Monarch.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (20, "Henchman 1", "Born Scott Hall, both the most skilled and tragically doomed of all the Monarch's many henchmen.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (21, "Henchman 21", "Despite his tragic history, 21 would come to enjoy the lifestyle and rise through the ranks becoming Henchman 21 and would later become friends with fellow henchman, Henchman 24.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (22, "Tim-Tom", "One of Dr. Mrs. The Monarch's original henchmen known as 'The Murderous Moppets'", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (23, "Kevin", "One of Dr. Mrs. The Monarch's original henchmen known as 'The Murderous Moppets'", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (24, "Henchman 24", "Sometime after the plant he worked at closed down 24 turned to professional henching for recourse since his only qualification was a GED.", true);

-- The Guild of Calamitous Intent
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (25, "Augustus St. Cloud", "The wealthy inheritor of the St. Cloud plastics fortune. Spending his vast wealth on collecting, he is the archenemy of Billy 'Quizboy' Whalen.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (26, "Baron Werner Underbheit", "The ruler of Underland and an arch-villain.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (27, "The Sovereign", "Shapeshifter and one-time leader of the Guild of Calamitous Intent", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (28, "Radical Left", "A psychotic supervillain imprisoned at Dunwitch Asylum who has half of his body severely disfigured.", true);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (29, "Phantom Limb", "Phantom Limb's arms and legs are completely invisible. He possesses the ability to kill or incapacitate others through physical contact.", true);
-- more GoCI


-- Peril Partnership

-- Fraternity of Torment

-- Council of 13

-- The Revenge Society 

-- SPHINX

-- OSI



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


INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (1, "Team Venture", "Dr. Thaddeus Venture, his boys Hank and Dean, and Brock Samson reluctantly save the world.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (2, "Crusaders Action League", "The CAL offers protection against all threats, be they terrestrial, extra-terrestrial or super-natural in origin.  Not for free, of course.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (3, "Order of the Triad", "The Order reunited when the Guild finally approved Orpheus' numerous petitions for a supervillain archenemy.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (4, "The Fluttering Horde", "The (mighty) Monarch's band of henchmen.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (5, "Guild of Calamitous Intent", "The Guild of Calamitous Intent is the largest organized labor group representing supervillains. Its direct competitors are The Peril Partnership and the Fraternity of Torment.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (6, "Peril Partnership", "Even less competent than the Fraternity of Torment.  That's a feat, at least.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (7, "Fraternity of Torment", "A Canadian alternative to the monolithic Guild of Calamitous Intent.  Sad!");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (8, "Council of 13", "The governing body of the Guild of Calamitous Intent, they only answer to the Sovereign.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (9, "The Revenge Society", "The Revenge Society was founded by Phantom Limb after he was removed from The Guild of Calamitous Intent for staging a coup against the Sovereign David Bowie.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (10, "S.P.H.I.N.X.", "A terrorist organization and enemy of the Office of Secret Intelligence until its defeat in the Pyramid Wars of 1987. The S.P.H.I.N.X. was later revived.");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (11, "O.S.I.", "A government agency that (usually) protects the world from evil and is the primary nemesis of The Guild of Calamitous Intent. ");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (12, "Venture industries", "A government agency that (usually) protects the world from evil and is the primary nemesis of The Guild of Calamitous Intent. ");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (13, "Classic Team Venture", "A government agency that (usually) protects the world from evil and is the primary nemesis of The Guild of Calamitous Intent. ");
INSERT INTO ORGS (Orgid, OrgName, OrgDesc) VALUES (14, "Conjectural Technologies", "A government agency that (usually) protects the world from evil and is the primary nemesis of The Guild of Calamitous Intent. ");

CREATE TABLE HeroesOrgs(
HeroesOrgsid INT NOT NULL,
Heroid INT NOT NULL,
Orgid INT NOT NULL,
Active boolean NOT NULL,
PRIMARY KEY(HeroesOrgsid),
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Orgid) REFERENCES Orgs(Orgid)
);

-- team venture
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (1, 1, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (2, 1, 12, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (3, 1, 13, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (4, 2, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (5, 3, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (6, 3, 5, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (7, 4, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (8, 4, 5, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (9, 4, 11, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (10, 5, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (11, 5, 13, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (12, 6, 3, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (13, 6, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (14, 6, 9, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (15, 6, 14, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (16, 7, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (17, 7, 14, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (18, 8, 3, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (19, 8, 1, true);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (20, 9, 12, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (21, 10, 1, false);
insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid, Active) values (22, 11, 11, true);

-- cal, etc etc




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

