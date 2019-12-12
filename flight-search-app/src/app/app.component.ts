import { Component } from '@angular/core'
import { NgModule } from '@angular/core'
import { SearchService } from './search.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'flight-search-app';
  flightNumber = '';
  origin = '';
  destination = '';
  date = '';
  results = [];

  constructor(
    public searchService: SearchService) {
    
  }


  search() { 
    if((!this.flightNumber && (!this.origin || !this.destination)) || !this.date){
      alert("Please enter correct critirea");
    }
    this.searchService.search<any[]>(this.flightNumber, this.origin, this.destination, this.date).subscribe((result) => {
      this.results = result;
    }, (err) => {
      console.log(err);
    });
    console.log(event);
 }
}
