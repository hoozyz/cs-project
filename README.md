## 해당 프로젝트는 개인 토이 프로젝트입니다.<br/>
 
**비전공자로서 컴퓨터 지식(CS)를 공부하면서 다양한 기술 스택을 배우기 위해서**<br/> 
**CS를 공부하고 문제를 맞히기 위한 웹 사이트를 만들었습니다.**

**아래 순서로 설명해 보겠습니다.**

  1. 프로젝트 기획 의도 및 설명
  2. 개발 환경 / 기술 스택
  3. 페이지별 기능 설명
  4. 페이지별 완성된 화면 및 설명
 
# 1. 어떤 프로젝트인가? [2023.03.09 ~ 2023.04.14]

- 방대한 컴퓨터 지식 중에서 백엔드 로드맵의 지식들을 한 곳에 모아서 지식을 쌓음과 동시에 문제를 풀면서 확실하게 알아가는 과정을 위해서 프로젝트를 기획하게 되었습니다.
- 지식에 대한 설명과 단답형, 주관식 문제 제공하고, 또한 웹소켓에 대한 원리와 실적용을 위해 오픈 채팅을 추가했습니다.
- AWS 지식을 알기 위해서 EC2, S3, Docker 등을 활용하여 가상화 구축과 무중단 서버에 프로젝트 배포를 했습니다.

**더욱 더 자세한 코드 및 구현은 블로그에 설명되어 있습니다.**

# 2. 개발 환경 / 기술 스택은?

### 개발 환경

- STS
- OpenJDK 17
- Gradle - groovy
- Spring Boot 3.0.4
- Github

### 기술 스택

- Java
- MySQL
- Spring Data JPA
- Thymeleaf
- Docker
- AWS EC2
- AWS S3
- jQuery
- Amazon Linux 2
- STOMP
- Websocket
- BootStrap

# 3. 페이지 별 기능

- 모든 페이지
  - 왼쪽 사이드 바에 카테고리 선택.
  - 오른쪽 사이드 바에 유저 정보 변경, 각 페이지 별 카테고리로 이동, 현재 접속중인 유저 닉네임 목록<br/>
  
- 홈페이지
  - 매일 00시에 바뀌는 카테고리 별 단답형 3문제씩 제공.
  
- 지식 페이지
  - 카테고리 별 지식 설명.
  
- 단답형 페이지
  - 카테고리 별 단답형 문제만 3문제씩 제공.
  
- 주관식 페이지
  - 카테고리 별 주관식 문제만 3문제씩 제공.
  
- 오픈 채팅 페이지
  - 로그인 한 유저만 채팅방 생성, 채팅방 접속, 실시간 채팅 제공.

# 4. 페이지 별 완성된 화면 및 설명

<details>
<summary>1. 홈페이지</summary>
![image](https://user-images.githubusercontent.com/93322974/233050950-693f37d4-3e1b-460b-8f4f-b5655a0b089a.png)


</details>

<details>
<summary>2. 지식 페이지</summary>
![image](https://user-images.githubusercontent.com/93322974/233051004-a7ecfe9e-ee21-4ce8-a590-413220a9062e.png)

- 지식마다 댓글 팝업
![image](https://user-images.githubusercontent.com/93322974/233051140-5e188578-4de4-494f-bd24-0eb8466f6c56.png)

</details>

<details>
<summary>3. 단답형 페이지</summary>
![image](https://user-images.githubusercontent.com/93322974/233051170-21dc419b-4443-4fa1-98d9-724f7d323be6.png)


</details>

<details>
<summary>4. 주관식 페이지</summary>
![image](https://user-images.githubusercontent.com/93322974/233051193-c1ca55e2-6b8a-4df0-b8c5-7279d5912721.png)

</details>

<details>
<summary>5. 오픈 채팅 페이지</summary>
![image](https://user-images.githubusercontent.com/93322974/233051827-9282d895-bfc9-40e8-ab5b-dc964bb9519d.png)

![image](https://user-images.githubusercontent.com/93322974/233051673-0360bd21-8506-4b9e-bf88-f23932f69d6f.png)
![image](https://user-images.githubusercontent.com/93322974/233051752-deca42b5-259b-4078-b218-27f9aeb99dd6.png)

</details>
