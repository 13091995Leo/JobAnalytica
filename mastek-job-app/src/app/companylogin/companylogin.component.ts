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
  companyPwd: String[]

  httpOption: String

  invalidFormMessage: String

  isEditable: boolean

  constructor(private compSvc: CompanyloginService) { }

  ngOnInit() {
    this.isEditable = false
    this.companyPwd = []
    this.companyPassword = ""


  }

  toggleEdits() {
    this.isEditable = !this.isEditable
  }

  selectCompanyId(companyId, companyPassword) {
    this.companyId = companyId
    this.companyPassword = companyPassword
    sessionStorage.setItem("companyId", String(companyId))
    sessionStorage.setItem("companyPassword",String(companyPassword))
    this.compSvc.getCompanyPassword(companyId).subscribe(
      response => {
        this.companyPwd = response
        if (this.companyPassword == this.companyPwd[0]) {
          this.httpOption = "/companyPage"
          sessionStorage.setItem("httpOption2",String(this.httpOption))
        }
        else {
          alert("Please enter valid login details")
          this.httpOption = "/companyLogin"
          sessionStorage.setItem("httpOption2",String(this.httpOption))
        }
      }
    )
    this.httpOption = sessionStorage.getItem("httpOption2")
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
