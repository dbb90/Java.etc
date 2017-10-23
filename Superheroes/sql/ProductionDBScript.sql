DROP DATABASE IF EXISTS GamesLibrary;
CREATE DATABASE GamesLibrary;
USE `GamesLibrary`;

CREATE TABLE `Games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) NOT NULL,
  `console` varchar(64) DEFAULT 'unknown',
  `genre` varchar(100) NOT NULL DEFAULT 'unknown',
  `studio` varchar(100) NOT NULL DEFAULT 'unknown',
  `userRating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO Games (title) VALUES
("Don't Starve"), ("Stardew Valley"), ("Majora's Mask"), 
("Paper Mario"), ("Games of War"), ("Super Mario 64");

SELECT * FROM Games;

UPDATE Games SET console = NULL WHERE 1=1;
UPDATE Games SET genre = NULL WHERE 1=1;