import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-rectangle',
  templateUrl: './rectangle.component.html',
  styleUrls: ['./rectangle.component.css']
})
export class RectangleComponent implements OnInit {
  private width: number;
  private height: number;

  constructor(width, height) {
    if (width <= 0.0 || height <= 0.0) {
      throw new Error('Dimensions must be > 0');
    }
    this.width = width;
    this.height = height;

  }
  ngOnInit() {
  }
  public area() {
    return this.width * this.height;
  }
  public perimeter() {
    return 2 * (this.width + this.height);
  }

}
