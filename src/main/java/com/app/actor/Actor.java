package com.app.actor;

import java.util.Date;

@Entity
@Table(name = "Actors")
public class Actor {

    @Id
    @GenaratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public Actor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Actor(Long id, String name, Date dateOfBirth) {

        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
