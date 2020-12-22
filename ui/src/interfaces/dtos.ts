import {IUserProfile} from "./interfaces";

export interface ILoginRequest{
    phoneNr: string;
    password: string;
}

export interface ILoginResponse {
    refreshToken: string;
    token: string;
    profile:IUserProfile;
}

export interface  IRegistrationRequest {
    phoneNr: string;
    password: string;
    email: string;
    username: string;
    firstName: string;
    lastName: string;
}
export interface IRegistrationResponse{
    refreshToken: string;
    token: string;
    profile:IUserProfile;
}