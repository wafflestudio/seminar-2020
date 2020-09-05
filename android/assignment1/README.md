# Wafflestudio Android Seminar Assignment1
### due: 2020.9.12 23:59

## 과제의 목표
- ViewModel + Databinding + LiveData 를 실제 코드를 작성하며 이해한다

## 과제 상세
- [TicTacToe](https://ko.wikipedia.org/wiki/%ED%8B%B1%ED%83%9D%ED%86%A0) 게임을 Android Application 으로 구현한다
- 사용자는 게임을 번갈아가며 진행하며 승리조건에 맞게 `PLAYING...`, `PLAYER X WIN!`, `PLAYER O WIN!`, `DRAW!` 등의 메세지를 구현하는 게임을 만들면 된다.
- 뼈대 코드의 경우 이 레포지토리의 TicTacToe 폴더에 제공된다.
- 뼈대 코드는 사용해도 좋고, 직접 a-z를 만들어 보아도 좋다.
- 과제의 채점은 pass / fail 로 구체적인 기준은 두지 않고, 앞서 언급된 TicTacToe 게임의 규칙을 준수하는 앱을 만들면 된다.
  - 다만, 게임보드(cell) 게임 진행 상황 메세지 등은 viewModel 에 LiveData로 담아두고, 이를 databinding 으로 가져오는 형식으로 코드를 짜도록 한다.
  - 위 사항은 뼈대 코드에서 이미 잘 작성되어 있다.

## 앱 데모
![Demo](demo.gif)
  
## 과제 진행 방법
#### 뼈대 코드 사용 시 (easy)
- 본인의 github 에 새로운 private repository를 생성한다. (이름은 waffle-android-assign 으로)
- 만들었던 private repository 를 clone 받는다.
- 본 레포지토리 (rookies) 를 git clone 받는다.
- 본 레포지토리의 rookies/android/assignment1/TicTacToe 파일을 복사하여 방금 만들었던 private repository 안에 옮긴다
  - 파일 구조는 아래와 같아야 한다
```
waffle-android-assign
└── TicTacToe
    ├── app
    .
    .
    .
```
- 이후 과제를 완료한 후 `git add .`, `git commit`, `git push` 를 통해 github 에 업로드 한다.
#### 뼈대 코드 미사용 시 (hard)
- 본인의 github 에 새로운 private repository를 생성한다. (이름은 waffle-android-assign 으로)
- 만들었던 private repository 를 clone 받는다.
- Android Studio 를 통해 `waffle-android-assign` 폴더안에 TicTacToe 라는 이름의 프로젝트를 만든다
- 이후 과제를 완료한 후 `git add .`, `git commit`, `git push` 를 통해 github 에 업로드 한다.
  
## 제출 방식
- 완성된 과제가 있는 Private Repository(waffle-android-assign)에서 [Backend assign](https://github.com/wafflestudio/rookies/blob/master/backend/seminar0/assignment.md)의 **제출 방식** 을 참고하여 collaborator 로 세미나 운영진들을 초대한다.
