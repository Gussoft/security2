package com.gussoft.security.controller;

import com.gussoft.security.models.Users;
import com.gussoft.security.models.dto.GenericResponse;
import com.gussoft.security.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/users/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Users>> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/users/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Users> create(
            @RequestBody Users request) {
        return ResponseEntity.ok(service.save(request));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<GenericResponse> delete(
            @PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok(new GenericResponse(200, "OK"));
    }

}
