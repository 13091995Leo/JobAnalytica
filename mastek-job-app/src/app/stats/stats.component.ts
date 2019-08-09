import { Component, OnInit } from '@angular/core';
import { StatsService } from '../stats.service';
import { Job } from '../job';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
  requirementId: number
  requirement: String
  reqObj: StatsComponent[]
  jobRequirement: Job[]
  
  reqIds: number[]
  requirementNameArray: String[]
  requirementMeanSalaryArray: number[]
  sumSalary: number
  individualCounter: number;

  constructor(private reqServ: StatsService) {

    this.reqIds = []
    this.requirementNameArray = []
    this.requirementMeanSalaryArray = []
    this.sumSalary = 0
    this.individualCounter = 0
  }

  ngOnInit() {
    this.getAllRequirementStats()
  }

  getAllRequirementStats() {
    
    this.reqServ.getAllRequirements().subscribe(
      response => {
        
        response.forEach(element => {
          this.requirementNameArray.push(element.requirement)
        })

        response.forEach(element => {
          this.reqIds.push(element.requirementId)
        })

        response.forEach( element => {
          element.jobRequirement.forEach(element => {
            this.sumSalary += element.salary
            this.individualCounter +=1
          }
          )
          this.requirementMeanSalaryArray.push(this.sumSalary / this.individualCounter)
          
        })

      }
    )

  }


}
