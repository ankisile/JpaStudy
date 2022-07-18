## jpa 공부용 - REST API 만들기
##### BungaeMarketAPI를 JPA로 만들어보고자 하였고 DB는 간추려서 제작하고자 하였음
#### 6/11 
1. User 엔티티 만들기
#### 6/25
1. UserService, UserServiceImpl 제작
2. UserRepository 만들기
#### 6/27
1. Spring Security를 이용한 비밀번호 암호화 공부중
#### 6/30
1. 회원가입 구현
#### 7/4
1. maria db와 연동. 정상적으로 db에 저장되는것 확인 
#### 7/7 
1. login 할때 jwt 토큰 받아오는 식으로 구현하려고 함. JDBCtemplate에서만 jwt를 이용해 보아서 Spring Security+Jpa에서 jwt 처리 인프런 강의 보면서 공부중
2. 예전 피드백 때 ERROR 메세지는 Exception을 이용하여 하라고 하셨음.=> exception 패키지 만든후 거기에 Exception make
3. jwt를 이용한 login 구현. login하면 토큰 받아와짐
#### 7/18
1. Product Entity 제작 => Product와 User는 다대일(user한명이 여러개 product 등록 가능. 일대다는 권장되지 않음)
2. Product 등록용 dto 작성

##### 참고문서
- https://velog.io/@ehdrms2034/Spring-비밀번호-암호화에-대한-고찰
- https://mia-dahae.tistory.com/120
- https://inf.run/8sE2
- https://hyeonic.tistory.com/219