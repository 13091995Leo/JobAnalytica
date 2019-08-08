import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';
import { JobsearchService } from '../jobsearch.service';

@Component({
  selector: 'app-jobsearch',
  templateUrl: './jobsearch.component.html',
  styleUrls: ['./jobsearch.component.css']
})
export class JobsearchComponent implements OnInit {

  searchParam: String

  jobId: number
  jobTitle: String
  location: String
  salary: number

  jobsObj: JobsearchComponent[]
  filterBySalaryParam: number;
  filterByLocationParam: String;
  filterByCompanyNameParam: String;
  isEditable: boolean;

  constructor(private jsrchSvc: JobsearchService) {
    this.searchParam = "Search Jobs"
    this.salary = 0
    this.location = ""
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

  filterBySalary() {
    this.jsrchSvc.findJobsBySearchParam(this.filterBySalaryParam).subscribe(
      response => {
        this.jobsObj = response
      }
    )
  }

  filterByLocation() {
    this.jsrchSvc.findJobsBySearchParam(this.filterByLocationParam).subscribe(
      response => {
        this.jobsObj = response
      }
    )
  }

  filterByCompanyName() {
    this.jsrchSvc.findJobsBySearchParam(this.filterByCompanyNameParam).subscribe(
      response => {
        this.jobsObj = response
      }
    )
  }

  addJobToUser(jid) {
    this.jsrchSvc.assignJobToUser(Number(sessionStorage.getItem("userId")),jid).subscribe(
      // response => {
      //   this.fetchCurrentUsersFromService()
      // }
    )
  }

 



}
