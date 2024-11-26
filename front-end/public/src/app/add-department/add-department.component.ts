import { Component } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { NgIf } from '@angular/common';
import { EmployeeService } from '../EmployeeService';
import { Department } from '../Department';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-department',
  standalone: true,
  imports: [FormsModule,NgIf],
  templateUrl: './add-department.component.html',
  styleUrl: './add-department.component.css'
})
export class AddDepartmentComponent {

  employeeService:EmployeeService;
  message:string="";

  constructor(employeeService:EmployeeService){
    this.employeeService=employeeService;
  }
  onSubmit(myForm:NgForm){
    debugger;
    this.message=this.employeeService.saveDepartment(new Department(-1,myForm.value.department))
  }

}
