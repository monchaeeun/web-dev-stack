/*
    데이터베이스 : 테이터(data) + 베이스(base)
 -DBMS : Database Management System의 약자(데이터베이스 관리 시스템)
 -관계형(Relational) 데이터 베이스
    1. 가장 대표적인 데이터 베이스 시스템
    2. 데이터를 테이블 형태(행과 열)로 저장하고, 여러 테이블간 관계를 설정하고
        데이터의 관계를 표현 및 분석
    3. 데이터의 중복을 최소화하고 무결성, 트랜잭션 관리 등 
        뛰어난 데이터 관리 성능을 제공 
 -SQL(Structured Query Language)
 :관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 언어
 
 -SQL 종류
 1. DML(Data Manipulation Language) : 데이터 조작어
     -데이터를 조작하기 위한 단어
        *INSERT : 추가
        *SELECT : 조회
        *UPDATE : 수정
        *DELETE : 삭제
        
CRUD : Create, Read, Update, Delete-추가, 조회, 수정, 삭제
    -SELECT는 데이터 조회를 의미하여 일부에서는 DQL(Data Query Language) 로 분류하기도 함 
    
 2. DDL(Data Definition Language) : 데이터 정의어
    -DB의 구조를 정의하거나 변경, 삭제하기 위한 언어
        *CREATE : 생성
        *ALTER : 수정
        *DROP : 삭제
   -테이블 변경과 관련
 3. DCL(Data Control Language) : 데이터 제어어
    -DB의 보안, 권한 관리, 무결성 제어를 위한 언어
        GRANT : 권한 부여
        REMOKE : 권한 회수
 4. TCL(Transaction Control Language) : 트랜잭션 제어어 <- 오라클에만 있음
    -트랜잭션 처리 밒 제어를 위한 언어
        *COMMIT : 실행
        *ROLLBACK : 취소
        *SAVEPOINT : 임시저장
*/
/*
    SELECT 컬럼1, 컬럼2,...
    FROM 테이블명
    
    -테이블에서 데이터를 조회할 때 사용하는 SQL 문
    -SELECT 실행 결과를 Result Set이라고 한다.
    -조회하고자 하는 컬럼은 반드시 FROM 절에 지정한 테이블에 존재해야 한다.
    -테이블의 모든 컬럼을 조회하려면 * 기호를 사용    
*/
--USER_INFO 테이블 전체 조회
SELECT * FROM USER_INFO;
--USER_INFO 이름(NAME), 나이(AGE), 취미(HOBBY) 조회
SELECT name, hobby From user_info;--MySQL 방식
SELECT NAME, AGE, HOBBY FROM USER_INFO;--오라클 : 대문자를 씀

--EMPLOYEE 테이블의 직원명(EMP_NAME), 이메일(EMAIL)조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE;
/*
컬럼 산술 연산
-SELECT 절에 컬럼 명 입력 부분에 산술 연산자를 사용하여 결과 조회

컬럼 별칭
-산술연산을 하게되면 컬렴명이 지저분해진다.
이때 컬럼명에 별칭을 부여하면 깔끔하게 보일 수 있다.
컬럼 AS 별칭/ 컬럼 AS "별칭"/ 컬럼 별칭/ 컬럼"별칭"
*/
--USER_INFO에서 나이(AGE)에 10년  전을 계산
SELECT 
NAME 이름,
AGE 나이,
AGE-10 AS "10년 전"
FROM USER_INFO;
SELECT * FROM USER_INFO;
--EMPLOYEE에서 직원명(EMP_NAME), 월급(SALARY), 연봉 조회
SELECT EMP_NAME, SALARY,SALARY*12 AS "연봉" FROM EMPLOYEE;
/*
리터럴(문자열)
-SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회 가능
-즉, 리터럴을 RESULT SET의 모든 행에 반복적으로 출력

연결 연산자: ||
-여러 컬럼값들을 마치 하나의 컬럼인것처럼 연결
-컬럼 값과 리터럴도 연결할 수 있음
*/
--SUSER_INFO에서 이름(NAME),나이(AGE),단위(살)조회
SELECT NAME, AGE||'살' "나이" FROM USER_INFO;
--USER_INFO에서 이름(NAME)의 MBTI는 XXXX입니다.
SELECT 
NAME||'의 MBTI는 '||MBTI||'입니다' "MBTI" FROM USER_INFO;

