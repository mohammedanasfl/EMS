import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Department } from './Department';
import { Employee } from './employee';
import { Skilldto } from './skillDto';

@Injectable()
export class EmployeeService{

    private employee:Employee[]=[];
    private department:Department[]=[];
    private skill:Skilldto[]=[];

    onEmplyeeUpdate:Subject<void>=new Subject<void>();
    
    constructor(private httpClient:HttpClient){
        this.retriveEmployees();
       this. getdepartment();
       this.getSkills();
    }
    retriveEmployees(){
       
        this.httpClient.get<any[]>("http://localhost:1001/api/allEmployess").subscribe(
            (response: any[]) => {
                for (let e of response) {
                    //debugger;
                    let emp = new Employee(
                        e.id+" "+e.firstName  , e.lastName, 
                        e.email, 
                        e.departmentDto.name,
                        e.skill, 
                        e.accountDto.username,
                        e.accountDto.active
                    );
                    this.employee.push(emp);
                }
            this.onEmplyeeUpdate.next();
        });
    }
    public getEmployess(status:string){
    

        if(status =="all"){
            return this.employee.slice();
        }
        return this.employee.filter((emp)=>emp.status==(status=='active'));
    }
    public onChangeState(emp:Employee){
        let id=emp.name.split(" ")[0];
        this.httpClient.patch("http://localhost:1001/api/employee/"+id+"/status",{
            "active":emp.status
        }).subscribe((response:any)=>{
            let index=this.employee.findIndex((e)=>e.name==emp.name);
            this.employee[index].status=emp.status;
            this.onEmplyeeUpdate.next();
        });
       
    }
    public addEmployee(employee: Employee) {
        this.setSkillJson(employee.skills);
    
        let index = this.employee.findIndex((e) => e.email === employee.email);
        if (index !== -1) {
            return;
        }
        
        this.employee.push(employee);
    
        this.httpClient.patch("http://localhost:1001/api/add/employee/"+employee.department.getId, {
            "firstName":employee.name,
            "lastName":employee.lastname,
            "email":employee.email,
            "skill":this.dyanmicSkill,
            "accountDto": {
                "username": employee.username,
                "active": employee._status==true?true:false
              
            },
            "departmentDto": {
                "name": employee.department.getName

            }
        }).subscribe(
            (response:any) => {
                console.log('POST request successful', response);
                
            },
            (error:any) => {
                console.error('POST request error', error);

            }
        );
        console.log(this.employee)
    }
    
    dyanmicSkill:any[]=[];
    setSkillJson(skills:Skilldto[]){
    this.dyanmicSkill=[];

        for(let f of skills){
            this.dyanmicSkill.push({
            
                "name":f.getName,
            });
        }
        console.log(this.dyanmicSkill)
    }

    public getdepartment():Department[]{
       // debugger;
        this.httpClient.get("http://localhost:1001/api/all/department").subscribe((response:any)=>{
            this.department=[];
                for(let e of response){
                    let d=new Department(e.id,e.name);
                    this.department.push(d);
                }
                this.onEmplyeeUpdate.next();
        });
        return this.department;

    }
    public getSkills():Skilldto[]{
        debugger;
        this.httpClient.get("http://localhost:1001/api/all/skills").subscribe((response:any)=>{
            
        this.skill=[];

                for(let e of response){
                    let skill=new Skilldto(e.id,e.name,false);
                    this.skill.push(skill);
                }
                this.onEmplyeeUpdate.next();
        });
        
        return this.skill;

    }
    public saveDepartment(department:Department):string{

        this.httpClient.post("http://localhost:1001/api/all/department", {
            "name":department.getName
    }).subscribe();

    return"";
    }
    public saveSkills(skill:Skilldto){

        this.httpClient.post("http://localhost:1001/api/all/skill", {
            "name":skill.getName
    }).subscribe();

    return"";
    }

}