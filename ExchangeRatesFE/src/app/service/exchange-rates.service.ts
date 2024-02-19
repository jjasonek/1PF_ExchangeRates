import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse,} from '@angular/common/http';
import {ExchangeRate} from "../model/exchange-rate";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ExchangeRatesService {

  constructor(private http: HttpClient) {}

  public getExchangeRates(address: string): Observable<HttpResponse<ExchangeRate[]>> {
    return this.http.get<ExchangeRate[]>(address, {observe: 'response'});
  }
}
