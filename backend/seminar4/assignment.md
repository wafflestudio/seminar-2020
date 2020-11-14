# 와플스튜디오 Backend Seminar[4] 과제

### due: 2020.11.15.(일) 23:59

### 과제 목적
- Redis를 이용해 기본적인 caching 로직에 익숙해지고 이를 활용합니다.
- AWS의 EC2, RDS 서비스를 이용해봅니다.
- Nginx, uWSGI를 활용해 정적/동적 콘텐츠를 배포하고, 좀 더 나은 배포 방식을 고민합니다.
- 도메인을 직접 구입해 EC2 instance에 연결하고, DNS와 HTTPS의 개념을 익힙니다.

### 주의할 점
- 본인이 [과제 2](https://github.com/wafflestudio/rookies/blob/master/backend/seminar2/assignment.md) 를 위해 생성한 private repository인 `waffle-rookies-18.5-backend-2`에서 이어서 작업합니다.
`test` branch의 최신 상황에서 `git checkout -b deploy`로 새로운 branch를 생성해 진행하세요.
- 배포를 위해 생성하고 수정한 파일들도 확인할 수 있도록 EC2 instance에서도 `deploy` branch에서 진행하고, 진행 내용을 commit해 push하세요.
- 과제 3을 온전히 완료한 상황에서 진행해야 합니다. 과제 3 당시의 `test` branch에 추가적인 변경을 가해서는 안됩니다.
- 다른 모든 것에 대해서도 마찬가지이지만, 배포에 관련해 인터넷에서 검색하여 나오는 자료들을 무비판적으로 따라하지 마세요. 어떤 프로젝트를 배포하려 하는지, 어떤 기술 스택을 이용하고 있는지, 어떤 OS를 이용하고 있는지, 어떤 의도를 가지는지 등에 따라 진행해야하는 것이 다를 것입니다.
- 제출 방식을 잘 지켜주세요. 제출 방식 때문에 자신이 의도한 마감 시점보다 이후에 commit하게 되는 경우에는, `deploy` branch의 `README.md`에 해당 특이 사항을 기재해주세요.
이러한 내용이 적절한 위치에 없으면 그러한 사유에도 인정하지 않겠습니다.

## 과제 내용
### 1
- caching을 하는 저장 공간은 [여기](https://docs.djangoproject.com/en/3.1/topics/cache/) 에서도 찾아볼 수 있듯 다양하지만,
특히 많이 사용되는 것에는 Redis가 있습니다. Redis를 이용한 caching 로직을 구현해보도록 합니다. 자신의 local 환경에 [Redis](https://redis.io) 를 설치하여 `redis-server`, `redis-cli`가 동작하게 하세요.
각자의 환경을 고려하여 적절히 설치하세요. 마치 RDB인 MySQL을 local 환경에 설치하여 개발 과정에서 이용하는 것과 유사합니다. 실제 배포 환경에서는 또 별도의 Redis가 필요할 것입니다.
- 개발되어 있는 `GET /api/v1/seminar/` API를 수정하여, query param의 `order` 여부, 또는 그 값에 따라 존재하는 두 경우 모두를 각각 caching 하도록 합시다.
`name`이 query param에 존재하는 경우에는, caching의 장점을 충분히 활용하지 못할 가능성이 높으므로 caching을 이용하지 않습니다.
- `redis-server`를 통해 Redis를 local 환경에서 실행하는 상황에서 caching 로직을 포함해 수정 개발한 API가 잘 동작하는지 확인하세요.
cache key, timeout을 어떻게 설정할지는 자유입니다.
- 직접 `print` 등을 통해 Python 코드로 동작을 확인할 수도 있겠지만, Django Debug Toolbar와 `redis-cli`를 활용하여 caching이 된 경우와 그렇지 않은 경우 모두를
확인하도록 합시다. Django Debug Toolbar에서 cache hit, cache miss 각각의 경우를 확인하고
`waffle-rookies-18.5-backend-2`의 최상위 `/results` directory에 해당 스크린샷을 적절한 이름으로 포함시키세요. cache hit 상황에서는
Seminar들을 DB에서 가져오는 불필요한 query가 발생하지 않아야 할 것입니다.
또한 `redis-cli`에 접근하여, 명령어를 이용하여 caching이 된 상황에서 지정한 cache key가 Redis에 저장되어 있는 것을 확인하고 스크린샷을 `/results`에 남기세요.
cache가 만료되어 cache key가 사라진 경우에 대해서도 마찬가지입니다.

### 2
- [Amazon Web Services(AWS)](https://aws.amazon.com)의 EC2와 RDS 서비스를 이용하여 `waffle-rookies-18.5-backend-2` 서버를 직접 배포합시다.
어려운 내용이 많을 수 있지만, 기본적으로 [3번째 세미나](https://github.com/wafflestudio/rookies/blob/master/backend/seminar3) 와
[4번째 세미나](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4) 의 내용을 참고하면 많은 부분을 해결할 수 있을 것이라 생각합니다.
특정한 상황에서 배포를 하는 하나의 방식을 보여드렸을 뿐이니, 기계적으로 해당 내용을 참고하지 마시고 최대한 각각의 행동이 무엇을 의미하는지 이해하려 노력하세요. 고민을 하고 찾아보아도 어려운 내용이 있다면 [Issues](https://github.com/wafflestudio/rookies/issues)
에서 나눠주시면 됩니다.
- AWS 계정이 없는 경우에는 새로 생성하여 주시고, [Free Tier](https://aws.amazon.com/ko/free/free-tier-faqs/) 를 사용 가능하다면 1달의 EC2, RDS 사용량을 초과하지 않도록 `t2.micro`를 instance type으로 선택하시면 됩니다.
위의 링크와 기타 [관련 설명](https://aws.amazon.com/ko/free/?all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc) 등에도 있듯, EC2와 RDS
에 대해 t2.micro 기준 각각 한 달에 750시간(약 24 * 31)을 이용할 수 있으며, 따라서 t2.micro라도 각 서비스 내에서 복수 개의 instance를 동시에 운영하면 해당 범위를 초과하게 됩니다.
기타 AWS 사용 방식에 대해 충분히 알아보지 않고 사용해, 의도치 않게 비용이 부과되는 경우에 대해서는 본인 책임입니다.

- EC2의 AMI를 택할 때, OS는 `Amazon Linux 2 AMI (HVM), SSD Volume Type`를 선택해주세요.
- RDS의 Engine으로는 `MySQL`을 선택해주세요.
- AWS의 각 자원들에는 Tag를 달아둘 수 있으며, 이것을 달아두는 것은 좋은 습관입니다. Tag의 Key로 `Name`을 설정하고, Value로는 `waffle-backend-server`,
`waffle-backend-db` 등을 달아두도록 합시다.
- EC2, RDS 둘 중 하나의 자원을 먼저 생성할 때, (VPC) Security Group을 `waffle-backend` 등의 이름으로 생성하도록 합시다.(특히 EC2의 자원 생성
Step 2 직후 바로 `Review and Launch`를 통해 완료하지 말고, `Configure Instance Details`를 통해 다음 단계를 계속 진행하도록 하세요.) 나중에 생성하는 자원에 대해서는
default Security Group 등을 사용하지 말고, 앞서 생성한 Security Group을 택해서 두 자원이 하나의 Security Group에 포함되도록 해주세요.
해당 Security Group에서 절대 SSH port를 모든 IP(`0.0.0.0/0` 등)에 노출하지 마세요. 또한 자신의 집 IP 등을 저장할 때 Description을 잘 기입하는 습관을 들이도록 합시다.
- EC2, RDS의 각 자원을 성공적으로 생성했다면 해당 instance들이 실행되고 있는 것을 AWS console에서 캡처해 `/results`에 해당 스크린샷을 적절한 이름으로 포함시키세요. 아래는 EC2의 예시입니다.
  - ![스크린샷 2020-10-18 18 33 55](https://user-images.githubusercontent.com/35535636/96363627-888ec780-1170-11eb-8478-33e086f8bd95.png)
- 이 시점에서(아직 동작하지 않는 상황이라도), 생성된 EC2의 Public IPv4 address, Public IPv4 DNS를 복사하여 [rookies](https://github.com/wafflestudio/rookies) 의
[assignment-servers.md](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4/assignment-servers.md) 에 반영하는 Pull Requests를 open하시기 바랍니다.
(마치 [rookies.txt](https://github.com/wafflestudio/rookies/blob/master/rookies.txt) 에 대해 그렇게 했던 것처럼)
서로의 서버에 수시로 접근해보는 것도 재밌을 것입니다.
  - ![스크린샷 2020-10-18 20 08 27](https://user-images.githubusercontent.com/35535636/96365748-b75f6a80-117d-11eb-9291-8308090d8ed1.png)

- 배포를 성공적으로 진행한 시점의 해당 Security Group의 Inbound rules를 캡처해 `/results`에 해당 스크린샷을 적절한 이름으로 포함시키세요. 집 IP 등을 노출하기 꺼려진다면 해당 부분을 가리시면 됩니다.
- 만약 자신의 local 환경에 있는 MySQL 데이터를 RDS의 database에 그대로 옮기고 싶다면, mysqldump에 관해 찾아보시기 바랍니다.

### 3
- Nginx, uWSGI를 이용해 `waffle-rookies-18.5-backend-2` Django 서버를 배포하세요.
- 가장 원시적인 방법 중 하나인, `git`을 이용해 해당 repository를 clone하고 변경 사항을 pull 해와서(`deploy` branch) 수동으로 배포하는 방식을 이용해 봅시다.
- 배포를 위해 생성하고 수정한 파일들도 확인할 수 있도록 EC2 instance 내에서도 `deploy` branch에서 진행하고, 진행 내용을 commit해 push하세요.
- Nginx와 uWSGI의 연결은 HTTP가 아닌 [unix socket](https://en.wikipedia.org/wiki/Unix_domain_socket) 방식을 이용하도록 하세요.
- 당연히 Python 가상환경을 이용해야 합니다. 또한 EC2 instance 내에서 파일 추가, 수정 등을 하기 위해서 [Vim](https://ko.wikipedia.org/wiki/Vim) 을 간단하게라도 이용할 줄 아는 것이 좋습니다.
- Nginx는 `/etc/nginx/nginx.conf`에 location block 등을 작성하여 동작시키지 말고, `/etc/nginx/sites-available/`과 `/etc/nginx/sites-enabled/` directory를 생성하고,
`/etc/nginx/sites-available/` 내에 conf 파일을 생성하여 symbolic link를 `/etc/nginx/sites-enabled/`에 포함시키는 방식으로 진행하세요.
이에 대해서는 React 배포에 대한 내용이긴 하지만 [이 글](https://medium.com/@bdv111/aws-ec2에서-nginx로-react-앱-직접-배포하기-c1e09639171e) 의 내용 4.에 더 자세히 설명되어 있습니다.
(~~Medium 계정을 만들고 follow와 clap하는 것을 권장~~)
- uWSGI를 위한 ini 파일과 `uwsgi_params`를 `manage.py`와 같은 위치에 생성하세요. `uwsgi_params`는 단순히 아래와 같은 내용을 가지면 됩니다.
    ```
    uwsgi_param  QUERY_STRING       $query_string;
    uwsgi_param  REQUEST_METHOD     $request_method;
    uwsgi_param  CONTENT_TYPE       $content_type;
    uwsgi_param  CONTENT_LENGTH     $content_length;
    
    uwsgi_param  REQUEST_URI        $request_uri;
    uwsgi_param  PATH_INFO          $document_uri;
    uwsgi_param  DOCUMENT_ROOT      $document_root;
    uwsgi_param  SERVER_PROTOCOL    $server_protocol;
    uwsgi_param  REQUEST_SCHEME     $scheme;
    uwsgi_param  HTTPS              $https if_not_empty;
    
    uwsgi_param  REMOTE_ADDR        $remote_addr;
    uwsgi_param  REMOTE_PORT        $remote_port;
    uwsgi_param  SERVER_PORT        $server_port;
    uwsgi_param  SERVER_NAME        $server_name;
    ```

- Nginx, uWSGI를 위해 추가해야 하는 파일들 외에도, 배포 환경에서는 `DATABASES`가 RDS에 연결되도록 하고 `DEBUG=False`가 되도록 설정하는 등 `settings.py`를 수정해야 함을 잊지 마세요.
- 1.에서 만들었던 caching 로직이 동작하기 위해서는 EC2 instance에도 Redis가 설치되어 Django 서버와 연결되어야 할 것입니다. 단순히 `redis-server` 등으로 실행해둘 수 없고, 백그라운드로 실행해두어야 함을 깨달아야 합니다. 실제 서비스에서는 AWS의 ElastiCache 등을 사용해 DB의 경우와 마찬가지로 원격 연결을 많이 합니다.
- EC2 instance의 메모리 한계를 경험하게 되는 경우가 있을 수 있는데, AWS console에서 해당 instance를 reboot하고 기다렸다가 다시 접근하면 일반적으로 해결됩니다.

- `/etc/nginx/sites-available/`의 conf 파일을 변경하면, `/etc/nginx/sites-enabled/`에 symbolic link로 생성되었던 것을 지우고 다시 symbolic link를 생성한 후, Nginx를 재시작해야하는 것을 잊지 마세요.(`/etc/nginx/sites-available/`의 동일 conf 파일을 단순히 수정하는 경우에는 link를 재생성할 필요가 없습니다.([#249 Issue](https://github.com/wafflestudio/rookies/issues/249) 참고))
- Django 서버 쪽이 수정되었을 경우에는 uWSGI 역시 재시작해야하는 것을 잊지 마세요.
- 변경에 따라 배포된 환경에 잘 반영되는지 쉽게 확인하기 위해서, `GET /` API를 생성하고 매우 간단한 응답을 주도록 만들어두는 것이 좋습니다.
[여기](https://github.com/davin111/waffle-rookies-18.5-backend-2/commit/00ba8c05d1a82e93be3f3b51fee98ec180763ee2) 를 참고하세요.

- 배포에 성공했다면, 웹 브라우저를 통해 해당 EC2 instance의 Public IPv4 address나 Public IPv4 DNS로 접근하여, DRF가 만들어주는 프론트 화면이 잘(예쁘지 않고 깨지는 것처럼 보이면 정상) 보이는지 확인하세요.
- 웹 브라우저의 DRF 프론트(static 배포가 완료되지 않은 상황에서 Raw data 탭을 통해 body를 만드는 경우 원하는 JSON 형태대로 request가 잘 전달되지 않을 수 있습니다. - [#288 Issue](https://github.com/wafflestudio/rookies/issues/288) 참고) 또는 Postman을 이용해, 배포한 서버(해당 주소를 이용하고 있음이 보여야 합니다)에 요청을 보내보세요.
최소한 Participant, Instructor 각각으로 회원 가입을 하고, Instructor가 세미나를 생성하고, Participant가 그것에 참여하는 과정이 포함되게 하여 캡처해 `/results`에 해당 스크린샷을 적절한 이름으로 포함시키세요.
- 또한 RDS의 database에 MySQL CLI, MySQL Workbench, DataGrip 등으로 local 환경에서 연결해 `show tables`한 결과, 그리고 User, Seminar에 대항하는 table들 등을 몇 개 조회한 스크린샷도 `/results`에 적절한 이름으로 포함시키세요.

- 직접 수정하고 생성한 `/etc/nginx/nginx.conf`와 `/etc/nginx/sites-available/`의 conf 파일을 복사해 `waffle-rookies-18.5-backend-2`(`deploy` branch)의 최상위에 `/deployment` directory를 생성하고
해당 파일들을 포함시키세요. 과제를 진행하며 최신 상황을 잊지 않고 반영하시기 바랍니다.

### 4
- [4번째 세미나](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4) 의 배포 성공 상황에서도 보았듯, 웹 브라우저에서 `/api/v1/user/` 등 존재하는 API endpoint로 접근하면
웹 프론트가 예쁘게 보이는 상황이 아닙니다. 이것은 세미나 보완 영상에서도 언급했듯, static file이 제대로 배포되지 못한 상황이기 때문에 그렇습니다. 이 문제를 해결해봅시다.
- 상황이 꼬이지 않도록 위의 내용을 모두 완료한 다음에 진행하시기를 강하게 권장드립니다.
- 배포 환경의 `settings.py`에서 [STATIC_URL](https://docs.djangoproject.com/en/3.1/ref/settings/#static-url) 이 정의된 곳 line 근처에 `STATIC_ROOT = os.path.join(BASE_DIR, 'static')`을 추가합시다.
- 배포 환경에서 `python manage.py collectstatic`를 실행하고, `manage.py`가 존재하는 위치에 `static` directory와 그 하위 파일들이 생성된 것을 확인하세요.
- 우리는 기존에 직접 생성한 static 파일이 없어서 와닿지 않을 수 있지만, DRF가 만들어주는 예쁜 웹 프론트는 내부적으로 `/static` 위치에 접근해 해당하는 CSS 파일 등에 접근하여 그것을 이용하는 것입니다.
- [4번째 세미나](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4) 에서 정적/동적인 것을 배포하는 것에 대해 이야기한 적이 있습니다.
지금까지 진행한 배포는 동적인 서버 배포에 대한 것이었고, 지금은 앞서 생성한 `static` directory에 정적으로 존재하는 파일들을 외부의 요청에 맞게 잘 제공해주어야 하는 상황입니다.

- `/etc/nginx/sites-available/`에 생성했던 conf 파일을 수정하여, `/static`에 해당하는 요청이 `static` directory의 파일들에 잘 도달하도록 해, 해당 내용을 정적으로 잘 제공해주도록 합시다.
- 기존의 배포를 진행하며 생성했을 `location /`으로 시작하는 block 외에 하나의 block을 추가하면 됩니다.

- 직접 수정하고 생성한 `/etc/nginx/nginx.conf`와 `/etc/nginx/sites-available/`의 conf 파일을 복사해 `waffle-rookies-18.5-backend-2`(`deploy` branch)의 최상위에 `/deployment` directory를 생성하고
해당 파일들을 포함시키고, commit과 push하세요. 과제를 진행하며 최신 상황을 잊지 않고 반영하시기 바랍니다.

### 5
- 서버 코드가 변경되면 git pull을 하고(배포를 위해 EC2 instance에서만 추가 및 변경하는 파일과 충돌이 있다면 이것과 잘 merge 시키는 등의 과정이 필요할 수도 있을 것이지만, 우리는 `deploy` branch에 EC2의
내용도 모두 commit해 push하면서 반영했으니 sync가 맞는 상황일 것입니다. 상황을 단순화하기 위해 EC2 instance의 repository가 항상 `deploy` branch에 있도록 하세요.),
필요에 따라 uWSGI, Nginx(사실 Nginx는 매번 재시작할 필요는 없겠지만) 등을 수동으로 재시작해야하는 상황이 번거로울 수 있습니다.
- 현재 배포는 원시적인 방법이지만 shell script를 잘 작성해두면 훨씬 편리하게 배포를 반복할 수 있습니다. 배포 과정을 더 잘 이해할 겸, 변경 사항이 있을 때마다 명령어 한 번만으로 원하는 배포 동작이 이뤄지도록 합시다.
`deploy.sh`라는 이름의 파일을 EC2 instance의 home(`/home/ec2-user`)에 생성해, shell script를 작성하세요. 크게 아래와 같은 동작들이 이루어져야 합니다.
  - `source ~/.bash_profile`
  - `waffle-rookies-18.5-backend-2`로 위치를 이동해 `git pull`하여 `deploy` branch에 변경 사항이 있으면 EC2 instance 내에서도 최신 상황 반영
  - `waffle-backend`로 위치를 이동해 Python 가상환경을 활성화시키고, `requirements.txt`의 모든 패키지 설치(최신 변경에서 패키지가 변경되었을 수 있으므로)
  - RDS의 database에 migration(최신 변경에서 migration 내용이 추가되었을 수 있으므로)
  - `python manage.py check --deploy` (deploy하기 적절한지 체크합니다.)
  - uWSGI를 ini 파일을 통해 재시작
  - Nginx 설정 파일 체크
  - Nginx를 재시작
- 자신의 local에서 `deploy` branch에 서버 코드를 살짝 변경하는 commit을 한 후, EC2 instance에 접속해 `bash deploy.sh`만 입력하고 위의 과정이 모두 자동으로 잘 이뤄지는지 확인해보세요.
  - 변경에 따라 배포된 환경에 잘 반영되는지 쉽게 확인하기 위해서, `GET /` API를 생성하고 매우 간단한 응답을 주도록 만들어두는 것이 좋습니다.
  [여기](https://github.com/davin111/waffle-rookies-18.5-backend-2/commit/00ba8c05d1a82e93be3f3b51fee98ec180763ee2) 를 참고하세요.

- `deploy.sh` 파일을 복사해 `waffle-rookies-18.5-backend-2/deployment` directory에 포함시키고, commit과 push하세요. 과제를 진행하며 최신 상황을 잊지 않고 반영하시기 바랍니다.

### 6
- 예쁘지 않고 외우기도 어려운 IP 주소나 EC2에서 자동으로 생성해주는 domain 말고, 직접 domain을 만들어 우리의 EC2 instance에 연결해봅시다.
- 기본적으로 [가비아(Gabia)](https://www.gabia.com)를 이용하는 것으로 하겠습니다. 계정이 없으면 가입해주세요. (만일 다른 서비스를 이용하시는 경우에는 HTTPS까지 이용할 수 있는 도메인을 가질 수 있다면 그렇게 하셔도 됩니다. 이 경우에는 README.md 등에 명시해주시기 바랍니다. Issues에서 공유해주셔도 좋을 것 같습니다.)
- [도메인을 IP 주소에 연결하는 방법과 nslookup](https://medium.com/@bdv111/도메인을-ip-주소에-연결하는-방법과-nslookup-9e70a32eec57) 을 참고해 가비아에서 원하는 도메인을 구입하세요. (~~Medium 계정을 만들고 follow와 clap하는 것을 권장~~)
  - `.shop` 등의 최상위 도메인은 일반적으로 처음 1년에 500원이라는 저렴한 가격입니다.(18.5기 Rookies recruiting 페이지, 기억나시나요?)
  과제 4 완료까지 세미나를 중도 포기하지 않은 분들에 한해, 와플스튜디오에서 인당 500원을 지원해 환급해드리도록 하겠습니다. 물론 이보다 비싼 다른 최상위 도메인을 추가 본인 부담으로 이용하시는 것은 자유입니다.
  `deploy` branch의 `README.md`에 환급받으실 계좌번호, 은행 이름, 계좌 소유주를 명시해주세요.

- 이 시점에서(아직 동작하지 않는 상황이라도), 생성한 도메인에 `http://`가 포함되도록 하여 [rookies](https://github.com/wafflestudio/rookies)
[assignment-servers.md](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4/assignment-servers.md) 자신의 `HTTP Domain`에 반영하도록 하여 Pull Requests에 추가로 적용하시길 바랍니다.

- 관련하여 `settings.py`의 `ALLOWED_HOSTS`에 도메인을 추가해주는 등의 수정이 필요할 수 있으며, Nginx conf 파일의 수정도 필요할 수 있습니다.

### 7 (자유 과제: 구매한 도메인으로 HTTPS 인증서 발급받아 적용하기)
- 단순한 IP 주소나 EC2에서 생성해주는 domain에는 HTTPS를 적용할 수 없습니다. 하지만 6.의 과정을 통해 이제 HTTPS 설정이 가능합니다.

- [Let's Encrypt](https://letsencrypt.org/ko/) 을 이용하여 구입한 도메인에 대해 HTTPS 인증서를 무료로 발급받도록 합시다.
EC2 instance 내에서 certbot을 이용하면 명령어만으로 모든 작업을 처리할 수 있어 편리합니다. (수동으로 관련 파일을 수정하는 등의 일은 해주어야 할 수 있습니다.)

- 이 시점에서(아직 동작하지 않는 상황이라도), 생성한 도메인에 `https://`가 포함되도록 하여 [rookies](https://github.com/wafflestudio/rookies)
[assignment-servers.md](https://github.com/wafflestudio/rookies/blob/master/backend/seminar4/assignment-servers.md) 자신의 `HTTPS Domain`에 반영하도록 하여 Pull Requests에 추가로 적용하시길 바랍니다.

- 관련하여 Nginx conf 파일의 수정이 필요합니다. 단순히 HTTPS가 지원되게 할 수도 있고, 더 똑똑하게 HTTP(80 port)로 오는 요청을 HTTPS(443 port)로 redirect 시킬 수 있습니다. 당연히 후자의 방식이 더욱 바람직합니다.

## 제출 방식 (반드시 지킬 것)
1. 과제 2를 통해 생성한 GitHub 개인 계정의 `waffle-rookies-18.5-backend-2` private repository에서 이어 작업합니다.

2. 과제 진행은 다음 절차를 따라주세요
  - **waffle-rookies-18.5-backend-2 의 `test`에서 `git checkout -b deploy` 로 이번 과제를 진행할 새로운 브랜치를 만들고 이동합니다.**
  - 해당 branch에서 작업을 완료해주세요. (**master, workspace, test branch에 push하면 안됩니다. deploy branch에만 변경사항을 반영해주세요.**)
  - 과제를 진행하면서 local 환경 및 EC2 환경 모두에서 deploy branch에 commit, push 해주시고 Pull Requests를 생성하시면 됩니다. (master <- deploy)
  - git이 어려운 경우 [OT자료](../../wafflestudio%2018.5%20rookies%20OT.pdf), https://backlog.com/git-tutorial/kr/stepup/stepup1_1.html 등을 참고해주세요.
  - repository 최상위에 `/results`, `/deployment` directory가 존재해야 합니다.

3. 마감 시점에 PR을 기준으로 collaborators로 지정된 세미나 운영진들이 확인할 것입니다. GitHub repository에 반영되도록 commit, push해두는 것을 잊지 마세요.

4. master, workspace, test branch의 상태는 반드시 본인 과제 3의 제출 시점과 동일해야합니다. 

## 참고하면 좋은 것들
- 관련 문서(추후 점진적으로 추가 예정입니다.)
    - 세미나 3, 세미나 4 슬라이드의 참고 링크들
    - 과제 내용의 본문에서 언급된 링크들
    - https://stackoverrun.com/ko/q/8703618
    - https://docs.djangoproject.com/en/3.1/howto/static-files/deployment/
    - https://nachwon.github.io/django-deploy-4-static/
    - https://lahuman.github.io/nginx_location_options/

- 앞으로도 늘 그렇겠지만, 과제를 진행하며 모르는 것들과 여러 난관에 부딪히리라 생각됩니다. 당연히 그 지점을 기대하고 과제를 드리는 것이고, 기본적으로 스스로 구글링을
통해 여러 내용을 확인하고 적절한 수준까지 익숙해지실 수 있도록 하면 좋겠습니다.
- [Issues](https://github.com/wafflestudio/rookies/issues) 에 질문하는 것을 어려워하지 마시길 바랍니다. 필요하다면 본인의 환경에 대한 정보를 잘 포함시켜주세요.
또한 Issue 제목에 과제 내용의 번호 등을 사용하시기보다, 궁금한 내용의 키워드가 포함되도록 해주세요. 답이 정해져있지 않은 설계에 대한 고민 공유도 좋습니다.
- 문제를 해결하기 위해 질문하는 경우라면, 질문을 통해 기대하는 바, (가급적 스크린샷 등을 포함한) 실제 문제 상황, 이를 해결하기 위해 시도해본 것, 예상해본 원인 등을 포함시켜 주시는 것이 자신과 질문을 답변하는 사람, 제3자 모두에게 좋습니다.
- 저는 직장을 다니고 있으므로 아주 빠른 답변은 어려울 수 있고, 특히 과제 마감 직전에 여러 질문이 올라오거나 하면 마감 전에 모든 답변을 드릴 수 있다는 것은
보장하기 어렵다는 점 이해해주시면 좋겠습니다. 그리고 세미나 진행자들이 아니어도, 참여자 분들 모두가 자신이 아는 선에서 서로 답변을 하고 도우시려고 하면 아주 좋을 것 같습니다.
- 과제의 핵심적인 스펙은 바뀌지 않을 것이며 설령 있다면 공지를 따로 드릴 것입니다. 하지만 문구나 오타 수정 등의 변경은 수시로 있을 수 있고,
특히 '참고하면 좋을 것들'에는 추가 자료들을 첨부할 수도 있습니다. 때문에 종종 이 repository를 pull 받아주시거나, 이 페이지를 GitHub에서 종종 다시 확인해주시기 바랍니다.
