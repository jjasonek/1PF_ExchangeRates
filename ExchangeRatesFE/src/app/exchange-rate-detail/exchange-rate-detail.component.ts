import {Component} from '@angular/core';
import {MatList, MatListItem} from "@angular/material/list";
import {ExchangeRate} from '../model/exchange-rate'
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-exchange-rate-detail',
  standalone: true,
  imports: [
    MatList,
    MatListItem,
    RouterLink
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
