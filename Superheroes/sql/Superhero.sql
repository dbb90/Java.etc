
DROP DATABASE IF EXISTS Superhero;
CREATE DATABASE Superhero;
USE Superhero;

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
INSERT INTO HEROES (Heroid, HeroName, HeroDesc, Villain) values (4, "Sergeant Hatred", "Massive bodyguard of Dr. Venture. A former supervillain, and apparently reformed(behavior modified) criminal.", false);
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




CREATE TABLE Locs

(locid INT(12) NOT NULL AUTO_INCREMENT,
LocName VARCHAR(255) NOT NULL,
LocDesc VARCHAR(1024) DEFAULT 'Unknown.',
LocAddress VARCHAR(255) DEFAULT 'Unknown.',
LocLat VARCHAR(50) DEFAULT 'Unknown.',
LocLong VARCHAR(50) DEFAULT 'Unknown.',
PRIMARY KEY(locid)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;



insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('It Is a Mystery', 'Uknown', 'Unknown', '-6.5643956', '106.2522143');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Brisby Dome', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 'Unknown', '1.130349', '-77.550994');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Brisby Land', 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '02595 Toban Parkway', '48.8834042', '2.333434');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Chairman Waos Chow House', 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.', '247 Scoville Drive', '37.932976', '102.665494');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Community University of Mexico at Tijuana', 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2465 Eastlawn Junction', '-26.3749827', '-49.0615086');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Don Hells', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', '014 Burrows Road', '56.026549', '12.8055694');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Dunwitch Asylum for the Criminally Obsessive', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '5 Marcy Place', '35.8939566', '117.9249002');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Gargantua I', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '5948 Red Cloud Hill', '2.7239834', '101.9476452');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Gargantua II', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.', '52 North Street', '-15.5404411', '-47.3374297');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Hall of Sorrows', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis.', '279 Eliot Alley', '37.62', '-77.61');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Malice', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '1938 Kensington Plaza', '21.4906113', '-77.6049218');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Meteor Majeure', 'Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', '4725 Homewood Street', '37.841046', '140.5203882');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Morpho Cave', 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', '48 Eagan Road', '18.3440652', '-78.0171776');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Nightin Ales', 'Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '8292 Rieder Crossing', '34.8591956', '134.5488877');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Specialty Tailoring', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '6 Darwin Park', '50.1209479', '17.3831619');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Spider-Skull Island', 'Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.', '88 David Crossing', '24.160878', '113.433561');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('State University', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '3 Paget Avenue', '9.6026645', '122.4656415');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Stuyvesant University', null, '17 Oak Valley Road', '29.5530941', '118.9353968');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Cocoon', null, '05 Veith Crossing', null, null);
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The United Nations', null, '0253 Florence Point', '52.0404442', '8.4770585');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Panic Room', 'Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '16 Basil Court', '-16.2803207', '27.4732571');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Pool', 'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', '5200 Fallview Park', '34.7277137', '-58.3326356');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Venture Industries Lobby', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '41424 Huxley Crossing', '59.3146154', '18.0001365');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Bodyguard Quarters', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '953 Chinook Parkway', '26.789958', '114.908872');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Rustys Bedroom', 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat.', '7491 Logan Pass', '37.3743044', '60.5008307');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Hangar', 'Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '08 Bartelt Hill', '-32.9321855', '-60.7222767');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Kitchen', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.', '0096 Rutledge Point', '-24.7869452', '65.4128686');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Cloning Lab', 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.', null, '22.3577742', '103.2493721');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Hank and Deans Room', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis.', '883 Mitchell Street', '15.1955811', '104.8304807');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Deans Room (Attic)', 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '8 Moland Hill', '48.8547803', '16.567169');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Surveillance Room', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2 Golden Leaf Trail', '7.5286908', '1.1305049');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Underground Tunnel', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '42 Tennessee Terrace', '41.0919871', '-7.8038268');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - E-Den', 'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', '4119 Troy Alley', '-34.793224', '-58.4103552');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Laboratory', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim.', '29672 Macpherson Circle', '0.3268809', '-79.4647633');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound Manufacturing Wing', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', '85796 Tennyson Drive', '29.137138', '89.499642');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Venture Compound - Venture Industries Arachnid Research', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '60 3rd Court', '39.7992062', '44.7723968');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Tophet Tower', null, '25097 Eggendart Terrace', '5.301832', '-1.9930466');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('VenTech Tower', 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', '27 Mifflin Crossing', '34.8412176', '32.4297369');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Venture Industries', null, '34 Bowman Plaza', '48.019573', '66.923684');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Vincenzos', 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', '8839 Susan Court', '48.8902362', '6.308001');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Ye Olde Battleaxe', 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', null, '8.9705754', '37.7609688');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Yumi', 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '56 Dunning Court', '-28.7245183', '-52.8444231');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Underland', 'Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', '2 Porter Plaza', '50.7917257', '21.2322042');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Hello Hill Mall', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '341 Trailsway Road', '14.55647', '121.018975');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('West Entrance Bus Stop', null, '2113 Del Sol Point', '31.491169', '120.31191');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('St. Sebastians Medical Center', 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim.', '2 Morningstar Junction', '46.003670', '14.5753497');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Trailer Park', 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '5 Lakewood Gardens Way', '63.9727688', '-22.5764849');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Grand Canyon', 'Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '0246 Judy Drive', '1.3031434', '101.0259275');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Redusas House', 'Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.', '6 Ridgeway Road', '44.780865', '28.447649');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('The Monarchs Home', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', '1 Weeping Birch Circle', '55.9', '37.55');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Pete and Billys Residence', null, '999 Mitchell Street', '32.849276', '35.068929');
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('Augustus St Clouds Manse', null, '262 Quincy Pass', null, null);
insert into LOCS (LocName, LocDesc, LocAddress, LocLat, LocLong) values ('OSI Headquarters', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '9 Di Loreto Park', '-6.6889038', '107.6185727');


