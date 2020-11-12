import React from 'react'
import Main from './Components/Main'
import { ListProvider } from './Context/List';

function App() {
  return (
    /*
      ListProvider로 Main을 감싸서,
      하위 컴포넌트에서 List 사용가능하도록 함
    */
    <ListProvider>
      <Main />
    </ListProvider>
  );
}

export default App;
