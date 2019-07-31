import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';

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

  constructor(private jobsvc:JobService) {

  this.jobId = 1
  this.jobTitle = "IT Admin Assistant"
  this.salary = 14000
  this.location = "London"
  // this.isProjectFormValid=true



   }

  ngOnInit() {
  }

}
