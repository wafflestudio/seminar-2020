import React, { useState } from 'react';
import List from './List';
import { useListContext } from '../Context/List';

const defaultInput = {
  name: '',
  seminar: ''
}

const Main = () => {
  const [input, setInput] = useState(defaultInput)
  /*
    Item을 추가하기 위해서 addItem 함수만 불러오면 됨
  */
  const { addItem } = useListContext();

  const onChangeInput = (event) => {
    const { name, value } = event.target

    setInput({
      ...input,
      [name]: value
    })
  }


  const { name, seminar } = input
  return (
    <>
      <input onChange={onChangeInput} value={name} name="name"  placeholder="이름" />
      <input onChange={onChangeInput} value={seminar} name="seminar"  placeholder="세미나" />
      <button onClick={() => addItem({ name, seminar })}>추가하기</button>
      <hr />
      <List/>
    </>

  )
}

export default Main