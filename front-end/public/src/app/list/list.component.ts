import { Component } from '@angular/core';
import { ItemComponent } from '../item/item.component';
import { Employee } from '../employee';
import { Input } from '@angular/core';
import{NgFor} from '@angular/common';
import { OnInit ,OnDestroy} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../EmployeeService';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [ItemComponent,NgFor],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit,OnDestroy{

  @Input() employess:any;
  currentStatus:string='all';
  activatedRoute:ActivatedRoute;
  employeeService:EmployeeService;
  employeeSubcription:any;
  

  constructor(activatedRoute:ActivatedRoute,employeeService:EmployeeService){
    this.activatedRoute=activatedRoute;
    this.employeeService=employeeService;
  }
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.currentStatus = params['status'];
      this.employess = this.employeeService.getEmployess(this.currentStatus); 
    });

    this.employeeSubcription = this.employeeService.onEmplyeeUpdate.subscribe(
      () => {
        this.employess = this.employeeService.getEmployess(this.currentStatus); 
      }
    );
  }

 
    
    

  ngOnDestroy(): void {
    this.employeeSubcription.unsubscribe();
  }
}
