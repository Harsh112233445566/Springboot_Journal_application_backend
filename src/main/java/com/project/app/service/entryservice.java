package com.project.app.service;

import com.project.app.entity.JournalEntry;
import com.project.app.entity.UserEntry;
import com.project.app.repo.entryrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class entryservice {

    @Autowired
    private entryrepo repo;
    @Autowired
    private userservice user;

    @Transactional
    public void SaveJournalentry(JournalEntry journalEntry, String newuser)
    {
        UserEntry usr = user.findByusername(newuser);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry e = repo.save(journalEntry);
        usr.getEntries().add(e);
        user.SaveUserentry(usr);

    }
    public void SaveJournalentry(JournalEntry journalEntry)
    {
        JournalEntry e = repo.save(journalEntry);
    }
     public List<JournalEntry> getAll( )
     {
         return repo.findAll();
     }
     public Optional<JournalEntry> findById(ObjectId Id){
        return repo.findById(Id);
     }
     public boolean deleteById(ObjectId Id, String userdel)
     {
         boolean rmv = false;
         try{
             UserEntry usr = user.findByusername(userdel);
             rmv = usr.getEntries().removeIf(x->x.getId().equals(Id));
             if(rmv){
                 user.SaveUserentry(usr);
                 repo.deleteById(Id);
             }
         }
         catch (Exception e)
         {
             System.out.println(e);
             throw new RuntimeException("Error occured deleting .",e);
         }
         return rmv;

     }



}
