package com.project.app.controller;

import com.project.app.entity.JournalEntry;
import com.project.app.entity.UserEntry;
import com.project.app.service.entryservice;
import com.project.app.service.userservice;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/_user")
public class Usercontroller2 {

    @Autowired
    private userservice user;

    @GetMapping
    public  ResponseEntity<?> getAll()
    {
        List<UserEntry> list=user.getAll();
        if(list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(list,HttpStatus.OK) ;
    }



    @PutMapping
    public ResponseEntity<?>  upadteuser(@RequestBody @NotNull UserEntry u)
    {
         Authentication a=SecurityContextHolder.getContext().getAuthentication();
         String usr=a.getName();
         UserEntry usrentry=user.findByusername(usr);
            usrentry.setUsername(u.getUsername());
            usrentry.setPassword(u.getPassword());
            user.SaveUserentry(usrentry);
            return new ResponseEntity<>(usrentry,HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<?>  deleteuser()
    {
        Authentication a=SecurityContextHolder.getContext().getAuthentication();
        String usr=a.getName();
        user.DelUserentryByName(usr);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
