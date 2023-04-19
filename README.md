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
- AWS EC2, S3
- jQuery
- Amazon Linux 2
- STOMP, SockJS, Websocket
- BootStrap

# 3. 페이지별 기능

- 모든 페이지
  - 왼쪽 사이드 바에 카테고리 선택.
  - 오른쪽 사이드 바에 유저 정보 변경, 각 페이지 별 카테고리로 이동, 현재 접속중인 유저 닉네임 목록<br/>
  
- 홈페이지
  - 매일 00시에 바뀌는 카테고리 별 단답형 3문제씩 제공.
  
- 지식 페이지
  - 카테고리별 지식 설명.
  
- 단답형 페이지
  - 카테고리별 단답형 문제만 3문제씩 제공.
  
- 주관식 페이지
  - 카테고리별 주관식 문제만 3문제씩 제공.
  
- 오픈 채팅 페이지
  - 로그인 한 유저만 채팅방 생성, 채팅방 접속, 실시간 채팅 제공.

# 4. 페이지 별 완성된 화면 및 설명

<details>
<summary>1. 홈페이지</summary>
 
![image](https://user-images.githubusercontent.com/93322974/233055377-b0a0582e-771e-4e62-9cd4-e3265ae93f7b.png) <br/><br/>

- 카테고리별로 오늘의 문제 3문제 씩 제공하고 매일 00시에만 바뀌도록 스프링의 Scheduled를 사용하여 구현했습니다.
</details>

<details>
<summary>2. 지식 페이지</summary>
 
![image](https://user-images.githubusercontent.com/93322974/233055333-488567de-150a-42d2-88c1-b7096d682228.png) <br/><br/>
 
- 카테고리별로 지식을 제공하고, 지식을 클릭하면 Ajax로 지식 팝업이 뜨도록 구현했습니다.

## 지식마다 댓글 팝업
 ![image](https://user-images.githubusercontent.com/93322974/233055226-47d1a10b-58a4-47ca-9e94-2eb92e2cd3c5.png) <br/><br/>

- 댓글 모양을 클릭하면 Collapse 기능을 이용하여 댓글이 나오고, 로그인 한 유저만 댓글이 작성가능합니다.
- 댓글은 댓글과 답글로 나뉘어지며, 답글은 들여쓰기가 되어 있고, 답글을 클릭하여 Collapse 기능을 사용하여 보거나 숨길 수 있습니다.
- 좋아요, 댓글, 답글, 수정, 삭제 모두 Ajax로 바로 보이도록 구현했습니다.
- 삭제한 댓글은 삭제한 댓글입니다. 라고 댓글 내용이 바뀝니다.
</details>

<details>
<summary>3. 단답형 페이지</summary>
 
![image](https://user-images.githubusercontent.com/93322974/233055423-92c8751b-c2a8-465a-b71c-53448e77ce55.png) <br/><br/>

- 홈페이지와 같이 단답형 문제만을 제공하지만, 문제가 고정이 아니어서 새로고침 할 때마다 문제가 바뀝니다.
- 문제를 맞추거나 다른 문제를 풀고 싶을 때 넘기기를 클릭하면 같은 카테고리 내의 문제로 랜덤하게 바뀝니다.
</details>

<details>
<summary>4. 주관식 페이지</summary>
 
![image](https://user-images.githubusercontent.com/93322974/233051193-c1ca55e2-6b8a-4df0-b8c5-7279d5912721.png) <br/><br/>

- 주관식 문제만 랜덤으로 2개씩 제공하며, 테이블 형식 문제는 테이블 형식으로 제공합니다.
- 단답형 페이지와 같이 넘기기를 클릭하면 같은 카테고리 내의 문제로 랜덤하게 바뀝니다.
</details>

<details>
<summary>5. 오픈 채팅 페이지</summary>
 
![image](https://user-images.githubusercontent.com/93322974/233056832-0df3fbc0-dbf0-483d-9ee2-56061830cf34.png) <br/><br/>
 
- 로그인 한 유저만 채팅방 생성과 채팅방 목록을 볼 수 있습니다.
- 채팅방을 클릭하면 STOMP와 SockJS를 활용하여 채팅방에 구독해서 서버의 소켓과 연결합니다.

## 오픈 채팅방 채팅
![image](https://user-images.githubusercontent.com/93322974/233051673-0360bd21-8506-4b9e-bf88-f23932f69d6f.png) <br/><br/>
![image](https://user-images.githubusercontent.com/93322974/233051752-deca42b5-259b-4078-b218-27f9aeb99dd6.png) <br/><br/>

- 채팅방 삭제는 채팅방 생성한 유저나 관리자만 가능하며, 해당하지 않는 유저는 삭제 버튼이 없습니다.
- 채팅을 하면 채팅 내역은 실시간으로 웹소켓을 통하여 송수신되고, 채팅 내용은 DB에 저장됩니다.
- 유저가 입장하면 입장한 유저에게는 DB에 있는 최근 채팅내역 5개까지 출력해주고, 채팅방에 있는 모두에게는(입장 유저 포함) 환영메시지(입장메시지)를 출력합니다.
</details>

<details>
 <summary>6. 사이드 바</summary>
 
 ![image](https://user-images.githubusercontent.com/93322974/233054338-9f3c1606-dd76-4d9d-846f-eb81da1421ce.png) <br/><br/>

- 사이드 바는 모든 페이지에 존재하며, 로그인 한 유저만 계정 탭이 생성됩니다. 
- 모든 페이지의 카테고리별로 이동이 가능하도록 구현했습니다.
- 현재 접속중인 유저의 닉네임 목록을 제공합니다.
 
 ## 유저 정보 변경
 ![image](https://user-images.githubusercontent.com/93322974/233054345-ef6bc22a-5934-4283-b5ef-c3042a65f8bc.png) <br/><br/>

- 로그인 한 유저는 계정 정보(닉네임, 비밀번호, 프로필 사진)을 번경할 수 있습니다.
- 프로필 사진은 S3 버킷의 static 폴더에 저장됩니다.
</details>
