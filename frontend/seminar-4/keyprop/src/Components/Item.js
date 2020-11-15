import React from 'react'

const Item = ({ id, createdAt }) => {
  return (
    <tr>
    <td>
      <label>{id}</label>
    </td>
    <td>
      <input />
    </td>
    <td>
      <label>{createdAt.toTimeString()}</label>
    </td>
  </tr>
  )
}

export default Item