/*
DISTINCT
-컬럼에 중복된 값들을 한번씩만 표시하고자 할 때
-주의사항 : DISTINCT는 SELECT 절에서 한번만 기술 가능
*/
--USER_INFO에서 나이(AGE)가 중복되지 않게 조회
SELECT  DISTINCT AGE FROM USER_INFO;

--USER_INFO에서 MBTI가 중복되지 않게 조회
SELECT DISTINCT MBTI FROM USER_INFO;
/*
WHERE 절

SELECT 컬럼, 컬럼, ...FROM 테이블명 WHERE 조건식;
-조회하고자 하는 테이블로부터 "특정 조건" 에 만족하는 데이터만 조회하고자 할 때
-이때 WHERE 절에 조건식 제시
-조건식에는 다양한 연산자 사용 가능 

    *비교 연산자*
    = : 같음
    !=, <> : 같지 않음
    >,<,>=,<= : 대소 비교
    
*/

--USER_INFO에서 나이가 30이상인 이름(NAME), 나이(AGE), 생년월일(BIRTHDATE) 조회
SELECT NAME,AGE,BIRTHDATE FROM USER_INFO WHERE AGE>=30;
--EMPLOYEE에서 부서코드(DEPT_CODE)가 'D9'인 사원들(모든 컬럼)조회
--SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D9';
/*
OR(또는) , AND(그리고)

테이블 : USER_INFO
성별(GENDER)이 여자거나 나이(AGE)가 25살 연하인 사람들 조회

테이블 : EMPLOYEE
급여(SALARY)가 350만원 이상 600만원 이하를 받는 사람들 조회

*/

SELECT * FROM USER_INFO WHERE GENDER  = '여'OR AGE<=25;
SELECT * FROM EMPLOYEE WHERE SALARY >=3500000 AND SALARY <=6000000;
--BETWEEN AND 연산자
--조건식에서 사용되는 구문
--몇 이상, 몇 이하인 범위에 대한 조건을 제시할 때 사용
--컬럼 BETWEEN 하한값 AND 상한값
SELECT * FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 6000000;

--USER_INFO에서 나이가 25~30사이인 사람들 조회
SELECT * FROM USER_INFO WHERE AGE BETWEEN 25 AND 30;

/*
*** LIKE
- 비교하고자 하는 컬럼 값이 특정 패턴에 만족할 경우 조회
컬럼 LIKE '특정패턴'
-특정 패턴에는 '%', '_'를 와일드 카드로 사용
 _ : 한 글자
 _문자 : 앞에 한 글자 + 문자 
 __ : 앞에 두 글자 + 문자
_문자_: 앞 뒤에  한 글자씩 + 문자

% : 0글자 이상
문자% : 문자로 시작
%문자 : 문자로 끝남
%문자% : 문자가 앞 뒤 상관 없이 포함
->키워드 검색에 사용됨

*/

