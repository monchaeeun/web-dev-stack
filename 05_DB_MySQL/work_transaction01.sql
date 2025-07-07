SELECT * FROM work.member;

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);


UPDATE bank SET balance = 100000 WHERE name = '지은';
UPDATE bank SET balance = 0 WHERE name = '지연';