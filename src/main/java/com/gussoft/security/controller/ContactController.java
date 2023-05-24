package com.gussoft.security.controller;

import com.gussoft.security.models.Contact;
import com.gussoft.security.models.dto.GenericResponse;
import com.gussoft.security.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping(path ="/contact/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/contact/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Contact> create(
            @RequestBody Contact request) {
        return ResponseEntity.ok(service.save(request));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<GenericResponse> delete(
            @PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "OK"));
    }

}
