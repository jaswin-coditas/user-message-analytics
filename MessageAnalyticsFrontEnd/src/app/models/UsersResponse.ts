import { User } from './User';

export class UserResponse {
    success: boolean;
    message: string;
    data: User[];
    errorCode: string;
    httpStatus: string;s
}