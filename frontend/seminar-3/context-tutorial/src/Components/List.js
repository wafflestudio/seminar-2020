import React from 'react'
import { useListContext } from '../Context/List'
import Item from './Item'

const List = () => {
  /*
    List 컴포넌트에서는 List만 있으면 됩니다.
  */
  const { list } = useListContext();

  return (
    <ul>
      {
        list.map(item => {
          return <li key={item.name}>
            <Item item={item}/>
          </li>
        })
      }
    </ul>
  )
}

export default List