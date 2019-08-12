import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { CompanyService } from '../company.service';
import { Job } from '../job';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companyId: Number
  companyName: String
  companyLocation: String
  industry: String
  companyPassword: String
  allCompanies: Company[]

  jobId: number
  jobTitle: string
  location: string
  salary: number
  assignments: Job[]
  isJobFormVisible:boolean

  isJobFormValid:boolean
  invalidFormMessage:String

  allCompanyJobs: Job[]

  allJobs: Job[]
  selectJobId:number
  selectCompanyId: number

  isEditable: boolean
  jobIsEditable: boolean

  constructor(private companysvc:CompanyService) {
    this.companyId = Number(sessionStorage.getItem("companyId"))

    // this.isEditable=false
    // this.isJobFormVisible=false
    // this.isJobFormValid=true
    // this.jobId = 3883
    // this.jobTitle = "IT Admin Assistant"
    // this.salary = 14000
    // this.location = "London"

  // this.assignments = [
  //   {jobId:15, jobTitle: "Senior Java Developer", salary: 40000, location:"London"},
  //   {jobId:16, jobTitle: "Junior Java Developer", salary: 30000, location:"London"},
  //   {jobId:3884, jobTitle: "Admin Assistant", salary: 20000, location:"Leeds"}
  // ]

  }

  ngOnInit() {
    //this.fetchCurrentJobFromService()
    this.loadAllCompanyJobs()
    this.companyId = Number(sessionStorage.getItem("companyId"))
    this.fetchCurrentCompanyFromService()
    console.log(this.companyLocation)
  }

  fetchCurrentCompanyFromService():Observable<Company> {
    this.companysvc.findCompanyByCompanyId(this.companyId).subscribe(
      response => {
        this.companyId = response.companyId
        this.companyName = response.companyName
        this.companyLocation = response.location
        this.industry = response.industry
        this.companyPassword = response.companyPassword
      }
    )
    return
  }

  loadAllUsers() {
    this.companysvc.loadAllCompaniesFromServer().subscribe(
      response => {
        this.allCompanies = response
      }
    )
  }

  updateCompanySelection(id) {
    this.selectCompanyId = id
    // localStorage.setItem("userId", String(id))
    this.companyId = id
    this.fetchCurrentCompanyFromService()
  }

  updateCompanyDetails() {
    this.companysvc.updateCompanyOnServer({
      companyId:this.companyId, companyName:this.companyName, companyPassword:this.companyPassword, companyLocation:this.companyLocation, industry:this.industry
    }).subscribe(
      response => {
        this.fetchCurrentCompanyFromService
      }
    )
  }

  deleteCompany() {
    this.companysvc.deleteCompanyOnServer(Number(sessionStorage.getItem("companyId"))).subscribe()
    sessionStorage.setItem("companyId", "0")
  }

  fetchCurrentJobFromService(){
    this.companysvc.findJobByJobId(this.jobId).subscribe(
      response => {
        this.jobId=response.jobId
        this.jobTitle=response.jobTitle
        this.salary=response.salary
        this.location=response.location
        this.allJobs=response.allJobs
      }
    )
  }

  deleteJob(index, jid){
    //deletes 1 element from the index specified 
    this.allCompanyJobs.splice(index,1)
    this.companysvc.deleteJobOnServer(jid).subscribe(
      response => {
        this.fetchCurrentJobFromService()
      }
    )
   }

  updateSelectedJobId(jbid){
    this.selectJobId=jbid
  }

  assignNewJob(){
    this.companysvc.assignJobToCompany(this.jobId).subscribe(
      response =>{
        this.fetchCurrentJobFromService()
      }
    )
    this.isJobFormVisible=false
  }

  showJobForm(){
    this.isJobFormVisible=true
          //load all the projects from the server
       
    this.loadAllJobs()
  }
        
  loadAllJobs(){
    this.companysvc.loadAllJobsFromServer().subscribe(
      response =>{
          this.allJobs = response
      })
  }

  loadAllCompanyJobs() {
    this.companysvc.getJobsByCompanyId(Number(sessionStorage.getItem("companyId"))).subscribe(
      response => {
        this.allCompanyJobs = response
      }
    )
  }
  
  toggleEdits(){
    this.isEditable = !this.isEditable
    this.updateJobDetails()
    this.loadAllJobs()
  }

  toggleJobEdits(){
    this.jobIsEditable = !this.jobIsEditable
  }
        
  updateJobDetails(){
    this.companysvc.updateJobOnServer({jobId:this.jobId, jobTitle:this.jobTitle, salary:this.salary, location:this.location}).subscribe(
      response => { // perform the following operation on successful post
        this.companysvc.updateJobOnServer(this.jobId).subscribe(
          response =>{
            this.fetchCurrentJobFromService()
          })
      })
  }

}