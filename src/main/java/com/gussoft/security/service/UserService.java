package com.gussoft.security.service;

import com.gussoft.security.models.Users;
import java.util.List;

public interface UserService {

    List<Users> getAll();

    Users findById(Long id);

    Users save(Users obj);

    Users update(Users obj, Long id);

    void delete(Long id);

}
