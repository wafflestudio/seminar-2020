import React from 'react';
import { Link, Route, Switch } from 'react-router-dom'
import About from './Components/About'
import Temp from './Components/Temp'

function App() {
  return (
    <>
      <ul>
        <li>
          <Link to="/">홈으로</Link>
        </li>
        <li>
          <Link to ="/about">소개페이지로</Link>
          {/* 
            URL 파라미터
            <Link to ="/about:id">소개페이지로</Link> 
          */}
        </li>
      </ul>
      <hr />
      <Switch>
        <Route path="/" component={Home} exact/>
        <Route path="/about" component={About} />
        <Route path="/temp" component={Temp} />
        <Route path="" render={() => {
          return <p>없는 페이지입니다.</p>
          }}
        />
      </Switch>
    </>
  );
}

const Home = () => {
  return <p>홈입니다.</p>
}


export default App;
