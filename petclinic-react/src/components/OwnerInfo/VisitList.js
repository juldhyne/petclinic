import React from 'react'
import { Link } from "react-router-dom";
import Visit from "./Visit";

const componentize = array => array.map(item => <Visit key={item.id} {...item} />)

const VisitList = ({ visits, oid }) => {
    const { petId: pid } = visits
    return (
        <td valign="top">
            <table className="table-condensed table-fill" >
                <thead><tr>
                    <th>Visit Date</th>
                    <th>Description</th>
                </tr></thead>
                <tbody>
                    {componentize(visits)}
                    <tr>
                        <td>
                            <Link to={`/owners/${oid}/pets/${pid}/edit`}>Edit Pet</Link>
                        </td>
                        <td>
                            <Link to={`/owners/${oid}/pets/${pid}/visits/new`}>Add Visit</Link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </td>
    )
}

export default VisitList