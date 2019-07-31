import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';

@Component({
  selector: 'app-jobsearch',
  templateUrl: './jobsearch.component.html',
  styleUrls: ['./jobsearch.component.css']
})
export class JobsearchComponent implements OnInit {
  


  isJobFormValid:boolean
  invalidFormMessage:String

  selectJobId: number

  constructor(private jobsvc:JobService) { }


 

  ngOnInit() {
  }

  saveJob(index) {
    
  }



}
