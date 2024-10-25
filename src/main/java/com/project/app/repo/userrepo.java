package com.project.app.repo;


import com.project.app.entity.JournalEntry;
import com.project.app.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userrepo extends MongoRepository<UserEntry, ObjectId> {
    UserEntry findByusername(String username);
}
// controller --> service --> repo
