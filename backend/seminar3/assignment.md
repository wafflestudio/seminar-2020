# 와플스튜디오 Backend Seminar[3] 과제

### due: 2020.10.11.(일) 23:59

### 과제 목적
- 직접 개발한 API가 구체적인 개발 명세를 엄밀히 지켰는지 확인하고, 잘못된 부분을 수정 개발합니다.
- test를 스스로 정의하고 통과하는 노력을 통해, 개발에 있어 test의 중요성과 API 단위의 test에 익숙해집니다.
- test와 관련된 개념과 원칙 등을 익히고, coverage 등의 관련 도구를 이용해봅니다.

### 주의할 점
- 본인이 [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 를 위해 생성한 private repository인 `waffle-rookies-18.5-backend-2`에서 이어서 작업합니다.
`workspace` branch의 최신 상황에서 `git checkout -b test` 등으로 새로운 branch를 생성해 진행하세요.
- 과제 2를 온전히 완료한 상황에서 진행해야 합니다. 과제 3을 진행하며 과제 2 제출 당시의 부족한 지점을 발견하더라도, 과제 2 당시의 `workspace`
branch에 추가적인 변경을 가해서는 안됩니다.
- [과제 2 종합 피드백](https://youtu.be/-s9gCmdpXn0)을 참고하시면 좋습니다. 정답이 있는 것이 아니므로 자신의 코드를 피드백에서 언급된 방식대로 반드시 고쳐야 한다는 생각을 갖지는 말아주세요. 다만 부족했던 부분이 있었다면, 자신의 코드를 개선하려는 노력이 과제 3에서 드러나야 합니다.
- Django에서 기본적으로 test를 위해 사용하는 database는 별개로 생성됩니다. 이에 대해 [관련 문서](https://docs.djangoproject.com/en/3.1/topics/testing/overview/#the-test-database) 등을 참조하고, MySQL의 `waffle-backend` 사용자에게 관련 권한을 부여하는 것을 잊지 마세요.
- test를 작성하는 것은 제법 귀찮은 일처럼 여겨지고 당연한 것을 확인하기 위해 많은 시간 투자를 하는 과정으로 여겨질 수 있습니다.
그러나 단 하나의 실수를 방지하기 위해 수백 개의 동작을 반복해 확인하는 것이며, 무엇보다 test는 test 작성 시점 자체보다도
이후 기능 추가, 유지 보수 등의 과정에서 기존에 개발해둔 의도가 훼손되지 않도록 하는 강력한 도구라는 점을 기억하도록 합시다. 또한 협업에서 다른 개발자가
기존 코드의 맥락을 잘 모르고 수정해 오작동하게 하는 상황을 사전에 방지해 줍니다.
- 제출 방식을 잘 지켜주세요. 제출 방식 때문에 자신이 의도한 마감 시점보다 이후에 commit하게 되는 경우에는, `test` branch의 `README.md`에 해당 특이 사항을 기재해주세요.
이러한 내용이 적절한 위치에 없으면 그러한 사유에도 인정하지 않겠습니다.

## 과제 내용
### 1
- [tests_user.py](tests_user.py) 파일을 `waffle-rookies-18.5-backend-2`(`test` branch)의 `/waffle_backend/user/` 내부에
`tests.py` 등의 이름으로 넣으세요. 다만 관련 문서를 보면 알 수 있듯, 일반적으로 일정한 파일 이름으로 만들어야 test 파일로서 동작합니다. `tests_user.py`
라는 이름은 유효합니다.
- `tests_user.py`에는 `POST /api/v1/user/`, `PUT /api/v1/user/me/` API에 대한 기본적인 test들이 포함되어 있습니다.
우선 해당 test를 `python manage.py test` 또는 `python manage.py test user`으로 실행시켜 보세요.
- 만약 실패한다면 `test` branch에서 그대로, 관련 API의 개발 내용을 수정하시면 됩니다. 이후 본인이 작성하시는 test를 이용하면서 부족한 점을 스스로 발견하고
고쳐나가는 것 자체가 이번 과제의 핵심입니다. (`InstructorProfile`, `ParticipantProfile`을 다른 위치에 정의해서 생기는 문제에 대해서는 해당 [import line](https://github.com/wafflestudio/rookies/blob/master/backend/seminar3/tests_user.py#L7)을 수정하셔도 좋습니다.)
(과제 2의 관련 명세가 엄밀하지 않아, `accepted`를 request body에서 optional하지 않은 것으로 전제했거나, optional하더라도 default 값이 `False`인 것으로 전제했을 수 있습니다.
이 경우 무언가를 잘못했던 것은 아니고, 과제 3을 위해서는 test가 전제하는대로 수정해주시면 됩니다. - [#221 issue](https://github.com/wafflestudio/rookies/issues/221) 참고)

### 2
- 아래 모든 API들(일부 API가 없는 것은 의도된 것으로, 물론 그에 대해서도 test 작성하셔도 좋습니다.)에 대해 [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 의 명세를 참고해,
test를 작성하세요. 이미 작성되어 있는 일부 API에 대해서도 test를 보강할 필요가 있다고 여겨지면 수정 및 추가하셔도 좋습니다.(실제로 부족한 부분이 있습니다.)
    - POST /api/v1/user/
    - PUT /api/v1/user/login/
    - PUT /api/v1/user/me/
    - GET /api/v1/user/{user_id}/
    - GET /api/v1/user/me/
    - POST /api/v1/user/participant/
    - POST /api/v1/seminar/
    - PUT /api/v1/seminar/{seminar_id}/
    - GET /api/v1/seminar/{seminar_id}/
    - GET /api/v1/seminar/
    - POST /api/v1/seminar/{seminar_id}/user/
    - DELETE /api/v1/seminar/{seminar_id}/user/

- `tests_user.py`를 보시면서 또는 스스로 test를 작성하시면서 느끼시겠지만, 모든 경우에 대해 완벽한 test를 작성하는 것에는 무리가 있습니다. 예를 들어,
`PUT /api/v1/user/me/`에 대해 미리 작성해둔 test들만 해도, request body가 불충분해서 `400`이 발생해야 하는 경우가 실제로는 훨씬 많은 경우의 수가 있을 것입니다.
- 때문에 충분한 test를 작성하려고 하되 적정선을 스스로 찾아야할 필요는 있습니다. 기본적으로는 모든 로직을 test해야 한다는 것을 기본 마인드로 가지셔야 합니다.
- 각 API들에 대해 정상 동작하지 않을 수 있는 기본적인 각 경우와 정상 동작하는 기본적인 경우에 대해서는 모두 작성해야 합니다. 예를 들어 request body에
필수로 요구되는 특정 key들이 빠진 경우를 test하려고 할 때, A라는 key가 빠진 경우와 B라는 key가 빠진 경우, A와 B 모두 빠진 경우 등을 일일이 test를 작성할
필요까지는 없으나, 특정 key가 빠진 경우에 대한 동작 명세가 과제 2에 있었다면 그중 적어도 한 경우는 test code로서 수행되어야 한다는 것입니다.
- test code는 일반적으로 꽤 길어지며, test 각각이 하나의 상황을 분명하게 test 해야 합니다. 하나의 test 파일 안에서도 적절히 `TestCase`를 나누고
그 내부에서도 test method를 나누세요. 하나의 Django app 내에서도 test 파일을 여러 개로 나누어 작성해도 좋습니다. 예를 들어 user app에서 test 파일을
여러 개로 나누려고 한다면 `/waffle_backend/user/tests` 라는 directory를 생성하고 여기에 user app의 test 파일들을 포함시키세요.
- 본인이 생각하기에 적절한 test method 이름을 붙여야 하며, test code의 의미를 이해하기 어려울 수 있다고 여겨지는 부분에 대해서는 주석을 포함시키세요.
- 각 API들에 대해, 최소 한 번 이상은 response body의 모든 부분들을 간단히라도 체크해야 합니다. 이 때 `null`, `""`, `[]` 등의 차이에 대해서도 엄밀하게 test하세요.
- response body만 항상 test하지 말고, 직접 DB를 Django code로 직접 조회해 값이나 개수 등을 확인하는 test 코드도 포함시키도록 하세요.
예를 들어 `PUT /api/v1/user/me/`의 경우 response body만 보면 `User` 등의 정보가 수정된 것처럼 보이더라도, model instance에 대해 `save()`를 하지 않는 등의 실수로 인해
실제 DB에는 수정이 안 되었을 수 있다는 등 여러 최악의 경우를 고려해야 합니다.

### 3
- 지금은 API 단위의 test만 예시를 드렸고 실제로 이번 과제 3에서 요구하는 test 유형도 그것뿐이지만, 실제로는 class나 method 단위로 구체적인 구현 수준의
test 역시 별도로 작성하기도 합니다. 이 과제에서 그만큼 요구하지는 않지만 실제로 바람직한 개발은 그만큼을 필요로 하기도 한다는 점을 알아주시고, 가능하면 관련 내용도 찾아보세요.
과제 2의 구현 방식이 각자 다를 것이기 때문에 관련한 예시 test를 직접 드릴 수 없다는 상황도 인지하셔야 합니다.
- 서로 다른 TestCase끼리도 당연하고, 같은 TestCase 내부의 각 test method들끼리도 서로 independent 해야합니다. test method 간의 실행 순서가
서로에게 무관해야 하며, 어떤 test의 실행 결과가 다른 test의 실행에 영향을 끼쳐서는 절대 안됩니다.
- test가 실제 DB의 data 등의 외부 상황에 의존성이 없고 철저히 logic을 테스트하도록 작성해야 합니다. 관련해서 mock, stub 등의 키워드로 관련 정보를 찾아보셔도 좋습니다.

### 4
- test를 열심히 작성하고 꼼꼼히 생각할 수록, 더 오래 걸리고 번거로운 과제가 될 가능성이 높습니다. 세미나 전체적으로도 당연한 말이지만, 이것이 완료 자체에만 목적을 두는 과정이 아닌,
개발 자체에 능숙해지기 위한 공부 과정이라는 것을 잊지 마시고 스스로에게 엄격해지시기를 바랍니다. 그럴수록 당연히 본인 실력에 큰 도움이 될 것이에요.
- 과제 2 당시에 부족하게 구현했던 부분을 test를 이용한 개발 과정에서 발견하셨다면 `test` branch의 `README.md`에 기록해나가 주세요.(필수) 알아보기 좋게 API 단위로
구분해서 적어주시는 등의 방식을 포함해주세요.
- 과제 3을 진행하시는 중에 과제 2에 대한 피드백을 드리게 될텐데, 과제 3 진행 과정에서 해당 피드백을 반영하시면 좋습니다.
- test를 통해 발견하긴 했으나 test와는 무관한 개발 질문이나 tip 등을 [Issues](https://github.com/wafflestudio/rookies/issues) 에 공유하는 상황에는 `HW2` label을 달아주시기 바랍니다.

### 5
- 본인이 test를 최소한의 수준으로는 잘 작성해가고 있는지 도움을 받을 수 있는 도구들도 여럿 있습니다. 그중 하나는 Python package인 coverage입니다.
test를 실행할 때 자신이 개발해둔 코드 중 몇 %가 실행되는지 그 coverage를 아주 기계적으로 계산해줍니다. 단순히 실행 범위만 따지는 것이기에, % 자체를 무의미하게
높이기는 아주 쉬우며 그 자체는 의미가 전혀 없습니다. 참고의 척도로만 삼아주세요.
- 다만 모든 `views.py`, `serializers.py`, `models.py`(와 이 파일들에서 이용하는 별도로 생성한 파일이 있다면 그것들 각각)는 test 실행 후 `coverage report`로 조회했을 때 최소 90%의 coverage를 가져야 합니다.
그러나 이 % 자체를 과제 평가 척도로 삼겠다는 것은 절대 아니고, coverage라는 도구 및 개념을 소개하고, 본인이 최소한의 방향을 지켜 나아가고 있는지
참고로 삼을 수 있다는 점을 알려드리기 위한 의미가 큽니다.
- `pip install coverage==5.3`를 통해 coverage 5.3을 설치해서 진행해주세요. 그 외에 대해서는 관련 문서를 참고하시기 바랍니다.

### 6
- `waffle-rookies-18.5-backend-2`의 `README.md`(`test` branch)에 과제 관련 하고 싶은 말, 어려웠던 점 등을 남겨주세요. 물론 적극적으로 해결되어야 할 피드백이나
질문 사항은 [Issues](https://github.com/wafflestudio/rookies/issues) 등을 이용해주세요!
- 개발 과정의 흐름이나 시행 착오를 알아보기 좋게 작성해주셔도 좋습니다.
- 과제 2 당시에 부족하게 구현했던 부분을 test를 이용한 개발 과정에서 발견하셨다면 간단히 README.md에 기록해나가 주세요.

### 7 (자유 과제: GitHub Actions로 Django test에 대한 CI 진행하기)
- 과제 2를 충분히 완벽히 수행해서 과제 3의 진행 속도가 훨씬 빠르거나, 추가적인 개발 동기 부여를 얻고 싶은 분들을 위해 과제 3 기간 후반부에
필수가 아닌 추가 과제를 공유드렸습니다.

- CI(Continuous Integration)는 지속적인 통합으로, 개발자를 위한 자동화 프로세스라고 할 수 있습니다. CI를 성공적으로 구현할 경우
애플리케이션에 대한 변경 사항이 자동으로 테스트되어 repository에 통합되므로 여러 개발자가 동시에 작업을 할 경우 서로 충돌할 수 있는 문제를 좀 더
똑똑하게 방지할 수 있습니다. 또한, 애초에 개발자 스스로가 branch에 commit, push할 때 test를 철저히 하여 문제의 소지가 없게 해야하지만,
게을러서 또는 실수로 충분한 검토 없이 branch에 push를 하여 Pull Request를 만들고, 이것이 실제 서비스 배포를 진행하는 branch에 merge되어
버릴 수 있습니다. GitHub에 CI 도구를 적용시키면 PR이 open되었을 때, 각 branch에 push가 발생할 때마다 자동으로 설정한 스크립트 등에 따라
test, build 등이 진행되어 이러한 문제를 어느 정도 방지 할 수 있습니다.

  - CI 동작 결과를 기다리는 상황
    ![스크린샷 2020-10-10 19 22 27](https://user-images.githubusercontent.com/35535636/95652700-f2ceb900-0b2d-11eb-85d8-cc896922b912.png)

  - CI 동작이 모두 완료된 상황(성공)
    ![스크린샷 2020-10-10 18 47 15](https://user-images.githubusercontent.com/35535636/95652209-71c1f280-0b2a-11eb-858d-a30cb9df891b.png)

- CI 도구에는 Travis, Jenkins 등 다양한 것이 있고 각자가 초점을 맞추고 있는 것도 조금씩 다르지만, 여기서는 GitHub이 최근에 도입한
[GitHub Actions](https://docs.github.com/en/free-pro-team@latest/actions) 를 이용해보도록 합시다.

- 위 링크의 공식 문서와, 여러 자료들, 그리고 자신의 repository의 Actions 탭을 눌렀을 때 나오는 제안되는 workflows 등을 참고해
우리의 Django app을 위한 자동화된 test를 만들어보세요. 생각보다 직접 작성할 부분 거의 없이, 각 부분이 무슨 내용인지만 이해하면 다른 사람이 만든 것을
거의 그대로 갖다 써서 필요한 부분만 고쳐 쓰기 쉽습니다.

  ![스크린샷 2020-10-10 19 04 07](https://user-images.githubusercontent.com/35535636/95652378-73d88100-0b2b-11eb-8915-f85f05cf18b4.png)

- `waffle-rookies-18.5-backend-2`의 최상위에 `.github/workflows` directory를 만들고 `django.yml`로 workflow를 작성하고,
처음 몇 줄이 다음과 같게 하세요.

  ```
  name: Django CI
  
  on:
    push:
      branches: [ master ]
    pull_request:
      branches: [ master ]
  ```
  [최근 GitHub 정책](https://github.com/github/renaming) 에 따라 새로 만들어지는 repository는 default branch가 `main`이기도 하다는 점에 주의하세요.

- Python 버전은 당연히 가상환경에서 사용하고 있는 버전(3.8.3)에 호환되어야 하며, 일련의 설정과 준비 과정을 통해 결과적으로 PR을 열고, branch에 push할 때마다
GitHub Actions workflow를 통해 `python manage.py test`가 자신이 작성한 모든 테스트를 자동으로 잘 실행시키면 됩니다.

- `test` branch로 만들었던 PR에 `.github/workflows/django.yml`을 그대로 포함시키면 됩니다. Actions를 통해 test가 정상적으로 실행되었다면(fail, pass와 무관하게),
PR 하단의 merge 버튼 위에 생기는 CI에 대한 정보의 `Details`를 눌러 내용을 살펴보세요. 이를 통해 로그를 보고, 관련 스크린샷을 촬영하세요.
`waffle-rookies-18.5-backend-2`의 최상위에 `/results` directory를 만들어 적절한 이름으로 포함시키세요.

- 자유 과제는 마감, grace day 등에 상관이 없습니다. 자유 과제를 위해 자신이 의도한 마감 시점보다 이후에 commit하게 되는 경우에는,
`test` branch의 `README.md`에 해당 특이 사항을 기재해주세요. 자유 과제를 수행하셨다는 내용 자체도 적어주세요.

- 관련한 질문이 있으면 [Issues](https://github.com/wafflestudio/rookies/issues) 에 `HW3+` label을 포함하여 올려주시면 됩니다.

### 8 (자유 과제: React로 만든 웹 frontend와 local 환경에서 연결하기)
- 과제 2를 충분히 완벽히 수행해서 과제 3의 진행 속도가 훨씬 빠르거나, 추가적인 개발 동기 부여를 얻고 싶은 분들을 위해 과제 3 기간 후반부에
필수가 아닌 추가 과제를 공유드렸습니다.

- 한결([@Hank-Choi](https://github.com/Hank-Choi)) 씨가 만들어주신 과제 2 및 3의 명세에 따른 웹 프론트엔드가
https://github.com/Hank-Choi/wba2_client 에 공개되어 있습니다.

- 해당 repository를 local 환경의 별도의 위치에 clone한 후,
Node.js와 npm을 설치하세요. `npm install -g yarn` 등을 통해 yarn을 설치하고, `package.json`이 있는 위치에서 `yarn start`를 통해
실행하시면 localhost의 `3000` port로 접근하실 수 있습니다. [여기](https://github.com/Hank-Choi/wba2_client/blob/e49e9f0de47e33d27e47039a60714c827edffc86/package.json#L5) 를
보면 아실 수 있듯, Django 서버가 `8000` port에서 실행된다는 상황이 전제되어 있습니다. 

- 웹 브라우저로 React app에 접근하여, instructor로 Seminar를 만들고 participant 3명 이상이 참여한 상황을 만들어보세요. 해당 스크린샷을
`waffle-rookies-18.5-backend-2`의 최상위에 `/results` directory를 만들어 적절한 이름으로 포함시키세요.

- 추가 과제이지만, 편리한 프론트엔드 화면을 통해 자신이 만든 서버를 재미있게 테스트해볼 수 있어 과제 3 진행 자체에 도움이 될 수 있습니다.

- 자유 과제는 마감, grace day 등에 상관이 없습니다. 자유 과제를 위해 자신이 의도한 마감 시점보다 이후에 commit하게 되는 경우에는,
`test` branch의 `README.md`에 해당 특이 사항을 기재해주세요. 자유 과제를 수행하셨다는 내용 자체도 적어주세요.

- 관련한 질문이 있으면 [Issues](https://github.com/wafflestudio/rookies/issues) 에 `HW3+` label을 포함하여 올려주시면 됩니다.

## 제출 방식
1. 과제 2를 통해 생성한 GitHub 개인 계정의 `waffle-rookies-18.5-backend-2` private repository에서 이어 작업합니다.

2. 과제 진행은 다음 절차를 따라주세요
  - **waffle-rookies-18.5-backend-2 의 `workspace`에서 `git checkout -b test` 로 이번 과제를 진행할 새로운 브랜치를 만들고 이동합니다.**
  - 해당 branch에서 작업을 완료해주세요. (**master, workspace branch에 push하면 안됩니다. test branch에만 변경사항을 반영해주세요.**)
  - 과제를 진행하면서 test branch에 commit, push 해주시고 Pull Requests를 생성하시면 됩니다. (master(workspace 아님) <- test)
  - git이 어려운 경우 [OT자료](../../wafflestudio%2018.5%20rookies%20OT.pdf), https://backlog.com/git-tutorial/kr/stepup/stepup1_1.html 등을 참고해주세요.

3. 마감 시점에 PR을 기준으로 collaborators로 지정된 세미나 운영진들이 확인할 것입니다. GitHub repository에 반영되도록 commit, push해두는 것을 잊지 마세요.

4. master, workspace branch의 상태는 반드시 본인 과제 2의 제출 시점과 동일해야합니다. 

## 참고하면 좋은 것들
- 관련 문서(추후 점진적으로 추가 예정입니다.)
    - https://docs.djangoproject.com/en/3.1/topics/testing/overview/
    - https://docs.djangoproject.com/en/3.1/topics/testing/tools/
    - https://realpython.com/test-driven-development-of-a-django-restful-api/
    - https://docs.python.org/3/library/unittest.html
    - https://docs.djangoproject.com/en/3.1/topics/testing/advanced/#integration-with-coverage-py
    - https://coverage.readthedocs.io/en/coverage-5.3/

- 앞으로도 늘 그렇겠지만, 과제를 진행하며 모르는 것들과 여러 난관에 부딪히리라 생각됩니다. 당연히 그 지점을 기대하고 과제를 드리는 것이고, 기본적으로 스스로 구글링을
통해 여러 내용을 확인하고 적절한 수준까지 익숙해지실 수 있도록 하면 좋겠습니다.
- [Issues](https://github.com/wafflestudio/rookies/issues) 에 질문하는 것을 어려워하지 마시길 바랍니다. 필요하다면 본인의 환경에 대한 정보를 잘 포함시켜주세요.
또한 Issue 제목에 과제 내용의 번호 등을 사용하시기보다, 궁금한 내용의 키워드가 포함되도록 해주세요. 답이 정해져있지 않은 설계에 대한 고민 공유도 좋습니다.
- 문제를 해결하기 위해 질문하는 경우라면, 질문을 통해 기대하는 바, (가급적 스크린샷 등을 포함한) 실제 문제 상황, 이를 해결하기 위해 시도해본 것, 예상해본 원인 등을 포함시켜 주시는 것이 자신과 질문을 답변하는 사람, 제3자 모두에게 좋습니다.
- 저는 직장을 다니고 있으므로 아주 빠른 답변은 어려울 수 있고, 특히 과제 마감 직전에 여러 질문이 올라오거나 하면 마감 전에 모든 답변을 드릴 수 있다는 것은
보장하기 어렵다는 점 이해해주시면 좋겠습니다. 그리고 세미나 진행자들이 아니어도, 참여자 분들 모두가 자신이 아는 선에서 서로 답변을 하고 도우시려고 하면 아주 좋을 것 같습니다.
- 과제의 핵심적인 스펙은 바뀌지 않을 것이며 설령 있다면 공지를 따로 드릴 것입니다. 하지만 문구나 오타 수정 등의 변경은 수시로 있을 수 있고,
특히 '참고하면 좋을 것들'에는 추가 자료들을 첨부할 수도 있습니다. 때문에 종종 이 repository를 pull 받아주시거나, 이 페이지를 GitHub에서 종종 다시 확인해주시기 바랍니다.
