import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Company } from './company';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyloginService {

  rootURL: String

  constructor(private httpsvc:HttpClient) { 
    this.rootURL = "http://localhost:7705/companyLogin"
  }

  createNewCompany(companyName, location, industry, companyPassword):Observable<Company>{
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "companyName=" + companyName + "&location=" + location + "&industry=" + industry + "&companyPassword=" + companyPassword
    return this.httpsvc.post<Company>(
      "http://localhost:7705/companies/register", reqBody, httpOptions
    )
  }

}
