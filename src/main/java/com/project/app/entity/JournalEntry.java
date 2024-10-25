package com.project.app.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "entries")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data
@NoArgsConstructor
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime Date;


}
