import React, { Component } from 'react'
import OwnerSearch from './OwnerSearch'
import OwnerFound from './OwnerFound';

export default class OwnerFindPage extends Component {
    state = { owners: [] }

    getOwners = async (ln) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners${ln && '/l/' + ln}`)
        return response.ok ? await response.json() : []

    }

    setOwners = () => {
        const { value } = document.querySelector("#search");
        this.getOwners(value)
            .then(owners => this.setState(owners.length ? { owners, noMatch: false } : { noMatch: true }))
    }

    render() {
        return (
            <div className="Content">
                <div className="container xd-container">
                    <h2>Owners</h2>
                    {
                        this.state.owners.length
                            ? <OwnerFound owners={this.state.owners} />
                            : <OwnerSearch setOwners={this.setOwners} noMatch={this.state.noMatch} />
                    }
                </div>
            </div>
        )
    }
}