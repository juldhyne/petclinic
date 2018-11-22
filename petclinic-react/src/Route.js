import * as React from 'react';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Home from './components/Home/Home';
// import OwnerNewPage from './components/OwnerNew/OwnerNewPage';
// import OwnerEditPage from './components/OwnerEdit/OwnerEditPage';
import OwnerFormPage from './components/OwnerForm/OwnerFormPage';
import OwnerFindPage from './components/OwnerFind/OwnerFindPage';
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
                    <Route path="/owners/:ownerId" component={OwnerInfoPage} />
                    <Route path="/vets" component={VetsPage} />
                    <Route path="/error" component={ErrorPage} />
                    <Route component={ErrorPage} />
                </Switch>
            </div>
        </BrowserRouter>
    )