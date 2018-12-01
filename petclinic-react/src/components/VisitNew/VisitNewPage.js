import React, { Component, Fragment } from "react";
import PetInfo from "./PetInfo";
import VisitForm from "./VisitForm";
import VisitPrevious from "./VisitPrevious";


export default class VisitNewPage extends Component {
    state = {
        visits: [],
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

    handleChange = ({ target }) => {
        this.setState({ [target.name]: target.value });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        // const url = 'http://localhost:9999/api/v1/owners/${oid}'
        // do some validation
        // postData(url,this.state)
    }

    getVisits = async (pid) => {
        const response = await fetch(`http://localhost:9999/api/v1/visits/p/${pid}`)
        const json = response.ok ? await response.json() : []
        return json
    }

    setVisits = async (pid) => {
        const visits = await this.getVisits(pid)
        const visitsPrev = visits.reduce((acc, visit) => {
            acc.push(
                <Fragment key={visit.id}>
                    <tr>
                        <td>{visit.date}</td>
                        <td>{visit.description}</td>
                    </tr>
                </Fragment>
            )
            return acc
        }, [])
        this.setState({ visits: visitsPrev })
    }

    getPet = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/pets/${id}`)
        const json = response.ok && await response.json()
        return json
    }

    setPet = async (id) => {
        const pet = await this.getPet(id)
        pet && this.setState({ pet })
    }

    getOwner = async (oid) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners/${oid}`)
        const json = response.ok ? await response.json() : {}
        return json
    }

    setOwner = async (oid) => {
        const { lastname = "", firstname = "" } = await this.getOwner(oid)
        this.setState({ owner: { lastname, firstname } })
    }

    componentDidMount() {
        const pid = this.props.match.params.petId
        this.setPet(pid)
        this.setVisits(pid)
    }

    render() {
        return (
            <Fragment>
                <h2>New Visit</h2>
                <PetInfo {...this.state} />
                <VisitForm handleChange={this.handleChange} handleSubmit={this.handleSubmit} />
                <VisitPrevious {...this.state} />
            </Fragment>
        )
    }
}