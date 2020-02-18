import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { MobilePhone } from '../model/mobilephone';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = 'http://localhost:8080';
  private ALL_STORE_MODELS_URL = `${this.BASE_URL}/mobiles`;

  constructor(private http: HttpClient) { }

  getAllModels(): Observable<MobilePhone[]>{
    return this.http.get<MobilePhone[]>(this.ALL_STORE_MODELS_URL);
  }
}
