import { TestBed } from '@angular/core/testing';

import { CompanyloginService } from './companylogin.service';

describe('CompanyloginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CompanyloginService = TestBed.get(CompanyloginService);
    expect(service).toBeTruthy();
  });
});
