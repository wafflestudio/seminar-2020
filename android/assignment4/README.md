# Wafflestudio Android Seminar Assignment #4
Due: 2020.11.21 23:59
## 과제의 목표
- 뼈대코드 없이 스크래치 부터 새로운 앱을 만들어본다.
- API 문서를 읽으며 백엔드 서버의 스펙을 확인하고 직접 기능을 구현해본다.

## 과제 명세
- 이번 과제는 백엔드 [assignment 0](../../backend/seminar0/assignment.md), [assignment 1](../../backend/seminar1/assignment.md), [assignment 2](../../backend/seminar2/assignment.md) 에서 명시된 api 서버를 활용해 세미나 참여자, 진행자를 관리하는 SeminarManager Application 을 제작하는 것입니다.
    - 유저의 회원 가입과 토큰을 persist 하게 저장하며 유저의 인증 정보를 앱에서 가지고 로그인 할 수 있어야 합니다.
    - 회원 가입된 유저는 유저의 타입(Instructor, Participant) 에 따라 다른 행동을 할 수 있습니다.
        - Instructor 는 세미나를 만들고 수정할 수 있습니다.
        - Participant 는 세미나에 참여할 수 있습니다.
    - 유저의 개인 정보를 앱에서 변경 가능하고, 로그아웃 할 수 있습니다.
    - 위 행동과 관련된 모든 사항은 구현 가이드와 데모 app (demo.apk) 를 참고 해주세요.
- 이번 과제는 스켈레톤 코드가 주어지지 않습니다. 그만큼 원하는 기술 스택을 사용하여서 과제를 구현하시면 됩니다.
- 백엔드 서버의 api 문서(TBD)를 통해 어떤 기능을 구현할 수 있는지 확인하고, demo.apk 파일(TBD)을 참고하여 적절한 앱을 구현하시면 됩니다. 과제의 스펙이 정확하지 않은 만큼, 확인에 있어서도 어느정도 여유롭게 진행하려고 합니다.


## 백엔드 서버
- 백엔드 서버에 대한 모든 상세 사항(api endpoint, request format, response format)은 백엔드 assignment 0, 1, 2 에 제공되어 있습니다.
- 백엔드 서버 주소(baseUrl): http://ec2-3-34-178-249.ap-northeast-2.compute.amazonaws.com/
- 백엔드 api 서버 / docs 가 제공됩니다. (현재 디플로이 되기 전입니다. 곧 디플로이 되면 이 문구는 취소선 긋도록 하겠습니다)
    - `baseurl + /docs/` => redoc 문서
        - 실제로 리퀘스트는 날릴 수 없지만, 깔끔한 UI 와 spec을 확인 할 수 있음
        
