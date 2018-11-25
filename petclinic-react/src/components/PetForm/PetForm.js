import React, { Fragment } from "react";
import { Redirect } from 'react-router'

const PetForm = ({ handleSubmit, handleChange, pet: { id, name, birthdate, type }, owner: { lastname, firstname }, redirect }) => {
    if (redirect) return <Redirect to='/error' />
    return (
        <Fragment>
            <form onSubmit={handleSubmit} method='POST'>
                <label>
                    Owner:
                        <span> {`${lastname} ${firstname}`} </span>
                </label>
                <label htmlFor='name'>
                    Name:
          <input type="text" value={name} onChange={handleChange} id="name" name="name" />
                </label>
                <label htmlFor='birthdate'>
                    Birthdate:
          <input type="text" value={birthdate} onChange={handleChange} id="birthdate" name="birthdate" />
                </label>
                <label htmlFor='type'>
                    type:
                    {/* Todo: Combobox */}
                    <input type="text" value={type} onChange={handleChange} id="type" name="type" />
                </label>
                <input type="submit" value={`${id ? 'Update' : 'Add'} Pet`} />
            </form>
        </Fragment>
    )
}

export default PetForm