import { Component, OnInit } from '@angular/core';
import { UserloginService } from '../userlogin.service';
import { Requirement } from '../requirement';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  userId: number
  userName: String
  userPassword: String

  allRequirements: Requirement[]

  invalidFormMessage: String

  isEditable: boolean

  constructor(private userSvc:UserloginService) {
    
  }

  ngOnInit() {
    this.isEditable = false
  }

  toggleEdits() {
    this.isEditable = !this.isEditable
    this.loadAllRequirements()
  }

  selectUserId(name) {
    this.userId = name
    localStorage.setItem("userId", String(name))

  }

  loadAllRequirements() {
    this.userSvc.getAllRequirements().subscribe(
      response => {
        this.allRequirements = response
      }
    )
  }

  addNewUser(userName, locationPreference, userPassword) {
    console.log(userName)
    this.userSvc.createNewUser(userName, locationPreference, userPassword).subscribe(
      // response => {
      //   localStorage.setItem("userId", response.userId)

      // }
    )
  }

}
