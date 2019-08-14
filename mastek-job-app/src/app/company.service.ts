import { Injectable } from '@angular/core';
import { CompanyComponent } from './company/company.component';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Company } from './company';
import { Job } from './job';


@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  rootURL:string
  
  constructor(private httpsvc:HttpClient) {

    this.rootURL="http://localhost:7705/companies"

  }

  loadAllCompaniesFromServer():Observable<Company[]> {
    return this.httpsvc.get<Company[]>(
      this.rootURL + "displayAllCompanies"
    )
  }

  findCompanyByCompanyId(companyId):Observable<Company> {
    return this.httpsvc.get<Company>(
      this.rootURL + "/find/" + companyId
    )
  }

  updateCompanyOnServer(companyId, companyName, location, industry, companyPassword):Observable<Company> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "companyId=" + companyId + "&companyName=" + companyName + "&location=" + location + "&industry=" + industry +  "&companyPassword=" + companyPassword
    return this.httpsvc.post<Company>(
      this.rootURL + "/register", reqBody, httpOptions
    )
  }

  deleteCompanyOnServer(compId):Observable<Company> {
    return this.httpsvc.delete<Company>(
      this.rootURL + "/delete/" + compId
    )
  }

  // private extractData(res: Response) {
  //   let body = res;
  //   return body || { };
  // }
  
  // const endpoint = 'http://localhost:7705/api/v1/';
  //   const httpOptions = {
  //     headers: new HttpHeaders({
  //     })
  //   };


  //   getJobs(): Observable<any> {
  //     return this.http.get(endpoint + 'jobs').pipe(
  //       map(this.extractData));
  //   }
    
  //   getJob(id): Observable<any> {
  //     return this.http.get(endpoint + 'jobs/' + id).pipe(
  //       map(this.extractData));
  //   }
    
  //   addJob (job): Observable<any> {
  //     console.log(job;
  //     return this.http.post<any>(endpoint + 'jobs', JSON.stringify(job), httpOptions).pipe(
  //       tap((job) => console.log(`added job w/ id=${job.id}`)),
  //       catchError(this.handleError<any>('addJob'))
  //     );
  //   }
    
  //   updateJob (id, job): Observable<any> {
  //     return this.http.put(endpoint + 'jobs/' + id, JSON.stringify(job), httpOptions).pipe(
  //       tap(_ => console.log(`updated job id=${id}`)),
  //       catchError(this.handleError<any>('updateJob'))
  //     );
  //   }
    
  //   deleteJob (id): Observable<any> {
  //     return this.http.delete<any>(endpoint + 'jobs/' + id, httpOptions).pipe(
  //       tap(_ => console.log(`deleted job id=${id}`)),
  //       catchError(this.handleError<any>('deleteJob'))
  //     );
  //   }


  // postJob(model:any)
  // {
  //   return this.http.post("http://localhost:7705/api/values",model)
  //   .map(res=>res.json());
  // }

//   save(job: Job): Observable<Job> {
//     if (job.jobId === null) {
//       return this.httpClient.post<Job>('http://localhost:3000/jobs',
//       job, {
//           headers: new HttpHeaders({
//               'Content-Type': 'application/json'
//           })
//       })
//       .pipe(catchError(this.handleError));
// } else {
//   const foundIndex =
//       this.listJobs.findIndex(e => e.id === job.id);

//   this.listJobs[foundIndex] = job;
// }
// }


  findJobByJobId(jobId):Observable<CompanyComponent>{
    return this.httpsvc.get<CompanyComponent>(
                 this.rootURL+"/find/"+jobId)
  }

 updateJobOnServer(job):Observable<CompanyComponent>{
    const httpOptions= {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    var reqBody = "jobid=" + job.jobId + "&jobTitle=" + job.jobTitle + "&salary=" + job.salary + "&location=" + job.location
    // post(URL.body.httpOptionswithHeaders)
    return this.httpsvc.post<CompanyComponent>(
      "http://localhost:7705/jobs/register", reqBody, httpOptions)
    }

  loadAllJobsFromServer():Observable<Job[]>{
    return this.httpsvc.get<Job[]>(
      "http://localhost:7705/jobs/displayAllJobs"
    )
  }

  createNewJob(jobTitle, salary, location, companyId):Observable<Job>{
    const httpOptions = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    var reqBody = "jobTitle=" + jobTitle + "&salary=" + salary + "&location=" + location

    return this.httpsvc.post<Job>(
      "http://localhost:7705/jobs/register/" + companyId, reqBody, httpOptions
    )
  }

  // assignJobToCompany(companyId, jobId):Observable<Job>{
  //   const httpOptions = {
  //     headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
  //   }
  //   var reqBody = "companyId=" + companyId + "&jobId="+jobId

  //   // post(URL.body.httpOptionswithHeaders)
  //   return this.httpsvc.post<Job>(
  //     this.rootURL + "/assign/jobs",reqBody, httpOptions)
  
  // }

  deleteJobOnServer(jobId):Observable<CompanyComponent[]>{
    return this.httpsvc.delete<CompanyComponent[]>(
      "http://localhost:7705/jobs/delete/"+jobId)
    }

  getJobsByCompanyId(compId):Observable<Job[]>{
    return this.httpsvc.get<Job[]>(
      "http://localhost:7705/jobs/fetchJobsByCompanyId?companyId=" + compId
    )
  }
  

}

