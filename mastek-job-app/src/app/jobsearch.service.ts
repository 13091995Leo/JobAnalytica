import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobsearchComponent } from './jobsearch/jobsearch.component';
import { Job } from './job';
import { JobComponent } from './job/job.component';

@Injectable({
  providedIn: 'root'
})
export class JobsearchService {

  rootURL : String
  constructor(private httpsvc:HttpClient) { 
    this.rootURL = "http://localhost:7705/jobs"
  }

  findJobsBySearchParam(searchParam): Observable<JobsearchComponent[]>{
    return this.httpsvc.get<JobsearchComponent[]>(
      this.rootURL + "/fetchBySearchParam/?searchParam=" + searchParam
    )
  }

  assignJobToUser(userId, jobId):Observable<JobComponent[]> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userId=" + userId + "&jobId=" +jobId
    return this.httpsvc.post<JobComponent[]>(
      this.rootURL + "/assign/users", reqBody, httpOptions
    )
  }

}
