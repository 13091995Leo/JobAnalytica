import { Component, OnInit } from '@angular/core';
import { CompanyloginService } from '../companylogin.service';

@Component({
  selector: 'app-companylogin',
  templateUrl: './companylogin.component.html',
  styleUrls: ['./companylogin.component.css']
})
export class CompanyloginComponent implements OnInit {

  companyId: Number
  companyName: String
  companyPassword: String
  industry: String
  location: String

  invalidFormMessage: String

  isEditable: boolean

  constructor(private compSvc:CompanyloginService) { }

  ngOnInit() {
    this.isEditable = false
  }

  toggleEdits() {
    this.isEditable = !this.isEditable
  }

  selectCompanyId(compName) {
    this.companyId = compName
    sessionStorage.setItem("companyId", String(compName))
  }

  addNewCompany(companyName, companyLocation, companyIndustry, companyPassword) {
    console.log(companyName)
    this.compSvc.createNewCompany(companyName, companyLocation, companyIndustry, companyPassword).subscribe(
      response => {
        sessionStorage.setItem("companyId", String(response.companyId))
      }
    )
  }

}
