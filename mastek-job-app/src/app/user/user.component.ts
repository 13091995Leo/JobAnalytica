import { Component, OnInit } from '@angular/core';
import { JobComponent } from '../job/job.component';
import { UserService } from '../user.service';
import { Job } from '../job';
import { Requirement } from '../requirement';
import { User } from '../user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

  userId: number
  userName: String
  userPassword: String
  locationPreference: String

  allUsers: User[]
  userSpeciality: Requirement[]
  selectUserId: number

  recommendations: Job[]

  group: Job[]
  selectJobId: number

  isEditable: boolean

  constructor(private userSvc:UserService) {
    this.userId = Number(localStorage.getItem("userId"))
    // this.userName = localStorage.getItem("userName")
    // this.locationPref = localStorage.getItem("locationPref")
    // this.recommendations = [
    //   // {jobId:2, jobTitle:"CSS Assistant", location:"Cornwall", salary:90000},
    //   // {jobId:9, jobTitle:"Angular Specialist", location:"Essex", salary:80000}
    // ]
    // this.recommendations = this.loadAllJobs()
   }

  ngOnInit() {
    this.fetchCurrentUserFromService()
    // localStorage.setItem("userId", "21")
    // localStorage.setItem("userName", "Hollie Jules Reed")
    // localStorage.setItem("locationPref", "London")
  }

  fetchCurrentUserFromService() {
    this.userSvc.findUserByUserId(this.userId).subscribe(
      response => {
        this.userId = response.userId
        this.userName = response.userName
        this.locationPreference = response.locationPreference
        // this.userPassword = response.userPassword
        //this.recommendations = response.recommendations
        this.group = response.group
        this.userSpeciality = response.userSpeciality
      }
    )
  }

  toggleEdits() {
    this.isEditable = !this.isEditable
    this.loadAllUsers()
  }

  loadAllUsers() {
    this.userSvc.loadAllUsersFromServer().subscribe(
      response => {
        this.allUsers = response
      }
    )
  }

  updateUserSelection(id) {
    this.selectUserId = id
    // localStorage.setItem("userId", String(id))
    this.userId = id
    this.fetchCurrentUserFromService()
  }

  updateUserDetails() {
    this.userSvc.updateUserOnServer({
      userId:this.userId, userName:this.userName, userPassword:this.userPassword, locationPreference:this.locationPreference
    }).subscribe(
      response => {
        this.fetchCurrentUserFromService
      }
    )
  }

  deleteRecJob(index) {
    this.recommendations.splice(index, 1)
  }

  deleteSaveJob(index, jid) {
    this.group.splice(index, 1)
    this.userSvc.removeJobFromUser(Number(localStorage.getItem("userId")), jid).subscribe(
      response => {
        this.fetchCurrentUserFromService()
      }
    )
  }

  updateSelectedJobId(jid) {
    this.selectJobId = jid
  }

  assignNewJob() {
    this.userSvc.assignJobToUser(this.userId, this.selectJobId).subscribe(
      response => {
        this.fetchCurrentUserFromService()
      }
    )
  }

  loadJobsByRequirement(reqId) {
    
  }

  getRecommendedJobs() {
    for (let u of this.userSpeciality) {
      this.loadJobsByRequirement(u.requirementId)
    }
  }

}