--테이블 : USER_INFO
-- 이름이 '은'으로 끝나는 경우 조회
SELECT * FROM USER_INFO WHERE NAME LIKE '%은';
-- 성이 '성'씨인 경우 조회
SELECT * FROM USER_INFO WHERE NAME LIKE '성__';
-- MBTI가 E면서 T인 경우 조회
SELECT * FROM USER_INFO WHERE MBTI LIKE 'E_T_';
--전화번호가 010-2XXX-XXXX인 경우 조회
SELECT * FROM USER_INFO WHERE CONTACT LIKE '010-2%';
--나이가 25이하면서 경기도에 사는 사람이거나 MBTI가 INTP인 경우
SELECT * FROM USER_INFO WHERE AGE <= 25 AND ADDRESS LIKE '경기%' OR MBTI LIKE '%INTP%';
--TABLE : ENPLOYEE
--이메일 중 앞글자가 3글자인 사원들 조회
--ESCAPE OPTION : 나만의 와일드 카드 만들어서 사용
SELECT * FROM EMPLOYEE WHERE EMAIL LIKE '___#_%' ESCAPE '#';
--위 사원들 이외의 사람들 조회
SELECT * FROM EMPLOYEE WHERE NOT EMAIL LIKE '___#_%' ESCAPE '#';

SELECT * FROM EMPLOYEE WHERE EMAIL NOT LIKE '___#_%' ESCAPE '#';
/*
IS NULL / IS NOT NULL
-컬럼 값에 NULL 이 있을 경우 NULL 값 비교에 사용되는 연산자
*/
SELECT * FROM USER_INFO WHERE MBTI IS NULL;

--EMPLOYEE에서 보너스(BONUS)를 받지 않는 사원들 조회
SELECT * FROM EMPLOYEE WHERE BONUS IS NULL;
--부서 배치를 아직 받지 않고(ERPT_CODE)보너스는 받는 사원들 조회
SELECT * FROM EMPLOYEE WHERE BONUS IS NOT NULL AND DEPT_CODE IS NULL;

/*

*/

--USER_INFO에서 MBTI가 INFP 또는 INTJ 인 사용자 조회
SELECT *
FROM USER_INFO
WHERE MBTI LIKE '%INFP%'
OR MBTI LIKE '%INTJ%'; 
-- IN() 연산자
/*
-컬럼값이 내가 제시한 목록중에 일치하는 값이 있는지
컬럼 IN('값1', '값2', ....); -> 검색 필터에서 사용
*/
SELECT *
FROM USER_INFO
WHERE MBTI IN ('INFP','INTJ');

--EMPLOYEE에서 부서코드(DEPT_CODE)가 D5,D6,D8인 사원들 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN('D5','D6','D8');
--직급 코드(JOB_CODE)RK J7이거나 J2인 사원들 중 급여가 200만원인 사원들 조회

--IN 연산자
SELECT * 
FROM EMPLOYEE 
WHERE JOB_CODE IN('J7','J2') 
AND SALARY >= 2000000;
--OR 연산자 
-- ->AND 가 먼저 되고 OR이 처리됨( 괄호로 묶으면 먼저 처리됨)

/*
연산자 순위
0. ( )
1. 산술 연산자 : *,/,+,-
2. 문자열 연결 : ||
3. 비교 연산자 : =, !=, <>, <, >, <=, >=
4. IS NULL / LIKE / IN / BETWEEN
5. NOT
6. AMD
7. OR
*/
SELECT * 
FROM EMPLOYEE 
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2') 
AND SALARY >= 2000000;

/*
ORDER BY
- SELECT 문 가장 마지막 줄에 작성 뿐만 아니라 
  실행순서 또한 마지막
  
3. SELECT 컬럼, 컬럼...
1. FROM 테이블명
2. WHERE 조건식
4. ORDER BY 정렬하고자 하는 컬럼값 ASC | DESC;

- ASC : 오름차순 정렬(생략시 기본값)
- DESC : 내림차순 정렬
*/
--USER_INFO에서 나이를 오름차순 정렬
SELECT * FROM USER_INFO ORDER BY AGE;
--MABI는 오름차순, 나이는 내림차순 정렬
SELECT * FROM USER_INFO ORDER BY MBTI, AGE DESC;

