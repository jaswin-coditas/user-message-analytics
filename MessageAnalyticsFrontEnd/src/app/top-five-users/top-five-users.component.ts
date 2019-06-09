import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/User';
import { UserResponse } from '../models/UsersResponse';

@Component({
  selector: 'app-top-five-users',
  templateUrl: './top-five-users.component.html',
  styleUrls: ['./top-five-users.component.scss']
})
export class TopFiveUsersComponent implements OnInit {
  userResponse: UserResponse;
  topFiveUsers: User[];
  constructor(private userService: UserService) {
  }
  ngOnInit() {
    this.getTopFiveUsers();
  }

  getTopFiveUsers() {
    this.userService.getTopFiveUsers().subscribe(userResponse => {
      this.userResponse = userResponse;
      console.log("top five users")
      console.log(userResponse.message)
      this.topFiveUsers = userResponse.data;
      for (var val of this.topFiveUsers ) {
        console.log("top five users")
        console.log(val.userName); // prints values: 10, 20, 30, 40
      }
    });
  }
}
