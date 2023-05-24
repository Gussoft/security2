package com.gussoft.security.service;

import com.gussoft.security.models.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    Contact findById(Long id);

    Contact save(Contact obj);

    Contact update(Contact obj, Long id);

    void delete(Long id);

}
