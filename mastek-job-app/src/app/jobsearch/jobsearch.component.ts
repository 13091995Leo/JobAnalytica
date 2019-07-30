import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-jobsearch',
  templateUrl: './jobsearch.component.html',
  styleUrls: ['./jobsearch.component.css']
})
export class JobsearchComponent implements OnInit {
  jobid: number
  jobTitle: string
  requirements: string
  salary: number

  constructor() { }

  ngOnInit() {
  }

}
