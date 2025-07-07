CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);
SELECT * FROM  person WHERE id = 3;
SELECT * FROM person; 
DELETE  FROM person WHERE id = 1;

CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);
/***********************************************/
drop table member;
drop table book;
drop table rent;


CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    age INT NOT NULL
);
CREATE TABLE book(
	book_No int PRIMARY KEY auto_increment,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    access_age INT default 0
);
CREATE TABLE rent(
	rent_No int PRIMARY KEY auto_increment,
    id VARCHAR(100),
    book_No int,
    rent_date Date DEFAULT(CURRENT_DATE)
);

ALTER TABLE rent ADD 
FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE; 
ALTER TABLE rent ADD
FOREIGN KEY (book_No) REFERENCES book(book_No);

select * from member;
select * from book;
select * from rent;
SELECT * FROM rent WHERE book_No = 18;
INSERT INTO book(title,author,access_age) value('집가고싶다','채은',0);
delete from member where id = 'aaaa';
delete from book where book_No = 2;
DELETE FROM book WHERE book_No = 18;
INSERT INTO member(id,name,pwd,age) value('admin','관리자','1234', 50);
INSERT INTO member(id,name,pwd,age) value('isc','문채은','10708', 24);

SELECT * FROM book WHERE book_No =  20;

SELECT * FROM member WHERE id = 'isc';

SELECT * FROM member JOIN book USING(book_No)WHERE id = isc;