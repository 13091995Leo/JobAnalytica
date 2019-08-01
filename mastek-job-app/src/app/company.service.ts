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

  this.rootURL=" http://localhost:7705/jobs"
  }
  findJobByJobId(jobId):Observable<CompanyComponent>{
    return this.httpsvc.get<CompanyComponent>(
                 this.rootURL+"/users/find/"+jobId)
  }

 updateJobOnServer(job):Observable<CompanyComponent>{
    const httpOptions= {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    var reqBody = "jobid="+job.jobId+"&jobTitle="+
                    job.jobTitle+"&salary="+job.salary+"&location="+job.location
  
    // post(URL.body.httpOptionswithHeaders)
    return this.httpsvc.post<CompanyComponent>(
      this.rootURL+"/register",
      reqBody, httpOptions)
    }

loadAllJobsFromServer():Observable<Company[]>{
    return this.httpsvc.get<Company[]>(
      this.rootURL+"/displayAllJobs"
    )
  }
  assignJobToCompany(companyId, jobId):Observable<Company>{
    const httpOptions = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    var reqBody = "companyId="+companyId+"&jobId="+jobId

    // post(URL.body.httpOptionswithHeaders)
    return this.httpsvc.post<Company>(
    this.rootURL+"/register",reqBody, httpOptions)
  
  }

  

  

}

