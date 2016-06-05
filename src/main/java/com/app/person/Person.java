package com.app.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "people")
public class Person {
    @Id
    private String id;
    @Indexed
    private String ic;
    private String name;
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    private String description;
    private List<String> imagesObjectIds;
    private Map<String, JobTitle> roles;


    public Person() {
    }

    public Person(String title, Date dateOfBirth, String description) {
        this.name = title;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, JobTitle> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, JobTitle> roles) {
        this.roles = roles;
    }

    public List<String> getImagesObjectIds() {
        return imagesObjectIds;
    }

    public void setImagesObjectIds(List<String> imagesObjectIds) {
        this.imagesObjectIds = imagesObjectIds;
    }
}
