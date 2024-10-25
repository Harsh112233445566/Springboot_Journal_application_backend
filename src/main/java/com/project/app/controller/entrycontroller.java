package com.project.app.controller;

import com.project.app.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class entrycontroller {

    private Map<ObjectId,JournalEntry> journalmap = new HashMap();
    @GetMapping("/list")
    public List<JournalEntry> getall()
    {
        return new ArrayList<>(journalmap.values());
    }
    @PostMapping
    public boolean entry(@RequestBody JournalEntry myentry)
    {
        journalmap.put(myentry.getId(),myentry);
        return true;
    }
    @GetMapping("/find/{id}")
    public JournalEntry getJournalentrybyId(@PathVariable ObjectId id)
    {
        return journalmap.get(id);
    }
    @DeleteMapping ("/remove/{id}")
    public JournalEntry removeJournalentrybyId(@PathVariable ObjectId id)
    {
        return journalmap.remove(id);
    }
    @PutMapping ("/update/{id}")
    public JournalEntry upadteJournalentrybyId(@PathVariable ObjectId id,@RequestBody JournalEntry entry)
    {
        return journalmap.put(id,entry);
    }



}
