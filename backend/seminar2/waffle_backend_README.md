# waffle-rookies-18.5-backend-1
- [과제 1](https://github.com/wafflestudio/rookies/blob/master/backend/seminar1/assignment.md) 의 구현 방식 중 하나
- [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 의 본격적인 시작에 앞서,
과제 1을 더 깊이 있게 살펴볼 필요가 있습니다.
- 과제 2의 구현에 바로 뛰어드는 것보다, 과제 1에 대해 받으신 피드백을 살필 시간을 갖고, 비교적 색다른 구현 방식을 이해하며 기본을 다지도록 하면
좋겠다고 생각했습니다.
- 특히, 이 코드는 의도적으로 Django REST framework를 이용해 구현한 부분이 많으므로, 과제 1을 어느 정도 잘 완료하신 분들도 새롭게 익히실 만한 부분이
분명 존재하리라 생각합니다.
- 이 코드를 잘 살펴보고 이해하려 노력하는 것 자체가 과제 2에 포함되며, 시작점이라고 생각해주시면 됩니다. 물론, 과제 2에도 서버를 직접 구현할 사항들이 존재하며
9/15(화) 오전 중에 공유될 예정입니다. 내용과 마감 시한은 해당 시작 시점을 고려하여, 이전과 마찬가지로 적절히 설정할 것입니다.
- 특히, 이 코드의 [0002_auto_20200912_0149.py](waffle_backend/survey/migrations/0002_auto_20200912_0149.py)는
  여러분이 과제 1을 진행하며 직접 생성해 migration하신 파일 이름과 달라서, 과제 1의 migration 부분을 정상적으로 진행하셨든 그렇지 않든,
  Django의 migration 관리가 번거로워질 수 있습니다. 때문에 [settings.py](waffle_backend/waffle_backend/settings.py)를
  보면 아실 수 있듯, 연결하는 MySQL의 database 이름을 `waffle_backend_assignment_2`으로 바꾸었습니다.
  - 이에 따라, 자신의 로컬 MySQL에 root user 등으로 접속하여 해당 database를 새로 생성하고, `waffle-backend` user에게 `grant privileges` 하셔야 합니다.
- 이 서버 코드를 기반으로 [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 를 진행할 예정입니다.
미리 [제출 방식](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md#제출-방식) 을 고려해,
이전과 마찬가지로 해당 repository를 만들고 `waffle_backend` directory를 최상위에 위치시켜두세요.

### 과제 1의 [내용](https://github.com/wafflestudio/rookies/blob/master/backend/seminar1/assignment.md#과제-내용) 과 다른 점
- 더 올바른 설계를 반영하기 위해 과제 1에서 제시된 내용과 다르게 구현된 부분이 있습니다.
  - 과제 1에서는 자신의 정보를 가져오고 수정하는 URI로 단순한 `/api/v1/user/`를 제시했으나, 이는 RESTful하지 못하므로 아래와 같이 구현했습니다.
  - 관련해서는 [#158 issue](https://github.com/wafflestudio/rookies/issues/158) 를 참고하시기 바랍니다.
  - `GET /api/v1/user/{user_id}/` 또는 `GET /api/v1/user/me/`
  - `PUT /api/v1/user/me/`

- DRF를 활용한 구현을 비교적 간소화하기 위해 과제 1에서 제시된 내용과 살짝 다르게 구현된 부분이 있습니다.
  - `POST /api/v1/user/`와 `PUT /api/v1/user/me/`에서, 이미 존재하는 `username`이 요청되는 경우 `409 CONFLICT`가
    아닌, 다른 `request.data` 관련 문제 상황과 마찬가지로 `400 BAD REQUEST`로 응답합니다.
  - 로그인이 되어 있지 않은 요청의 경우, `403 FORBIDDEN`이 아닌 `401 UNAUTHORIZED`로 응답합니다.
  - 하지만 로그인 API에서 존재하지 않는 User의 경우, 비밀번호가 잘못된 경우는 여전히 `403 FORBIDDEN`이며,
    `PUT /api/v1/user/me/`에서 me가 아닌 다른 값이 URI에 포함되는 경우도 `403 FORBIDDEN`입니다.

- 과제 1에서 제시된 내용보다 더 많이 구현된 부분들도 있습니다.
  - 자신의 정보를 수정하는 `PUT /api/v1/user/me/`는 `email`, `password`도 수정 가능합니다.
  - `GET /api/v1/user/{user_id}/`는 `{user_id}`에 `me`뿐만 아니라 `User`의 `id`도 받아, 다른 사람의 정보도 조회 가능합니다.
  - SurveyResult를 생성하는 `POST /api/v1/survey/`는 (자유에 맡겼던 부분인) `major`, `grade`, `backend_reason`,
    `waffle_reason`, `say_something`의 정보도 넣어서 생성 가능합니다.
  - 아래와 같이, 문제 상황의 응답은 비교적 상세한 에러 메시지를 포함합니다. 일부는 DRF를 통해 자동 생성되고 일부는 수동으로 만들어줍니다.
  <img width="724" alt="스크린샷 2020-09-14 04 42 40" src="https://user-images.githubusercontent.com/35535636/93026973-e2b5dd80-f644-11ea-8c50-12570f166edb.png">
  <img width="724" alt="스크린샷 2020-09-14 04 42 27" src="https://user-images.githubusercontent.com/35535636/93026970-e0538380-f644-11ea-834f-71d2b4b27302.png">
  
  - [2번째 세미나](https://github.com/wafflestudio/rookies/tree/master/backend/seminar2) 에서 말씀드린 DRF의 TokenAuthentication을 이용해 User 인증을 구현했습니다.

- 이 외에는 익숙한 코드 구조와 많이 달라보일지라도, 과제 1에서 제시하는 내용을 모두 구현하고 있습니다.(혹시 그렇지 않은 부분을 발견한다면 제보해주세요.)
  과제 2의 본격적 시작 전까지, MySQL에 새로운 database를 만들고 연결하여 서버를 실행하여 직접 관찰해보세요. 특히 아래의 문서들을 참고하시기 바랍니다.
  과제 2, 또는 앞으로 Django와 DRF를 이용한 서버 개발을 하면서 필요할 내용들입니다.
  - [Python dict 관련 함수들](https://wikidocs.net/16#_8)
  - [Python overriding과 super()](https://nirsa.tistory.com/115)
  - [Django QueryDict](https://docs.djangoproject.com/en/3.1/ref/request-response/#querydict-objects)
  - [DRF TokenAuthentication](https://www.django-rest-framework.org/api-guide/authentication/#tokenauthentication)
  - [DRF Serializers의 Validation](https://www.django-rest-framework.org/api-guide/serializers/#validation)
  - [DRF Serializers의 Saving instances](https://www.django-rest-framework.org/api-guide/serializers/#saving-instances), [Partial updates](https://www.django-rest-framework.org/api-guide/serializers/#partial-updates)
  - [How to use DRF serializers effectively during write operations](https://medium.com/@raaj.akshar/how-to-effectively-use-django-rest-framework-serializers-during-write-operations-dd73b62c26b5)
  - [DRF Serializers의 Fields](https://www.django-rest-framework.org/api-guide/fields/)
  - [DRF Serializers의 Context](https://www.django-rest-framework.org/api-guide/serializers/#including-extra-context)
  - [DRF Generic views의 Methods](https://www.django-rest-framework.org/api-guide/generic-views/#methods)
  - [DRF Permissions](https://www.django-rest-framework.org/api-guide/permissions/)
