import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobComponent } from './job/job.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  rootURL: String

  constructor(private httpsvc:HttpClient) { 
    this.rootURL="http://localhost:7700/users"
  }

  loadAllJobsFromServer():Observable<JobComponent[]> {
    return this.httpsvc.get<JobComponent[]>(
      "http://localhost:7700/jobs/list"
    )
  }

  

}
