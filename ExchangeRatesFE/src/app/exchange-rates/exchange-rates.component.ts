import {Component} from '@angular/core';
import {ExchangeRatesService} from "../service/exchange-rates.service";
import {ExchangeRate} from "../model/exchange-rate";
import {DatePipe, NgForOf} from "@angular/common";
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable
} from "@angular/material/table";
import {ExchangeRateDetailComponent} from "../exchange-rate-detail/exchange-rate-detail.component";

@Component({
  selector: 'app-exchange-rates',
  standalone: true,
  imports: [
    NgForOf,
    DatePipe,
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderCellDef,
    MatCell,
    MatCellDef,
    MatHeaderRow,
    MatRow,
    MatRowDef,
    MatHeaderRowDef,
    ExchangeRateDetailComponent,
    RouterLink,
    RouterOutlet,
  ],
  templateUrl: './exchange-rates.component.html',
  styleUrl: './exchange-rates.component.css'
})
export class ExchangeRatesComponent {

  constructor(
    private exchangeRatesService: ExchangeRatesService,
    private router: Router
  ) {
  }

  externalAddress: string = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
  beAppAddress: string = "";

  exchangeRates: ExchangeRate[] = [];
  displayedColumns: string[] = [
    'shortName',
    'validFrom',
    'name',
    'country',
    'move',
    'amount',
    'valBuy',
    'valSell',
    'valMid',
    'currBuy',
    'currSell',
    'currMid',
    'version',
    'cnbMid',
    'ecbMid',
    'button'
  ];

  fetchResponse(address: string) {
    this.exchangeRatesService.getExchangeRates(address)
      .subscribe(rates => this.exchangeRates = rates.body? rates.body : [])
  }

  detailButtonClick(exchangeRate: ExchangeRate) {
    this.router.navigate(['/exchange-rate-detail'], {
      state: {
        data: exchangeRate
      }
    });
  }
}