CREATE TABLE Sightings(

Sightingid INT NOT NULL,
SightingLocid INT NOT NULL,
DateSighted DATE NOT NULL,
PRIMARY KEY(Sightingid)
);

insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (1, 16, '2017-07-25 20:09:26');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (2, 53, '2017-03-08 02:42:58');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (3, 37, '2017-04-28 07:24:38');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (4, 39, '2016-12-14 05:23:30');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (5, 39, '2017-03-08 11:18:05');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (6, 48, '2017-03-23 17:17:28');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (7, 44, '2017-06-15 04:40:53');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (8, 24, '2016-11-24 16:39:22');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (9, 37, '2017-06-14 08:33:42');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (10, 51, '2017-06-24 13:38:42');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (11, 10, '2017-05-04 07:35:03');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (12, 30, '2017-03-17 00:39:07');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (13, 51, '2017-03-08 18:19:57');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (14, 22, '2017-07-27 19:14:06');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (15, 45, '2017-02-26 04:56:19');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (16, 2, '2016-11-04 13:37:36');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (17, 50, '2017-07-04 11:19:39');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (18, 47, '2017-08-21 12:48:04');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (19, 44, '2017-05-26 17:54:20');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (20, 33, '2016-12-21 16:31:24');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (21, 4, '2016-12-06 11:47:03');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (22, 44, '2017-08-25 19:36:19');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (23, 20, '2017-03-14 20:39:56');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (24, 39, '2017-03-22 10:56:52');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (25, 8, '2017-04-01 17:47:49');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (26, 22, '2017-09-17 17:53:30');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (27, 28, '2017-01-29 17:09:35');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (28, 28, '2017-04-06 12:52:34');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (29, 7, '2017-01-28 07:28:57');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (30, 38, '2017-07-16 14:33:14');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (31, 2, '2017-07-02 13:24:02');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (32, 9, '2017-06-25 20:52:07');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (33, 52, '2017-03-21 07:20:43');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (34, 34, '2017-03-13 23:54:22');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (35, 32, '2017-08-29 19:06:18');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (36, 50, '2016-12-25 06:26:10');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (37, 28, '2017-07-30 12:22:12');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (38, 19, '2017-06-10 17:33:24');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (39, 13, '2016-11-11 23:34:42');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (40, 45, '2017-06-03 20:42:48');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (41, 15, '2017-01-24 03:57:48');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (42, 17, '2017-01-19 17:27:25');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (43, 24, '2016-11-05 17:02:49');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (44, 32, '2017-06-14 00:13:50');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (45, 26, '2017-06-10 20:12:46');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (46, 22, '2017-03-12 06:00:21');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (47, 52, '2017-08-23 13:37:35');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (48, 5, '2017-04-29 18:37:06');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (49, 15, '2017-03-18 12:13:39');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (50, 30, '2017-04-03 04:50:23');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (51, 27, '2017-01-30 15:01:59');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (52, 18, '2016-11-20 23:48:06');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (53, 27, '2017-10-11 22:19:00');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (54, 23, '2016-12-05 19:00:31');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (55, 19, '2017-09-30 06:44:09');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (56, 53, '2017-06-19 23:43:26');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (57, 19, '2017-01-09 13:21:51');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (58, 22, '2017-07-22 09:01:29');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (59, 40, '2017-01-07 01:21:59');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (60, 36, '2017-06-20 20:37:22');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (61, 15, '2017-04-10 12:25:23');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (62, 16, '2017-06-22 02:09:42');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (63, 5, '2017-01-21 07:23:13');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (64, 34, '2017-09-07 04:39:22');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (65, 8, '2017-06-26 06:54:48');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (66, 11, '2016-11-22 00:23:09');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (67, 41, '2016-11-25 10:57:50');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (68, 15, '2017-01-03 00:54:01');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (69, 24, '2017-05-25 01:38:27');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (70, 33, '2017-02-18 12:20:24');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (71, 51, '2017-09-10 14:32:11');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (72, 53, '2017-07-16 11:18:21');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (73, 18, '2017-06-28 22:49:51');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (74, 38, '2017-10-17 00:45:46');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (75, 17, '2017-01-21 08:02:43');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (76, 44, '2017-09-28 21:47:56');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (77, 18, '2016-12-23 09:17:18');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (78, 29, '2017-03-15 04:21:26');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (79, 41, '2017-09-25 04:20:29');
insert into SIGHTINGS (Sightingid, SightingLocid, DateSighted) values (80, 24, '2017-09-25 12:28:01');



