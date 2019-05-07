import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RectangleComponent } from './rectangle/rectangle.component';

@NgModule({
  declarations: [
    RectangleComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [RectangleComponent]
})
export class AppModule { }
