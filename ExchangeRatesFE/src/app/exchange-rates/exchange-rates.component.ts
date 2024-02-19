import {Component} from '@angular/core';
import {ExchangeRatesService} from "../service/exchange-rates.service";
import {ExchangeRate} from "../model/exchange-rate";
import {DatePipe, NgForOf} from "@angular/common";

@Component({
  selector: 'app-exchange-rates',
  standalone: true,
  imports: [
    NgForOf,
    DatePipe
  ],
  templateUrl: './exchange-rates.component.html',
  styleUrl: './exchange-rates.component.css'
})
export class ExchangeRatesComponent {

  constructor(private exchangeRatesService: ExchangeRatesService) {
  }


  externalAddress: string = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
  beAppAddress: string = "";

  exchangeRates: ExchangeRate[] = [];

  fetchResponse(address: string) {
    this.exchangeRatesService.getExchangeRates(address)
      .subscribe(rates => this.exchangeRates = rates.body? rates.body : [])
  }
}
