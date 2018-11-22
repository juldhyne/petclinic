import React, { Fragment } from 'react'

const VisitPrevious = ({ visits }) => {
    return (
        <Fragment>
            <b>Previous Visits</b>
            <table className="table table-striped">
                <tbody><tr>
                    <th>Date</th>
                    <th>Description</th>
                </tr>
                    {visits}
                </tbody>
            </table>
        </Fragment>
    )
}

export default VisitPrevious