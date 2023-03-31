INSERT INTO KNOW VALUES
-- 네트워크
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '인터넷', '여러 통신망을 하나로 연결하는 거대한 컴퓨터 통신망./클라이언트와 서버가 연결되어 구성된 망을 컴퓨터 네트워크 라고 하며, 
TCP/IP 프로토콜을 통해 제공됨./즉, 수많은 컴퓨터 네트워크들로 구성된 집합체이다/인터넷은 서로 동시에 참여할 수 있는 쌍방향 통신을 제공한다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'IP 프로토콜', '네트워크 상에서 컴퓨터의 고유한 주소. 총 4바이트로 0.0.0.0 형태이며 각 숫자는 256까지 가능하다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'TCP 프로토콜', '클라이언트와 서버간에 데이터를 신뢰성있게 전달하기 위해 만들어진 프로토콜./근거리통신망(LAN), 
원거리 통신망(WAN), 인트라넷, 인터넷 등 컴퓨터에서 실행되는 프로그램 간에 데이터를 안정적이고, 에러없이 데이터를 교환 가능하게 합니다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'DNS 주소', '브라우저가 도메인 이름을 IP주소로 변환하여 서버에서 인터넷 자원을 받을 수 있게 하는 시스템이다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'DNS의 세가지 요소', '도메인 네임 스페이스 : 네임 서버에서 도메인 주소를 관리하는 방법 또는 관리 단위./네입 서버 : 도메인 주소를 관리하기 위해 사용하는 DNS 전용 서버. 
DNS 서버라고도 한다./리졸버 : DNS 상의 클라이언트. 네임 서버에게 도메인 주소에 대한 IP주소를 물어보는(반대여도 마찬가지) 장비 또는 프로그램.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'HTTP 프로토콜', '데이터를 주고 받기 위한 프로토콜이며, 서버와 클라이언트 모델을 따른다./
상태 정보를 저장하지 않는 Stateless의 특징과 클라이언트의 요청에 맞는 응답을 보낸 후 연결을 끊는 Connectionless 특징을 가진다./통신간의 연결 상태 처리나 상태 정보를 관리할 필요가 없어 서버 디자인이 간단./
각각의 HTTP 요청에 독립적으로 응답만 보내주면 OK./이전 통신의 정보를 모르기 때문에 매번 인증 해야한다./해결하기 위해 쿠키, 세션을 사용해서 데이터를 처리한다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'HTTPS 프로토콜', 'HTTP에 SSL을 추가한 프로토콜./HTTP가 SSL과 통신 후 SSL이 TCP와 통신해서 암호화, 증명서 등 보호가 가능하다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹', '인터넷에 연결된 사용자들이 서로의 정보를 공유할 수 있는 공간이지만, 인터넷과 같은 의미로 많이 사용됩니다./
텍스트, 그림, 소리, 영상 등과 같은 멀티미디어 정보를 하이퍼텍스트 방식으로 연결하여 제공합니다./수많은 웹페이지들이 하이퍼 링크를 통해 서로 연결되어 구성됩니다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '하이퍼텍스트', '문서 내부에 또 다른 문서로 연결되는 참조를 집어 넣음으로써 웹 상에 존재하는 문서끼리 참조할 수 있는 기술.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 페이지', 'HTML(하이퍼 텍스트 마크업 언어) 를 사용하여 작성된 하이퍼텍스트 문서', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 사이트', '웹 페이지 중에서 서로 관련된 내용으로 작성된 웹 페이지들의 집합', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 브라우저', '웹 페이지를 검색하기 위해 사용하는 프로그램.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '인터넷 연결 원리', '1. 컴퓨터*2. 라우터*3. 모뎀*4. ISP*5. ISP*6. 모뎀*7. 라우터*8. 컴퓨터', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '라우터', '특수한 소형 컴퓨터로 여러 컴퓨터에 연결되어서 테이터를 받아 잘 전달해주는 역할만 하는 간단한 컴퓨터.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '모뎀', '우리의 네트워크와 연결되어, 외부에 전화 시설과 연결해주는 기계./전화 시설에 사용되는 데이터와 컴퓨터에 사용되는 데이터 교환해주는 기계.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'ISP', '인터넷 서비스 제공 업체로 몇몇 특수한 라우터를 관리하고 다른 ISP에 액세스 할 수 있는 회사. SKT, KT, LG 등이 있다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '포트 포워딩', '공유기의 포트를 통해 이 공유기와 연결된 기기들의 특정 포트에 진입할 수 있게 하는 기능.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 동작 원리', '1. URL 입력*2. DNS가 서버 IP 찾아옴.*3. IP 주소로 웹 서버에 TCP 3 HANDSHAKE로 연결 수립*4. 클라이언트로 웹 서버로 HTTP 요청 메시지 보냄*
5. 웹 서버는 HTTP 응답 메시지를 보냄*6. 도착한 HTTP 응답 메시지는 웹 페이지 데이터로 변환되고, 웹 브라우저에 의해 출력.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '쿠키', 'HTTP의 일종으로 사용자의 컴퓨터에 저장하는 작은 기록 정보 파일./HTTP에서 클라이언트의 상태 정보를 PC(사용자의 PC)에 저장했다가 필요시 정보를 참조하거나 재사용 가능./
이름, 값, 저장기간, 경로 정보로 구성./클라이언트에 총 300개의 쿠키를 저장 가능./하나의 도메인 당 20개의 쿠키 가질 수 있음./하나의 쿠키는 4KB까지 저장 가능.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '쿠키의 동작 원리', '1. 클라이언트가 페이지를 요청.*2. 웹 서버는 쿠키 생성.*3. 생성한 쿠키에 정보를 담아 HTTP 화면을 돌려줄 때, 같이 클라이언트에게 돌려준다.*
4. 넘겨받은 쿠키는 클라이언트가 가지고 있다가(로컬 PC에 저장) 다시 서버에 요청할 때 요청과 함께 쿠키를 전송.*5. 동일 사이트 재방문 시 클라이언트의 PC에 해당 쿠키가 있는 경우, 요청 페이지와 함께 쿠키를 전송한다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '세션', '일정 시간동안 같은 사용자로부터 들어오는 일련의 요구를 하나의 상태로 보고, 그 상태를 유지하는 기술./방문자가 웹 서버에 접속해 있는 상태를 하나의 단위로 본 것./
웹 서버에 웹 컨테이너의 상태를 유지하기 위한 정보를 저장한다./웹 서버에 저장되는 쿠키(세션 쿠키)./브라우저를 닫거나, 서버에서 세션을 삭제했을 때만 삭제되어서 쿠키보다 보안성이 좋다./
저장 데이터에 제한이 없다. (서버 용량이 허용하는 만큼)./각 클라이언트에 고유 세션 ID를 부여함. 세션 ID로 클라이언트를 구분해 각 요구에 맞는 서비스 제공.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '세션의 동작 원리', '1. 클라이언트가 페이지에 요청한다. (웹사이트 접근)*2. 서버는 접근한 클라이언트의 쿠키를 확인하여, 클라이언트가 해당 세션 ID를 보냈는지 확인.*
3. 세션 ID가 존재하지 않으면, 서버는 세션 ID를 생성해 클라이언트에게 돌려줌.*4. 서버에서 클라이언트로 돌려준 세션 ID를 쿠키를 사용해 서버에 저장.*5. 클라이언트는 재접속 시 이 쿠키를 이용해 세션 ID 값을 서버에 전달.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '쿠키 / 세션 차이점', '*', DEFAULT, DEFAULT, DEFAULT), -- 23
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '캐시', '웹 페이지 요소를 저장하기 위한 임시 저장소이며, 웹 페이지를 빠르게 렌더링 하도록 돕는다./이미지, 비디오, 오디오, CSS, JS 등 데이터나 값을 미리 복사해 놓는 리소스 파일들의 임시 저장소./
저장 공간이 적고 비용이 비싼 대신 빠른 성능을 제공한다./같은 웹 페이지에 접속할 때 사용자의 PC에서 로드하므로 서버를 거치지 않아도 된다./이전에 사용된 데이터가 다시 사용될 가능성이 많으면 캐시 서버에 있는 데이터를 사용한다./
그래서 다시 사용될 확률이 있는 데이터들이 빠르게 접근 가능하다. (페이지 로딩 속도 증가)', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '캐시 히트', '캐시 사용 가능할 때 (이전에 왔던 요청이랑 같은 요청이 왔을 때)', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '캐시 미스', '캐시 사용 불가할 때 (웹 서버로 처음 요청했을 때)', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '렌더링', '웹 사이트 정보를 받아 웹 사이트가 그려지는 과정', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'TCP 프로토콜', '연결형 서비스로, 3-WAY HANDSHAKING 과정을 통해 연결을 설정하기 때문에 높은 신뢰성 보장하지만, 속도가 비교적 느림./신뢰가 중요한 파일 교환과 같은 경우에 쓰임.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'UDP 프로토콜', '비연결형 서비스로, 3-WAY HANDSHAKING을 사용하지 않아 신뢰성이 떨어지지만, 데이터 수신 여부를 확인 안해서 속도가 빠르다./실시간성이 중요한 스트리밍에 쓰임.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'TCP / UDP 차이점', '*', DEFAULT, DEFAULT, DEFAULT), -- 30
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '3-WAY HANDSHAKE', 'TCP 네트워크에서 통신 하는 장치가 서로 연결이 잘 되었는지 확인하는 방법./송신자와 수신자는 총 3번에 걸쳐 데이터를 주고 받으며 통신이 가능한 상태인지 확인합니다./연결을 설정하는 것', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '4-WAY HANDSHAKE', 'TCP 네트워크에서 통신 하는 장치의 연결을 해제하는 방법./송신자와 수신자는 총 4번에 걸쳐 데이터를 주고 받으며 연결을 끊습니다./연결을 해제하는 것', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'OSI 7계층', '*', DEFAULT, DEFAULT, DEFAULT), -- 33
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'GET', '데이터를 조회하기 위해 사용되는 방식으로 데이터를 헤더에 추가하여 전송하는 방식./URL에 데이터가 노출되므로 보안적으로 중요한 데이터를 포함하면 안됨.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'POST', '데이터를 추가 또는 수정하기 위해 사용되는 방식으로 데이터를 바디에 추가하여 전송하는 방식./완전히 안전하지는 않지만 URL에 데이터가 노출되지 않아 GET 보다는 안전.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'GET / POST 차이점', '*', DEFAULT, DEFAULT, DEFAULT), -- 36
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '세션 상태', '클라이언트와 서버간 통신 인증이 된 상태.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '세션 정보', '한 세션 내에서 클라이언트가 서버에 전송할 데이터 정보./서버는 세션 유지 시간이 지나거나(브라우저 종료나 설정한 시간), 클라이언트가 전송하려했던 데이터를 모두 수신할 때까지 클라이언트와의 세션 상태를 유지합니다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'STATEFUL', '세션이 종료될 때까지, 클라이언트의 세션 정보를 저장하는 프로토콜./서버는 클라이언트의 세션 정보를 저장하므로, 갑자기 통신이 중단되더라도 중단된 곳부터 다시 시작할 수 있습니다./
서버에 저장하기 때문에 사용자가 많아지면 과부하로 인해 확장성이 좋지 않다./EX) TCP, 은행(서버)은 고객(클라이언트)의 인증 정보(세션 상태)와 결제 내역(세션 정보)을 가지고 있습니다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'STATELESS', '서버가 클라이언트의 세션 상태 및 세션 정보를 저장하지 않는 프로토콜./요청에 대한 응답만 처리하는 방식./각 통신은 선행되거나 후속으로 따라오는 통신과 관련이 없습니다./
클라이언트가 송신하려 했던 모든 데이터가 서버 쪽에 수신 되었는지 확인하지 않습니다./서버가 세션 상태 및 세션 정보를 저장하지 않기 때문에, 클라이언트 측에서 송신할 데이터의 양이 많아집니다./확장성이 좋습니다./EX) UDP, 검색창에 질문을 입력하다가 요청이 중단되어도, 다시 검색하면 됩니다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '세션 기반 인증', '클라이언트로부터 요청을 받으면 클라이언트의 상태 정보를 저장하므로 STATEFUL한 구조를 가진다./단일 도메인이 사용하기 좋다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '토큰 기반 인증', '상태 정보를 서버에 저장하지 않아서 STATELESS한 구조를 가진다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '대칭키', '양방향 암호화 방식./암호화와 복호화에 같은 암호 키를 쓰는 알고리즘./중간에 누군가 암호 키를 가로채면 암호화된 정보가 유출될 수 있다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '비대칭키', '양방향 암호화 방식./암호화와 복호화에 쓰는 키를 서로 다르게 사용하는 알고리즘./타인에게 절대 노출되어서 안되는 개인키와 공캐적으로 개방되어 있는 공개키를 쌍으로 이룬 형태.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'Connection Timeout', '서버 자체에 클라이언트가 어떤 사유로 접근을 실패했을 시 적용./접근을 시도하는 시간 제한.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'Read Timeout', '클라이언트가 서버 접속에 성공 했으나 서버가 로직을 수행하는 시간이 너무 길어 제대로 응답을 못할 때 연결을 해제하는 것./
클라이언트는 해당 상황을 오류로 인지하고, 서버는 계속 로직을 수행하고 있어 성공으로 인지해 서로 싱크가 맞지 않아 문제가 발생할 확률이 높다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '공인 IP', 'ISP가 제공하는 IP 주소이며, 외부에 공개되어 있는 IP 주소.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '사설 IP', '일반 가정이나 회사 내 등에 할당된 IP 주소이며, IPv4의 주소 부족으로 인해 서브넷팅된 IP이기 때문에 라우터(공유기)에 의해 로컬 네트워크 상의 PC나 장치에 할당된다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 호스팅 서비스', '웹 사이트 또는 웹 애플리케이션을 저장하고 데스크톱, 모바일 및 태블릿과 같은 다양한 디바이스에서 손쉽게 액세스하도록 하는 서비스./
공급자는 파일을 저장하기 위해 임대할 수 있는 물리적 서버를 유지 관리, 구성 및 실행한다./웹 사이트 및 웹 애플리케이션 호스팅 서비스는 보안, 웹 사이트 백업, 웹 사이트 성능 등의 추가 지원을 제공하여 고객이 웹 사이트의 핵심 기능에 집중할 수 있도록 한다./
회사는 다양한 호스팅 패키지와 플랜을 제공한다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 호스팅', '서버 1대를 여러 웹사이트(여러 사용자)가 공용으로 씀./하나의 서버를 나누어서 사용해서 비용이 비교적 저렴하다./
사용자가 많아지면 그에 따라 서버에 과부하가 와서 속도가 느려지거나, 서버가 다운될 수 있다./호스팅 운영자가 관리하므로 서버 지식 없어도 됨./주로 간단한 홈페이지, 블로그, 커뮤니티 사이트, 회사 홈페이지 등 규모가 작은 곳을 운영할 때 사용.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '서버 호스팅', '서버 1대를 혼자서 쓰는 호스팅./서버 공간 전체를 사용할 수 있고 운영과 관리에 관한 직접적인 권한을 가짐./
서버 공간 전체를 사용할 수 있고 운영과 관리에 관한 직접적인 권한을 가짐./서버 용량만큼 저장할 수 있는 데이터 공간도 커진다./운영과 관리에 필요한 설비를 갖춰야 하고, 전기를 365일 24시간 내내 공급해야 해서 비용 많이 든다./
보안이 좋지 않을 경우 해킹을 당할 수 있다.', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '클라우드 호스팅', '서버 호스팅을 가상화한 것으로, 가상화된 서버를 단독으로 사용할 수 있는 형태의 호스팅./
웹 호스팅과 다르게 서버에 대한 직접적인 권한을 갖고 사용자의 필요에 따라 메모리 용량, DB 등 자유롭게 서버를 확장하거나 축소를 할 수 있다는 장점이 있다./하나의 서버에 문제가 생기면 연결되어 있는 다른 서버에도 문제가 생길 수 있다./
대표적인 것으로 AWS, AZURE 등이 있고, 가격을 비교해서 쓰면 좋다.', DEFAULT, DEFAULT, DEFAULT), -- 52
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 서버', 'HTTP 프로토콜을 기반으로 클라이언트가 웹 브라우저에서 어떠한 요청을 하면 요청을 받아 정적 컨텐츠를 제공하는 서버./EX) APACHE', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', 'WAS', '웹 서버와 다르게 동적 컨텐츠를 제공하는 서버./JSP, SERVLET 구동환경을 제공하기 때문에 웹 컨테이너라고도 불린다./웹 서버의 기능도 할 수 있다./EX) TOMCAT', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '네트워크', '웹 서버와 WAS를 분리하는 이유', '서버 부하 방지.*보안 강화.*여러 대의 WAS 연결 가능.*여러 웹 어플리케이셔 서비스 가능.', DEFAULT, DEFAULT, DEFAULT),

