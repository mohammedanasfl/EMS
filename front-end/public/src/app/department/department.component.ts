import { Component } from '@angular/core';
import { RouterOutlet,RouterLink} from '@angular/router';



@Component({
  selector: 'app-department',
  standalone: true,
  imports: [RouterOutlet,RouterLink],
  templateUrl: './department.component.html',
  styleUrl: './department.component.css'
})
export class DepartmentComponent {

}
