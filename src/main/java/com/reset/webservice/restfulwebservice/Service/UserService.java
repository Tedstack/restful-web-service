package com.reset.webservice.restfulwebservice.Service;

import com.reset.webservice.restfulwebservice.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User addUser(User user);

    List<User> findAll();

    User findUserByName(String name);

    User findUserById(int id);

    void deleteUser(int id);
}
