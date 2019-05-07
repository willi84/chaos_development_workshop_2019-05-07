import { async } from '@angular/core/testing';

import { RectangleComponent } from './rectangle.component';

describe('RectangleComponent', () => {
  let rectangle: RectangleComponent;

  beforeEach(async(() => {
    rectangle = new RectangleComponent(3, 4);
  }));

  it('should get the area', () => {
    expect(rectangle.area()).toEqual(12);
  });

  it('should get the perimenter', () => {
    expect(rectangle.perimeter()).toEqual(14);
  });
});
