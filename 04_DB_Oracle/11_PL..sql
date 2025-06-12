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
DBMS_OUTPUT.PUT_LINE('HELLO ORACLE')
END/
-- / 무조건 명시@!