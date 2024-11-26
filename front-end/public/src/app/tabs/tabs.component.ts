import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
import { ListComponent } from '../list/list.component';
import { EmployeeService } from '../EmployeeService';
import{RouterLink,RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-tabs',
  standalone: true,
  imports: [ListComponent,NgClass,RouterLink,RouterOutlet],
  templateUrl: './tabs.component.html',
  styleUrl: './tabs.component.css'
})
export class TabsComponent {

  currentStatus='all';
  employeeService:EmployeeService;

  constructor (employeeService:EmployeeService){
    this.employeeService=employeeService;
  }
onTabClick(selectedStatus:string){
  this.currentStatus=selectedStatus;
}
getEmployee(){
  return this.employeeService.getEmployess(this.currentStatus);
}

}
