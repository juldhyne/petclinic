import axios from 'axios'
import Owner from './OwnerFind'
import React, { Component } from 'react'
import {Link} from 'react-router-dom'

export default class OwnerFindPage extends Component {
    state = { owners: [] }

    getOwners = async (ln) => {
        const response = await axios.get(`http://localhost:9999/api/v1/owners${ln && '/l/' + ln}`)
        return await response
    }

    setOwners = () => {
        const a = document.querySelector("input").value;
        this.getOwners(a)
            .then((response) => {
                let owners = []
                response.data.forEach(owner => {
                    owners.push(
                        <Owner key={owner.id} {...owner} />
                    )
                });
                this.setState({ owners })
            })
    }

    componentWillMount() {
        // this.setOwners()
    }

    render() {
        return (
            <div className="Content">
                <div className="container xd-container">
                    <h2>Owners</h2>
                    <input type="text" placeholder="Recherche de propriétaires" name="search" />
                    <button onClick={this.setOwners}>
                        OK
                    </button>
                    <table className="table table-striped" className="table-fill">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Locality</th>
                                <th>Phone</th>
                                <th>Pets</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.owners}
                        </tbody>
                    </table>
                    <Link to='/owners/new'>Add new owner</Link>
                </div>
            </div>
        )
    }
}