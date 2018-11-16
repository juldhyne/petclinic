import React from 'react'

const Owner = ({lastname,firstname,city, address, telephone, pets}) => {
  return (
      <tr>
        <td>{lastname + ' ' + firstname}</td>
        <td>{city + ' ' + address}</td>
        <td>{telephone}</td>
        <td>{pets}</td>
      </tr>
  )
}

export default Owner