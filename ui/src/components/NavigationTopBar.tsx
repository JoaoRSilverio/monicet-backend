import {Alignment, Button, Navbar} from "@blueprintjs/core";
import {Routes} from "../config/routes";
import React from "react";

 function NavigationTopBar(){
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
                <Button
                    onClick={()=> window.location.href = Routes.REGISTRATION}
                    className="bp3-minimal"
                    icon="new-person"
                    text="Registration" />
            </Navbar.Group>
        </Navbar>
    )
}
export default NavigationTopBar
