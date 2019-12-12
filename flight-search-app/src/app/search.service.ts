import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'http://localhost:8080/search';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  public search<T>(flightNo: string, org: string, dest: string, dt: string): Observable<T> {
    const toAdd = JSON.stringify({ flightNumber: flightNo, origin: org, destination: dest, date: dt });
  
    return this.http.post<T>(endpoint, toAdd, httpOptions);
  }

}
