import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';
import { JobsearchService } from '../jobsearch.service';
import { Company } from '../company';

@Component({
  selector: 'app-jobsearch',
  templateUrl: './jobsearch.component.html',
  styleUrls: ['./jobsearch.component.css']
})
export class JobsearchComponent implements OnInit {

  items = [];
  pageOfItems: Array<any>;



  searchParam: String

  jobId: number
  jobTitle: String
  location: String
  salary: number
  salaryParam: number
  averageSalary: number

  start: number
  end:number


  jobsObj: JobsearchComponent[]
  jobs1: JobsearchComponent[]
  jobs2: JobsearchComponent[]
  filterBySalaryParam: number;
  filterByLocationParam: String;
  filterByCompanyNameParam: String;
  isEditable: boolean;

  currentCompany: Company
  resultsLength: number;

  constructor(private jsrchSvc: JobsearchService) {
    this.searchParam = ""
    this.salary = 0
    this.location = ""
  }

  ngOnInit() {
    this.fetchJobsBySearchParam()

  }

  toggleEdits() {
    this.isEditable = !this.isEditable
  }

  fetchJobsBySearchParam() {
    this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
      response => {
        this.jobsObj = response
        this.resultsLength = response.length
      }
    )

  }

  filter(filterBySalaryParam, filterByLocationParam, filterByCompanyNameParam) {

    this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
      response => {
        this.jobsObj = response
          .filter(response => filterBySalaryParam == null || (response.salary == filterBySalaryParam || response.salary > filterBySalaryParam-1) )
          .filter(response => filterByLocationParam == null || response.location == filterByLocationParam)
          .filter(response => filterByCompanyNameParam == null || response.currentCompany.companyName == filterByCompanyNameParam)
        this.resultsLength = response.length
      }
    )
    filterBySalaryParam = null 
    filterByLocationParam = null
    filterByCompanyNameParam = null
  }


  addJobToUser(jid) {
    this.jsrchSvc.assignJobToUser(Number(localStorage.getItem("userId")), jid).subscribe(
      // response => {
      //   this.fetchCurrentUsersFromService()
      // }
    )
  }

  paginationIncrease(pageOfItems: Array<any>){
    this.pageOfItems = pageOfItems
  }



}
