import React from 'react';
import { Link } from 'react-router-dom'

export default class Menu extends React.Component {

    render() {
        return (
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navi">
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li>
                            <Link to="/" /*activeClassName="selected"*/>HOME</Link>
                        </li>
                        <li>
                            <Link to="/owners/find" /*activeClassName="selected"*/>FIND OWNERS</Link>
                        </li>
                        <li>
                            <Link to="/vets" /*activeClassName="selected"*/>VETERINARIANS</Link>
                        </li>
                    </ul>
                </div>
            </nav >
        )
    }
}