import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

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
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
