/*
    시퀀스(SEQUENCE)
    -번호를 자동으로 생성하는 객체
    -주로 PK 값 자동생성

    CREATE SEQUENCE 시퀀스 명
    START WITH 시작값 (지정 안하면 기본값 1)
    INCREMENT BY 증가값 (지정 안하면 기본 값 1) -> 얼마씩 증가하는지
    MAXVALUE 최대값 (기본값 큼)
    MINVALUE 최소값 (지정 안하면 기본값 1)
    CYCLE / NOCYCLE (기본값 NOCYCLE) -> 값 순환 여부
    CACHE / NOCACHE (기본값 CACHE 20) -> 캐시 메모리 할당여부;
    
    *캐시 메모리
    -미리 발생된 값들을 생성해서 저장해두는 공간
    -매번 호출될 때마다 새로 번호를 생성하는 게 아니라 캐시 메모리 공간에
        미리 생성된 값들을 가져다 쓸 수 있음(속도가 빨라짐)
        -접속이 해제되면 -> 캐시 메모리에 미리 만들어 둔 번호들은 다 날라감
        
        * 객체 명칭
        테이블명 : TB_
        시퀀스명 : SEQ_
        뷰명 : VW_
        트리거명 : TRG_
*/
DROP SEQUENCE SEQ_EMP_ID;
/*미친 배고픔*/
CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;


--현재 계정이 소유하고 있는 시퀀스들의 구조를 보고자 할 때
SELECT * FROM USER_SEQUENCES;
/*
    시퀀스명.CURRVAL : 현재 시퀀스 값
    시퀀스명.SEXTVAL : 시퀀스에 일정값을 증가시켜서 발생된 값
                        시퀀스명.CURRVAL + INCREMENT BY 값
*/
--CURRVAL 은 한번이라도 NEXTVAL가 수행되지 않으면 가져올 수 없음!
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
--ㅡMAXLVAL가 초과하고 NOCYCLE인 경우
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;



/*
    ALTER SEQUENCE 시퀀스명
    INCREMENT BY 증가값 
    MAXVALUE 최대값 
    MINVALUE 최소값 
    CYCLE / NOCYCLE 
    CACHE / NOCACHE 바이트 크기
    
    -> START 위치는 변경 불가!
    */
    ALTER SEQUENCE SEQ_EMPID
    INCREMENT BY 10
    MAXVALUE 400;
    
    SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
    
    /*
        시퀀스 삭제
        DROP SEQUENCE 시퀀스명;
    */
    DROP SEQUENCE SEQ_EMPID;
    /*
        시퀀스명 : SEQ+TEST
        시작값 : 300
        증가값 : 1
        최대밧 : 1000
        순환없음
        캐시 사용 안함
    */
    
    CREATE SEQUENCE SEQ_TEST
    START WITH 300
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
    
    
/*
    뷰(VIEW)
    - SELECT 문을 저장할 수 있는 객체
    - 가상 테이블 (실제 데이터가 담겨있는 건 아님 -. 논리적인 테이블)
    -DML(INSERT, UPDATE, DELETE)작업 가능(단, 일부만!)
    
    *사용 목적
    -편리성 : SELECT 문의 복잡도 완화
    -보완성 : 테이블의 특정 열을 노툴하고 싶지 않은 경우
*/
SELECT * FROM NATIONAL;--국가명
SELECT * FROM LOCATION;--지역명
SELECT * FROM  JOB;--직업
SELECT * FROM DEPARTMENT;--부서
SELECT * FROM EMPLOYEE;--사원
SELECT * FROM  SAL_GRADE;--등급

-- 한국에서 근무하는 사원들의 사번,이름, 부서명, 급여, 근무 국가명 조회

SELECT EMP_ID,EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

-- 중국에서 근무하는 사원들의 사번,이름, 부서명, 급여, 근무 국가명 조회

SELECT EMP_ID,EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '중국';

