import React from 'react'
import { Link } from 'react-router-dom';

const Owner = ({ id, lastname, firstname, city, address, telephone, petsNames }) => {
  return (
    <tr>
      <td><Link to={`/owners/${id}`} >{`${lastname} ${firstname}`}</Link></td>
      <td>{address}</td>
      <td>{city}</td>
      <td>{telephone}</td>
      <td>{petsNames && petsNames.join(' ')}</td>
    </tr>
  )
}

export default Owner