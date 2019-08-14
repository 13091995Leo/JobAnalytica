import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  adminUserName: String
  adminPassword: String

  userNameInput: String
  passwordInput: String

  httpOption: String

  constructor() { }

  ngOnInit() {
    this.adminUserName = "masterAnalyst"
    this.adminPassword = "TLSJM"
  }

  validateAdmin(adminName, adminPassword) {
    this.userNameInput = adminName
    this.passwordInput = adminPassword
    if (this.adminUserName == this.userNameInput && this.adminPassword == this.passwordInput) {
      this.httpOption = "/adminPage"
    }
    else {
      alert("Please enter valid login details")
      this.httpOption = "/adminLogin"
    }
  }
}
