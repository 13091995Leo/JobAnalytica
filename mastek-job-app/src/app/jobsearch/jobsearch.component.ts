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

  constructor(private jsrchSvc:JobsearchService) { 
    this.searchParam = ""
  }

  ngOnInit() {
    this.fetchJobsBySearchParam()
  }

  fetchJobsBySearchParam(){
    this.jsrchSvc.findJobsBySearchParam(this.searchParam).subscribe(
      response => {
        this.jobsObj = response
      }
    )
  }

 



}
