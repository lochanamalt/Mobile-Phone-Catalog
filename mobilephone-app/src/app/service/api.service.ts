import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { MobilePhoneUser } from '../model/mobilephone-user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = 'http://localhost:8080';
  private ALL_STORE_MODELS_URL = `${this.BASE_URL}/storemobile`;

  constructor(private http: HttpClient) { }

  getAllStoreModels(): Observable<MobilePhoneUser[]>{
    return this.http.get<MobilePhoneUser[]>(this.ALL_STORE_MODELS_URL);
  }
}
