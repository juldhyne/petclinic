import React, { Component, Fragment } from "react";
import PetForm from "./PetForm";

export default class OwnerFormPage extends Component {

    state = {
        pet: {
            name: "",
            birthdate: "",
            type: "",
        },
        owner: {
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

    getPet = async (pid) => {
        const response = await fetch(`http://localhost:9999/api/v1/pets/${pid}`)
        if (response.ok) {
            return await response.json()
        } else this.setState({ redirect: true })
    }

    setPet = async (pid) => {
        const pet = await this.getPet(pid)
        this.setOwner(pet.owner_id) // if rework of server
        this.setState({ pet })
    }

    getOwner = async (oid) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners/${oid}`)
        if (response.ok) {
            return await response.json()
        } else {
            this.setState({ redirect: true })
            return {}
        }
    }

    setOwner = async (oid) => {
        const { lastname = "", firstname = "" } = await this.getOwner(oid);
        !this.state.redirect && this.setState({ owner: { lastname, firstname } })
    }

    handleChange = ({ target }) => {
        this.setState({ pet: { ...this.state.pet, [target.name]: target.value } });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // const url = 'http://localhost:9999/api/v1/owners/${oid}'
        // do some validation
        // postData(url,this.state)
    }

    componentDidMount() {
        const { petId: pid, ownerId: oid } = this.props.match.params
        if (pid) this.setPet(pid)
        else this.setOwner(oid);

    }

    render() {
        return (
            <Fragment>
                <h2>Pet</h2>
                <PetForm {...this.state} handleChange={this.handleChange} handleSubmit={this.handleSubmit} />
            </Fragment>
        )
    }
}