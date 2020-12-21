import React from 'react';
import {BrowserRouter as Router, Route,Switch, useRouteMatch} from "react-router-dom";
import './App.css';
import HomePage from "./pages/HomePage";
import BasePage from "./pages/BasePage";
import {Alignment, Button, Navbar} from "@blueprintjs/core";
import {Routes} from "./config/routes";
function DashboardNavigation(){
    const match = useRouteMatch();
    return (
        <Switch>
            <Route path={`${match.path}${Routes.CATALOG}`}>
                <BasePage>
                    <div>{"Catalog"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.DATA_VISUALIZATION}`}>
                <BasePage>
                    <div>{"Maps and Graphs"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.SIGHTINGS_HISTORY}`}>
                <BasePage>
                    <div>{"Sightings"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.SIGHTINGS_ADD}`}>
                <BasePage>
                    <div>{"Add Sighting"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.BAYWATCH_SCAN}`}>
                <BasePage>
                    <div>{"Baywatch Scan"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.BAYWATCH_DATA_UPLOAD}`}>
                <BasePage>
                    <div>{"Data Upload"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.BAYWATCH_HISTORY}`}>
                <BasePage>
                    <div>{"Maps and Graphs"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.BACKOFFICE}`}>
               <BackOfficeDashboardNavigation />
            </Route>
            <Route path={match.path}>
                <BasePage>
                    <div>{"Dashboard"}</div>
                </BasePage>
            </Route>
        </Switch>
    )
}
function BackOfficeDashboardNavigation(){
    const match = useRouteMatch();
    return (
        <Switch>
            <Route path={`${match.path}${Routes.MANAGEMENT_COLABORATORS}`}>
                <BasePage>
                    <div>{"Colaborators and Boats"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.MANAGEMENT_BAYWATCH}`}>
                <BasePage>
                    <div>{"BayWatch"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.AUDIT_LOG}`}>
                <BasePage>
                    <div>{"Audit Log"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.MANAGEMENT_PUBLICATIONS}`}>
                <BasePage>
                    <div>{"Publications"}</div>
                </BasePage>
            </Route>
            <Route path={`${match.path}${Routes.NEWS}`}>
                <BasePage>
                    <div>{"News Managment"}</div>
                </BasePage>
            </Route>
            <Route path={match.path}>
                <BasePage>
                    <div>{"Backend Dashboard"}</div>
                </BasePage>
            </Route>
        </Switch>
    )
}
function NavigationBar(){
    return(
        <Navbar>
            <Navbar.Group align={Alignment.LEFT}>
                <Navbar.Heading>Monicet</Navbar.Heading>
                <Navbar.Divider />
                <Button
                    onClick={()=> window.location.href = Routes.NEWS}
                    className="bp3-minimal"
                    icon="clipboard"
                    text="News"  />
                <Button
                    onClick={()=> window.location.href = Routes.TEAM}
                    className="bp3-minimal"
                    icon="people"
                    text="Team And Partners" />
                <Button
                    onClick={()=> window.location.href = Routes.PUBLICATIONS}
                    className="bp3-minimal"
                    icon="document"
                    text="Publications" />
                <Button
                    onClick={()=> window.location.href = Routes.LOGIN}
                    className="bp3-minimal"
                    icon="lock"
                    text="Login" />
            </Navbar.Group>
        </Navbar>
    )
}
function App() {
  return (
    <div className="App">
            <NavigationBar />
        <Router>
     <BasePage>
         <Switch>
             <Route path={Routes.NEWS}>
                 <BasePage>
                     <div>{"News Page"}</div>
                 </BasePage>
             </Route>
             <Route path={Routes.TEAM}>
                 <BasePage>
                     <div>{"Team and Partner"}</div>
                 </BasePage>
             </Route>
             <Route path={Routes.PUBLICATIONS}>
                 <BasePage>
                     <div>{"Publications"}</div>
                 </BasePage>
             </Route>
             <Route path={Routes.LOGIN}>
                 <BasePage>
                     <div>{"Login"}</div>
                 </BasePage>
             </Route>
             <Route path={Routes.DASHBOARD}>
                <DashboardNavigation />
             </Route>
             <Route  path={"/"} >
                 <HomePage />
             </Route>
         </Switch>
     </BasePage>
        </Router>
    </div>
  );
}


export default App;
