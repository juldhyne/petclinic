import React, { Component, Fragment } from "react";
import OwnerForm from "./OwnerForm";

export default class OwnerFormPage extends Component {
    state = {
        owner: {
            firstname: "",
            lastname: "",
            address: "",
            city: "",
            telephone: ""
        },
    }


    postData = async (url = '', data = {}) => {
        const encode = (obj) => Object.entries(obj).reduce((acc, [key, val]) => {
            acc.append(key, val)
            return acc
        }, new URLSearchParams())
        const body = encode(data)
        const response = await fetch(url, {
            method: "POST",
            mode: "cors",
            body: body
        })
        const json = await response.json()
        return json
    }

    getData = async (oid) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners/${oid}`)
        if (response.ok) this.setState({ owner: await response.json() })
        else this.setState({ redirect: true })
    }

    handleChange = ({ target }) => {
        this.setState({ owner: { ...this.state.owner, [target.name]: target.value } });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // const url = 'http://localhost:9999/api/v1/owners/${oid}'
        // do some validation
        // postData(url,this.state)
    }

    componentDidMount() {
        const { ownerId: oid } = this.props.match.params
        oid && this.getData(oid)
    }

    render() {
        return (
            <Fragment>
                <h2>Owner</h2>
                <OwnerForm {...this.state} handleChange={this.handleChange} handleSubmit={this.handleSubmit} />
            </Fragment>
        )
    }
}