-- 자바(기초) ((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '*', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '*', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(기초)', '', '', DEFAULT, DEFAULT, DEFAULT),

-- 자바(심화) ((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '*', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '*', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT, DEFAULT),
((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), '자바(심화)', '', '', DEFAULT, DEFAULT, DEFAULT);


-- ((SELECT IFNULL(MAX(K.no) + 1, 1) FROM KNOW K), 2, '', '', DEFAULT, DEFAULT),
COMMIT;
ROLLBACK;

select
        k1_0.no,
        k1_0.cate,
        k1_0.cont,
        k1_0.date,
        k1_0.likes,
        k1_0.name 
    from
        know k1_0 
    where
        k1_0.cate="자바(심화)" 
        and k1_0.cont like "%*%";










INSERT INTO ADDI VALUES
(23, '-', '쿠키', '세션', ''),
(23, '저장 위치', '클라이언트(사용자 PC)', '웹 서버(WAS)', ''),
(23, '저장 형식', 'TEXT', 'OBJECT', ''),
(23, '만료 시점', '쿠키 저장 시 설정', '브라우저 종료시 삭제', ''),
(23, '사용하는 자원(리소스)', '클라이언트 리소스', '웹 서버 리소스', ''),
(23, '용량 제한', '총 300개, 도메인 당 20개, 하나의 쿠키 당 4KB', '서버가 허용하는 한 제한 없음', ''),
(23, '속도', '세션보다 빠름', '쿠키보다 느림', ''),
(23, '보안', '세션보다 안좋음', '쿠키보다 좋음', ''),
(30, '-', 'TCP', 'UDP', ''),
(30, '연결 방식', '연결형 서비스', '비연결형 서비스', ''),
(30, '패킷 교환 방식', '가상 회선 방식', '테이터그램 방식', ''),
(30, '전송 순서', '전송 순서 보장', '전송 순서 보장 안함', ''),
(30, '수신 여부 확인', '수신 여부를 확인', '수신 여부 확인 안함', ''),
(30, '통신 방식', '1:1 통신', '1:1 OR 1:N OR N:N 통신', ''),
(30, '신뢰성', '높다', '낮다', ''),
(30, '속도', '느리다', '빠르다', ''),
(33, '-', '계층 모델', '설명', ''),
(33, '7 계층', '응용 계층', '사용자에게 통신을 위한 서비스 제공. 인터페이스 역할', ''),
(33, '6 계층', '표현 계층', '테이터의 형식을 정의하는 계층. 코드 간의 번역을 담당', ''),
(33, '5 계층', '세션 계층', '컴퓨터끼리 통신을 하기 위해 세션을 만드는 계층.', ''),
(33, '4 계층', '전송 계층', '최종 수신 프로세스로 데이터의 전송을 담당하는 계층. (단위: SEGMENT) (TCP, UDP 등)', ''),
(33, '3 계층', '네트워크 계층', '패킷을 목적지까지 가장 빠른 길로 전송하기 위한 계층. (단위: PACKET) (ROUTER 등)', ''),
(33, '2 계층', '데이터링크 계층', '데이터의 물리적인 전송과 에러 검출, 흐름 제어를 담당하는 계층. (단위: FRAME) (이더넷 등)', ''),
(33, '1 계층', '물리 계층', '데이터를 전기 신호로 바꾸어주는 계층 (단위: BIT) (장비: 케이블, 리피터, 허브 등)', ''),
(36, '-', 'GET 방식', 'POST 방식', ''),
(36, 'URL에 데이터 노출 여부', 'O', 'X', ''),
(36, 'URL 예시', '.com?title=제목&cont=내용', '.com', ''),
(36, '데이터의 위치', '헤더', '바디', ''),
(36, '캐싱 가능 여부', 'O', 'X', ''),
(36, '멱등성 여부', 'O', 'X', ''),
(0, '', '', '', '');

-- (0, '', '', '', ''),

select * from know where no != 23 and 24;

SELECT * FROM today;
SELECT * FROM chat;
SELECT * FROM room;
SELECT * FROM user;
SELECT * FROM know;
SELECT * FROM reply;
SELECT * FROM addi;

DELETE FROM today;  
DELETE FROM chat;  
DELETE FROM room;        
DELETE FROM user;
DELETE FROM reply;
DELETE FROM know;
DELETE FROM addi;

alter table reply auto_increment = 1;

DROP TABLE IF EXISTS today;
DROP TABLE IF EXISTS chat;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS know;
DROP TABLE IF EXISTS addi;

CREATE TABLE today (
	no int NOT NULL,
    kno int NOT NULL
);

CREATE TABLE chat (
	no int NOT NULL,
    type varchar(100) NOT NULL,
    roomid varchar(255) NOT NULL,
    nick varchar(100) NOT NULL,
    profile varchar(1000) NULL,
    msg varchar(1000) NOT NULL,
    date datetime DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE room (
	id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    master varchar(100) NOT NULL,
    date datetime DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE addi (
	no int NOT NULL,
    stand varchar(255) NULL COMMENT '기준(저장 위치 등)',
    comp1 varchar(255) NOT NULL COMMENT '비교대상 1',
    comp2 varchar(255) NOT NULL,
    comp3 varchar(255) NULL
);

CREATE TABLE user (
	email	varchar(255)	NOT NULL,
	nick	varchar(100)	NOT NULL,
    pwd     varchar(255)    NOT NULL,
    salt 	varchar(255)  NOT NULL,
    role    varchar(100)  DEFAULT "ROLE_USER" NOT NULL, -- ROLE_ 을 붙여줘야 시큐리티가 접근
    profile varchar(1000) DEFAULT "default.png"  NULL
);

CREATE TABLE know (
	no	int	NOT NULL,
	cate	varchar(255)	NOT NULL,
	name	varchar(255)	NOT NULL,
	cont	varchar(1000)	NOT NULL,
	likes	int	NULL DEFAULT 0,
    likenick varchar(2000) DEFAULT "" NULL,
	date	datetime NOT NULL DEFAULT current_timestamp
);

CREATE TABLE reply (
	no	int	NOT NULL,
    kno	int	NOT NULL,
	email	varchar(100)	NULL,
    profile varchar(255)    NULL,
    nick    varchar(100)       NOT NULL,
    cont    varchar(1000) NOT NULL,
	repn	int	NULL, -- 댓글이 속한 댓글 번호
	repo	int	NULL, -- 댓글이 속한 댓글 중 순서 
	repl	int	NULL, -- 댓글 레벨 (첫 댓글은 0, 답글들은 1)
	checks	int	 NULL	DEFAULT 0	COMMENT '삭제면 1 아니면 0',
    likes   int NULL DEFAULT 0,
    likenick varchar(2000) DEFAULT ""  NULL,
	date	datetime	DEFAULT CURRENT_TIMESTAMP NULL
);

ALTER TABLE today ADD CONSTRAINT PK_TODAY PRIMARY KEY (
	no
);

ALTER TABLE chat ADD CONSTRAINT PK_CHAT PRIMARY KEY (
	no
);

ALTER TABLE room ADD CONSTRAINT PK_ROOM PRIMARY KEY (
	id
);

ALTER TABLE user ADD CONSTRAINT PK_USER PRIMARY KEY (
	email
);

ALTER TABLE know ADD CONSTRAINT PK_KNOW PRIMARY KEY (
	no
);

ALTER TABLE reply ADD CONSTRAINT PK_REPLY PRIMARY KEY (
	no
);

ALTER TABLE today ADD CONSTRAINT FK_know_TO_today_1 FOREIGN KEY (
	kno
)
REFERENCES know (
	no
);

ALTER TABLE chat ADD CONSTRAINT FK_room_TO_chat_1 FOREIGN KEY (
	roomid
)
REFERENCES room (
	id
);

ALTER TABLE reply ADD CONSTRAINT FK_user_TO_reply_1 FOREIGN KEY (
	email
)
REFERENCES user (
	email
);

ALTER TABLE reply ADD CONSTRAINT FK_know_TO_reply_1 FOREIGN KEY (
	kno
)
REFERENCES know (
	no
);

