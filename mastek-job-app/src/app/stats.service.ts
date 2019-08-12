import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StatsComponent } from './stats/stats.component';



@Injectable({
  providedIn: 'root'
})
export class StatsService {

  rootURL:string
  
  constructor(private httpsvc:HttpClient) {
  this.rootURL=" http://localhost:7705/requirements"
  }

getArrayRequirementJobCompany(requirementId) : Observable<StatsComponent[]>{

  return this.httpsvc.get<StatsComponent[]>(
      this.rootURL + "/find/" + requirementId
  )
}

getAllRequirements() : Observable<StatsComponent[]>{

  return this.httpsvc.get<StatsComponent[]>(
      this.rootURL + "/displayAllRequirements"
  )
}

}

