import { Routes } from '@angular/router';
import { ExchangeRatesComponent } from "./exchange-rates/exchange-rates.component";
import { ExchangeRateDetailComponent } from "./exchange-rate-detail/exchange-rate-detail.component";

export const routes: Routes = [
  {path: '', redirectTo: 'exchange-rates', pathMatch: 'full'},
  {path: 'exchange-rates', component: ExchangeRatesComponent},
  {path: 'exchange-rate-detail', component: ExchangeRateDetailComponent}
];
