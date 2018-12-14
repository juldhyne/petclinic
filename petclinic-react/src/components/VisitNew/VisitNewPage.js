import React, { Component, Fragment } from "react";
import PetInfo from "./PetInfo";
import VisitForm from "./VisitForm";
import VisitPrevious from "./VisitPrevious";


export default class VisitNewPage extends Component {
    state = {
        visits: [],
        visit:{
            description:"",
            date:"",
            pet_id:+this.props.match.params.petId
        },
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
        
        // this.setState({ owner: { ...this.state.owner, [target.name]: target.value } });
        this.setState({visit:{  ...this.state.visit,[target.name]: target.value }});
    }

    handleSubmit = (event) => {
        event.preventDefault();
         const url = 'http://localhost:9999/api/v1/visits'
        // do some validation
        // postData(url,this.state)
        //const { ownerId: oid } = this.props.match.params
        console.log(this.state.visit)
        console.log(typeof this.state.visit.date,typeof this.state.visit.description,typeof this.state.visit.pet_id)
        this.postData(url, this.state.visit)
    }

    postData = async (url = '', data = {}) =>{
        const response = await fetch(url, {
            headers:
            {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8',
            },
            method: "POST",
            mode: "cors",
            body: JSON.stringify(data)
        })
        const json = await response.json()
        console.log(json)
        return json
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
        console.log(pid)
        this.setPet(pid)
        this.setVisits(pid)
    }

    render() {
        return (
            <Fragment>
                <h2>New Visit</h2>
                <PetInfo {...this.state} />
                <VisitForm handleChange={this.handleChange} handleSubmit={this.handleSubmit} {...this.state.visit}/>
                <VisitPrevious {...this.state} />
            </Fragment>
        )
    }
}