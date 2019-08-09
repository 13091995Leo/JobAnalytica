import { Injectable } from '@angular/core';
import { Requirement } from './requirement';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { UserComponent } from './user/user.component';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  rootURL: String

  constructor(private httpsvc:HttpClient) { 

    this.rootURL = "http://localhost:7705/userlogin"

  }

  getAllRequirements():Observable<Requirement[]> {
    return this.httpsvc.get<Requirement[]>(
      this.rootURL = "http://localhost:7705/requirements/displayAllRequirements"
    )
  }

  createNewUser(userName, locationPreference, userPassword):Observable<UserComponent> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "userName=" + userName + "&locationPreference=" + locationPreference + "&userPassword=" + userPassword
    return this.httpsvc.post<UserComponent>(
      "http://localhost:7705/users/register", reqBody, httpOptions
    )
  }
}
