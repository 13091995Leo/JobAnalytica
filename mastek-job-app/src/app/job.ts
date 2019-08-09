import { Company } from './company';

export interface Job {
    jobId: number
    jobTitle: String
    location: String
    salary: number
    currentCompany: Company
}
