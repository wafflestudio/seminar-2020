import React, { createContext, useState, useContext } from "react";

/*
  context는 전역에서 사용가능한, 하나의 객체라고 생각하면 됩니다.
  이 파일을 제외한 외부 파일에서는 
  context값과, 이를 변경시킬 수 있는 changer 함수만을 제공받습니다.
  (아래에 정의하는 useListContext함수를 사용해서)
  피피티 중간에 있는 사진 참고하시면 될 것 같습니다
*/

/*
  1. Context(전역 state)의 default 값이 default 형식을 벗어나지 않아야 함
  2. addItem/onToggle 함수가 삭제된다거나 이 외의 함수가 추가된다거나 하지 않아야 함
  3. list 배열에 값이 추가될 수는 있어도, list 외의 다른 변수가 추가되지는 않아야 함

  정확히 말하면, 추가/삭제한다고 해서 에러가 발생하지는 않지만,
  context를 사용하는 데 있어 user가 지켜야하는 Rule
*/
const defaultList = {
  list: [
    {
      name: "김기완",
      seminar: "프론트엔드",
      on: false,
    },
    {
      name: "김상민",
      seminar: "안드로이드",
      on: false,
    },
    {
      name: "변다빈",
      seminar: "백엔드",
      on: false,
    },
  ],
  addItem: () => {},
  onToggle: () => {},
};

//Context 초기화
const ListContext = createContext(defaultList);

/*
  context.Provider를 래핑하여
  Context changer 함수들을 정의하여 제공
*/
const ListProvider = (props) => {
  const { children } = props;

  const addItem = ({ name, seminar }) => {
    setState((state) => {
      return {
        ...state,
        list: [...state.list, { name, seminar, on: false }],
      };
    });
  };

  const onToggle = (name) => {
    setState((state) => {
      return {
        ...state,
        list: state.list.map((item) => {
          return item.name === name ? { ...item, on: !item.on } : { ...item };
        }),
      };
    });
  };

  const listState = {
    ...defaultList,
    onToggle,
    addItem,
  };
  const [state, setState] = useState(listState);

  return (
    /*
      value: 값이 변하면 하위 컴포넌트에 반영
      children: 하위 컴포넌트
    */
    <ListContext.Provider value={state}>{children}</ListContext.Provider>
  );
};

/*
  다른 컴포넌트에서 listContext를 사용할 때,
  더욱 알아보기 쉽도록 하기 위해 제공하는 함수
  사용할 때마다
  useContext(ListContext) 보다
  useListContext() 라고 하는게
  다른 Context들과 헷갈릴 확률이 적음
  외부에서 useListContext()를 호출하면 아래가 리턴됨
  {
    list,
    onToggle,
    addItem
  }
  ListProvider 보시면, value에 state확인하실 수 있습니다.
*/
const useListContext = () => useContext(ListContext);

/*
  ListProvider는 최상위 컴포넌트를 감싸주어,
  하위 컴포넌트들에게 context를 사용할 수 있도록 함.
  useListContext는 하위 컴포넌트에서 context의 값을 불러올 수 있도록 함
*/
export { useListContext, ListProvider };
