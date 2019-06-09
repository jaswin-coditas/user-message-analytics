import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TopFiveUsersComponent } from './top-five-users/top-five-users.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    TopFiveUsersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
