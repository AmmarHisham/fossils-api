package com.fossils.fossils.service;

import com.fossils.fossils.entity.User;

public interface UserService {
    void save(User user);

    User findByUsernameAndPassword(String username, String password);
    
}