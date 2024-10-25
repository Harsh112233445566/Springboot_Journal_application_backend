package com.project.app.service;

import com.project.app.entity.JournalEntry;

import com.project.app.entity.UserEntry;
import com.project.app.repo.userrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userservice {

    @Autowired
    private userrepo repo;
    public static final  PasswordEncoder passwordEncoder=  new BCryptPasswordEncoder();


    public void SaveNewUserentry(UserEntry userEntry)
    {
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(List.of("USER"));
        repo.save(userEntry);
    }
    public void Saveadmin(UserEntry userEntry)
    {
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(List.of("USER","Admin"));
        repo.save(userEntry);
    }
    public void SaveUserentry(UserEntry userEntry)
    {
        repo.save(userEntry);
    }

     public List<UserEntry> getAll( )
     {
         return repo.findAll();
     }
     public Optional<UserEntry> findById(ObjectId Id){
        return repo.findById(Id);
     }
     public void deleteById(ObjectId Id)
     {
         repo.deleteById(Id);
     }
     public UserEntry findByusername(String usr)
     {
         return repo.findByusername(usr);
     }
     public void DelUserentryByName(String usr)
     {
         UserEntry u=repo.findByusername(usr);
         repo.delete(u);
     }



}
