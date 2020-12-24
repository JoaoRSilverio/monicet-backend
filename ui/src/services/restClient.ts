import axios, {AxiosInstance, AxiosResponse} from "axios";
import {MonicetAPI} from "../config/monicetAPI";
import {ILoginRequest, ILoginResponse, IRegistrationRequest, IRegistrationResponse} from "../interfaces/dtos";
import {useState} from "react";

interface IRestAuthState{
    token: string;
    refreshToken: string;
}
let AuthState = {
    token:"",
    refreshToken:""
}

const POST = async (route: string, data:any):Promise<AxiosResponse<any>> =>{
    // const authState = {tokens:{accessToken:""}};
    const response:AxiosResponse = await axios.post(route,data,{
        headers:{
           // "Accept":"application/json"
            //"Authorization":`Bearer ${authState.tokens.accessToken}`
        }
    });

    return response;
}
async function  refreshToken(): Promise<void> {

}
function  validation(response:AxiosResponse){
    //;
}

export async function register(http: AxiosInstance,data:IRegistrationRequest):Promise<IRegistrationResponse>{
    const response:AxiosResponse<IRegistrationResponse> = await http.post(MonicetAPI.REGISTER,data);
    console.log("Registration Result",response);
    if(response.status == 200) {
        return response.data;
    }

    throw new Error(`Registration Failed ${response.status} ${response.statusText} `)
}

export async function login(http:AxiosInstance, data:ILoginRequest)
    :Promise<ILoginResponse> {
    const response: AxiosResponse<ILoginResponse> = await http.post(MonicetAPI.LOGIN,data,);
    console.log("Login Result", response);
    if(response.status === 200){
        AuthState = response.data;
        return response.data;
    }
    throw new Error(`Login Failed ${response.status} ${response.statusText} `)
}

export async function testProtectedResource(http:AxiosInstance,data: any){
    const response:AxiosResponse<any> = await http.post(MonicetAPI.TEST_END_POINT,data,{
        headers:{
            "Authorization" :` Bearer ${AuthState.token}`
        }
    });
    console.log("Protected Endpoint Result",response);
    if(response.status === 200){
        return response.data;
    }
}
