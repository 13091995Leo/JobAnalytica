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
  richJob: Job[]
  
  reqIds: number[]
  requirementNameArray: String[]
  requirementMeanSalaryArray: number[]
  sumSalary: number
  individualCounter: number;
  individualCounter1: number;
  maxJ: number
  maxS: number
  indexPoint: number
  popularSkill: Stats[]
  richSkill: Stats[]
  indexPoint1: number;

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
            this.stats = {skill: element.requirement, avgSalaryBySkill: Math.round(this.sumSalary / this.individualCounter) , skillFreq: this.individualCounter,salaryIndex: 0, avgSalaryByIndustry: 0 }
            this.statsArr.push(this.stats)
        })
        
        // Working out the max number of jobs in a skill
        this.maxJ = this.statsArr[0].skillFreq

        for (let index = 1; index < this.statsArr.length; index++) {
          const element = this.statsArr[index].skillFreq
          if (element > this.maxJ) {
            this.maxJ = element
          }
          else {
            this.maxJ = this.maxJ
          }
        
        }
        console.log(this.statsArr)
        this.popularSkill = this.statsArr.filter(response => response.skillFreq == this.maxJ)

        // Working out the max salary for a skill
        this.maxS = this.statsArr[0].avgSalaryBySkill

        for (let index = 0; index < this.statsArr.length; index++) {
          const element = this.statsArr[index].avgSalaryBySkill
          if(element > this.maxS){
            this.maxS = element
          }
          else{
            this.maxS = this.maxS
          }
        }

        this.richSkill = this.statsArr.filter(response => response.avgSalaryBySkill == Math.round(this.maxS))

        // Working out the highest paid Jobs
        response.forEach(
          response => 
            this.richJob = response.jobRequirement.filter(
            element => 
            element.salary > 100000
          )
          )
      }
    )

  }


}
