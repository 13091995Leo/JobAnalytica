import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from './job';
import { User } from './user';
import { Company } from './company';
import { Requirement } from './requirement';
import { JobComponent } from './job/job.component';
import { UserComponent } from './user/user.component';
import { CompanyComponent } from './company/company.component';
import { RequirementComponent } from './requirement/requirement.component';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  rootURL:string

  constructor(private httpsvc:HttpClient) {
    this.rootURL = "http://localhost:7705"
   }

   loadAllUsersFromServer():Observable<User[]>{
    return this.httpsvc.get<User[]>(
      this.rootURL+"/users/displayAllUsers"
    )
  }

  loadAllJobsFromServer():Observable<Job[]>{
    return this.httpsvc.get<Job[]>(
      this.rootURL+"/jobs/displayAllJobs"
    )
  }

  loadAllCompaniesFromServer():Observable<Company[]>{
    return this.httpsvc.get<Company[]>(
      this.rootURL+"/companies/displayAllCompanies"
    )
  }

  loadAllRequirementsFromServer():Observable<Requirement[]>{
    return this.httpsvc.get<Requirement[]>(
      this.rootURL+"/requirements/displayAllRequirements"
    )
  }

  deleteUserOnServer(userId):Observable<UserComponent[]>{
    return this.httpsvc.delete<UserComponent[]>(
      this.rootURL+"/users/delete/"+userId)
  }

  deleteJobOnServer(jobId):Observable<JobComponent[]>{
    return this.httpsvc.delete<JobComponent[]>(
      this.rootURL+"/jobs/delete/"+jobId)
  }

  deleteCompanyOnServer(companyId):Observable<CompanyComponent[]>{
    return this.httpsvc.delete<CompanyComponent[]>(
      this.rootURL+"/companies/delete/"+companyId)
  }

  deleteRequirementOnServer(requirementId):Observable<RequirementComponent[]>{
    return this.httpsvc.delete<RequirementComponent[]>(
      this.rootURL+"/requirements/delete/"+requirementId)
  }

  createNewRequirement(requirement):Observable<RequirementComponent>{
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "requirement=" + requirement
    return this.httpsvc.post<RequirementComponent>(
      this.rootURL+"/requirements/register", reqBody, httpOptions
    )
  }

  // addRequirementOnServer(req):Observable<RequirementComponent[]>{
  //   return this.httpsvc.post<RequirementComponent[]>(
  //     this.rootURL+"/requirements/delete/"+req)
  //   )
  // }
}
