import React, { createContext, useContext } from 'react';

const MyContext = createContext("초기값");

const GrandChild = () => {
  const text = useContext(MyContext);
  return <p>{text}</p>
}

const Child = () => {
  return <GrandChild ></GrandChild>
}

const ContextExample = () => {
  return (
    <MyContext.Provider value="1254">
      <Child ></Child>
    </MyContext.Provider>
  )
  
} 

export default ContextExample