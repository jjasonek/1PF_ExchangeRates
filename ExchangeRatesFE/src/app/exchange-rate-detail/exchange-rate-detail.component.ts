import { Component } from '@angular/core';
import { MatListModule } from "@angular/material/list";
import { ExchangeRate } from '../model/exchange-rate'
import { Router, RouterLink } from "@angular/router";
import { MatButtonModule } from "@angular/material/button";

@Component({
  selector: 'app-exchange-rate-detail',
  standalone: true,
  imports: [
    MatListModule,
    RouterLink,
    MatButtonModule
  ],
  templateUrl: './exchange-rate-detail.component.html',
  styleUrl: './exchange-rate-detail.component.css'
})
export class ExchangeRateDetailComponent {
  constructor(private router: Router) {
    // @ts-ignore
    this.exchangeRate = this.router.getCurrentNavigation().extras.state.data;
  }

  exchangeRate: ExchangeRate
}