--조건은 MBTI가 I 인분들 조회(앞에있는 컬럼값을 먼저 정렬)
SELECT NAME, AGE , GENDER, MBTI FROM USER_INFO ORDER BY 4 ASC, 2 DESC;
--NULL 처리(오라클만 있음)
SELECT MBTI FROM USER_INFO ORDER BY MBTI DESC NULLS LAST;

SELECT * FROM USER_INFO WHERE MBTI LIKE 'I___'  ORDER BY MBTI, AGE DESC;

--EMPLOYEE에서 전체 사원의 사원명, 보너스 조회(보너스 기준 오름차순 정렬)
SELECT EMP_NAME , BONUS 
FROM EMPLOYEE 
ORDER BY BONUS NULLS FIRST; -- 오름차순인 경우는 NULL이 뒤에 있음 

SELECT EMP_NAME , BONUS 
FROM EMPLOYEE 
ORDER BY BONUS DESC NULLS LAST; -- 내림차순인 경우는 NULL이 앞에 있음

/*
    GROUP BY 
    -그룹 기준을 제시할 수 있는 구문
    -여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용
*/
--MBTI별 평균 나이
SELECT 
MBTI,AVG(AGE)"평균 나이",SUM(AGE)"나이 합",COUNT(*)"인원 수"
FROM USER_INFO
GROUP BY MBTI;

--EMPLOYEE : 성별 사원 수 조회
SELECT 
DECODE(SUBSTR(EMP_NO,8,1),1,'남',2,'여'),
COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO,8,1);

/*
    HAVING
    -그룹에 대한 조건을 제시할 때 사용하는 구문
    
    SELECT 실행 순서
    5 SELECT * / 컬럼/ 함수
    1 FROM    테이블명
    2 WHERE   조건식
    3 GROUP BY 그룹 기준에 해당하는 컬럼|함수
    4 HAVING 조건식(그룹 함수)
    6 ORDER BY 컬럼 / 별칭 / 컬럼순번 (숫자)
*/

--EMPLOYEE에서 부서별 평균 급여가 300만원 이상인 직원의
--평균 급여 조회(부서 코드 - DEPT_CODE, 급여 - SALARY)
SELECT
DEPT_CODE,
 TO_CHAR(FLOOR(AVG(NVL(SALARY,0))),'9,999,999')
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;


--직급별(JOB_CODE) 총 급여의 합이 1000만원 이상인 직급만 조회

SELECT 
JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >=10000000;

--부서 별 보너스 받는 사원이 없는 부서만 조회
SELECT 
DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

--USER_INFO에서 MBTI별 평균 나이를 계상하는데 평균 나이가 30 이하인 MBTI만 조회
--단, 나이가 100살 이상인 경우는 제외

SELECT 
ROUND(AVG(AGE),2)
FROM USER_INFO
GROUP BY MBTI
HAVING AVG(AGE) <= 30;
/*----------------------------------------------------------------------------*/

--학생 정보 관리 테이블
create sequence seq_sungtb_no;

create table sungtb(
no Number(3) primary key,
name varchar2(50),
kor number(3),
eng number(3),
mat number(3)
);

--샘플 데이터
insert into sungtb values(seq_sungtb_no.nextVal, '문채은', 87,88,65);

select * from system.sungtb;
select * from sungtb;
insert into system.sungtb values(seq_sungtb_no.nextVal,'이름',100,90,80);

delete from sungtb where no = 3;

commit;

create table dept(
    deptNo number(2) primary key,
    dname varchar2(20),
    loc varchar2(20)
);
select * from system.dept;

create sequence seq_member_no;

create table member(
    idx number(2) primary key,
    name varchar2(20),
    id varchar2(20),
    pwd varchar2(20),
    email varchar2(50),
    addr varchar2(50)
);
insert into member values(seq_member_no.nextVal,'감자','rkawk','1234','gamza@gmail.com', '감자밭');
insert into system.member values(seq_member_no.nextVal,'테스트01','test01','1234','email.com', '지구');

select * from member;

create sequence seq_member_idx;
drop table member;

