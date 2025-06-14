/*
	DB 모델링 
    1. 개념적 모델링
		- 엔티티(테이블) 추출
        - 엔티티 간의 관계설정
    2. 논리적 모델링
		- 속성(컬럼) 추출
        - 정규화 작업 (1,2,3) ---> 이 이상으로 가면 역정규화
    3. 물리적 모델링
		- 테이블 실질적으로 작성 (CREATE문 작성)
		
    *정규화(NOMALIZATION)
    -불필요한 데이터의 중복을 제거하여 데이터모델을 구조화하는것 
    -효율적인 자료 저장 및 데이터 무결성을 보장하고 오류를 최소화하여 안정성을 
	 보장하기 위해 적용함
	
    제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
    제 2 정규화 : 주 식별자에 종속되지 않는 속성을 분리
    제 3 정규화 : 속성에 종속적인 속성을 제거
*/

/*
	사용자 or 사원 관련 정보 들어가는 테이블 CREATE문 작성해서 제출
    MySQL
    -데이터 타입
    1. 문자 
		- char / **varchar** : 고정 및 가변 길이 문자, 반드시 크기 지정
        - text : 매우 긴 문자열을 저장하는데 사용
	2. 숫자
		- int : 정수값 저장사는데 사용
        -float / double :부동 소수점 저장하는데 사용
        -decimal : 고정 소수점 저장하는데 사용
   3. 날짜 및 시간
		-date : 날짜 저장하는데 사용
        -time : 시간 저장하는데 사용
        -**dateTime** / timeStamp : 날짜와 시간을 함께 저장
  4. 불리언
	- boolean / bool : 참(true) 또는 거짓(false) 값을 저장하는데 사용
  5. 이진 자료형
  -blob : 이진 데이터를 저장하는데 사용. 이미지나 동영상과 같은 이진 파일
  --> 실제로는 이미지나 동영상을 따로 관리 (url만 문자형으로 저장)
  
  ->PRIMARY KEY --> AUTO INCREMENT 추가
*/

/*

-- 	프로젝트 관리 : 테이블 몇개든 상관없이 짜보시고 foreign key까지 걸어보는 것까지!
--     테이블 필요한 컬럼 짜기 힘드시다면 어떤 기능이 있어야되는지 정도로 제출해도 괜찮아요@!
--     
-- */

/*********************************************************************/
-- 삭제
drop table user_info;
DROP TABLE DEPARTMENT;
DROP TABLE PROJECT_MEMBERS;
DROP TABLE PROJECT_TASK;
DROP TABLE GRADE;
DROP TABLE PROJECT;
DROP TABLE SCHEDULE;
DROP TABLE SCHEDULE_MEMBERS;
create table user_Info(
	user_no int primary key auto_increment,
	user_Id varchar(50) unique not null,
    user_Pw varchar(300) not null,
    email varchar(100) unique,
	user_Name varchar(50) not null,
    phone varchar(50) unique,
    addr varchar(200),
    gender varchar(10) check(gender in ('남','여')),
    birth_date date,
    hire_date date default (current_date), /*현재 날짜 저장*/
    quit_date date,
    dept_no int,
    grade_no int
);
create table department(-- 부서
dept_no int primary key auto_increment,
dept_name varchar(100) not null,
DEPT_COLOR VARCHAR(50)
    );
create table grade( -- 사원
grade_no int primary key auto_increment,
grade_name varchar(100) not null
    );

CREATE TABLE PROJECT(
	PRO_NO INT primary key auto_increment,
    PRO_NAME VARCHAR(100) NOT NULL,
    PRO_DESC TEXT,
    START_DATE DATE,
    END_DATE DATE,
    STATUS VARCHAR(20) CHECK(STATUS IN('진행 전', '진행 중','완료', '중단'))
);
--  PROJECT_MEMBERS : USER_NO, PRO_NO
CREATE TABLE PROJECT_MEMBERS(
MEMBER_NO INT  primary key auto_increment,
USER_NO INT, 
PRO_NO INT,
MEM_ROLE VARCHAR(50)
);
-- 프로젝트 : 업무들 = 1 : M
-- PROJECT_TASK : PRO_NO
CREATE TABLE PROJECT_TASK(
	TASK_NO INT  primary key auto_increment,
    PRO_NO INT,
    
    TASK_NAME VARCHAR(100),
    TASK_DESC TEXT,
    STATUS VARCHAR(50) CHECK(STATUS IN('진행 전','진행 중','완료','중단')),
	START_DATE DATE,
    END_DATE DATE,
	PARENT_TASK_NO INT
);

-- 일정 관리!
-- SCHE : PRO_NO,TASK_NO,USER_NO
-- SCHE_MEM : USER_NO,SCHEDULE_NO
 CREATE TABLE SCHEDULE(
 	SCHEDULE_NO INT primary key auto_increment,
    PRO_NO INT,
    TASK_NO INT,
    USER_NO INT,
    -- 제목
    
    SCHEDULE_TITLE VARCHAR(100) NOT NULL,-- 제목
    SCHEDULE_DESC TEXT,-- 메모
    STATUS VARCHAR(30) CHECK(STATUS IN('진행전', '진행중','완료','중단')),
    LOCATION VARCHAR(200),-- 장소
    -- 프로젝트 시간 관리
	START_DATE DATE,
	END_DATE DATE

);

CREATE TABLE SCHEDULE_MEMBERS(
SCE_MEM_NO INT  primary key auto_increment,
USER_NO INT,
SCHEDULE_NO INT
);




-- ----------------ALTER-------------------------
/*dept_no, grade_no*/
alter table user_info add 
foreign key(dept_no) references department(dept_no);
alter table user_info add 
foreign key(grade_no) references grade(grade_no);  



--  PROJECT_MEMBERS : USER_NO, PRO_NO

ALTER TABLE PROJECT_MEMBERS ADD
FOREIGN KEY(USER_NO) references USER_INFO(USER_NO);
ALTER TABLE PROJECT_MEMBERS ADD
FOREIGN KEY(PRO_NO) references PROJECT(PRO_NO);

-- PROJECT_TASK : PRO_NO
ALTER TABLE PROJECT_TASK ADD
FOREIGN KEY(PRO_NO) references PROJECT(PRO_NO);

-- SCHE : PRO_NO,TASK_NO,USER_NO

ALTER TABLE SCHEDULE ADD
FOREIGN KEY(PRO_NO) references PROJECT(PRO_NO);

ALTER TABLE SCHEDULE ADD
FOREIGN KEY(TASK_NO) references PROJECT_TASKS(TASK_NO);

ALTER TABLE SCHEDULE ADD
FOREIGN KEY(USER_NO) references USER_INFO(USER_NO);


-- SCHE_MEM : USER_NO,SCHEDULE_NO

ALTER TABLE SCHEDULE_MEMBERS ADD
FOREIGN KEY(SCHEDULE_NO) references SCHEDULE(SCHEDULE_NO);

ALTER TABLE SCHEDULE_MEMBERS ADD
FOREIGN KEY(USER_NO) references USER_INFO(USER_NO);

-- 고객관계관리, 인적자원 관리, 재무관리, 품질보증 관리
