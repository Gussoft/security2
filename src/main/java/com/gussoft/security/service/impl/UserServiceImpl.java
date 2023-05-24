package com.gussoft.security.service.impl;

import com.gussoft.security.models.User;
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
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User save(User obj) {
        return repository.save(obj);
    }

    @Override
    public User update(User obj, Long id) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
