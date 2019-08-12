import { Component, OnInit } from '@angular/core';
import { StatsService } from '../stats.service';
import { Job } from '../job';
import { Stats } from '../stats';

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
  statsArr: Stats[]
  stats: Stats
  
  reqIds: number[]
  requirementNameArray: String[]
  requirementMeanSalaryArray: number[]
  sumSalary: number
  individualCounter: number;
  individualCounter1: number;
  max: number;
  indexPoint: number
  popularSkill: Stats[];

  constructor(private reqServ: StatsService) {

    this.reqIds = []
    this.requirementNameArray = []
    this.requirementMeanSalaryArray = []
    this.sumSalary = 0
    this.individualCounter = 0
    this.statsArr = []


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
            this.individualCounter += 1
          }
          )
            this.stats = {skill: element.requirement, avgSalaryBySkill: this.sumSalary / this.individualCounter , skillFreq: this.individualCounter, avgSalaryByIndustry: 0, mostSoughtAfterSkill: 0}
            this.statsArr.push(this.stats)
        })

        this.statsArr = this.statsArr
        
        this.max = this.statsArr[0].skillFreq;
        this.indexPoint = 0;

        for (let index = 1; index < this.statsArr.length; index++) {
          const element = this.statsArr[index].skillFreq;
          if (element > this.max) {
            this.max = element
            // this.indexPoint = index
          }
          else {
            this.max = this.max
            // this.indexPoint = this.indexPoint
          }
        
        }
        console.log(this.statsArr)
        this.popularSkill = this.statsArr.filter(response => response.skillFreq == this.max)
        // this.popularSkill = this.stats[this.indexPoint]
        // console.log(this.popularSkill)
        

        
        // response => filterByLocationParam == null || response.location == filterByLocationParam
        
      }
    )

  }


}
