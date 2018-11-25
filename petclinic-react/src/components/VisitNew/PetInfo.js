import React, { Fragment } from 'react'

const PetInfo = ({ name, birthdate, type, owner: { lastname, firstname } }) => {
    return (
        <Fragment>
            <b>Pet</b>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Birth Date</th>
                        <th>Type</th>
                        <th>Owner</th>
                    </tr>
                </thead>
                <tbody><tr>
                    <td>{name}</td>
                    <td>{birthdate}</td>
                    <td>{type}</td>
                    <td>{`${lastname} ${firstname}`}</td>
                </tr>
                </tbody></table>
        </Fragment >
    )
}

export default PetInfo;