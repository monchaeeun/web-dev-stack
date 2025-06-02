-- Oracle 12c 이상부터 도입
--CDB (Container Database)<- 컨테이너 역할을 하는 DB, 여러개의 PDB를 포함할 수 있음
--PDB (Pluggable Database)<- CDB 안에 존재하는 독립된 데이터베이스(논리적 DB)
-- CDB 에 접속하려면 공용 사용자를 만들 수 있는데 계정 이름에 C## 접두사가 필요(CDB는 이름 맘대로 못함)
-- PDB 에 접속하면 PDB 전용 사용자를 만들 수 있으며 C## 접두사가 필요 없음
--SELRCT 테이블에서 찾아주는 애
SELECT PDB_NAME FROM DBA_PDBS;
-- 쿼리문 실행 : ctrl + enter
--세션 변경
ALTER SESSION SET CONTAINER = XEPDB1;

--사용자 계정 생성하는 구문 : 관리자 계정만 할 수 있는 역할
--CREATE USER 계정명 IDENTIFIED BY 비밀번호;
--유저 아이디 : kh,비번 kh
CREATE USER kh IDENTIFIED BY kh;

/*
DCL(Data Control Language): 데이터 언어 제어
-계정한테 시스템 권한 또는 객체 접근 권한을 
    부여(GRANT)하거나 회수(REVOKE)하는 구문
    -GRANT  권한, 권한 ...TO 계정
    -REVOKE 권한, 권한, ...FROM 계정
*/

--CONNECT : 접속 권한 - 없으면 해당 유저로 접속이 되지 않음
--RESOURCE : 객체(생성, 수정, 삭제), 데이터(입력, 수정, 조회, 삭제)권한 부여
--(접속)권한,(객체 수정, 삭제) 권한 주기
GRANT CONNECT, RESOURCE TO kh; 
--TABLESPACE : 오라클의 데이터를 저장하는 논리적 공간 단위(오라클만 있음)
-- GRANT UNLIMITED TABLESPACE TO 계정명: 제한 없음
GRANT UNLIMITED TABLESPACE TO kh;
