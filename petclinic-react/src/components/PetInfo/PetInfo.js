import React from 'react'

const PetInfo = ({ name, birthdate, type }) => {
    return (
        <tr>
            <td>
                <dl>
                    <dt>Name</dt>
                    <dd>{name}</dd>
                    <dt>Birthday</dt>
                    <dd>{birthdate}</dd>
                    <dt>Type</dt>
                    <dd>{type}</dd>
                </dl>
            </td>
        </tr>
    )
}
export default PetInfo

