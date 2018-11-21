import React from 'react'

const OwnerInfo = ({ lastname, firstname, city, address, telephone }) => {
    return (
        <table className="table table-striped">
            <tbody>
                <tr>
                    <th>Name</th>
                    <td><b>{[lastname, firstname].join(' ')}</b></td>
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
    )
}

export default OwnerInfo