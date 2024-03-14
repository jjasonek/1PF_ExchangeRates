import { Component } from '@angular/core';
import { ExchangeRatesService } from "../service/exchange-rates.service";
import { ExchangeRate } from "../model/exchange-rate";
import { DatePipe, NgForOf } from "@angular/common";
import { Router, RouterOutlet } from '@angular/router';
import { MatTableModule } from "@angular/material/table";
import { ExchangeRateDetailComponent } from "../exchange-rate-detail/exchange-rate-detail.component";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatSelectModule } from "@angular/material/select";
import { SourceAddresse } from "../model/source-addresse";
import { FormsModule } from "@angular/forms";
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from "@angular/material/button";

@Component({
  selector: 'app-exchange-rates',
  standalone: true,
  imports: [
    NgForOf,
    DatePipe,
    MatTableModule,
    ExchangeRateDetailComponent,
    RouterOutlet,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    MatInputModule,
    MatButtonModule
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

  exchangeRates: ExchangeRate[] = [];
  sourceAddresses: SourceAddresse[] = [
    {
      value: "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e",
      viewValue: "External address"
    },
    {
      value: "/exchangerates/api/v1?useDb=false",
      viewValue: "Local Back End Application"
    },
    {
      value: "/exchangerates/api/v1?useDb=true",
      viewValue: "Local Back End Application with DB"
    }
  ]
  selectedAddress = this.sourceAddresses[0].value;
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

  fetchResponse() {
    this.exchangeRatesService.getExchangeRates(this.selectedAddress)
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
