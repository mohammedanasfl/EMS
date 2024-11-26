export class Skilldto{

    constructor(private id:number,private name:string,private _isSelected:boolean){
        
    }
    public get getId():number{
        return this.id;
    }
    public get getName():string{
        return this.name;
    }
    public get isSelected():boolean{
        return this._isSelected;
    }
    public set isSelected(isSelected:boolean){
        this._isSelected=isSelected;
    }
}