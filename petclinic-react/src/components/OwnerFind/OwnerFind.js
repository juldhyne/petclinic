import React from 'react'

const Owner = ({lastname,firstname,city, address, telephone}) => {
  return (
      <tr>
        <td>{lastname + ' ' + firstname}</td>
        <td>{city + ' ' + address}</td>
        <td>{telephone}</td>
      </tr>
  )
}

export default Owner