import { Component, OnInit } from '@angular/core';
import { JobComponent } from '../job/job.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  recommendations: JobComponent[]

  savedJobs: JobComponent[]
  selectJobId: number

  constructor() {
    this.recommendations = [{},{}]
   }

  ngOnInit() {
  }

  deleteJob(index) {
    this.recommendations.splice(index, 1)
  }

  updateSelectedJobId(jid) {
    this.selectJobId = jid
  }

  loadAllJobs() {
    this.userSvc
  }


}
