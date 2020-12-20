import React from 'react';
import {BrowserRouter as Router, Route,Switch} from "react-router-dom";
import './App.css';
import HomePage from "./pages/HomePage";
import BasePage from "./pages/BasePage";

function App() {
  return (
    <div className="App">
        <Router>
     <BasePage>
         <Switch>
             <Route path={"/"} >
                 <HomePage />
             </Route>
         </Switch>
     </BasePage>
        </Router>
    </div>
  );
}

export default App;
