import React, { Component } from "react";
import VisitList from "./VisitList";
import Pet from "./Pet";

export default class PetItemList extends Component {
    state = {
        visits: []
    }

    getVisits = async (pid) => {
        const response = await fetch(`http://localhost:9999/api/v1/visits/p/${pid}`)
        const json = response.ok ? await response.json() : []
        return json
    }

    setVisits = async (pid) => {
        const visits = await this.getVisits(pid)
        this.setState({ visits })
    }


    componentDidMount() {
        this.setVisits(this.props.id)
    }

    render() {
        const { id: pid, owner: { id: oid } } = this.props
        return (
            <tr>
                <Pet {...this.props} />
                <VisitList visits={this.state.visits} oid={oid} pid={pid} />
            </tr>
        )
    }
}