Waffle Studio Frontend Assignment - 2
================================

### **due: 2020.09.27(일) 23:59**

## 과제 목적
- Javascript를 사용해서 사이트를 동적으로 구현한다.
- React의 기본적인 사용법 및 배열을 렌더링하는 방법을 숙지한다.

## 과제 - 리스트 기능 사이트 만들기(주제자유)
- **리액트를 사용**하여 아래의 사진과 같이 **리스트 기능**이 있는 사이트를 만드시면 됩니다.
  - 리스트에 항목을 **추가하는 기능**이 있어야 합니다.
  - 각 항목마다 **3개 이상의 내용**을 보여줘야 합니다. 당연히 **추가할때도** 3개 이상의 내용이 있어야겠죠
  - 각 항목에 **'좋아요' 기능**이 있어야 합니다.
  - 리스트 중 **좋아하는 항목의 개수**를 보여줘야 합니다.

- 리액트를 사용하여 구현을 완료한 후에, **HTML과 Javascript만을** 이용하여, 동일한 사이트를 만드시면 됩니다.

![image](https://im.ezgif.com/tmp/ezgif-1-22d9b960d4e8.gif)


## 주의사항
1. 위의 gif처럼 **추가하기**는 부분은 버튼을 클릭하면 나타나고, 추가를 하면 자동으로 사라져야 합니다. 사진처럼 모달로 구현해도 괜찮고, 어느 방식이든 사라져있던게 보이기만 하면 됩니다.
2. 초기 데이터가 **최소한 3개**는 있어야 합니다.  
3. App.js를 제외한 **2개 이상의 Component**를 만들어 주세요.
4. 디자인은 신경쓰지 않을 것 입니다. ~~그래도 예쁘면 좋아요~~ 
5.  **커밋은 되도록이면 최대한 잘게 쪼개서 해주세요.** 커밋 내용을 지켜보고, 전체적인 진행 상황에 따라 과제 due나 명세를 수정할 수 있습니다. 커밋 메시지도 상세할수록 좋습니다.


## 제출 방식
1. 자신의 GitHub 개인 계정에 `waffle-rookies-18.5-frontend-2`라는 이름으로 private repository를 개설합니다.

2. 개설 후 Settings > Manage access 로 들어갑니다.

![스크린샷 2020-08-30 02 13 52](https://user-images.githubusercontent.com/35535636/91642567-5eb9fe00-ea67-11ea-9382-89fcce03be70.png)

3. collaborator로, 세미나 운영진들을 초대합니다.

![스크린샷 2020-08-30 02 14 59](https://user-images.githubusercontent.com/35535636/91642588-87da8e80-ea67-11ea-9d5a-60a3596463c9.png)

- [@davin111](https://github.com/davin111)
- [@sanggggg](https://github.com/sanggggg)
- [@dkwanm1](https://github.com/dkwanm1)
- [@Hank-Choi](https://github.com/Hank-Choi)
- [@veldic](https://github.com/veldic)

![스크린샷 2020-08-30 02 16 17](https://user-images.githubusercontent.com/35535636/91642619-cbcd9380-ea67-11ea-84ea-1a0729103755.png)

4. 리액트로 구현할 때는 `version-react` 브랜치를,
   HTML/JS로 구현할 때는 `version-js` 브랜치를 생성하고 해당 브랜치에서 작업해주세요. 각각의 브랜치에서 커밋하고, push를 브랜치에 따라 아래와 같이 하면 됩니다.
   ``` git
   git push origin version-react
   git push origin version-js
   ```
   **단, `create-react-app`은 `master`브랜치에서 실행해주세요.**



5. 세미나 신청하셨을 때와 마찬가지로 브랜치마다 풀 리퀘를 작성하시면 됩니다.
   ```
    base: master <- compare: version-react
    base: master <- compare: version-js
   ```
   ![image](https://user-images.githubusercontent.com/48665265/93014268-ae153800-f5ea-11ea-82aa-59f4efcf40b7.png)

   ![image](https://user-images.githubusercontent.com/48665265/93014281-d00eba80-f5ea-11ea-8f17-da028bd1ad60.png)


6. 풀리퀘를 생성하신 후에 commit을 해도 자동으로 풀리퀘에 반영 되므로, 가급적 일찍 생성해주시면 좋겠습니다. 각 브랜치마다 마감 시점의 최종 commit을 확인할 것입니다. 

7. 가급적 repository 생성과 collaborator 지정은 미리 해둬주세요! 제출 방식을 다들 올바로 이해하고 계신지와 함께, 가능하다면 대략적인 진행상황을 보면서 필요하면 몇 가지 말씀을 더 드릴 수도 있습니다.

**두 개의 브랜치 모두 `master`브랜치를 기준으로 생성해 주세요.**   
**지금까지의 과제와 달리 `master` 브랜치를 확인하는 것이 아닌 생성된 각 풀리퀘를 확인할 것입니다. `merge`는 하지 말아주세요**    
**혹시 브랜치 생성 및 풀리퀘 생성에 문제가 있으면 꼭 질문해주시기 바랍니다**

## 참고하면 좋은 것들
- [JS 문법](https://learnjs.vlpt.us/)

