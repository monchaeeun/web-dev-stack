/*
함수 : 컬럼값을 읽어서 가공된 값을 반환

-단일행 함수 : N개의 값을 받아서 여러 개의 결과를 반환
-그룹 함수 : N개의 값을 받아서 1개의 결과를 반환

    >> 단일행 함수와 그룹 함수는 SELECT 절에서 함께 사용할 수 없음!
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

--단일행 함수
/*
    
    문자 처리 함수
    
    LENGTH : 문자 수 반환
        - 한글 1글자 -> 1
        - 영문자/숫자/특수문자 -> 1
    LENGTHB : 바이트 수 반환
        - 한글 1글자 -> 3바이트
        -영문자/숫자/특수문자 -> 1바이트
*/

SELECT 
    LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
    LENGTH('database'), LENGTHB('database')
FROM DUAL; -- DUAL : 가상테이블
    
/*
    INSTR(컬럼, 찾을 문자, 시작위치, 몇번째)
    - 특정 문자가 몇번째에 위치하는지 반환
    -없으면 0 반환
    -시작 위치 : 1(앞에서부터), -1(뒤에서부터)
*/    
SELECT 
    INSTR('AABAACAABBAA', 'B'),--앞에서 3번째에 위치해 3 반환
    INSTR('AABAACAABBAA', 'B',-1),--맨 뒤에 있는 B의 위치
    INSTR('AABAACAABBAA', 'B',-1,2),--뒤에서부터 2번째에 있는 B
    INSTR('AABAACAABBAA', 'D')--D가 없어서 0
FROM DUAL;    

