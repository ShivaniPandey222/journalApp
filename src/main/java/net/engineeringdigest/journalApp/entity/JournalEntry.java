package net.engineeringdigest.journalApp.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@Data
public class JournalEntry {
    public void setId(ObjectId id) {
        this.id = id;
    }

    @Id
    private ObjectId id;

    @NonNull
    private String title;
    private String content;

    private LocalDateTime date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public  void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Object getId() {
        return id;
    }
}
