import React from "react";
import {Alignment, Button, Navbar} from "@blueprintjs/core";
import BasePage from "./BasePage";

export interface IHomepageProps{}

const HomePage:React.FC<IHomepageProps> = props => {
    return(
           <h3>{"HomePage"}</h3>
    )
}
export default HomePage;