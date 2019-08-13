import { Component, OnInit } from '@angular/core';
import { RequirementService } from '../requirement.service';

@Component({
  selector: 'app-requirement',
  templateUrl: './requirement.component.html',
  styleUrls: ['./requirement.component.css']
})
export class RequirementComponent implements OnInit {

  requirementId: number

  constructor(private reqSvc:RequirementService) { }

  ngOnInit() {
  }

}
