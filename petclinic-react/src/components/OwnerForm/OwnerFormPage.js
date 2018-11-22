import React, { Component, Fragment } from "react";
// import {Redirect} from 'react-router'
import OwnerForm from "./OwnerForm";

export default class OwnerFormPage extends Component {
    render() {
        return (
            <Fragment>
                <OwnerForm {...this.props} />
            </Fragment>
        )
    }
}