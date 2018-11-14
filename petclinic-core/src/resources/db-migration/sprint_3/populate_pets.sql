--liquibase formatted sql

--changeset juliend:4

USE petclinic;

INSERT IGNORE INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 'cat');
INSERT IGNORE INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 'dog');
INSERT IGNORE INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 'snake');
INSERT IGNORE INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 'cat');
INSERT IGNORE INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 'cat');
INSERT IGNORE INTO pets VALUES (6, 'George', '2000-01-20', 4, 'lizard');
INSERT IGNORE INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 'dog');
INSERT IGNORE INTO pets VALUES (8, 'Max', '1995-09-04', 1, 'dog');
INSERT IGNORE INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 'snake');
INSERT IGNORE INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 'spider');
INSERT IGNORE INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 'golden fish');
INSERT IGNORE INTO pets VALUES (12, 'Perry', '2000-06-24', 2, 'platypus');
INSERT IGNORE INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 'alpaga');
