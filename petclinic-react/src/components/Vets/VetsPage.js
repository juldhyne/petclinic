// import axios from 'axios'
import Vet from './Vet'
import React, { Component } from 'react'

export default class VetsPage extends Component {


  state = { vets: [] }

  getVets = async () => {
    const response = await fetch('http://localhost:9999/api/v1/vets')
    return await response.json()
  }

  setVets = async () => {
    const vets = await this.getVets()
    const vetsComponents = await vets.map((vet, index) => <Vet key={index} {...vet} />)
    this.setState({ vets: vetsComponents })
  }


  componentWillMount() {
    this.setVets()
  }

  render() {
    return (
      <div className="Content">
        <div className="container xd-container">
          <h2 id="Vet-Title">Veterinarians</h2>
          <table className="table table-striped table-fill">
            <thead>
              <tr>
                <th>Name</th>
                <th>Specialties</th>
              </tr>
            </thead>
            <tbody>
              {this.state.vets}
            </tbody>
          </table>
        </div>
      </div>
    )
  }
}