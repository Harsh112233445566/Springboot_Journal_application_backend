package com.project.app.controller;

import com.project.app.entity.UserEntry;
import com.project.app.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin {

    @Autowired
    private userservice service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        List<UserEntry> list=service.getAll();
        if(list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createadmin(@RequestBody UserEntry u)
    {

        try{
            service.Saveadmin(u);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
