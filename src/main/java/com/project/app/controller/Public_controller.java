package com.project.app.controller;

import com.project.app.entity.UserEntry;
import com.project.app.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class Public_controller {

    @Autowired
    private userservice user;

    @PostMapping("/create")
    public ResponseEntity<?> createuser(@RequestBody UserEntry u)
    {

        try{

            user.SaveNewUserentry(u);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
