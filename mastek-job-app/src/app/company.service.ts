import { Injectable } from '@angular/core';
import { CompanyComponent } from './company/company.component';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Company } from './company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  rootURL:string
  
  constructor(private httpsvc:HttpClient) {

  this.rootURL="http://localhost:4200/companyPage"
  }

  updateJobOnServer(job):Observable<CompanyComponent>{
    const httpOptions = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    var reqBody = "jobtitle="+
    job.jobtitle+"&salary="+job.salary

    // post(URL.body.httpOptionswithHeaders)
    return this.httpsvc.post<CompanyComponent>(
    this.rootURL+"/register",
    reqBody, httpOptions)
  
  }

  loadAllJobsFromServer():Observable<Company[]>{
    return this.httpsvc.get<Company[]>(
      "http://localhost:7700/job/list"
    )
  }

}