-- 일본에서 근무하는 사원들의 사번,이름, 부서명, 급여, 근무 국가명 조회

SELECT EMP_ID,EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME = '일본';

/*
    뷰 생성
    
    CREATE OR REPLACE FORCE / NOFORCE VIEW 뷰명
    AS 서브쿼리 --어떤 SELECT 인지
    WITH CHECK OPTION
    WITH READ ONLY;
    
    * VIEW 옵션들
    - OR REPLACE : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성,
                    기존에 중복된 이름의 뷰가 있다면 해당 뷰 변경하는 옵션
    - FORCE : 서브쿼리에 기술된 테이블이 존재하지 않느 테이블이어도 뷰 생성
    - NONFORCE : 서브쿼리에 기술된 테이블이 존재해야만 뷰 생성 (기본값)
    - WITH CHECK OPTION : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로
                                                수정하는 경우 오류 발생
    -WITH READ ONLY : 뷰에 대해 조회만 가능(DML[수정,삭제] 수행 불가)                                             

*/
--관리자 계정으로 CREATE VIEW 권한 부여
ALTER SESSION SET CONTAINER = XEPDB1;
GRANT CREATE VIEW TO kh;

CREATE OR REPLACE VIEW VM_EMPLOYEE
AS  SELECT EMP_ID,EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
    JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
    JOIN NATIONAL USING(NATIONAL_CODE);
    
-- 한국에서 근무하는 사원들의 사번,이름, 부서명, 급여, 근무 국가명 조회
SELECT * FROM VM_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

/*
    뷰 컬럼에 별칭을 부여해야 하는 경우
    -서브쿼리의 SELECT 절에 함수식이나 산술연산식이 기술되어 있을경우
    반드시 별칭 부여!
*/
-- 사원의 사번, 사원명 직급명,성별,근무년수 조회
--VIEW 명 : VW_EMP_JOB

SELECT * FROM  JOB;--직업
SELECT * FROM EMPLOYEE;--사원

SELECT * FROM EMPLOYEE
WHERE EMP_NO LIKE '______-1%';

SELECT INSTR(EMP_NO,'-')+1 FROM EMPLOYEE;

SELECT EMP_ID,EMP_NAME,JOB_NAME,
DECODE(SUBSTR(EMP_NO,8,1),1,'남',2,'여')"셩별",
(EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM HIRE_DATE))"년도"
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

CREATE OR REPLACE VIEW VW_EMP_JOB("사번","사원명","직급명","성별","근무년수")
AS
SELECT EMP_ID,EMP_NAME,JOB_NAME,
DECODE(SUBSTR(EMP_NO,INSTR(EMP_NO,'-')+1,1),1,'남',2,'여'),
(EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM HIRE_DATE))
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

SELECT 사원명 , 직급명 FROM VW_EMP_JOB
WHERE 근무년수 >= 20 AND 성별 = '남';

/*
 VIEW를 이용해서 (INSERT,UPDATE, DELETE) 사용가능
 -뷰를 통해서 조작하게 되면 실제 데이터가 담겨있는 베이스 테이블에 반영
*/

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME FROM JOB;

--INSERT
INSERT INTO VW_JOB VALUES('J8','인턴');
SELECT * FROM VW_JOB;

SELECT 
ROUND((SYSDATE - HIRE_DATE/365)) FROM EMPLOYEE;

--UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

SELECT * FROM VW_JOB;

--DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';

SELECT * FROM VW_JOB;

/*
    DML 구문으로 VIEW 조작이 불가능한 경우
*/
--VIEW 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE FROM JOB;

--INSERT
INSERT INTO VW_JOB VALUES('J8','인턴');-- JOBNAME이 없음
INSERT INTO VW_JOB VALUES('J8');-- JOBNAME이 없음

SELECT * FROM VW_JOB;
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8'; -- JOB_NAME 이 없어서 안됨

