import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayArticlesAsCardComponent } from './display-articles-as-card.component';

describe('DisplayArticlesAsCardComponent', () => {
  let component: DisplayArticlesAsCardComponent;
  let fixture: ComponentFixture<DisplayArticlesAsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayArticlesAsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayArticlesAsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
