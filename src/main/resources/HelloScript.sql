CREATE USER oladushka IDENTIFIED BY o1234;

GRANT CONNECT, RESOURCE TO oladushka;

CONNECT oladushka/o1234;

DROP TABLE Twins;

CREATE TABLE Twins (
  twin_id NUMERIC PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  actor VARCHAR(40) NOT NULL
);

INSERT INTO Twins (twin_id, first_name, last_name, actor) VALUES (1, 'Laura','Palmer', 'Sheryl Lee');
INSERT INTO Twins (twin_id, first_name, last_name, actor) VALUES (2, 'Dale', 'Cooper', 'Kyle MacLachlan');
INSERT INTO Twins (twin_id, first_name, last_name, actor) VALUES (3, 'Ben', 'Horne', 'Richard Beymer');
INSERT INTO Twins (twin_id, first_name, last_name, actor) VALUES (4, 'Audrey', 'Horne', 'Sherilyn Fenn');
INSERT INTO Twins (twin_id, first_name, last_name, actor) VALUES (5, 'Harry', 'Truman', 'Michael Ontkean');

COMMIT;