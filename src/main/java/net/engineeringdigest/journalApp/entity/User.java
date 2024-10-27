package net.engineeringdigest.journalApp.entity;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data
@Builder
public class User {
    @Id
    private ObjectId id;

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @NonNull
    private String password;

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public User(ObjectId id) {
        this.id = id;
    }

    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();

    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }
    public User(@NonNull String userName, @NonNull String password, List<String> roles ) {
        this.userName = userName;
        this.password = password;
        this.roles = roles != null ? roles: new ArrayList<>();
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
