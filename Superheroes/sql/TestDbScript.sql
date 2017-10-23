
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
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Dean Venture", "the other Venture twin, son of Thaddeus. The more science-minded son, as well as the most awkward.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Sergeant Hatred", "Massive bodyguard of Dr. Venture. A former supervillain, and apparently reformed(behavior modified) pedophile.", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "H.E.L.P.eR.", "Helpful Electronic Lab Partner Robot", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Master Billy Quizboy", "Hydrocephalic; eye-patch; self-proclaimed boy genius; bionic arm; speech impediment", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Pete White", "An albino computer technologist, and co-founder of 'Conjectural Technologies' along with Billy Quizboy. ", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Dr. Orpheus", "A melodramatic necromancer", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Jonas Venture Jr.", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "Brock Samson", "", false);

INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (2, "", "", false);

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


CREATE TABLE HeroesOrgs(
Heroid INT NOT NULL,
Orgid INT NOT NULL,
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Orgid) REFERENCES Orgs(Orgid)
);

insert into HEROESORGS (HeroesOrgsid, Heroid, Orgid) values (1, 1, 1);



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

