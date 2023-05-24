package com.gussoft.security.service.impl;

import com.gussoft.security.models.Users;
import com.gussoft.security.repository.UserRepository;
import com.gussoft.security.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<Users> getAll() {
        return repository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Users save(Users obj) {
        return repository.save(obj);
    }

    @Override
    public Users update(Users obj, Long id) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
