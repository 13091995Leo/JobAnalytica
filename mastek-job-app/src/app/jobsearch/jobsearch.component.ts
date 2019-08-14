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
  errorMessage: String



  jobsObj: JobsearchComponent[]

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
    this.errorMessage = ""
  }

  ngOnInit() {
    this.fetchJobsBySearchParam()

  }

  toggleEdits() {
    this.isEditable = !this.isEditable
  }

  fetchJobsBySearchParam() {
    this.errorMessage = ""
    
    this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
      response => {
          this.jobsObj = response
          this.resultsLength = response.length
          if (this.resultsLength == 0) {
            this.errorMessage = "No results - Please try a valid job field."
          } else {
            this.jobsObj = response
          }
      }
    )

}

  filter(filterBySalaryParam, filterByLocationParam, filterByCompanyNameParam) {

      this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
        response => {
          this.jobsObj = response
            .filter(response => filterBySalaryParam == null || response.salary == filterBySalaryParam )
            .filter(response => filterByLocationParam == null || response.location == filterByLocationParam)
            .filter(response => filterByCompanyNameParam == null || response.currentCompany.companyName == filterByCompanyNameParam)
            this.resultsLength = this.jobsObj.length
        }
      )
    
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
