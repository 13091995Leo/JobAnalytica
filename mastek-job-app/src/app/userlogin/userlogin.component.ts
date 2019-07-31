import { Component, OnInit } from '@angular/core';

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

  constructor() {
     
  }

  ngOnInit() {
    
  }

}
