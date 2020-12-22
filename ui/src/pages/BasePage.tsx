import React from "react";
import {Alignment, Button, Navbar} from "@blueprintjs/core";

export interface IHomepageProps{
    children:any;
}

const BasePage:React.FC<IHomepageProps> = props => {
    return(
        <div style={{width:500}}>
            {props.children}
        </div>
    )
}
export default BasePage;