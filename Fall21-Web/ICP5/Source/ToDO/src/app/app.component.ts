import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements  OnInit{

  // define list of items
  public items = [];
  public countDownTimes = [];
  public intervals = []
  public item = '';
  public time = new Date();
  constructor() { }

  ngOnInit(): void {
  }

  subNewItem(){
    const todoObject = {
      id: this.items.length + 1,
      name: this.item,
      expectedDate: new Date(this.time),
      completed: false,

    }
    this.getCountDown(todoObject.expectedDate, this.items.length)
    this.items.push(todoObject);
    console.log(this.items)
  }

  countDown(todo){

  }

  getCountDown(todoTime, index) {
    this.intervals[index] = setInterval(() => {
      const now = new Date().getTime();
      const distance = todoTime.getTime() - now;
      const days = Math.floor(distance / (1000 * 60 * 60 * 24));
      const hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((distance % (1000 * 60)) / 1000);
      this.countDownTimes[index]= {
        days,
        hours,
        minutes,
        seconds
      };
    }, 1000);
  }

  deleteItem(index) {
    this.items.splice(index,1)
    this.countDownTimes.splice(index,1)
    clearInterval(this.intervals[index]);
  }

  completeItem(index) {
    const item = this.items[index];
    item['completed'] = !item['completed'];
    this.items[index] = item;
    clearInterval(this.intervals[index]);
  }
}
