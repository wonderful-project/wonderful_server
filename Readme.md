# WONDERPOOL(가칭)

#### 서버 실행 방법
- 터미널에서 아래 명령어 입력 
> java -jar carpool.jar

---

#### DB 
- 더미데이터 생성법 :
    - http://localhost:8080/api/v1/user/add-dummies
    - 운전자, 승객 각각 50명씩 생성
    - http://localhost:8080/api/v1/route/add-dummies
    - 유저 별로 루트 하나씩 생성, 더미유저를 먼저 생성해야 함
---

#### URL
- 회원
    - 회원가입 : (POST) http://localhost:8080/api/v1/user
        - 요청 예시  
        {  
        "email" : "abc@wemakeprice.com",  
        "password" : "password",  
        "role" : "PASSENGER"  
        } 
    - 회원전체목록 : (GET) http://localhost:8080/api/v1/user
    - 회원정보보기 : (GET) http://localhost:8080/api/v1/user/{id}
    - 회원정보수정 : (PUT) http://localhost:8080/api/v1/user/{id}
    - 회원탈퇴 : (DELETE) http://localhost:8080/api/v1/user/{id}
- 경로
    - 경로입력 : (POST) http://localhost:8080/api/v1/route
    - 경로전체목록 : (GET) http://localhost:8080/api/v1/route
    - 경로정보보기 : (GET) http://localhost:8080/api/v1/route/{id}
    - 경로정보수정 : (PUT) http://localhost:8080/api/v1/route/{id}
    - 경로삭제 : (DELETE) http://localhost:8080/api/v1/route/{id}