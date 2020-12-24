import React, {ChangeEvent, useState} from "react";
import {IHomepageProps} from "./HomePage";
import axios from "axios"
import {login, register, testProtectedResource} from "../services/restClient";
import {Button, InputGroup} from "@blueprintjs/core";
import {ILoginRequest} from "../interfaces/dtos";
import {log} from "util";
import {FormGroup} from "@blueprintjs/core/lib/cjs";
import BasePage from "./BasePage";

function doRegister(){
    register(
        axios,
        {
            email:"reactuser@react.com",
            password:"123456",
            username:"reactperson"});
}
enum FIELDS {
    USERNAME = "username",
    PASSWORD = "password",
    EMAIL = "email"
}
function useLoginRequest():[ILoginRequest,(lr:ILoginRequest)=> void]{
    const [loginRequest,setLoginRequest] = useState({password:"", email:"" } as ILoginRequest);
    return [loginRequest,setLoginRequest];
}

interface IAuthState{
    refreshToken: string;
    token: string;
}
function useAuthState():[IAuthState,(auth:IAuthState)=> void]{
    const [authState,setAuthState] = useState({ token:"", refreshToken:""} as IAuthState);
    return [authState,setAuthState];
}

const LoginPage:React.FC<IHomepageProps> = props => {
    // login(axios,{email:"reactexample",password:"12345"});
    const [authState,setAuthState] = useAuthState();
    const [loginRequest,setLoginRequest] = useLoginRequest();
    function handleInput(text: string, field: FIELDS){
        console.log("handleInput",text,field);
        switch (field){
            case FIELDS.PASSWORD:
            case FIELDS.USERNAME:
            case FIELDS.EMAIL:
                //@ts-ignore
                setLoginRequest({...loginRequest,[field]:text})
                break;
            default:
        }

    }
    async function doLogin(){
      const authResponse = await  login(axios,loginRequest);
      setAuthState(authResponse)
    }
    async function doTest(){
        testProtectedResource(axios,{someText:"reactAppText"})
    }
    return(
        <BasePage>
        <div>
        <h3>{"Login Page"}</h3>
            <FormGroup
                helperText="insert your email here"
                label="Email"
                labelInfo="(example@provider.com)"
            >
        <InputGroup
            onChange={(event:any) => handleInput(event.target.value,FIELDS.EMAIL)}
                    value={loginRequest.email} />
            </FormGroup>
            <FormGroup
                helperText="Helper text with details..."
                label="Label A"
                labelFor="text-input"
                labelInfo="(required)"
            >
            <InputGroup
            leftIcon={"lock"}
                type={"password"}
            onChange={(event:any) => handleInput(event.target.value,FIELDS.PASSWORD)}
            value={loginRequest.password} />
            </FormGroup>
            <Button icon={"airplane"} onClick={()=> doLogin() } />
        </div>
            {authState.token &&
            (<div>
                <h3>{"Logged In"}</h3>
                <h5>{`Access Token: ${authState.token}`}</h5>
                <h5>{`Refresh Token: ${authState.refreshToken}`}</h5>

            </div>)
            }
            <Button text={"accessResource"} onClick={()=> doTest()} />
        </BasePage>
    )
}
export default LoginPage;