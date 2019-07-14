import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee;

  constructor(private service: EmployeeService) { }

  ngOnInit() {
  }

  createEmployee(): void {
    this.service.createEmployee(this.employee).subscribe((res) => {
      console.log("Created a employee");
    });
  }

}
