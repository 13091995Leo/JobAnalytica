import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JobComponent } from './job/job.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserComponent } from './user/user.component';
import { CompanyloginComponent } from './companylogin/companylogin.component';
import { CompanyComponent } from './company/company.component';
import { JobsearchComponent } from './jobsearch/jobsearch.component';

@NgModule({
  declarations: [
    AppComponent,
    JobComponent,
    UserloginComponent,
    UserComponent,
    CompanyloginComponent,
    CompanyComponent,
    JobsearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