CREATE TABLE HeroesSightings(
HeroesSightingsid INT NOT NULL,
Heroid INT NOT NULL,
Sightingid INT NOT NULL,
FOREIGN KEY(Heroid) REFERENCES Heroes(Heroid),
FOREIGN KEY(Sightingid) REFERENCES Sightings(Sightingid)
);

insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (1, 10, 32);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (2, 19, 67);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (3, 24, 74);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (4, 23, 15);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (5, 5, 10);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (6, 9, 42);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (7, 16, 20);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (8, 29, 78);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (9, 10, 57);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (10, 3, 35);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (11, 9, 6);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (12, 27, 40);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (13, 24, 1);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (14, 4, 7);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (15, 27, 61);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (16, 19, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (17, 6, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (18, 24, 66);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (19, 4, 7);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (20, 1, 68);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (21, 17, 54);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (22, 28, 18);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (23, 6, 67);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (24, 26, 10);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (25, 15, 1);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (26, 5, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (27, 19, 43);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (28, 16, 53);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (29, 5, 40);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (30, 15, 25);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (31, 5, 78);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (32, 1, 57);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (33, 13, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (34, 2, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (35, 24, 2);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (36, 17, 65);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (37, 4, 26);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (38, 29, 75);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (39, 19, 79);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (40, 5, 70);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (41, 4, 47);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (42, 14, 76);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (43, 12, 47);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (44, 12, 49);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (45, 22, 10);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (46, 2, 74);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (47, 26, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (48, 24, 38);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (49, 5, 3);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (50, 20, 73);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (51, 19, 28);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (52, 4, 37);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (53, 7, 71);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (54, 3, 59);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (55, 8, 50);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (56, 29, 29);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (57, 3, 69);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (58, 17, 8);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (59, 20, 24);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (60, 22, 48);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (61, 12, 48);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (62, 17, 49);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (63, 6, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (64, 11, 16);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (65, 12, 33);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (66, 4, 27);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (67, 17, 5);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (68, 19, 48);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (69, 12, 26);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (70, 11, 50);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (71, 21, 80);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (72, 9, 80);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (73, 19, 61);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (74, 18, 35);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (75, 7, 66);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (76, 28, 31);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (77, 10, 5);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (78, 14, 42);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (79, 8, 59);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (80, 5, 23);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (81, 4, 77);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (82, 15, 29);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (83, 3, 68);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (84, 11, 13);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (85, 4, 53);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (86, 14, 76);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (87, 11, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (88, 29, 58);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (89, 1, 36);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (90, 1, 1);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (91, 17, 8);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (92, 27, 16);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (93, 2, 41);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (94, 2, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (95, 21, 29);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (96, 1, 72);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (97, 8, 72);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (98, 4, 3);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (99, 17, 33);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (100, 4, 45);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (101, 24, 30);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (102, 16, 65);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (103, 7, 17);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (104, 13, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (105, 26, 36);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (106, 11, 30);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (107, 11, 73);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (108, 7, 66);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (109, 19, 70);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (110, 12, 21);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (111, 20, 28);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (112, 26, 36);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (113, 29, 1);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (114, 7, 45);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (115, 20, 22);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (116, 28, 48);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (117, 15, 50);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (118, 18, 78);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (119, 7, 77);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (120, 24, 26);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (121, 2, 62);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (122, 21, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (123, 17, 68);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (124, 12, 48);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (125, 3, 25);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (126, 11, 41);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (127, 17, 37);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (128, 7, 26);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (129, 14, 31);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (130, 21, 79);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (131, 16, 55);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (132, 5, 53);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (133, 26, 56);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (134, 23, 51);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (135, 29, 59);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (136, 20, 78);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (137, 16, 25);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (138, 11, 35);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (139, 25, 72);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (140, 18, 54);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (141, 15, 38);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (142, 15, 39);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (143, 23, 26);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (144, 8, 18);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (145, 3, 61);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (146, 5, 64);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (147, 9, 16);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (148, 23, 77);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (149, 7, 45);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (150, 25, 19);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (151, 9, 50);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (152, 13, 47);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (153, 9, 76);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (154, 16, 2);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (155, 29, 74);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (156, 11, 44);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (157, 7, 17);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (158, 12, 3);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (159, 21, 44);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (160, 4, 32);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (161, 8, 28);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (162, 24, 38);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (163, 20, 64);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (164, 19, 63);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (165, 3, 20);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (166, 13, 63);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (167, 20, 65);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (168, 21, 62);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (169, 11, 49);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (170, 10, 3);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (171, 19, 73);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (172, 26, 36);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (173, 16, 58);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (174, 20, 9);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (175, 9, 35);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (176, 1, 24);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (177, 5, 70);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (178, 2, 17);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (179, 1, 41);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (180, 28, 9);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (181, 11, 74);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (182, 24, 2);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (183, 1, 56);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (184, 20, 23);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (185, 4, 31);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (186, 23, 22);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (187, 6, 42);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (188, 3, 60);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (189, 23, 4);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (190, 7, 12);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (191, 10, 67);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (192, 11, 28);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (193, 1, 64);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (194, 3, 31);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (195, 20, 80);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (196, 11, 71);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (197, 1, 28);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (198, 19, 42);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (199, 9, 24);
insert into HEROESSIGHTINGS (HeroesSightingsid, Heroid, Sightingid) values (200, 13, 25);


CREATE TABLE Contacts(

Contactid INT NOT NULL,
Orgid INT NOT NULL,
Locid INT DEFAULT 1,
Phone VARCHAR(20) DEFAULT 'Unknown.',
Email VARCHAR(50) DEFAULT 'Unknown.',
PRIMARY KEY(Contactid),
FOREIGN KEY(Orgid) REFERENCES Orgs(Orgid),
FOREIGN KEY(Locid) REFERENCES Locs(Locid)
);

insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (1, 10, 35, '467-723-7232', 'sphinx@sphinx.org');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (2, 3, 36, '175-533-7633', 'orpheus@ootriad.net');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (3, 4, 13, '282-617-9670', 'kmorden2@wix.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (4, 10, 32, '915-387-1530', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (5, 12, 32, '782-200-5367', 'ckender4@privacy.gov.au');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (6, 10, 20, null, 'dlomath5@360.cn');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (7, 10, 3, '184-160-1265', 'mdietmar6@posterous.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (8, 6, 43, '525-113-1226', 'loldford7@parallels.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (9, 13, null, '952-728-7053', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (10, 14, 3, '719-707-5705', 'dragge9@discovery.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (11, 2, 45, '488-684-3844', 'imacdermanda@cbsnews.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (12, 9, null, '155-273-7421', 'mmcgahernb@cargocollective.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (13, 3, 4, '315-619-0653', 'kblondenc@123-reg.co.uk');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (14, 9, 19, '170-425-0717', 'hcaressd@miitbeian.gov.cn');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (15, 2, 41, '381-245-2605', 'spumphreye@exblog.jp');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (16, 5, 42, '218-833-5429', 'jforderf@ustream.tv');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (17, 7, 7, '888-853-5590', 'chousegog@bigcartel.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (18, 14, 15, '158-400-0067', 'hthorleyh@rambler.ru');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (19, 5, 15, '907-803-5142', 'iogormani@ovh.net');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (20, 10, null, '831-902-9797', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (21, 5, 10, '793-201-8326', 'gbansalk@issuu.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (22, 6, null, null, null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (23, 13, 30, '948-675-8419', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (24, 13, 15, '618-451-3503', 'dhazeln@mapquest.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (25, 13, 42, '309-421-7074', 'sstollenbecko@virginia.edu');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (26, 8, 32, '529-668-8446', 'adrippp@aol.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (27, 10, 52, '998-704-3768', 'eslemmingq@wunderground.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (28, 12, null, '267-988-3719', 'cbromehedr@clickbank.net');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (29, 13, 25, '320-698-1134', 'ncapeys@desdev.cn');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (30, 4, null, '461-720-9893', 'dretchlesst@sciencedirect.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (31, 2, 36, '461-519-1741', 'rcranefieldu@list-manage.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (32, 4, null, '212-327-9118', 'bgrabiecv@csmonitor.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (33, 13, null, '822-412-3074', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (34, 2, 30, '442-732-6879', 'bhucx@sun.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (35, 13, 38, '829-293-5495', 'twinningy@sciencedaily.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (36, 8, 10, '368-822-8222', null);
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (37, 14, 7, '935-411-6721', 'jikringill10@123-reg.co.uk');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (38, 4, 22, '639-197-4041', 'kgodehardsf11@newsvine.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (39, 12, 36, '512-385-1529', 'bcoull12@privacy.gov.au');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (40, 14, 28, '117-200-5449', 'jilive13@comsenz.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (41, 6, 33, '973-184-9755', 'vfallowes14@stumbleupon.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (42, 9, 36, '605-628-2329', 'jcleeve15@amazonaws.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (43, 4, 10, '794-989-5551', 'smillyard16@nps.gov');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (44, 13, 52, '619-731-9810', 'cgilbody17@a8.net');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (45, 9, 3, '998-881-2285', 'smycock18@biglobe.ne.jp');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (46, 5, null, '364-773-8628', 'bcochran19@si.edu');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (47, 1, 37, '266-466-8783', 'mgounel1a@independent.co.uk');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (48, 14, 3, null, 'sszabo1b@weibo.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (49, 12, 8, '755-863-7172', 'swillox1c@github.com');
insert into CONTACTS (Contactid, Orgid, Locid, Phone, Email) values (50, 10, null, '886-320-8385', 'ngeany1d@cbslocal.com');

