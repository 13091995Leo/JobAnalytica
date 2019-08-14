import { Job } from './job';
import { Requirement } from './requirement';

export interface User {
    userId: number
    userName: String
    userPassword: String
    locationPreference: String
    group: Job[]
    userSpeciality: Requirement[]
}
