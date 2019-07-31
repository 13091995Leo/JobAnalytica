import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit {
  

  isJobFormValid:boolean
  invalidFormMessage:String

  selectJobId: number

  constructor() { 
  
  
  
  }

  ngOnInit() {
  }


//     addNewJobListing(jobid,jobtitle,sal,loc){
//     if(isNaN(jobid))
//   {
//     this.isJobFormValid=false
//     this.invalidFormMessage="Job ID must be a number"
//   }
//     if(jobtitle.length<3){
//       this.isJobFormValid=false
//       this.invalidFormMessage="Job Title must be greater than 3 characters"
//     }
  
//     else{
//       this.JobsearchComponent.push({jobTitle:jobtitle,salary:sal,location:loc})
//       this.isJobFormVisible=false
//       this.isJobFormValid=true
//       this.invalidFormMessage=""
//         }



// }

updateSelectedJobId(jobid){
  this.selectJobId=jobid
}

// createNewJobListing(){
//   this.empSvc.assignProjectToEmployee(
//     this.empno,this.selectProjectId)
//     .subscribe(
//       response =>{
//         this.fetchCurrentEmployerFromService()
//       }

//   )
//   this.isProjectFormVisible=false
// }  


}