import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { CompanyService } from '../company.service';

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
  assignments: Company[]
  isJobFormVisible:boolean

  isJobFormValid:boolean
  invalidFormMessage:String

  allJobs:Company[]
  selectJobId:number

  constructor(private companysvc:CompanyService) {
  this.isEditable=false
  this.isJobFormVisible=false
  this.isJobFormValid=true
  this.jobId = 1
  this.jobTitle = "IT Admin Assistant"
  this.salary = 14000
  this.location = "London"

  this.assignments = [
    {jobId:15, jobTitle: "Senior Java Developer", salary: 40000, location:"London"},
    {jobId:16, jobTitle: "Junior Java Developer", salary: 30000, location:"London"}

  ]

  }

  ngOnInit() {
    
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
  
    else if(jbtitle.length<4){
      this.isJobFormValid=false
      this.invalidFormMessage="Job Title must be greater than 4 characters"
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

  toggleEdits(){
    this.isEditable = !this.isEditable
    // this.updateJobDetails()
    this.loadAllJobs()
  }

  loadAllJobs(){
    this.companysvc.loadAllJobsFromServer().subscribe(
      response =>{
        this.allJobs = response
      }
    )
  }

//   updateJobDetails(){
//     this.companysvc.updateJobOnServer({
//       jobId:this.jobId, jobTitle:this.jobTitle, salary:this.salary, location:this.location
//     }).subscribe(
//       response =>{ // perform the following operation on successful post
        
//           this.companysvc.updateJobOnServer(this.jobId).subscribe(
//         response =>{
//             this.fetchCurrentJobFromService()
//           }
//           )
//         }
//     )
//       }

//   )
//   this.isProjectFormVisible=false
// }  


showJobForm(){
    this.isJobFormVisible=true
        //load all the projects from the server
     
    this.loadAllJobs()
  }





}
