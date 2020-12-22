import React, {ChangeEvent, useState} from "react";
import BasePage from "./BasePage";
import {FormGroup} from "@blueprintjs/core/lib/cjs";
import {Button, InputGroup} from "@blueprintjs/core";
import {IRegistrationRequest} from "../interfaces/dtos";
import {register} from "../services/restClient";
import axios from "axios";


function useRegistration():[IRegistrationRequest,(rR:IRegistrationRequest)=>void]{
    return useState({username:"",password:"",email:""});
}
enum FIELDS {
    USERNAME = "username",
    PASSWORD = "password",
    EMAIL = "email"
}

export const RegisterPage:React.FC<any> = (props) =>{
    const [registrationRequest,setRegistrationRequest] = useRegistration();

    function handleInput(text: string, field: FIELDS) {
        switch (field) {
            case FIELDS.PASSWORD:
            case FIELDS.USERNAME:
            case FIELDS.EMAIL:
                //@ts-ignore
                setRegistrationRequest({...registrationRequest, [field]: text})
                break;
            default:
        }
    }
    return (
        <BasePage>
            <h3>{"Registration Page"}</h3>
            <FormGroup
                label="Email"
                labelInfo="(example@provider.com)"
            >
                <InputGroup
                    onChange={(event:any) => handleInput(event.target.value,FIELDS.EMAIL)}
                    value={registrationRequest.email} />
            </FormGroup>
            <FormGroup
                label="Username"
                labelInfo="(maria.leal)"
            >
                <InputGroup
                    onChange={(event:any) => handleInput(event.target.value,FIELDS.USERNAME)}
                    value={registrationRequest.username} />
            </FormGroup>
            <FormGroup
                label="Password"
                labelInfo="use 5 chars and 50 numbers please"
            >
                <InputGroup
                    leftIcon={"lock"}
                    type={"password"}
                    onChange={(event:any) => handleInput(event.target.value,FIELDS.PASSWORD)}
                    value={registrationRequest.password} />
            </FormGroup>
            <Button onClick={()=> register(axios,registrationRequest)} text={"Register"} />
        </BasePage>
    )
}