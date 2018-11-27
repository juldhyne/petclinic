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
        const { ownerId: oid } = this.props.match.params
        const response = await fetch(url, {
            headers:
            {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8',
            },  
            method: `${oid ? "PUT" : "POST"}`,
            mode: "cors",
            body: JSON.stringify(data)
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

        const { ownerId: oid } = this.props.match.params

        const url = `http://localhost:9999/api/v1/owners/${oid ? oid : ""}`

        // do some validation
        this.postData(url,this.state.owner)
        console.log(url);
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