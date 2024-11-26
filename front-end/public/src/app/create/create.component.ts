import { Component,OnInit  } from '@angular/core';
import { NgFor } from '@angular/common';
import { NgForm,FormsModule } from '@angular/forms';
import { Employee } from '../employee';
import { EmployeeService } from '../EmployeeService';
import { NgIf } from '@angular/common';
import { formatCurrency } from '../../../node_modules/@angular/common/index';
import { FormGroup } from '../../../node_modules/@angular/forms/index';
import { FormControl, FormBuilder } from '@angular/forms';
import { Skilldto } from '../skillDto';
import { Department } from '../Department';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';



@Component({
  selector: 'app-create',
  standalone: true,
  imports: [NgFor,FormsModule,NgIf,NgMultiSelectDropDownModule],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent implements OnInit{

  options=[{display:'none',value:''},{display:"Active",value:"active"},{display:'InActive',value:"Inactive"}];
  department=[{display:'none',value:''}];
  dep:Department[];
  skills:any[]=[];
  selectedItems:Skilldto[]=[];
  dropdownSettings = {};
  employeeService:EmployeeService;

  constructor(employeeService:EmployeeService){
    this.employeeService=employeeService;
    this.dep=this.employeeService.getdepartment();
    this.fillOption();
    this.fillSkills();

  
  
}
ngOnInit(): void {
  this.dropdownSettings = {
    singleSelection: false,
    idField: 'id',
    textField: 'name',
    selectAllText: 'Select All',
    unSelectAllText: 'UnSelect All',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };

  this.getSkills(); // Fetch skills when component initializes
}

  submitForm(myForm:NgForm){
    debugger;
    if(myForm.invalid){
      return;
    }
    let employee=new Employee(myForm.value.firstName,myForm.value.lastName,myForm.value.email,this.getSelectedDepartment(myForm.value.department),this.selectedItem,myForm.value.email,myForm.value.status);
    this.employeeService.addEmployee(employee);
    
  }
  

  fillOption(){
    debugger;
   this. department=[];
    for(let s of this.dep){
      this.department.push({display:s.getName,value:s.getName})
    }
    console.log(this.department);
  }
  fillSkills(){
   this.skills=this.employeeService.getSkills();
    console.log(this.skills);
  }
  getSelectedDepartment(name:string):any{
    for(let e of this.dep){
        if(e.getName== name){
          return e;
        }
    }
    return null;
  }
  selectedItem: any[] = [];

  onItemSelect(item: any) {
  debugger;
    this.selectedItem.push(new Skilldto(item.id, item.name, false));
    console.log(this.selectedItem);
  }

  onSelectAll(items: any) {
    console.log(items);
  }
  getSkills() {

    this.skills = this.employeeService.getSkills().map(skill => ({
      id: skill.getId,
      name: skill.getName
    }));
  }
}
