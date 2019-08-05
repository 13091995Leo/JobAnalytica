import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobComponent } from './job/job.component';
import { UserComponent } from './user/user.component';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  rootURL: String

  constructor(private httpsvc:HttpClient) { 
    this.rootURL="http://localhost:7705/users"
  }

  loadAllUsersFromServer():Observable<User[]> {
    return this.httpsvc.get<User[]>(
      "http://localhost7705/users/displayAllUsers"
    )
  }

  findUserByUserId(userId):Observable<UserComponent> {
    return this.httpsvc.get<UserComponent>(
      this.rootURL + "/find/" + userId
    )
  }

  // getRecommendedJobs(skill):Observable<UserComponent> {
  //   return this.http
  // }

  updateUserOnServer(user):Observable<UserComponent> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userId=" + user.userId + "&userName=" + user.userName + "&locationPreference=" + user.locationPreference + "&userPassword=" + user.password
    return this.httpsvc.post<UserComponent>(
      this.rootURL + "/register", reqBody, httpOptions
    )
  }

  loadAllJobsFromServer():Observable<JobComponent[]> {
    return this.httpsvc.get<JobComponent[]>(
      "http://localhost:7705/jobs/list"
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
      this.rootURL + "/assign/job", reqBody, httpOptions
    )
  }

  

}
