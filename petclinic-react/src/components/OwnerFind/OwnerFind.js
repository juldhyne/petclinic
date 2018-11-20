import React from 'react'

const Owner = ({id, lastname, firstname, city, address, telephone, petsNames}) => {
  return (
      <tr>
        <td><a href={id}>{lastname + ' ' + firstname}</a></td>
        <td>{city + ' ' + address}</td>
        <td>{telephone}</td>
        <td>{petsNames && petsNames.join(' ')}</td>
      </tr>
  )
}

export default Owner