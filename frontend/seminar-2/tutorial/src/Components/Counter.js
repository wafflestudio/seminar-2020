import React, { useState, useEffect } from 'react';

const Counter = () => {
  const [num, setNum] = useState(0);

  const clickPlus = () => {
    setNum(num + 1);
  }

  useEffect(() => {
    console.log('컴포넌트가 마운트 되었습니다.');

    return () => {
      console.log('컴포넌트가 언마운트 되었습니다.');
    }
  }, []);

  useEffect(() => {
    console.log('변경 후 값: ', num);

    return () => {
      console.log('변경 전 값', num);
    }

  }, [num]);

  return (
    <div>
      <p>{num}</p>
      <button onClick={clickPlus}>+</button>
    </div>
  )

}

export default Counter;