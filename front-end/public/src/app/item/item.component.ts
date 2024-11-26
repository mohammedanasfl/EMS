import { Component,Input } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../EmployeeService';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [],
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent {

  @Input() employee:any
  employeeService:EmployeeService;

  constructor(employeeService:EmployeeService){
    this.employeeService=employeeService;
  }


  changeStatus(currentStatuts:boolean){
    debugger;

    this.employeeService.onChangeState(new Employee(this.employee.name,this.employee.lastName,this.employee.email,this.employee.department,this.employee.username,this.employee.skills, currentStatuts));
  }
  }

