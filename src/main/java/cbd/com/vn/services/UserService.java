package cbd.com.vn.services;

import cbd.com.vn.model.Users;

public interface UserService {
    Users findByUserName(String userName);
}
