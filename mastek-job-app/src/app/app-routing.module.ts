import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobComponent } from './job/job.component';
import { JobsearchComponent } from './jobsearch/jobsearch.component';
import { CompanyComponent } from './company/company.component';
import { CompanyloginComponent } from './companylogin/companylogin.component';
import { UserComponent } from './user/user.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { FeatComponent } from './feat/feat.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';



const routes: Routes = [
  { path: 'job', component: JobComponent },
  { path: 'jobsearch', component: JobsearchComponent },
  { path: 'companyPage', component: CompanyComponent},
  { path: 'companyLogin', component: CompanyloginComponent},
  { path: 'userPage', component: UserComponent},
  { path: 'userLogin', component: UserloginComponent},
  { path: 'feat', component: FeatComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, BrowserModule, HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
