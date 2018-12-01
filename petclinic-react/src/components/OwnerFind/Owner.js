import React from 'react'
import { Link } from 'react-router-dom';

const Owner = ({ id, lastname, firstname, city, address, telephone, pets_names }) => {
  return (
    <tr>
      <td><Link to={`/owners/${id}`} >{`${lastname} ${firstname}`}</Link></td>
      <td>{address}</td>
      <td>{city}</td>
      <td>{telephone}</td>
      <td>{pets_names && pets_names.join(' ')}</td>
    </tr>
  )
}

export default Owner