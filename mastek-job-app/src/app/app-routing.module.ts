import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobComponent } from './job/job.component';
import { JobsearchComponent } from './jobsearch/jobsearch.component';
import { CompanyComponent } from './company/company.component';
import { CompanyloginComponent } from './companylogin/companylogin.component';
import { UserComponent } from './user/user.component';
import { UserloginComponent } from './userlogin/userlogin.component';

const routes: Routes = [
  { path: 'job', component: JobComponent },
  { path: 'jobsearch', component: JobsearchComponent },
  { path: 'companyPage', component: CompanyComponent},
  { path: 'companyLogin', component: CompanyloginComponent},
  { path: 'userPage', component: UserComponent},
  { path: 'userLogin', component: UserloginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
