import React, { Fragment } from 'react'

const VisitInfo = ({ description, date }) => {
    return (
        <Fragment>
            <tr>
                <td>{date}</td>
                <td>{description}</td>
            </tr>
        </Fragment>
    )
}

export default VisitInfo