--USER_INFO에서 각 전화번호(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
SELECT CONTACT,  
INSTR(CONTACT, '5')
FROM USER_INFO;
--EMPLOYEE 에서 's'가 포함되어있는 이메일중 @ 위치 조회
SELECT EMAIL,
INSTR(EMAIL, '@')
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%';

/* 
LPAD / RPAD(컬럼, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
-문자열을 조회 시 통일감있게 조회하고자 할 때 사용
*/

SELECT 
    LPAD('HELLO',10),LPAD('HELLO',10,'A'),--왼쪽부터 공백으로 채움/ A로 채움
    RPAD('HELLO',10),RPAD('HELLO',10,'A')--오른쪽부터 공백으로 채움/A로 채움
FROM DUAL;

/*
    LTRIM / RTRIM(컬럼, 제거하고자 하는 문자들)
    -문자열에서 특정 문자를 제거한 나머지를 반환
*/
SELECT 
    LTRIM('    K H'),--왼쪽 공백 제거
    LTRIM('ACBAACCCKH','ABC'),--왼쪽에서 ABC에 해당하는 문자들 제거
    RTRIM('46548518KH54568','0123456789')--오른쪽에서 해당하는 숫자들 제거
 FROM DUAL;
 /*
 TRIM(LEADING | TRAILING | BOTH, 제거하고자 하는 문자들, FROM 컬럼)
 -문자열의 양쪽(앞,뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
 */
 SELECT
    TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'),--왼쪽 제거(LTIRM)
    TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'),--오른쪽 제거(RTRIM)
    TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'),--양쪽 제거
    TRIM('              KH           ')
FROM DUAL;
/*
    SUBSTR(컬럼, 시작위치, 추출 길이)
    -문자열에서 특정 부분을 잘라서 추출
*/
SELECT 
    SUBSTR('PROGRAMING',5,2),--문자열 5부터 2글자 추출
    SUBSTR('PROGRAMING',1,6),--문자열 1부터 6글자 추출
    SUBSTR('PROGRAMING',-8,3)--뒤에서 8번째부터 3글자 추출
FROM DUAL;
--USER_INFO에서 전화번호(CONTACT)에서 가운데 번호 4자리만 조회
SELECT 
    SUBSTR(CONTACT,5,4)
FROM USER_INFO;
--다른 방법
SELECT 
    SUBSTR(CONTACT,INSTR(CONTACT, '-')+1,4)
FROM USER_INFO;
-- EMPLOYEE에서 이메일에서 ID(@앞부분)조회
SELECT
    RTRIM( EMAIL,'@kh.or.kr')--왼쪽 제거(LTIRM)
    FROM EMPLOYEE;
SELECT --앞 부분 찾기
    EMAIL,INSTR(EMAIL, '@'),SUBSTR(EMAIL,1,INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;
--다른 방법
SELECT
    EMAIL, REPLACE(EMAIL,'@kh.or.kr','')
FROM EMPLOYEE;    

--주민등록번호(EMP_NO)를 000000-0******로 조회
SELECT
   EMP_NO,--오른쪽 제거(LTIRM)   
   RPAD(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')+1),14,'*'),
   SUBSTR(EMP_NO,1,8) || '******'
FROM EMPLOYEE;

SELECT
EMP_NO "기존 값",
INSTR(EMP_NO,'-')+1 "값 확인",
SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')+1) "값 확인2",
 CONCAT(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')+1),'******') "다른 방식" 
FROM EMPLOYEE;

SELECT EMP_NO,REPLACE(EMP_NO, SUBSTR(EMP_NO,-6,6),'******') 
FROM EMPLOYEE;
--남자 사원들만 조회
SELECT
    *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,INSTR(EMP_NO,'-')+1,1) = 1;
SELECT
    SUBSTR(EMP_NO,INSTR(EMP_NO,'-')-6,2)
FROM EMPLOYEE;
SELECT
    EMP_NO
FROM EMPLOYEE;


/*
LOWER : 다 소문자로 변경
UPPER : 다 대문자로 변경
*/

SELECT
    LOWER('Welcome'),--소문자
    UPPER('Wlocome')--대문자
FROM DUAL;
/*
CONCAT(문자열,문자열);
-문자열 2개를 전달받아 1개로 합친 후 결과 반환
*/
--가나다라,1234를 합치기
SELECT 
    CONCAT('가나다라','1234')
FROM DUAL; 
SELECT '가나다라'||'1234'FROM DUAL;

--가나다라,ABCD,1234를 합치기
SELECT
     CONCAT(CONCAT('가나다라','ABCD'), '1234')"합치기"
FROM DUAL ;

/*
    REPLACE(컬럼, 바꾸고 싶은 문자열,바꿀 문자열)
    -특정 문자열로 변경
*/

SELECT REPLACE('서울시 강남구 역삼동','역삼동','삼성동')"글자 바꾸기" FROM DUAL;

--USER_INFO에서 서울이신 분들을 모두 경기로 바꾸기
SELECT ADDRESS,
REPLACE(ADDRESS,'서울','경기')
FROM USER_INFO;

-- EMPLOYEE에서 사원들의 이메일 KH.OR.KR을 GMAIL.COM으로 바꾸기
SELECT EMAIL,
REPLACE(EMAIL, 'kh.or.kr','gmail.com')
FROM EMPLOYEE;

/*
    숫자 처리 함수
    
    ABS : 절대값 반환
    MOD(숫자,숫자) : 두 수를 나눈 나머지 값 반환
    CEIL : 올림
    FLOOR : 내림
*/
SELECT ABS(5.7), ABS(-10) FROM DUAL;
SELECT MOD(10,3)FROM DUAL;--나머지값 1 반환
--무조건 올리고 무조건 내림
SELECT 
CEIL(123.152),
FLOOR(123.952) 
FROM DUAL;
/*
    ROUND(숫자,위치)
    -반올림한 결과 반환
*/
SELECT
    ROUND(123.456),--123(위치 생략 시 0
    ROUND(123.456,1),--소수점 1째 자리까지
    ROUND(123.456,-2)--소수점 앞 두자리까지
FROM DUAL;    
/*
    TRUNC(숫자, 위치)
    -위치 지정하여 버림 처리
*/
SELECT 
TRUNC(123.952)"값 안넣기", --뒤에 위치값이 없으면 전부 버림
TRUNC(123.952,1) "첫째자리 남기기"--첫째까지만 남김
FROM DUAL;

/*
    날짜 처리 함수(오라클식)
    
    SYSDATE : 시스템의 날짜를 반환합니다.(현재 날짜)    
*/
SELECT SYSDATE FROM DUAL;

--날짜 포멧 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';--시,분,초까지
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YY';
SELECT SYSDATE FROM DUAL;

/*
    MONTHS_BRTWEEN(날짜,날짜)
    -입력받은 두 날짜 사이의 개월 수 반환
*/
SELECT FLOOR(MONTHS_BETWEEN('20251216', SYSDATE)) FROM DUAL;

--USER_INFO에서 몇개월생인지 조회
SELECT
FLOOR(MONTHS_BETWEEN(SYSDATE,BIRTHDATE))"몇 개월 생"
FROM USER_INFO;

/*
    ADD_MONTHS(날짜,숫자)
    -특정 날짱 입력받는 숫자만큼 개월 수를 더한 날짜 반환
*/
SELECT ADD_MONTHS(SYSDATE,6)FROM DUAL;

--USER_INFO에서 해당 태어난 날짜부터 20년이 지났을 경우
SELECT ADD_MONTHS(BIRTHDATE,12*20)FROM USER_INFO;

/*
    NEXT_DAY(날짜,요일(문자/숫자))
    -특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    -요일 : 1 - 일, 2 - 월, 3 - 화, ... 7 - 토
    - 지나간 요일은 X
*/

SELECT 
NEXT_DAY(SYSDATE,'MONDAY') 
FROM DUAL;

SELECT 
NEXT_DAY(SYSDATE,'월요일') 
FROM DUAL;

SELECT 
NEXT_DAY(SYSDATE,'금') 
FROM DUAL;

SELECT 
NEXT_DAY(SYSDATE,1) 
FROM DUAL;

--언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;


/*
    LAST_DAY(날짜)
    -해당 월의 마지막 날짜 변환
*/
SELECT 
LAST_DAY(SYSDATE),
LAST_DAY('20250815'),
LAST_DAY('2025/12/25')
FROM DUAL;
/*
    ETRACT(YEAR|MONTH|DAY FROM 날짜)
    -특정 날짜에서 연도,월, 일 정보를 추출
*/
--USER_INFO 에서 BIRTHDATE로 연도,월, 일 따로 조회

SELECT 
    EXTRACT(YEAR FROM BIRTHDATE)"년도",
    EXTRACT(MONTH FROM BIRTHDATE)"월",
    EXTRACT(DAY FROM BIRTHDATE)"일"
FROM USER_INFO;

/*
    형 변환 함수
    
    TO_CHAR(날짜/숫자, 포맷)
    -날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/
SELECT TO_CHAR(1234,'L99,999') FROM DUAL; --L99999 : 현재 설성된 화폐단위
ALTER SESSION SET NLS_CURRENCY = '\';
ALTER SESSION SET NLS_CURRENCY = '$';

--EMPLOYEE에서 연봉을 TO_CHAR을 이용해서 조회(,)
SELECT TO_CHAR(SALARY*12,'L9,999') FROM EMPLOYEE; 
SELECT EMP_NAME, 
TO_CHAR(SALARY*12,'999,999,999') "연봉" 
FROM EMPLOYEE
ORDER BY 연봉;--별칭으로도 정렬 가능

--날짜 -> 문자
SELECT 
TO_CHAR(SYSDATE,'YYYY')"년도",-- YYYY,YY,RRRR,RR,YEAR
TO_CHAR(SYSDATE, 'MON') "월",-- MM, MON, MONTH, RM
TO_CHAR(SYSDATE, 'DD')"일", --D (주 - 일요일이 1),DD,DDD(년 기준) 
TO_CHAR(SYSDATE, 'DAY')"요일", -- DAY, DY
TO_CHAR(SYSDATE,'PM HH:MI:SS')"시,분,초",
TO_CHAR(SYSDATE,'AM HH24:MI:SS') "시, 분, 초2"
FROM DUAL;

--BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회

SELECT 
NAME,
TO_CHAR(BIRTHDATE,'YYYY"년" MON DD"일" DAY')"태어난 날짜"
FROM USER_INFO;

/*
    TO_DATE(숫자/문자, 포맷)
    -숫자 또는 문자형 데이터를 날짜 타입으로 변환
*/

-- 숫자 -> 날짜
SELECT 
TO_DATE(20250604) "숫자 변환",
TO_DATE(20250604164230, 'YYYY-MM-DD HH24:MI:SS') "변환2"
FROM DUAL;
--문자 -> 날짜
SELECT 
TO_DATE('20250624'),
TO_DATE('20250604164230', 'YYYY-MM-DD HH24:MI:SS') "변환2"
FROM DUAL;

/*
    TO_NUMBER(문자,포맷)
    -문자형 데이터를 숫자 타입으로 변환
*/
SELECT 
'100000' + '550000'FROM DUAL;
SELECT TO_NUMBER('100,000', '999,999') + TO_NUMBER('550,000','999,999')"문자를 숫자로 더하기"
FROM DUAL;

/*
    NULL 처리 함수
    NVL/COALESCE(값1,값2)
    - 값1이 NULL이 아니면 값1을 반환
    - 값1이 NULL이면 값2을 반환
*/
--USER_INFO에서 MBTI가 NULL인 경우, 'MBTI 모름'처리

SELECT 
NVL(MBTI,'MBTI 모름') "NVL",
COALESCE(MBTI,'MBTI 모름')"COALESCE" -- COALESCE(값1,값2,......)
FROM USER_INFO;
--MBTI NULL이 아니면 MBTI
--NULL이면 HOBBY, 이것또한 아니면 '모름'

SELECT 
COALESCE(MBTI,HOBBY,'모름')"COALESCE" -- COALESCE(값1,값2,......)
FROM USER_INFO;

/*
    NVL2(값1,값2,값3)
    -값1이 NULL이 아니면 값2,NULL이면 값 3
*/
--EMPLOYEE에서 부서코드(DEPT_CODE)가 있으면'부서있음', 없으면'부서없음'

SELECT EMP_NAME,
NVL2(DEPT_CODE,'부서있음','부서없음')"부서"
FROM EMPLOYEE;

/*
    NULLIF(값1, 값2)
    -2개의 값이 동일하면 NULL, 동일하지 않으면 값1
*/

SELECT 
NULLIF('123','123'),
NULLIF('123','456')
FROM DUAL;

/*
    선택 함수 : 어러가지 경우에 선택할 수 있는 기능을 제공
    
    DECODE(값, 조건값1,결과값1,조건값2,결과값2, ...)
    -비교하고자 하는 값이 조건값과 일치하는 경우,
    그에 해당하는 결과값 반환
    
    CASE WHEN 조건식1 THEN 결과값1
        WHEN 조건식2 THEN 결과값2
        ...
        ELSE 결과값 N
        END
*/
--EMPLOYEE에서 주민번호(EMP_NO)로 성별(남,여)조회

SELECT 
 EMP_NAME,
 DECODE(SUBSTR(EMP_NO,INSTR(EMP_NO,'-',1)+1,1),1,'남자',2,'여자')"성별"
FROM EMPLOYEE;

SELECT 
    CASE WHEN SUBSTR(EMP_NO,8,1)+1 = 1 THEN '남'
        WHEN SUBSTR(EMP_NO,8,1)+1 = 2 THEN '여'
        ELSE '남'
      END
FROM EMPLOYEE;



--직급 코드가 j7인 사원응ㄴ 급여를 10%인상
--직급코드가 j6인 사원은 급여를 15%인상
--직급 코드가 j5인 사원은 급여를 20%인상
--그 외 직급 사원은 급여를 5%인상
--정렬 : 직급 코드(JOB_CODE) J1 부터, 인상된 급여 높은 순서대로

SELECT 
DECODE(JOB_CODE, 'J5',SALARY * 1.2,
                'J6',SALARY *1.15,
                'J7',SALARY * 1.1,
                SALARY * 1.05)
                "급여 인상률"
FROM EMPLOYEE 
ORDER BY SALARY DESC;


SELECT 
    EMP_NAME,
    CASE JOB_CODE 
        WHEN 'J7' THEN SALARY *1.1
        WHEN 'J6' THEN SALARY *1.15
        WHEN 'J5' THEN SALARY *1.2
        ELSE SALARY * 1.05
    END
    "급여"
FROM EMPLOYEE;    
--급여가 500만원 초과일 경우 1등급
--급여가 500만원 이하 350만원 초과일 경우 2등급
--급여가 350만원 이하 200만원 초과일 경우 3등급
--그 외의 경우 4등급

SELECT 
EMP_NAME "  이름  ",
SALARY "  급여",
CASE WHEN SALARY > 5000000 THEN '1등급'
     WHEN SALARY > 3500000 THEN '2등급'
     WHEN SALARY > 2000000 THEN '3등급'
     ELSE '4등급'
     END 
     "  등급   "
FROM EMPLOYEE;

/*
    그룹함수 -> 결과값이 1개
    -대량의 데이터들로 집계나 통계 값은 작업을 처리해야 하는 경우
    -모든 그룹 함수는 NULL값을 자동으로 제외하고 값이 있는 것들만 계산
*/

--SUM : 해당 컬럼값들의 총 합계
--USER_INFO에서 나이(AGE) 모두 더한 값
SELECT 
SUM(AGE)"나이 합"
FROM USER_INFO;

--EMPLOYEE 에서 부서 코드가 D5인 사원들의 총 연봉 조회
SELECT 
SUM(SALARY * 12)"연봉 합" 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';
--DECODE 계산
SELECT 
SUM(DECODE(DEPT_CODE, 'D5',SALARY*12,0))"연봉 합" 
FROM EMPLOYEE;

SELECT 
SUM(CASE DEPT_CODE  WHEN 'D5' THEN SALARY * 12 ELSE 0 END)
FROM EMPLOYEE; 
/*
    AVG
    -해당 컬럼값들의 평균값
    -모든 그룹 함수는 NULL값을 자동으로 제외하기 때문에
    NVL함수랑 함께 사용할 것을 권장
*/
--USER_INFO에서 평균 나이
SELECT
FLOOR( AVG(CASE WHEN AGE <100 THEN AGE END))
FROM USER_INFO;
--EMPLOYEE에서 평균 보너스값(BONUS)
SELECT
ROUND(AVG(NVL(BONUS, 0)),3) "평균 보너스"
FROM EMPLOYEE;
/*
MIN : 해당 컬럼 값들중에 가장 작은 값
MAX : 해당 컬럼 값들중에 가장 큰 값
*/

--EMPLOYEE에서 MIN MAX 전부 사용해서 
--사원명(EMP_NAME),급여(SALARY),입사일(HIRE_DATE)
SELECT 
MIN(EMP_NAME)"MIN 이름",
MAX(EMP_NAME)"MAX 이름",
MIN(SALARY) "MIN 급여",
MAX(SALARY) "MAX 급여",
MIN(HIRE_DATE)"MIN 입사일",
MAX(HIRE_DATE)"MAX 입사일"
FROM EMPLOYEE;

/*
    COUNT -> 가장 많이 사용
    -컬럼 또는 행의 개수를 세서 반환
    - * : 조회 결과에 해당하는 모든 행 개수 반환
    -컬럼 : 해당 컬럼값이 NULL이 아닌 행 개수 반환
    DISTINCT 컬럼 : 해당 컬럼값의 중복을 제거한 행 개수 반환
*/
--USER_INFO 전체 사람 수 
SELECT
COUNT(*)
FROM USER_INFO;
--서울에 사는 사람들 수 조회
SELECT
COUNT(ADDRESS)
FROM USER_INFO
WHERE SUBSTR(ADDRESS,1,2) = '서울';

--다른 방법
SELECT
COUNT(ADDRESS)
FROM USER_INFO
WHERE ADDRESS LIKE '%서울%';

--다른 방법
SELECT COUNT(CASE WHEN ADDRESS LIKE '서울%' THEN 1 END)
FROM USER_INFO;
-- EMPLOYEE에서 보너스를 받은 사원 수 조회
SELECT 
COUNT(EMP_NAME)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

SELECT 
COUNT(BONUS)
FROM EMPLOYEE;


--부서가 배치된 사원 수 조회
SELECT 
COUNT(DEPT_CODE)"부서 사원 수"
FROM EMPLOYEE;
--현재 사원들이 속해있는 부서 수 조회
SELECT
COUNT(DISTINCT DEPT_CODE)"부서 수"
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL;

SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

/*
    집계 함수
    -그룹별 산출한 결과 값의 중간 집계를 계산해주는 함수
    -ROLLUP(컬럼1,컬럼2) : 컬럼1을 가지고 다시 중간집계를 내는 함수
    
    -CUBE(컬럼1,컬럼) : 컬럼 1을 가지고 중간집계도 내고, 
                        컬럼 2를 가지고 중간집계를 또 내는 함수
*/
--EMPLOYEE에서 직급별 급여합
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

SELECT JOB_NAME,SUM(SALARY)"급여합"
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
GROUP BY JOB_NAME;

--ROLLUP

SELECT JOB_CODE,SUM(SALARY)"급여합"
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE);-- 전체 합계까지 추산(하단)

--CUBE

SELECT JOB_CODE,SUM(SALARY)"급여합"
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE);-- 컬럼 하나일 때에는 ROLLUP과 차이 X

--부서 코드와 직급코드가 같은 사원들의 급여 합계
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;

--ROLLUP : DEPT_CODE 기준으로만 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

--CUBE : 2가지 기준 모두 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

/*
    GROUPING
    -ROLLUP이나 CUBE에 의해 산출된 값이 해당 컬럼 집합의 산출물이면
    0을 반환, 아니면 1을 반환하는 함수
*/

--ROLLUP : DEPT_CODE 기준으로만 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY),
GROUPING(DEPT_CODE),GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

--CUBE : 2가지 기준 모두 합계
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY),
GROUPING(DEPT_CODE),GROUPING(JOB_CODE)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE);


