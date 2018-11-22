import VisitInfo from './VisitInfo';
import React, { Component, Fragment } from 'react'
import { Link } from 'react-router-dom'

class PetInfo extends Component {
    state = {
        visits: []
    }

    getVisits = async (id) => {
        const response = await fetch(`http://localhost:9999/api/v1/visits/p/${id}`)
        const json = response.ok ? await response.json() : []
        return json
    }

    setVisits = async () => {
        const pid = this.props.pet.id
        const visits = await this.getVisits(pid)
        const visitInfos = visits.reduce((acc, visit) => {
            acc.push(
                <VisitInfo key={visit.id} {...visit} />
            )
            return acc
        }, []);

        this.setState({ visits: visitInfos })
    }

    componentDidMount() {
        this.setVisits()
    }

    render() {
        const { id, name, birthdate, type, owner: { id: oid } } = this.props.pet;
        return (
            <Fragment>
                <tr>
                    <td valign="top"><dl className="dl-horizontal">
                        <dt>Name</dt>
                        <dd>{name}</dd>
                        <dt>Birth Date</dt>
                        <dd>{birthdate}</dd>
                        <dt>Type</dt>
                        <dd>{type}</dd>
                    </dl></td>
                    <td valign="top">
                        <table className="table-condensed table-fill" >
                            <thead><tr>
                                <th>Visit Date</th>
                                <th>Description</th>
                            </tr></thead>

                            <tbody>
                                {this.state.visits}
                                <tr>
                                    <td>
                                        <Link to={`/owners/${oid}/pets/${id}/edit`}>Edit Pet</Link>
                                    </td>
                                    <td>
                                        {/* id/visit/new, id/0/new, id/v/new or id/new ? */}
                                        <Link to={`/owners/${oid}/pets/${id}/visits/new`}>Add Visit</Link>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </Fragment >
        )
    }
}

export default PetInfo;