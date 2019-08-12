import { Component, OnInit } from '@angular/core';
import { JobComponent } from '../job/job.component';
import { UserService } from '../user.service';
import { Job } from '../job';
import { Requirement } from '../requirement';
import { User } from '../user';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';
import { Observable } from 'rxjs';

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

  allRequirements: Requirement[]

  allUsers: User[]
  userSpeciality: Requirement[]
  selectUserId: number

  recommendations: Job[]
  jobRequirement: Job[]

  group: Job[]
  selectJobId: number

  isEditable: boolean

  constructor(private userSvc:UserService) {
    this.userId = Number(sessionStorage.getItem("userId"))
    // this.userId = Number(localStorage.getItem("userId"))
    // this.userName = localStorage.getItem("userName")
    // this.locationPref = localStorage.getItem("locationPref")
    // this.recommendations = [
    //   // {jobId:2, jobTitle:"CSS Assistant", location:"Cornwall", salary:90000},
    //   // {jobId:9, jobTitle:"Angular Specialist", location:"Essex", salary:80000}
    // ]
    // this.recommendations = this.loadAllJobs()
   }

  ngOnInit() {
    this.loadAllRequirements()
    this.userId = Number(sessionStorage.getItem("userId"))
    // this.userId = Number(localStorage.getItem("userId"))

    this.fetchCurrentUserFromService()
    // localStorage.setItem("userId", "21")
    // localStorage.setItem("userName", "Hollie Jules Reed")
    // localStorage.setItem("locationPref", "London")
  }

  fetchCurrentUserFromService():Observable<User> {
    this.userSvc.findUserByUserId(this.userId).subscribe(
      response => {
        this.userId = response.userId
        this.userName = response.userName
        this.locationPreference = response.locationPreference
        // this.userPassword = response.userPassword
        //this.recommendations = response.recommendations
        this.group = response.group
        this.userSpeciality = response.userSpeciality
        this.recommendations = []
        this.getRecommendedJobs()
        
        //this.jobRequirement = response.jobRequirement
      }
    )
    return 
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

  deleteUser() {
    this.userSvc.deleteUserOnServer(Number(sessionStorage.getItem("userId"))).subscribe()
    sessionStorage.setItem("userId", "0")
  }

  loadAllRequirements() {
    this.userSvc.getAllRequirements().subscribe(
      response => {
        this.allRequirements = response
        console.log(this.allRequirements.length)
        //console.log
      }
    )
  }

  addSkillToUser(reqId) {
    this.userSvc.assignRequirementToUser(Number(sessionStorage.getItem("userId")), reqId).subscribe(
      response => {
        this.fetchCurrentUserFromService()
        console.log("req: " + reqId)
      }
    )
  }

  deleteSkillFromUser(reqId) {
    this.userSvc.removeRequirementFromUser(Number(sessionStorage.getItem("userId")), reqId).subscribe(
      response => {
        this.fetchCurrentUserFromService()
      }
    )
  }

  deleteRecJob(index) {
    this.recommendations.splice(index, 1)
  }

  deleteSaveJob(index, jid) {
    this.group.splice(index, 1)
    // this.userSvc.removeJobFromUser(Number(localStorage.getItem("userId")), jid).subscribe(

    this.userSvc.removeJobFromUser(Number(sessionStorage.getItem("userId")), jid).subscribe(
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
    return this.userSvc.findJobByRequirementId(reqId).subscribe(
      response => {
        if (response.jobRequirement != null && !this.recommendations.some((obj) => obj.jobId == response.jobRequirement.jobId)) {
          console.log(response.jobRequirement)
          // this.recommendations.push(response.jobRequirement)
          Array.prototype.push.apply(this.recommendations, response.jobRequirement)
        }
        // Array.prototype.push.apply(this.recommendations, response.jobRequirement);
        // this.recommendations = this.recommendations.concat(response.jobRequirement)
      }
    )
  }

  getRecommendedJobs() {
    this.userSpeciality.forEach( u => {
      // this.recommendations.push((this.loadJobsByRequirement(u.requirementId)))
      this.loadJobsByRequirement(u.requirementId)
    })
    console.log("Recs " + this.recommendations)
  }

  addJobToUser(jid) {
    // this.userSvc.assignJobToUser(Number(localStorage.getItem("userId")),jid).subscribe(
    this.userSvc.assignJobToUser(Number(sessionStorage.getItem("userId")),jid).subscribe(

      // response => {
      //   this.fetchCurrentUsersFromService()
      // }
    )
  }

  editClick() {
    this.toggleEdits()
  }  

  saveClick(uName, locPref) {
    this.toggleEdits()
  }

}
