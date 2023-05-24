package com.gussoft.security.service.impl;

import com.gussoft.security.models.Contact;
import com.gussoft.security.repository.ContactRepository;
import com.gussoft.security.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contact save(Contact obj) {
        return repository.save(obj);
    }

    @Override
    public Contact update(Contact obj, Long id) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
