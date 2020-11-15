import React, { useState } from 'react';
import Counter from './Components/Counter';
import Form from './Components/Form';

function App() {
  const [counter, setCounter] = useState(false);
  return (
    <>
      {
        counter ?
        <Counter /> :
        <Form />
      }
      <button onClick={() => setCounter(!counter)}>전환하기</button>
    </>
  );
}

export default App;
