import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  apiURL: string = 'http://localhost:8080/user/';

  constructor(private httpClient: HttpClient) { }

  public createEmployee(employee: Employee) {
    return this.httpClient.post(`${this.apiURL}/createUser`, employee);
  }

  public getEmployees() {
    return this.httpClient.get<Employee[]>(`${this.apiURL}/getUser`);
  }
}
