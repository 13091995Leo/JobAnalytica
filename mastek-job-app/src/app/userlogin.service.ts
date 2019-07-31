import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  rootURL: String

  constructor() { 

    this.rootURL = "http://localhost:7700/userlogin"

  }
}
