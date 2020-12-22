import {IUserProfile} from "./interfaces";

export interface ILoginRequest{
    email: string;
    password: string;
}

export interface ILoginResponse {
    refreshToken: string;
    token: string;
    profile:IUserProfile;
}

export interface  IRegistrationRequest {
    password: string;
    email: string;
    username: string;
}
export interface IRegistrationResponse{
    refreshToken: string;
    token: string;
    profile:IUserProfile;
}