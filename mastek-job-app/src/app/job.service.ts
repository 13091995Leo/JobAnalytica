import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobComponent } from './job/job.component';
import { User } from './user';
import { Company } from './company';


    Injectable({ //ensures that service can be used by multiple components on declaration in constructor
      providedIn: 'root' //its available in all components on current module
    })
    export class JobService {
      rootURL:string //identify root URL of the service
      //declare Http Client object to connect to service
      constructor(private httpsvc:HttpClient) { 
        // initialise the URL
        this.rootURL="http://localhost:7700/jobs"
      }
      // we use Observable to manage HTTP Communication as helper class
    
      // for each operation identify the parameters
      //identify the type of response object
      findJobByJobId(jobId):Observable<JobComponent>{
        return this.httpsvc.get<JobComponent>(this.rootURL+"/find/"+jobId)
      }
    
      updateJobOnServer(job):Observable<JobComponent>{
        const httpOptions={
          headers: new HttpHeaders(
            {"Content-Type":"application/x-www-form-urlencoded"})
        }
    
        var reqBody = "jobId="+job.jobId+"&jobTitle="+job.jobTitle+"&salary="+job.salary    
    
        return this.httpsvc.post<JobComponent>(this.rootURL+"/register",reqBody, httpOptions)
    
      }
    
      loadAllCompanysFromServer():Observable<User[]>{
        return this.httpsvc.get<Company[]>("http://localhost:7700/company/list")
      }
    
      assignJobToUser(jobId, userId):Observable<User[]>{
    
        const httpOptions={
          headers: new HttpHeaders(
            {"Content-Type":"application/x-www-form-urlencoded"}
          )
        }
    
        var reqBody = "jobId="+jobId+"&userId=" +userId
        console.log(reqBody)
        return this.httpsvc.post<User[]>(this.rootURL+"/assign/user", reqBody, httpOptions)
      }
      
      updateJobCompanyOnServer(jobId, companyId):Observable<JobComponent>{
        const httpOptions={
          headers: new HttpHeaders(
            {"Content-Type":"application/x-www-form-urlencoded"})
          }
    
        var reqBody = "jobId=" + jobId + "&companyId=" + companyId  
    
        return this.httpsvc.post<JobComponent>(
             this.rootURL+"/assign/company", reqBody, httpOptions
          )
      }
    
      loadAllPUsersFromServer():Observable<User[]>{
        return this.httpsvc.get<User[]>("http://localhost:7700/user/list")
      }
    
      
      
    
      
    
    }

  
