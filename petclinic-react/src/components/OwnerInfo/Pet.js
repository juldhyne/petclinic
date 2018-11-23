import React, { Fragment } from 'react'

const Pet = ({ name, birthdate, type }) => {

    return (
        <Fragment>
            <td valign="top"><dl className="dl-horizontal">
                <dt>Name</dt>
                <dd>{name}</dd>
                <dt>Birth Date</dt>
                <dd>{birthdate}</dd>
                <dt>Type</dt>
                <dd>{type}</dd>
            </dl></td>
        </Fragment >
    )
}

export default Pet;