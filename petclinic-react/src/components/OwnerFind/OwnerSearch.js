import React, { Fragment } from 'react';
import { Link } from "react-router-dom";


const OwnerSearch = ({ setOwners, noMatch }) => {
    return (
        <Fragment>
            {/* Todo: Remplacer le label par une combobox pour chaque champs */}
            <label>Last name:
                <input type="text" placeholder="Recherche de propriétaires" id="search" />
            </label>
            {noMatch && <p className="help-inline">has not been found</p>}
            <button onClick={setOwners}>Find Owner</button>
            <Link to='/owners/new'>Add new owner</Link>
        </Fragment>
    )
}

export default OwnerSearch


