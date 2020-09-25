import React, { useState } from 'react';

const Form = () => {
  const [text, setText] = useState("");

  const onChange = (event) => {
    setText(event.target.value);
  }
  
  const onReset = () => {
    setText("")
  }

  return (
    <div>
      <input onChange={onChange} value={text} />
      <p>값 : {text}</p>
      <button onClick={onReset}>초기화</button>
    </div>
  )

}

export default Form;