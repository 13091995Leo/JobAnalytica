import { TestBed } from '@angular/core/testing';

import { JobsearchService } from './jobsearch.service';

describe('JobsearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JobsearchService = TestBed.get(JobsearchService);
    expect(service).toBeTruthy();
  });
});
