### 📝 요구사항 (Week 3)
**🔹 (기본) 바우처 서비스 관리 페이지 개발하기**  
- [x] Spring MVC를 적용해서 thymeleaf 템플릿을 설정
  - [x]  조회페이지
  - [x]  상세페이지
  - [x]  입력페이지
  - [x]  삭제기능

**🔹  (기본) 바우처 서비스의  API  개발하기**
- [x]  Spring MVC를 적용해서 JSON과 XML을 지원하는 REST API를 개발
    - [x]  전체 조회기능
    - [x]  조건별 조회기능 (바우처 생성기간 및 특정 할인타입별)
    - [x]  바우처 추가기능
    - [x]  바우처 삭제기능
    - [x]  바우처 아이디로 조회 기능

**🔸 (보너스) 바우처 지갑용 관리페이지를 만들어보세요.**
- [x]  Wallet 관리 페이지

### 👩‍💻 요구 사항과 구현 내용 
| Controller 및 타임리프 구현 |
|----------|
|![Hnet-image (2)](https://user-images.githubusercontent.com/41179265/165753488-2e5764cf-90af-46dc-9df8-40441caf178e.gif)| 

## REST API

### GET `/api/v1/vouchers`

바우처 전체 조회

```
GET http://localhost:8080/api/v1/vouchers
Accept: application/xml
```

```
GET http://localhost:8080/api/v1/vouchers
Accept: application/json
```

### GET `/api/v1/voucher/{id}`

바우처 상세 조회

```
GET http://localhost:8080/api/v1/voucher/302a6066-e1dc-46f2-a558-4c81175825ca
Accept: application/json
```
### POST `/api/v1/voucher`

바우처 추가

```
POST http://localhost:8080/api/v1/voucher
Accept: application/json
Content-Type: application/json

{
"type": "PERCENT",
  "amount": 5
}
```


### POST `/api/v1/voucher/query`

바우처 조건별 조회

```
POST http://localhost:8080/api/v1/voucher/query
Accept: application/json
Content-Type: application/json

{
  "type": "FIXED",
  "from": "2022-04-11"
}
```


### DELETE `/api/v1/voucher/{id}`

바우처 삭제

```java
DELETE http://localhost:8080/api/v1/voucher/ee0b4ffa-433e-4ab9-ac72-08c6811d0cea
```

### ✅ 피드백 반영사항  
- DB url 및 password 정보 노출 차단
- 테이블 복수형 -> 단수형
- 함수 네이밍 변경 (findHavingTypeAll -> findAllByUserType)
- 불필요한 @Import( Config파일) -> Config 컴포넌트 스캔으로 변경
- Transactional 추가 (조회용에는 readonly=true)
- 테스트 코드 추가
