package com.gussoft.security.service;

import com.gussoft.security.models.User;
import java.util.List;

public interface UserService {

    List<User> getAll();

    User findById(Long id);

    User save(User obj);

    User update(User obj, Long id);

    void delete(Long id);

}
