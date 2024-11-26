import { Component,OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { EmployeeService } from '../EmployeeService';
import { NgForm } from '@angular/forms';
import { Skilldto } from '../skillDto';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-add-skills',
  standalone: true,
  imports: [FormsModule,NgIf,NgMultiSelectDropDownModule],
  templateUrl: './add-skills.component.html',
  styleUrl: './add-skills.component.css'
})
export class AddSkillsComponent {
  skills: any[] = []; // Assuming this will hold the list of skills to display
  selectedItem: Skilldto[] = []; // Assuming Skilldto has appropriate properties

  dropdownSettings: any = {};

  constructor(private employeeService: EmployeeService) {}

  

  

  onSubmit(myForm: NgForm) {
    debugger;
    this.employeeService.saveSkills(new Skilldto(-1, myForm.value.skill, false));
  }

  
}