--DELETE
DELETE FROM VW_JOB
WHERE JOB_CODE = 'J8';

DELETE FROM VW_JOB
WHERE JOB_NAME = '사원';--VIEW에 JOB_NAME이 존재하지 않아서

SELECT * FROM VW_JOB;

--2. 뷰에 포함되지 않은 컬럼 중에서 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME FROM JOB;

SELECT * FROM VW_JOB;


--INSERT
INSERT INTO VW_JOB VALUES('인턴');-- JOB_CODE에 NOT NULL 조건이 걸려 있어서 X
SELECT * FROM VW_JOB;

--UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_NAME = '사원';

SELECT * FROM VW_JOB;
ROLLBACK;
--DELETE
DELETE FROM VW_JOB
WHERE JOB_NAME = NULL;

SELECT * FROM VW_JOB;

-- 3. 산술 표현식 또는 함수식으로 정의된 경우
-- 뷰명 : VW_EMP SAL
--컬럼 : EMP_ID,EMP_NAME, SALARY, SALARY * 12

CREATE OR REPLACE VIEW VW_EMP_SAL
AS 
SELECT EMP_ID,EMP_NAME, SALARY, SALARY * 12 "연봉"
FROM EMPLOYEE;

--INSERT
INSERT INTO VW_EMP_SAL
VALUES(300,'최다인',3000000,36000000);--가상 열은 사용할 수 없습니다.

ALTER TABLE EMPLOYEE MODIFY EMP_NO NULL;

INSERT INTO VW_EMP_SAL(EMP_ID,EMP_NAME,SALARY)
VALUES(300,'최다인',3000000);--가상 열은 사용할 수 없습니다.

SELECT * FROM VW_EMP_SAL;-- 연봉은 자동 계산

--UPDATE
-- 300번 사원의 연봉을 9600만원으로
UPDATE VW_EMP_SAL
SET SALARY = 8000000
WHERE EMP_ID = 300;

--DELETE
DELETE FROM VW_EMP_SAL WHERE EMP_ID = 300;
ROLLBACK;

SELECT * FROM VW_EMP_SAL;

-- 4. 그룸 함수나 GROUP BY 절을 포함하는 경우
--뷰 명 ; VW_GROUPDEPT
--컬럼 : 부서별 급여 합계, 급여 평균
SELECT * FROM VW_GROUPDEPT;

CREATE OR REPLACE VIEW VW_GROUPDEPT
AS
SELECT DEPT_CODE,SUM(SALARY)"급여합계", ROUND(AVG(SALARY))"급여평균"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

--INSERT
INSERT INTO VW_GROUPDEPT
VALUES('D0', 100000,10000); --그룹 함수들은 이미 계산된 함수이기 때문에 쓸 수 없음

INSERT INTO VW_GROUPDEPT(DEPT_CODE)
VALUES("D0");

--UPDATE

UPDATE VW_GROUPDEPT
SET "급여합계" = 2000000
WHERE DEPT_CODE = 'D1';

--DELETE
DELETE FROM VW_GROUPDEPT
WHERE "급여합계" = 17700000;

DELETE FROM VW_GROUPDEPT
WHERE DEPT_CODE = 'D1';

SELECT * FROM VW_GROUPDEPT;

-- 5. DISTINCT 구문이 포함되어있는 경우
CREATE OR REPLACE VIEW VW_DT_JOB
AS
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;

--INSERT
INSERT INTO VW_DT_JOB
VALUES('J8');

--UPDATE
UPDATE VW_DT_JOB
SET JOB_CODE = 'J8'
WHERE JOB_CODE = 'J7';

--DELETE
DELETE FROM VW_DT_JOB
WHERE JOB_CODE = 'D1';

-- 6. JOIN을 이용해서 여러 테이블을 연결하는 경우

--뷰명 : VW_JOINEMP
--컬럼 : EMP_ID,EMP_NAME,DEPT_TITLE

SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;

CREATE OR REPLACE VIEW VW_JOINEMP
AS
SELECT EMP_ID,EMP_NAME,DEPT_TITLE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE);
--INSERT
-- JOIN 뷰에 의하여 기본 테이블 이외의 컬럼을 수정하지 못한다.
INSERT INTO VW_JOINEMP VALUES(300,'문채은','총무부'); 

INSERT INTO VW_JOINEMP(EMP_ID,EMP_NAME) VALUES(300,'문채은'); 

SELECT * FROM VW_JOINEMP;

--UPDATE
UPDATE VW_JOINEMP
SET EMP_NAME = '간성훈'
WHERE EMP_ID = 300;

--UPDATE
UPDATE VW_JOINEMP
SET DEPT_CODE = '인사관리부'
WHERE EMP_ID = 300;
 
SELECT * FROM VW_JOINEMP;

--DELETE

DELETE FROM VW_JOINEMP
WHERE DEPT_TITLE = '총무부';

SELECT * FROM VW_JOINEMP;

ROLLBACK;

-- VIEW 옵션들
-- FORCE: 존재하지 않아도 일단 뷰부터 생성 가능 
-- NOFORCE(기본값) : 존재하는 테이블만 뷰가 생성됨
-- 컴파일 오류와 함께 뷰가 생성되었습니다. -> 그래도 만들어짐!

CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT * FROM TEST;

CREATE TABLE TEST
(
    TID NUMBER
);

-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 오류 발생
CREATE OR REPLACE VIEW VW_EMP
AS SELECT * FROM EMPLOYEE
WHERE SALARY >= 3000000
WITH CHECK OPTION;
-- WITH CHECK OPTION 이 있는 경우 해당 조건에 위배가 되어 변경 불가

--200번 사원의 급여를 400만원으로 변경
UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200;

--WITH READ ONLY : 뷰에 대해 조회만 가능 (DML 수행 불가)
CREATE OR REPLACE VIEW VW_DEPT
AS SELECT * FROM DEPARTMENT
WITH READ ONLY;

--INSERT
INSERT INTO VW_DEPT
VALUES('D0', '개발부','L1');

--UPDATE
UPDATE VW_DEPT
SET DEPT_TITLE = '디자인부'
WHERE DEPT_ID = 'D0';

--DELETE
DELETE FROM VW_DEPT
WHERE DEPT_ID = 'D0';

SELECT * FROM VW_DEPT;
ROLLBACK;

/*
    INDEX 
    - SQL 명령문의 처리속도를 향상시키기 위해서 행들의 위치정보를 가지고 있다.
    
    * 데이터 검색 방식
    1. TABLE FULL SCAN : 테이블 데이터를 처음부터 끝까지 검색하여 원하는 데이터를 찾는 방식
    2. INDEX SCAN : 인덱스를 통해 데이터를 찾는 방식
*/
-- 현재 인덱스 정보

SELECT * FROM USER_INDEXES;
SELECT *FROM  USER_IND_COLUMNS;

--데이터가 얼마 없으면 오라클에서 굳이 인덱스 사용해서 데이터 조회 X 
SELECT * FROM USER_INFO
WHERE USER_ID = 1;

SELECT * FROM USER_INFO
WHERE NAME = '간성훈';


/*
    INDEX 생성
    CREATE  INDEX 인덱스명
    ON테이블명(컬럼,컬럼,...);
*/
--인덱스 부여
CREATE INDEX IDX_USER_NAME
ON USER_INFO(NAME);

CREATE INDEX IDX_USER_ID_NAME
ON USER_INFO(USER_ID,NAME); -- 결합 인덱스 생성

--인덱스 삭제
DROP INDEX IDX_USER_ID_NAME;

