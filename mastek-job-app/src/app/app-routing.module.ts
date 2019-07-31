import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobComponent } from './job/job.component';
import { JobsearchComponent } from './jobsearch/jobsearch.component';
import { CompanyComponent } from './company/company.component';


const routes: Routes = [
  { path: 'job', component: JobComponent },
  { path: 'jobsearch', component: JobsearchComponent },
  { path: 'companyPage', component: CompanyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
