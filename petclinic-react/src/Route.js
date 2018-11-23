import React from 'react';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Home from './components/Home/Home';
import OwnerFindPage from './components/OwnerFind/OwnerFindPage';
import OwnerFormPage from './components/OwnerForm/OwnerFormPage';
import PetFormPage from './components/PetForm/PetFormPage';
import VisitNewPage from './components/VisitNew/VisitNewPage';
import OwnerInfoPage from './components/OwnerInfo/OwnerInfoPage';
import VetsPage from './components/Vets/VetsPage';
import ErrorPage from './components/ErrorPage/ErrorPage';
import Menu from './components/Menu/Menu'

export default () =>
    (
        <BrowserRouter>
            <div>
                <Menu />
                <Switch>
                    <Route exact path="/" component={Home} />
                    <Route path="/owners/find" component={OwnerFindPage} />
                    <Route path="/owners/new" component={OwnerFormPage} />
                    <Route path="/owners/:ownerId/edit" component={OwnerFormPage} />
                    <Route path="/owners/:ownerId/pets/new" component={PetFormPage} />
                    <Route path="/owners/:ownerId/pets/:petId/edit" component={PetFormPage} />
                    <Route path="/owners/:ownerId/pets/:petId/visits/new" component={VisitNewPage} />
                    {/* <Route path="/owners/:ownerId/pets/:petId/visits/:visitId/edit" component={VisitFormPage} /> */}
                    <Route path="/owners/:ownerId" component={OwnerInfoPage} />
                    <Route path="/vets" component={VetsPage} />
                    <Route path="/error" component={ErrorPage} />
                    <Route component={ErrorPage} />
                </Switch>
            </div>
        </BrowserRouter>
    )