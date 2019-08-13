import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobComponent } from './job/job.component';
import { UserComponent } from './user/user.component';
import { User } from './user';
import { Requirement } from './requirement';

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
      "http://localhost:7705/users/displayAllUsers"
    )
  }

  // findUserByUserId(userId):Observable<UserComponent> {
  //   return this.httpsvc.get<UserComponent>(
  //     this.rootURL + "/find/" + userId
  //   )
  // }

  findUserByUserIdAndPwd(userId,userPassword):Observable<UserComponent> {
    return this.httpsvc.get<UserComponent>(
      this.rootURL + "/findUser?userId=" + userId + "&userPassword=" + userPassword
    )
  }



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

  deleteUserOnServer(userId):Observable<User> {
    return this.httpsvc.delete<User>(
      this.rootURL + "/delete/" + userId
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
      "http://localhost:7705/jobs/assign/users", reqBody, httpOptions
    )
  }

  removeJobFromUser(userId, jobId):Observable<JobComponent[]> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userId=" + userId + "&jobId=" +jobId
    return this.httpsvc.post<JobComponent[]>(
      "http://localhost:7705/jobs/remove/users", reqBody, httpOptions
    )
  }
  
  findJobByRequirementId(reqId):Observable<Requirement> {
    return this.httpsvc.get<Requirement>(
      "http://localhost:7705/requirements/find/" + reqId
    )
  }

  getAllRequirements():Observable<Requirement[]> {
    return this.httpsvc.get<Requirement[]>(
      "http://localhost:7705/requirements/displayAllRequirements"
    )
  }

  assignRequirementToUser(userId, requirementId):Observable<UserComponent[]> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userId=" + userId + "&specialityId=" + requirementId
    return this.httpsvc.post<UserComponent[]>(
      "http://localhost:7705/users/assign/speciality", reqBody, httpOptions
    )
  }

  removeRequirementFromUser(userId, requirementId):Observable<UserComponent[]> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userId=" + userId + "&specialityId=" + requirementId
    return this.httpsvc.post<UserComponent[]>(
      "http://localhost:7705/users/remove/speciality", reqBody, httpOptions
    )
  }

}
