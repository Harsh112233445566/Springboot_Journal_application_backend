package com.project.app.repo;


import com.project.app.entity.JournalEntry;
import com.project.app.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface entryrepo extends MongoRepository<JournalEntry, ObjectId> {


}
// controller --> service --> repo
