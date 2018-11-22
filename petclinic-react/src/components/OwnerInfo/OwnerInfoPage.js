// import axios from 'axios'
import OwnerInfo from './OwnerInfo'
import PetInfo from './PetInfo';
import {Redirect} from 'react-router';
import React, { Component, Fragment } from 'react'

export default class OwnerInfoPage extends Component {
    state = {
        owners: {},
        pets: [],
        visits: []
    }

    getOwner = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/owners/${id}`)
        if(response.ok){
            const json = await response.json();
            return await json
        }else{
             this.setState({redirect : true})
             return {}
        }
    }

    setOwner = async (id) => {
        const owner = await this.getOwner(id)
        if(this.mounted){
            this.setState({ owner })
        }
    }

    getPets = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/pets/o/${id}`)
        const json = response.ok ? await response.json() : []
        return json
    }

    setPets = async (id) => {
        const pets = await this.getPets(id)
        if(this.mounted){
        const petInfos = pets.reduce((acc, pet) => {
            acc.push(
                <PetInfo key={pet.id} pet={pet} />
            )
            return acc
        }, []);

        this.setState({ pets: petInfos })
        }
    }

    componentDidMount() {
        this.mounted = true;
        const id = this.props.match.params.ownerId
        this.setOwner(id);
        this.setPets(id);
    }

    componentWillUnmount(){
        this.mounted = false;
    }

    render() {
        return (
            <Fragment >
                {this.state.redirect && <Redirect to='/error'/>}
                <h2>Owner Information</h2>
                <OwnerInfo {...this.state.owner} />
                <h2>Pets and Visits</h2>
                <table className="table table-striped">
                    <tbody>
                        {this.state.pets}
                    </tbody>
                </table>
            </Fragment>
        )
    }
}