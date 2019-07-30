import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobComponent } from './job/job.component';
import { JobsearchComponent } from './jobsearch/jobsearch.component';


const routes: Routes = [
  { path: 'job', component: JobComponent },
  { path: 'jobsearch', component: JobsearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
