import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent} from './home/home.component'; 
import { QuestionComponent }   from './questions/question.component';


const appRoutes: Routes = [
    {path: '', component:HomeComponent},
    {path:'question',component:QuestionComponent}, 
    
];

export const appRouterProviders: any[] = [];

export const routing: ModuleWithProviders =
  RouterModule.forRoot(appRoutes);
