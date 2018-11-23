import React, { Fragment } from 'react'
import { Link } from 'react-router-dom'

const Owner = ({ id, lastname, firstname, city, address, telephone }) => {
    return (
        <Fragment>
            <h2>Owner Information</h2>
            <table className="table table-striped">
                <tbody>
                    <tr>
                        <th>Name</th>
                        <td><b>{`${lastname} ${firstname}`}</b></td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>{address}</td>
                    </tr>
                    <tr>
                        <th>City</th>
                        <td>{city}</td>
                    </tr>
                    <tr>
                        <th>Telephone</th>
                        <td>{telephone}</td>
                    </tr>
                </tbody>
            </table>
            <Link to={`/owners/${id}/edit`}>Edit Onwer</Link>
            <Link to={`/owners/${id}/pets/new`}>Add New Pet</Link>
        </Fragment>
    )
}

export default Owner