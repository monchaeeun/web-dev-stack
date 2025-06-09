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
drop table user_info;
create table user_Info(
	user_code int AUTO_INCREMENT,
	user_Name varchar(6) default '채은' "이름",
    user_Age varchar(10) default '24' "나이",
    user_Id varchar(20) default 'user_123' "아이디",
    user_Pw varchar(20) default 'qwer1234' "비밀번호"
);
select * from user_info;