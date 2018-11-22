import React, { Component, Fragment } from "react";
import OwnerEdit from "./OwnerEdit";

export default class OwnerEditPage extends Component {
    render() {
        return (
            <Fragment>
                <OwnerEdit {...this.props} />
            </Fragment>
        )
    }
}