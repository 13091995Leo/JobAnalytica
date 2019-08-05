import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';
import { JobsearchService } from '../jobsearch.service';

@Component({
  selector: 'app-jobsearch',
  templateUrl: './jobsearch.component.html',
  styleUrls: ['./jobsearch.component.css']
})
export class JobsearchComponent implements OnInit {
  
  searchParam : String

  jobId : number
  jobTitle: String
  location : String
  requirements: String
  salary: number

  jobsObj : JobsearchComponent[]

  isEditable: boolean

  constructor(private jsrchSvc:JobsearchService) { 
    this.searchParam = ""
  }

  ngOnInit() {
    this.fetchJobsBySearchParam()
  }

  toggleEdits() {
    this.isEditable = !this.isEditable
  }

  fetchJobsBySearchParam(){
    this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
      response => {
        this.jobsObj = response
      }
    )
  }

  addJobToUser(jid) {
    this.jsrchSvc.assignJobToUser(Number(localStorage.getItem("userId")),jid).subscribe(
      // response => {
      //   this.fetchCurrentUsersFromService()
      // }
    )
  }

 



}
