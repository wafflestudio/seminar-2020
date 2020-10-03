# Wafflestudio Android Seminar Assignment #2
### due: 2020.10.17 23:59

## 과제의 목표
- Retrofit 을 활용해 외부 API 데이터를 받아오는 방법을 배운다,

## 과제 명세
- MovieDB Application을 Android Application 으로 구현한다
- 사용자는 `Discover Activity`에서 다양한 영화의 리스트 뷰를 볼 수 있다.
  - Discover Activity 의 각 아이템은 영화의 poster image 와 title 을 보여주어야 한다.
  - 2*n 격자 모양의 Recycler View 를 사용한다. ([GridLayoutManager](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/GridLayoutManager))
- 리스트의 아이템을 클릭 시 해당 영화에 관련된 자세한 정보를 보여주는 `Detail Activity` 로 전환한다.
  - Detail Activity 는 각 영화의 backdrop image 와 title, overview text 를 보여주어야 한다.
- 영화 정보들은 [TMdb API](https://www.themoviedb.org/?language=ko)의 [Discover Endpoint](https://developers.themoviedb.org/3/discover/movie-discover) 를 통해 Retrofit 으로 가져온다.
  - 이때 query string 은 기본적으로 `page=1&sort_by=popularity.desc` 을 사용해 인기도 순으로 20개의 영화 데이터를 가져와 보여준다.
  - `page` 의 경우 과제 추가 구현을 위해 1이 아닌 값을 사용해도 좋다.
- 뼈대 코드의 경우 이 레포지토리의 MovieDb 폴더에 제공된다.
- 과제의 채점은 pass / fail 로 구체적인 기준은 두지 않고, 앞서 언급된 Application의 명세를 만족하면 pass 이다.
  - 단, Retrofit 을 사용하여 HTTP 통신하는 완결성 있는 MVVM pattern의 앱을 구현해야 한다.

## 앱 데모
![Demo](demo.gif)
  
## Follow Up
> 이번 과제는 DI library 인 koin 을 사용합니다. 아직 세미나에서 다룬 내용이 아니기에 따로 koin 에 대해 공부할 필요는 없습니다.
> koin 과 관련된 코드는 모두 뼈대 코드에 구현되어 있습니다.(`di` 패키지)

> 뼈대 코드 사용 시 Discover Activity 에 자동으로 여러분이 구현한 Discover ViewModel 이 inject 되고,
> Discover ViewModel 에는 자동으로 여러분이 구현한 MovieRepository 가 inject 됩니다.
> 마찬가지로 MovieRepository 에는 구현한 MovieService 가 inject 됩니다.

> 따라서 어떻게 Repository 에 Service 를 가져오지? 나 Scope 를 어떻게 설정하지? (Scope 는 이번 과제서 중요하지 않지만) 등은 고민하지 않으셔도 됩니다.

> 이번 과제는 되도록이면 뼈대 코드를 사용하여 완료하기를 권장합니다

### #1 뼈대코드 가져오기 **(필수)**
- 이전 과제에서 만들었던 private repository(waffle-android-assign) 를 clone 받는다.
- **`git checkout -b moviedb` 로 이번 과제를 진행할 새로운 브랜치를 만들고 이동한다**
- 본 레포지토리 (rookies) 를 git clone 받는다.
- 본 레포지토리의 rookies/android/assignment3/MovieDb 파일을 복사하여 방금 만들었던 private repository 안에 옮긴다
  - 파일 구조는 아래와 같아야 한다
```
waffle-android-assign
└── TicTacToe
    ├── app
└── SimpleTodo
    ├── app
└── MovieDb
    ├── app
    .
    .
    .
```
- 이후 과제를 완료한 후 `git add .`, `git commit`, `git push origin moviedb` 를 통해 repository 의 **moviedb 브랜치** 에 업로드 한다.

### #2 TMdb api key 가져오기 **(필수)**
- 이번 과제에서는 영화 데이터를 [TMdb](https://www.themoviedb.org/?language=ko) 의 [API v3](https://developers.themoviedb.org/3) 으로부터 가져옵니다.
- 이 api 들을 사용하기 위해서는 TMdb 사이트에 로그인 후 api key 를 발급 받아야 합니다.
- TMdb 에 가입하신 후, user -> settings -> api -> new api key 에서 정보를 입력하고 api key를 발급 받습니다 (app url 같이 입력해야할게 많은데, 아무 정보나 입력해도 상관 없습니다.)
- 정보들을 입력해주시면 키 `API Key (v3 auth)` 가 발급됩니다. 
- 발급된 키를 `moviedb/app/build.gradle` 파일의 `your-api-key` 대신 입력합니다. (쌍 따옴표를 지우면 안 됩니다)
![screenshot](https://user-images.githubusercontent.com/37951125/94994440-8f470780-05d2-11eb-8596-014534850c06.png)
```
...
buildConfigField "String", "TMDB_API_KEY", '"your-api-key"'
...
```

### #3 API 문서 확인하기
- 이번 과제에서는 인기있는 영화 목록을 가져오는 api endpoint, 영화 id 에 따라 상세한 영화 정보를 가져오는 api endpoint (Optional), 총 두개의 endpoint 를 사용해야 합니다.
- 각 endpoint 는 [TMdb API 문서](https://developers.themoviedb.org/3) 에서 확인할 수 있습니다.
- 문서에서 우리가 원하는 endpoint 를 찾습니다. 위 두 개의 endpoint 는 각각 [Discover](https://developers.themoviedb.org/3/discover/movie-discover), [Movie](https://developers.themoviedb.org/3/movies/get-movie-details)(optional) 가 되겠군요.
- 이제 해당 api 에 어떻게 요청을 보내고, 어떤 응답이 돌아오는지 문서를 통해 함께 확인해 봅니다.
  - `GET` [/discover/movie](https://developers.themoviedb.org/3/discover/movie-discover)
    - request 
      - Query String 을 통해 어떤 조건으로 영화 목록을 가져올지 결정할 수 있습니다.
        - `api_key` 의 경우 좀 전에 얻은 key를 넣어주면 되겠군요.
        - `sort_by`, `page` 등의 쿼리를 잘 활용하면 최근의 인기 영화들을 받아올 수 있을 것 같습니다.
      ![스크린샷 2020-10-04 오전 12 53 10](https://user-images.githubusercontent.com/37951125/94995856-fb7a3900-05db-11eb-8ea4-71cced7aeef0.png)
    - response
      - page 를 통해 결과의 page 를, results 를 통해 영화 리스트를 받아올 수 있는 것 같습니다.
      ![스크린샷 2020-10-04 오전 12 53 21](https://user-images.githubusercontent.com/37951125/94995862-00d78380-05dc-11eb-8420-16205eb9df58.png)
    - example
      - tmdb api 문서의 Try it out 탭에서 직접 request 를 보내고 response 를 받아볼 수 있습니다.
      - api key 와 query 들을 잘 넣어주고 요청을 보내니 아래와 같은 결과를 응답하네요
      ![스크린샷 2020-10-04 오전 12 55 39](https://user-images.githubusercontent.com/37951125/94995908-5449d180-05dc-11eb-9dea-dcb40358d3ff.png)

### #4 Retrofit Model Class 만들기
- 이제 이렇게 받은 Response를 Android Retrofit 에서 Kotlin Object 로 변환되어 사용할 수 있게 Data Model class 를 만들어야 합니다.
- 응답 결과를 보니 각 영화들은 `popularity`, `title`, `id` 등으로 고정된 값들을 가지고 있네요, 이 값들이 매핑될 클래스를 만들어줍니다.
```kotlin
data class Movie(
    val id: Long,
    val title: String,
    val poster_path: String,
    // ....
)
```
- 실제 Response 의 경우 이런 Movie 의 List 가 들어오기 떄문에 아래와 같이 구성하면 될 것 같습니다.
```kotlin
data class DiscoverResponse (
    val page: Long,
    val total_results: Long,
    val results: List<Movie>
    // ...
)
```
- 이렇게 작성된 class 의 경우 [Gson](https://github.com/google/gson) converter 를 통해 class 의 field 와 response 의 json 값의 key에 따라 자동으로 json -> kotlin object conversion 이 일어납니다.
- response 에 명시된 모든 json key value 쌍을 class에 적지 않아도 괜찮습니다. 필요한 값들만 class 의 field 로 만들어도 잘 작동합니다.

### #5 Retrofit Service 만들기
- 응답 양식(json)에 따라 model class 의 작성을 완료했으니, 이제 실제 http 통신을 위한 retrofit service 를 만들어 봅시다.
- Discover endpoint 에서 요구하는 query string 중 우리는 인기 영화를 순서대로 받기 위해 `sort_by`, 특정 페이지를 요구하기 위해 `page` query 를 사용한 service 를 구성해 봅시다.
- `sort_by` 는 항상 고정이므로 url 에 같이, page 는 인자로 받아 다른, 다양한 페이지를 받을 수 있게 함수를 작성해 봅시다. (추가구현의 경우)
- 반환값은 RxJava 의 Single 을 통해 observer 패턴을 활용해봅시다. (강의 자료 참고)
```kotlin
interface MovieService {
    @GET("blabla")
    fun fetchDiscoverMovie(@Query("blabla") blabla: BlaBla): Single<DiscoverResponse>
    // ...
```

### #6 UI 와 바인딩, RecyclerView 와 연결, 마무리
- 이제 만들어진 Service 를 Repository 에서 가져다 사용하면 됩니다. (뼈대코드의 DI 모듈에서 알아서 `MovieRepository` 로 inject 됩니다.)
- url을 사용한 이미지 로딩의 경우 [Glide](https://github.com/bumptech/glide) 를 사용합니다. Glide 경우 BindingUtils 에 `setImageUrl` 으로 이미 구현해 놓았으므로 xml 에서 잘 연결해서 사용하시면 될 것 같습니다.
- DataBinding, RecyclerView 등 이전 세미나에서 배웠던 내용들이나 stackoverflow 등의 도움을 받으며 과제를 완성하세요.

### #7 추가 구현 (도전해보세요)
- Infinite scroll
  - Discover Activity 에서 현재는 20개의 영화만을 보여줍니다.
  - 스크롤이 끝에 닿으면 자동으로 추가로 20개의 영화를 로드해서 보여주도록 구현해봅시다. (이 경우 discover endpoint query 의 `page` 를 1이 아닌 2, 3, 4 ... 로 주면 다음 페이지의 값들이 로드 되겠죠?)
  - 참고자료
    - [RecyclerView.OnScrollListener](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.OnScrollListener)
    - [RecyclerView Infinite Scroll](https://acaroom.net/ko/blog/youngdeok/%EC%97%B0%EC%9E%AC-%EC%BD%94%ED%8B%80%EB%A6%B0-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-02-6%EB%8B%A8%EA%B3%84-infinite-scroll%EA%B3%BC-ui%EC%9D%98-%EA%B0%9C%EC%84%A0)
- Detail Activity 추가 구현
  - 과제 스펙의 detail activity 는 title, backdrop, overview 만 있어서 심심합니다.
  - tag 나 video 등등 response 에서 들어오는 다양한 값들을 활용해 detail activity 를 영화에 대한 더 자세한 정보를 담을 수 있도록 만들어보세요.

## 기타
- 이번 과제의 경우 skydoves 님의 [TheMovies](https://github.com/skydoves/TheMovies)를 참조하였습니다.

## **제출 방식**
- 자신의 waffle-android-assign 의 moviedb branch에 파일을 성공적으로 올렸다면 해당 브랜치(moviedb) 에서 master 브랜치로 pull request 를 날린다. 이때, assignee 에 `sanggggg` 를 꼭 기입한다.
