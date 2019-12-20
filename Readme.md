# WONDERPOOL(가칭)

#### 서버 실행 방법
- 터미널에서 아래 명령어 입력 
> java -jar wonderpool.jar

---

#### DB 접속
- http://localhost:8080/h2-console 접속
- JDBC URL : jdbc:h2:mem:testdb 입력
- 주의사항 : 세션에 저장되는 db이기 때문에 서버 종료시 모든 데이터가 삭제됩니다.
- 더미데이터 생성법 :
    - http://localhost:8080/api/v1/user/add-dummies
    - 운전자, 승객 각각 50명씩 생성
    - H2 CONSOLE 에서 SELECT * FROM USER 로 확인 가능

---

#### URL
- 회원가입 : (POST) http://localhost:8080/api/v1/user
- 회원정보보기 : (GET) http://localhost:8080/api/v1/user/{id}
- 회원정보수정 : (PUT) http://localhost:8080/api/v1/user/{id}
- 회원탈퇴 : (DELETE) http://localhost:8080/api/v1/user/{id}