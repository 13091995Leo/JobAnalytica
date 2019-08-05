import { Component, OnInit } from '@angular/core';
import { UserloginService } from '../userlogin.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  userId: number
  userName: String
  userPassword: String

  invalidFormMessage: String

  constructor(private userSvc:UserloginService) {
     
  }

  ngOnInit() {
    
  }

  selectUserId(name) {
    this.userId = name
    localStorage.setItem("userId", String(name))

  }

}
