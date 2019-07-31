import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Company } from '../company';
import { JobService } from '../job.service';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {

  jobId: number
  jobTitle: string
  requirements: string
  salary: number
  location: string
  currentCompany: Company
  assignments: User[]
  isEditable:boolean
  isProjectFormVisible: boolean

  isProjectFormValid: boolean
  invalidFormMessage:String

  allCompanys:Company[]
  selectedCompanyId:number

  allUsers:User[]
  selectedUserId:number
  constructor(private jobSvc:JobService) {
    this.jobId = 1
    this.jobTitle="Front End Developer"
    this.requirements="Java, HTML, MySQL"
    this.salary=35000

    this.currentCompany ={
      companyId: 12,
      companyName: "Pepsicocacola",
      location: "Afghanistan"
    }

    this.assignments = [
      {userId:22, userName:"Triple H", locationPreference:"Cuba", speciality:"AngularJS"},  
      {userId:23, userName:"Kim Jong Un", locationPreference:"North Korea", speciality:"Lambda"}
    ]
  }
  
  
  ngOnInit() {
    //this will be called by angular after object creation

    //subscribe observable call and wait for the response
    this.fetchCurrentEmployeeFromService()
    }
    fetchCurrentJobFromService(){
    this.jobSvc.findJobByJobId(this.jobId).subscribe(
      //use the response to initialise the component properties
      response => { //assign the data recived from the server as response to the current component
        this.jobId = response.jobId
        this.jobTitle = response.name
        this.salary = response.salary
        this.currentDepartment = response.currentDepartment
        this.assignments = response.assignments
      }
    )
    }
  }
}