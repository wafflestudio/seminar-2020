import React from 'react'
import { useListContext } from '../Context/List'

const Item = ({ item }) => {
  /*
    item은 List 컴포넌트에서 받고,
    이 컴포넌트에서는 버튼을 누르면,
    list 내부의 값을 수정해야하므로
    onToggle만 가져옴
  */
  const { onToggle } = useListContext();
  const { name, seminar, on } = item;
  return (
    <div
      style ={
        on ?
         { background: 'grey'} :
         {}
      }>
        <span>{`${name}   `}</span>
        <span>{`${seminar}    `}</span>
        <button onClick={() => onToggle(name)}>toggle</button>
    </div>
  )
}

export default Item