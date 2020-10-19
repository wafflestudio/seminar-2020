import React, { useState, useRef } from "react";
import Item from "./Item";

const defaultList = [
  {
    id: 1,
    createdAt: new Date(),
  },
];

const IndexTable = () => {
  const [list, setList] = useState(defaultList);
  const ref = useRef(2);

  const addToStart = () => {
    const id = ref.current;
    ref.current += 1;
    setList([{ id, createdAt: new Date() }, ...list]);
  };

  const addToEnd = () => {
    const id = ref.current;
    ref.current += 1;
    setList([...list, { id, createdAt: new Date() }]);
  };

  const sortByEarliest = () => {
    const newList = list.sort((a, b) => {
      return a.createdAt > b.createdAt ? 1 : -1;
    });

    setList([...newList]);
  };

  const sortByLatest = () => {
    const newList = list.sort((a, b) => {
      return b.createdAt > a.createdAt ? 1 : -1;
    });

    setList([...newList]);
  };

  return (
    <div>
      <h1>KEY = INDEX</h1>
      <button onClick={addToStart}>Add New to Start</button>
      <button onClick={addToEnd}>Add New to End</button>
      <button onClick={sortByEarliest}>Sort by Earliest</button>
      <button onClick={sortByLatest}>Sort by Latest</button>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th />
            <th>created at</th>
          </tr>
        </thead>
        <tbody>
          <IndexList list={list} />
        </tbody>
      </table>
    </div>
  );
};

const IndexList = ({ list }) => {
  return (
    <>
      {
        list.map((item, index) => 
          <Item key={index} {...item} />
        )
      }
    </>
  );
};

export default IndexTable;
