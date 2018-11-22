import React, { Component, Fragment } from "react";
// import {Redirect} from 'react-router'
import PetForm from "./PetForm";

export default class OwnerFormPage extends Component {
    render() {
        return (
            <Fragment>
                <PetForm {...this.props} />
            </Fragment>
        )
    }
}