alter table member modify pwd varchar2(100);

create table member(
   idx number(3) primary key, 
   name VARCHAR2(50), 
   id varchar2(50), 
   pwd varchar2(50), 
   email varchar2(100), 
   addr varchar2(200)   
);

insert into member values(
   seq_member_idx.nextVal, 
   '홍길동', 
   'one', 
   '1234', 
   'one@korea.com', 
   '서울시 은평구'
);


drop table dept;
create table dept(
   deptno number(2) primary key, 
   dname varchar2(20), 
   loc varchar2(20)
);

insert into dept values( 50, '경리부', '505' );
commit;


--학생 정보관리 테이블
create sequence seq_sungtb_no;

drop SEQUENCE seq_sungtb_no;
drop table sungtb;

create table sungtb(
   no Number(3) primary key, 
   name varchar2( 50 ), 
   kor number(3), 
   eng number(3), 
   mat number(3)
);

--샘플데이터
insert into sungtb values( 
   seq_sungtb_no.nextVal, 
   '일길동', 
   77, 88, 99
);

commit;

create sequence seq_pro_idx;

--상품 테이블
create table product(
	idx number(3) primary key,
	category varchar2(80),
	p_num varchar2(100) unique,
	p_name varchar2(200),
	p_company varchar2(100),
	p_price number(10),
	p_saleprice number(10),
	p_image_s varchar2(255),
	p_image_l varchar2(255),
	p_content CLOB,
	p_date date
);

select * from product;

--샘플 테이터

select * from product;
insert into product values(
seq_pro_idx.nextVal,
'sp003',
'RC-113',
'인사인 스케이트',
'apple',
50000,
35000,
'pds1.jpg',
'pds1_z.jpg',
'바이오맥스 통풍 나잉온 재질 인라인',
sysdate);

insert into product values(
seq_pro_idx.nextVal,
'ele002',
'vcx-123',
'브라운관 tv',
'sony',
990000,
870000,
'pds4.jpg',
'pds4_z.jpg',
'레트로 장비 티비 모니터 소품 브라운관 TV 아날로그',
sysdate);

update product set
p_name = '인라인 스케이트'
where idx = 1;
commit;

create sequence seq_cart_idx;

select * from dept;
delete from dept;

create sequence seq_visit_idx;
create table visit(
    idx number(3) primary key,
    name varchar2(50), -- 작성자
    content VARCHAR2(2000), -- 내용
    pwd VARCHAR2(100), -- 비밀번호
    ip VARCHAR2(30), -- ip
    regdate Date -- 작성일
);
-- 샘플 데이터
insert into visit values(
    seq_visit_idx.nextVal,
    '문채은',
    '내가 일등했어요.',
    '1234',
    '192.1.1.1',
    sysdate
);

alter table visit add filename varchar2(100);
commit;


insert into visit values(
    seq_visit_idx.nextVal,
    '엘풍',
    '풀 페어리 최강',
    '1234',
    '192.2.2.2',
    sysdate
);


commit;
select * from visit;





create sequence seq_cart_idx;

create table cart(
   c_idx number(3) primary key, --장바구니 일련번호
   c_cnt number(3), --수량
   idx number(3), -- 상품번호
   m_idx number(3) --회원번호
);

alter table cart
add constraint fk_cart foreign key( idx )
references product( idx );

--장바구니에 임시로 제품을 추가
insert into cart values( seq_cart_idx.nextVal, 1, 4, 1 );
insert into cart values( seq_cart_idx.nextVal, 1, 5, 1 );
insert into cart values( seq_cart_idx.nextVal, 1, 2, 1 );
commit;

--장바구니 조회용 view
create or replace view cart_view AS
select p.idx, c_idx, p_num, p_name, p_price, p_saleprice, 
   c_cnt, m_idx, p_image_s, c_cnt * p_saleprice amount
from product p, cart c
where p.idx = c.idx;

select * from cart_view;









