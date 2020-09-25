# Wafflestudio Android Seminar Assignment #2
### due: 2020.9.26 23:59

## 과제의 목표
- Repository Pattern, Room database 를 실제 코드로 구현해본다.
- RecyclerView 를 통해 android 의 list item UI 를 코드로 구현해본다.

## 과제 명세
- Simple Todo Application을 Android Application 으로 구현한다
- 사용자는 floating button 을 클릭하여 title과 content 라는 두 문자열을 가진 새로운 TODO 를 추가할 수 있다. (CREATE)
- TODO list 는 RecyclerView를 통해 구현한 UI 에 나타나야 한다 (READ)
- 사용자가 뷰의 TODO item의 DONE 버튼을 누를 시 해당 TODO 아이템을 삭제한다. (DELETE)
- 위 TODO 데이터는 안드로이드 로컬 데이터베이스에 저장하여 앱을 끄고 다시켜도 남아있어야 한다. (Android Room 을 통해 구현 가능)
  - 기본적인 Table (Entity) 를 이미 뼈대코드에 구현해 놓았다 (`Todo.kt`)
- 뼈대 코드의 경우 이 레포지토리의 SimpleTodo 폴더에 제공된다.
- 뼈대 코드는 사용해도 좋고, 직접 a-z를 만들어 보아도 좋다.
- 과제의 채점은 pass / fail 로 구체적인 기준은 두지 않고, 앞서 언급된 Simple Todo Application의 명세를 만족하면 pass 이다.
  - 다만, Repository Pattern 과 Room Database 를 활용하여 완결성 있는 MVVM pattern의 앱을 작성해야 한다.
  - 위 사항은 뼈대 코드에서 이미 잘 작성되어 있다.

## 앱 데모
![Demo](demo.gif)
  
## 과제 진행 방법
#### 뼈대 코드 사용 시 (easy)
- 이전 과제에서 만들었던 private repository(waffle-android-assign) 를 clone 받는다.
- **`git checkout -b simpletodo` 로 이번 과제를 진행할 새로운 브랜치를 만들고 이동한다**
- 본 레포지토리 (rookies) 를 git clone 받는다.
- 본 레포지토리의 rookies/android/assignment1/SimpleTodo 파일을 복사하여 방금 만들었던 private repository 안에 옮긴다
  - 파일 구조는 아래와 같아야 한다
```
waffle-android-assign
└── TicTacToe
    ├── app
└── SimpleTodo
    ├── app
    .
    .
    .
```
- 이후 과제를 완료한 후 `git add .`, `git commit`, `git push origin simpletodo` 를 통해 repository 의 **simpletodo 브랜치** 에 업로드 한다.

> 뼈대 코드를 사용할 시, 코드에서 어떤 식으로 작성하면 되는가를 TODO 로 명시해 놓았습니다.
> 이 TODO 를 따라가시면서 코드를 작성하면 좋을 것 같습니다.

#### 뼈대 코드 미사용 시 (hard)
- 이전 과제에서 만들었던 private repository(waffle-android-assign) 를 clone 받는다.
- **`git checkout -b simpletodo` 로 이번 과제를 진행할 새로운 브랜치를 만들고 이동한다**
- Android Studio 를 통해 `waffle-android-assign` 폴더안에 SimpleTodo 라는 이름의 프로젝트를 만든다
- 이후 과제를 완료한 후 `git add .`, `git commit`, `git push origin simpletodo` 를 통해 repository 의 **simpletodo 브랜치** 에 업로드 한다.

> 뼈대 코드를 미사용할 시, google codelab 의 viewModel, DataBinding, LiveData, room database, Repository pattern 등과 뼈대 코드 SimpleTodo 를 참고하여 내가 직접 a-z 를 작성하게 됩니다.
> 뼈대 코드에 따라 작성하는 것 보다 더 많은 부분을 배울 수 있습니다. (뇌절도 많이 할 가능성이 높습니다.)
  
## 제출 방식
- 자신의 waffle-android-assign 의 simpletodo branch에 파일을 성공적으로 올렸다면 해당 브랜치(simpletodo) 에서 master 브랜치로 pull request 를 날린다. 이때, assignee 에 `sanggggg` 를 꼭 기입한다.
