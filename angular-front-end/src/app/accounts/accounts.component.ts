import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-accounts',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{
  accounts : any
  constructor(private http : HttpClient) {

    }
 ngOnInit() {
      this.http.get(`${environment.apiBaseUrl}/ACCOUNT-SERVICE/accounts`)
          .subscribe({
            next : (data:any) =>  {
                 this.accounts = data;
              },
            error : (err:any) => {
                 console.log(err);
            }
       });
 }
}