/*
    동의어(SYNONYM) -> 별칭 부여
    - 데이터 베이스 객체에 별칭을 생성
    
    CREATE SYNONYM 동의어명
    FOR 사용자.객체명;
*/
--SYSTEM
ALTER SESSION SET CONTAINER = XEPDB1;
GRANT CREATE SYNONYM TO kh;
-- KH
CREATE SYNONYM EMP -- 별칭 부여
FOR EMPLOYEE;
SELECT * FROM EMP;

--관리자 게정으로 접속해서 공개 SYNONYM 생성
CREATE PUBLIC SYNONYM DEPT FOR kh.DEPARTMENT;

SELECT * FROM DEPT;
--TEST 계정 생성하고 권한 부여
CREATE USER test IDENTIFIED BY test;
GRANT CONNECT,RESOURCE TO test;
GRANT SELECT ON kh.DEPARTMENT TO test;

SELECT * FROM DEPT;


/*
    커서(CURSOR)
    - SQL 쿼리의 결과가 여러 행일 때 처리 결과를 한 행씩 처리하는 객체
    
    1. 묵시적(INPLICIT) 쿼리
        - 오라클에서 자동으로 생성되어 사용하는 커서
        - PL / SQL 에서 SQL 문 실행시 자동으로 만들어져서 사용
        
    2. 명시적(ECPLICIT) 쿼리
        - 사용자가 직접 선언해서 사용할 수 있는 커서
        
        CURSOR 커서명 IS SELECT 문
        
        OPEN 커서명
        FETCH 커서명 INTO 변수, ...
        ...
        CLOSE 커서명
*/

CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

-- PL / SQL 에서 EMP_COPY 테이블에 BONUS가 NULL인 사원의 BONUS를 0으로 수정

--묵시적 커서
BEGIN
UPDATE EMP_COPY
SET BONUS = 0
WHERE BONUS IS NULL;

DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '행 수정됨');
END;
/

--PL / SQL 에서 급여가 300만원 이상인 사원들 출력(사번,사원,급여)
--명시적 커서
DECLARE
EID EMPLOYEE.EMP_ID%TYPE;
ENAME EMPLOYEE.EMP_NAME%TYPE;
SAL EMPLOYEE.SALARY%TYPE;


    CURSOR CUR IS 
            SELECT EMP_ID, EMP_NAME, SALARY
            FROM EMPLOYEE
            WHERE SALARY >= 3000000;
BEGIN
    OPEN CUR;
        LOOP
        FETCH CUR INTO EID, ENAME, SAL;
        EXIT WHEN CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(EID || ''||ENAME||''||SAL);
        END LOOP;
        CLOSE CUR;
END;
/

--FOR LOOP
-- 1. LOOP 시작 시 자동으로 커서 오픈! (즉,OPEN 필요 X)
-- 2. 반복할 때마다 FETCH도 자동
-- 3. LOOP 종료 시 자동으로 커서 CLOSE
DECLARE
    EMP EMPLOYEE%ROWTYPE;
BEGIN
        FOR EMP IN (
            SELECT EMP_ID,EMP_NAME,SALARY
            FROM EMPLOYEE
            WHERE SALARY >= 3000000)
        LOOP    
                DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || ''||EMP.EMP_NAME||''||EMP.SALARY);
        END LOOP;
END;
/
/*
    프로시저 (PROCEDURE)
    -PL / SQL 문을 저장하여 필요할 때마다
    복잡한 구문을 다시 입력할 필요 없이 간단하게 호출
    
    CREATE OR REPLACE PROCEDURE 프로시저명(
    
        매개변수 IN / OUT 데이터 타입, ...
            - IN : 사용자로부터 값을 입력받아 PROCEDURE로 전달해주는 역할
            - OUT : PROCEDURE에서 호출 환경으로 값을 전달하는 역할
    )
    IS <- DECLARE 역할
    BEGIN 실행부
    EXCEPTION 예외처리부
    END 프로시저명;
    /
    
    호출 시 
    EXECUTE(또는 EXEC) 프로시저명(매개값, ..);
    
    삭제
    DROP PROCEDURE 프로시저명;
*/

