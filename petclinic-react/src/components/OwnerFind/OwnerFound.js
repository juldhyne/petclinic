import React from 'react'
import { Redirect } from 'react-router-dom'
import Owner from './Owner';

const OwnerFound = ({ owners }) => {
    // Auto-redirect si il n'y a qu'une seule correspondance et la liste dans l'historique (à voir avec un tableau "persistant")
    if (owners.length === 1) return <Redirect to={`/owners/${owners[0].id}`} push={true} />

    // convertit un tableau en objet Owner
    const componentize = array => array.map(item => <Owner key={item.id} {...item} />)

    return (
        <table className="table table-striped table-fill">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Phone</th>
                    <th>Pets</th>
                </tr>
            </thead>
            <tbody>
                {componentize(owners)}
            </tbody>
        </table>
    )
}

export default OwnerFound