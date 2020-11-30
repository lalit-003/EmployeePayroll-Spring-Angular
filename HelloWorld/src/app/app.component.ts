import { Component, SimpleChanges, OnChanges, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnChanges{
  title = 'HelloWorld';
  imgURL;
  url;
  @Input() userName: string = "";
  nameError: string = "";

  ngOnInit():void{
    this.title="Modified HelloWorld";
    this.imgURL="../assets/5.jpg";
    this.url="https://www.bridgelabz.com";
  }

  onClick($event){
    console.log("Picture was clicked ",$event);
    window.open(this.url,"_blank");
  }

  ngOnChanges(changes:SimpleChanges){
    if(changes)
    console.log("ngOnChanges called");
    const nameRegex = RegExp("^[A-Z].{2,}$");
    if(nameRegex.test(this.userName)){
      this.nameError = "";
      return;
    }
    this.nameError = "Name is not of required Format";
  }
}
