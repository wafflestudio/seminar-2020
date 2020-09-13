# 와플스튜디오 Backend Seminar[2] 과제

### NOTE: 과제의 일부만 제시되어 있습니다. 9/15(화)에 추가로 확인하셔야 합니다.

### due: -

### 과제 목적
- Django REST framework의 Serializers과 ViewSet을 익힙니다.
- ...

### 주의할 점
- https://github.com/davin111/waffle-rookies-18.5-backend-1 를 clone하되 로컬에 생성된 [waffle_backend](https://github.com/davin111/waffle-rookies-18.5-backend-1/tree/master/waffle_backend) 에서 바로 작업하지 마세요.
아래 '제출 방식'을 통해 생성한 본인의 `waffle-rookies-18.5-backend-2` repo를 로컬에 clone하고, 그 directory 바로 하위에 [waffle_backend](https://github.com/davin111/waffle-rookies-18.5-backend-1/tree/master/waffle_backend)
를 복붙하여 작업을 시작하세요.
- [seminar1](../seminar1) 내부의 waffle_backend와 착각하지 마세요! 또한 본인이 1번째 과제를 위해 기존에 작업했던 서버를 그대로 사용하지 마세요!
- 일반적인 경우 서로 다른 서버면 다른 Python 가상 환경을 쓰는 것이 맞고, 1번째 과제와 별도로 지금의 과제에 대해서는 별개의 Python 가상 환경을 구축하는 것이
바람직합니다. 하지만 1번째 과제와 사용하는 Python 버전, 패키지 등에 사실상 차이가 거의 없으므로, 기존 환경을 그대로 이용하셔도 괜찮습니다.
- '과제 내용'에 언급되어있는 database 설정을 반드시 참조하세요. 로컬 MySQL의 기존 `waffle_backend` database를 그대로 이용하지 않습니다.

### 과제 내용
1.
- 정답이 있는 것은 아니지만 [과제 1](https://github.com/wafflestudio/rookies/blob/master/backend/seminar1/assignment.md) 을
https://github.com/davin111/waffle-rookies-18.5-backend-1 에 구현하고, 과제 1을 완료하신 분들께 invitation을 보냈습니다.
grace day 3일을 고려한 9/14(월)이 지나면 이 rookies repository에도 해당 코드를 옮길 예정입니다. 과제를 완료하고 invitation을 못 받은 분들은 따로 연락해주세요.
- [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 의 본격적인 시작에 앞서,
과제 1을 더 깊이 있게 살펴볼 필요가 있습니다.
- 과제 2의 구현에 바로 뛰어드는 것보다, 과제 1에 대해 받으신 피드백을 살필 시간을 갖고, 비교적 색다른 구현 방식을 이해하며 기본을 다지도록 하면
좋겠다고 생각했습니다.
- 특히, 이 코드는 의도적으로 Django REST framework를 이용해 구현한 부분이 많으므로, 과제 1을 어느 정도 잘 완료하신 분들도 새롭게 익히실 만한 부분이
분명 존재하리라 생각합니다.
- 이 코드를 잘 살펴보고 이해하려 노력하는 것 자체가 과제 2에 포함되며, 시작점이라고 생각해주시면 됩니다. 물론, 과제 2에도 서버를 직접 구현할 사항들이 존재하며
9/15(화) 오전 중에 공유될 예정입니다. 내용과 마감 시한은 해당 시작 시점을 고려하여, 이전과 마찬가지로 적절히 설정할 것입니다.
- 특히, 이 코드의 [0002_auto_20200912_0149.py](https://github.com/davin111/waffle-rookies-18.5-backend-1/blob/master/waffle_backend/survey/migrations/0002_auto_20200912_0149.py) 는
  여러분이 과제 1을 진행하며 직접 생성해 migration하신 파일 이름과 달라서, 과제 1의 migration 부분을 정상적으로 진행하셨든 그렇지 않든,
  Django의 migration 관리가 번거로워질 수 있습니다. 때문에 [settings.py](https://github.com/davin111/waffle-rookies-18.5-backend-1/blob/master/waffle_backend/waffle_backend/settings.py) 를
  보면 아실 수 있듯, 연결하는 MySQL의 database 이름을 `waffle_backend_assignment_2`으로 바꾸었습니다.
  - 이에 따라, 자신의 로컬 MySQL에 root user 등으로 접속하여 해당 database를 새로 생성하고, `waffle-backend` user에게 `grant privileges` 하셔야 합니다.
- 이 서버 코드를 기반으로 과제 2를 진행할 예정입니다. 미리 '제출 방식'을 고려해,
이전과 마찬가지로 해당 repository를 만들고 `waffle_backend` directory를 최상위에 위치시켜두세요.

## 제출 방식
1. 자신의 GitHub 개인 계정에 `waffle-rookies-18.5-backend-2`라는 이름으로 private repository를 개설합니다.

![스크린샷 2020-08-30 02 12 24](https://user-images.githubusercontent.com/35535636/91642533-097dec80-ea67-11ea-96e4-ab0dfa757187.png)

2. 개설 후 Settings > Manage access 로 들어갑니다.

![스크린샷 2020-08-30 02 13 52](https://user-images.githubusercontent.com/35535636/91642567-5eb9fe00-ea67-11ea-9382-89fcce03be70.png)

3. collaborator로, 세미나 운영진들을 초대합니다.

![스크린샷 2020-08-30 02 14 59](https://user-images.githubusercontent.com/35535636/91642588-87da8e80-ea67-11ea-9d5a-60a3596463c9.png)

- [@davin111](https://github.com/davin111) (아래 스크린샷에는 저 자신이라 포함이 안 되어있는 것이고, 당연히 추가하셔야 합니다.)
- [@sanggggg](https://github.com/sanggggg)
- [@dkwanm1](https://github.com/dkwanm1)
- [@Hank-Choi](https://github.com/Hank-Choi)
- [@veldic](https://github.com/veldic)

![스크린샷 2020-08-30 02 16 17](https://user-images.githubusercontent.com/35535636/91642619-cbcd9380-ea67-11ea-84ea-1a0729103755.png)

4. 아래 스크린샷과 같은 directory 구조를 갖추어야 합니다.

```
/README.md
/.gitignore
/waffle_backend/manage.py
/waffle_backend/waffle_backend/*
/waffle_backend/survey/*
/waffle_backend/user/*
...
```

![스크린샷 2020-08-30 03 16 21](https://user-images.githubusercontent.com/35535636/91643553-3b934c80-ea6f-11ea-8e5c-c20b1e6e42a3.png)

![스크린샷 2020-08-30 03 16 29](https://user-images.githubusercontent.com/35535636/91643554-3cc47980-ea6f-11ea-9ade-087b4845df11.png)

5. 마감 시점에 master branch를 기준으로 collaborator로 지정된 세미나 운영진들이 확인할 것입니다. GitHub repository에 반영되도록 commit, push해두는 것을 잊지 마세요.

6. 가급적 repository 생성과 collaborator 지정은 미리 해둬주세요! 제출 방식을 다들 올바로 이해하고 계신지와 함께, 가능하다면 대략적인 진행상황을 보면서 필요하면 몇 가지 말씀을 더 드릴 수도 있습니다.


### 참고하면 좋은 것들
- 추후 점진적으로 추가 예정입니다.
- https://github.com/davin111/waffle-rookies-18.5-backend-1 의 README.md 참고