/*
    집합연산자
    -여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
    -여러 개의 쿼리문에서 조회하려고 하는 컬럼의 개수와 이름이 같아야
     집합 연산자를 사용할 수 있음!
     
     UNION (합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 - 중복된 값은 제거
     UNION ALL(합집합) : 두 쿼리문을 수행한 결과값을 하나로 합쳐서 추출 - 중복된 값 포함
     INTERSECT(교집합) : 두 쿼리문을 수행한 결과값에 중복된 결과값만 추출
     MINUS(차집합) : 선행 쿼리문의 결과값에서 후행 쿼리문의 결과값을 뺀 나머지 결과값만 추출
     
*/
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;

-- 부서 코드가 D5인 사원들의 사번, 사원명, 부서코드, 급여 조회

SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

--급여가 300만원 초과인 사원들의 사번,사원명,부서코드,급여 조회

SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 1. UNION
--부서코드가 D5이거나 급여가 300만원 초과인 사원들 조회
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--부서코드가 D5이거나 급여가 300만원 초과인 사원들 조회
--위 쿼리문 대신 WHERE 절에서 OR 연산자 사용해서도 처리가 가능
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

--2. UNION ALL
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 3. INTERSECT
-- 부서코드가 'D5'면서 급여가 300만원 초과인 사원들 조회
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--위 쿼리문 대신 AND 연산자 사용해서 처리 가능
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 4. MINUS
-- 부서 코드가 'D5' 인데 급여가 300만원 초과인 사원들은 제외
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--위 쿼리문 대신 AND 연산자 사용해서 처리 가능
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
AND SALARY <= 3000000;

/*
    GROUPING SETS
    -그룹별로 처리된 어러개의 SELECT 문을 하나로 합친 결과를 원할 때 사용
*/
--부서별, 직급별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
UNION ALL
SELECT JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--다른 방법
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY GROUPING SETS( DEPT_CODE, JOB_CODE);

