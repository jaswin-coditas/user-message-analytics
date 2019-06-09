import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { sprintf } from 'sprintf-js';
import { UserResponse } from '../models/UsersResponse';
import { APIEndPoints } from 'src/ApiEndPoints';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getTopFiveUsers() {
    return this.httpClient.get<UserResponse>
      (sprintf(APIEndPoints.GET_TOP_FIVE_USERS));
  }
}
