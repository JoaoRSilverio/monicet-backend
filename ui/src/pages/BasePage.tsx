import React from "react";
import {Alignment, Button, Navbar} from "@blueprintjs/core";

export interface IHomepageProps{
    children:any;
}

const BasePage:React.FC<IHomepageProps> = props => {
    return(
        <div>
            <Navbar>
                <Navbar.Group align={Alignment.LEFT}>
                    <Navbar.Heading>Monicet</Navbar.Heading>
                    <Navbar.Divider />
                    <Button className="bp3-minimal" icon="clipboard" text="News" />
                    <Button className="bp3-minimal" icon="people" text="Team And Partners" />
                    <Button className="bp3-minimal" icon="document" text="Publications" />
                    <Button className="bp3-minimal" icon="lock" text="Login" />
                </Navbar.Group>
            </Navbar>
            {props.children}
        </div>
    )
}
export default BasePage;