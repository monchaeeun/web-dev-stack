/*
	LIMIT
    - OREDER BY 절보다 뒤에 조건을 걸고 싶을 때 사용
    - 출력되는 행 수를 제한하는 MYSQL 전용 비표준 구문 
    -데이터 양을 제한하고자 할 대 유용(페이징 처리)
*/
-- 1~10까지 생성
SELECT * 
FROM ACTOR
LIMIT 10 OFFSET 0;
-- 2 페이지
SELECT * 
FROM ACTOR
LIMIT 10 OFFSET 10;

SELECT * 
FROM ACTOR
ORDER BY FIRST_NAME
LIMIT 20,10;

/*
	CONCAT(컬럼,컬럼,...)
    -문자열을 하나로 합친 후 결과 반환(검색 기능 - LIKE, %)
*/
SELECT 
CONCAT(TITLE, DESCRIPTION,SPECIAL_FEATURES)
FROM FILM;

/*
	날짜 처리 함수
    NOW(), CURRENT_TIMESTAMP() : 현재 날짜와 시간 반환
    CURDATE(), CURREANT_DATE() : 현재 날짜 반환
    CURTIME(), CURRENT_TIME() : 현재 시간 반환
*/

SELECT NOW(), CURRENT_TIMESTAMP(),
		CURDATE(),CURRENT_DATE(),
        CURTIME(),CURRENT_TIME();
        
/*
	YEAR(날짜), MONTH(날짜),DAY(날짜)
    HOUR(날짜), MINUTE(날짜),SECOND(날짜)
*/        

SELECT YEAR(NOW()),MONTH(NOW()), DAY(NOW()), 
		HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());
        
/*
	포맷 함수
    FORMAT(숫자, 위치) : 숫자에 3 단위씩 콤마 추가해서 반환
    DATE_FORMAT(날짜, 포맷형식) : 날짜 형식을 변경해서 반환
*/        
SELECT 
FORMAT(AMOUNT,1),
DATE_FORMAT(PAYMENT_DATE,'%Y년 %M월 %D일 %H시, %I분 %S초'),
DATE_FORMAT(LAST_UPDATE, '%Y.%M.%D.%T')
FROM PAYMENT;

/*
	NULL 처리 함수
    IFNULL / COALESCE(값, 값이 NULL일 경우 반환 값);
*/
SELECT ADDRESS, ADDRESS2,IFNULL(ADDRESS2,'주소 없음') FROM ADDRESS;

/*
	IF(값1,값2,값3) / IF(조건, 조건이 TRUE인 경우, 조건 FALSE인 경우)
    -값1이 NULL이 아니면 값2 반환,NULL이면 값 3반환
    -조건에 해당하면 두번째 값 반환, 해당하지 않으면 마지막 값 반환
*/
SELECT ADDRESS, 
IF(ADDRESS2,'주소있음','주소없음'),
IF(ADDRESS LIKE '1%', 'TRUE', 'FALSE')
FROM ADDRESS;

