import React, { Fragment } from "react";
import { Redirect } from 'react-router'


const OwnerForm = ({ handleSubmit, handleChange, owner: { id, firstname, lastname, address, city, telephone }, redirect }) => {
    if (redirect) return <Redirect to='/error' />

    return (
        <Fragment>
            <form onSubmit={handleSubmit} method='POST'>
                <label htmlFor='firstname'>
                    First Name:
          <input type="text" value={firstname} onChange={handleChange} id="firstname" />
                </label>
                <label htmlFor='lastname'>
                    Last Name:
          <input type="text" value={lastname} onChange={handleChange} id="lastname" />
                </label>
                <label htmlFor='address'>
                    Address:
          <input type="text" value={address} onChange={handleChange} id="address" />
                </label>
                <label htmlFor='city'>
                    City:
          <input type="text" value={city} onChange={handleChange} id="city" />
                </label>
                <label htmlFor='telephone'>
                    Telephone:
          <input type="text" value={telephone} onChange={handleChange} id="telephone" />
                </label>
                <input type="submit" value={`${id ? 'Update' : 'Add'} Owner`} />
            </form>
        </Fragment>
    )
}


export default OwnerForm