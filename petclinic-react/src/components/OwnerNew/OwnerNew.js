import React, { Component, Fragment } from "react";

export default class OwnerNew extends Component {
    state = {
        firstname: "",
        lastname: "",
        address: "",
        city: "",
        telephone: ""
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

    handleChange = ({ target }) => {
        this.setState({ [target.name]: target.value });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // const url = 'localhost:9999/owners/new'
        // do some validation
        // postData(url,this.state)
    }

    componentDidMount() {
    }

    render() {
        return (
            <Fragment>
                <h2>Owner</h2>
                <form onSubmit={this.handleSubmit} method='POST'>
                    <label>
                        First Name:
          <input type="text" value={this.state.firstname} onChange={this.handleChange} name="firstname" />
                    </label>
                    <label>
                        Last Name:
          <input type="text" value={this.state.lastname} onChange={this.handleChange} name="lastname" />
                    </label>
                    <label>
                        Address:
          <input type="text" value={this.state.address} onChange={this.handleChange} name="address" />
                    </label>
                    <label>
                        City:
          <input type="text" value={this.state.city} onChange={this.handleChange} name="city" />
                    </label>
                    <label>
                        Telephone:
          <input type="text" value={this.state.telephone} onChange={this.handleChange} name="telephone" />
                    </label>
                    <input type="submit" value="Add Owner" />
                </form>
            </Fragment>
        )
    }
}