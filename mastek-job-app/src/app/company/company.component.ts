import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { CompanyService } from '../company.service';
import { Job } from '../job';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  jobId: number
  jobTitle: string
  location: string
  salary: number
  isEditable:boolean
  assignments: Job[]
  isJobFormVisible:boolean

  isJobFormValid:boolean
  invalidFormMessage:String

  allJobs:Company[]
  selectJobId:number
  selectCompanyId: number

  constructor(private companysvc:CompanyService) {
  this.isEditable=false
  this.isJobFormVisible=false
  this.isJobFormValid=true
  this.jobId = 3883
  this.jobTitle = "IT Admin Assistant"
  this.salary = 14000
  this.location = "London"

  this.assignments = [
    {jobId:15, jobTitle: "Senior Java Developer", salary: 40000, location:"London"},
    {jobId:16, jobTitle: "Junior Java Developer", salary: 30000, location:"London"},
    {jobId:3884, jobTitle: "Admin Assistant", salary: 20000, location:"Leeds"}

  ]

  }

  ngOnInit() {
    //this.fetchCurrentJobFromService()
    this.loadAllJobs()
  }

  fetchCurrentJobFromService(){
    this.companysvc.findJobByJobId(this.jobId).subscribe(
      response => {
        this.jobId=response.jobId
        this.jobTitle=response.jobTitle
        this.salary=response.salary
        this.location=response.location
        this.assignments=response.assignments
      }
    )
  }

  deleteJob(index){
    //deletes 1 element from the index specified 
    this.assignments.splice(index,1)
   }

   addNewJob(jbid,jbtitle,sal,loc){
    if(isNaN(jbid))
  {
    this.isJobFormValid=false
    this.invalidFormMessage="Job ID must be a number"
  }

  else if(jbtitle.length<2){
    this.isJobFormValid=false
    this.invalidFormMessage="Job Title must be greater than 2 characters"
  }

  else{
    this.assignments.push({
    jobId:jbid,jobTitle:jbtitle,salary:sal,location:loc 
    })
    this.isJobFormVisible=false
    this.isJobFormValid=true
    this.invalidFormMessage=""
      }
}

updateSelectedJobId(jbid){
  this.selectJobId=jbid
}

assignNewJob(){
  this.companysvc.assignJobToCompany(
    this.jobId,this.selectJobId)
      .subscribe(
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
          this.companysvc.loadAllJobsFromServer()
          .subscribe(
            response =>{
          this.allJobs = response
            })
        }
        toggleEdits(){
          this.isEditable = !this.isEditable
          this.updateJobDetails()
          this.loadAllJobs()
          
        }
          // updateSelection(jobId){
          //   this.selectJobId=jobId
          // }
        
        updateJobDetails(){
            this.companysvc.updateJobOnServer({
              jobId:this.jobId, jobTitle:this.jobTitle, salary:this.salary, location:this.location
            }).subscribe(
              response =>{ // perform the following operation on successful post
                
                  this.companysvc.updateJobOnServer(this.jobId).subscribe(
                response =>{
                    this.fetchCurrentJobFromService()
                  }
                  )
                }
            )
              }
      
        
      }

