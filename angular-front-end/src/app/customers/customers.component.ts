import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-customers',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
   customers : any;
  constructor(private http: HttpClient) {

  }
  ngOnInit() {
       this.http.get(`${environment.apiBaseUrl}/CUSTOMER-SERVICE/customers`)
       .subscribe({
         next : (data:any) =>  {
              this.customers = data;
           },
         error : (err:any) => {
              console.log(err);
         }
    });
}
}
