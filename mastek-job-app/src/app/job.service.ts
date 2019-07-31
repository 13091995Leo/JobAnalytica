import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  rootURL: String

  constructor(private httpsvc:HttpClient) {

    this.rootURL="http://localhost:7700/jobs"

  } 

  
  

  

  
}
