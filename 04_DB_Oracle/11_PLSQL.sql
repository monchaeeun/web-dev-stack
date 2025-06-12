/*
    PL / SQL(PROCEDURE LANGUAGE EXTENSION TO SQL)
    - 오라클에서 제공하는 절차적인 프로그래밍 언어
    - SQL 문장 내에서 변수의 정의, 조건 처리(IF), 반복처리(LOOP, FOR, WHILE) 등을
        지원하는 SQL 의 단점을 보완
        
    - 다수의 SQL 문을 한번에 실행 가능 (BLOCK 구조)
    
    *블록(BLOCK) : 명령어를 모아둔 PL/ SQL 프로그램의 기본 단위
    
    * PL / SQL 구조
    -[선언부 (DECLARE SECTION] 
    : DECLARE 시작, 변수나 상수를 선언 및 초기화
    -실행부(EXECUTABLE SECTION) 
    : MEGIN 시작, SQL 문 또는 제어문(조건문, 반복문) 등의 로직을 기술하는 부분
    
    -[예외처리부(EXCEPTION SECTION)]
    : EXCEPTION 시작, 예외 발생 시 해결하기 위한 구문을 미리 기술
*/


SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/ 
-- / <- 무조건 명시@!

/*
    DECLARE 선언부
    - 변수 및 상수를 선언하는 공간(선언과 동시에 초기화도 가능)
    -일반 타입 변수, 레퍼런스 타입 변수, ROW 타입 변수
*/
DECLARE 
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14; --상수값 지정

BEGIN
EID:= &번호;
WNAMW := '&이름';
DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/
--박나라 사원의 사번, 직원명, 급여 정보를 조회해서 출력
--레퍼런스 타입 변수 : 변수명 테이블명.컬럼명%TYPE;

DECLARE
EID EMPLOYEE.EMP_ID%TYPE;
ENAME EMPLOYEE.EMP_NAME%TYPE;
SAL EMPLOYEE.SALARY%TYPE;
BEGIN
SELECT EMP_ID,EMP_NAME,SALARY
INTO EID, ENAME, SAL
FROM EMPLOYEE
WHERE EMP_NAME = '&이름';

DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/

/*

EMPLOYEE,DEPARTMENT 테이블
컬럼 : EMP_ID, EMP_NAME, DEPT_TITLE
조회 : EMP_ID로 해당 부서가 어디인지
*/

DECLARE
EID EMPLOYEE.EMP_ID%TYPE;
ENAME EMPLOYEE.EMP_NAME%TYPE;
DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
INTO EID,ENAME,DTITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE EMP_ID = '&사번';

DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
DBMS_OUTPUT.PUT_LINE('부서 : ' || DTITLE);
 
END;
/


    