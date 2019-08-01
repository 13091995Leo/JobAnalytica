import { Component, OnInit } from '@angular/core';
import { JobComponent } from '../job/job.component';
import { UserService } from '../user.service';
import { Job } from '../job';
import { Requirement } from '../requirement';

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
  userSpeciality: Requirement[]

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
    localStorage.setItem("userId", "12")
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

  deleteSaveJob(index) {
    this.group.splice(index, 1)
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

  // loadAllJobs() {
  //   this.userSvc.loadAllJobsFromServer().subscribe(
  //     response => {
  //       this.group = response
  //     }
  //   )
  // }

}
