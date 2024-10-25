package com.project.app.controller;

import com.project.app.entity.JournalEntry;
import com.project.app.entity.UserEntry;
import com.project.app.service.entryservice;
import com.project.app.service.userservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/_journal")
public class entrycontroller2 {

    @Autowired
    private entryservice entry;
    @Autowired
    private userservice user;
    @GetMapping("/list")
    public ResponseEntity<?> getalluserentries()
    {
        Authentication a= SecurityContextHolder.getContext().getAuthentication();
        String usr=a.getName();
        UserEntry newuser=user.findByusername(usr);
        List<JournalEntry> list=newuser.getEntries();
        if(list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @PostMapping("/create_entry")
    public  ResponseEntity<?>  entry(@RequestBody JournalEntry myentry)
    {
            Authentication a=SecurityContextHolder.getContext().getAuthentication();
            String usr=a.getName();
            entry.SaveJournalentry(myentry,usr);
            return new ResponseEntity<>(myentry,HttpStatus.CREATED);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getJournalentrybyId(@PathVariable ObjectId id)
    {
        Optional<JournalEntry> obj = entry.findById(id);
        return obj.map(journalEntry -> new ResponseEntity<>(journalEntry, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping ("/remove/{id}")
    public ResponseEntity<?> removeJournalentrybyId(@PathVariable ObjectId id)
    {
        Authentication a=SecurityContextHolder.getContext().getAuthentication();
        String usr=a.getName();
        boolean rmv = entry.deleteById(id,usr);
        if(rmv)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<?>  upadteJournalentrybyId(@PathVariable ObjectId id,@RequestBody JournalEntry myentry)
    {
        Authentication a=SecurityContextHolder.getContext().getAuthentication();
        String usr=a.getName();
        JournalEntry old = entry.findById(id).orElse(null);
        if(old!=null) {
            old.setTitle(myentry.getTitle()!=null && !myentry.getTitle().equals("") ? myentry.getTitle() : old.getTitle());
            old.setContent(myentry.getContent()!=null && !myentry.getContent().equals("") ? myentry.getContent() : old.getContent());
            entry.SaveJournalentry(old);
            return new ResponseEntity<>(myentry,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }



}
