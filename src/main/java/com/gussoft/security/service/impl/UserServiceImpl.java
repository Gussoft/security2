package com.gussoft.security.service.impl;

import com.gussoft.security.models.Users;
import com.gussoft.security.repository.UserRepository;
import com.gussoft.security.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
        obj.setPassword(encoder.encode(obj.getPassword()));
        return repository.save(obj);
    }

    @Override
    public Users update(Users obj, Long id) {
        obj.setPassword(encoder.encode(obj.getPassword()));
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
