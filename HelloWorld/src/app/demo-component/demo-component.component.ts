import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-component',
  templateUrl: './demo-component.component.html',
  styleUrls: ['./demo-component.component.scss']
})
export class DemoComponentComponent implements OnInit {

  employee;
  color = "red";
  data = [
    {
      "id":1,"name":"Raj","salary":45000
    },
    {
      "id":2,"name":"Siya","salary":3300
    },
    {
      "id":3,"name":"Piya","salary":55000
    }
  ];
  constructor() { }

  ngOnInit(): void {
    this.employee =this.data;
  }

}
