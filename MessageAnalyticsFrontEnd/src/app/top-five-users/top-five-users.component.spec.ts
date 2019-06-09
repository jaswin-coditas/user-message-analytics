import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopFiveUsersComponent } from './top-five-users.component';

describe('TopFiveUsersComponent', () => {
  let component: TopFiveUsersComponent;
  let fixture: ComponentFixture<TopFiveUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopFiveUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopFiveUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