--EMP_COPY에 모든 데이터를 삭제하는 프로시저 생성
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_COPY;
END;
/
--프로시저 실행
EXEC DEL_ALL_EMP;

-- 매개변수가 있는 프로시저
-- 사번을 입력받아서 해당하는 사원을 삭제하는 프로시저 생성
-- 프로시저명 : DEL_ALL_EMP;

CREATE OR REPLACE PROCEDURE DEL_EMP_ID(EID EMP_COPY.EMP_ID%TYPE)
IS
BEGIN
DELETE FROM EMP_COPY
WHERE EMP_ID = EID;
END DEL_EMP_ID;
/

EXEC DEL_EMP_ID('&사번'); 
SELECT * FROM EMP_COPY;
ROLLBACK;

-- IN / OUT 매개변수가 있는 프로시저
-- 사번을 입력받아서 해당하는 사원의 이름(EMP_NAME), 급여(SALARY)
-- 프로시저명 : SEL_EMP_ID
--변수명 : EID(IN),ENAME(OUT),SAL(OUT)
CREATE OR REPLACE PROCEDURE SEL_EMP_ID(
    EID IN EMP_COPY.EMP_ID%TYPE,
    ENAME OUT EMP_COPY.EMP_NAME%TYPE,
    SAL OUT EMP_COPY.SALARY%TYPE
)
IS
BEGIN
    SELECT EMP_NAME, SALARY
    INTO ENAME, SAL
    FROM EMP_COPY
    WHERE EMP_ID = EID;
END SEL_EMP_ID;
/

--바인드 변수 : VAR 변수명 데이터 타입
VAR VAR_EMP_NAME VARCHAR2(30);
VAR VAR_SALARY NUMBER;
EXEC SEL_EMP_ID('&사번',:VAR_EMP_NAME,:VAR_SALARY);

--바인드 변수에 담긴 값 출력 따로
PRINT VAR_EMP_NAME;
PRINT VAR_SALARY;

/*
    함수 (FUNCTION)
    -프로시저와 거의 유사한 용도로 사용하지만, 
        실행 결과를 되돌려 받을 수 있다.(RETURN)
    
    CREATE OR REPLACE FUNCTION 함수명(
        매개변수 데이터 타입, ...
    )
    RETURN 데이터타입 
    IS <- DECLARE 역할
    BEGIN
        실행부
        RETURN 반환값;
    EXCEPTION 예외처리부
    END 함수명;
    /
    호출 시 
    EXECUTE(또는 EXEC) 함수명(매개값, ..);
    
    삭제
    DROP FUNCTION 함수명;
*/
-- 사번(EID)를 입력받아서 해당 사원의 연봉을 계산하여 RETURN 하는 함수 생성
--함수명 : SAL_CALC

CREATE OR REPLACE FUNCTION SAL_CALC(
    EID EMP_COPY.EMP_ID%TYPE
)
RETURN NUMBER 
IS 
SAL EMP_COPY.SALARY%TYPE;
BEGIN
    SELECT SALARY
    INTO  SAL
    FROM EMP_COPY
    WHERE EMP_ID = EID;

    RETURN SAL * 12;
END SAL_CALC;
/

SELECT EMP_NAME, SALARY,SAL_CALC(EMP_ID) 
FROM EMPLOYEE;

ROLLBACK;
/*
    트리거(TRIGER)
    -테이블이나 뷰가 DML(INSERT, UPDATE, DELETE)문에 의해 변경될 경우
        자동으로 실행될 내용을 정의하여 저장
        
        CREATE OR REPLACE TRIGGER 트리거명
        BEFORE / AFTER,  INSERT / UPDATE / DELETE ON 테이블명
        FOR EACH ROW
        DECLARE 변수 선언
        BEGIN 실행 내용(지정된 이벤트 발생시 자동으로 실행할 구문)
        EXCEPTION 예외처리
        END;
        /
        
        - BEFORE : 이벤트가 발생되기 전에 트리거 실행 
        -AFTER : 이벤트가 발생된 후에 트리거 실행
*/

