import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ExchangeRatesComponent} from "./exchange-rates/exchange-rates.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ExchangeRatesComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ExchangeRatesFE';
}
