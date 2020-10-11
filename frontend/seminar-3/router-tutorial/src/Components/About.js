import React, { useEffect } from 'react';
import { useParams, useHistory } from 'react-router-dom'
import qs from 'qs'

const data = [
  {
    id: 1,
    seminar: 'frontend',
  },
  {
    id: 2,
    seminar: 'backend',
  },
  {
    id: 3,
    seminar: 'android',
  }
]


const About = () => {
  const history = useHistory();
  /*
    URL 파라미터 사용
    const params = useParams();
  */
  /*
    쿼리 사용
    const params = qs.parse(window.location.search, { ignoreQueryPrefix: true})
  */ 

  useEffect(() => {
    const unblock = history.block('정말 나가시겠습니까?');
    return () => {
      unblock()
    }
  }, [])

  
  return (
    <>
     <p>소개페이지</p>
     <button onClick={() => history.goBack()}>뒤로가기</button>
     <button onClick={() => history.push('/temp')}>다른 페이지로 이동하기</button>
     <button onClick={() => history.replace('/temp')}>다른 페이지로 이동하기(replace)</button>
    </>
  )
}

export default About