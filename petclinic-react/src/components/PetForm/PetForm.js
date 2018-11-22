import React, { Component, Fragment } from "react";
import { Redirect } from 'react-router'

export default class PetForm extends Component {
    state = {
        name: "",
        birthdate: "",
        type: "",
        owner: {
            id: "",
            lastname: "",
            firstname: ""
        }
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

    getOwner = async () => {
        const oid = this.props.match.params.ownerId
        const response = await fetch(`http://localhost:9999/api/v1/owners/${oid}`)
        const { id, lastname, firstname } = await response.json()
        const json = { id, lastname, firstname }
        this.setState({ owner: json })
    }

    getData = async (pid) => {
        const response = await fetch(`http://localhost:9999/api/v1/pets/${pid}`)
        if (response.ok) {
            const json = await response.json()
            this.setState({ ...json })
        } else {
            this.setState({ redirect: true })
        }
    }

    handleChange = ({ target }) => {
        this.setState({ [target.name]: target.value });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // const url = 'http://localhost:9999/api/v1/owners/${oid}'
        // do some validation
        // postData(url,this.state)
    }

    componentDidMount() {
        this.getOwner();
        const { url } = this.props.match
        const { petId: pid } = this.props.match.params
        const re = /\/owners\/[\d]+\/pets\/[\d]+\/edit/
        re.test(url) && this.getData(pid)
    }

    render() {
        const { url } = this.props.match
        const re = /\/owners\/[\d]+\/pets\/[\d]+\/edit/
        const owner = [this.state.owner.lastname, this.state.owner.firstname].join(' ')
        return (
            <Fragment>
                {this.state.redirect && <Redirect to='/error' />}
                <h2>Pet</h2>
                <form onSubmit={this.handleSubmit} method='POST'>
                    <label>
                        Owner:
                        <span> {owner} </span>
                        {/* <input type="text" value={owner} onChange={this.handleChange} name="owner" /> */}
                    </label>
                    <label>
                        Name:
          <input type="text" value={this.state.name} onChange={this.handleChange} name="name" />
                    </label>
                    <label>
                        Birthdate:
          <input type="text" value={this.state.birthdate} onChange={this.handleChange} name="birthdate" />
                    </label>
                    <label>
                        type:
          <input type="text" value={this.state.type} onChange={this.handleChange} name="type" />
                    </label>
                    <input type="submit" value={`${re.test(url) ? 'Update' : 'Add'} Pet`} />
                </form>
            </Fragment>
        )
    }
}