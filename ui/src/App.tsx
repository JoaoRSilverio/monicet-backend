import React from 'react';
import {BrowserRouter as Router, Route,Switch, useRouteMatch} from "react-router-dom";
import './App.css';
import HomePage from "./pages/HomePage";
import BasePage from "./pages/BasePage";
import {Routes} from "./config/routes";
import LoginPage from "./pages/LoginPage";
import NavigationTopBar from "./components/NavigationTopBar";
import {RegisterPage} from "./pages/RegistrationPage";
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
function App() {
  return (
    <div className="App">
            <NavigationTopBar />
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
                 <LoginPage />
             </Route>
             <Route path={Routes.REGISTRATION}>
                 <RegisterPage />
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
