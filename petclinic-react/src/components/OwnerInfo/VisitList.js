import React from 'react'
import { Link } from "react-router-dom";
import Visit from "./Visit";

const componentize = array => array.map(item => <Visit key={item.id} {...item} />)

const VisitList = ({ visits, pid, oid }) => {
    return (
        <td valign="top">
            <table className="no_css" >
                <thead><tr className="no_css">
                    <th className="no_css">Visit Date</th>
                    <th className="no_css">Description</th>
                </tr></thead>
                <tbody>
                    {componentize(visits)}
                    <tr className="no_css">
                        <td className="no_css">
                            <Link to={`/owners/${oid}/pets/${pid}/edit`}>Edit Pet</Link>
                        </td>
                        <td className="no_css">
                            <Link to={`/owners/${oid}/pets/${pid}/visits/new`}>Add Visit</Link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </td>
    )
}

export default VisitList