![스크린샷 2020-11-03 오전 3 58 22](https://user-images.githubusercontent.com/37951125/97907662-f51cdf80-1d88-11eb-8382-ef97b29d4da4.png)
    - `baseurl + /swagger/` => swagger 문서
        - 실제로 리퀘스트를 날려 볼 수 있음.
        - 리퀘스트를 날릴 때 login 을 제외한 대부분의 api 는 token 을 필요로 합니다.
        - 따라서 login api (또는 sign up) 으로 swagger 로 요청을 날려보고 반환값을 받았다면 swagger 의 `authorization` 버튼을 눌러 "Token {받은 토큰 문자열}" 을 등록시켜야 정상적으로 다른 endpoint 를 사용할 수 있습니다.
        
 ![스크린샷 2020-11-03 오전 4 11 05](https://user-images.githubusercontent.com/37951125/97908883-a708db80-1d8a-11eb-98d4-ebc8ad8f425a.png)

    - 현재 나오는 url 중 os, survey 과제 진행에 있어서 필요없는 endpoint 이므로 무시하시면 됩니다.
    

## 상세 구현 가이드

### LoginActivity
- 현재 디바이스에 유효한 User Token 이 없는 경우 LoginActivity 가 나타납니다. (유효한 토큰이 있는 경우 `MainActivity` 로 이동합니다.)
- 유저는 Username, password 를 입력하여 로그인 할 수 있습니다.
    - 로그인 성공시 유효한 `MainActivity` 로 이동하며, token 을 persist 하게 저장하여 앱을 시작할 때 마다 자동 로그인 되도록 합니다.
- `가입하기` Button 을 통해 `SignUpActivity` 로 이동할 수 있습니다.
- 사용가능한 Endpoint
    - PUT `api/v1/user/login/`

### SignUpActivity
- API 명세를 참고하여 적절한 정보를 입력하여 회원가입을 진행합니다.
- `가입` Button 을 통해 회원가입을 완료할 수 있습니다. 회원가입 성공 시 token을 persist 하게 저장하고 `MainActivity` 로 이동합니다.
- 사용가능한 Endpoint
    - POST `api/v1/user/`

### MainActivity
- Activity는 총 두 개의 Page(SeminarFragment, UserFragment) 가 있고 각 페이지는 ViewPager + Fragment 로 구현합니다.
- 유저는 화면 하단의 `BottomNavigation` 을 통해 각 Fragment 를 이동할 수 있습니다.

### 1. Seminar Fragment
#### Room List
- 현재 존재하는 모든 Seminar 를 List 로 보여줍니다.
- 각 List 의 item 은 세미나 이름과 ~~세미나 의 시간 (`hh:mm`) 을~~ **세미나의 진행자 이름 (여러명 존재시 "," 으로 연결한 문자열) 을** 보여줍니다. [#258](https://github.com/wafflestudio/rookies/issues/258)
- List item 의 background 색상은 내가 진행자인 세미나일 시 녹색(#dcedc8), 내가 참여자인 세미나일 시 푸른 색(#b3e5fc) 으로, 둘 다 아닐 경우 흰 색 (#ffffff) 으로 보입니다.
- Seminar Fragment 가 화면에 위치하고 현재 유저가 instructor 자격이 있을 경우 Activity 의 ActionBar 에 `+` 아이콘을 띄웁니다. 아이콘을 누를 시 `CreateSeminarActivity` 로 전환합니다.
- 사용가능한 Endpoint
    - GET `api/v1/seminar/`

### 2. User Fragment
- 현재 회원의 이름 정보(username, first_name, last_name) 를 보여줍니다.
- 이름 정보는 EditTextField 로, 수정 후 `회원정보 수정하기` Button 을 누를 시 회원 정보를 변경합니다름
    - 성공시 `수정이 완료되었습니다.` Toast message 를 보여줍니다.
    - 실패시 실패 이유(fail message)에 따라 적절한 Toast message 를 보여줍니다.
- 현재 수강중인 세미나의 목록을 horizontal list 로 보여줍니다. 수강 중인 세미나가 없을 시 표시하지 않습니다.
    - 각 세미나 item 을 클릭시 해당 세미나의 DetailSeminarActivity 로 넘어갑니다.
- 현재 진행중인 세미나의 목록을 horizontal list 로 보여줍니다. 진행 중인 세미나가 없을 시 표시하지 않습니다.
    - 각 세미나 item 을 클릭시 해당 세미나의 DetailSeminarActivity 로 넘어갑니다.
- 사용가능한 Endpoint
    - GET `api/v1/user/me/`
    - PUT `api/v1/user/me/`

### CreateSeminarActivity
- instructor 자격이 있을 때만 진입할 수 있습니다.
- API 명세를 참고하여 name, capacity, time 등의 input을 입력받습니다.
- `생성`  Button 을 누를 시
    - 성공했다면 해당 seminar 의 DetailSeminarActivity 로 이동합니다.
    - 실패했다면 해당 실패 메세지를 Toast 로 출력합니다.
- 사용가능한 Endpoint
    - POST `api/v1/seminar/`

### DetailSeminarActivity
- 세미나의 상세 정보를 보여줍니다.
- 세미나의 이름 등의 정보를 보여줍니다.
- 세미나의 진행자를 vertical list 로 보여줍니다. username 만 표시해도 좋습니다. 진행자가 없을 경우 "Empty" 와 같은 Text 를 대신 출력합니다.
- 세미나의 참여자를 vertical list 로 보여줍니다. username 만 표시해도 좋습니다. 참여자가 없을 경우 "Empty" 와 같은 Text 를 대신 출력합니다.
- 현재 유저가 Instructor 의 경우 `Join` Button 을 누를 시 해당 세미나의 진행자로 추가됩니다.
- 현재 유저가 Participant 의 경우 `Join` Button 을 누를 시 해당 세미나의 참여자로 추가됩니다.
- 사용가능한 Endpoint
    - GET `api/v1/seminar/{seminar_id}/`
    - POST `api/v1/seminar/{seminar_id}/user/`

## **제출 방식**
- 자신의 waffle-android-assign 의 seminar-manager branch에 파일을 성공적으로 올렸다면 해당 브랜치(seminar-manager) 에서 master 브랜치로 pull request 를 날린다. 이때, assignee 에 `sanggggg` 를 꼭 기입한다.


## 자료 (TBD)
- 백엔드 서버 base url
- demo apk
- 백엔드 서버 docs

