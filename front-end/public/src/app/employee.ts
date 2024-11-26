import { Department } from "./Department";
import { Skilldto } from "./skillDto";

export class Employee{

    constructor(private _name:string,private _lastName:string,private _email:string,private _department:Department,private _skills:Skilldto[],private _userName:string,public _status:boolean){

    }
    public get name():string{
        return this._name;
    }
    public get lastname():string{
        return this._lastName;
    }
    public get email():string{
        return this._email;
    }
    public get department():Department{
        return this._department;
    }
    public get status():boolean{
        return this._status;
    }
    public get skills():Skilldto[]{
        return this._skills;
    }
    public set skills(skill:Skilldto[]){
            this._skills=skill;
    }
    public get username():string{
        return this._userName;
    }
    public set status(status:boolean){
        this._status=status;
    }
}