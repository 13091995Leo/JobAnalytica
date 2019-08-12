import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Job } from '../job';
import { Company } from '../company';
import { User } from '../user';
import { Requirement } from '../requirement';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  userId: number
  userName: string
  isUserFormVisible:boolean

  users: User[]

  jobId: number
  jobTitle: string
  isJobFormVisible:boolean

  jobs: Job[]

  companyId: number
  companyName: string
  isCompanyFormVisible:boolean

  companies: Company[]

  requirementId: number
  requirement: string
  isRequirementFormVisible:boolean

  requirements: Requirement[]

  isEditable:boolean

  

  constructor(private adminsvc:AdminService) { 
  this.isEditable=false
  this.isUserFormVisible=false
  this.isJobFormVisible=false
  this.isCompanyFormVisible=false
  this.isRequirementFormVisible=false
  }

  ngOnInit() {
    this.loadAllUsers()
    this.loadAllJobs()
    this.loadAllCompanies()
    this.loadAllRequirements()
 
  }

  loadAllUsers() {

    this.adminsvc.loadAllUsersFromServer().subscribe(
      response => {
        this.users = response
      }
    )
  }

  loadAllJobs() {

    this.adminsvc.loadAllJobsFromServer().subscribe(
      response => {
        this.jobs = response
      }
    )
  }

  loadAllCompanies() {

    this.adminsvc.loadAllCompaniesFromServer().subscribe(
      response => {
        this.companies = response
      }
    )
  }

  loadAllRequirements() {

    this.adminsvc.loadAllRequirementsFromServer().subscribe(
      response => {
        this.requirements = response
      }
    )
  }

  deleteUser(index, userId){
    //deletes 1 element from the index specified 
    this.users.splice(index,1)
    this.adminsvc.deleteUserOnServer(userId).subscribe()
  }

  deleteJob(index, jobId){
    //deletes 1 element from the index specified 
    this.jobs.splice(index,1)
    this.adminsvc.deleteJobOnServer(jobId).subscribe()
  }

  deleteCompany(index, companyId){
    //deletes 1 element from the index specified 
    this.companies.splice(index,1)
    this.adminsvc.deleteCompanyOnServer(companyId).subscribe()
  }

  deleteRequirement(index, requirementId){
    //deletes 1 element from the index specified 
    this.requirements.splice(index,1)
    this.adminsvc.deleteRequirementOnServer(requirementId).subscribe()
  }

  // addRequirement() {
  //   this.adminsvc.addRequirementOnServer(req)
  // }

}