--EMPLOYEE 테이블에 새로운 행이 INSERT 될 때 '신입사원이 입사했습니다!' 출력

CREATE OR REPLACE TRIGGER ADD_EMP
AFTER INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다!');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME) VALUES(400,'강성모');

-- :OLD : 수정, 삭제전 데이터에 접근 가능
-- :NEW : 추가, 수정 후 데이터에 접근 가능
-- EMPLOYEE 체이블에 UPDATE 수행 후'변경전 : 값, 변경후 : 값'
--트리거명 : PUT_EMP

CREATE OR REPLACE TRIGGER PUT_EMP
AFTER UPDATE ON EMPLOYEE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('변경전 :' ||:OLD.EMP_NAME); 
DBMS_OUTPUT.PUT_LINE(' 변경후 :' || :NEW.EMP_NAME);
END;
/

UPDATE EMPLOYEE
SET EMP_NAME = '박지연'
WHERE EMP_ID = 400;


CREATE TABLE TB_PRODUCT(
    PCODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL, -- 상품명
    PRICE NUMBER, --상풉 가격
    STOCK NUMBER DEFAULT 0 -- 상품 수량
);

INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('TV', 10000, DEFAULT);
INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('PHONE', 20000, 10);
INSERT INTO TB_PRODUCT(PNAME, PRICE, STOCK) VALUES('NOTEBOOK', 15000, 20);
SELECT * FROM TB_PRODUCT;
--입출고때 알림
CREATE TABLE TB_PRODETAIL(
    DCODE NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    PCODE NUMBER REFERENCES TB_PRODUCT,
    PDATE DATE DEFAULT SYSDATE, -- 상품 입출고일
    AMOUNT NUMBER, -- 입출고 수량
    STATUS CHAR(10) CHECK(STATUS IN ('입고', '출고')) -- 상태
);

--1번 TV 상품 오늘 날짜로 10개 입고
INSERT INTO TB_PRODETAIL(PCODE, AMOUNT,STATUS)
VALUES (1,10,'입고');
--> 1번 TV 상품의 재고 수량이 10개 증가
UPDATE TB_PRODUCT
SET STOCK = STOCK +10
WHERE PCODE = 1;
--2번 PHONE 상품이 오늘 날짜로 5개 출고

--> 2번 PHONE 상품의 재고 수량이 5개 감소
INSERT INTO TB_PRODETAIL(PCODE, AMOUNT, STATUS)
VALUES(2,-5,'출고');

UPDATE TB_PRODUCT
SET STOCK = STOCK -5
WHERE PCODE = 2;


---TB_PRODETAIL 테이블에 INSERT 발생시
--TB_PRODUCT 테이블에 매번 자동으로 재고수량 UPDATE되게끔 트리거 정의
--트리거명 : TRG_PRO
CREATE OR REPLACE TRIGGER TRG_PRO
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
BEGIN
--입고
IF  :NEW.STATUS = '입고'

THEN UPDATE TB_PRODUCT
     SET STOCK = STOCK + :NEW.AMOUNT
     WHERE PCODE = :NEW.PCODE;
END IF;     
--출고
IF :NEW.STATUS = '출고'
     THEN UPDATE TB_PRODUCT
          SET STOCK = STOCK - :NEW.AMOUNT
          WHERE PCODE = :NEW.PCODE;
END IF;
DBMS_OUTPUT.PUT_LINE('변경됨');
END;
/
INSERT INTO TB_PRODETAIL(PCODE, AMOUNT,STATUS)
VALUES (3,4,'입고');


SELECT * FROM TB_PRODUCT;
SELECT * FROM TB_PRODETAIL;
