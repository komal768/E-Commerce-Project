
package com.niit.dao;

import java.util.List;

import com.niit.domain.User;


public interface UserDao {
    void save(User u);
    void delete(User u);
    List<User> list();
    void update();
        public User getUserByName(String email);

    
}
