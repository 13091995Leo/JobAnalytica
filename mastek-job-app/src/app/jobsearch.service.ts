import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobsearchComponent } from './jobsearch/jobsearch.component';

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

}
