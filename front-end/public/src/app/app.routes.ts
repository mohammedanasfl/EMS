import { Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { DepartmentComponent } from './department/department.component';
import { ListComponent } from './list/list.component';
import { TabsComponent } from './tabs/tabs.component';

import { AddDepartmentComponent } from './add-department/add-department.component';
import { AddSkillsComponent } from './add-skills/add-skills.component';

export const routes: Routes = [

    {path:'employee',component:TabsComponent,
        children:[{path:'',redirectTo:"/all",pathMatch:'full'},{path:":status",component:ListComponent}]        
},

    
    {path:'new-Employee',component:CreateComponent},
    {path:'add-Employee',component:DepartmentComponent,
    children:[{path:'',component:AddDepartmentComponent},{path:'addDepartment',component:AddDepartmentComponent},{path:'addSkill',component:AddSkillsComponent}]
},
    {path:'**',redirectTo:"employee/all"},
   
];
