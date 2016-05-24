package com.app.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.concurrent.Immutable;
import java.util.ArrayList;

@Document(collection = "users")
@Immutable
public class User {
    @Id
    private String id;
    @Indexed
    private String ic;
    private String username;
    private String password;
    private ArrayList<UserRole> roles;

    public User() {
    }

    public User(String username, String password, ArrayList<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!ic.equals(user.ic)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return roles.equals(user.roles);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + ic.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + roles.hashCode();
        return result;
    }
}
