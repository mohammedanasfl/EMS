export class Department{

    constructor(private id:number,private name:string){

    }
    public get getId():number{
        return this.id;
    }
    public get getName():string{
        return this.name;
    }

}