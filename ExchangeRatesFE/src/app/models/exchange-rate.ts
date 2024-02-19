export interface ExchangeRate {
  shortName: string,
  validFrom: Date,
  name: string,
  country: string
  move: number,
  amount: number,
  valBuy: number,
  valSell: number,
  valMid: number,
  currBuy: number,
  currSell: number,
  currMid: number,
  version: number,
  cnbMid: number,
  ecbMid: number
}
