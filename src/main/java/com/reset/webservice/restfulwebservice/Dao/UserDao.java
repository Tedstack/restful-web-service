package com.reset.webservice.restfulwebservice.Dao;

import com.reset.webservice.restfulwebservice.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
   User findByName(String name);

   User findById(int id);
}
