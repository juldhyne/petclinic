import Owner from './Owner'
import PetList from './PetList';
import { Redirect } from 'react-router';
import React, { Component, Fragment } from 'react'

export default class OwnerInfoPage extends Component {
    state = {
        owners: {},
        pets: [],
    }

    getOwner = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners/${id}`)
        if (response.ok) {
            const json = await response.json();
            return json
        } else {
            this.setState({ redirect: true })
            return {}
        }
    }

    setOwner = async (id) => {
        const owner = await this.getOwner(id)
        !this.state.redirect && this.setState({ owner })
        return id // just for promises callback purpose
    }

    getPets = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/pets/o/${id}`)
        const json = response.ok ? await response.json() : []
        return json
    }

    setPets = async (id) => {
        if (!this.state.redirect) {
            const pets = await this.getPets(id)
            this.setState({ pets })
        }
    }

    componentDidMount() {
        this.setOwner(this.props.match.params.ownerId)
            .then(this.setPets)
    }

    render() {
        if (this.state.redirect) return <Redirect to='/error' />
        return (
            <Fragment >
                <Owner {...this.state.owner} />
                <PetList pets={this.state.pets} />
            </Fragment>
        )
    }
}