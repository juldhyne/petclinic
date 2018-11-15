import axios from 'axios'
import Owner from './OwnerFind'
import React, { Component } from 'react'

export default class OwnerFindPage extends Component
{
    state = { owners:[] }

    getOwners = async() => {
        const response = await axios.get('http://localhost:9999/api/v1/owners')
        return await response
    }

    setOwners = () => {
        this.getOwners()
        .then((response) => {
            let owners = []
            response.data.forEach(owner => {
                owners.push(
                    <Owner key = {owner.lastname} {...owner}/>
                )
            });
            this.setState({owners})
        })
    }

    componentWillMount()
    {
        this.setOwners()
    }

    render()
    {
        return (
            <div className="Content">
                <div className="container xd-container">
                    <h2>Owners</h2>
                    <table className = "table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Locality</th>
                                <th>Phone</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.owners}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}