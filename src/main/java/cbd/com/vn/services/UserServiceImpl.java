package cbd.com.vn.services;

import cbd.com.vn.model.Users;
import cbd.com.vn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public Users findByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
