import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  @ViewChild('recipe') recipes: ElementRef;
  @ViewChild('place') places: ElementRef;
  recipeValue: any;
  placeValue: any;
  venueList = [];
  recipeList = [];
  noRecords: Boolean = false;
  isLoading = true;
  currentLat: any;
  currentLong: any;
  geolocationPosition: any;

  constructor(private _http: HttpClient) {
  }

  ngOnInit() {

    window.navigator.geolocation.getCurrentPosition(
      position => {
        this.geolocationPosition = position;
        this.currentLat = position.coords.latitude;
        this.currentLong = position.coords.longitude;
      });
  }

  getVenues() {

    this.recipeValue = this.recipes.nativeElement.value;
    this.placeValue = this.places.nativeElement.value;

    if (this.recipeValue !== null) {
      /**
       * Write code to get recipe
       */
      this._http.get('https://api.edamam.com/search?q=' + this.recipeValue + '&app_id=6b2ccc59&app_key=835422279b4e65d2d1de1fa5245061a8&from=0&to=10&calories=591-722&health=alcohol-free').subscribe((recipes: any) => {
          this.noRecords = recipes.count == 0;
          console.log(this.noRecords);
          this.recipeList = Object.keys(recipes.hits).map((rec, index) => {
            const recipe = recipes.hits[index].recipe;
            return {name: recipe.label, content: recipe.digest[0].schemaOrgTag, icon: recipe.image, add: recipe.address, url: recipe.url};
          });
        }, error => {
          this.noRecords = true;
        }
      );

    }

    if (this.placeValue != null && this.placeValue !== '' && this.recipeValue != null && this.recipeValue !== '') {
      // tslint:disable-next-line:max-line-length
      this._http.get('https://api.foursquare.com/v2/venues/search?client_id=HVNZDHZ3Y2FFR0ZSADDZBP3N30YEA1DZQYOGG35VCUCBUOT4' + '&client_secret=1QTPX3WSGSUFTO0VAGMNEYEJFPDFQO15RGJ3C5RINYJZATWH&v=20180323&limit=10&near=' + this.placeValue + '&query=' + this.recipeValue).subscribe((restaurants: any) => {
        this.venueList = Object.keys(restaurants.response.venues).map((input, index) => {
          const restaurant = restaurants.response.venues[index];
          console.log(restaurant);
          return { name: restaurant.name, location: restaurant.location };

        });
      });
    }
  }
}
