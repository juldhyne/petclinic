import React, { Fragment } from 'react'
import PetItemList from './PetItemList';


const componentize = array => array.map(item => <PetItemList key={item.id} {...item} />)

const PetList = ({ pets }) => {
    return (
        <Fragment>
            <h2>Pets and Visits</h2>
            <table className="table table-striped table-fill">
                <tbody>
                    {componentize(pets)}
                </tbody>
            </table>
        </Fragment >
    )
}

export default PetList;