import { Component } from '@angular/core';
import {MatList, MatListItem} from "@angular/material/list";

@Component({
  selector: 'app-exchange-rate-detail',
  standalone: true,
  imports: [
    MatList,
    MatListItem
  ],
  templateUrl: './exchange-rate-detail.component.html',
  styleUrl: './exchange-rate-detail.component.css'
})
export class ExchangeRateDetailComponent {

}
